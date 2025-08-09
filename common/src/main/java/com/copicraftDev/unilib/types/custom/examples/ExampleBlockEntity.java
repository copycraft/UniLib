package com.copicraftDev.unilib.types.custom.examples;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;

public class ExampleBlockEntity extends BlockEntity {

    public ExampleBlockEntity(BlockPos pos, BlockState state) {
        super(UnilibExampleRegistryObject.EXAMPLE_BLOCK_ENTITY_TYPE, pos, state);
    }

    // Add your custom logic here
}
