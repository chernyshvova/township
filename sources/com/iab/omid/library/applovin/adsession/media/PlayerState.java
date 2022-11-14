package com.iab.omid.library.applovin.adsession.media;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");
    
    public final String playerState;

    /* access modifiers changed from: public */
    PlayerState(String str) {
        this.playerState = str;
    }

    public String toString() {
        return this.playerState;
    }
}
