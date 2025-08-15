package com.copicraftDev.unilib.animation.timeline;

public class UnilibKeyframe {

    private final float time;
    private final Object value;  // could be Float, Vec3, etc.
    private final String marker;  // optional marker name

    public UnilibKeyframe(float time, Object value) {
        this(time, value, null);
    }

    public UnilibKeyframe(float time, Object value, String marker) {
        this.time = time;
        this.value = value;
        this.marker = marker;
    }

    public float getTime() {
        return time;
    }

    public Object getValue() {
        return value;
    }

    public String getMarker() {
        return marker;
    }
}
