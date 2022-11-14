package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakn extends BroadcastReceiver {
    public final /* synthetic */ zzakp zza;

    public /* synthetic */ zzakn(zzakp zzakp, zzakl zzakl) {
        this.zza = zzakp;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r11 = "connectivity"
            java.lang.Object r11 = r10.getSystemService(r11)
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11
            r0 = 2
            r1 = 9
            r2 = 6
            r3 = 4
            r4 = 29
            r5 = 1
            r6 = 0
            r7 = 5
            if (r11 != 0) goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x004f
        L_0x0016:
            android.net.NetworkInfo r11 = r11.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x0014 }
            if (r11 == 0) goto L_0x004e
            boolean r8 = r11.isConnected()
            if (r8 != 0) goto L_0x0023
            goto L_0x004e
        L_0x0023:
            int r8 = r11.getType()
            if (r8 == 0) goto L_0x003a
            if (r8 == r5) goto L_0x004f
            if (r8 == r3) goto L_0x003a
            if (r8 == r7) goto L_0x003a
            if (r8 == r2) goto L_0x0038
            if (r8 == r1) goto L_0x0036
            r0 = 8
            goto L_0x004f
        L_0x0036:
            r0 = 7
            goto L_0x004f
        L_0x0038:
            r0 = 5
            goto L_0x004f
        L_0x003a:
            int r11 = r11.getSubtype()
            switch(r11) {
                case 1: goto L_0x004c;
                case 2: goto L_0x004c;
                case 3: goto L_0x004a;
                case 4: goto L_0x004a;
                case 5: goto L_0x004a;
                case 6: goto L_0x004a;
                case 7: goto L_0x004a;
                case 8: goto L_0x004a;
                case 9: goto L_0x004a;
                case 10: goto L_0x004a;
                case 11: goto L_0x004a;
                case 12: goto L_0x004a;
                case 13: goto L_0x0038;
                case 14: goto L_0x004a;
                case 15: goto L_0x004a;
                case 16: goto L_0x0041;
                case 17: goto L_0x004a;
                case 18: goto L_0x004f;
                case 19: goto L_0x0041;
                case 20: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r0 = 6
            goto L_0x004f
        L_0x0043:
            int r11 = com.google.android.gms.internal.ads.zzalh.zza
            if (r11 < r4) goto L_0x0014
            r0 = 9
            goto L_0x004f
        L_0x004a:
            r0 = 4
            goto L_0x004f
        L_0x004c:
            r0 = 3
            goto L_0x004f
        L_0x004e:
            r0 = 1
        L_0x004f:
            if (r0 != r7) goto L_0x007b
            int r11 = com.google.android.gms.internal.ads.zzalh.zza
            if (r11 < r4) goto L_0x007c
            java.lang.String r11 = "phone"
            java.lang.Object r10 = r10.getSystemService(r11)     // Catch:{ RuntimeException -> 0x007c }
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch:{ RuntimeException -> 0x007c }
            r11 = 0
            if (r10 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzako r0 = new com.google.android.gms.internal.ads.zzako     // Catch:{ RuntimeException -> 0x007c }
            com.google.android.gms.internal.ads.zzakp r1 = r9.zza     // Catch:{ RuntimeException -> 0x007c }
            r0.<init>(r1, r11)     // Catch:{ RuntimeException -> 0x007c }
            int r11 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ RuntimeException -> 0x007c }
            r1 = 31
            if (r11 >= r1) goto L_0x0071
            r10.listen(r0, r5)     // Catch:{ RuntimeException -> 0x007c }
            goto L_0x0076
        L_0x0071:
            r11 = 1048576(0x100000, float:1.469368E-39)
            r10.listen(r0, r11)     // Catch:{ RuntimeException -> 0x007c }
        L_0x0076:
            r10.listen(r0, r6)     // Catch:{ RuntimeException -> 0x007c }
            return
        L_0x007a:
            throw r11     // Catch:{ RuntimeException -> 0x007c }
        L_0x007b:
            r7 = r0
        L_0x007c:
            com.google.android.gms.internal.ads.zzakp r10 = r9.zza
            com.google.android.gms.internal.ads.zzakp.zzd(r10, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.onReceive(android.content.Context, android.content.Intent):void");
    }
}
