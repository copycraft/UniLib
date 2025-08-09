package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.types.custom.examples.UnilibExampleEntity;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;

public class UnilibEntity {

    public static void addEntity(String rawName) {
        String id = NameFormatter.toId(rawName);        // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName); // e.g. "Wheel Of Doom"

        Unilib.ENTITIES.register(id, () ->
                EntityType.Builder.<Mob>of(UnilibExampleEntity::new, MobCategory.CREATURE)
                        .sized(0.6F, 1.8F) // Adjust hitbox size as needed
                        .build(id)
        );

        System.out.println("[Unilib] [ENTITY] Registered: " + id + " (Display: " + display + ")");
    }
}
