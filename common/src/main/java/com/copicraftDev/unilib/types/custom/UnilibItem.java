package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.Unilib;
import com.copicraftDev.unilib.utils.NameFormatter;
import net.minecraft.world.item.Item;

public class UnilibItem {
    public static void addItem(String rawName) {
        String id = NameFormatter.toId(rawName);       // e.g. wheel_of_doom
        String display = NameFormatter.toLang(rawName); // e.g. Wheel Of Doom

        Unilib.ITEMS.register(id, () -> new Item(new Item.Properties()));
        System.out.println("[Unilib] [ITEM] Registered: " + id + " (Display: " + display + ")");
    }
}
