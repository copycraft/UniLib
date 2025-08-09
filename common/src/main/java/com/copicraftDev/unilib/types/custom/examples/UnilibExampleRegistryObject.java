package com.copicraftDev.unilib.types.custom.examples;

import com.copicraftDev.unilib.Unilib;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnilibExampleRegistryObject {

    // Example Block
    public static final Block EXAMPLE_BLOCK = new Block(BlockBehaviour.Properties.of());

    // Example Item (block item for the block)
    public static final Item EXAMPLE_BLOCK_ITEM = new BlockItem(EXAMPLE_BLOCK, new Item.Properties());

    // Example EntityType (using your example entity class)
    public static final EntityType<UnilibExampleEntity> EXAMPLE_ENTITY_TYPE = EntityType.Builder
            .of(UnilibExampleEntity::new, MobCategory.CREATURE)
            .sized(0.6F, 1.8F)
            .build(ResourceLocation.fromNamespaceAndPath(Unilib.MOD_ID, "example_entity").toString());

    // Example BlockEntityType (linking to your ExampleBlockEntity and valid blocks)
    public static final BlockEntityType<ExampleBlockEntity> EXAMPLE_BLOCK_ENTITY_TYPE = BlockEntityType.Builder
            .of(ExampleBlockEntity::new, EXAMPLE_BLOCK)
            .build(null);

    // Utility method to register these examples in your mod registries
    public static void registerAll() {
        // Register block
        Unilib.BLOCKS.register("example_block", () -> EXAMPLE_BLOCK);

        // Register item
        Unilib.ITEMS.register("example_block", () -> EXAMPLE_BLOCK_ITEM);

        // Register entity
        Unilib.ENTITIES.register("example_entity", () -> EXAMPLE_ENTITY_TYPE);

        // Register block entity
        Unilib.BLOCK_ENTITIES.register("example_block_entity", () -> EXAMPLE_BLOCK_ENTITY_TYPE);
    }
}
