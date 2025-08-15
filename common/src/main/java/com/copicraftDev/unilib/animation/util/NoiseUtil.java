package com.copicraftDev.unilib.animation.util;

import java.util.Random;

public class NoiseUtil {

    private static final Random RANDOM = new Random();

    public static float noise() {
        return RANDOM.nextFloat() * 2f - 1f;
    }

    public static float noise(float scale) {
        return noise() * scale;
    }
}
