package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;

public class UnilibAnimationManager {

    private final AnimationScheduler scheduler = new AnimationScheduler();
    private final UnilibAnimationRegistry registry = new UnilibAnimationRegistry();

    /** Play a specific animation */
    public void playAnimation(UnilibAnimation anim, AnimationContext context) {
        // Initialize any timelines inside the animation
        anim.onStart(context);
        scheduler.addAnimation(anim);
    }

    /** Play animation by name from the registry */
    public void playAnimation(String name, AnimationContext context) {
        UnilibAnimation anim = registry.create(name);
        anim.onStart(context);
        scheduler.addAnimation(anim);
    }

    /** Stop all running animations */
    public void stopAll() {
        scheduler.clear();
    }

    /** Tick all running animations */
    public void tick(AnimationContext context, float delta) {
        scheduler.tick(context, delta);
    }

    public UnilibAnimationRegistry getRegistry() {
        return registry;
    }
}
