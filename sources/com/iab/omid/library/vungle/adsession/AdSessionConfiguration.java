package com.iab.omid.library.vungle.adsession;

public class AdSessionConfiguration {
    public final CreativeType creativeType;
    public final Owner impressionOwner;
    public final ImpressionType impressionType;
    public final boolean isolateVerificationScripts;
    public final Owner mediaEventsOwner;

    public AdSessionConfiguration(CreativeType creativeType2, ImpressionType impressionType2, Owner owner, Owner owner2, boolean z) {
        this.creativeType = creativeType2;
        this.impressionType = impressionType2;
        this.impressionOwner = owner;
        if (owner2 == null) {
            this.mediaEventsOwner = Owner.NONE;
        } else {
            this.mediaEventsOwner = owner2;
        }
        this.isolateVerificationScripts = z;
    }
}
