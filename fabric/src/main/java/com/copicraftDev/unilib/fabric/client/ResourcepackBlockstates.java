package com.copicraftDev.unilib.fabric.client;

public enum ResourcepackBlockstates {
    SINGLE {
        @Override
        public String buildBlockstateJson(String modId, String name) {
            return """
                {
                  "variants": {
                    "": { "model": "%s:block/%s" }
                  }
                }
                """.formatted(modId, name);
        }
    },
    ROTATION_4 {
        @Override
        public String buildBlockstateJson(String modId, String name) {
            return """
                {
                  "variants": {
                    "facing=north": { "model": "%s:block/%s" },
                    "facing=east":  { "model": "%s:block/%s" },
                    "facing=south": { "model": "%s:block/%s" },
                    "facing=west":  { "model": "%s:block/%s" }
                  }
                }
                """.formatted(modId, name, modId, name, modId, name, modId, name);
        }
    };

    public abstract String buildBlockstateJson(String modId, String name);
}
