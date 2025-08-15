package com.copicraftDev.unilib.animation.fx.camera;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.util.NoiseUtil;

public class CameraShakeTrack extends UnilibAnimation {

    private final float intensity;
    private final float duration;
    private float elapsed = 0;

    public CameraShakeTrack(float intensity, float duration) {
        this.intensity = intensity;
        this.duration = duration;
    }

    @Override
    public void onStart(AnimationContext context) {
        elapsed = 0;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        elapsed += delta;
        if (elapsed > duration) return;

        float shakeX = NoiseUtil.noise(intensity);
        float shakeY = NoiseUtil.noise(intensity);
        float shakeZ = NoiseUtil.noise(intensity);

        context.getCamera().addOffset(shakeX, shakeY, shakeZ);
    }

    @Override
    public boolean isDone() {
        return elapsed >= duration;
    }

    @Override
    public void onEnd(AnimationContext context) {
        context.getCamera().resetOffset();
    }
}
