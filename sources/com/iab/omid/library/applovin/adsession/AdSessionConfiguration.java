package com.iab.omid.library.applovin.adsession;

import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2860e;
import org.json.JSONObject;

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

    public static AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType2, ImpressionType impressionType2, Owner owner, Owner owner2, boolean z) {
        C2860e.m3379a((Object) creativeType2, "CreativeType is null");
        C2860e.m3379a((Object) impressionType2, "ImpressionType is null");
        C2860e.m3379a((Object) owner, "Impression owner is null");
        C2860e.m3377a(owner, creativeType2, impressionType2);
        return new AdSessionConfiguration(creativeType2, impressionType2, owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.impressionOwner;
    }

    public boolean isNativeMediaEventsOwner() {
        return Owner.NATIVE == this.mediaEventsOwner;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "impressionOwner", this.impressionOwner);
        C2856b.m3362a(jSONObject, "mediaEventsOwner", this.mediaEventsOwner);
        C2856b.m3362a(jSONObject, "creativeType", this.creativeType);
        C2856b.m3362a(jSONObject, "impressionType", this.impressionType);
        C2856b.m3362a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}
