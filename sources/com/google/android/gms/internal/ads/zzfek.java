package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzfek {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    public final String zzd;

    /* access modifiers changed from: public */
    zzfek(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
