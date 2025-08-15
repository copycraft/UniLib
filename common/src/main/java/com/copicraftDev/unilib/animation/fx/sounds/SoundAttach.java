package com.copicraftDev.unilib.animation.fx.sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class SoundAttach {

    private final Level level;
    private final SoundEvent sound;

    private Entity entityTarget;
    private BlockPos blockTarget;
    private double offsetX, offsetY, offsetZ;
    private float volume = 1f;
    private float pitch = 1f;

    public SoundAttach(Level level, SoundEvent sound) {
        this.level = level;
        this.sound = sound;
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

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void play() {
        if (entityTarget != null) {
            level.playSound(null,
                    entityTarget.blockPosition(),
                    sound,
                    SoundSource.PLAYERS,
                    volume,
                    pitch);
        } else if (blockTarget != null) {
            level.playSound(null,
                    blockTarget.getX(),
                    blockTarget.getY(),
                    blockTarget.getZ(),
                    sound,
                    SoundSource.PLAYERS,
                    volume,
                    pitch);
        }
    }
}
