package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadb implements zzadt, zzads {
    public final zzadt zza;
    public long zzb;
    @Nullable
    public zzads zzc;
    public zzada[] zzd = new zzada[0];
    public long zze = 0;

    public zzadb(zzadt zzadt, boolean z, long j, long j2) {
        this.zza = zzadt;
        this.zzb = j2;
    }

    public final void zza(long j, long j2) {
        this.zzb = j2;
    }

    public final void zzb(zzads zzads, long j) {
        this.zzc = zzads;
        this.zza.zzb(this, j);
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final zzaft zzd() {
        return this.zza.zzd();
    }

    public final void zze(long j, boolean z) {
        this.zza.zze(j, false);
    }

    public final void zzf(long j) {
        this.zza.zzf(j);
    }

    public final long zzg() {
        if (zzp()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long zzg = zzg();
            return zzg != -9223372036854775807L ? zzg : j;
        }
        long zzg2 = this.zza.zzg();
        if (zzg2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = false;
        zzajg.zzd(zzg2 >= 0);
        long j2 = this.zzb;
        if (j2 == Long.MIN_VALUE || zzg2 <= j2) {
            z = true;
        }
        zzajg.zzd(z);
        return zzg2;
    }

    public final long zzh() {
        long zzh = this.zza.zzh();
        if (zzh != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzh < j) {
                return zzh;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 > r8) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzi(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zzada[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.zza()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.gms.internal.ads.zzadt r0 = r7.zza
            long r0 = r0.zzi(r8)
            r3 = 1
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0036
            long r8 = r7.zzb
            r4 = -9223372036854775808
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0035
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            com.google.android.gms.internal.ads.zzajg.zzd(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadb.zzi(long):long");
    }

    public final void zzj(zzadt zzadt) {
        zzads zzads = this.zzc;
        if (zzads != null) {
            zzads.zzj(this);
            return;
        }
        throw null;
    }

    public final long zzk(long j, zzme zzme) {
        if (j == 0) {
            return 0;
        }
        long zzy = zzalh.zzy(zzme.zzf, 0, j);
        long j2 = zzme.zzg;
        long j3 = this.zzb;
        long zzy2 = zzalh.zzy(j2, 0, j3 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j3 - j);
        if (!(zzy == zzme.zzf && zzy2 == zzme.zzg)) {
            zzme = new zzme(zzy, zzy2);
        }
        return this.zza.zzk(j, zzme);
    }

    public final long zzl() {
        long zzl = this.zza.zzl();
        if (zzl != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzl < j) {
                return zzl;
            }
        }
        return Long.MIN_VALUE;
    }

    public final /* bridge */ /* synthetic */ void zzm(zzafl zzafl) {
        zzadt zzadt = (zzadt) zzafl;
        zzads zzads = this.zzc;
        if (zzads != null) {
            zzads.zzm(this);
            return;
        }
        throw null;
    }

    public final boolean zzn(long j) {
        return this.zza.zzn(j);
    }

    public final boolean zzo() {
        return this.zza.zzo();
    }

    public final boolean zzp() {
        return this.zze != -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r4 > r7) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzq(com.google.android.gms.internal.ads.zzagf[] r14, boolean[] r15, com.google.android.gms.internal.ads.zzafj[] r16, boolean[] r17, long r18) {
        /*
            r13 = this;
            r0 = r13
            r1 = r16
            int r2 = r1.length
            com.google.android.gms.internal.ads.zzada[] r3 = new com.google.android.gms.internal.ads.zzada[r2]
            r0.zzd = r3
            com.google.android.gms.internal.ads.zzafj[] r2 = new com.google.android.gms.internal.ads.zzafj[r2]
            r3 = 0
            r4 = 0
        L_0x000c:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L_0x0021
            com.google.android.gms.internal.ads.zzada[] r5 = r0.zzd
            r6 = r1[r4]
            com.google.android.gms.internal.ads.zzada r6 = (com.google.android.gms.internal.ads.zzada) r6
            r5[r4] = r6
            if (r6 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzafj r11 = r6.zza
        L_0x001c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0021:
            com.google.android.gms.internal.ads.zzadt r4 = r0.zza
            r5 = r14
            r6 = r15
            r7 = r2
            r8 = r17
            r9 = r18
            long r4 = r4.zzq(r5, r6, r7, r8, r9)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zze = r6
            r6 = 1
            int r7 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r7 == 0) goto L_0x004e
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x004d
            long r7 = r0.zzb
            r9 = -9223372036854775808
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x004e
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r6 = 0
        L_0x004e:
            com.google.android.gms.internal.ads.zzajg.zzd(r6)
        L_0x0051:
            int r6 = r1.length
            if (r3 >= r6) goto L_0x0077
            r6 = r2[r3]
            if (r6 != 0) goto L_0x005d
            com.google.android.gms.internal.ads.zzada[] r6 = r0.zzd
            r6[r3] = r11
            goto L_0x006e
        L_0x005d:
            com.google.android.gms.internal.ads.zzada[] r7 = r0.zzd
            r8 = r7[r3]
            if (r8 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzafj r8 = r8.zza
            if (r8 == r6) goto L_0x006e
        L_0x0067:
            com.google.android.gms.internal.ads.zzada r8 = new com.google.android.gms.internal.ads.zzada
            r8.<init>(r13, r6)
            r7[r3] = r8
        L_0x006e:
            com.google.android.gms.internal.ads.zzada[] r6 = r0.zzd
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x0051
        L_0x0077:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadb.zzq(com.google.android.gms.internal.ads.zzagf[], boolean[], com.google.android.gms.internal.ads.zzafj[], boolean[], long):long");
    }
}
