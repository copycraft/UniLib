package com.copicraftDev.unilib.animation.timeline;

import java.util.ArrayList;
import java.util.List;
import com.copicraftDev.unilib.animation.util.UnilibInterp;

/**
 * Timeline container for keyframes and markers.
 */
public class UnilibTimeline {

    private final List<UnilibKeyframe> keyframes = new ArrayList<>();
    private final List<Marker> markers = new ArrayList<>();
    private float duration = 0f;

    /** Add a keyframe */
    public void addKeyframe(UnilibKeyframe keyframe) {
        keyframes.add(keyframe);
        if (keyframe.getTime() > duration) duration = keyframe.getTime();
        keyframes.sort((a, b) -> Float.compare(a.getTime(), b.getTime()));
    }

    /** Add a marker */
    public void addMarker(Marker marker) {
        markers.add(marker);
    }

    /** Sample value at a specific time */
    public float sample(float time) {
        if (keyframes.isEmpty()) return 0f;
        if (time <= keyframes.get(0).getTime()) return keyframes.get(0).getValue();
        if (time >= keyframes.get(keyframes.size() - 1).getTime())
            return keyframes.get(keyframes.size() - 1).getValue();

        for (int i = 0; i < keyframes.size() - 1; i++) {
            UnilibKeyframe kf1 = keyframes.get(i);
            UnilibKeyframe kf2 = keyframes.get(i + 1);
            if (time >= kf1.getTime() && time <= kf2.getTime()) {
                float t = (time - kf1.getTime()) / (kf2.getTime() - kf1.getTime());
                t = kf2.getEasing().apply(t);
                return UnilibInterp.lerp(kf1.getValue(), kf2.getValue(), t);
            }
        }
        return 0f;
    }

    public float getDuration() {
        return duration;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    /** Reset timeline (optional) */
    public void reset() {}
}
