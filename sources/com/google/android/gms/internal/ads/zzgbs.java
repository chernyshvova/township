package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbs implements zzfvb {
    public final ThreadLocal<Mac> zza = new zzgbr(this);
    public final String zzb;
    public final Key zzc;
    public final int zzd;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgbs(java.lang.String r5, java.security.Key r6) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            r4.<init>()
            com.google.android.gms.internal.ads.zzgbr r0 = new com.google.android.gms.internal.ads.zzgbr
            r0.<init>(r4)
            r4.zza = r0
            r4.zzb = r5
            r4.zzc = r6
            byte[] r6 = r6.getEncoded()
            int r6 = r6.length
            r0 = 16
            if (r6 < r0) goto L_0x0090
            int r6 = r5.hashCode()
            r0 = 4
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r6) {
                case -1823053428: goto L_0x004b;
                case 392315023: goto L_0x0041;
                case 392315118: goto L_0x0037;
                case 392316170: goto L_0x002d;
                case 392317873: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0055
        L_0x0023:
            java.lang.String r6 = "HMACSHA512"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = 4
            goto L_0x0056
        L_0x002d:
            java.lang.String r6 = "HMACSHA384"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = 3
            goto L_0x0056
        L_0x0037:
            java.lang.String r6 = "HMACSHA256"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = 2
            goto L_0x0056
        L_0x0041:
            java.lang.String r6 = "HMACSHA224"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = 1
            goto L_0x0056
        L_0x004b:
            java.lang.String r6 = "HMACSHA1"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = 0
            goto L_0x0056
        L_0x0055:
            r6 = -1
        L_0x0056:
            if (r6 == 0) goto L_0x0086
            if (r6 == r3) goto L_0x0083
            if (r6 == r2) goto L_0x0080
            if (r6 == r1) goto L_0x007d
            if (r6 == r0) goto L_0x0078
            java.security.NoSuchAlgorithmException r6 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            int r1 = r5.length()
            if (r1 == 0) goto L_0x006f
            java.lang.String r5 = r0.concat(r5)
            goto L_0x0074
        L_0x006f:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
        L_0x0074:
            r6.<init>(r5)
            throw r6
        L_0x0078:
            r5 = 64
            r4.zzd = r5
            goto L_0x008a
        L_0x007d:
            r5 = 48
            goto L_0x0088
        L_0x0080:
            r5 = 32
            goto L_0x0088
        L_0x0083:
            r5 = 28
            goto L_0x0088
        L_0x0086:
            r5 = 20
        L_0x0088:
            r4.zzd = r5
        L_0x008a:
            java.lang.ThreadLocal<javax.crypto.Mac> r5 = r4.zza
            r5.get()
            return
        L_0x0090:
            java.security.InvalidAlgorithmParameterException r5 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r6 = "key size too small, need at least 16 bytes"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbs.<init>(java.lang.String, java.security.Key):void");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.zzd) {
            this.zza.get().update(bArr);
            return Arrays.copyOf(this.zza.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
