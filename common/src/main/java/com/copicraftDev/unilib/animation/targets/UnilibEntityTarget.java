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
        if (entity != null && !entity.isRemoved()) {
            // Example: apply position/rotation/FX updates
        }
    }

    public Entity getEntity() {
        return entity;
    }
}
