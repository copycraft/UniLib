package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;

import java.util.ArrayList;
import java.util.List;


public class UnilibAnimationManager {

    private final AnimationScheduler scheduler = new AnimationScheduler();
    private final UnilibAnimationRegistry registry = new UnilibAnimationRegistry();

    public void playAnimation(UnilibAnimation anim, AnimationContext context) {
        scheduler.addAnimation(anim);
    }

    public void playAnimation(String name, AnimationContext context) {
        UnilibAnimation anim = registry.create(name);
        scheduler.addAnimation(anim);
    }

    public void stopAll() {
        scheduler.clear();
    }

    public void tick(AnimationContext context, float delta) {
        scheduler.tick(context, delta);
    }

    public UnilibAnimationRegistry getRegistry() {
        return registry;
    }
}
