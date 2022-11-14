package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckw implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzckx zze;

    public zzckw(zzckx zzckx, String str, String str2, String str3, String str4) {
        this.zze = zzckx;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            java.lang.String r1 = "precacheCanceled"
            java.util.HashMap r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline28(r0, r1)
            java.lang.String r1 = r3.zza
            java.lang.String r2 = "src"
            r0.put(r2, r1)
            java.lang.String r1 = r3.zzb
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r3.zzb
            java.lang.String r2 = "cachedSrc"
            r0.put(r2, r1)
        L_0x001e:
            java.lang.String r1 = r3.zzc
            int r2 = r1.hashCode()
            switch(r2) {
                case -1947652542: goto L_0x009d;
                case -1396664534: goto L_0x0092;
                case -1347010958: goto L_0x0088;
                case -918817863: goto L_0x007d;
                case -659376217: goto L_0x0073;
                case -642208130: goto L_0x0069;
                case -354048396: goto L_0x005e;
                case -32082395: goto L_0x0053;
                case 3387234: goto L_0x0049;
                case 96784904: goto L_0x003f;
                case 580119100: goto L_0x0034;
                case 725497484: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x00a7
        L_0x0029:
            java.lang.String r2 = "noCacheDir"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 7
            goto L_0x00a8
        L_0x0034:
            java.lang.String r2 = "expireFailed"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 6
            goto L_0x00a8
        L_0x003f:
            java.lang.String r2 = "error"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 1
            goto L_0x00a8
        L_0x0049:
            java.lang.String r2 = "noop"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 4
            goto L_0x00a8
        L_0x0053:
            java.lang.String r2 = "externalAbort"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 10
            goto L_0x00a8
        L_0x005e:
            java.lang.String r2 = "sizeExceeded"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 11
            goto L_0x00a8
        L_0x0069:
            java.lang.String r2 = "playerFailed"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 5
            goto L_0x00a8
        L_0x0073:
            java.lang.String r2 = "contentLengthMissing"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 0
            goto L_0x00a8
        L_0x007d:
            java.lang.String r2 = "downloadTimeout"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 9
            goto L_0x00a8
        L_0x0088:
            java.lang.String r2 = "inProgress"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 2
            goto L_0x00a8
        L_0x0092:
            java.lang.String r2 = "badUrl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 8
            goto L_0x00a8
        L_0x009d:
            java.lang.String r2 = "interrupted"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a7
            r1 = 3
            goto L_0x00a8
        L_0x00a7:
            r1 = -1
        L_0x00a8:
            java.lang.String r2 = "internal"
            switch(r1) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x00b6;
                case 2: goto L_0x00b6;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00b6;
                case 6: goto L_0x00b4;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00b1;
                case 9: goto L_0x00b1;
                case 10: goto L_0x00ae;
                case 11: goto L_0x00ae;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            goto L_0x00b6
        L_0x00ae:
            java.lang.String r2 = "policy"
            goto L_0x00b6
        L_0x00b1:
            java.lang.String r2 = "network"
            goto L_0x00b6
        L_0x00b4:
            java.lang.String r2 = "io"
        L_0x00b6:
            java.lang.String r1 = "type"
            r0.put(r1, r2)
            java.lang.String r1 = r3.zzc
            java.lang.String r2 = "reason"
            r0.put(r2, r1)
            java.lang.String r1 = r3.zzd
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d1
            java.lang.String r1 = r3.zzd
            java.lang.String r2 = "message"
            r0.put(r2, r1)
        L_0x00d1:
            com.google.android.gms.internal.ads.zzckx r1 = r3.zze
            java.lang.String r2 = "onPrecacheEvent"
            com.google.android.gms.internal.ads.zzckx.zzo(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckw.run():void");
    }
}
