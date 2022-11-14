package com.swrve.sdk;

public class SwrveABTestDetails {
    public final int caseIndex;

    /* renamed from: id */
    public final String f2778id;
    public final String name;

    public SwrveABTestDetails(String str, String str2, int i) {
        this.f2778id = str;
        this.name = str2;
        this.caseIndex = i;
    }

    public int getCaseIndex() {
        return this.caseIndex;
    }

    public String getId() {
        return this.f2778id;
    }

    public String getName() {
        return this.name;
    }
}
