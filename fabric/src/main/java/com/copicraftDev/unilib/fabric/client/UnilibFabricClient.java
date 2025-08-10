package com.copicraftDev.unilib.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.core.registries.Registries;

public final class UnilibFabricClient implements ClientModInitializer {
    public static final String MOD_ID = "unilib";

    @Override
    public void onInitializeClient() {
        // keep client hooks and ResourcePackManager initialization only
        ResourcePackManager.init(MOD_ID);
        ResourcePackManager.registerCleanupOnExit();
    }
}

