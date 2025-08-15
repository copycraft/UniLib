package com.copicraftDev.unilib.animation.fx.particles;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class UnilibParticleTrack extends UnilibAnimation {

    private final ParticleOptions particle;
    private final Entity target; // optional target
    private final Level level;
    private final float interval; // seconds between particle spawns
    private float timer = 0f;

    public UnilibParticleTrack(Level level, ParticleOptions particle, Entity target, float interval) {
        this.level = level;
        this.particle = particle;
        this.target = target;
        this.interval = interval;
    }

    @Override
    public void onStart(AnimationContext context) {
        timer = 0f;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        timer += delta;
        if (timer >= interval) {
            timer = 0f;
            spawnParticle();
        }
    }

    private void spawnParticle() {
        if (target != null) {
            level.addParticle(particle, target.getX(), target.getY() + 1, target.getZ(), 0, 0, 0);
        } else {
            level.addParticle(particle, 0, 0, 0, 0, 0, 0);
        }
    }
}
