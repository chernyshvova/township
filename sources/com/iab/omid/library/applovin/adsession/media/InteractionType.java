package com.iab.omid.library.applovin.adsession.media;

public enum InteractionType {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");
    
    public String interactionType;

    /* access modifiers changed from: public */
    InteractionType(String str) {
        this.interactionType = str;
    }

    public String toString() {
        return this.interactionType;
    }
}
