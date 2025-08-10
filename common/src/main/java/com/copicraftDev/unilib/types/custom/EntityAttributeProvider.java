package com.copicraftDev.unilib.types.custom;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public interface EntityAttributeProvider {
    AttributeSupplier.Builder createAttributes();
}
