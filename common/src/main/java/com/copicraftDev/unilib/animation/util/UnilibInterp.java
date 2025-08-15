package com.copicraftDev.unilib.animation.util;

import net.minecraft.world.phys.Vec3;

public class UnilibInterp {
    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static Vec3 lerp(Vec3 a, Vec3 b, float t) {
        double x = a.x + (b.x - a.x) * t;
        double y = a.y + (b.y - a.y) * t;
        double z = a.z + (b.z - a.z) * t;
        return new Vec3(x, y, z);
    }
}
