package com.swrve.sdk;

public class SwrveUser {
    public String externalUserId;
    public String swrveUserId;
    public boolean verified;

    public SwrveUser(String str, String str2, boolean z) {
        this.swrveUserId = str;
        this.externalUserId = str2;
        this.verified = z;
    }

    public String getExternalUserId() {
        return this.externalUserId;
    }

    public String getSwrveUserId() {
        return this.swrveUserId;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setExternalUserId(String str) {
        this.externalUserId = str;
    }

    public void setSwrveUserId(String str) {
        this.swrveUserId = str;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }
}
