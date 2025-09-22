package com.copicraftDev.unilib.fabric;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.fabric.client.*;
import com.copicraftDev.unilib.types.UnilibTypes;
import com.copicraftDev.unilib.types.custom.examples.GreetPlayerEvent;
import net.fabricmc.api.ModInitializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class UnilibFabric implements ModInitializer {

    private static Unilib unilib;

    @Override
    public void onInitialize() {
        UnilibClientHooks.init(UnilibFabricClient.MOD_ID); //you dont need this
        unilib = new Unilib("unilib");

        unilib.init();
        unilib.add(UnilibTypes.BLOCK("secretname"));
        unilib.add(UnilibTypes.ITEM("secretitem", SecretItemClass.class));
        unilib.add(UnilibTypes.BLOCK(
                "stair_block",
                SecretStairBlock.class,
                id -> ExampleModels.createStairModel() // returns UnilibModel directly
        ));

    }

    public static Unilib getInstance() {
        return unilib;
    }
}
