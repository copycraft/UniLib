package com.copicraftDev.unilib.fabric.client;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class UnilibClientHooks {

    private static final Logger LOGGER = LogManager.getLogger(UnilibClientHooks.class);

    private static volatile UnilibClientHooks INSTANCE;

    private final String modId;

    public UnilibClientHooks(String modId) {
        this.modId = Objects.requireNonNull(modId, "modId");
        synchronized (UnilibClientHooks.class) {
            if (INSTANCE == null) {
                INSTANCE = this;
                LOGGER.info("Initialized UnilibClientHooks for mod '{}'.", modId);
            } else if (!INSTANCE.modId.equals(modId)) {
                LOGGER.warn("Attempted to create a second UnilibClientHooks for mod '{}', existing mod='{}'.", modId, INSTANCE.modId);
            }
        }
    }

    public static void init(String modId) {
        if (INSTANCE == null) {
            synchronized (UnilibClientHooks.class) {
                if (INSTANCE == null) INSTANCE = new UnilibClientHooks(modId);
            }
        }
    }

    public static boolean isInitialized() {
        return INSTANCE != null;
    }

    public static void onBlockRegistered(String id) {
        UnilibClientHooks inst = INSTANCE;
        if (inst == null) {
            LOGGER.warn("onBlockRegistered called before UnilibClientHooks.init() - id='{}'", id);
            return;
        }
        inst.handleBlockRegisteredAsync(id);
    }

    public static void onItemRegistered(String id) {
        UnilibClientHooks inst = INSTANCE;
        if (inst == null) {
            LOGGER.warn("onItemRegistered called before UnilibClientHooks.init() - id='{}'", id);
            return;
        }
        inst.handleItemRegisteredAsync(id);
    }

    private void handleBlockRegisteredAsync(String id) {
        CompletableFuture.runAsync(() -> {
            try {
                ResourcePackManager.generateBlock(modId, id, ResourcepackModelType.FULL, ResourcepackBlockstates.SINGLE);
                ResourcePackManager.generateItem(modId, id, ResourcepackItemModelType.BLOCK_PARENT);
                LOGGER.info("Resource generation finished for block '{}'.", id);
            } catch (IOException e) {
                LOGGER.error("Failed to generate resources for block '" + id + "'", e);
            }
        });
    }

    private void handleItemRegisteredAsync(String id) {
        CompletableFuture.runAsync(() -> {
            try {
                ResourcePackManager.generateItem(modId, id, ResourcepackItemModelType.GENERATED);
                LOGGER.info("Resource generation finished for item '{}'.", id);
            } catch (IOException e) {
                LOGGER.error("Failed to generate resources for item '" + id + "'", e);
            }
        });
    }

    public static void shutdown() {
        synchronized (UnilibClientHooks.class) {
            if (INSTANCE != null) {
                LOGGER.info("Shutting down UnilibClientHooks for mod '{}'.", INSTANCE.modId);
                INSTANCE = null;
            }
        }
    }
}