package com.copicraftDev.unilib.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RuntimeResourcePack implements PackResources {
    private final Map<String, String> resources = new HashMap<>();
    private final String namespace;

    public RuntimeResourcePack(String namespace) {
        this.namespace = namespace;
    }

    public void addJson(String path, String json) {
        resources.put(namespace + "/" + path, json);
    }

    @Override
    public @Nullable IoSupplier<InputStream> getRootResource(String... strings) {
        return null;
    }

    @Override
    public IoSupplier<InputStream> getResource(PackType type, ResourceLocation id) {
        if (type == PackType.CLIENT_RESOURCES) {
            String key = id.getNamespace() + "/" + id.getPath();
            if (resources.containsKey(key)) {
                byte[] data = resources.get(key).getBytes(StandardCharsets.UTF_8);
                return () -> new ByteArrayInputStream(data);
            }
        }
        return null;
    }

    @Override
    public void listResources(PackType packType, String string, String string2, ResourceOutput resourceOutput) {

    }

    @Override
    public Set<String> getNamespaces(PackType type) {
        return type == PackType.CLIENT_RESOURCES ? Set.of(namespace) : Collections.emptySet();
    }

    @Override
    public @Nullable <T> T getMetadataSection(MetadataSectionSerializer<T> metadataSectionSerializer) throws IOException {
        return null;
    }

    @Override
    public PackLocationInfo location() {
        return null;
    }

    @Override
    public void close() {}
}
