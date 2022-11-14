package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacf {
    public static final zzacd zza = zzacc.zza;

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzabe zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzacd r13, com.google.android.gms.internal.ads.zzabg r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzakr r0 = new com.google.android.gms.internal.ads.zzakr
            r0.<init>(r11, r12)
            int r11 = r0.zzd()
            r12 = 2
            r1 = 10
            r2 = 4
            r3 = 0
            r4 = 1
            java.lang.String r5 = "Id3Decoder"
            r6 = 0
            if (r11 >= r1) goto L_0x0020
            java.lang.String r11 = "Data too short to be an ID3 tag"
            android.util.Log.w(r5, r11)
            goto L_0x00a9
        L_0x0020:
            int r11 = r0.zzr()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0051
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7[r3] = r11
            java.lang.String r11 = "%06X"
            java.lang.String r11 = java.lang.String.format(r11, r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = "Unexpected first three bytes of ID3 tag header: 0x"
            int r8 = r11.length()
            if (r8 == 0) goto L_0x0048
            java.lang.String r11 = r7.concat(r11)
            goto L_0x004d
        L_0x0048:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7)
        L_0x004d:
            android.util.Log.w(r5, r11)
            goto L_0x00a9
        L_0x0051:
            int r11 = r0.zzn()
            r0.zzk(r4)
            int r7 = r0.zzn()
            int r8 = r0.zzA()
            if (r11 != r12) goto L_0x006c
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0093
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            android.util.Log.w(r5, r11)
            goto L_0x00a9
        L_0x006c:
            r9 = 3
            if (r11 != r9) goto L_0x007d
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0093
            int r9 = r0.zzv()
            r0.zzk(r9)
            int r9 = r9 + r2
            int r8 = r8 - r9
            goto L_0x0093
        L_0x007d:
            if (r11 != r2) goto L_0x00a2
            r9 = r7 & 64
            if (r9 == 0) goto L_0x008d
            int r9 = r0.zzA()
            int r10 = r9 + -4
            r0.zzk(r10)
            int r8 = r8 - r9
        L_0x008d:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0093
            int r8 = r8 + -10
        L_0x0093:
            if (r11 >= r2) goto L_0x009b
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x009b
            r7 = 1
            goto L_0x009c
        L_0x009b:
            r7 = 0
        L_0x009c:
            com.google.android.gms.internal.ads.zzace r9 = new com.google.android.gms.internal.ads.zzace
            r9.<init>(r11, r7, r8)
            goto L_0x00aa
        L_0x00a2:
            r7 = 57
            java.lang.String r8 = "Skipped ID3 tag with unsupported majorVersion="
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r7, r8, r11, r5)
        L_0x00a9:
            r9 = r6
        L_0x00aa:
            if (r9 != 0) goto L_0x00ad
            return r6
        L_0x00ad:
            int r11 = r0.zzg()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00b8
            r1 = 6
        L_0x00b8:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00ca
            int r12 = r9.zzc
            int r12 = zzd(r0, r12)
        L_0x00ca:
            int r11 = r11 + r12
            r0.zzf(r11)
            int r11 = r9.zza
            boolean r11 = zzb(r0, r11, r1, r3)
            if (r11 != 0) goto L_0x00f2
            int r11 = r9.zza
            if (r11 != r2) goto L_0x00e6
            boolean r11 = zzb(r0, r2, r1, r4)
            if (r11 == 0) goto L_0x00e6
            r3 = 1
            goto L_0x00f2
        L_0x00e6:
            int r11 = r9.zza
            r12 = 56
            java.lang.String r13 = "Failed to validate ID3 tag with majorVersion="
            com.android.tools.p006r8.GeneratedOutlineSupport.outline29(r12, r13, r11, r5)
            return r6
        L_0x00f2:
            int r11 = r0.zzd()
            if (r11 < r1) goto L_0x0106
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzacg r11 = zzc(r11, r0, r3, r1, r13)
            if (r11 == 0) goto L_0x00f2
            r14.add(r11)
            goto L_0x00f2
        L_0x0106:
            com.google.android.gms.internal.ads.zzabe r11 = new com.google.android.gms.internal.ads.zzabe
            r11.<init>((java.util.List<? extends com.google.android.gms.internal.ads.zzabd>) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacf.zza(byte[], int, com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzabg):com.google.android.gms.internal.ads.zzabe");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if ((r10 & 128) != 0) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzb(com.google.android.gms.internal.ads.zzakr r19, int r20, int r21, boolean r22) {
        /*
            r1 = r19
            r0 = r20
            int r2 = r19.zzg()
        L_0x0008:
            int r3 = r19.zzd()     // Catch:{ all -> 0x00ae }
            r4 = 1
            r5 = r21
            if (r3 < r5) goto L_0x00aa
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r19.zzv()     // Catch:{ all -> 0x00ae }
            long r8 = r19.zzt()     // Catch:{ all -> 0x00ae }
            int r10 = r19.zzo()     // Catch:{ all -> 0x00ae }
            goto L_0x002c
        L_0x0022:
            int r7 = r19.zzr()     // Catch:{ all -> 0x00ae }
            int r8 = r19.zzr()     // Catch:{ all -> 0x00ae }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003b
            if (r10 == 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            r1.zzh(r2)
            return r4
        L_0x003b:
            r7 = 4
            if (r0 != r7) goto L_0x006a
            if (r22 != 0) goto L_0x006a
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004c
            r1.zzh(r2)
            return r6
        L_0x004c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r11 = r11 & r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 24
            long r8 = r8 >> r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L_0x006a:
            if (r0 != r7) goto L_0x007a
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            r3 = r10 & 1
            r18 = r4
            r4 = r3
            r3 = r18
            goto L_0x008a
        L_0x007a:
            if (r0 != r3) goto L_0x0088
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0082
            r3 = 1
            goto L_0x0083
        L_0x0082:
            r3 = 0
        L_0x0083:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0088:
            r3 = 0
        L_0x0089:
            r4 = 0
        L_0x008a:
            if (r4 == 0) goto L_0x008e
            int r3 = r3 + 4
        L_0x008e:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0097
            r1.zzh(r2)
            return r6
        L_0x0097:
            int r3 = r19.zzd()     // Catch:{ all -> 0x00ae }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a4
            r1.zzh(r2)
            return r6
        L_0x00a4:
            int r3 = (int) r8
            r1.zzk(r3)     // Catch:{ all -> 0x00ae }
            goto L_0x0008
        L_0x00aa:
            r1.zzh(r2)
            return r4
        L_0x00ae:
            r0 = move-exception
            r1.zzh(r2)
            goto L_0x00b4
        L_0x00b3:
            throw r0
        L_0x00b4:
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacf.zzb(com.google.android.gms.internal.ads.zzakr, int, int, boolean):boolean");
    }

    /* JADX WARNING: type inference failed for: r3v17, types: [com.google.android.gms.internal.ads.zzabz] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.ads.zzabr] */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0273, code lost:
        if (r9 == 67) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0305, code lost:
        r2 = "Id3Decoder";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0552, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0553, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0556, code lost:
        r2 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0561, code lost:
        r14 = r21;
        r2 = r22;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:121:0x0220, B:142:0x028f] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x036e A[Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03e1 A[Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0523  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0552 A[ExcHandler: all (th java.lang.Throwable), PHI: r21 
      PHI: (r21v1 int) = (r21v2 int), (r21v2 int), (r21v2 int), (r21v5 int), (r21v8 int) binds: [B:236:0x0525, B:239:0x054e, B:240:?, B:142:0x028f, B:121:0x0220] A[DONT_GENERATE, DONT_INLINE], Splitter:B:121:0x0220] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzacg zzc(int r34, com.google.android.gms.internal.ads.zzakr r35, boolean r36, int r37, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzacd r38) {
        /*
            r0 = r34
            r1 = r35
            r2 = r36
            r3 = r37
            int r4 = r35.zzn()
            int r5 = r35.zzn()
            int r6 = r35.zzn()
            r7 = 3
            if (r0 < r7) goto L_0x001c
            int r9 = r35.zzn()
            goto L_0x001d
        L_0x001c:
            r9 = 0
        L_0x001d:
            r10 = 4
            if (r0 != r10) goto L_0x003c
            int r11 = r35.zzB()
            if (r2 != 0) goto L_0x0047
            r12 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r11 >> 8
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 7
            r12 = r12 | r13
            int r13 = r11 >> 16
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 14
            r12 = r12 | r13
            int r11 = r11 >> 24
            int r11 = r11 << 21
            r11 = r11 | r12
            goto L_0x0047
        L_0x003c:
            if (r0 != r7) goto L_0x0043
            int r11 = r35.zzB()
            goto L_0x0047
        L_0x0043:
            int r11 = r35.zzr()
        L_0x0047:
            if (r0 < r7) goto L_0x004e
            int r12 = r35.zzo()
            goto L_0x004f
        L_0x004e:
            r12 = 0
        L_0x004f:
            r13 = 0
            if (r4 != 0) goto L_0x0065
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r9 != 0) goto L_0x0065
            if (r11 != 0) goto L_0x0065
            if (r12 == 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r0 = r35.zze()
            r1.zzh(r0)
            return r13
        L_0x0065:
            int r14 = r35.zzg()
            int r14 = r14 + r11
            int r15 = r35.zze()
            java.lang.String r8 = "Id3Decoder"
            if (r14 <= r15) goto L_0x007f
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r8, r0)
            int r0 = r35.zze()
            r1.zzh(r0)
            return r13
        L_0x007f:
            if (r38 != 0) goto L_0x057e
            r15 = 1
            if (r0 != r7) goto L_0x00a2
            r7 = r12 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x008a
            r7 = 1
            goto L_0x008b
        L_0x008a:
            r7 = 0
        L_0x008b:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x0092
            r17 = 1
            goto L_0x0094
        L_0x0092:
            r17 = 0
        L_0x0094:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x009a
            r12 = 1
            goto L_0x009b
        L_0x009a:
            r12 = 0
        L_0x009b:
            r18 = r17
            r19 = 0
            r17 = r7
            goto L_0x00d5
        L_0x00a2:
            if (r0 != r10) goto L_0x00cd
            r7 = r12 & 64
            if (r7 == 0) goto L_0x00aa
            r7 = 1
            goto L_0x00ab
        L_0x00aa:
            r7 = 0
        L_0x00ab:
            r17 = r12 & 8
            if (r17 == 0) goto L_0x00b2
            r17 = 1
            goto L_0x00b4
        L_0x00b2:
            r17 = 0
        L_0x00b4:
            r18 = r12 & 4
            if (r18 == 0) goto L_0x00bb
            r18 = 1
            goto L_0x00bd
        L_0x00bb:
            r18 = 0
        L_0x00bd:
            r19 = r12 & 2
            if (r19 == 0) goto L_0x00c4
            r19 = 1
            goto L_0x00c6
        L_0x00c4:
            r19 = 0
        L_0x00c6:
            r12 = r12 & r15
            r33 = r12
            r12 = r7
            r7 = r33
            goto L_0x00d5
        L_0x00cd:
            r7 = 0
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x00d5:
            if (r17 != 0) goto L_0x0573
            if (r18 == 0) goto L_0x00db
            goto L_0x0573
        L_0x00db:
            if (r12 == 0) goto L_0x00e2
            int r11 = r11 + -1
            r1.zzk(r15)
        L_0x00e2:
            if (r7 == 0) goto L_0x00e9
            int r11 = r11 + -4
            r1.zzk(r10)
        L_0x00e9:
            if (r19 == 0) goto L_0x00ef
            int r11 = zzd(r1, r11)
        L_0x00ef:
            r7 = 84
            r12 = 88
            r10 = 2
            if (r4 != r7) goto L_0x012f
            if (r5 != r12) goto L_0x012f
            if (r6 != r12) goto L_0x012f
            if (r0 == r10) goto L_0x00fe
            if (r9 != r12) goto L_0x012f
        L_0x00fe:
            if (r11 > 0) goto L_0x0101
            goto L_0x0137
        L_0x0101:
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zze(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzm(r10, r12, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = zzg(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r15 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r15.<init>(r10, r12, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r12 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = r7 + r12
            int r2 = zzg(r10, r7, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r2 = zzk(r10, r7, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaco r3 = new com.google.android.gms.internal.ads.zzaco     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r7 = "TXXX"
            r3.<init>(r7, r15, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x012f:
            if (r4 != r7) goto L_0x0168
            java.lang.String r2 = zzf(r0, r7, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            if (r11 > 0) goto L_0x0142
        L_0x0137:
            r23 = r4
            r3 = r5
            r4 = r6
            r22 = r8
            r8 = r9
            r21 = r14
            goto L_0x0521
        L_0x0142:
            int r3 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r7 = zze(r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r10 = r11 + -1
            byte[] r12 = new byte[r10]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r15 = 0
            r1.zzm(r12, r15, r10)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r3 = zzg(r12, r15, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r10.<init>(r12, r15, r3, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaco r3 = new com.google.android.gms.internal.ads.zzaco     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3.<init>(r2, r13, r10)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
        L_0x0160:
            r13 = r3
            goto L_0x0137
        L_0x0162:
            r0 = move-exception
            goto L_0x056f
        L_0x0165:
            r2 = r8
            goto L_0x0565
        L_0x0168:
            r7 = 87
            java.lang.String r15 = "ISO-8859-1"
            if (r4 != r7) goto L_0x01aa
            if (r5 != r12) goto L_0x01a7
            if (r6 != r12) goto L_0x01a7
            if (r0 == r10) goto L_0x0176
            if (r9 != r12) goto L_0x01a7
        L_0x0176:
            if (r11 > 0) goto L_0x0179
            goto L_0x0137
        L_0x0179:
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zze(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzm(r10, r12, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = zzg(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r13 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r13.<init>(r10, r12, r7, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r2 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = r7 + r2
            int r2 = zzh(r10, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r2 = zzk(r10, r7, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzacq r3 = new com.google.android.gms.internal.ads.zzacq     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r7 = "WXXX"
            r3.<init>(r7, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01a7:
            r12 = 87
            goto L_0x01ab
        L_0x01aa:
            r12 = r4
        L_0x01ab:
            if (r12 != r7) goto L_0x01c7
            java.lang.String r2 = zzf(r0, r7, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            byte[] r3 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r7 = 0
            r1.zzm(r3, r7, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r10 = zzh(r3, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12.<init>(r3, r7, r10, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzacq r3 = new com.google.android.gms.internal.ads.zzacq     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r7 = 0
            r3.<init>(r2, r7, r12)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01c7:
            r7 = 73
            r13 = 80
            if (r12 != r13) goto L_0x01f5
            r12 = 82
            if (r5 != r12) goto L_0x01f3
            if (r6 != r7) goto L_0x01f3
            r12 = 86
            if (r9 != r12) goto L_0x01f3
            byte[] r2 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3 = 0
            r1.zzm(r2, r3, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = zzh(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r10.<init>(r2, r3, r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3 = 1
            int r7 = r7 + r3
            byte[] r2 = zzj(r2, r7, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzacm r3 = new com.google.android.gms.internal.ads.zzacm     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3.<init>(r10, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01f3:
            r12 = 80
        L_0x01f5:
            r7 = 79
            r13 = 71
            if (r12 != r13) goto L_0x0256
            r12 = 69
            if (r5 != r12) goto L_0x0251
            if (r6 != r7) goto L_0x0251
            r12 = 66
            if (r9 == r12) goto L_0x0207
            if (r0 != r10) goto L_0x0251
        L_0x0207:
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zze(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzm(r10, r12, r7)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r13 = zzh(r10, r12)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r21 = r14
            r14 = 0
            r12.<init>(r10, r14, r13, r15)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r14 = 1
            int r13 = r13 + r14
            int r14 = zzg(r10, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            java.lang.String r13 = zzk(r10, r13, r14, r3)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            int r15 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            int r14 = r14 + r15
            int r15 = zzg(r10, r14, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            java.lang.String r3 = zzk(r10, r14, r15, r3)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            int r2 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            int r15 = r15 + r2
            byte[] r2 = zzj(r10, r15, r7)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzacb r7 = new com.google.android.gms.internal.ads.zzacb     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r7.<init>(r12, r13, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r23 = r4
            r3 = r5
            r4 = r6
            r13 = r7
            r22 = r8
            goto L_0x035d
        L_0x0251:
            r21 = r14
            r12 = 71
            goto L_0x0258
        L_0x0256:
            r21 = r14
        L_0x0258:
            r13 = 67
            if (r0 != r10) goto L_0x0267
            r14 = 80
            if (r12 != r14) goto L_0x0308
            r7 = 73
            if (r5 != r7) goto L_0x0308
            if (r6 != r13) goto L_0x0308
            goto L_0x0275
        L_0x0267:
            r7 = 73
            r14 = 80
            r10 = 65
            if (r12 != r10) goto L_0x0308
            if (r5 != r14) goto L_0x0308
            if (r6 != r7) goto L_0x0308
            if (r9 != r13) goto L_0x0308
        L_0x0275:
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            java.lang.String r3 = zze(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            int r7 = r11 + -1
            byte[] r10 = new byte[r7]     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r12 = 0
            r1.zzm(r10, r12, r7)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r13 = 2
            if (r0 != r13) goto L_0x02b6
            java.lang.String r13 = "image/"
            java.lang.String r14 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0552 }
            r22 = r8
            r8 = 3
            r14.<init>(r10, r12, r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfjm.zza(r14)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r12 = r8.length()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r12 == 0) goto L_0x02a5
            java.lang.String r8 = r13.concat(r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x02aa
        L_0x02a5:
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r8.<init>(r13)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
        L_0x02aa:
            java.lang.String r12 = "image/jpg"
            boolean r12 = r12.equals(r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r12 == 0) goto L_0x02b4
            java.lang.String r8 = "image/jpeg"
        L_0x02b4:
            r12 = 2
            goto L_0x02e1
        L_0x02b6:
            r22 = r8
            r8 = 0
            int r12 = zzh(r10, r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r13 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13.<init>(r10, r8, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfjm.zza(r13)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = 47
            int r13 = r8.indexOf(r13)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r14 = -1
            if (r13 != r14) goto L_0x02e1
            java.lang.String r13 = "image/"
            int r14 = r8.length()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r14 == 0) goto L_0x02dc
            java.lang.String r8 = r13.concat(r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x02e1
        L_0x02dc:
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r8.<init>(r13)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
        L_0x02e1:
            int r13 = r12 + 1
            byte r13 = r10[r13]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14 = 2
            int r12 = r12 + r14
            int r14 = zzg(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r15 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r23 = r4
            int r4 = r14 - r12
            r15.<init>(r10, r12, r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r2 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r14 = r14 + r2
            byte[] r2 = zzj(r10, r14, r7)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzabr r3 = new com.google.android.gms.internal.ads.zzabr     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r3.<init>(r8, r15, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x035a
        L_0x0305:
            r2 = r8
            goto L_0x0558
        L_0x0308:
            r23 = r4
            r22 = r8
            r4 = 77
            if (r12 != r13) goto L_0x0360
            r7 = 79
            if (r5 != r7) goto L_0x0360
            if (r6 != r4) goto L_0x0360
            if (r9 == r4) goto L_0x031b
            r7 = 2
            if (r0 != r7) goto L_0x0360
        L_0x031b:
            r2 = 4
            if (r11 >= r2) goto L_0x0324
            r3 = r5
            r4 = r6
            r8 = r9
            r13 = 0
            goto L_0x0521
        L_0x0324:
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r3 = zze(r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r4 = 3
            byte[] r7 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r8 = 0
            r1.zzm(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r10.<init>(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r4 = r11 + -4
            byte[] r7 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r1.zzm(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r4 = zzg(r7, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r12.<init>(r7, r8, r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r8 = zzi(r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r4 = r4 + r8
            int r2 = zzg(r7, r4, r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r2 = zzk(r7, r4, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzabz r3 = new com.google.android.gms.internal.ads.zzabz     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r3.<init>(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
        L_0x035a:
            r13 = r3
            r3 = r5
            r4 = r6
        L_0x035d:
            r8 = r9
            goto L_0x0521
        L_0x0360:
            if (r12 != r13) goto L_0x03e1
            r7 = 72
            if (r5 != r7) goto L_0x03e1
            r7 = 65
            if (r6 != r7) goto L_0x03e1
            r7 = 80
            if (r9 != r7) goto L_0x03e1
            int r4 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r7 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = zzh(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r10 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r12 = r7 - r4
            r8.<init>(r10, r4, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r10 = 1
            int r7 = r7 + r10
            r1.zzh(r7)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r26 = r35.zzv()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r27 = r35.zzv()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            long r12 = r35.zzt()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x03a1
            r12 = -1
        L_0x03a1:
            r28 = r12
            long r12 = r35.zzt()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x03b2
            r12 = -1
        L_0x03b2:
            r30 = r12
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r7.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r4 = r4 + r11
        L_0x03ba:
            int r10 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r10 >= r4) goto L_0x03cb
            r10 = 0
            com.google.android.gms.internal.ads.zzacg r12 = zzc(r0, r1, r2, r3, r10)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r12 == 0) goto L_0x03ba
            r7.add(r12)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x03ba
        L_0x03cb:
            r2 = 0
            com.google.android.gms.internal.ads.zzacg[] r2 = new com.google.android.gms.internal.ads.zzacg[r2]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.Object[] r2 = r7.toArray(r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r32 = r2
            com.google.android.gms.internal.ads.zzacg[] r32 = (com.google.android.gms.internal.ads.zzacg[]) r32     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzabv r3 = new com.google.android.gms.internal.ads.zzabv     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r24 = r3
            r25 = r8
            r24.<init>(r25, r26, r27, r28, r30, r32)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x035a
        L_0x03e1:
            if (r12 != r13) goto L_0x0495
            r7 = 84
            if (r5 != r7) goto L_0x0495
            r7 = 79
            if (r6 != r7) goto L_0x0495
            if (r9 != r13) goto L_0x0495
            int r4 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r7 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = zzh(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r10 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r12 = r7 - r4
            r8.<init>(r10, r4, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r10 = 1
            int r7 = r7 + r10
            r1.zzh(r7)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r12 = r7 & 2
            if (r12 == 0) goto L_0x0414
            r26 = 1
            goto L_0x0416
        L_0x0414:
            r26 = 0
        L_0x0416:
            r7 = r7 & r10
            int r10 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.String[] r12 = new java.lang.String[r10]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = 0
        L_0x041e:
            if (r13 >= r10) goto L_0x0451
            int r14 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r38 = r10
            byte[] r10 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r10 = zzh(r10, r14)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r16 = r9
            java.lang.String r9 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r17 = r6
            byte[] r6 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r20 = r5
            int r5 = r10 - r14
            r9.<init>(r6, r14, r5, r15)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r12[r13] = r9     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r10 = r10 + 1
            r1.zzh(r10)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r13 = r13 + 1
            r10 = r38
            r9 = r16
            r6 = r17
            r5 = r20
            goto L_0x041e
        L_0x0451:
            r20 = r5
            r17 = r6
            r16 = r9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r5.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r4 = r4 + r11
        L_0x045d:
            int r6 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r6 >= r4) goto L_0x046e
            r6 = 0
            com.google.android.gms.internal.ads.zzacg r9 = zzc(r0, r1, r2, r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            if (r9 == 0) goto L_0x045d
            r5.add(r9)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            goto L_0x045d
        L_0x046e:
            r2 = 0
            com.google.android.gms.internal.ads.zzacg[] r3 = new com.google.android.gms.internal.ads.zzacg[r2]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            java.lang.Object[] r2 = r5.toArray(r3)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r29 = r2
            com.google.android.gms.internal.ads.zzacg[] r29 = (com.google.android.gms.internal.ads.zzacg[]) r29     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzabx r3 = new com.google.android.gms.internal.ads.zzabx     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r2 = 1
            if (r2 == r7) goto L_0x0481
            r27 = 0
            goto L_0x0483
        L_0x0481:
            r27 = 1
        L_0x0483:
            r24 = r3
            r25 = r8
            r28 = r12
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = r3
            r8 = r16
            r4 = r17
            r3 = r20
            goto L_0x0521
        L_0x0495:
            r20 = r5
            r17 = r6
            r16 = r9
            if (r12 != r4) goto L_0x050b
            r2 = 76
            r3 = r20
            if (r3 != r2) goto L_0x0506
            r2 = 76
            r4 = r17
            r8 = r16
            if (r4 != r2) goto L_0x0511
            r2 = 84
            if (r8 != r2) goto L_0x0511
            int r25 = r35.zzo()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r26 = r35.zzr()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r27 = r35.zzr()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r2 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r5 = r35.zzn()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzakq r6 = new com.google.android.gms.internal.ads.zzakq     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r7 = r35.zzi()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r9 = r35.zze()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r6.zza(r7, r9)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = r35.zzg()     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = r7 * 8
            r6.zzd(r7)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r7 = r11 + -10
            int r7 = r7 * 8
            int r9 = r2 + r5
            int r7 = r7 / r9
            int[] r9 = new int[r7]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int[] r10 = new int[r7]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r12 = 0
        L_0x04e8:
            if (r12 >= r7) goto L_0x04f9
            int r13 = r6.zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r14 = r6.zzh(r5)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r9[r12] = r13     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r10[r12] = r14     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            int r12 = r12 + 1
            goto L_0x04e8
        L_0x04f9:
            com.google.android.gms.internal.ads.zzack r2 = new com.google.android.gms.internal.ads.zzack     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r24 = r2
            r28 = r9
            r29 = r10
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = r2
            goto L_0x0521
        L_0x0506:
            r8 = r16
            r4 = r17
            goto L_0x0511
        L_0x050b:
            r8 = r16
            r4 = r17
            r3 = r20
        L_0x0511:
            java.lang.String r2 = zzf(r0, r12, r3, r4, r8)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            byte[] r5 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r6 = 0
            r1.zzm(r5, r6, r11)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            com.google.android.gms.internal.ads.zzabt r6 = new com.google.android.gms.internal.ads.zzabt     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r6.<init>(r2, r5)     // Catch:{ UnsupportedEncodingException -> 0x0561, all -> 0x0552 }
            r13 = r6
        L_0x0521:
            if (r13 != 0) goto L_0x055b
            r2 = r23
            java.lang.String r0 = zzf(r0, r2, r3, r4, r8)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            int r2 = r2.length()     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            int r2 = r2 + 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            r3.<init>(r2)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            java.lang.String r2 = "Failed to decode frame: id="
            r3.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            java.lang.String r0 = ", frameSize="
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            r3.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            java.lang.String r0 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x0556, all -> 0x0552 }
            r2 = r22
            android.util.Log.w(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0552 }
            goto L_0x055b
        L_0x0552:
            r0 = move-exception
            r14 = r21
            goto L_0x056f
        L_0x0556:
            r2 = r22
        L_0x0558:
            r14 = r21
            goto L_0x0565
        L_0x055b:
            r14 = r21
            r1.zzh(r14)
            return r13
        L_0x0561:
            r14 = r21
            r2 = r22
        L_0x0565:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0162 }
            r1.zzh(r14)
            r0 = 0
            return r0
        L_0x056f:
            r1.zzh(r14)
            throw r0
        L_0x0573:
            r2 = r8
            r0 = r13
            java.lang.String r3 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r2, r3)
            r1.zzh(r14)
            return r0
        L_0x057e:
            r0 = r13
            r1.zzh(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacf.zzc(int, com.google.android.gms.internal.ads.zzakr, boolean, int, com.google.android.gms.internal.ads.zzacd):com.google.android.gms.internal.ads.zzacg");
    }

    public static int zzd(zzakr zzakr, int i) {
        byte[] zzi = zzakr.zzi();
        int zzg = zzakr.zzg();
        int i2 = zzg;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzg + i) {
                return i;
            }
            if ((zzi[i2] & Base64.EQUALS_SIGN_ENC) == 255 && zzi[i3] == 0) {
                System.arraycopy(zzi, i2 + 2, zzi, i3, (i - (i2 - zzg)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    public static String zze(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    public static String zzf(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    public static int zzg(byte[] bArr, int i, int i2) {
        int zzh = zzh(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzh;
        }
        while (true) {
            int length = bArr.length;
            if (zzh >= length - 1) {
                return length;
            }
            if (zzh % 2 == 0 && bArr[zzh + 1] == 0) {
                return zzh;
            }
            zzh = zzh(bArr, zzh + 1);
        }
    }

    public static int zzh(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    public static int zzi(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static byte[] zzj(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzalh.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    public static String zzk(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }
}
