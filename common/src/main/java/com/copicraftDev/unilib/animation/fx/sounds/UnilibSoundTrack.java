package com.copicraftDev.unilib.animation.fx.sounds;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class UnilibSoundTrack extends UnilibAnimation {

    private final SoundEvent sound;
    private final Entity target;
    private final Level level;
    private final float interval;
    private float timer = 0f;

    public UnilibSoundTrack(Level level, SoundEvent sound, Entity target, float interval) {
        this.level = level;
        this.sound = sound;
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
            playSound();
        }
    }

    private void playSound() {
        if (target != null) {
            level.playSound(null, target.blockPosition(), sound, SoundSource.PLAYERS, 1f, 1f);
        } else {
            level.playSound(null, 0, 0, 0, sound, SoundSource.PLAYERS, 1f, 1f);
        }
    }
}
