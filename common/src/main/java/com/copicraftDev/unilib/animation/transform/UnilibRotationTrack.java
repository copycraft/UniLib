package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.util.UnilibInterp;
import net.minecraft.world.phys.Vec3;

public class UnilibRotationTrack extends UnilibTrack {

    private Vec3 startRot;
    private Vec3 endRot;
    private float progress = 0f;

    public UnilibRotationTrack(Vec3 start, Vec3 end) {
        super("rotation");
        this.startRot = start;
        this.endRot = end;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        progress += delta;
        if (progress >= 1f) {
            progress = 1f;
            markDone();
        }
        Vec3 currentRot = UnilibInterp.lerp(startRot, endRot, progress);
    }
}
