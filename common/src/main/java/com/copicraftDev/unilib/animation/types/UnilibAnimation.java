package com.copicraftDev.unilib.animation.types;

import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.timeline.UnilibTimeline;
import com.copicraftDev.unilib.animation.triggers.UnilibTriggers;

import java.util.ArrayList;
import java.util.List;

public abstract class UnilibAnimation {

    private boolean started = false;
    private boolean ended = false;
    private boolean done = false;

    protected float speed = 1.0f;
    protected boolean loop = false;

    private final List<UnilibTimeline> timelines = new ArrayList<>();
    private UnilibTriggers triggers;

    public void setTriggers(UnilibTriggers triggers) {
        this.triggers = triggers;
    }

    public void addTimeline(UnilibTimeline timeline) {
        timelines.add(timeline);
    }

    public void removeTimeline(UnilibTimeline timeline) {
        timelines.remove(timeline);
    }

    public List<UnilibTimeline> getTimelines() {
        return timelines;
    }

    public boolean isDone() { return done; }

    protected void markDone() { this.done = true; }

    public void onStart(AnimationContext context) {}

    public abstract void update(AnimationContext context, float delta);

    public void onEnd(AnimationContext context) {}

    public final void tick(AnimationContext context, float delta) {
        if (!started) {
            started = true;
            onStart(context);
        }

        if (!done) {
            update(context, delta * speed);

            // Tick all timelines
            for (UnilibTimeline timeline : timelines) {
                timeline.sample(delta * speed);

                // Fire timeline triggers if any
                if (triggers != null) {
                    timeline.getFiredMarkers().forEach(marker ->
                            triggers.fire(marker, timeline.getTarget())
                    );
                }
            }
        }

        if (isDone() && !ended) {
            ended = true;
            onEnd(context);

            if (loop) {
                started = false;
                ended = false;
                done = false;
                timelines.forEach(UnilibTimeline::reset);
            }
        }
    }
}
