package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;

public class UnilibBoneTarget extends UnilibAnimationTarget {

    private final String boneName;

    public UnilibBoneTarget(String boneName) {
        this.boneName = boneName;
    }

    @Override
    public void apply(AnimationContext context, float delta) {
        // bone-specific transform logic
    }

    public String getBoneName() {
        return boneName;
    }
}
