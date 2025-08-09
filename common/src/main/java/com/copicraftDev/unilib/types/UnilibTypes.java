package com.copicraftDev.unilib.types;

import com.copicraftDev.unilib.enums.UnilibBlockModels;
import com.copicraftDev.unilib.enums.UnilibBlockStates;
import com.copicraftDev.unilib.types.custom.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UnilibTypes {

    public static Type BLOCK(String name) {
        return new Type(name, UnilibBlock::addBlock);
    }

    public static Type ITEM(String name) {
        return new Type(name, UnilibItem::addItem);
    }

    public static Type ENTITY(String name) {
        return new Type(name, UnilibEntity::addEntity);
    }

    public static Type BLOCK_ENTITY(String name, BlockEntityType.BlockEntitySupplier<?> supplier, Block... blocks) {
        return new Type(name, n -> UnilibBlockEntity.addBlockEntity(n, supplier, blocks));
    }

    public static Type NETWORK_INBOUND(String name) {
        return new Type(name, UnilibNetwork::addInboundListener);
    }

    public static Type NETWORK_OUTBOUND(String name) {
        return new Type(name, UnilibNetwork::addOutboundSender);
    }
}

