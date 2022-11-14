package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkt {
    @Nullable
    public CharSequence zza;
    @Nullable
    public CharSequence zzb;
    @Nullable
    public CharSequence zzc;
    @Nullable
    public CharSequence zzd;
    @Nullable
    public byte[] zze;
    @Nullable
    public Integer zzf;
    @Nullable
    public Integer zzg;

    public zzkt() {
    }

    public /* synthetic */ zzkt(zzku zzku, zzks zzks) {
        this.zza = zzku.zzb;
        this.zzb = zzku.zzc;
        this.zzc = zzku.zzd;
        this.zzd = zzku.zze;
        this.zze = zzku.zzf;
        this.zzf = zzku.zzg;
        this.zzg = zzku.zzh;
    }

    public final zzkt zza(@Nullable CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzkt zzb(@Nullable CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzkt zzc(@Nullable CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzkt zzd(@Nullable CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzkt zze(@Nullable byte[] bArr) {
        this.zze = bArr == null ? null : (byte[]) bArr.clone();
        return this;
    }

    public final zzkt zzf(@Nullable Integer num) {
        this.zzf = num;
        return this;
    }

    public final zzkt zzg(@Nullable Integer num) {
        this.zzg = num;
        return this;
    }
}
