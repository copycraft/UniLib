package com.copicraftDev.unilib.types.custom.examples;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;

import org.jetbrains.annotations.Nullable;

public class ExampleBlock extends Block implements EntityBlock {

    public static final ExampleBlock INSTANCE = new ExampleBlock(Block.Properties.of());

    public ExampleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ExampleBlockEntity(pos, state);
    }
}
