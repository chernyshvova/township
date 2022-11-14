package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzku {
    public static final zzku zza = new zzku(new zzkt());
    public static final zzif<zzku> zzi = zzkr.zza;
    @Nullable
    public final CharSequence zzb;
    @Nullable
    public final CharSequence zzc;
    @Nullable
    public final CharSequence zzd;
    @Nullable
    public final CharSequence zze;
    @Nullable
    public final byte[] zzf;
    @Nullable
    public final Integer zzg;
    @Nullable
    public final Integer zzh;

    public zzku(zzkt zzkt) {
        this.zzb = zzkt.zza;
        this.zzc = zzkt.zzb;
        this.zzd = zzkt.zzc;
        this.zze = zzkt.zzd;
        this.zzf = zzkt.zze;
        this.zzg = zzkt.zzf;
        this.zzh = zzkt.zzg;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzku.class == obj.getClass()) {
            zzku zzku = (zzku) obj;
            return zzalh.zzc(this.zzb, zzku.zzb) && zzalh.zzc(this.zzc, zzku.zzc) && zzalh.zzc(this.zzd, zzku.zzd) && zzalh.zzc(this.zze, zzku.zze) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null) && Arrays.equals(this.zzf, zzku.zzf) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc(this.zzg, zzku.zzg) && zzalh.zzc(this.zzh, zzku.zzh) && zzalh.zzc((Object) null, (Object) null) && zzalh.zzc((Object) null, (Object) null);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zze, null, null, null, null, null, null, Integer.valueOf(Arrays.hashCode(this.zzf)), null, this.zzg, this.zzh, null, null});
    }
}
