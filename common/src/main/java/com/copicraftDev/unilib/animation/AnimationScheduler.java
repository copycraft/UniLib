package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimationScheduler {

    private final List<UnilibAnimation> runningAnimations = new ArrayList<>();

    public void addAnimation(UnilibAnimation anim) {
        if (!runningAnimations.contains(anim)) {
            runningAnimations.add(anim);
        }
    }

    public void removeAnimation(UnilibAnimation anim) {
        runningAnimations.remove(anim);
    }

    public void tick(AnimationContext context, float delta) {
        Iterator<UnilibAnimation> it = runningAnimations.iterator();
        while (it.hasNext()) {
            UnilibAnimation anim = it.next();
            anim.tick(context, delta);
            if (anim.isDone()) {
                it.remove();
            }
        }
    }

    public void clear() {
        runningAnimations.clear();
    }
}
