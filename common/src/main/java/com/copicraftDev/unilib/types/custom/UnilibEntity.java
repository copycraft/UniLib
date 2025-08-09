package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Function;

public class UnilibEntity {

    /**
     * Register an entity type using the given Unilib instance.
     *
     * @param unilib Unilib instance for registration
     * @param rawName Display/raw name of the entity
     * @param factory Factory to create the entity (e.g., a constructor reference)
     * @param category MobCategory of the entity
     * @param width Width of the entity hitbox
     * @param height Height of the entity hitbox
     * @param <T> Entity type, extending Mob
     */
    public static <T extends Mob> void addEntity(Unilib unilib, String rawName,
                                                 EntityType.EntityFactory<T> factory,
                                                 MobCategory category,
                                                 float width, float height) {
        String id = NameFormatter.toId(rawName);
        String display = NameFormatter.toLang(rawName);

        unilib.getEntities().register(id, () ->
                EntityType.Builder.of(factory, category)
                        .sized(width, height)
                        .build(id)
        );

        System.out.println("[Unilib] [ENTITY] Registered: " + id + " (Display: " + display + ")");
    }
}
