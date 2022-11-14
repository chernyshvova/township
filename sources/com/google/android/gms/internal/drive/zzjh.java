package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;

public final class zzjh extends zzjm {
    public final int zznv;
    public final int zznw;

    public zzjh(byte[] bArr, int i, int i2) {
        super(bArr);
        zzjc.zzb(i, i + i2, bArr.length);
        this.zznv = i;
        this.zznw = i2;
    }

    public final int size() {
        return this.zznw;
    }

    public final int zzbw() {
        return this.zznv;
    }

    public final byte zzs(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzny[this.zznv + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline9(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline11(40, "Index > length: ", i, RESTClient.COMMA_SEPARATOR, size));
    }

    public final byte zzt(int i) {
        return this.zzny[this.zznv + i];
    }
}
