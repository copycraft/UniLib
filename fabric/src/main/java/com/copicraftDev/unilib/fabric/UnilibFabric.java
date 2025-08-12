package com.copicraftDev.unilib.fabric;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.fabric.client.UnilibClientHooks;
import com.copicraftDev.unilib.fabric.client.UnilibFabricClient;
import com.copicraftDev.unilib.types.UnilibTypes;
import net.fabricmc.api.ModInitializer;

public final class UnilibFabric implements ModInitializer {

    private static Unilib unilib;

    @Override
    public void onInitialize() {
        UnilibClientHooks.init(UnilibFabricClient.MOD_ID);
        unilib = new Unilib("unilib");

        unilib.init();
        unilib.add(UnilibTypes.BLOCK("secretname"));
        unilib.add(UnilibTypes.ITEM("secretitem"));
        unilib.add(UnilibTypes.NETWORK_OUTBOUND("a"));
        unilib.add(UnilibTypes.NETWORK_INBOUND("a"));
    }

    public static Unilib getInstance() {
        return unilib;
    }
}
