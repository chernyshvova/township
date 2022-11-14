package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyw extends zzst {
    public zzyw(zzale zzale, long j, long j2) {
        super(new zzso(), new zzyv(zzale, (zzyu) null), j, 0, j + 1, 0, j2, 188, 1000);
    }

    public static /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & Base64.EQUALS_SIGN_ENC) | ((bArr[i] & Base64.EQUALS_SIGN_ENC) << 24) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 16) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 8);
    }
}
