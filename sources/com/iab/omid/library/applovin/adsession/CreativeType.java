package com.iab.omid.library.applovin.adsession;

public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO("audio");
    
    public final String creativeType;

    /* access modifiers changed from: public */
    CreativeType(String str) {
        this.creativeType = str;
    }

    public String toString() {
        return this.creativeType;
    }
}
