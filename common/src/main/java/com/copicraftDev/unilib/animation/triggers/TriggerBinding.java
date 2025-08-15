package com.copicraftDev.unilib.animation.triggers;

import com.copicraftDev.unilib.animation.targets.UnilibAnimationTarget;
import java.util.function.Consumer;

/**
 * Represents a single trigger binding: event -> action.
 */
public class TriggerBinding {

    private final String triggerName;
    private final Consumer<UnilibAnimationTarget> action;

    public TriggerBinding(String triggerName, Consumer<UnilibAnimationTarget> action) {
        this.triggerName = triggerName;
        this.action = action;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public Consumer<UnilibAnimationTarget> getAction() {
        return action;
    }
}
