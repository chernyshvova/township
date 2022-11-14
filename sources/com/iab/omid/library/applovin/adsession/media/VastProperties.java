package com.iab.omid.library.applovin.adsession.media;

import com.iab.omid.library.applovin.p047d.C2858c;
import com.iab.omid.library.applovin.p047d.C2860e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a */
    public final boolean f3388a;

    /* renamed from: b */
    public final Float f3389b;

    /* renamed from: c */
    public final boolean f3390c;

    /* renamed from: d */
    public final Position f3391d;

    public VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f3388a = z;
        this.f3389b = f;
        this.f3390c = z2;
        this.f3391d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        C2860e.m3379a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        C2860e.m3379a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    /* renamed from: a */
    public JSONObject mo36700a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f3388a);
            if (this.f3388a) {
                jSONObject.put("skipOffset", this.f3389b);
            }
            jSONObject.put("autoPlay", this.f3390c);
            jSONObject.put("position", this.f3391d);
        } catch (JSONException e) {
            C2858c.m3374a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f3391d;
    }

    public Float getSkipOffset() {
        return this.f3389b;
    }

    public boolean isAutoPlay() {
        return this.f3390c;
    }

    public boolean isSkippable() {
        return this.f3388a;
    }
}
