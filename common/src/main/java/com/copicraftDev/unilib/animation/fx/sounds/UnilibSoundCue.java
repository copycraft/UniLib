package com.copicraftDev.unilib.animation.fx.sounds;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class UnilibSoundCue extends UnilibAnimation {

    private final SoundEvent sound;
    private final Entity target;
    private final Level level;
    private final boolean played = false;

    public UnilibSoundCue(Level level, SoundEvent sound, Entity target) {
        this.level = level;
        this.sound = sound;
        this.target = target;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        if (!played) {
            if (target != null) {
                level.playSound(null, target.blockPosition(), sound, net.minecraft.sounds.SoundSource.PLAYERS, 1f, 1f);
            } else {
                level.playSound(null, 0, 0, 0, sound, net.minecraft.sounds.SoundSource.PLAYERS, 1f, 1f);
            }
            markDone();
        }
    }
}
