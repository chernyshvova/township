package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafa extends zzacx implements zzaes {
    public final zzkq zza;
    public final zzkp zzb;
    public final zzahs zzc;
    public final zzaem zzd;
    public final zzsi zze;
    public final int zzf;
    public boolean zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    @Nullable
    public zzajd zzk;
    public final zzaih zzl;

    public /* synthetic */ zzafa(zzkq zzkq, zzahs zzahs, zzaem zzaem, zzsi zzsi, zzaih zzaih, int i, zzaex zzaex, byte[] bArr) {
        zzkp zzkp = zzkq.zzb;
        if (zzkp != null) {
            this.zzb = zzkp;
            this.zza = zzkq;
            this.zzc = zzahs;
            this.zzd = zzaem;
            this.zze = zzsi;
            this.zzl = zzaih;
            this.zzf = i;
            this.zzg = true;
            this.zzh = -9223372036854775807L;
            return;
        }
        throw null;
    }

    private final void zzv() {
        long j = this.zzh;
        boolean z = this.zzi;
        boolean z2 = this.zzj;
        zzkq zzkq = this.zza;
        zzafn zzafn = r1;
        zzafn zzafn2 = new zzafn(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0, 0, z, false, (Object) null, zzkq, z2 ? zzkq.zzc : null);
        zze(this.zzg ? new zzaex(this, zzafn) : zzafn);
    }

    public final void zzA(zzadt zzadt) {
        ((zzaew) zzadt).zzj();
    }

    public final zzadt zzC(zzadv zzadv, zzahy zzahy, long j) {
        zzaht zza2 = this.zzc.zza();
        zzajd zzajd = this.zzk;
        if (zzajd != null) {
            zza2.zzb(zzajd);
        }
        Uri uri = this.zzb.zza;
        zzaen zza3 = this.zzd.zza();
        zzsi zzsi = this.zze;
        zzsd zzh2 = zzh(zzadv);
        zzaih zzaih = this.zzl;
        zzaee zzf2 = zzf(zzadv);
        String str = this.zzb.zzf;
        return new zzaew(uri, zza2, zza3, zzsi, zzh2, zzaih, zzf2, this, zzahy, (String) null, this.zzf, (byte[]) null);
    }

    public final void zza(@Nullable zzajd zzajd) {
        this.zzk = zzajd;
        zzv();
    }

    public final void zzb(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.zzh;
        }
        if (this.zzg || this.zzh != j || this.zzi != z || this.zzj != z2) {
            this.zzh = j;
            this.zzi = z;
            this.zzj = z2;
            this.zzg = false;
            zzv();
        }
    }

    public final void zzd() {
    }

    public final void zzu() {
    }

    public final zzkq zzz() {
        return this.zza;
    }
}
