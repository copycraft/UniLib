package com.copicraftDev.unilib.animation.fx.camera;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;

public class CameraFovTrack extends UnilibAnimation {

    private final float startFov;
    private final float endFov;
    private final float duration;
    private float elapsed = 0;

    public CameraFovTrack(float startFov, float endFov, float duration) {
        this.startFov = startFov;
        this.endFov = endFov;
        this.duration = duration;
    }

    @Override
    public void onStart(AnimationContext context) {
        elapsed = 0;
        context.getCamera().setFov(startFov);
    }

    @Override
    public void update(AnimationContext context, float delta) {
        elapsed += delta;
        float t = Math.min(elapsed / duration, 1f);

        float fov = startFov + (endFov - startFov) * t; // linear for now
        context.getCamera().setFov(fov);
    }

    @Override
    public boolean isDone() {
        return elapsed >= duration;
    }
}
