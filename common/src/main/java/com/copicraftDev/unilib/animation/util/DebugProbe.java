package com.copicraftDev.unilib.animation.util;

public class DebugProbe {

    public static void log(String message) {
        System.out.println("[Unilib Debug] " + message);
    }

    public static void dumpTrack(String name, float[] values) {
        StringBuilder sb = new StringBuilder("[Unilib Track] " + name + ": ");
        for (float v : values) sb.append(v).append(", ");
        System.out.println(sb.toString());
    }
}
