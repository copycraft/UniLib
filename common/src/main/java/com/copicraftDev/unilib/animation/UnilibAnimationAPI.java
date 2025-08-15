package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.targets.UnilibAnimationTarget;
import com.copicraftDev.unilib.animation.timeline.UnilibTimeline;

/**
 * Public entry point for Unilib animations and timelines.
 */
public class UnilibAnimationAPI {

    private static final UnilibAnimationAPI INSTANCE = new UnilibAnimationAPI();

    private final UnilibAnimationManager manager = new UnilibAnimationManager();

    private UnilibAnimationAPI() {}

    public static UnilibAnimationAPI getInstance() {
        return INSTANCE;
    }

    // ------------------ Animation control ------------------

    /** Play an animation on a context */
    public void play(UnilibAnimation anim, AnimationContext context) {
        manager.playAnimation(anim, context);
    }

    /** Play by name (lookup from registry) */
    public void play(String name, AnimationContext context) {
        manager.playAnimation(name, context);
    }

    /** Stop all running animations */
    public void stopAll() {
        manager.stopAll();
    }

    /** Tick all running animations (per-frame or per-tick) */
    public void tick(AnimationContext context, float delta) {
        manager.tick(context, delta);
    }

    /** Get the animation registry */
    public UnilibAnimationRegistry getRegistry() {
        return manager.getRegistry();
    }

    // ------------------ Timeline helpers ------------------

    /** Create a new timeline for a given target */
    public UnilibTimeline createTimeline(UnilibAnimationTarget target) {
        return new UnilibTimeline(target);
    }

    /** Sample a timeline (tick its internal state) */
    public void sampleTimeline(UnilibTimeline timeline, float delta) {
        timeline.sample(delta);
    }

    /** Attach a timeline to an animation and play it */
    public void playTimeline(UnilibTimeline timeline, UnilibAnimation anim, AnimationContext context) {
        anim.addTimeline(timeline);
        play(anim, context);
    }
}
