package com.copicraftDev.unilib.animation.transform;

import com.copicraftDev.unilib.animation.AnimationContext;
import com.copicraftDev.unilib.animation.types.UnilibAnimation;

public abstract class UnilibTrack extends UnilibAnimation {
    protected String trackName;

    public UnilibTrack(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }
}
