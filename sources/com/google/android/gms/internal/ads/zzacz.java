package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacz implements zzaen {
    public final zztg zza;
    @Nullable
    public zzta zzb;
    @Nullable
    public zztb zzc;

    public zzacz(zztg zztg) {
        this.zza = zztg;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r0.zzn() != r11) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
        if (r0.zzn() != r11) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzahq r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.gms.internal.ads.zztd r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzsx r6 = new com.google.android.gms.internal.ads.zzsx
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzta r8 = r7.zzb
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.gms.internal.ads.zztg r8 = r7.zza
            com.google.android.gms.internal.ads.zzta[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.zzb = r8
            goto L_0x007f
        L_0x0020:
            r14 = 0
        L_0x0021:
            if (r14 >= r10) goto L_0x007b
            r0 = r8[r14]
            boolean r1 = r0.zzd(r6)     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            if (r1 == 0) goto L_0x003f
            r7.zzb = r0     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            if (r0 != 0) goto L_0x0037
            long r0 = r6.zzn()
            int r10 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x0038
        L_0x0037:
            r13 = 1
        L_0x0038:
            com.google.android.gms.internal.ads.zzajg.zzd(r13)
            r6.zzl()
            goto L_0x007b
        L_0x003f:
            com.google.android.gms.internal.ads.zzta r0 = r7.zzb
            if (r0 != 0) goto L_0x0071
            long r0 = r6.zzn()
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            goto L_0x0071
        L_0x004c:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzta r9 = r7.zzb
            if (r9 != 0) goto L_0x0059
            long r9 = r6.zzn()
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x005a
        L_0x0059:
            r13 = 1
        L_0x005a:
            com.google.android.gms.internal.ads.zzajg.zzd(r13)
            r6.zzl()
            throw r8
        L_0x0061:
            com.google.android.gms.internal.ads.zzta r0 = r7.zzb
            if (r0 != 0) goto L_0x0071
            long r0 = r6.zzn()
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r0 = 0
            goto L_0x0072
        L_0x0071:
            r0 = 1
        L_0x0072:
            com.google.android.gms.internal.ads.zzajg.zzd(r0)
            r6.zzl()
            int r14 = r14 + 1
            goto L_0x0021
        L_0x007b:
            com.google.android.gms.internal.ads.zzta r10 = r7.zzb
            if (r10 == 0) goto L_0x0085
        L_0x007f:
            com.google.android.gms.internal.ads.zzta r8 = r7.zzb
            r8.zze(r15)
            return
        L_0x0085:
            com.google.android.gms.internal.ads.zzafu r10 = new com.google.android.gms.internal.ads.zzafu
            java.lang.String r8 = com.google.android.gms.internal.ads.zzalh.zzK(r8)
            java.lang.String r11 = java.lang.String.valueOf(r8)
            int r11 = r11.length()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            int r11 = r11 + 58
            r12.<init>(r11)
            java.lang.String r11 = "None of the available extractors ("
            java.lang.String r13 = ") could read the stream."
            java.lang.String r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline19(r12, r11, r8, r13)
            r10.<init>(r8, r9)
            goto L_0x00a7
        L_0x00a6:
            throw r10
        L_0x00a7:
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacz.zza(com.google.android.gms.internal.ads.zzahq, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zztd):void");
    }

    public final void zzb() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzc() {
        zzta zzta = this.zzb;
        if (zzta instanceof zzvs) {
            ((zzvs) zzta).zza();
        }
    }

    public final long zzd() {
        zztb zztb = this.zzc;
        if (zztb != null) {
            return zztb.zzn();
        }
        return -1;
    }

    public final void zze(long j, long j2) {
        zzta zzta = this.zzb;
        if (zzta != null) {
            zzta.zzg(j, j2);
            return;
        }
        throw null;
    }

    public final int zzf(zzts zzts) throws IOException {
        zzta zzta = this.zzb;
        if (zzta != null) {
            zztb zztb = this.zzc;
            if (zztb != null) {
                return zzta.zzf(zztb, zzts);
            }
            throw null;
        }
        throw null;
    }
}
