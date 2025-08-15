package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.item.ItemStack;

public class UnilibItemTarget extends UnilibAnimationTarget {

    private final ItemStack itemStack;

    public UnilibItemTarget(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public void apply(AnimationContext context, float delta) {
        // Example: item transform or FX logic
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
