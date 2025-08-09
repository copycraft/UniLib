package com.copicraftDev.unilib;

import com.copicraftDev.unilib.types.Type;
import com.copicraftDev.unilib.types.UnilibTypes;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Unilib {

    public static String MOD_ID = "unilib";

    public static DeferredRegister<Block> BLOCKS;
    public static DeferredRegister<Item> ITEMS;
    public static DeferredRegister<EntityType<?>> ENTITIES;
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;

    public static void init(String modid) {
        MOD_ID = modid;

        BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
        ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
        ENTITIES = DeferredRegister.create(MOD_ID, Registries.ENTITY_TYPE);
        BLOCK_ENTITIES = DeferredRegister.create(MOD_ID, Registries.BLOCK_ENTITY_TYPE);

        BLOCKS.register();
        ITEMS.register();
        ENTITIES.register();
        BLOCK_ENTITIES.register();

        System.out.println("[Unilib] Initialized with MOD_ID: " + modid);
    }

    public static void add(Type type) {
        System.out.println("[Unilib] Adding: " + type.name());
        type.action().register(type.name());
    }

    public static String getModId() {
        return MOD_ID;
    }
}
