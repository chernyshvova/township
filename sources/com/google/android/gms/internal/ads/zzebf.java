package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebf implements zzfcb<zzebd, zzebe> {
    public final Context zza;
    public final String zzb;
    public final zzcbw zzc;

    public zzebf(Context context, String str, zzcbw zzcbw, int i, byte[] bArr) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzcbw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r2 = new java.io.InputStreamReader(r7.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        com.google.android.gms.ads.internal.zzs.zzc();
        r0 = new java.lang.StringBuilder(8192);
        r3 = new char[2048];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014f, code lost:
        r6 = r2.read(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0154, code lost:
        if (r6 == -1) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0156, code lost:
        r0.append(r3, 0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015b, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r4.zze(r0);
        r5.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016b, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017d, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzdM)).booleanValue() == false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0186, code lost:
        throw new com.google.android.gms.internal.ads.zzdxy(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0187, code lost:
        r5.zzd = com.google.android.gms.ads.internal.zzs.zzj().elapsedRealtime() - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0197, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0217, code lost:
        throw new com.google.android.gms.internal.ads.zzdxy(1, r4.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x023e A[Catch:{ all -> 0x024d }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x024c A[Catch:{ all -> 0x024d }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x0192=Splitter:B:68:0x0192, B:113:0x024e=Splitter:B:113:0x024e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(java.lang.Object r20) throws java.lang.Exception {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "Received error HTTP response code: "
            r2 = r20
            com.google.android.gms.internal.ads.zzebd r2 = (com.google.android.gms.internal.ads.zzebd) r2
            java.lang.String r3 = r2.zza
            int r11 = r2.zzb
            java.util.Map<java.lang.String, java.lang.String> r12 = r2.zzc
            java.lang.String r2 = r2.zzd
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzs.zzj()
            long r13 = r4.elapsedRealtime()
            r15 = 1
            com.google.android.gms.internal.ads.zzebe r10 = new com.google.android.gms.internal.ads.zzebe     // Catch:{ IOException -> 0x0252 }
            r10.<init>()     // Catch:{ IOException -> 0x0252 }
            java.lang.String r4 = "SDK version: "
            java.lang.String r5 = r1.zzb     // Catch:{ IOException -> 0x0252 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0252 }
            int r6 = r5.length()     // Catch:{ IOException -> 0x0252 }
            if (r6 == 0) goto L_0x0031
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x0252 }
            goto L_0x0037
        L_0x0031:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x0252 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0252 }
            r4 = r5
        L_0x0037:
            com.google.android.gms.internal.ads.zzcgs.zzh(r4)     // Catch:{ IOException -> 0x0252 }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0252 }
            int r6 = r5.length()     // Catch:{ IOException -> 0x0252 }
            if (r6 == 0) goto L_0x004b
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x0252 }
            goto L_0x0051
        L_0x004b:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x0252 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0252 }
            r4 = r5
        L_0x0051:
            com.google.android.gms.internal.ads.zzcgs.zzd(r4)     // Catch:{ IOException -> 0x0252 }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0252 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0252 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x0252 }
            r3.<init>()     // Catch:{ IOException -> 0x0252 }
            r9 = 0
            r16 = 0
        L_0x0061:
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0252 }
            r8 = r4
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x0252 }
            com.google.android.gms.ads.internal.util.zzr r4 = com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ zzdxy -> 0x0229, all -> 0x0226 }
            android.content.Context r5 = r1.zza     // Catch:{ zzdxy -> 0x0229, all -> 0x0226 }
            java.lang.String r6 = r1.zzb     // Catch:{ zzdxy -> 0x0229, all -> 0x0226 }
            r7 = 0
            r17 = 0
            r20 = r8
            r9 = r17
            r18 = r10
            r10 = r11
            r4.zzb(r5, r6, r7, r8, r9, r10)     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.util.Set r4 = r12.entrySet()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
        L_0x0085:
            boolean r5 = r4.hasNext()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            if (r5 == 0) goto L_0x00a5
            java.lang.Object r5 = r4.next()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.lang.Object r6 = r5.getKey()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.lang.Object r5 = r5.getValue()     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ zzdxy -> 0x0220, all -> 0x021c }
            r7 = r20
            r7.addRequestProperty(r6, r5)     // Catch:{ zzdxy -> 0x021a }
            r20 = r7
            goto L_0x0085
        L_0x00a5:
            r7 = r20
            int r4 = r2.length()     // Catch:{ zzdxy -> 0x021a }
            r5 = 0
            if (r4 <= 0) goto L_0x00d3
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzfjs.zzc     // Catch:{ zzdxy -> 0x021a }
            byte[] r4 = r2.getBytes(r4)     // Catch:{ zzdxy -> 0x021a }
            r7.setDoOutput(r15)     // Catch:{ zzdxy -> 0x021a }
            int r6 = r4.length     // Catch:{ zzdxy -> 0x021a }
            r7.setFixedLengthStreamingMode(r6)     // Catch:{ zzdxy -> 0x021a }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00ce }
            java.io.OutputStream r8 = r7.getOutputStream()     // Catch:{ all -> 0x00ce }
            r6.<init>(r8)     // Catch:{ all -> 0x00ce }
            r6.write(r4)     // Catch:{ all -> 0x00cb }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r6)     // Catch:{ zzdxy -> 0x021a }
            goto L_0x00d3
        L_0x00cb:
            r0 = move-exception
            r5 = r6
            goto L_0x00cf
        L_0x00ce:
            r0 = move-exception
        L_0x00cf:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)     // Catch:{ zzdxy -> 0x021a }
            throw r0     // Catch:{ zzdxy -> 0x021a }
        L_0x00d3:
            com.google.android.gms.internal.ads.zzcgr r4 = new com.google.android.gms.internal.ads.zzcgr     // Catch:{ zzdxy -> 0x021a }
            r4.<init>(r5)     // Catch:{ zzdxy -> 0x021a }
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzfjs.zzc     // Catch:{ zzdxy -> 0x021a }
            byte[] r6 = r2.getBytes(r6)     // Catch:{ zzdxy -> 0x021a }
            r4.zza(r7, r6)     // Catch:{ zzdxy -> 0x021a }
            int r6 = r7.getResponseCode()     // Catch:{ zzdxy -> 0x021a }
            java.util.Map r8 = r7.getHeaderFields()     // Catch:{ zzdxy -> 0x021a }
            java.util.Set r8 = r8.entrySet()     // Catch:{ zzdxy -> 0x021a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ zzdxy -> 0x021a }
        L_0x00f1:
            boolean r9 = r8.hasNext()     // Catch:{ zzdxy -> 0x021a }
            if (r9 == 0) goto L_0x0123
            java.lang.Object r9 = r8.next()     // Catch:{ zzdxy -> 0x021a }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ zzdxy -> 0x021a }
            java.lang.Object r10 = r9.getKey()     // Catch:{ zzdxy -> 0x021a }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ zzdxy -> 0x021a }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzdxy -> 0x021a }
            java.util.List r9 = (java.util.List) r9     // Catch:{ zzdxy -> 0x021a }
            boolean r17 = r3.containsKey(r10)     // Catch:{ zzdxy -> 0x021a }
            if (r17 == 0) goto L_0x0119
            java.lang.Object r10 = r3.get(r10)     // Catch:{ zzdxy -> 0x021a }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzdxy -> 0x021a }
            r10.addAll(r9)     // Catch:{ zzdxy -> 0x021a }
            goto L_0x00f1
        L_0x0119:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ zzdxy -> 0x021a }
            r5.<init>(r9)     // Catch:{ zzdxy -> 0x021a }
            r3.put(r10, r5)     // Catch:{ zzdxy -> 0x021a }
            r5 = 0
            goto L_0x00f1
        L_0x0123:
            r4.zzc(r7, r6)     // Catch:{ zzdxy -> 0x021a }
            r5 = r18
            r5.zza = r6     // Catch:{ zzdxy -> 0x0218 }
            r5.zzb = r3     // Catch:{ zzdxy -> 0x0218 }
            java.lang.String r8 = ""
            r5.zzc = r8     // Catch:{ zzdxy -> 0x0218 }
            r8 = 200(0xc8, float:2.8E-43)
            r9 = 300(0x12c, float:4.2E-43)
            if (r6 < r8) goto L_0x019f
            if (r6 >= r9) goto L_0x019f
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0199 }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x0199 }
            r2.<init>(r0)     // Catch:{ all -> 0x0199 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0197 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3)     // Catch:{ all -> 0x0197 }
            r3 = 2048(0x800, float:2.87E-42)
            char[] r3 = new char[r3]     // Catch:{ all -> 0x0197 }
        L_0x014f:
            int r6 = r2.read(r3)     // Catch:{ all -> 0x0197 }
            r8 = -1
            if (r6 == r8) goto L_0x015b
            r8 = 0
            r0.append(r3, r8, r6)     // Catch:{ all -> 0x0197 }
            goto L_0x014f
        L_0x015b:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzdxy -> 0x0218 }
            r4.zze(r0)     // Catch:{ zzdxy -> 0x0218 }
            r5.zzc = r0     // Catch:{ zzdxy -> 0x0218 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzdxy -> 0x0218 }
            if (r0 == 0) goto L_0x0187
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzdM     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ zzdxy -> 0x0218 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ zzdxy -> 0x0218 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzdxy -> 0x0218 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzdxy -> 0x0218 }
            if (r0 == 0) goto L_0x0180
            goto L_0x0187
        L_0x0180:
            com.google.android.gms.internal.ads.zzdxy r0 = new com.google.android.gms.internal.ads.zzdxy     // Catch:{ zzdxy -> 0x0218 }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzdxy -> 0x0218 }
            throw r0     // Catch:{ zzdxy -> 0x0218 }
        L_0x0187:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ zzdxy -> 0x0218 }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzdxy -> 0x0218 }
            long r2 = r2 - r13
            r5.zzd = r2     // Catch:{ zzdxy -> 0x0218 }
        L_0x0192:
            r7.disconnect()     // Catch:{ IOException -> 0x0252 }
            goto L_0x024b
        L_0x0197:
            r0 = move-exception
            goto L_0x019b
        L_0x0199:
            r0 = move-exception
            r2 = 0
        L_0x019b:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzdxy -> 0x0218 }
            throw r0     // Catch:{ zzdxy -> 0x0218 }
        L_0x019f:
            r8 = 0
            if (r6 < r9) goto L_0x01ef
            r4 = 400(0x190, float:5.6E-43)
            if (r6 >= r4) goto L_0x01ef
            java.lang.String r4 = "Location"
            java.lang.String r4 = r7.getHeaderField(r4)     // Catch:{ zzdxy -> 0x0218 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ zzdxy -> 0x0218 }
            if (r6 != 0) goto L_0x01e2
            java.net.URL r6 = new java.net.URL     // Catch:{ zzdxy -> 0x0218 }
            r6.<init>(r4)     // Catch:{ zzdxy -> 0x0218 }
            int r4 = r16 + 1
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzbjn.zzdn     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzbjl r10 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ zzdxy -> 0x0218 }
            java.lang.Object r9 = r10.zzb(r9)     // Catch:{ zzdxy -> 0x0218 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ zzdxy -> 0x0218 }
            int r9 = r9.intValue()     // Catch:{ zzdxy -> 0x0218 }
            if (r4 > r9) goto L_0x01d5
            r7.disconnect()     // Catch:{ IOException -> 0x0252 }
            r16 = r4
            r10 = r5
            r4 = r6
            r9 = 0
            goto L_0x0061
        L_0x01d5:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzdxy r0 = new com.google.android.gms.internal.ads.zzdxy     // Catch:{ zzdxy -> 0x0218 }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r15, r2)     // Catch:{ zzdxy -> 0x0218 }
            throw r0     // Catch:{ zzdxy -> 0x0218 }
        L_0x01e2:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzcgs.zzi(r0)     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzdxy r0 = new com.google.android.gms.internal.ads.zzdxy     // Catch:{ zzdxy -> 0x0218 }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r15, r2)     // Catch:{ zzdxy -> 0x0218 }
            throw r0     // Catch:{ zzdxy -> 0x0218 }
        L_0x01ef:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ zzdxy -> 0x0218 }
            r3 = 46
            r2.<init>(r3)     // Catch:{ zzdxy -> 0x0218 }
            r2.append(r0)     // Catch:{ zzdxy -> 0x0218 }
            r2.append(r6)     // Catch:{ zzdxy -> 0x0218 }
            java.lang.String r2 = r2.toString()     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzcgs.zzi(r2)     // Catch:{ zzdxy -> 0x0218 }
            com.google.android.gms.internal.ads.zzdxy r2 = new com.google.android.gms.internal.ads.zzdxy     // Catch:{ zzdxy -> 0x0218 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzdxy -> 0x0218 }
            r4.<init>(r3)     // Catch:{ zzdxy -> 0x0218 }
            r4.append(r0)     // Catch:{ zzdxy -> 0x0218 }
            r4.append(r6)     // Catch:{ zzdxy -> 0x0218 }
            java.lang.String r0 = r4.toString()     // Catch:{ zzdxy -> 0x0218 }
            r2.<init>(r15, r0)     // Catch:{ zzdxy -> 0x0218 }
            throw r2     // Catch:{ zzdxy -> 0x0218 }
        L_0x0218:
            r0 = move-exception
            goto L_0x022c
        L_0x021a:
            r0 = move-exception
            goto L_0x0223
        L_0x021c:
            r0 = move-exception
            r7 = r20
            goto L_0x024e
        L_0x0220:
            r0 = move-exception
            r7 = r20
        L_0x0223:
            r5 = r18
            goto L_0x022c
        L_0x0226:
            r0 = move-exception
            r7 = r8
            goto L_0x024e
        L_0x0229:
            r0 = move-exception
            r7 = r8
            r5 = r10
        L_0x022c:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzbjn.zzfI     // Catch:{ all -> 0x024d }
            com.google.android.gms.internal.ads.zzbjl r3 = com.google.android.gms.internal.ads.zzbex.zzc()     // Catch:{ all -> 0x024d }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ all -> 0x024d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x024d }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x024d }
            if (r2 == 0) goto L_0x024c
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ all -> 0x024d }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x024d }
            long r2 = r2 - r13
            r5.zzd = r2     // Catch:{ all -> 0x024d }
            goto L_0x0192
        L_0x024b:
            return r5
        L_0x024c:
            throw r0     // Catch:{ all -> 0x024d }
        L_0x024d:
            r0 = move-exception
        L_0x024e:
            r7.disconnect()     // Catch:{ IOException -> 0x0252 }
            throw r0     // Catch:{ IOException -> 0x0252 }
        L_0x0252:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Error while connecting to ad server: "
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0268
            java.lang.String r2 = r3.concat(r2)
            goto L_0x026d
        L_0x0268:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
        L_0x026d:
            com.google.android.gms.internal.ads.zzcgs.zzi(r2)
            com.google.android.gms.internal.ads.zzdxy r3 = new com.google.android.gms.internal.ads.zzdxy
            r3.<init>(r15, r2, r0)
            goto L_0x0277
        L_0x0276:
            throw r3
        L_0x0277:
            goto L_0x0276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebf.zza(java.lang.Object):java.lang.Object");
    }
}
