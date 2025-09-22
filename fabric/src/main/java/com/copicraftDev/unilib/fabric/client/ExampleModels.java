package com.copicraftDev.unilib.fabric.client;

import com.copicraftDev.unilib.fabric.client.model.Model;

public class ExampleModels {
    public static Model createStairModel() {
        Model model = new Model();

        Model.Element step1 = new Model.Element(new float[]{0,0,0}, new float[]{16,8,16});
        step1.putAllFacesTexture("block/stone");
        model.addElement(step1);

        Model.Element step2 = new Model.Element(new float[]{0,8,0}, new float[]{16,16,8});
        step2.putAllFacesTexture("block/stone");
        model.addElement(step2);

        return model;
    }
}
