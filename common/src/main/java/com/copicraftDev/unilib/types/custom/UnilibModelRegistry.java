package com.copicraftDev.unilib.types.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UnilibModelRegistry {
    private static final Map<String, Function<String, UnilibModel>> BLOCK_MODELS = new HashMap<>();
    private static final Map<String, Function<String, UnilibModel>> ITEM_MODELS = new HashMap<>();

    public static void registerBlockModel(String id, Function<String, UnilibModel> supplier) {
        BLOCK_MODELS.put(id, supplier);
    }

    public static void registerItemModel(String id, Function<String, UnilibModel> supplier) {
        ITEM_MODELS.put(id, supplier);
    }

    public static Map<String, Function<String, UnilibModel>> getBlockModels() {
        return BLOCK_MODELS;
    }

    public static Map<String, Function<String, UnilibModel>> getItemModels() {
        return ITEM_MODELS;
    }
}
