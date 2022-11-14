package com.swrve.sdk;

public class QaGeoCampaignInfo {
    public boolean displayed;
    public String reason;
    public long variantId;

    public QaGeoCampaignInfo(long j, boolean z, String str) {
        this.variantId = j;
        this.displayed = z;
        this.reason = str;
    }
}
