package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.entity.Entity;

public class UnilibEntityTarget extends UnilibAnimationTarget {

    private final Entity entity;

    public UnilibEntityTarget(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void apply(AnimationContext context, float delta) {
        // Example: could apply position, rotation, or FX to the entity
        if (entity != null && !entity.isRemoved()) {
            // animation logic here
        }
    }

    public Entity getEntity() {
        return entity;
    }
}
