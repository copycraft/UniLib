package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import com.copicraftDev.unilib.animation.timeline.UnilibTimeline;

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

    // ---------- Timeline convenience methods ----------

    /** Create a new timeline */
    public UnilibTimeline createTimeline() {
        return new UnilibTimeline();
    }

    /** Play a timeline with a target animation (wrapper) */
    public void playTimeline(UnilibTimeline timeline, UnilibAnimation targetAnim, AnimationContext context) {
        targetAnim.onStart(context);
        // You could optionally store timelines inside targetAnim and tick them automatically
        // For example:
        // targetAnim.addTimeline(timeline);
        manager.playAnimation(targetAnim, context);
    }

    /** Sample a timeline at a given time */
    public float sampleTimeline(UnilibTimeline timeline, float time) {
        return timeline.sample(time);
    }
}
