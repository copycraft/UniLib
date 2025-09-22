package com.copicraftDev.unilib.fabric;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SecretStairBlock extends Block {

    public SecretStairBlock(Properties properties) {
        super(properties);
    }

    // Called when player right-clicks the block
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) { // Only log on server
            System.out.println("[SecretStairBlock] Player " + player.getName().getString() + " right-clicked block at " + pos + "!");
            player.sendSystemMessage(Component.literal("You clicked the secret stair block!"));
        }

        return InteractionResult.SUCCESS;
    }
}
