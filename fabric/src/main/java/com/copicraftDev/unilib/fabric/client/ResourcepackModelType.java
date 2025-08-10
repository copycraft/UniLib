package com.copicraftDev.unilib.fabric.client;

public enum ResourcepackModelType {
    FULL {
        @Override
        public Model buildModelFor(String modId, String name) {
            Model m = new Model();
            m.setParent("block/cube_all");
            m.putTexture("all", modId + ":block/" + name);
            return m;
        }
    },
    CUBE_COLUMN {
        @Override
        public Model buildModelFor(String modId, String name) {
            Model m = new Model();
            m.setParent("block/cube_column");
            m.putTexture("end", modId + ":block/" + name + "_end");
            m.putTexture("side", modId + ":block/" + name + "_side");
            return m;
        }
    },
    CUSTOM_VOXEL_EXAMPLE {
        @Override
        public Model buildModelFor(String modId, String name) {
            Model m = new Model();
            Model.Element base = new Model.Element(new float[]{0, 0, 0}, new float[]{16, 4, 16});
            base.putAllFacesTexture(modId + ":block/" + name + "_base");
            m.addElement(base);

            Model.Element pillar = new Model.Element(new float[]{6, 4, 6}, new float[]{10, 16, 10});
            pillar.putAllFacesTexture(modId + ":block/" + name + "_pillar");
            m.addElement(pillar);
            return m;
        }
    };

    public abstract Model buildModelFor(String modId, String name);
}
