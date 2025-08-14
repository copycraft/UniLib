package com.copicraftDev.unilib.types;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.types.custom.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UnilibTypes {

    public static Type BLOCK(String name) {
        Unilib unilib = Unilib.getInstance();
        return new Type(name, n -> UnilibBlock.addBlock(unilib, n));
    }

    public static Type ITEM(String name) {
        Unilib unilib = Unilib.getInstance();
        return new Type(name, n -> UnilibItem.addItem(unilib, n));
    }

    public static <T extends Mob> Type ENTITY(String name,
                                              EntityType.EntityFactory<T> factory,
                                              MobCategory category,
                                              float width, float height) {
        Unilib unilib = Unilib.getInstance();
        return new Type(name, n -> UnilibEntity.addEntity(unilib, n, factory, category, width, height));
    }

    public static Type BLOCK_ENTITY(String name,
                                    BlockEntityType.BlockEntitySupplier<?> supplier,
                                    Block... blocks) {
        Unilib unilib = Unilib.getInstance();
        return new Type(name, n -> UnilibBlockEntity.addBlockEntity(unilib, n, supplier, blocks));
    }

    public static Type NETWORK_INBOUND(String name) {
        return new Type(name, UnilibNetwork::addInboundListener);
    }

    public static Type NETWORK_OUTBOUND(String name) {
        return new Type(name, UnilibNetwork::addOutboundSender);
    }

    // ---------------- NEW TYPES ----------------

    /** Registers a particle type for a specific location */
    public static Type PARTICLE(String name, ParticleOptions particle, Location location) {
        return new Type(name, n -> UnilibParticles.addParticle(n, particle, location));
    }

    /** Registers a chat message type for a specific location */
    public static Type CHAT(String message, Location location) {
        return new Type(message, n -> UnilibChat.addChatType(n, location));
    }


    public static Type EVENT(UnilibEvent event) {
        // The Type still needs a name for your add(Type) system
        return new Type(event.getName(), n -> UnilibEvents.addEventListener(event));
    }
}
