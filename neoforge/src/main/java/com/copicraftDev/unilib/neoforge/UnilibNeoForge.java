package com.copicraftDev.unilib.neoforge;

import com.copicraftDev.unilib.Unilib;
import net.neoforged.fml.common.Mod;

@Mod(Unilib.UNI_MOD_ID)
public final class UnilibNeoForge {
    public UnilibNeoForge() {
        // Run our common setup.
        Unilib.init("unilib");
    }
}
