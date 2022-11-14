package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadq extends zzadf<Void> {
    public final zzadx zza;
    public final boolean zzb;
    public final zzmu zzc;
    public final zzms zzd;
    public zzado zze;
    @Nullable
    public zzadn zzf;
    public boolean zzg;
    public boolean zzh;
    public boolean zzi;

    public zzadq(zzadx zzadx, boolean z) {
        boolean z2;
        this.zza = zzadx;
        if (z) {
            zzadx.zzt();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzmu();
        this.zzd = new zzms();
        zzadx.zzs();
        this.zze = zzado.zzj(zzadx.zzz());
    }

    private final Object zzD(Object obj) {
        return (this.zze.zzf == null || !obj.equals(zzado.zzd)) ? obj : this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzE(long j) {
        zzadn zzadn = this.zzf;
        int zzh2 = this.zze.zzh(zzadn.zza.zza);
        if (zzh2 != -1) {
            zzado zzado = this.zze;
            zzms zzms = this.zzd;
            zzado.zzg(zzh2, zzms, false);
            long j2 = zzms.zzd;
            if (j2 != -9223372036854775807L && j >= j2) {
                j = Math.max(0, j2 - 1);
            }
            zzadn.zzp(j);
        }
    }

    public final void zzA(zzadt zzadt) {
        ((zzadn) zzadt).zzu();
        if (zzadt == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzB */
    public final zzadn zzC(zzadv zzadv, zzahy zzahy, long j) {
        zzadn zzadn = new zzadn(zzadv, zzahy, j, (byte[]) null);
        zzadn.zzs(this.zza);
        if (this.zzh) {
            zzadn.zzt(zzadv.zzc(zzD(zzadv.zza)));
        } else {
            this.zzf = zzadn;
            if (!this.zzg) {
                this.zzg = true;
                zzw(null, this.zza);
            }
        }
        return zzadn;
    }

    public final void zza(@Nullable zzajd zzajd) {
        super.zza(zzajd);
        if (!this.zzb) {
            this.zzg = true;
            zzw(null, this.zza);
        }
    }

    public final void zzd() {
        this.zzh = false;
        this.zzg = false;
        super.zzd();
    }

    public final void zzu() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzv(java.lang.Object r12, com.google.android.gms.internal.ads.zzadx r13, com.google.android.gms.internal.ads.zzmv r14) {
        /*
            r11 = this;
            java.lang.Void r12 = (java.lang.Void) r12
            boolean r12 = r11.zzh
            r13 = 0
            if (r12 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzado r12 = r11.zze
            com.google.android.gms.internal.ads.zzado r12 = r12.zzl(r14)
            r11.zze = r12
            com.google.android.gms.internal.ads.zzadn r12 = r11.zzf
            if (r12 == 0) goto L_0x001a
            long r0 = r12.zzr()
            r11.zzE(r0)
        L_0x001a:
            r12 = r13
            goto L_0x00a0
        L_0x001d:
            boolean r12 = r14.zzt()
            if (r12 == 0) goto L_0x0039
            boolean r12 = r11.zzi
            if (r12 == 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzado r12 = r11.zze
            com.google.android.gms.internal.ads.zzado r12 = r12.zzl(r14)
            goto L_0x0036
        L_0x002e:
            java.lang.Object r12 = com.google.android.gms.internal.ads.zzmu.zza
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzado.zzd
            com.google.android.gms.internal.ads.zzado r12 = com.google.android.gms.internal.ads.zzado.zzk(r14, r12, r0)
        L_0x0036:
            r11.zze = r12
            goto L_0x001a
        L_0x0039:
            com.google.android.gms.internal.ads.zzmu r12 = r11.zzc
            r0 = 0
            r1 = 0
            r14.zze(r0, r12, r1)
            com.google.android.gms.internal.ads.zzmu r12 = r11.zzc
            java.lang.Object r12 = r12.zzb
            com.google.android.gms.internal.ads.zzadn r3 = r11.zzf
            if (r3 == 0) goto L_0x0067
            long r3 = r3.zza()
            com.google.android.gms.internal.ads.zzado r5 = r11.zze
            com.google.android.gms.internal.ads.zzadn r6 = r11.zzf
            com.google.android.gms.internal.ads.zzadv r6 = r6.zza
            java.lang.Object r6 = r6.zza
            com.google.android.gms.internal.ads.zzms r7 = r11.zzd
            r5.zzf(r6, r7)
            com.google.android.gms.internal.ads.zzado r5 = r11.zze
            com.google.android.gms.internal.ads.zzmu r6 = r11.zzc
            r5.zze(r0, r6, r1)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0067
            r9 = r3
            goto L_0x0068
        L_0x0067:
            r9 = r1
        L_0x0068:
            com.google.android.gms.internal.ads.zzmu r6 = r11.zzc
            com.google.android.gms.internal.ads.zzms r7 = r11.zzd
            r8 = 0
            r5 = r14
            android.util.Pair r0 = r5.zzv(r6, r7, r8, r9)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            boolean r0 = r11.zzi
            if (r0 == 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzado r12 = r11.zze
            com.google.android.gms.internal.ads.zzado r12 = r12.zzl(r14)
            goto L_0x008b
        L_0x0087:
            com.google.android.gms.internal.ads.zzado r12 = com.google.android.gms.internal.ads.zzado.zzk(r14, r12, r1)
        L_0x008b:
            r11.zze = r12
            com.google.android.gms.internal.ads.zzadn r12 = r11.zzf
            if (r12 == 0) goto L_0x001a
            r11.zzE(r2)
            com.google.android.gms.internal.ads.zzadv r12 = r12.zza
            java.lang.Object r14 = r12.zza
            java.lang.Object r14 = r11.zzD(r14)
            com.google.android.gms.internal.ads.zzadv r12 = r12.zzc(r14)
        L_0x00a0:
            r14 = 1
            r11.zzi = r14
            r11.zzh = r14
            com.google.android.gms.internal.ads.zzado r14 = r11.zze
            r11.zze(r14)
            if (r12 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzadn r14 = r11.zzf
            if (r14 == 0) goto L_0x00b4
            r14.zzt(r12)
            return
        L_0x00b4:
            throw r13
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadq.zzv(java.lang.Object, com.google.android.gms.internal.ads.zzadx, com.google.android.gms.internal.ads.zzmv):void");
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zzadv zzx(Object obj, zzadv zzadv) {
        Void voidR = (Void) obj;
        Object obj2 = zzadv.zza;
        if (this.zze.zzf != null && this.zze.zzf.equals(obj2)) {
            obj2 = zzado.zzd;
        }
        return zzadv.zzc(obj2);
    }

    public final zzmv zzy() {
        return this.zze;
    }

    public final zzkq zzz() {
        return this.zza.zzz();
    }
}
