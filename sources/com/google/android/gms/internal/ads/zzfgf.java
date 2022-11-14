package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgf extends zzfga {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: long} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.HashSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfgf(com.google.android.gms.internal.ads.zzfft r8, com.google.android.gms.internal.ads.zzfft r9, java.util.HashSet<java.lang.String> r10, org.json.JSONObject r11, long r12) {
        /*
            r7 = this;
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgf.<init>(com.google.android.gms.internal.ads.zzfft, java.util.HashSet, org.json.JSONObject, long, byte[]):void");
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzffn.zzi(this.zzb, this.zzd.zzd())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzfew zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfew.zza()) != null) {
            for (zzfel next : zza.zze()) {
                if (this.zza.contains(next.zzi())) {
                    next.zzh().zzf(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
