package com.copicraftDev.unilib.animation.timeline;

import com.copicraftDev.unilib.animation.targets.UnilibAnimationTarget;

import java.util.ArrayList;
import java.util.List;

public class UnilibTimeline {

    private final List<UnilibKeyframe> keyframes = new ArrayList<>();
    private UnilibAnimationTarget target;
    private float time = 0f;
    private final List<String> firedMarkers = new ArrayList<>();

    public UnilibTimeline(UnilibAnimationTarget target) {
        this.target = target;
    }

    public void addKeyframe(UnilibKeyframe keyframe) {
        keyframes.add(keyframe);
    }

    public void sample(float delta) {
        if (keyframes.isEmpty()) return;

        time += delta;
        firedMarkers.clear();

        for (int i = 0; i < keyframes.size() - 1; i++) {
            UnilibKeyframe start = keyframes.get(i);
            UnilibKeyframe end = keyframes.get(i + 1);

            if (time >= start.getTime() && time <= end.getTime()) {
                float t = (time - start.getTime()) / (end.getTime() - start.getTime());
                target.applyTween(start, end, t);
            }

            if (time >= start.getTime() && !firedMarkers.contains(start.getMarker())) {
                if (start.getMarker() != null) firedMarkers.add(start.getMarker());
            }
        }

        if (time > keyframes.get(keyframes.size() - 1).getTime()) {
            time = keyframes.get(keyframes.size() - 1).getTime();
        }
    }

    public void reset() {
        time = 0f;
    }

    public UnilibAnimationTarget getTarget() {
        return target;
    }

    public List<String> getFiredMarkers() {
        return firedMarkers;
    }
}
