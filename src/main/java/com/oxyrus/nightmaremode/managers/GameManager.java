package com.oxyrus.nightmaremode.managers;

public final class GameManager {

    private boolean enableNightmareMode;

    public GameManager(boolean enableNightmareMode) {
        this.enableNightmareMode = enableNightmareMode;
    }

    public void setEnableNightmareMode(boolean enableNightmareMode) {
        this.enableNightmareMode = enableNightmareMode;
    }

    public boolean nightmareModeEnabled() {
        return this.enableNightmareMode;
    }
}
