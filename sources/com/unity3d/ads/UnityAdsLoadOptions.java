package com.unity3d.ads;

public class UnityAdsLoadOptions extends UnityAdsBaseOptions {
    public String AD_MARKUP = "adMarkup";

    public void setAdMarkup(String str) {
        set(this.AD_MARKUP, str);
    }
}
