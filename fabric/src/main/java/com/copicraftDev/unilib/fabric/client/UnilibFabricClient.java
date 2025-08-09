package com.copicraftDev.unilib.fabric.client;

import com.copicraftDev.unilib.client.RuntimeResourcePack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public final class UnilibFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Create a runtime resource pack for "unilib"
        RuntimeResourcePack pack = new RuntimeResourcePack("unilib");

        // Add a test model to the pack
        String testModelJson = """
        {
          "parent": "block/cube_all",
          "textures": {
            "all": "unilib:block/test_block"
          }
        }
        """;
        pack.addJson("models/block/test_block.json", testModelJson);

        // Register the runtime resource pack so it's always enabled
        ResourceManagerHelper.registerBuiltinResourcePack(
                ResourceLocation.fromNamespaceAndPath("unilib", "runtime"),
                FabricLoader.getInstance().getModContainer("unilib").orElseThrow(),
                ResourcePackActivationType.ALWAYS_ENABLED
        );

        System.out.println("[Unilib/Fabric] Runtime resource pack registered");
    }
}
