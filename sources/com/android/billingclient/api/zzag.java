package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzag implements Callable<Void> {
    public final /* synthetic */ BillingClientImpl.zza zza;

    public zzag(BillingClientImpl.zza zza2) {
        this.zza = zza2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object call() throws java.lang.Exception {
        /*
            r10 = this;
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza
            java.lang.Object r0 = r0.zzb
            monitor-enter(r0)
            com.android.billingclient.api.BillingClientImpl$zza r1 = r10.zza     // Catch:{ all -> 0x00fd }
            boolean r1 = r1.zzc     // Catch:{ all -> 0x00fd }
            r2 = 0
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            goto L_0x00fc
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            r0 = 3
            r1 = 0
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x00db }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x00db }
            android.content.Context r3 = r3.zzf     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x00db }
            r4 = 13
            r5 = 13
            r6 = 3
        L_0x0021:
            if (r5 < r0) goto L_0x0038
            com.android.billingclient.api.BillingClientImpl$zza r7 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r7 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            com.google.android.gms.internal.play_billing.zza r7 = r7.zzg     // Catch:{ Exception -> 0x0035 }
            java.lang.String r8 = "subs"
            int r6 = r7.zza(r5, r3, r8)     // Catch:{ Exception -> 0x0035 }
            if (r6 != 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            int r5 = r5 + -1
            goto L_0x0021
        L_0x0035:
            r0 = r6
            goto L_0x00db
        L_0x0038:
            r5 = 0
        L_0x0039:
            com.android.billingclient.api.BillingClientImpl$zza r7 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r7 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r8 = 5
            r9 = 1
            if (r5 < r8) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            r7.zzj = r8     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r7 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r7 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            if (r5 < r0) goto L_0x004e
            r8 = 1
            goto L_0x004f
        L_0x004e:
            r8 = 0
        L_0x004f:
            r7.zzi = r8     // Catch:{ Exception -> 0x0035 }
            if (r5 >= r0) goto L_0x005a
            java.lang.String r5 = "BillingClient"
            java.lang.String r7 = "In-app billing API does not support subscription on this device."
            com.google.android.gms.internal.play_billing.zzb.zza((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x0035 }
        L_0x005a:
            r5 = 13
        L_0x005c:
            if (r5 < r0) goto L_0x0070
            com.android.billingclient.api.BillingClientImpl$zza r7 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r7 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            com.google.android.gms.internal.play_billing.zza r7 = r7.zzg     // Catch:{ Exception -> 0x0035 }
            java.lang.String r8 = "inapp"
            int r6 = r7.zza(r5, r3, r8)     // Catch:{ Exception -> 0x0035 }
            if (r6 != 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            int r5 = r5 + -1
            goto L_0x005c
        L_0x0070:
            r5 = 0
        L_0x0071:
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            if (r5 < r4) goto L_0x0079
            r4 = 1
            goto L_0x007a
        L_0x0079:
            r4 = 0
        L_0x007a:
            r3.zzp = r4     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r4 = 12
            if (r5 < r4) goto L_0x0086
            r4 = 1
            goto L_0x0087
        L_0x0086:
            r4 = 0
        L_0x0087:
            r3.zzo = r4     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r4 = 10
            if (r5 < r4) goto L_0x0093
            r4 = 1
            goto L_0x0094
        L_0x0093:
            r4 = 0
        L_0x0094:
            r3.zzn = r4     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r4 = 9
            if (r5 < r4) goto L_0x00a0
            r4 = 1
            goto L_0x00a1
        L_0x00a0:
            r4 = 0
        L_0x00a1:
            r3.zzm = r4     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r4 = 8
            if (r5 < r4) goto L_0x00ad
            r4 = 1
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            r3.zzl = r4     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r4 = 6
            if (r5 < r4) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r9 = 0
        L_0x00b9:
            r3.zzk = r9     // Catch:{ Exception -> 0x0035 }
            if (r5 >= r0) goto L_0x00c4
            java.lang.String r0 = "BillingClient"
            java.lang.String r3 = "In-app billing API version 3 is not supported on this device."
            com.google.android.gms.internal.play_billing.zzb.zzb((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0035 }
        L_0x00c4:
            if (r6 != 0) goto L_0x00ce
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r0 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r3 = 2
            r0.zza = r3     // Catch:{ Exception -> 0x0035 }
            goto L_0x00eb
        L_0x00ce:
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r0 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r0.zza = r1     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza     // Catch:{ Exception -> 0x0035 }
            com.android.billingclient.api.BillingClientImpl r0 = com.android.billingclient.api.BillingClientImpl.this     // Catch:{ Exception -> 0x0035 }
            r0.zzg = r2     // Catch:{ Exception -> 0x0035 }
            goto L_0x00eb
        L_0x00db:
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "Exception while checking if billing is supported; try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzb((java.lang.String) r3, (java.lang.String) r4)
            com.android.billingclient.api.BillingClientImpl$zza r3 = r10.zza
            com.android.billingclient.api.BillingClientImpl r3 = com.android.billingclient.api.BillingClientImpl.this
            r3.zza = r1
            r3.zzg = r2
            r6 = r0
        L_0x00eb:
            if (r6 != 0) goto L_0x00f5
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzak.zzn
            com.android.billingclient.api.BillingClientImpl.zza.zza(r0, r1)
            goto L_0x00fc
        L_0x00f5:
            com.android.billingclient.api.BillingClientImpl$zza r0 = r10.zza
            com.android.billingclient.api.BillingResult r1 = com.android.billingclient.api.zzak.zza
            com.android.billingclient.api.BillingClientImpl.zza.zza(r0, r1)
        L_0x00fc:
            return r2
        L_0x00fd:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            goto L_0x0101
        L_0x0100:
            throw r1
        L_0x0101:
            goto L_0x0100
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzag.call():java.lang.Object");
    }
}
