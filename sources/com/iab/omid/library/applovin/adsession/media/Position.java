package com.iab.omid.library.applovin.adsession.media;

import com.vungle.warren.model.Advertisement;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    
    public final String position;

    /* access modifiers changed from: public */
    Position(String str) {
        this.position = str;
    }

    public String toString() {
        return this.position;
    }
}
