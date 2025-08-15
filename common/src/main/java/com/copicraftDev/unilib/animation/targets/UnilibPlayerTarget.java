package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.entity.player.Player;

public class UnilibPlayerTarget extends UnilibEntityTarget {

    public UnilibPlayerTarget(Player player) {
        super(player);
    }

    @Override
    public void apply(AnimationContext context, float delta) {
        super.apply(context, delta);
        // extra player-specific logic here
    }
}
