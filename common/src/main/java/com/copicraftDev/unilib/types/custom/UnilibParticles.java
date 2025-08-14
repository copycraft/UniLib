package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.types.Location;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class UnilibParticles {

    private static final Map<String, ParticleEntry> particleTypes = new HashMap<>();

    private record ParticleEntry(ParticleOptions particle, Location location) {}

    public static void addParticle(String name, ParticleOptions particle, Location location) {
        particleTypes.put(name, new ParticleEntry(particle, location));
    }

    public static ParticleEntry get(String name) {
        return particleTypes.get(name);
    }

    // Example spawn method
    public static void spawn(String name, Level world, double x, double y, double z, int count) {
        ParticleEntry entry = particleTypes.get(name);
        if (entry == null) return;

        if ((entry.location() == Location.CLIENT && world.isClientSide()) ||
                (entry.location() == Location.SERVER && !world.isClientSide())) {

            for (int i = 0; i < count; i++) {
                world.addParticle(entry.particle(), x, y, z, 0, 0, 0);
            }
        }
    }
}
