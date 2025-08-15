package com.copicraftDev.unilib.animation.fx.particles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class ParticleAttach {

    private final Level level;
    private final ParticleOptions particle;

    private Entity entityTarget;
    private BlockPos blockTarget;
    private double offsetX, offsetY, offsetZ;

    public ParticleAttach(Level level, ParticleOptions particle) {
        this.level = level;
        this.particle = particle;
    }

    public void setEntityTarget(Entity entity, double offsetX, double offsetY, double offsetZ) {
        this.entityTarget = entity;
        this.blockTarget = null;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }

    public void setBlockTarget(BlockPos pos, double offsetX, double offsetY, double offsetZ) {
        this.blockTarget = pos;
        this.entityTarget = null;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }

    public void spawn() {
        if (entityTarget != null) {
            level.addParticle(particle,
                    entityTarget.getX() + offsetX,
                    entityTarget.getY() + offsetY,
                    entityTarget.getZ() + offsetZ,
                    0, 0, 0);
        } else if (blockTarget != null) {
            level.addParticle(particle,
                    blockTarget.getX() + offsetX,
                    blockTarget.getY() + offsetY,
                    blockTarget.getZ() + offsetZ,
                    0, 0, 0);
        }
    }
}
