package com.copicraftDev.unilib.animation.fx.camera;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.AnimationContext;

public class CameraOrbitTrack extends UnilibAnimation {

    private final float radius;
    private final float speed;
    private final float duration;
    private float elapsed = 0;

    public CameraOrbitTrack(float radius, float speed, float duration) {
        this.radius = radius;
        this.speed = speed;
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

        float angle = elapsed * speed;
        float x = (float) Math.cos(angle) * radius;
        float z = (float) Math.sin(angle) * radius;

        // Orbit around the target entity/player
        context.getCamera().setPositionOffset(x, 0, z);
        context.getCamera().lookAt(context.getTargetPosition());
    }

    @Override
    public boolean isDone() {
        return elapsed >= duration;
    }
}
