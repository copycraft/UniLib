package com.copicraftDev.unilib.neoforge;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.types.UnilibTypes;
import net.neoforged.fml.common.Mod;

@Mod(Unilib.UNI_LIB_MOD_ID)
public final class UnilibNeoForge {
    public UnilibNeoForge() {
        Unilib unilib = new Unilib("unilib");

        unilib.init();
        unilib.add(UnilibTypes.BLOCK("secretname"));
    }
}
