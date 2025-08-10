package com.copicraftDev.unilib.fabric.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** small helper to find the player's resourcepacks folder in dev and normal environment */
public final class RuntimePaths {
    private RuntimePaths() {}

    public static Path locateResourcepacksDir() {
        // dev: working dir / resourcepacks
        Path wdRp = Path.of(System.getProperty("user.dir", "."), "resourcepacks");
        if (Files.exists(wdRp) && Files.isDirectory(wdRp)) return wdRp;

        // user home: ~/.minecraft/resourcepacks
        String userHome = System.getProperty("user.home", ".");
        Path homeRp = Path.of(userHome, ".minecraft", "resourcepacks");
        if (Files.exists(homeRp) && Files.isDirectory(homeRp)) return homeRp;

        // fallback: create working dir resourcepacks
        try {
            Files.createDirectories(wdRp);
            return wdRp;
        } catch (IOException e) {
            throw new RuntimeException("Unable to find or create resourcepacks directory", e);
        }
    }
}
