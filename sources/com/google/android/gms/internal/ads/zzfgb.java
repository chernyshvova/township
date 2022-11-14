package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfgb extends AsyncTask<Object, Void, String> {
    public zzfgc zza;
    public final zzfft zzd;

    public zzfgb(zzfft zzfft, byte[] bArr) {
        this.zzd = zzfft;
    }

    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfgc zzfgc = this.zza;
        if (zzfgc != null) {
            zzfgc.zzb(this);
        }
    }

    public final void zzb(zzfgc zzfgc) {
        this.zza = zzfgc;
    }
}
