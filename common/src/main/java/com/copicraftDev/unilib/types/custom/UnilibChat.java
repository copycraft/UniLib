package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.types.Location;

import java.util.HashMap;
import java.util.Map;

public class UnilibChat {

    private static final Map<String, Location> chatTypes = new HashMap<>();

    public static void addChatType(String name, Location location) {
        chatTypes.put(name, location);
    }

    public static Location getLocation(String name) {
        return chatTypes.getOrDefault(name, Location.SERVER);
    }

    // Example usage
    public static void send(String name, String message) {
        Location loc = chatTypes.getOrDefault(name, Location.SERVER);
        if (loc == Location.SERVER) {
            // send server-side chat
            System.out.println("[Server] " + message);
        } else {
            // send client-side chat (example, you can integrate with Minecraft client)
            System.out.println("[Client] " + message);
        }
    }
}
