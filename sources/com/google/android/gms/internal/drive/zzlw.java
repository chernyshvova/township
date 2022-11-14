package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class zzlw<T> implements zzmf<T> {
    public final zzlq zzuh;
    public final boolean zzui;
    public final zzmx<?, ?> zzur;
    public final zzjy<?> zzus;

    public zzlw(zzmx<?, ?> zzmx, zzjy<?> zzjy, zzlq zzlq) {
        this.zzur = zzmx;
        this.zzui = zzjy.zze(zzlq);
        this.zzus = zzjy;
        this.zzuh = zzlq;
    }

    public static <T> zzlw<T> zza(zzmx<?, ?> zzmx, zzjy<?> zzjy, zzlq zzlq) {
        return new zzlw<>(zzmx, zzjy, zzlq);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
            return false;
        }
        if (this.zzui) {
            return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzur.zzr(t).hashCode();
        return this.zzui ? (hashCode * 53) + this.zzus.zzb(t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzuh.zzcz().zzde();
    }

    public final void zzc(T t, T t2) {
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    public final void zzd(T t) {
        this.zzur.zzd(t);
        this.zzus.zzd(t);
    }

    public final int zzn(T t) {
        zzmx<?, ?> zzmx = this.zzur;
        int zzs = zzmx.zzs(zzmx.zzr(t)) + 0;
        return this.zzui ? zzs + this.zzus.zzb(t).zzco() : zzs;
    }

    public final boolean zzp(T t) {
        return this.zzus.zzb(t).isInitialized();
    }

    public final void zza(T t, zzns zzns) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzus.zzb(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzkd zzkd = (zzkd) next.getKey();
            if (zzkd.zzcr() != zznr.MESSAGE || zzkd.zzcs() || zzkd.zzct()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzkv) {
                zzns.zza(zzkd.zzcp(), (Object) ((zzkv) next).zzdq().zzbl());
            } else {
                zzns.zza(zzkd.zzcp(), next.getValue());
            }
        }
        zzmx<?, ?> zzmx = this.zzur;
        zzmx.zzc(zzmx.zzr(t), zzns);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.drive.zzkk$zzd} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.drive.zziz r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.drive.zzkk r0 = (com.google.android.gms.internal.drive.zzkk) r0
            com.google.android.gms.internal.drive.zzmy r1 = r0.zzrq
            com.google.android.gms.internal.drive.zzmy r2 = com.google.android.gms.internal.drive.zzmy.zzfa()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.drive.zzmy r1 = com.google.android.gms.internal.drive.zzmy.zzfb()
            r0.zzrq = r1
        L_0x0011:
            com.google.android.gms.internal.drive.zzkk$zzc r10 = (com.google.android.gms.internal.drive.zzkk.zzc) r10
            r10.zzdg()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r11, r12, r14)
            int r2 = r14.zznk
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.drive.zzjy<?> r12 = r9.zzus
            com.google.android.gms.internal.drive.zzjx r0 = r14.zznn
            com.google.android.gms.internal.drive.zzlq r3 = r9.zzuh
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.drive.zzkk$zzd r0 = (com.google.android.gms.internal.drive.zzkk.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.drive.zziy.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.drive.zzmy) r6, (com.google.android.gms.internal.drive.zziz) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.drive.zzmd.zzej()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.drive.zziy.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.drive.zziz) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r11, r4, r14)
            int r5 = r14.zznk
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.drive.zziy.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zznm
            com.google.android.gms.internal.drive.zzjc r2 = (com.google.android.gms.internal.drive.zzjc) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.drive.zzmd.zzej()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.drive.zziy.zza(r11, r4, r14)
            int r12 = r14.zznk
            com.google.android.gms.internal.drive.zzjy<?> r0 = r9.zzus
            com.google.android.gms.internal.drive.zzjx r5 = r14.zznn
            com.google.android.gms.internal.drive.zzlq r6 = r9.zzuh
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.drive.zzkk$zzd r0 = (com.google.android.gms.internal.drive.zzkk.zzd) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.drive.zziy.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.drive.zziz) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzb(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.drive.zzkq r10 = com.google.android.gms.internal.drive.zzkq.zzdm()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlw.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.drive.zziz):void");
    }
}
