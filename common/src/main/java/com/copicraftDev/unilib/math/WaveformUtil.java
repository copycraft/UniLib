package com.copicraftDev.unilib.math;

public class WaveformUtil {
    public static float sine(float time, float amplitude) { return (float) Math.sin(time) * amplitude; }
    public static float cosine(float time, float amplitude) { return (float) Math.cos(time) * amplitude; }
    public static float triangle(float time, float amplitude) { return (float) (2 / Math.PI * Math.asin(Math.sin(time)) * amplitude); }
    public static float square(float time, float amplitude) { return Math.sin(time) >= 0 ? amplitude : -amplitude; }
    public static float sawtooth(float time, float amplitude) { return (float) ((2 * (time / (2 * Math.PI) - Math.floor(time / (2 * Math.PI) + 0.5))) * amplitude); }
}
