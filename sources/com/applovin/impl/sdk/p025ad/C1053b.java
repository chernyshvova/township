package com.applovin.impl.sdk.p025ad;

/* renamed from: com.applovin.impl.sdk.ad.b */
public enum C1053b {
    UNKNOWN(0),
    APPLOVIN_PRIMARY_ZONE(1),
    APPLOVIN_CUSTOM_ZONE(2),
    APPLOVIN_MULTIZONE(3),
    REGULAR_AD_TOKEN(4),
    DECODED_AD_TOKEN_JSON(5);
    

    /* renamed from: g */
    public final int f1399g;

    /* access modifiers changed from: public */
    C1053b(int i) {
        this.f1399g = i;
    }

    /* renamed from: a */
    public static C1053b m1464a(int i) {
        return i == 1 ? APPLOVIN_PRIMARY_ZONE : i == 2 ? APPLOVIN_CUSTOM_ZONE : i == 3 ? APPLOVIN_MULTIZONE : i == 4 ? REGULAR_AD_TOKEN : i == 5 ? DECODED_AD_TOKEN_JSON : UNKNOWN;
    }

    /* renamed from: a */
    public int mo10539a() {
        return this.f1399g;
    }
}
