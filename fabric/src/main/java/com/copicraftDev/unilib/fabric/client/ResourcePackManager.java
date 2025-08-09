package com.copicraftDev.unilib.fabric.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * High-level API for generating packs/models/blockstates at runtime.
 */
public final class ResourcePackManager {
    private static final String PACK_NAME = "UnilibGenerated";
    private static Path packRoot;

    private ResourcePackManager() {}

    public static void init(String modId) {
        packRoot = RuntimePaths.locateResourcepacksDir().resolve(PACK_NAME);
        try {
            Files.createDirectories(packRoot);
            RuntimeResourcePack.ensurePackMeta(packRoot);
            RuntimeResourcePack.ensureStructure(packRoot, modId);
        } catch (IOException e) {
            throw new RuntimeException("Failed to init resourcepack folder", e);
        }
    }

    /** ensure packRoot and directories exist (lazy init) */
    private static synchronized void ensureInit(String modId) {
        if (packRoot == null) init(modId);
        try {
            RuntimeResourcePack.ensureStructure(packRoot, modId);
        } catch (IOException e) {
            throw new RuntimeException("Failed to ensure resourcepack structure", e);
        }
    }

    public static void generateBlock(String modId, String name,
                                     ResourcepackModelType modelType,
                                     ResourcepackBlockstates stateType) throws IOException {
        ensureInit(modId);
        Path modelPath = packRoot.resolve("assets/" + modId + "/models/block/" + name + ".json");
        Model model = modelType.buildModelFor(modId, name);
        Files.writeString(modelPath, model.toJsonString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        String blockstate = stateType.buildBlockstateJson(modId, name);
        Path statePath = packRoot.resolve("assets/" + modId + "/blockstates/" + name + ".json");
        Files.writeString(statePath, blockstate, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("[Unilib] Generated block '" + name + "' at: " + packRoot.toAbsolutePath());
    }

    public static void generateItem(String modId, String name, ResourcepackItemModelType itemModelType) throws IOException {
        ensureInit(modId);
        Path itemModelPath = packRoot.resolve("assets/" + modId + "/models/item/" + name + ".json");
        String json = itemModelType.buildItemModelJson(modId, name);
        Files.writeString(itemModelPath, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("[Unilib] Generated item model for '" + name + "' (" + itemModelType + ")");
    }

    public static void registerCleanupOnExit() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                IOUtils.deleteRecursively(packRoot);
                System.out.println("[Unilib] Cleaned up generated resource pack");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    public static boolean registerBuiltinPackFromJar(String idInsideMod, net.fabricmc.fabric.api.resource.ResourcePackActivationType activationType) {
        return RuntimeResourcePack.registerBuiltinFromJar(idInsideMod, activationType);
    }
}
