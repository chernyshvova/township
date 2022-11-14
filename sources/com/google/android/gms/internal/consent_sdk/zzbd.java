package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzbd implements Runnable {
    public final zzbe zza;
    public final String zzb;

    public zzbd(zzbe zzbe, String str) {
        this.zza = zzbe;
        this.zzb = str;
    }

    public final void run() {
        zzch.zza(this.zza, this.zzb);
    }
}
