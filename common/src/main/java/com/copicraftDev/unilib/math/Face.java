package com.copicraftDev.unilib.math;

public final class Face {
    private final String texture;
    private final Integer rotation; // 0, 90, 180, 270
    private final float[] uv;       // optional: [u1, v1, u2, v2]

    public Face(String texture) {
        this(texture, null, null);
    }

    public Face(String texture, Integer rotation, float[] uv) {
        this.texture = texture;
        this.rotation = rotation;
        this.uv = uv;
    }

    public String toJsonString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"texture\":\"").append(escape(texture)).append("\"");
        if (rotation != null) sb.append(",\"rotation\":").append(rotation);
        if (uv != null && uv.length == 4) {
            sb.append(",\"uv\":[").append(trimFloat(uv[0])).append(",").append(trimFloat(uv[1]))
                    .append(",").append(trimFloat(uv[2])).append(",").append(trimFloat(uv[3])).append("]");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String trimFloat(float v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return Float.toString(v);
    }
}