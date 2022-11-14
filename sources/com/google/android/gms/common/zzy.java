package com.google.android.gms.common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzy {
    @Nullable
    public String zza = null;
    public long zzb = -1;
    public zzu<byte[]> zzc = zzu.zzi();
    public zzu<byte[]> zzd = zzu.zzi();

    public final zzy zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzy zzb(long j) {
        this.zzb = j;
        return this;
    }

    public final zzy zzc(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzu.zzm(list);
        return this;
    }

    public final zzy zzd(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzu.zzm(list);
        return this;
    }

    public final zzz zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.zzc.isEmpty() || !this.zzd.isEmpty()) {
            return new zzz(this.zza, this.zzb, this.zzc, this.zzd, (zzx) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
