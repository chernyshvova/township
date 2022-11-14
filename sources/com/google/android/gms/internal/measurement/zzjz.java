package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjz implements zzjh {
    public final zzjj zza;
    public final String zzb;
    public final Object[] zzc;
    public final int zzd;

    public zzjz(zzjj zzjj, String str, Object[] objArr) {
        this.zza = zzjj;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.zzd = c | (charAt2 << i);
                return;
            }
        }
    }

    public final int zza() {
        return (this.zzd & 1) == 1 ? zzju.zza : zzju.zzb;
    }

    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    public final zzjj zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
