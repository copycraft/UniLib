package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;

public class UnilibBlockEntity {

    /**
     * Register a block entity type under the given Unilib instance.
     *
     * @param unilib The Unilib instance to use for registration.
     * @param rawName The display/raw name.
     * @param blockEntitySupplier The supplier for the block entity.
     * @param validBlocks The blocks this block entity applies to.
     * @param <T> BlockEntity subclass type.
     */
    public static <T extends BlockEntity> void addBlockEntity(
            Unilib unilib,
            String rawName,
            BlockEntitySupplier<T> blockEntitySupplier,
            Block... validBlocks) {

        String id = NameFormatter.toId(rawName);
        String display = NameFormatter.toLang(rawName);

        // Register using instance's deferred register
        unilib.getBlockEntities().register(id,
                () -> BlockEntityType.Builder.of(blockEntitySupplier, validBlocks).build(null)
        );

        System.out.println("[Unilib] [BLOCK ENTITY] Registered: " + id + " (Display: " + display + ")");
    }
}
