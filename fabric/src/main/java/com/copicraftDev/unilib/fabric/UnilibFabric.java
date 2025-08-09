package com.copicraftDev.unilib.fabric;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.resource.TexturePackMain;
import com.copicraftDev.unilib.types.UnilibTypes;
import com.copicraftDev.unilib.types.custom.UnilibBlockEntity;
import com.copicraftDev.unilib.types.custom.examples.ExampleBlockEntity;
import com.copicraftDev.unilib.types.custom.examples.ExampleBlock;
import net.fabricmc.api.ModInitializer;

public final class UnilibFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Unilib.init("unilib");
        Unilib.add(UnilibTypes.BLOCK("test"));
        Unilib.add(UnilibTypes.ITEM("testitem"));
        Unilib.add(UnilibTypes.BLOCK("Wheel Of Doom")
                .withModel(UnilibBlockModels.CUBE_COLUMN)
                .withBlockstate(UnilibBlockStates.DIRECTIONAL)
        );
        Unilib.add(UnilibTypes.ENTITY("wasistdas"));
    }
}
