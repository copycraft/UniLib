package com.copicraftDev.unilib.client;

import net.minecraft.world.phys.Vec3;

public class UnilibCamera {
    private float fov = 70f; // default FOV
    private float offsetX, offsetY, offsetZ;

    public void setFov(float fov) {
        this.fov = fov;
    }

    public float getFov() {
        return fov;
    }

    public void setPositionOffset(float x, float y, float z) {
        this.offsetX = x;
        this.offsetY = y;
        this.offsetZ = z;
    }

    public void addOffset(float x, float y, float z) {
        this.offsetX += x;
        this.offsetY += y;
        this.offsetZ += z;
    }

    public void resetOffset() {
        this.offsetX = 0;
        this.offsetY = 0;
        this.offsetZ = 0;
    }

    public void lookAt(Vec3 pos) {
        // implement if needed: modify rotation based on target
    }

    // Getters for rendering integration
    public float getOffsetX() { return offsetX; }
    public float getOffsetY() { return offsetY; }
    public float getOffsetZ() { return offsetZ; }
}
