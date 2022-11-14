package com.google.android.gms.internal.ads;

import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzfep {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE);
    
    public final String zzd;

    /* access modifiers changed from: public */
    zzfep(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
