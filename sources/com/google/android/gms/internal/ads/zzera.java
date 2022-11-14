package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzera implements zzeqp<zzeqy> {
    public final zzfqo zza;
    public final Context zzb;

    public zzera(zzfqo zzfqo, Context context) {
        this.zza = zzfqo;
        this.zzb = context;
    }

    public final zzfqn<zzeqy> zza() {
        return this.zza.zzb(new zzeqz(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeqy zzb() throws java.lang.Exception {
        /*
            r9 = this;
            android.content.Context r0 = r9.zzb
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r2 = r0.getNetworkOperator()
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r1 == 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzbjn.zzfP
            com.google.android.gms.internal.ads.zzbjl r4 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r1 = r4.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0029
            r4 = 0
            goto L_0x002e
        L_0x0029:
            int r1 = r0.getNetworkType()
            r4 = r1
        L_0x002e:
            int r5 = r0.getPhoneType()
            com.google.android.gms.ads.internal.zzs.zzc()
            android.content.Context r0 = r9.zzb
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = com.google.android.gms.ads.internal.util.zzr.zzE(r0, r1)
            r1 = -1
            if (r0 == 0) goto L_0x0068
            android.content.Context r0 = r9.zzb
            java.lang.String r3 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r3 = r0.getActiveNetworkInfo()
            if (r3 == 0) goto L_0x0060
            int r1 = r3.getType()
            android.net.NetworkInfo$DetailedState r3 = r3.getDetailedState()
            int r3 = r3.ordinal()
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x0061
        L_0x0060:
            r3 = -1
        L_0x0061:
            boolean r0 = r0.isActiveNetworkMetered()
            r6 = r0
            r7 = r1
            goto L_0x006c
        L_0x0068:
            r0 = -2
            r3 = -2
            r6 = 0
            r7 = -1
        L_0x006c:
            com.google.android.gms.internal.ads.zzeqy r0 = new com.google.android.gms.internal.ads.zzeqy
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzera.zzb():com.google.android.gms.internal.ads.zzeqy");
    }
}
