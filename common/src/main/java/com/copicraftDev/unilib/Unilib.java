package com.copicraftDev.unilib;

import com.copicraftDev.unilib.types.Type;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Unilib {
    private static Unilib INSTANCE;

    private final String modId;

    public static final String UNI_LIB_MOD_ID = "unilib";

    private final DeferredRegister<Block> blocks;
    private final DeferredRegister<Item> items;
    private final DeferredRegister<EntityType<?>> entities;
    private final DeferredRegister<BlockEntityType<?>> blockEntities;

    public Unilib(String modId) {
        this.modId = modId;

        blocks = DeferredRegister.create(modId, Registries.BLOCK);
        items = DeferredRegister.create(modId, Registries.ITEM);
        entities = DeferredRegister.create(modId, Registries.ENTITY_TYPE);
        blockEntities = DeferredRegister.create(modId, Registries.BLOCK_ENTITY_TYPE);

        INSTANCE = this; // set singleton instance
    }

    public static Unilib getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Unilib instance not initialized yet!");
        }
        return INSTANCE;
    }

    public void init() {
        blocks.register();
        items.register();
        entities.register();
        blockEntities.register();

        System.out.println("[Unilib] Initialized mod with ID: " + modId);
    }

    public String getModId() {
        return modId;
    }

    public DeferredRegister<Block> getBlocks() {
        return blocks;
    }

    public DeferredRegister<Item> getItems() {
        return items;
    }

    public DeferredRegister<BlockEntityType<?>> getBlockEntities() {
        return blockEntities;
    }

    public DeferredRegister<EntityType<?>> getEntities() {
        return entities;
    }

    public void add(Type type) {
        System.out.println("[Unilib] Adding: " + type.name());
        type.action().register(type.name());
    }
}
