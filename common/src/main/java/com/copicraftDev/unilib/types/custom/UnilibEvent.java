package com.copicraftDev.unilib.types.custom;

import com.copicraftDev.unilib.types.Location;

public abstract class UnilibEvent {

    private final String name;
    private final Location location;

    public UnilibEvent(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    /** Called every tick or on trigger depending on event type */
    public abstract void execute();
}
