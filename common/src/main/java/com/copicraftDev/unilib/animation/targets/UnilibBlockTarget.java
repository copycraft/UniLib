package com.copicraftDev.unilib.animation.targets;

import com.copicraftDev.unilib.animation.AnimationContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class UnilibBlockTarget extends UnilibAnimationTarget {

    private final Level level;
    private final BlockPos pos;

    public UnilibBlockTarget(Level level, BlockPos pos) {
        this.level = level;
        this.pos = pos;
    }

    @Override
    public void apply(AnimationContext context, float delta) {
        // Example: could animate particles or FX at the block
    }

    public BlockPos getPos() {
        return pos;
    }

    public Level getLevel() {
        return level;
    }
}
