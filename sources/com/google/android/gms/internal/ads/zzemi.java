package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemi implements zzeqp<zzemj> {
    public final zzfqo zza;
    public final zzdss zzb;
    public final zzdww zzc;
    public final zzemk zzd;

    public zzemi(zzfqo zzfqo, zzdss zzdss, zzdww zzdww, zzemk zzemk) {
        this.zza = zzfqo;
        this.zzb = zzdss;
        this.zzc = zzdww;
        this.zzd = zzemk;
    }

    public final zzfqn<zzemj> zza() {
        if (zzfkm.zzc((String) zzbex.zzc().zzb(zzbjn.zzaW)) || this.zzd.zzb() || !this.zzc.zze()) {
            return zzfqe.zza(new zzemj(new Bundle(), (zzemg) null));
        }
        this.zzd.zza(true);
        return this.zza.zzb(new zzemh(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|(1:9)|10|11|(1:13)|14|15|21|19|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A[Catch:{ zzezb -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzemj zzb() throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbjf<java.lang.String> r0 = com.google.android.gms.internal.ads.zzbjn.zzaW
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzdss r3 = r7.zzb     // Catch:{ zzezb -> 0x0060 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ zzezb -> 0x0060 }
            r4.<init>()     // Catch:{ zzezb -> 0x0060 }
            com.google.android.gms.internal.ads.zzezn r3 = r3.zzb(r2, r4)     // Catch:{ zzezb -> 0x0060 }
            r3.zzn()     // Catch:{ zzezb -> 0x0060 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ zzezb -> 0x0060 }
            r4.<init>()     // Catch:{ zzezb -> 0x0060 }
            com.google.android.gms.internal.ads.zzbyb r5 = r3.zzA()     // Catch:{ zzezb -> 0x004d }
            if (r5 == 0) goto L_0x004d
            java.lang.String r6 = "sdk_version"
            java.lang.String r5 = r5.toString()     // Catch:{ zzezb -> 0x004d }
            r4.putString(r6, r5)     // Catch:{ zzezb -> 0x004d }
        L_0x004d:
            com.google.android.gms.internal.ads.zzbyb r3 = r3.zzz()     // Catch:{ zzezb -> 0x005c }
            if (r3 == 0) goto L_0x005c
            java.lang.String r5 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzezb -> 0x005c }
            r4.putString(r5, r3)     // Catch:{ zzezb -> 0x005c }
        L_0x005c:
            r1.putBundle(r2, r4)     // Catch:{ zzezb -> 0x0060 }
            goto L_0x001f
        L_0x0060:
            goto L_0x001f
        L_0x0062:
            com.google.android.gms.internal.ads.zzemj r0 = new com.google.android.gms.internal.ads.zzemj
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemi.zzb():com.google.android.gms.internal.ads.zzemj");
    }
}
