package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzdxy extends Exception {
    public final int zza;

    public zzdxy(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdxy(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdxy(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
