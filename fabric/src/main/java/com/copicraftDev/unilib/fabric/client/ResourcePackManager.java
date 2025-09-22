package com.copicraftDev.unilib.fabric.client;

import com.copicraftDev.unilib.fabric.client.model.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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
        System.out.println("[Unilib] Writing block model JSON: " + modelPath);
        Model model = modelType.buildModelFor(modId, name);
        Files.writeString(modelPath, model.toJsonString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        String blockstate = stateType.buildBlockstateJson(modId, name);
        Path statePath = packRoot.resolve("assets/" + modId + "/blockstates/" + name + ".json");
        Files.writeString(statePath, blockstate, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        Path itemModelPath = packRoot.resolve("assets/" + modId + "/models/item/" + name + ".json");
        String itemJson = ResourcepackItemModelType.BLOCK_PARENT.buildItemModelJson(modId, name);
        Files.writeString(itemModelPath, itemJson, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void generateItem(String modId, String name, ResourcepackItemModelType itemModelType) throws IOException {
        ensureInit(modId);
        Path itemModelPath = packRoot.resolve("assets/" + modId + "/models/item/" + name + ".json");
        String json = itemModelType.buildItemModelJson(modId, name);
        Files.writeString(itemModelPath, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // ---------------- NEW METHODS FOR CUSTOM MODELS ----------------

    public static void generateBlockFromModel(String modId, String name, Model model, ResourcepackBlockstates stateType) throws IOException {
        ensureInit(modId);

        // Write block model JSON
        Path modelPath = packRoot.resolve("assets/" + modId + "/models/block/" + name + ".json");
        Files.writeString(modelPath, model.toJsonString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // Write blockstate JSON
        Path statePath = packRoot.resolve("assets/" + modId + "/blockstates/" + name + ".json");
        String blockstate = stateType.buildBlockstateJson(modId, name);
        Files.writeString(statePath, blockstate, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // Write block item model JSON
        Path itemModelPath = packRoot.resolve("assets/" + modId + "/models/item/" + name + ".json");
        String itemJson = ResourcepackItemModelType.BLOCK_PARENT.buildItemModelJson(modId, name);
        Files.writeString(itemModelPath, itemJson, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("[Unilib] Generated block from custom model: " + name);
    }

    public static void generateItemFromModel(String modId, String name, Model model) throws IOException {
        ensureInit(modId);

        Path itemModelPath = packRoot.resolve("assets/" + modId + "/models/item/" + name + ".json");
        Files.writeString(itemModelPath, model.toJsonString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("[Unilib] Generated item from custom model: " + name);
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
