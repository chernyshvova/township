package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcla extends zzckx {
    public static final /* synthetic */ int zzd = 0;
    public static final Set<String> zze = Collections.synchronizedSet(new HashSet());
    public static final DecimalFormat zzf = new DecimalFormat("#,###");
    public File zzg;
    public boolean zzh;

    public zzcla(zzciz zzciz) {
        super(zzciz);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzcgs.zzi("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String valueOf = String.valueOf(this.zzg.getAbsolutePath());
            zzcgs.zzi(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzg = null;
        } else if (!this.zzg.setReadable(true, false) || !this.zzg.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzg.getAbsolutePath());
            zzcgs.zzi(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzg = null;
        }
    }

    private final File zzj(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02a9, code lost:
        r19 = r5.read(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ad, code lost:
        if (r19 < 0) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02af, code lost:
        r13 = r13 + r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02b1, code lost:
        if (r13 <= r6) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b3, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c3, code lost:
        if (r1.length() == 0) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c5, code lost:
        r11 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d0, code lost:
        r11 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02d8, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02d9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02dc, code lost:
        r2 = r11;
        r1 = r14;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02e1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02e4, code lost:
        r11 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r2.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ef, code lost:
        if (r3.write(r2) > 0) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02f1, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0300, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r10)) goto L_0x0376;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0302, code lost:
        r19 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0306, code lost:
        if (r8.zzh != false) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x030c, code lost:
        if (r1.zza() == false) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x030e, code lost:
        r20 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0314, code lost:
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0318, code lost:
        r23 = r1;
        r1 = r1;
        r24 = r14;
        r14 = com.google.android.gms.internal.ads.zzcgl.zza;
        r25 = r3;
        r26 = r4;
        r4 = r20;
        r20 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzckr(r29, r30, r4, r13, r7, false);
        r14.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x033b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x033d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x033e, code lost:
        r26 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0342, code lost:
        r23 = r1;
        r25 = r3;
        r26 = r4;
        r20 = r5;
        r27 = r6;
        r28 = r7;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0352, code lost:
        r2 = r19;
        r5 = r20;
        r15 = r21;
        r1 = r23;
        r14 = r24;
        r3 = r25;
        r4 = r26;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0366, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0375, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0376, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r0 = java.lang.Long.toString(r10);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a9, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03ad, code lost:
        r2 = r2.toString();
        r1 = r24;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03b4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03b7, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03be, code lost:
        r26 = r4;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03c2, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03c5, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r26.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d3, code lost:
        if (com.google.android.gms.internal.ads.zzcgs.zzm(3) == false) goto L_0x040b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03d5, code lost:
        r1 = zzf.format((long) r13);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r30).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzcgs.zzd(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x040b, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0414, code lost:
        if (r0.isFile() == false) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0416, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        zzl(r9, r12.getAbsolutePath(), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x042a, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x042f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0431, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0435, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0437, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0438, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x043b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x043e, code lost:
        r26 = r4;
        r1 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0443, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0445, code lost:
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0447, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0449, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x044c, code lost:
        r1 = r14;
        r15 = r15;
        r2 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0455, code lost:
        if ((r0 instanceof java.lang.RuntimeException) != false) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0457, code lost:
        com.google.android.gms.ads.internal.zzs.zzg().zzg(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0467, code lost:
        if (r8.zzh == false) goto L_0x048d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0469, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzcgs.zzh(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x048d, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzcgs.zzj(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04bc, code lost:
        r0 = java.lang.String.valueOf(r12.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04ca, code lost:
        if (r0.length() == 0) goto L_0x04d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04cc, code lost:
        r0 = "Could not delete partial cache file at ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04d1, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04d6, code lost:
        com.google.android.gms.internal.ads.zzcgs.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04d9, code lost:
        zzn(r9, r12.getAbsolutePath(), r15, r2);
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0128, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1 = com.google.android.gms.internal.ads.zzfix.zza().zzb(new com.google.android.gms.internal.ads.zzckz(r9), 265, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013c, code lost:
        if ((r1 instanceof java.net.HttpURLConnection) == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013e, code lost:
        r2 = r1.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0144, code lost:
        if (r2 < 400) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0146, code lost:
        r15 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0156, code lost:
        if (r1.length() == 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0158, code lost:
        r1 = "HTTP request failed. Code: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015e, code lost:
        r1 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r2);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018f, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0191, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0194, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0195, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r7 = r1.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019c, code lost:
        if (r7 >= 0) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019e, code lost:
        r1 = java.lang.String.valueOf(r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a8, code lost:
        if (r1.length() == 0) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01aa, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01af, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b5, code lost:
        com.google.android.gms.internal.ads.zzcgs.zzi(r0);
        zzn(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c6, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c7, code lost:
        r2 = zzf.format((long) r7);
        r6 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzq)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01de, code lost:
        if (r7 <= r6) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e0, code lost:
        r1 = new java.lang.StringBuilder((java.lang.String.valueOf(r2).length() + 33) + java.lang.String.valueOf(r30).length());
        r1.append("Content length ");
        r1.append(r2);
        r1.append(" exceeds limit at ");
        r1.append(r9);
        com.google.android.gms.internal.ads.zzcgs.zzi(r1.toString());
        r1 = java.lang.String.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0219, code lost:
        if (r1.length() == 0) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x021b, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0220, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0226, code lost:
        zzn(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0234, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0235, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r2).length() + 20) + java.lang.String.valueOf(r30).length());
        r4.append("Caching ");
        r4.append(r2);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzcgs.zzd(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r1.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r3 = r4.getChannel();
        r2 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzs.zzj();
        r17 = r16.currentTimeMillis();
        r1 = new com.google.android.gms.ads.internal.util.zzca(((java.lang.Long) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzt)).longValue());
        r10 = ((java.lang.Long) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzs)).longValue();
        r13 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x0421 */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0435 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r21 r24 r26 
      PHI: (r21v6 java.lang.String) = (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v15 java.lang.String), (r21v15 java.lang.String) binds: [B:160:0x03cb, B:169:0x0421, B:170:?, B:167:0x041e, B:168:?, B:131:0x0316, B:134:0x0334] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v8 java.lang.String), (r24v10 java.lang.String) binds: [B:160:0x03cb, B:169:0x0421, B:170:?, B:167:0x041e, B:168:?, B:131:0x0316, B:134:0x0334] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v7 java.io.FileOutputStream) = (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v13 java.io.FileOutputStream), (r26v16 java.io.FileOutputStream) binds: [B:160:0x03cb, B:169:0x0421, B:170:?, B:167:0x041e, B:168:?, B:131:0x0316, B:134:0x0334] A[DONT_GENERATE, DONT_INLINE], Splitter:B:134:0x0334] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r30) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            java.io.File r0 = r8.zzg
            r10 = 0
            r11 = 0
            if (r0 == 0) goto L_0x04ea
        L_0x000a:
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0010
            r3 = 0
            goto L_0x002c
        L_0x0010:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0017:
            if (r2 >= r1) goto L_0x002c
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x0029
            int r3 = r3 + 1
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x002c:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzbjn.zzp
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0090
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0043
            goto L_0x0085
        L_0x0043:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r11
            r4 = 0
        L_0x004f:
            if (r4 >= r1) goto L_0x006c
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0069
            long r12 = r6.lastModified()
            int r7 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0069
            r5 = r6
            r2 = r12
        L_0x0069:
            int r4 = r4 + 1
            goto L_0x004f
        L_0x006c:
            if (r5 == 0) goto L_0x0082
            boolean r0 = r5.delete()
            java.io.File r1 = r8.zzj(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0083
            boolean r1 = r1.delete()
            r0 = r0 & r1
            goto L_0x0083
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 != 0) goto L_0x000a
        L_0x0085:
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)
            java.lang.String r0 = "expireFailed"
            r8.zzn(r9, r11, r0, r11)
            return r10
        L_0x0090:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzcgl.zzd(r30)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzg
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzj(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d2
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d2
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "Stream cache hit at "
            int r3 = r0.length()
            if (r3 == 0) goto L_0x00c2
            java.lang.String r0 = r2.concat(r0)
            goto L_0x00c7
        L_0x00c2:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x00c7:
            com.google.android.gms.internal.ads.zzcgs.zzd(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzl(r9, r0, r1)
            return r13
        L_0x00d2:
            java.io.File r1 = r8.zzg
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r30)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00ec
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f2
        L_0x00ec:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f2:
            java.util.Set<java.lang.String> r1 = zze
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = zze     // Catch:{ all -> 0x04e7 }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x04e7 }
            if (r2 == 0) goto L_0x0122
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r30)     // Catch:{ all -> 0x04e7 }
            int r3 = r2.length()     // Catch:{ all -> 0x04e7 }
            if (r3 == 0) goto L_0x010e
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x04e7 }
            goto L_0x0114
        L_0x010e:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x04e7 }
            r2.<init>(r0)     // Catch:{ all -> 0x04e7 }
            r0 = r2
        L_0x0114:
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)     // Catch:{ all -> 0x04e7 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x04e7 }
            java.lang.String r2 = "inProgress"
            r8.zzn(r9, r0, r2, r11)     // Catch:{ all -> 0x04e7 }
            monitor-exit(r1)     // Catch:{ all -> 0x04e7 }
            return r10
        L_0x0122:
            java.util.Set<java.lang.String> r2 = zze     // Catch:{ all -> 0x04e7 }
            r2.add(r14)     // Catch:{ all -> 0x04e7 }
            monitor-exit(r1)     // Catch:{ all -> 0x04e7 }
            java.lang.String r15 = "error"
            com.google.android.gms.internal.ads.zzfje r1 = com.google.android.gms.internal.ads.zzfix.zza()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            com.google.android.gms.internal.ads.zzckz r2 = new com.google.android.gms.internal.ads.zzckz     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r3 = 265(0x109, float:3.71E-43)
            r4 = -1
            java.net.HttpURLConnection r1 = r1.zzb(r2, r3, r4)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            boolean r2 = r1 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            if (r2 == 0) goto L_0x0198
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r3 = 400(0x190, float:5.6E-43)
            if (r2 < r3) goto L_0x0198
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r1 = java.lang.Integer.toString(r2)     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
            int r3 = r1.length()     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
            if (r3 == 0) goto L_0x015e
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
            r1 = r0
            goto L_0x0163
        L_0x015e:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0193, RuntimeException -> 0x0191 }
        L_0x0163:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            java.lang.String r3 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            int r3 = r3.length()     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            r4.<init>(r3)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            r4.append(r2)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            java.lang.String r2 = " at "
            r4.append(r2)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            r4.append(r9)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            r0.<init>(r2)     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
            throw r0     // Catch:{ IOException -> 0x018e, RuntimeException -> 0x018c }
        L_0x018c:
            r0 = move-exception
            goto L_0x018f
        L_0x018e:
            r0 = move-exception
        L_0x018f:
            r2 = r1
            goto L_0x0195
        L_0x0191:
            r0 = move-exception
            goto L_0x0194
        L_0x0193:
            r0 = move-exception
        L_0x0194:
            r2 = r11
        L_0x0195:
            r1 = r14
            goto L_0x0453
        L_0x0198:
            int r7 = r1.getContentLength()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            if (r7 >= 0) goto L_0x01c7
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            if (r2 == 0) goto L_0x01af
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            goto L_0x01b5
        L_0x01af:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r0 = r1
        L_0x01b5:
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r1 = "contentLengthMissing"
            r8.zzn(r9, r0, r1, r11)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.util.Set<java.lang.String> r0 = zze     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r0.remove(r14)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            return r10
        L_0x01c7:
            java.text.DecimalFormat r2 = zzf     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            long r3 = (long) r7     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzbjn.zzq     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            com.google.android.gms.internal.ads.zzbjl r4 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r6 = r3.intValue()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            if (r7 <= r6) goto L_0x0235
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r0 = r0 + 33
            java.lang.String r1 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r0 = r0 + r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r0 = "Content length "
            r1.append(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r1.append(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r0 = " exceeds limit at "
            r1.append(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r1.append(r9)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            if (r2 == 0) goto L_0x0220
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            goto L_0x0226
        L_0x0220:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r0 = r1
        L_0x0226:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r2 = "sizeExceeded"
            r8.zzn(r9, r1, r2, r0)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.util.Set<java.lang.String> r0 = zze     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r0.remove(r14)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            return r10
        L_0x0235:
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r3 = r3 + 20
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r3 = "Caching "
            r4.append(r3)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r4.append(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r2 = " bytes from "
            r4.append(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r4.append(r9)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            com.google.android.gms.internal.ads.zzcgs.zzd(r2)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x044b, RuntimeException -> 0x0449 }
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzbjn.zzt     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.internal.ads.zzbjl r11 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            java.lang.Object r1 = r11.zzb(r1)     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            long r10 = r1.longValue()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.ads.internal.util.zzca r1 = new com.google.android.gms.ads.internal.util.zzca     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            r1.<init>(r10)     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r10 = com.google.android.gms.internal.ads.zzbjn.zzs     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            com.google.android.gms.internal.ads.zzbjl r11 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            java.lang.Object r10 = r11.zzb(r10)     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            long r10 = r10.longValue()     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            r13 = 0
        L_0x02a9:
            int r19 = r5.read(r2)     // Catch:{ IOException -> 0x043d, RuntimeException -> 0x043b }
            if (r19 < 0) goto L_0x03c5
            int r13 = r13 + r19
            if (r13 <= r6) goto L_0x02e8
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r13)     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            if (r2 == 0) goto L_0x02cb
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            r11 = r0
            goto L_0x02d1
        L_0x02cb:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x02e3, RuntimeException -> 0x02e1 }
            r11 = r1
        L_0x02d1:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            java.lang.String r1 = "stream cache file size limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
            throw r0     // Catch:{ IOException -> 0x02db, RuntimeException -> 0x02d9 }
        L_0x02d9:
            r0 = move-exception
            goto L_0x02dc
        L_0x02db:
            r0 = move-exception
        L_0x02dc:
            r2 = r11
            r1 = r14
            r11 = r4
            goto L_0x0453
        L_0x02e1:
            r0 = move-exception
            goto L_0x02e4
        L_0x02e3:
            r0 = move-exception
        L_0x02e4:
            r11 = r4
            r1 = r14
            goto L_0x0447
        L_0x02e8:
            r2.flip()     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
        L_0x02eb:
            int r19 = r3.write(r2)     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            if (r19 > 0) goto L_0x02eb
            r2.clear()     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            long r19 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            long r19 = r19 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r10
            int r23 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r23 > 0) goto L_0x0376
            r19 = r2
            boolean r2 = r8.zzh     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            if (r2 != 0) goto L_0x0366
            boolean r2 = r1.zza()     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            if (r2 == 0) goto L_0x0342
            java.lang.String r20 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            android.os.Handler r2 = com.google.android.gms.internal.ads.zzcgl.zza     // Catch:{ IOException -> 0x03bd, RuntimeException -> 0x03bb }
            r21 = r15
            com.google.android.gms.internal.ads.zzckr r15 = new com.google.android.gms.internal.ads.zzckr     // Catch:{ IOException -> 0x033d, RuntimeException -> 0x033b }
            r22 = 0
            r23 = r1
            r1 = r15
            r24 = r14
            r14 = r2
            r2 = r29
            r25 = r3
            r3 = r30
            r26 = r4
            r4 = r20
            r20 = r5
            r5 = r13
            r27 = r6
            r6 = r7
            r28 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r14.post(r15)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            goto L_0x0352
        L_0x033b:
            r0 = move-exception
            goto L_0x033e
        L_0x033d:
            r0 = move-exception
        L_0x033e:
            r26 = r4
            goto L_0x03c2
        L_0x0342:
            r23 = r1
            r25 = r3
            r26 = r4
            r20 = r5
            r27 = r6
            r28 = r7
            r24 = r14
            r21 = r15
        L_0x0352:
            r2 = r19
            r5 = r20
            r15 = r21
            r1 = r23
            r14 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r7 = r28
            goto L_0x02a9
        L_0x0366:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            throw r0     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
        L_0x0376:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r10)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            r2.append(r0)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.lang.String r11 = r2.toString()     // Catch:{ IOException -> 0x03b6, RuntimeException -> 0x03b4 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x03ac, RuntimeException -> 0x03aa }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x03ac, RuntimeException -> 0x03aa }
            throw r0     // Catch:{ IOException -> 0x03ac, RuntimeException -> 0x03aa }
        L_0x03aa:
            r0 = move-exception
            goto L_0x03ad
        L_0x03ac:
            r0 = move-exception
        L_0x03ad:
            r2 = r11
            r1 = r24
            r11 = r26
            goto L_0x0453
        L_0x03b4:
            r0 = move-exception
            goto L_0x03b7
        L_0x03b6:
            r0 = move-exception
        L_0x03b7:
            r1 = r24
            goto L_0x0445
        L_0x03bb:
            r0 = move-exception
            goto L_0x03be
        L_0x03bd:
            r0 = move-exception
        L_0x03be:
            r26 = r4
            r21 = r15
        L_0x03c2:
            r1 = r14
            goto L_0x0443
        L_0x03c5:
            r26 = r4
            r24 = r14
            r21 = r15
            r26.close()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r1 = 3
            boolean r1 = com.google.android.gms.internal.ads.zzcgs.zzm(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            if (r1 == 0) goto L_0x040b
            java.text.DecimalFormat r1 = zzf     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            long r2 = (long) r13     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r3.append(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r3.append(r9)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            com.google.android.gms.internal.ads.zzcgs.zzd(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
        L_0x040b:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            if (r1 == 0) goto L_0x041e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            goto L_0x0421
        L_0x041e:
            r0.createNewFile()     // Catch:{ IOException -> 0x0421, RuntimeException -> 0x0435 }
        L_0x0421:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r8.zzl(r9, r0, r13)     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            java.util.Set<java.lang.String> r0 = zze     // Catch:{ IOException -> 0x0437, RuntimeException -> 0x0435 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x0433, RuntimeException -> 0x0431 }
            r0 = 1
            return r0
        L_0x0431:
            r0 = move-exception
            goto L_0x0443
        L_0x0433:
            r0 = move-exception
            goto L_0x0443
        L_0x0435:
            r0 = move-exception
            goto L_0x0438
        L_0x0437:
            r0 = move-exception
        L_0x0438:
            r1 = r24
            goto L_0x0443
        L_0x043b:
            r0 = move-exception
            goto L_0x043e
        L_0x043d:
            r0 = move-exception
        L_0x043e:
            r26 = r4
            r1 = r14
            r21 = r15
        L_0x0443:
            r15 = r21
        L_0x0445:
            r11 = r26
        L_0x0447:
            r2 = 0
            goto L_0x0453
        L_0x0449:
            r0 = move-exception
            goto L_0x044c
        L_0x044b:
            r0 = move-exception
        L_0x044c:
            r1 = r14
            r21 = r15
            r15 = r21
            r2 = 0
            r11 = 0
        L_0x0453:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0460
            com.google.android.gms.internal.ads.zzcgd r3 = com.google.android.gms.ads.internal.zzs.zzg()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zzg(r0, r4)
        L_0x0460:
            r11.close()     // Catch:{ IOException | NullPointerException -> 0x0464 }
            goto L_0x0465
        L_0x0464:
        L_0x0465:
            boolean r3 = r8.zzh
            if (r3 == 0) goto L_0x048d
            java.lang.String r0 = java.lang.String.valueOf(r30)
            int r0 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r0 = r0 + 26
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzcgs.zzh(r0)
            goto L_0x04b0
        L_0x048d:
            java.lang.String r3 = java.lang.String.valueOf(r30)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + 25
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.internal.ads.zzcgs.zzj(r3, r0)
        L_0x04b0:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x04d9
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x04d9
            java.lang.String r0 = r12.getAbsolutePath()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Could not delete partial cache file at "
            int r4 = r0.length()
            if (r4 == 0) goto L_0x04d1
            java.lang.String r0 = r3.concat(r0)
            goto L_0x04d6
        L_0x04d1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x04d6:
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)
        L_0x04d9:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzn(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = zze
            r0.remove(r1)
        L_0x04e5:
            r1 = 0
            return r1
        L_0x04e7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x04e7 }
            throw r0
        L_0x04ea:
            java.lang.String r0 = "noCacheDir"
            r1 = 0
            r8.zzn(r9, r1, r0, r1)
            goto L_0x04e5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcla.zza(java.lang.String):boolean");
    }

    public final void zzg() {
        this.zzh = true;
    }
}
