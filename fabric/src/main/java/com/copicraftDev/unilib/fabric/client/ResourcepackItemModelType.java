package com.copicraftDev.unilib.fabric.client;

public enum ResourcepackItemModelType {
    BLOCK_PARENT {
        @Override
        public String buildItemModelJson(String modId, String name) {
            return """
                {
                  "parent": "%s:block/%s"
                }
                """.formatted(modId, name);
        }
    },

    GENERATED {
        @Override
        public String buildItemModelJson(String modId, String name) {
            return """
                {
                  "parent": "item/generated",
                  "textures": {
                    "layer0": "%s:item/%s"
                  }
                }
                """.formatted(modId, name);
        }
    };

    public abstract String buildItemModelJson(String modId, String name);
}
