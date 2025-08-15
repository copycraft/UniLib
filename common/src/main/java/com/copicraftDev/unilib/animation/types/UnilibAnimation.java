package com.copicraftDev.unilib.animation.types;

import com.copicraftDev.unilib.animation.AnimationContext;

public abstract class UnilibAnimation {

    private boolean started = false;
    private boolean ended = false;
    private boolean done = false;

    protected float speed = 1.0f;
    protected boolean loop = false;

    public void onStart(AnimationContext context) {
        // override in subclasses
    }

    public abstract void update(AnimationContext context, float delta);

    public void onEnd(AnimationContext context) {
        // override in subclasses
    }

    public boolean isDone() {
        return done;
    }

    public final void tick(AnimationContext context, float delta) {
        if (!started) {
            started = true;
            onStart(context);
        }

        if (!done) {
            update(context, delta * speed);
        }

        if (isDone() && !ended) {
            ended = true;
            onEnd(context);

            if (loop) {
                // reset state for looping
                started = false;
                ended = false;
                done = false;
            }
        }
    }

    protected void markDone() {
        this.done = true;
    }

    public void setSpeed(float speed) { this.speed = speed; }
    public float getSpeed() { return speed; }

    public void setLoop(boolean loop) { this.loop = loop; }
    public boolean isLooping() { return loop; }
}
