package com.copicraftDev.unilib.types.custom;

import java.util.HashMap;
import java.util.Map;

public class UnilibEvents {

    private static final Map<String, UnilibEvent> events = new HashMap<>();

    public static void addEventListener(UnilibEvent event) {
        events.put(event.getName(), event);
    }

    public static void trigger(String name) {
        UnilibEvent event = events.get(name);
        if (event != null) {
            event.execute();
        }
    }

    public static boolean hasEvent(String name) {
        return events.containsKey(name);
    }
}
