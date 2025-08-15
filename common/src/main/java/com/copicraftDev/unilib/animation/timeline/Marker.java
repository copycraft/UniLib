package com.copicraftDev.unilib.animation.timeline;

/**
 * Named point in the timeline for triggers (FX, sounds, events).
 */
public class Marker {

    private final String name;
    private final float time;

    public Marker(String name, float time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public float getTime() {
        return time;
    }
}
