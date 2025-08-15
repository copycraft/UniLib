package com.copicraftDev.unilib.math;

import java.util.ArrayList;
import java.util.List;

public class CurveUtil {
    public static List<Float> generateQuadraticPoints(float p0, float p1, float p2, int segments) {
        List<Float> points = new ArrayList<>();
        for (int i = 0; i <= segments; i++) {
            float t = i / (float) segments;
            points.add(Bezier.quadratic(t, p0, p1, p2));
        }
        return points;
    }
}
