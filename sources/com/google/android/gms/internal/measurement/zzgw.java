package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgw extends zzgz {
    public final int zzc;
    public final int zzd;

    public zzgw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgp.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline9(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline11(40, "Index > length: ", i, RESTClient.COMMA_SEPARATOR, zza));
    }

    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    public final int zze() {
        return this.zzc;
    }

    public final int zza() {
        return this.zzd;
    }
}
