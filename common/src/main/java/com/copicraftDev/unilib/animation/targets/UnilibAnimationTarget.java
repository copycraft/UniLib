package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.timeline.UnilibKeyframe;
import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.util.UnilibInterp;

public abstract class UnilibAnimationTarget {

    public abstract void apply(AnimationContext context, float delta);

    public void onStart(AnimationContext context) {}
    public void onEnd(AnimationContext context) {}

    /** Tween between two keyframes */
    public void applyTween(UnilibKeyframe start, UnilibKeyframe end, float t) {
        Object s = start.getValue();
        Object e = end.getValue();

        if (s instanceof Float && e instanceof Float) {
            float v = UnilibInterp.lerp((Float) s, (Float) e, t);
            applyValue(v);
        }
        // add Vec3 or other types as needed
    }

    /** Override this to apply a value to the target */
    protected void applyValue(float value) {
        // default does nothing, override in concrete targets
    }
}
