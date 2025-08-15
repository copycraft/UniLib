package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.phys.Vec3;
import com.copicraftDev.unilib.animation.util.UnilibInterp;

public class UnilibPivotTrack extends UnilibTrack {

    private Vec3 startPivot;
    private Vec3 endPivot;
    private float progress = 0f;

    public UnilibPivotTrack(Vec3 start, Vec3 end) {
        super("pivot");
        this.startPivot = start;
        this.endPivot = end;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        progress += delta;
        if (progress >= 1f) {
            progress = 1f;
            markDone();
        }
        Vec3 currentPivot = UnilibInterp.lerp(startPivot, endPivot, progress);
    }
}
