package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.animation.types.UnilibAnimation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class UnilibAnimationRegistry {

    private final Map<String, Supplier<UnilibAnimation>> registry = new HashMap<>();

    public void register(String name, Supplier<UnilibAnimation> factory) {
        registry.put(name, factory);
    }

    public UnilibAnimation create(String name) {
        Supplier<UnilibAnimation> factory = registry.get(name);
        if (factory != null) {
            return factory.get();
        }
        throw new IllegalArgumentException("Animation not found: " + name);
    }

    public boolean exists(String name) {
        return registry.containsKey(name);
    }
}
