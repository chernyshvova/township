package com.iab.omid.library.applovin.adsession;

import com.iab.omid.library.applovin.p047d.C2860e;

public class Partner {
    public final String name;
    public final String version;

    public Partner(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public static Partner createPartner(String str, String str2) {
        C2860e.m3381a(str, "Name is null or empty");
        C2860e.m3381a(str2, "Version is null or empty");
        return new Partner(str, str2);
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }
}
