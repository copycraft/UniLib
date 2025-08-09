package com.copicraftDev.unilib.fabric.client;

import java.io.IOException;

public final class UnilibClientHooks {

    private static UnilibClientHooks INSTANCE;

    private final String modId;

    public UnilibClientHooks(String modId) {
        this.modId = modId;
        INSTANCE = this; // Set the singleton instance on creation
    }

    public static void onBlockRegistered(String id) {
        if (INSTANCE != null) {
            INSTANCE.handleBlockRegistered(id);
        } else {
            System.err.println("[UnilibClientHooks] ERROR: instance not initialized!");
        }
    }

    public static void onItemRegistered(String id) {
        if (INSTANCE != null) {
            INSTANCE.handleItemRegistered(id);
        } else {
            System.err.println("[UnilibClientHooks] ERROR: instance not initialized!");
        }
    }

    // Instance methods
    private void handleBlockRegistered(String id) {
        try {
            ResourcePackManager.generateBlock(
                    modId,
                    id,
                    ResourcepackModelType.FULL,
                    ResourcepackBlockstates.SINGLE
            );
            ResourcePackManager.generateItem(modId, id, ResourcepackItemModelType.BLOCK_PARENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleItemRegistered(String id) {
        try {
            ResourcePackManager.generateItem(modId, id, ResourcepackItemModelType.GENERATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
