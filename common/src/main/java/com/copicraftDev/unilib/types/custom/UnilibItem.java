package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.Item;

public class UnilibItem {

    // ---------------- Default item ----------------
    public static void addItem(Unilib unilib, String rawName) {
        addItem(unilib, rawName, Item.class);
    }

    // ---------------- Optional custom item class ----------------
    public static <T extends Item> void addItem(Unilib unilib, String rawName, Class<T> itemClass) {
        String id = NameFormatter.toId(rawName);        // e.g. "wheel_of_doom"
        String display = NameFormatter.toLang(rawName); // e.g. "Wheel Of Doom"

        unilib.getItems().register(id, () -> {
            try {
                return itemClass.getConstructor(Item.Properties.class)
                        .newInstance(new Item.Properties());
            } catch (Exception e) {
                e.printStackTrace();
                return new Item(new Item.Properties());
            }
        });

        System.out.println("[Unilib] [ITEM] Registered: " + id + " (Display: " + display + ")");

        // Call client hook if present
        try {
            Class<?> hooks = Class.forName("com.copicraftDev.unilib.fabric.client.UnilibClientHooks");
            hooks.getMethod("onItemRegistered", String.class).invoke(null, id);
        } catch (ClassNotFoundException ignored) {
            // Not running client, ignore
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
