package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnilibBlock {

    /**
     * Registers a block and its item under the given Unilib instance's registries.
     *
     * @param unilib The Unilib instance owning the registration.
     * @param rawName The display/raw name (e.g. "Wheel Of Doom").
     */
    public static void addBlock(Unilib unilib, String rawName) {
        String id = NameFormatter.toId(rawName);            // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName);     // e.g. "Wheel Of Doom"

        // Register block via Unilib instance
        var block = unilib.getBlocks().register(id, () ->
                new Block(BlockBehaviour.Properties.of())
        );

        // Register block item via Unilib instance
        unilib.getItems().register(id, () ->
                new BlockItem(block.get(), new Item.Properties())
        );

        System.out.println("[Unilib] [BLOCK] Registered: " + id + " (Display: " + display + ")");

        // Reflective client hook call stays the same (can be static)
        try {
            Class<?> hooks = Class.forName("com.copicraftDev.unilib.fabric.client.UnilibClientHooks");
            hooks.getMethod("onBlockRegistered", String.class).invoke(null, id);
        } catch (ClassNotFoundException ignored) {
            // Not running client or no client module, ignore
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
