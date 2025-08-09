package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnilibBlock {

    public static void addBlock(String rawName) {
        String id = NameFormatter.toId(rawName);            // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName);     // e.g. "Wheel Of Doom"

        // Register block
        var block = Unilib.BLOCKS.register(id, () ->
                new Block(BlockBehaviour.Properties.of())
        );

        // Register block item
        Unilib.ITEMS.register(id, () ->
                new BlockItem(block.get(), new Item.Properties())
        );

        // Output confirmation
        System.out.println("[Unilib] [BLOCK] Registered: " + id + " (Display: " + display + ")");
    }
}
