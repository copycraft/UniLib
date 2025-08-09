package com.copicraftDev.unilib.fabric.client;

import java.util.*;

/**
 * Lightweight model builder + JSON serializer (no external libs).
 */
public final class Model {
    private String parent = null;
    private final Map<String, String> textures = new LinkedHashMap<>();
    private final List<Element> elements = new ArrayList<>();

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void putTexture(String key, String value) {
        textures.put(key, value);
    }

    public void addElement(Element e) {
        elements.add(e);
    }

    public String toJsonString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        if (parent != null) {
            sb.append("  \"parent\": \"").append(escape(parent)).append("\",\n");
        }
        if (!textures.isEmpty()) {
            sb.append("  \"textures\": {\n");
            int i = 0;
            for (Map.Entry<String, String> e : textures.entrySet()) {
                sb.append("    \"").append(escape(e.getKey())).append("\": \"").append(escape(e.getValue())).append("\"");
                if (++i < textures.size()) sb.append(",");
                sb.append("\n");
            }
            sb.append("  }");
            if (!elements.isEmpty()) sb.append(",\n"); else sb.append("\n");
        }
        if (!elements.isEmpty()) {
            sb.append("  \"elements\": [\n");
            for (int i = 0; i < elements.size(); i++) {
                sb.append(elements.get(i).toJsonString("    "));
                if (i + 1 < elements.size()) sb.append(",");
                sb.append("\n");
            }
            sb.append("  ]\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static final class Element {
        private final float[] from = new float[3];
        private final float[] to = new float[3];
        private final Map<String, Face> faces = new LinkedHashMap<>();

        public Element(float[] from, float[] to) {
            System.arraycopy(from, 0, this.from, 0, 3);
            System.arraycopy(to, 0, this.to, 0, 3);
        }

        public void putFace(String faceName, Face face) {
            faces.put(faceName, face);
        }

        public void putAllFacesTexture(String texturePath) {
            putFace("north", new Face(texturePath));
            putFace("south", new Face(texturePath));
            putFace("west", new Face(texturePath));
            putFace("east", new Face(texturePath));
            putFace("up", new Face(texturePath));
            putFace("down", new Face(texturePath));
        }

        public String toJsonString(String indent) {
            StringBuilder sb = new StringBuilder();
            sb.append(indent).append("{\n");
            sb.append(indent).append("  \"from\": [").append(trimFloat(from[0])).append(", ").append(trimFloat(from[1])).append(", ").append(trimFloat(from[2])).append("],\n");
            sb.append(indent).append("  \"to\":   [").append(trimFloat(to[0])).append(", ").append(trimFloat(to[1])).append(", ").append(trimFloat(to[2])).append("],\n");
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
    }

    public static final class Face {
        private final String texture;
        private final Integer rotation;
        private final float[] uv;

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
            sb.append("{");
            sb.append("\"texture\":\"").append(escape(texture)).append("\"");
            if (rotation != null) sb.append(",\"rotation\":").append(rotation);
            if (uv != null && uv.length == 4) {
                sb.append(",\"uv\":[").append(trimFloat(uv[0])).append(",").append(trimFloat(uv[1])).append(",").append(trimFloat(uv[2])).append(",").append(trimFloat(uv[3])).append("]");
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
}
