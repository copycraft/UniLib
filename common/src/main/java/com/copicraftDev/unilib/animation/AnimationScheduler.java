package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimationScheduler {

    private final List<UnilibAnimation> runningAnimations = new ArrayList<>();

    /** Add a running animation */
    public void addAnimation(UnilibAnimation anim) {
        if (!runningAnimations.contains(anim)) runningAnimations.add(anim);
    }

    /** Remove a running animation */
    public void removeAnimation(UnilibAnimation anim) {
        runningAnimations.remove(anim);
    }

    /** Tick all animations, automatically removing done ones */
    public void tick(AnimationContext context, float delta) {
        Iterator<UnilibAnimation> it = runningAnimations.iterator();
        while (it.hasNext()) {
            UnilibAnimation anim = it.next();
            anim.tick(context, delta);

            // Optional: if the animation has timelines, tick them here
            if (anim instanceof TimelineHolder) {
                ((TimelineHolder) anim).tickTimelines(context, delta);
            }

            if (anim.isDone()) it.remove();
        }
    }

    /** Clear all running animations */
    public void clear() {
        runningAnimations.clear();
    }
}
