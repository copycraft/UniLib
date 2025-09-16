package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnilibBlock {

    // ---------------- Default block ----------------
    public static void addBlock(Unilib unilib, String rawName) {
        addBlock(unilib, rawName, Block.class);
    }

    // ---------------- Optional custom block class ----------------
    public static <T extends Block> void addBlock(Unilib unilib, String rawName, Class<T> blockClass) {
        String id = NameFormatter.toId(rawName);            // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName);     // e.g. "Wheel Of Doom"

        var block = unilib.getBlocks().register(id, () -> {
            try {
                return blockClass.getConstructor(BlockBehaviour.Properties.class)
                        .newInstance(BlockBehaviour.Properties.of());
            } catch (Exception e) {
                e.printStackTrace();
                return new Block(BlockBehaviour.Properties.of());
            }
        });

        // Register block item automatically
        unilib.getItems().register(id, () -> new BlockItem(block.get(), new Item.Properties()));

        System.out.println("[Unilib] [BLOCK] Registered: " + id + " (Display: " + display + ")");

        // Call client hook if present
        try {
            Class<?> hooks = Class.forName("com.copicraftDev.unilib.fabric.client.UnilibClientHooks");
            hooks.getMethod("onBlockRegistered", String.class).invoke(null, id);
        } catch (ClassNotFoundException ignored) {
            // Not running client, ignore
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
