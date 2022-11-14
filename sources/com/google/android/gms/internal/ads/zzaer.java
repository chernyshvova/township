package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaer implements zzaiv, zzadk {
    public final /* synthetic */ zzaew zza;
    public final long zzb = zzadm.zza();
    public final Uri zzc;
    public final zzajc zzd;
    public final zzaen zze;
    public final zztd zzf;
    public final zzajj zzg;
    public final zzts zzh = new zzts();
    public volatile boolean zzi;
    public boolean zzj = true;
    public long zzk;
    public zzahx zzl = zzj(0);
    public long zzm = -1;
    @Nullable
    public zztz zzn;
    public boolean zzo;

    public zzaer(zzaew zzaew, Uri uri, zzaht zzaht, zzaen zzaen, zztd zztd, zzajj zzajj) {
        this.zza = zzaew;
        this.zzc = uri;
        this.zzd = new zzajc(zzaht);
        this.zze = zzaen;
        this.zzf = zztd;
        this.zzg = zzajj;
    }

    public static /* synthetic */ void zzi(zzaer zzaer, long j, long j2) {
        zzaer.zzh.zza = j;
        zzaer.zzk = j2;
        zzaer.zzj = true;
        zzaer.zzo = false;
    }

    private final zzahx zzj(long j) {
        zzahw zzahw = new zzahw();
        zzahw.zza(this.zzc);
        zzahw.zzc(j);
        zzahw.zzd(6);
        zzahw.zzb(zzaew.zzb);
        return zzahw.zze();
    }

    public final void zza(zzakr zzakr) {
        long j;
        if (!this.zzo) {
            j = this.zzk;
        } else {
            j = Math.max(this.zza.zzT(), this.zzk);
        }
        long j2 = j;
        int zzd2 = zzakr.zzd();
        zztz zztz = this.zzn;
        if (zztz != null) {
            zztx.zzb(zztz, zzakr, zzd2);
            zztz.zzd(j2, 1, zzd2, 0, (zzty) null);
            this.zzo = true;
            return;
        }
        throw null;
    }

    public final void zzb() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:71|72|(1:74)(1:75)|76) */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r7 = java.lang.String.valueOf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0125, code lost:
        if (r7.length() != 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0127, code lost:
        r7 = "Invalid metadata interval: ".concat(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012c, code lost:
        r7 = new java.lang.String("Invalid metadata interval: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0131, code lost:
        android.util.Log.w("IcyHeaders", r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x011d */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x022e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01ed A[EDGE_INSN: B:125:0x01ed->B:108:0x01ed ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0095 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b5 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cb A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d7 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e7 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f3 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0135 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0139 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0194 A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019d A[Catch:{ all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01aa A[SYNTHETIC, Splitter:B:93:0x01aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc() throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x022e
            r2 = -1
            r4 = 1
            r5 = 0
            com.google.android.gms.internal.ads.zzts r6 = r1.zzh     // Catch:{ all -> 0x020f }
            long r13 = r6.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzahx r6 = r1.zzj(r13)     // Catch:{ all -> 0x020f }
            r1.zzl = r6     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzajc r7 = r1.zzd     // Catch:{ all -> 0x020f }
            long r6 = r7.zzc(r6)     // Catch:{ all -> 0x020f }
            r1.zzm = r6     // Catch:{ all -> 0x020f }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0025
            long r6 = r6 + r13
            r1.zzm = r6     // Catch:{ all -> 0x020f }
        L_0x0025:
            com.google.android.gms.internal.ads.zzaew r6 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzajc r7 = r1.zzd     // Catch:{ all -> 0x020f }
            java.util.Map r7 = r7.zze()     // Catch:{ all -> 0x020f }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x020f }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x020f }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0087
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020f }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0069 }
            int r11 = r11 * 1000
            if (r11 <= 0) goto L_0x004a
            r8 = 1
            goto L_0x0066
        L_0x004a:
            java.lang.String r12 = "Invalid bitrate: "
            java.lang.String r15 = java.lang.String.valueOf(r8)     // Catch:{ NumberFormatException -> 0x006a }
            int r16 = r15.length()     // Catch:{ NumberFormatException -> 0x006a }
            if (r16 == 0) goto L_0x005b
            java.lang.String r12 = r12.concat(r15)     // Catch:{ NumberFormatException -> 0x006a }
            goto L_0x0061
        L_0x005b:
            java.lang.String r15 = new java.lang.String     // Catch:{ NumberFormatException -> 0x006a }
            r15.<init>(r12)     // Catch:{ NumberFormatException -> 0x006a }
            r12 = r15
        L_0x0061:
            android.util.Log.w(r9, r12)     // Catch:{ NumberFormatException -> 0x006a }
            r8 = 0
            r11 = -1
        L_0x0066:
            r16 = r11
            goto L_0x008a
        L_0x0069:
            r11 = -1
        L_0x006a:
            java.lang.String r12 = "Invalid bitrate header: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x020f }
            int r15 = r8.length()     // Catch:{ all -> 0x020f }
            if (r15 == 0) goto L_0x007b
            java.lang.String r8 = r12.concat(r8)     // Catch:{ all -> 0x020f }
            goto L_0x0080
        L_0x007b:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x020f }
            r8.<init>(r12)     // Catch:{ all -> 0x020f }
        L_0x0080:
            android.util.Log.w(r9, r8)     // Catch:{ all -> 0x020f }
            r16 = r11
            r8 = 0
            goto L_0x008a
        L_0x0087:
            r8 = 0
            r16 = -1
        L_0x008a:
            java.lang.String r11 = "icy-genre"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020f }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020f }
            r12 = 0
            if (r11 == 0) goto L_0x009f
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020f }
            r17 = r8
            r8 = 1
            goto L_0x00a1
        L_0x009f:
            r17 = r12
        L_0x00a1:
            java.lang.String r11 = "icy-name"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020f }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020f }
            if (r11 == 0) goto L_0x00b5
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020f }
            r18 = r8
            r8 = 1
            goto L_0x00b7
        L_0x00b5:
            r18 = r12
        L_0x00b7:
            java.lang.String r11 = "icy-url"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020f }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020f }
            if (r11 == 0) goto L_0x00cb
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020f }
            r19 = r8
            r8 = 1
            goto L_0x00cd
        L_0x00cb:
            r19 = r12
        L_0x00cd:
            java.lang.String r11 = "icy-pub"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020f }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020f }
            if (r11 == 0) goto L_0x00e7
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020f }
            java.lang.String r11 = "1"
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x020f }
            r20 = r8
            r8 = 1
            goto L_0x00e9
        L_0x00e7:
            r20 = 0
        L_0x00e9:
            java.lang.String r11 = "icy-metaint"
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x020f }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x020f }
            if (r7 == 0) goto L_0x0135
            java.lang.Object r7 = r7.get(r5)     // Catch:{ all -> 0x020f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x020f }
            int r11 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x011c }
            if (r11 <= 0) goto L_0x0101
            r8 = 1
            goto L_0x0119
        L_0x0101:
            java.lang.String r15 = java.lang.String.valueOf(r7)     // Catch:{ NumberFormatException -> 0x011d }
            int r21 = r15.length()     // Catch:{ NumberFormatException -> 0x011d }
            if (r21 == 0) goto L_0x0110
            java.lang.String r15 = r0.concat(r15)     // Catch:{ NumberFormatException -> 0x011d }
            goto L_0x0115
        L_0x0110:
            java.lang.String r15 = new java.lang.String     // Catch:{ NumberFormatException -> 0x011d }
            r15.<init>(r0)     // Catch:{ NumberFormatException -> 0x011d }
        L_0x0115:
            android.util.Log.w(r9, r15)     // Catch:{ NumberFormatException -> 0x011d }
            r11 = -1
        L_0x0119:
            r21 = r11
            goto L_0x0137
        L_0x011c:
            r11 = -1
        L_0x011d:
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x020f }
            int r15 = r7.length()     // Catch:{ all -> 0x020f }
            if (r15 == 0) goto L_0x012c
            java.lang.String r7 = r0.concat(r7)     // Catch:{ all -> 0x020f }
            goto L_0x0131
        L_0x012c:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x020f }
            r7.<init>(r0)     // Catch:{ all -> 0x020f }
        L_0x0131:
            android.util.Log.w(r9, r7)     // Catch:{ all -> 0x020f }
            goto L_0x0119
        L_0x0135:
            r21 = -1
        L_0x0137:
            if (r8 == 0) goto L_0x013f
            com.google.android.gms.internal.ads.zzabp r12 = new com.google.android.gms.internal.ads.zzabp     // Catch:{ all -> 0x020f }
            r15 = r12
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x020f }
        L_0x013f:
            com.google.android.gms.internal.ads.zzabp unused = r6.zzr = r12     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzajc r6 = r1.zzd     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzaew r7 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzabp r7 = r7.zzr     // Catch:{ all -> 0x020f }
            if (r7 == 0) goto L_0x0174
            com.google.android.gms.internal.ads.zzaew r7 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzabp r7 = r7.zzr     // Catch:{ all -> 0x020f }
            int r7 = r7.zzf     // Catch:{ all -> 0x020f }
            if (r7 == r10) goto L_0x0174
            com.google.android.gms.internal.ads.zzadl r6 = new com.google.android.gms.internal.ads.zzadl     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzajc r7 = r1.zzd     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzaew r8 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzabp r8 = r8.zzr     // Catch:{ all -> 0x020f }
            int r8 = r8.zzf     // Catch:{ all -> 0x020f }
            r6.<init>(r7, r8, r1)     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzaew r7 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zztz r7 = r7.zzv()     // Catch:{ all -> 0x020f }
            r1.zzn = r7     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzkc r8 = com.google.android.gms.internal.ads.zzaew.zzc     // Catch:{ all -> 0x020f }
            r7.zza(r8)     // Catch:{ all -> 0x020f }
        L_0x0174:
            r8 = r6
            com.google.android.gms.internal.ads.zzaen r7 = r1.zze     // Catch:{ all -> 0x020f }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzajc r6 = r1.zzd     // Catch:{ all -> 0x020f }
            java.util.Map r10 = r6.zze()     // Catch:{ all -> 0x020f }
            long r11 = r1.zzm     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zztd r15 = r1.zzf     // Catch:{ all -> 0x020f }
            r16 = r11
            r11 = r13
            r2 = r13
            r13 = r16
            r7.zza(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzaew r6 = r1.zza     // Catch:{ all -> 0x020f }
            com.google.android.gms.internal.ads.zzabp r6 = r6.zzr     // Catch:{ all -> 0x020f }
            if (r6 == 0) goto L_0x0199
            com.google.android.gms.internal.ads.zzaen r6 = r1.zze     // Catch:{ all -> 0x020f }
            r6.zzc()     // Catch:{ all -> 0x020f }
        L_0x0199:
            boolean r6 = r1.zzj     // Catch:{ all -> 0x020f }
            if (r6 == 0) goto L_0x01a6
            com.google.android.gms.internal.ads.zzaen r6 = r1.zze     // Catch:{ all -> 0x020f }
            long r7 = r1.zzk     // Catch:{ all -> 0x020f }
            r6.zze(r2, r7)     // Catch:{ all -> 0x020f }
            r1.zzj = r5     // Catch:{ all -> 0x020f }
        L_0x01a6:
            r13 = r2
            r2 = 0
        L_0x01a8:
            if (r2 != 0) goto L_0x01ed
            boolean r3 = r1.zzi     // Catch:{ all -> 0x01ea }
            if (r3 != 0) goto L_0x01e8
            com.google.android.gms.internal.ads.zzajj r3 = r1.zzg     // Catch:{ InterruptedException -> 0x01e2 }
            r3.zzc()     // Catch:{ InterruptedException -> 0x01e2 }
            com.google.android.gms.internal.ads.zzaen r3 = r1.zze     // Catch:{ all -> 0x01ea }
            com.google.android.gms.internal.ads.zzts r6 = r1.zzh     // Catch:{ all -> 0x01ea }
            int r2 = r3.zzf(r6)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.internal.ads.zzaen r3 = r1.zze     // Catch:{ all -> 0x01ea }
            long r6 = r3.zzd()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.internal.ads.zzaew r3 = r1.zza     // Catch:{ all -> 0x01ea }
            long r8 = r3.zzj     // Catch:{ all -> 0x01ea }
            long r8 = r8 + r13
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x01a8
            com.google.android.gms.internal.ads.zzajj r3 = r1.zzg     // Catch:{ all -> 0x01ea }
            r3.zzb()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.internal.ads.zzaew r3 = r1.zza     // Catch:{ all -> 0x01ea }
            android.os.Handler r3 = r3.zzp     // Catch:{ all -> 0x01ea }
            com.google.android.gms.internal.ads.zzaew r8 = r1.zza     // Catch:{ all -> 0x01ea }
            java.lang.Runnable r8 = r8.zzo     // Catch:{ all -> 0x01ea }
            r3.post(r8)     // Catch:{ all -> 0x01ea }
            r13 = r6
            goto L_0x01a8
        L_0x01e2:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01ea }
            r0.<init>()     // Catch:{ all -> 0x01ea }
            throw r0     // Catch:{ all -> 0x01ea }
        L_0x01e8:
            r2 = 0
            goto L_0x01ed
        L_0x01ea:
            r0 = move-exception
            r5 = r2
            goto L_0x0210
        L_0x01ed:
            if (r2 != r4) goto L_0x01f0
            goto L_0x0207
        L_0x01f0:
            com.google.android.gms.internal.ads.zzaen r3 = r1.zze
            long r3 = r3.zzd()
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0206
            com.google.android.gms.internal.ads.zzts r3 = r1.zzh
            com.google.android.gms.internal.ads.zzaen r4 = r1.zze
            long r4 = r4.zzd()
            r3.zza = r4
        L_0x0206:
            r5 = r2
        L_0x0207:
            com.google.android.gms.internal.ads.zzajc r2 = r1.zzd
            com.google.android.gms.internal.ads.zzalh.zzm(r2)
            if (r5 == 0) goto L_0x0004
            goto L_0x022e
        L_0x020f:
            r0 = move-exception
        L_0x0210:
            if (r5 == r4) goto L_0x0228
            com.google.android.gms.internal.ads.zzaen r2 = r1.zze
            long r2 = r2.zzd()
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0228
            com.google.android.gms.internal.ads.zzts r2 = r1.zzh
            com.google.android.gms.internal.ads.zzaen r3 = r1.zze
            long r3 = r3.zzd()
            r2.zza = r3
        L_0x0228:
            com.google.android.gms.internal.ads.zzajc r2 = r1.zzd
            com.google.android.gms.internal.ads.zzalh.zzm(r2)
            throw r0
        L_0x022e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaer.zzc():void");
    }
}
