package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.timeline.UnilibTimeline;

import java.util.List;

public interface TimelineHolder {
    List<UnilibTimeline> getTimelines();

    default void tickTimelines(AnimationContext context, float delta) {
        for (UnilibTimeline timeline : getTimelines()) {
            timeline.sample(delta); // or integrate time tracking
        }
    }
}
