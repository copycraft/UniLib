package com.copicraftDev.unilib.types.custom;

import java.util.function.Function;

public abstract class UnilibModelWrapper {
    public abstract Function<String, Object> getModelSupplier();
}
