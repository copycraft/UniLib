package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.world.phys.Vec3;
import com.copicraftDev.unilib.animation.util.UnilibInterp;

import java.util.List;

public class PathTrack extends UnilibTrack {

    private final List<Vec3> path;
    private float progress = 0f;

    public PathTrack(List<Vec3> path) {
        super("path");
        this.path = path;
    }

    @Override
    public void update(AnimationContext context, float delta) {
        progress += delta;
        if (progress >= 1f) {
            progress = 1f;
            markDone();
        }

        int lastIndex = path.size() - 1;
        float scaledProgress = progress * lastIndex;
        int index = (int) scaledProgress;
        float t = scaledProgress - index;

        Vec3 current = UnilibInterp.lerp(path.get(index), path.get(Math.min(index + 1, lastIndex)), t);
        context.setTargetPosition(current);
    }
}
