package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;

public abstract class UnilibAnimationTarget {

    public abstract void apply(AnimationContext context, float delta);

    public void onStart(AnimationContext context) {}

    public void onEnd(AnimationContext context) {}
}
