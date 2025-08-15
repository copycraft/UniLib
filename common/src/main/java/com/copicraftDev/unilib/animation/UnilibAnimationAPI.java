package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;

/**
 * Public Unilib animation API.
 */
public class UnilibAnimationAPI {

    private static final UnilibAnimationAPI INSTANCE = new UnilibAnimationAPI();

    private final UnilibAnimationManager manager = new UnilibAnimationManager();

    private UnilibAnimationAPI() {}

    public static UnilibAnimationAPI getInstance() {
        return INSTANCE;
    }

    public void play(UnilibAnimation anim, AnimationContext context) {
        manager.playAnimation(anim, context);
    }

    public void play(String name, AnimationContext context) {
        manager.playAnimation(name, context);
    }

    public void stopAll() {
        manager.stopAll();
    }

    public void tick(AnimationContext context, float delta) {
        manager.tick(context, delta);
    }

    public UnilibAnimationRegistry getRegistry() {
        return manager.getRegistry();
    }
}
