package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.util.UnilibInterp;
import net.minecraft.world.phys.Vec3;

public class UnilibScaleTrack extends UnilibTrack {

    private Vec3 startScale;
    private Vec3 endScale;
    private float progress = 0f;

    public UnilibScaleTrack(Vec3 start, Vec3 end) {
        super("scale");
        this.startScale = start;
        this.endScale = end;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        progress += delta;
        if (progress >= 1f) {
            progress = 1f;
            markDone();
        }
        Vec3 currentScale = UnilibInterp.lerp(startScale, endScale, progress);
    }
}
