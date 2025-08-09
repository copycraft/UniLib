package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.types.custom.examples.ExampleBlockEntity;
import com.copicraftDev.unilib.utils.NameFormatter;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;

public class UnilibBlockEntity {
    public static <T extends BlockEntity> void addBlockEntity(String rawName, BlockEntitySupplier<T> blockEntitySupplier, Block... validBlocks) {
        String id = NameFormatter.toId(rawName);
        String display = NameFormatter.toLang(rawName);

        Unilib.BLOCK_ENTITIES.register(id, () -> BlockEntityType.Builder.of(blockEntitySupplier, validBlocks).build(null));

        System.out.println("[Unilib] [BLOCK ENTITY] Registered: " + id + " (Display: " + display + ")");
    }
}
