package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzjn extends zzid implements zzir {
    public int zzA;
    public long zzB;
    public zzafm zzC;
    public final zzahd zzb;
    public final zzlp zzc;
    public final zzma[] zzd;
    public final zzahc zze;
    public final zzajt zzf;
    public final zzjv zzg;
    public final zzjx zzh;
    public final zzajz<zzlq> zzi;
    public final CopyOnWriteArraySet<zzip> zzj;
    public final zzms zzk;
    public final List<zzjm> zzl;
    public final boolean zzm;
    public final zzaeg zzn;
    @Nullable
    public final zzou zzo;
    public final Looper zzp;
    public final zzahl zzq;
    public final zzajh zzr;
    public int zzs;
    public int zzt;
    public boolean zzu;
    public int zzv;
    public zzme zzw;
    public zzlp zzx;
    public zzku zzy;
    public zzlj zzz;

    /* JADX WARNING: type inference failed for: r35v0, types: [com.google.android.gms.internal.ads.zzlu] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzjn(com.google.android.gms.internal.ads.zzma[] r21, com.google.android.gms.internal.ads.zzahc r22, com.google.android.gms.internal.ads.zzaeg r23, com.google.android.gms.internal.ads.zzkf r24, com.google.android.gms.internal.ads.zzahl r25, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzou r26, boolean r27, com.google.android.gms.internal.ads.zzme r28, com.google.android.gms.internal.ads.zzij r29, long r30, boolean r32, com.google.android.gms.internal.ads.zzajh r33, android.os.Looper r34, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzlu r35, com.google.android.gms.internal.ads.zzlp r36, byte[] r37) {
        /*
            r20 = this;
            r0 = r20
            r2 = r21
            r3 = r22
            r6 = r25
            r9 = r26
            r15 = r33
            r11 = r34
            r20.<init>()
            int r1 = java.lang.System.identityHashCode(r20)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            java.lang.String r4 = com.google.android.gms.internal.ads.zzalh.zze
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r5 = r5 + 30
            int r5 = r5 + r7
            r8.<init>(r5)
            java.lang.String r5 = "Init "
            java.lang.String r7 = " [ExoPlayerLib/2.14.0] ["
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r8, r5, r1, r7, r4)
            java.lang.String r1 = "]"
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.String r4 = "ExoPlayerImpl"
            android.util.Log.i(r4, r1)
            int r1 = r2.length
            r0.zzd = r2
            r1 = 0
            if (r3 == 0) goto L_0x012a
            r0.zze = r3
            r4 = r23
            r0.zzn = r4
            r0.zzq = r6
            r0.zzo = r9
            r4 = 1
            r0.zzm = r4
            r10 = r28
            r0.zzw = r10
            r0.zzp = r11
            r0.zzr = r15
            if (r35 == 0) goto L_0x0068
            r4 = r35
            goto L_0x0069
        L_0x0068:
            r4 = r0
        L_0x0069:
            com.google.android.gms.internal.ads.zzajz r5 = new com.google.android.gms.internal.ads.zzajz
            com.google.android.gms.internal.ads.zzis r7 = new com.google.android.gms.internal.ads.zzis
            r7.<init>(r4)
            r5.<init>(r11, r15, r7)
            r0.zzi = r5
            java.util.concurrent.CopyOnWriteArraySet r5 = new java.util.concurrent.CopyOnWriteArraySet
            r5.<init>()
            r0.zzj = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0.zzl = r5
            com.google.android.gms.internal.ads.zzafm r5 = new com.google.android.gms.internal.ads.zzafm
            r7 = 0
            r5.<init>(r7)
            r0.zzC = r5
            com.google.android.gms.internal.ads.zzahd r5 = new com.google.android.gms.internal.ads.zzahd
            r7 = 2
            com.google.android.gms.internal.ads.zzmc[] r8 = new com.google.android.gms.internal.ads.zzmc[r7]
            com.google.android.gms.internal.ads.zzagf[] r7 = new com.google.android.gms.internal.ads.zzagf[r7]
            r5.<init>(r8, r7, r1, r1)
            r0.zzb = r5
            com.google.android.gms.internal.ads.zzms r5 = new com.google.android.gms.internal.ads.zzms
            r5.<init>()
            r0.zzk = r5
            com.google.android.gms.internal.ads.zzlo r5 = new com.google.android.gms.internal.ads.zzlo
            r5.<init>()
            r7 = 10
            int[] r7 = new int[r7]
            r7 = {1, 2, 8, 9, 10, 11, 12, 13, 14, 15} // fill-array
            r5.zzc(r7)
            r7 = r36
            r5.zzd(r7)
            com.google.android.gms.internal.ads.zzlp r5 = r5.zze()
            r0.zzc = r5
            com.google.android.gms.internal.ads.zzlo r5 = new com.google.android.gms.internal.ads.zzlo
            r5.<init>()
            com.google.android.gms.internal.ads.zzlp r7 = r0.zzc
            r5.zzd(r7)
            r7 = 3
            r5.zza(r7)
            r7 = 7
            r5.zza(r7)
            com.google.android.gms.internal.ads.zzlp r5 = r5.zze()
            r0.zzx = r5
            com.google.android.gms.internal.ads.zzku r5 = com.google.android.gms.internal.ads.zzku.zza
            r0.zzy = r5
            r5 = -1
            r0.zzA = r5
            com.google.android.gms.internal.ads.zzajt r1 = r15.zza(r11, r1)
            r0.zzf = r1
            com.google.android.gms.internal.ads.zzjd r1 = new com.google.android.gms.internal.ads.zzjd
            r1.<init>(r0)
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzahd r1 = r0.zzb
            com.google.android.gms.internal.ads.zzlj r1 = com.google.android.gms.internal.ads.zzlj.zza(r1)
            r0.zzz = r1
            if (r9 == 0) goto L_0x00fe
            r9.zzP(r4, r11)
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r1 = r0.zzi
            r1.zzb(r9)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>(r11)
            r6.zza(r1, r9)
        L_0x00fe:
            com.google.android.gms.internal.ads.zzjx r5 = new com.google.android.gms.internal.ads.zzjx
            r1 = r5
            com.google.android.gms.internal.ads.zzahd r4 = r0.zzb
            r8 = 0
            r12 = 500(0x1f4, double:2.47E-321)
            r14 = 0
            com.google.android.gms.internal.ads.zzjv r7 = r0.zzg
            r17 = r7
            r18 = 0
            r7 = 0
            r2 = r21
            r3 = r22
            r19 = r5
            r5 = r24
            r6 = r25
            r9 = r26
            r10 = r28
            r11 = r29
            r15 = r34
            r16 = r33
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r1 = r19
            r0.zzh = r1
            return
        L_0x012a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjn.<init>(com.google.android.gms.internal.ads.zzma[], com.google.android.gms.internal.ads.zzahc, com.google.android.gms.internal.ads.zzaeg, com.google.android.gms.internal.ads.zzkf, com.google.android.gms.internal.ads.zzahl, com.google.android.gms.internal.ads.zzou, boolean, com.google.android.gms.internal.ads.zzme, com.google.android.gms.internal.ads.zzij, long, boolean, com.google.android.gms.internal.ads.zzajh, android.os.Looper, com.google.android.gms.internal.ads.zzlu, com.google.android.gms.internal.ads.zzlp, byte[]):void");
    }

    private final int zzG() {
        if (this.zzz.zza.zzt()) {
            return this.zzA;
        }
        zzlj zzlj = this.zzz;
        return zzlj.zza.zzf(zzlj.zzb.zza, this.zzk).zzc;
    }

    private final long zzH(zzlj zzlj) {
        if (zzlj.zza.zzt()) {
            return zzig.zzb(this.zzB);
        }
        if (zzlj.zzb.zzb()) {
            return zzlj.zzs;
        }
        zzmv zzmv = zzlj.zza;
        zzadv zzadv = zzlj.zzb;
        long j = zzlj.zzs;
        zzM(zzmv, zzadv, j);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0252  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzI(com.google.android.gms.internal.ads.zzlj r40, int r41, int r42, boolean r43, boolean r44, int r45, long r46, int r48) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            r2 = r45
            com.google.android.gms.internal.ads.zzlj r3 = r0.zzz
            r0.zzz = r1
            com.google.android.gms.internal.ads.zzmv r4 = r3.zza
            com.google.android.gms.internal.ads.zzmv r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzmv r6 = r3.zza
            com.google.android.gms.internal.ads.zzmv r7 = r1.zza
            boolean r8 = r7.zzt()
            r10 = 3
            r11 = 0
            r13 = -1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            r15 = 0
            if (r8 == 0) goto L_0x0036
            boolean r8 = r6.zzt()
            if (r8 == 0) goto L_0x0036
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r4.<init>(r6, r14)
            goto L_0x00c0
        L_0x0036:
            boolean r8 = r7.zzt()
            boolean r9 = r6.zzt()
            if (r8 == r9) goto L_0x004d
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r4.<init>(r6, r7)
            goto L_0x00c0
        L_0x004d:
            com.google.android.gms.internal.ads.zzadv r8 = r3.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzms r9 = r0.zzk
            com.google.android.gms.internal.ads.zzms r8 = r6.zzf(r8, r9)
            int r8 = r8.zzc
            com.google.android.gms.internal.ads.zzmu r9 = r0.zza
            com.google.android.gms.internal.ads.zzmu r6 = r6.zze(r8, r9, r11)
            java.lang.Object r6 = r6.zzb
            com.google.android.gms.internal.ads.zzadv r8 = r1.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzms r9 = r0.zzk
            com.google.android.gms.internal.ads.zzms r8 = r7.zzf(r8, r9)
            int r8 = r8.zzc
            com.google.android.gms.internal.ads.zzmu r9 = r0.zza
            com.google.android.gms.internal.ads.zzmu r7 = r7.zze(r8, r9, r11)
            java.lang.Object r7 = r7.zzb
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x009d
            if (r44 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0081
            r4 = 1
            goto L_0x008a
        L_0x0081:
            if (r44 == 0) goto L_0x0087
            if (r2 != r5) goto L_0x0087
            r4 = 2
            goto L_0x008a
        L_0x0087:
            if (r4 == 0) goto L_0x0097
            r4 = 3
        L_0x008a:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.<init>(r7, r4)
            r4 = r6
            goto L_0x00c0
        L_0x0097:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x009d:
            if (r44 == 0) goto L_0x00b9
            if (r2 != 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzadv r4 = r3.zzb
            long r6 = r4.zzd
            com.google.android.gms.internal.ads.zzadv r4 = r1.zzb
            long r8 = r4.zzd
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b9
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            r4.<init>(r6, r7)
            goto L_0x00c0
        L_0x00b9:
            android.util.Pair r4 = new android.util.Pair
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r4.<init>(r6, r14)
        L_0x00c0:
            java.lang.Object r6 = r4.first
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            java.lang.Object r4 = r4.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzku r7 = r0.zzy
            r8 = 0
            if (r6 == 0) goto L_0x0101
            com.google.android.gms.internal.ads.zzmv r9 = r1.zza
            boolean r9 = r9.zzt()
            if (r9 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzmv r9 = r1.zza
            com.google.android.gms.internal.ads.zzadv r14 = r1.zzb
            java.lang.Object r14 = r14.zza
            com.google.android.gms.internal.ads.zzms r10 = r0.zzk
            com.google.android.gms.internal.ads.zzms r9 = r9.zzf(r14, r10)
            int r9 = r9.zzc
            com.google.android.gms.internal.ads.zzmv r10 = r1.zza
            com.google.android.gms.internal.ads.zzmu r14 = r0.zza
            com.google.android.gms.internal.ads.zzmu r9 = r10.zze(r9, r14, r11)
            com.google.android.gms.internal.ads.zzkq r9 = r9.zzc
            goto L_0x00f7
        L_0x00f6:
            r9 = r8
        L_0x00f7:
            if (r9 == 0) goto L_0x00fc
            com.google.android.gms.internal.ads.zzku r10 = r9.zzd
            goto L_0x00fe
        L_0x00fc:
            com.google.android.gms.internal.ads.zzku r10 = com.google.android.gms.internal.ads.zzku.zza
        L_0x00fe:
            r0.zzy = r10
            goto L_0x0102
        L_0x0101:
            r9 = r8
        L_0x0102:
            java.util.List<com.google.android.gms.internal.ads.zzabe> r10 = r3.zzj
            java.util.List<com.google.android.gms.internal.ads.zzabe> r14 = r1.zzj
            boolean r10 = r10.equals(r14)
            if (r10 != 0) goto L_0x013b
            com.google.android.gms.internal.ads.zzkt r10 = new com.google.android.gms.internal.ads.zzkt
            r10.<init>(r7, r8)
            java.util.List<com.google.android.gms.internal.ads.zzabe> r7 = r1.zzj
            r14 = 0
        L_0x0114:
            int r13 = r7.size()
            if (r14 >= r13) goto L_0x0136
            java.lang.Object r13 = r7.get(r14)
            com.google.android.gms.internal.ads.zzabe r13 = (com.google.android.gms.internal.ads.zzabe) r13
            r11 = 0
        L_0x0121:
            int r12 = r13.zza()
            if (r11 >= r12) goto L_0x0131
            com.google.android.gms.internal.ads.zzabd r12 = r13.zzb(r11)
            r12.zza(r10)
            int r11 = r11 + 1
            goto L_0x0121
        L_0x0131:
            int r14 = r14 + 1
            r11 = 0
            goto L_0x0114
        L_0x0136:
            com.google.android.gms.internal.ads.zzku r7 = new com.google.android.gms.internal.ads.zzku
            r7.<init>(r10)
        L_0x013b:
            com.google.android.gms.internal.ads.zzku r10 = r0.zzy
            boolean r10 = r7.equals(r10)
            r10 = r10 ^ r5
            r0.zzy = r7
            com.google.android.gms.internal.ads.zzmv r7 = r3.zza
            com.google.android.gms.internal.ads.zzmv r11 = r1.zza
            boolean r7 = r7.equals(r11)
            if (r7 != 0) goto L_0x015a
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r7 = r0.zzi
            com.google.android.gms.internal.ads.zzji r11 = new com.google.android.gms.internal.ads.zzji
            r12 = r41
            r11.<init>(r1, r12)
            r7.zzd(r15, r11)
        L_0x015a:
            if (r44 == 0) goto L_0x0272
            com.google.android.gms.internal.ads.zzms r7 = new com.google.android.gms.internal.ads.zzms
            r7.<init>()
            com.google.android.gms.internal.ads.zzmv r11 = r3.zza
            boolean r11 = r11.zzt()
            if (r11 != 0) goto L_0x0191
            com.google.android.gms.internal.ads.zzadv r11 = r3.zzb
            java.lang.Object r11 = r11.zza
            com.google.android.gms.internal.ads.zzmv r12 = r3.zza
            r12.zzf(r11, r7)
            int r12 = r7.zzc
            com.google.android.gms.internal.ads.zzmv r13 = r3.zza
            int r13 = r13.zzh(r11)
            com.google.android.gms.internal.ads.zzmv r14 = r3.zza
            com.google.android.gms.internal.ads.zzmu r15 = r0.zza
            r16 = r9
            r8 = 0
            com.google.android.gms.internal.ads.zzmu r14 = r14.zze(r12, r15, r8)
            java.lang.Object r8 = r14.zzb
            r18 = r8
            r20 = r11
            r19 = r12
            r21 = r13
            goto L_0x019b
        L_0x0191:
            r16 = r9
            r19 = r48
            r18 = 0
            r20 = 0
            r21 = -1
        L_0x019b:
            if (r2 != 0) goto L_0x01ce
            long r8 = r7.zzd
            com.google.android.gms.internal.ads.zzadv r11 = r3.zzb
            boolean r11 = r11.zzb()
            if (r11 == 0) goto L_0x01b6
            com.google.android.gms.internal.ads.zzadv r8 = r3.zzb
            int r8 = r8.zzb
            r11 = -1
            long r8 = r7.zzh(r8, r11)
            long r12 = zzJ(r3)
            r11 = r12
            goto L_0x01e0
        L_0x01b6:
            r11 = -1
            com.google.android.gms.internal.ads.zzadv r7 = r3.zzb
            int r7 = r7.zze
            if (r7 == r11) goto L_0x01df
            com.google.android.gms.internal.ads.zzlj r7 = r0.zzz
            com.google.android.gms.internal.ads.zzadv r7 = r7.zzb
            boolean r7 = r7.zzb()
            if (r7 == 0) goto L_0x01df
            com.google.android.gms.internal.ads.zzlj r7 = r0.zzz
            long r8 = zzJ(r7)
            goto L_0x01df
        L_0x01ce:
            com.google.android.gms.internal.ads.zzadv r7 = r3.zzb
            boolean r7 = r7.zzb()
            if (r7 == 0) goto L_0x01dd
            long r8 = r3.zzs
            long r11 = zzJ(r3)
            goto L_0x01e0
        L_0x01dd:
            long r8 = r3.zzs
        L_0x01df:
            r11 = r8
        L_0x01e0:
            com.google.android.gms.internal.ads.zzlt r7 = new com.google.android.gms.internal.ads.zzlt
            long r22 = com.google.android.gms.internal.ads.zzig.zza(r8)
            com.google.android.gms.internal.ads.zzadv r8 = r3.zzb
            int r8 = r8.zzb
            long r24 = com.google.android.gms.internal.ads.zzig.zza(r11)
            r27 = -1
            r17 = r7
            r26 = r8
            r17.<init>(r18, r19, r20, r21, r22, r24, r26, r27)
            int r8 = r39.zzt()
            com.google.android.gms.internal.ads.zzlj r9 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r9 = r9.zza
            boolean r9 = r9.zzt()
            if (r9 != 0) goto L_0x022f
            com.google.android.gms.internal.ads.zzlj r9 = r0.zzz
            com.google.android.gms.internal.ads.zzadv r11 = r9.zzb
            java.lang.Object r11 = r11.zza
            com.google.android.gms.internal.ads.zzmv r9 = r9.zza
            com.google.android.gms.internal.ads.zzms r12 = r0.zzk
            r9.zzf(r11, r12)
            com.google.android.gms.internal.ads.zzlj r9 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r9 = r9.zza
            int r9 = r9.zzh(r11)
            com.google.android.gms.internal.ads.zzlj r12 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r12 = r12.zza
            com.google.android.gms.internal.ads.zzmu r13 = r0.zza
            r14 = 0
            com.google.android.gms.internal.ads.zzmu r12 = r12.zze(r8, r13, r14)
            java.lang.Object r12 = r12.zzb
            r32 = r9
            r31 = r11
            r29 = r12
            goto L_0x0235
        L_0x022f:
            r29 = 0
            r31 = 0
            r32 = -1
        L_0x0235:
            long r33 = com.google.android.gms.internal.ads.zzig.zza(r46)
            com.google.android.gms.internal.ads.zzlt r9 = new com.google.android.gms.internal.ads.zzlt
            com.google.android.gms.internal.ads.zzlj r11 = r0.zzz
            com.google.android.gms.internal.ads.zzadv r11 = r11.zzb
            boolean r11 = r11.zzb()
            if (r11 == 0) goto L_0x0252
            com.google.android.gms.internal.ads.zzlj r11 = r0.zzz
            long r11 = zzJ(r11)
            long r11 = com.google.android.gms.internal.ads.zzig.zza(r11)
            r35 = r11
            goto L_0x0254
        L_0x0252:
            r35 = r33
        L_0x0254:
            com.google.android.gms.internal.ads.zzlj r11 = r0.zzz
            com.google.android.gms.internal.ads.zzadv r11 = r11.zzb
            int r11 = r11.zzb
            r38 = -1
            r28 = r9
            r30 = r8
            r37 = r11
            r28.<init>(r29, r30, r31, r32, r33, r35, r37, r38)
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r8 = r0.zzi
            com.google.android.gms.internal.ads.zzjj r11 = new com.google.android.gms.internal.ads.zzjj
            r11.<init>(r2, r7, r9)
            r2 = 12
            r8.zzd(r2, r11)
            goto L_0x0274
        L_0x0272:
            r16 = r9
        L_0x0274:
            if (r6 == 0) goto L_0x0282
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzjk r6 = new com.google.android.gms.internal.ads.zzjk
            r8 = r16
            r6.<init>(r8, r4)
            r2.zzd(r5, r6)
        L_0x0282:
            com.google.android.gms.internal.ads.zzio r2 = r3.zzf
            com.google.android.gms.internal.ads.zzio r4 = r1.zzf
            if (r2 == r4) goto L_0x0296
            if (r4 == 0) goto L_0x0296
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzjl r4 = new com.google.android.gms.internal.ads.zzjl
            r4.<init>(r1)
            r6 = 11
            r2.zzd(r6, r4)
        L_0x0296:
            com.google.android.gms.internal.ads.zzahd r2 = r3.zzi
            com.google.android.gms.internal.ads.zzahd r4 = r1.zzi
            if (r2 == r4) goto L_0x02b8
            com.google.android.gms.internal.ads.zzahc r2 = r0.zze
            java.lang.Object r4 = r4.zzc
            r2.zzi(r4)
            com.google.android.gms.internal.ads.zzagx r2 = new com.google.android.gms.internal.ads.zzagx
            com.google.android.gms.internal.ads.zzahd r4 = r1.zzi
            com.google.android.gms.internal.ads.zzagf[] r4 = r4.zzd
            r6 = 0
            r2.<init>(r4, r6)
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r4 = r0.zzi
            com.google.android.gms.internal.ads.zzit r6 = new com.google.android.gms.internal.ads.zzit
            r6.<init>(r1, r2)
            r2 = 2
            r4.zzd(r2, r6)
        L_0x02b8:
            java.util.List<com.google.android.gms.internal.ads.zzabe> r2 = r3.zzj
            java.util.List<com.google.android.gms.internal.ads.zzabe> r4 = r1.zzj
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x02cd
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zziu r4 = new com.google.android.gms.internal.ads.zziu
            r4.<init>(r1)
            r6 = 3
            r2.zzd(r6, r4)
        L_0x02cd:
            if (r10 == 0) goto L_0x02dd
            com.google.android.gms.internal.ads.zzku r2 = r0.zzy
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r4 = r0.zzi
            com.google.android.gms.internal.ads.zziv r6 = new com.google.android.gms.internal.ads.zziv
            r6.<init>(r2)
            r2 = 15
            r4.zzd(r2, r6)
        L_0x02dd:
            boolean r2 = r3.zzg
            boolean r4 = r1.zzg
            r6 = 4
            if (r2 == r4) goto L_0x02ee
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zziw r4 = new com.google.android.gms.internal.ads.zziw
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x02ee:
            int r2 = r3.zze
            int r4 = r1.zze
            if (r2 != r4) goto L_0x02fa
            boolean r2 = r3.zzl
            boolean r4 = r1.zzl
            if (r2 == r4) goto L_0x0305
        L_0x02fa:
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzix r4 = new com.google.android.gms.internal.ads.zzix
            r4.<init>(r1)
            r7 = -1
            r2.zzd(r7, r4)
        L_0x0305:
            int r2 = r3.zze
            int r4 = r1.zze
            r7 = 5
            if (r2 == r4) goto L_0x0316
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zziy r4 = new com.google.android.gms.internal.ads.zziy
            r4.<init>(r1)
            r2.zzd(r7, r4)
        L_0x0316:
            boolean r2 = r3.zzl
            boolean r4 = r1.zzl
            r8 = 6
            if (r2 == r4) goto L_0x0329
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zziz r4 = new com.google.android.gms.internal.ads.zziz
            r9 = r42
            r4.<init>(r1, r9)
            r2.zzd(r8, r4)
        L_0x0329:
            int r2 = r3.zzm
            int r4 = r1.zzm
            r9 = 7
            if (r2 == r4) goto L_0x033a
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzja r4 = new com.google.android.gms.internal.ads.zzja
            r4.<init>(r1)
            r2.zzd(r9, r4)
        L_0x033a:
            boolean r2 = zzN(r3)
            boolean r4 = zzN(r40)
            if (r2 == r4) goto L_0x0350
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzjb r4 = new com.google.android.gms.internal.ads.zzjb
            r4.<init>(r1)
            r10 = 8
            r2.zzd(r10, r4)
        L_0x0350:
            com.google.android.gms.internal.ads.zzll r2 = r3.zzn
            com.google.android.gms.internal.ads.zzll r4 = r1.zzn
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0366
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzjc r4 = new com.google.android.gms.internal.ads.zzjc
            r4.<init>(r1)
            r10 = 13
            r2.zzd(r10, r4)
        L_0x0366:
            if (r43 == 0) goto L_0x0370
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzajw r4 = com.google.android.gms.internal.ads.zzje.zza
            r10 = -1
            r2.zzd(r10, r4)
        L_0x0370:
            com.google.android.gms.internal.ads.zzlp r2 = r0.zzx
            com.google.android.gms.internal.ads.zzlp r4 = r0.zzc
            com.google.android.gms.internal.ads.zzlo r10 = new com.google.android.gms.internal.ads.zzlo
            r10.<init>()
            r10.zzd(r4)
            boolean r4 = r39.zzy()
            r4 = r4 ^ r5
            r11 = 3
            r10.zzb(r11, r4)
            com.google.android.gms.internal.ads.zzlj r4 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r4 = r4.zza
            boolean r11 = r4.zzt()
            if (r11 != 0) goto L_0x03a7
            int r11 = r39.zzt()
            com.google.android.gms.internal.ads.zzmu r12 = r0.zza
            r13 = 0
            com.google.android.gms.internal.ads.zzmu r4 = r4.zze(r11, r12, r13)
            boolean r4 = r4.zzg
            if (r4 == 0) goto L_0x03a7
            boolean r4 = r39.zzy()
            if (r4 != 0) goto L_0x03a7
            r4 = 1
            goto L_0x03a8
        L_0x03a7:
            r4 = 0
        L_0x03a8:
            r10.zzb(r6, r4)
            com.google.android.gms.internal.ads.zzlj r4 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r4 = r4.zza
            boolean r6 = r4.zzt()
            if (r6 == 0) goto L_0x03b7
        L_0x03b5:
            r11 = 0
            goto L_0x03ca
        L_0x03b7:
            int r6 = r39.zzt()
            r11 = 0
            int r4 = r4.zza(r6, r11, r11)
            r6 = -1
            if (r4 == r6) goto L_0x03b5
            boolean r4 = r39.zzy()
            if (r4 != 0) goto L_0x03b5
            r11 = 1
        L_0x03ca:
            r10.zzb(r7, r11)
            com.google.android.gms.internal.ads.zzlj r4 = r0.zzz
            com.google.android.gms.internal.ads.zzmv r4 = r4.zza
            boolean r6 = r4.zzt()
            if (r6 == 0) goto L_0x03d9
        L_0x03d7:
            r15 = 0
            goto L_0x03ec
        L_0x03d9:
            int r6 = r39.zzt()
            r7 = 0
            int r4 = r4.zzb(r6, r7, r7)
            r6 = -1
            if (r4 == r6) goto L_0x03d7
            boolean r4 = r39.zzy()
            if (r4 != 0) goto L_0x03d7
            r15 = 1
        L_0x03ec:
            r10.zzb(r8, r15)
            boolean r4 = r39.zzy()
            r4 = r4 ^ r5
            r10.zzb(r9, r4)
            com.google.android.gms.internal.ads.zzlp r4 = r10.zze()
            r0.zzx = r4
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x040f
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            com.google.android.gms.internal.ads.zzjf r4 = new com.google.android.gms.internal.ads.zzjf
            r4.<init>(r0)
            r5 = 14
            r2.zzd(r5, r4)
        L_0x040f:
            com.google.android.gms.internal.ads.zzajz<com.google.android.gms.internal.ads.zzlq> r2 = r0.zzi
            r2.zze()
            boolean r2 = r3.zzo
            boolean r4 = r1.zzo
            if (r2 == r4) goto L_0x0432
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.gms.internal.ads.zzip> r2 = r0.zzj
            java.util.Iterator r2 = r2.iterator()
        L_0x0420:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0432
            java.lang.Object r4 = r2.next()
            com.google.android.gms.internal.ads.zzip r4 = (com.google.android.gms.internal.ads.zzip) r4
            boolean r5 = r1.zzo
            r4.zza(r5)
            goto L_0x0420
        L_0x0432:
            boolean r2 = r3.zzp
            boolean r3 = r1.zzp
            if (r2 == r3) goto L_0x0450
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.gms.internal.ads.zzip> r2 = r0.zzj
            java.util.Iterator r2 = r2.iterator()
        L_0x043e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0450
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.ads.zzip r3 = (com.google.android.gms.internal.ads.zzip) r3
            boolean r4 = r1.zzp
            r3.zzb(r4)
            goto L_0x043e
        L_0x0450:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjn.zzI(com.google.android.gms.internal.ads.zzlj, int, int, boolean, boolean, int, long, int):void");
    }

    public static long zzJ(zzlj zzlj) {
        zzmu zzmu = new zzmu();
        zzms zzms = new zzms();
        zzlj.zza.zzf(zzlj.zzb.zza, zzms);
        long j = zzlj.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzlj.zza.zze(zzms.zzc, zzmu, 0).zzl;
        return 0;
    }

    private final zzlj zzK(zzlj zzlj, zzmv zzmv, @Nullable Pair<Object, Long> pair) {
        zzadv zzadv;
        zzaft zzaft;
        zzahd zzahd;
        zzadv zzadv2;
        List list;
        zzlj zzlj2;
        long j;
        zzmv zzmv2 = zzmv;
        Pair<Object, Long> pair2 = pair;
        zzajg.zza(zzmv.zzt() || pair2 != null);
        zzmv zzmv3 = zzlj.zza;
        zzlj zzd2 = zzlj.zzd(zzmv);
        if (zzmv.zzt()) {
            zzadv zzb2 = zzlj.zzb();
            long zzb3 = zzig.zzb(this.zzB);
            zzlj zzg2 = zzd2.zzc(zzb2, zzb3, zzb3, zzb3, 0, zzaft.zza, this.zzb, zzfml.zzi()).zzg(zzb2);
            zzg2.zzq = zzg2.zzs;
            return zzg2;
        }
        Object obj = zzd2.zzb.zza;
        int i = zzalh.zza;
        boolean z = !obj.equals(pair2.first);
        if (z) {
            zzadv = new zzadv(pair2.first);
        } else {
            zzadv = zzd2.zzb;
        }
        zzadv zzadv3 = zzadv;
        long longValue = ((Long) pair2.second).longValue();
        long zzb4 = zzig.zzb(zzB());
        if (!zzmv3.zzt()) {
            zzmv3.zzf(obj, this.zzk);
        }
        if (z || longValue < zzb4) {
            zzadv zzadv4 = zzadv3;
            zzajg.zzd(!zzadv4.zzb());
            if (z) {
                zzaft = zzaft.zza;
            } else {
                zzaft = zzd2.zzh;
            }
            zzaft zzaft2 = zzaft;
            if (z) {
                zzadv2 = zzadv4;
                zzahd = this.zzb;
            } else {
                zzadv2 = zzadv4;
                zzahd = zzd2.zzi;
            }
            zzahd zzahd2 = zzahd;
            if (z) {
                list = zzfml.zzi();
            } else {
                list = zzd2.zzj;
            }
            zzlj zzg3 = zzd2.zzc(zzadv2, longValue, longValue, longValue, 0, zzaft2, zzahd2, list).zzg(zzadv2);
            zzg3.zzq = longValue;
            return zzg3;
        }
        if (longValue == zzb4) {
            int zzh2 = zzmv2.zzh(zzd2.zzk.zza);
            if (zzh2 != -1 && zzmv2.zzg(zzh2, this.zzk, false).zzc == zzmv2.zzf(zzadv3.zza, this.zzk).zzc) {
                return zzd2;
            }
            zzmv2.zzf(zzadv3.zza, this.zzk);
            if (zzadv3.zzb()) {
                j = this.zzk.zzh(zzadv3.zzb, -1);
            } else {
                j = this.zzk.zzd;
            }
            zzlj2 = zzd2.zzc(zzadv3, zzd2.zzs, zzd2.zzs, zzd2.zzd, j - zzd2.zzs, zzd2.zzh, zzd2.zzi, zzd2.zzj).zzg(zzadv3);
            zzlj2.zzq = j;
        } else {
            zzadv zzadv5 = zzadv3;
            zzajg.zzd(!zzadv5.zzb());
            long max = Math.max(0, zzd2.zzr - (longValue - zzb4));
            long j2 = zzd2.zzq;
            if (zzd2.zzk.equals(zzd2.zzb)) {
                j2 = longValue + max;
            }
            zzlj2 = zzd2.zzc(zzadv5, longValue, longValue, longValue, max, zzd2.zzh, zzd2.zzi, zzd2.zzj);
            zzlj2.zzq = j2;
        }
        return zzlj2;
    }

    @Nullable
    private final Pair<Object, Long> zzL(zzmv zzmv, int i, long j) {
        if (zzmv.zzt()) {
            this.zzA = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzB = j;
            return null;
        }
        if (i == -1 || i >= zzmv.zzr()) {
            i = zzmv.zzd(false);
            long j2 = zzmv.zze(i, this.zza, 0).zzl;
            j = zzig.zza(0);
        }
        return zzmv.zzv(this.zza, this.zzk, i, zzig.zzb(j));
    }

    private final long zzM(zzmv zzmv, zzadv zzadv, long j) {
        zzmv.zzf(zzadv.zza, this.zzk);
        return j;
    }

    public static boolean zzN(zzlj zzlj) {
        return zzlj.zze == 3 && zzlj.zzl && zzlj.zzm == 0;
    }

    public final int zzA() {
        if (zzy()) {
            int i = this.zzz.zzb.zzc;
        }
        return -1;
    }

    public final long zzB() {
        if (!zzy()) {
            return zzv();
        }
        zzlj zzlj = this.zzz;
        zzlj.zza.zzf(zzlj.zzb.zza, this.zzk);
        zzlj zzlj2 = this.zzz;
        if (zzlj2.zzc != -9223372036854775807L) {
            return zzig.zza(0) + zzig.zza(this.zzz.zzc);
        }
        long j = zzlj2.zza.zze(zzt(), this.zza, 0).zzl;
        return zzig.zza(0);
    }

    public final zzmv zzC() {
        return this.zzz.zza;
    }

    public final /* synthetic */ void zzE(zzju zzju) {
        this.zzf.zzk(new zzjg(this, zzju));
    }

    public final /* synthetic */ void zzF(zzju zzju) {
        long j;
        boolean z;
        long j2;
        int i = this.zzs - zzju.zzb;
        this.zzs = i;
        boolean z2 = true;
        if (zzju.zzc) {
            this.zzt = zzju.zzd;
            this.zzu = true;
        }
        if (zzju.zze) {
            this.zzv = zzju.zzf;
        }
        if (i == 0) {
            zzmv zzmv = zzju.zza.zza;
            if (!this.zzz.zza.zzt() && zzmv.zzt()) {
                this.zzA = -1;
                this.zzB = 0;
            }
            if (!zzmv.zzt()) {
                List<zzmv> zzq2 = ((zzly) zzmv).zzq();
                zzajg.zzd(zzq2.size() == this.zzl.size());
                for (int i2 = 0; i2 < zzq2.size(); i2++) {
                    zzmv unused = this.zzl.get(i2).zzb = zzq2.get(i2);
                }
            }
            if (this.zzu) {
                if (zzju.zza.zzb.equals(this.zzz.zzb) && zzju.zza.zzd == this.zzz.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzmv.zzt() || zzju.zza.zzb.zzb()) {
                        j2 = zzju.zza.zzd;
                    } else {
                        zzlj zzlj = zzju.zza;
                        zzadv zzadv = zzlj.zzb;
                        j2 = zzlj.zzd;
                        zzM(zzmv, zzadv, j2);
                    }
                    z = z2;
                    j = j2;
                } else {
                    j = -9223372036854775807L;
                    z = z2;
                }
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzu = false;
            zzI(zzju.zza, 1, this.zzv, false, z, this.zzt, j, -1);
        }
    }

    public final int zza() {
        int length = this.zzd.length;
        return 2;
    }

    @Deprecated
    public final void zzb(zzadx zzadx) {
        zzk(Collections.singletonList(zzadx), true);
        zzj();
    }

    public final zzlx zzc(zzlw zzlw) {
        return new zzlx(this.zzh, zzlw, this.zzz.zza, zzt(), this.zzr, this.zzh.zzh());
    }

    public final boolean zzd() {
        return this.zzz.zzp;
    }

    public final Looper zze() {
        return this.zzp;
    }

    public final void zzf(zzlq zzlq) {
        this.zzi.zzb(zzlq);
    }

    public final void zzg(zzlq zzlq) {
        this.zzi.zzc(zzlq);
    }

    public final void zzh(zzip zzip) {
        this.zzj.add(zzip);
    }

    public final int zzi() {
        return this.zzz.zze;
    }

    public final void zzj() {
        zzlj zzlj = this.zzz;
        if (zzlj.zze == 1) {
            zzlj zzf2 = zzlj.zzf((zzio) null);
            zzlj zze2 = zzf2.zze(true != zzf2.zza.zzt() ? 2 : 4);
            this.zzs++;
            this.zzh.zzb();
            zzI(zze2, 1, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public final void zzk(List<zzadx> list, boolean z) {
        zzG();
        zzv();
        this.zzs++;
        if (!this.zzl.isEmpty()) {
            int size = this.zzl.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzl.remove(i);
            }
            this.zzC = this.zzC.zzg(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzld zzld = new zzld(list.get(i2), this.zzm);
            arrayList.add(zzld);
            this.zzl.add(i2, new zzjm(zzld.zzb, zzld.zza.zzy()));
        }
        this.zzC = this.zzC.zzf(0, arrayList.size());
        zzly zzly = new zzly(this.zzl, this.zzC, (zzafm) null);
        if (zzly.zzt() || zzly.zzr() >= 0) {
            int zzd2 = zzly.zzd(false);
            zzlj zzK = zzK(this.zzz, zzly, zzL(zzly, zzd2, -9223372036854775807L));
            int i3 = zzK.zze;
            if (!(zzd2 == -1 || i3 == 1)) {
                i3 = (zzly.zzt() || zzd2 >= zzly.zzr()) ? 4 : 2;
            }
            zzlj zze2 = zzK.zze(i3);
            this.zzh.zzq(arrayList, zzd2, zzig.zzb(-9223372036854775807L), this.zzC);
            zzI(zze2, 0, 1, false, !this.zzz.zzb.zza.equals(zze2.zzb.zza) && !this.zzz.zza.zzt(), 4, zzH(zze2), -1);
            return;
        }
        throw new zzke(zzly, -1, -9223372036854775807L);
    }

    public final void zzl(boolean z) {
        zzm(z, 0, 1);
    }

    public final void zzm(boolean z, int i, int i2) {
        zzlj zzlj = this.zzz;
        if (zzlj.zzl != z || zzlj.zzm != i) {
            this.zzs++;
            zzlj zzh2 = zzlj.zzh(z, i);
            this.zzh.zzc(z, i);
            zzI(zzh2, 0, i2, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public final boolean zzn() {
        return this.zzz.zzl;
    }

    public final void zzo(int i, long j) {
        int i2 = i;
        long j2 = j;
        zzmv zzmv = this.zzz.zza;
        if (i2 < 0 || (!zzmv.zzt() && i2 >= zzmv.zzr())) {
            throw new zzke(zzmv, i, j2);
        }
        int i3 = 1;
        this.zzs++;
        if (!zzy()) {
            if (this.zzz.zze != 1) {
                i3 = 2;
            }
            int zzt2 = zzt();
            zzlj zzK = zzK(this.zzz.zze(i3), zzmv, zzL(zzmv, i, j2));
            this.zzh.zzd(zzmv, i, zzig.zzb(j));
            zzI(zzK, 0, 1, true, true, 1, zzH(zzK), zzt2);
            return;
        }
        Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
        zzju zzju = new zzju(this.zzz);
        zzju.zza(1);
        this.zzg.zza(zzju);
    }

    public final void zzp(boolean z) {
        zzq(false, (zzio) null);
    }

    public final void zzq(boolean z, @Nullable zzio zzio) {
        zzlj zzlj = this.zzz;
        zzlj zzg2 = zzlj.zzg(zzlj.zzb);
        zzg2.zzq = zzg2.zzs;
        zzg2.zzr = 0;
        zzlj zze2 = zzg2.zze(1);
        if (zzio != null) {
            zze2 = zze2.zzf(zzio);
        }
        zzlj zzlj2 = zze2;
        this.zzs++;
        this.zzh.zze();
        zzI(zzlj2, 0, 1, false, zzlj2.zza.zzt() && !this.zzz.zza.zzt(), 4, zzH(zzlj2), -1);
    }

    public final void zzr() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzalh.zze;
        String zza = zzjy.zza();
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(hexString).length(), 36, String.valueOf(str).length(), String.valueOf(zza).length()));
        GeneratedOutlineSupport.outline34(sb, "Release ", hexString, " [ExoPlayerLib/2.14.0] [", str);
        sb.append("] [");
        sb.append(zza);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        if (!this.zzh.zzg()) {
            zzajz<zzlq> zzajz = this.zzi;
            zzajz.zzd(11, zzjh.zza);
            zzajz.zze();
        }
        this.zzi.zzf();
        this.zzf.zzj((Object) null);
        zzou zzou = this.zzo;
        if (zzou != null) {
            this.zzq.zzb(zzou);
        }
        zzlj zze2 = this.zzz.zze(1);
        this.zzz = zze2;
        zzlj zzg2 = zze2.zzg(zze2.zzb);
        this.zzz = zzg2;
        zzg2.zzq = zzg2.zzs;
        this.zzz.zzr = 0;
    }

    public final int zzs() {
        if (this.zzz.zza.zzt()) {
            return 0;
        }
        zzlj zzlj = this.zzz;
        return zzlj.zza.zzh(zzlj.zzb.zza);
    }

    public final int zzt() {
        int zzG = zzG();
        if (zzG == -1) {
            return 0;
        }
        return zzG;
    }

    public final long zzu() {
        if (!zzy()) {
            zzmv zzmv = this.zzz.zza;
            if (zzmv.zzt()) {
                return -9223372036854775807L;
            }
            return zzig.zza(zzmv.zze(zzt(), this.zza, 0).zzm);
        }
        zzlj zzlj = this.zzz;
        zzadv zzadv = zzlj.zzb;
        zzlj.zza.zzf(zzadv.zza, this.zzk);
        return zzig.zza(this.zzk.zzh(zzadv.zzb, -1));
    }

    public final long zzv() {
        return zzig.zza(zzH(this.zzz));
    }

    public final long zzw() {
        if (zzy()) {
            zzlj zzlj = this.zzz;
            if (zzlj.zzk.equals(zzlj.zzb)) {
                return zzig.zza(this.zzz.zzq);
            }
            return zzu();
        } else if (this.zzz.zza.zzt()) {
            return this.zzB;
        } else {
            zzlj zzlj2 = this.zzz;
            if (zzlj2.zzk.zzd != zzlj2.zzb.zzd) {
                return zzig.zza(zzlj2.zza.zze(zzt(), this.zza, 0).zzm);
            }
            long j = zzlj2.zzq;
            if (this.zzz.zzk.zzb()) {
                zzlj zzlj3 = this.zzz;
                zzms zzf2 = zzlj3.zza.zzf(zzlj3.zzk.zza, this.zzk);
                long zzb2 = zzf2.zzb(this.zzz.zzk.zzb);
                j = zzb2 == Long.MIN_VALUE ? zzf2.zzd : zzb2;
            }
            zzlj zzlj4 = this.zzz;
            zzM(zzlj4.zza, zzlj4.zzk, j);
            return zzig.zza(j);
        }
    }

    public final long zzx() {
        return zzig.zza(this.zzz.zzr);
    }

    public final boolean zzy() {
        return this.zzz.zzb.zzb();
    }

    public final int zzz() {
        if (zzy()) {
            return this.zzz.zzb.zzb;
        }
        return -1;
    }
}
