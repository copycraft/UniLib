package com.copicraftDev.unilib.types;

import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;

public record Type(String name, UnilibTypeAction action,
                   UnilibBlockModels model,
                   UnilibBlockStates blockstate) {

    public Type(String name, UnilibTypeAction action) {
        this(name, action, UnilibBlockModels.CUBE_ALL, UnilibBlockStates.SIMPLE);
    }

    public Type withModel(UnilibBlockModels model) {
        return new Type(name, action, model, blockstate);
    }

    public Type withBlockstate(UnilibBlockStates blockstate) {
        return new Type(name, action, model, blockstate);
    }
}

