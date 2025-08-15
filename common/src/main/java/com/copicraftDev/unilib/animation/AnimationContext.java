package com.copicraftDev.unilib.animation;

import com.copicraftDev.unilib.client.UnilibCamera;
import net.minecraft.world.phys.Vec3;

public class AnimationContext {

    private Vec3 targetPosition;
    private UnilibCamera camera; // client-side camera wrapper

    public AnimationContext(UnilibCamera camera, Vec3 targetPosition) {
        this.camera = camera;
        this.targetPosition = targetPosition;
    }

    public UnilibCamera getCamera() {
        return camera;
    }

    public Vec3 getTargetPosition() {
        return targetPosition;
    }

    public void setCamera(UnilibCamera camera) {
        this.camera = camera;
    }

    public void setTargetPosition(Vec3 targetPosition) {
        this.targetPosition = targetPosition;
    }
}
