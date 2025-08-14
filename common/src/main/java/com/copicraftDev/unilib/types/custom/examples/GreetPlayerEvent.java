package com.copicraftDev.unilib.types.custom.examples;

import com.copicraftDev.unilib.types.Location;
import com.copicraftDev.unilib.types.custom.UnilibEvent;

public class GreetPlayerEvent extends UnilibEvent {

    public GreetPlayerEvent() {
        super("greet_player", Location.SERVER);
    }

    @Override
    public void execute() {
        System.out.println("[Unilib Event] Hello, Player! This is a server-side greeting.");
    }
}
