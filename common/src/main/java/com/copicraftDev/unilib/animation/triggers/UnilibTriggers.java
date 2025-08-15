package com.copicraftDev.unilib.animation.triggers;

import com.copicraftDev.unilib.animation.targets.UnilibAnimationTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Trigger system to fire animations on events.
 */
public class UnilibTriggers {

    private final List<TriggerBinding> bindings = new ArrayList<>();

    /** Register a trigger for a specific event */
    public void register(TriggerBinding binding) {
        bindings.add(binding);
    }

    public void fire(String triggerName, UnilibAnimationTarget target) {
        for (TriggerBinding b : bindings) {
            if (b.getTriggerName().equals(triggerName)) {
                b.getAction().accept(target);
            }
        }
    }
}
