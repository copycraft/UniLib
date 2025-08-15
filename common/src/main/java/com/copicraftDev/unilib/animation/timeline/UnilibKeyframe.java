package com.copicraftDev.unilib.animation.timeline;

import com.copicraftDev.unilib.animation.util.UnilibInterp;

/**
 * Represents a single keyframe in a timeline.
 */
public class UnilibKeyframe {

    private final float time;   // seconds
    private final float value;  // value at this keyframe
    private final EasingFunction easing;

    public interface EasingFunction {
        float apply(float t);
    }

    public UnilibKeyframe(float time, float value, EasingFunction easing) {
        this.time = time;
        this.value = value;
        this.easing = easing;
    }

    public float getTime() {
        return time;
    }

    public float getValue() {
        return value;
    }

    public EasingFunction getEasing() {
        return easing;
    }

    /** Convenience linear keyframe */
    public static UnilibKeyframe linear(float time, float value) {
        return new UnilibKeyframe(time, value, t -> t);
    }
}
