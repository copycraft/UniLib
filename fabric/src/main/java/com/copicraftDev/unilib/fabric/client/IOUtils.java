package com.copicraftDev.unilib.fabric.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public final class IOUtils {
    private IOUtils() {}

    public static void deleteRecursively(Path path) throws IOException {
        if (path == null || Files.notExists(path)) return;
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .forEach(p -> {
                    try {
                        Files.deleteIfExists(p);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
