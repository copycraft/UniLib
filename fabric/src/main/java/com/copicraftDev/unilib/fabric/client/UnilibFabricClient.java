package com.copicraftDev.unilib.fabric.client;

import net.fabricmc.api.ClientModInitializer;

public final class UnilibFabricClient implements ClientModInitializer {
    private static final String MOD_ID = "unilib"; // replace with your mod ID

    @Override
    public void onInitializeClient() {
        // Initialize the manager and register cleanup
        ResourcePackManager.init(MOD_ID);
        ResourcePackManager.registerCleanupOnExit();

        // Example: generate a block immediately (or call this later from a command)
        try {
            ResourcePackManager.generateBlock(
                    MOD_ID,
                    "secretname",
                    ResourcepackModelType.FULL,
                    ResourcepackBlockstates.SINGLE
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
