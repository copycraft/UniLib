package com.copicraftDev.unilib.animation.fx.particles;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class UnilibParticleBurst extends UnilibAnimation {

    private final ParticleOptions particle;
    private final Entity target;
    private final Level level;
    private final int count;

    public UnilibParticleBurst(Level level, ParticleOptions particle, Entity target, int count) {
        this.level = level;
        this.particle = particle;
        this.target = target;
        this.count = count;
    }

    @Override
    public void onStart(AnimationContext context) {
        for (int i = 0; i < count; i++) {
            if (target != null) {
                level.addParticle(particle, target.getX(), target.getY() + 1, target.getZ(), 0, 0, 0);
            } else {
                level.addParticle(particle, 0, 0, 0, 0, 0, 0);
            }
        }
        markDone();
    }

    @Override
    public void update(AnimationContext context, float delta) {
    }
}
