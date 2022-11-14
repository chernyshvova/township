package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzj extends zzi {
    public final byte[] zza;

    public zzj(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    public final byte[] zzc() {
        return this.zza;
    }
}
