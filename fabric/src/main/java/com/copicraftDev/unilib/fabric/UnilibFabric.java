package com.copicraftDev.unilib.fabric;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.types.UnilibTypes;
import net.fabricmc.api.ModInitializer;

public final class UnilibFabric implements ModInitializer {

    private static Unilib unilib;

    @Override
    public void onInitialize() {
        unilib = new Unilib("unilib");

        unilib.init();
        unilib.add(UnilibTypes.BLOCK("test"));
        unilib.add(UnilibTypes.ITEM("testitem"));
        unilib.add(UnilibTypes.BLOCK("Wheel Of Doom")
                .withModel(UnilibBlockModels.CUBE_COLUMN)
                .withBlockstate(UnilibBlockStates.DIRECTIONAL)
        );
    }
    public static Unilib getInstance() {
        return unilib;
    }
}
