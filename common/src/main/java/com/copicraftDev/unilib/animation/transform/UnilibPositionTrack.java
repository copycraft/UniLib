package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.phys.Vec3;
import com.copicraftDev.unilib.animation.util.UnilibInterp;

public class UnilibPositionTrack extends UnilibTrack {

    private Vec3 startPos;
    private Vec3 endPos;
    private float progress = 0f;

    public UnilibPositionTrack(Vec3 start, Vec3 end) {
        super("position");
        this.startPos = start;
        this.endPos = end;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        progress += delta;
        if (progress >= 1f) {
            progress = 1f;
            markDone();
        }
        Vec3 current = UnilibInterp.lerp(startPos, endPos, progress);
        context.setTargetPosition(current);
    }
}
