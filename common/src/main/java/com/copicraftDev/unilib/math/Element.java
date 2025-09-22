package com.copicraftDev.unilib.math;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Element {
    private final float[] from = new float[3];
    private final float[] to = new float[3];
    private final Map<String, Face> faces = new LinkedHashMap<>();

    public Element(float[] from, float[] to) {
        System.arraycopy(from, 0, this.from, 0, 3);
        System.arraycopy(to, 0, this.to, 0, 3);
    }

    /** Assign a texture to a single face */
    public void putFace(String faceName, Face face) {
        faces.put(faceName, face);
    }

    /** Assign the same texture to all six faces */
    public void putAllFacesTexture(String texturePath) {
        putFace("north", new Face(texturePath));
        putFace("south", new Face(texturePath));
        putFace("west", new Face(texturePath));
        putFace("east", new Face(texturePath));
        putFace("up", new Face(texturePath));
        putFace("down", new Face(texturePath));
    }

    public float[] getFrom() { return from; }
    public float[] getTo() { return to; }
    public Map<String, Face> getFaces() { return faces; }

    /** Optional: JSON serialization for resource pack generation */
    public String toJsonString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("{\n");
        sb.append(indent).append("  \"from\": [").append(trimFloat(from[0])).append(", ")
                .append(trimFloat(from[1])).append(", ").append(trimFloat(from[2])).append("],\n");
        sb.append(indent).append("  \"to\": [").append(trimFloat(to[0])).append(", ")
                .append(trimFloat(to[1])).append(", ").append(trimFloat(to[2])).append("],\n");
        sb.append(indent).append("  \"faces\": {\n");
        int i = 0;
        for (Map.Entry<String, Face> e : faces.entrySet()) {
            sb.append(indent).append("    \"").append(e.getKey()).append("\": ").append(e.getValue().toJsonString(indent + "    "));
            if (++i < faces.size()) sb.append(",");
            sb.append("\n");
        }
        sb.append(indent).append("  }\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

    private static String trimFloat(float v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return Float.toString(v);
    }

    /** Represents a single face of an element with texture, rotation, and UV */

}
