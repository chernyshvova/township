package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzib implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzhy zze;

    public zzib(zzhy zzhy, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhy;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
