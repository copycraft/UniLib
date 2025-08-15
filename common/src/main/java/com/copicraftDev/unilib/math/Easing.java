package com.copicraftDev.unilib.math;

public class Easing {
    public static float linear(float t) { return t; }
    public static float easeInQuad(float t) { return t * t; }
    public static float easeOutQuad(float t) { return t * (2 - t); }
    public static float easeInOutQuad(float t) { return t < 0.5 ? 2 * t * t : -1 + (4 - 2 * t) * t; }

    public static float easeInCubic(float t) { return t * t * t; }
    public static float easeOutCubic(float t) { return (--t) * t * t + 1; }
    public static float easeInOutCubic(float t) { return t < 0.5 ? 4 * t * t * t : (t - 1) * (2 * t - 2) * (2 * t - 2) + 1; }

    public static float easeInSine(float t) { return 1 - (float) Math.cos(t * Math.PI / 2); }
    public static float easeOutSine(float t) { return (float) Math.sin(t * Math.PI / 2); }
    public static float easeInOutSine(float t) { return -(float) (Math.cos(Math.PI * t) - 1) / 2; }
}
