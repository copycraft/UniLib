package com.copicraftDev.unilib.fabric;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class SecretItemClass extends Item {

    public SecretItemClass(Item.Properties properties) {
        super(properties);
    }

    // Right-click action
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) { // Only log on server
            System.out.println("[SecretItemClass] Player " + player.getName().getString() + " right-clicked with this item!");
        }

        // Optional: you can also do something else, like send feedback to the player
        player.sendSystemMessage(net.minecraft.network.chat.Component.literal("You used the secret item!"));

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
