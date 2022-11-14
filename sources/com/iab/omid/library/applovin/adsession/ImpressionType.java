package com.iab.omid.library.applovin.adsession;

public enum ImpressionType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    
    public final String impressionType;

    /* access modifiers changed from: public */
    ImpressionType(String str) {
        this.impressionType = str;
    }

    public String toString() {
        return this.impressionType;
    }
}
