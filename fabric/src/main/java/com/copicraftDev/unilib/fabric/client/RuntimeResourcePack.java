package com.copicraftDev.unilib.fabric.client;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Low-level helpers that create the directory layout and pack.mcmeta,
 * plus helper to register built-in pack from the mod JAR.
 */
public final class RuntimeResourcePack {
    private RuntimeResourcePack() {}

    public static void ensureStructure(Path packRoot, String modId) throws IOException {
        Files.createDirectories(packRoot.resolve("assets/" + modId + "/models/block"));
        Files.createDirectories(packRoot.resolve("assets/" + modId + "/models/item"));
        Files.createDirectories(packRoot.resolve("assets/" + modId + "/blockstates"));
        Files.createDirectories(packRoot.resolve("assets/" + modId + "/textures/block"));
        Files.createDirectories(packRoot.resolve("assets/" + modId + "/textures/item"));
    }

    public static void ensurePackMeta(Path packRoot) throws IOException {
        Path meta = packRoot.resolve("pack.mcmeta");
        if (Files.notExists(meta)) {
            String mcmeta = """
                {
                  "pack": {
                    "pack_format": 34,
                    "description": "Unilib runtime-generated pack"
                  }
                }
                """;
            Files.createDirectories(packRoot);
            Files.writeString(meta, mcmeta);
        }
    }

    /**
     * Register a built-in resource pack shipped inside this mod jar under /resourcepacks/<idInsideMod>/
     * The pack will appear in Options -> Resource Packs.
     *
     * NOTE: This only registers packs that are inside your mod JAR's resourcepacks/ folder.
     */
    public static boolean registerBuiltinFromJar(String idInsideMod, ResourcePackActivationType activationType) {
        FabricLoader loader = FabricLoader.getInstance();
        // assume this mod's id is the same as the mod container that contains this code
        // try to find the container that loaded this class
        ModContainer container = loader.getModContainer("unilib").orElse(null);
        if (container == null) {
            // fallback: use the first mod container (unlikely)
            container = loader.getAllMods().stream().findFirst().orElse(null);
        }
        if (container == null) {
            System.err.println("[Unilib] Couldn't find ModContainer to register builtin resource pack");
            return false;
        }

        try {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(container.getMetadata().getId(), idInsideMod);
            return ResourceManagerHelper.registerBuiltinResourcePack(id, container, activationType);
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
    }
}
