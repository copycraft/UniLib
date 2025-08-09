package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.Item;

public class UnilibItem {

    /**
     * Register an item with the given Unilib instance.
     *
     * @param unilib The Unilib instance to use for registration.
     * @param rawName The display/raw name of the item.
     */
    public static void addItem(Unilib unilib, String rawName) {
        String id = NameFormatter.toId(rawName);        // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName); // e.g. "Wheel Of Doom"

        // Register item on the instance's DeferredRegister
        unilib.getItems().register(id, () -> new Item(new Item.Properties()));

        System.out.println("[Unilib] [ITEM] Registered: " + id + " (Display: " + display + ")");

        // Tell client to generate item model if client module present
        try {
            Class<?> hooks = Class.forName("com.copicraftDev.unilib.fabric.client.UnilibClientHooks");
            hooks.getMethod("onItemRegistered", String.class).invoke(null, id);
        } catch (ClassNotFoundException ignored) {
            // Not running on client, safe to ignore
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
