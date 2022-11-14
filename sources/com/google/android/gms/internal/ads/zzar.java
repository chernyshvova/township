package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzar implements zzv {
    public final zzat zza;
    @Deprecated
    public final zzaq zzb;
    public final zzaq zzc;

    public zzar(zzaq zzaq) {
        zzat zzat = new zzat(4096);
        this.zzc = zzaq;
        this.zzb = zzaq;
        this.zza = zzat;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x021f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x020b */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027d A[Catch:{ IOException -> 0x0299 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0293 A[Catch:{ IOException -> 0x0299 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02b5 A[SYNTHETIC, Splitter:B:138:0x02b5] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02b8 A[EDGE_INSN: B:187:0x02b8->B:140:0x02b8 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzy zza(com.google.android.gms.internal.ads.zzac<?> r24) throws com.google.android.gms.internal.ads.zzal {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r2 = "Error occurred when closing InputStream"
            java.lang.String r3 = "Content-Type"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r7 = 1
            r8 = 0
            r9 = 0
            com.google.android.gms.internal.ads.zzl r0 = r24.zzk()     // Catch:{ IOException -> 0x02bb }
            if (r0 != 0) goto L_0x001b
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x02bb }
            goto L_0x003b
        L_0x001b:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IOException -> 0x02bb }
            r10.<init>()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r11 = r0.zzb     // Catch:{ IOException -> 0x02bb }
            if (r11 == 0) goto L_0x0029
            java.lang.String r12 = "If-None-Match"
            r10.put(r12, r11)     // Catch:{ IOException -> 0x02bb }
        L_0x0029:
            long r11 = r0.zzd     // Catch:{ IOException -> 0x02bb }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzaz.zzc(r11)     // Catch:{ IOException -> 0x02bb }
            r10.put(r0, r11)     // Catch:{ IOException -> 0x02bb }
        L_0x003a:
            r0 = r10
        L_0x003b:
            java.lang.String r10 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.lang.String r11 = r24.zzh()     // Catch:{ IOException -> 0x02bb }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x02bb }
            r12.<init>()     // Catch:{ IOException -> 0x02bb }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bb }
            java.util.Map r0 = r24.zzm()     // Catch:{ IOException -> 0x02bb }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bb }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02bb }
            r0.<init>(r11)     // Catch:{ IOException -> 0x02bb }
            java.net.URLConnection r11 = r0.openConnection()     // Catch:{ IOException -> 0x02bb }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ IOException -> 0x02bb }
            boolean r13 = java.net.HttpURLConnection.getFollowRedirects()     // Catch:{ IOException -> 0x02bb }
            r11.setInstanceFollowRedirects(r13)     // Catch:{ IOException -> 0x02bb }
            int r13 = r24.zzo()     // Catch:{ IOException -> 0x02bb }
            r11.setConnectTimeout(r13)     // Catch:{ IOException -> 0x02bb }
            r11.setReadTimeout(r13)     // Catch:{ IOException -> 0x02bb }
            r11.setUseCaches(r9)     // Catch:{ IOException -> 0x02bb }
            r11.setDoInput(r7)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r13 = "https"
            java.lang.String r0 = r0.getProtocol()     // Catch:{ IOException -> 0x02bb }
            r13.equals(r0)     // Catch:{ IOException -> 0x02bb }
            java.util.Set r0 = r12.keySet()     // Catch:{ all -> 0x02af }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02af }
        L_0x0083:
            boolean r13 = r0.hasNext()     // Catch:{ all -> 0x02af }
            if (r13 == 0) goto L_0x0099
            java.lang.Object r13 = r0.next()     // Catch:{ all -> 0x02af }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x02af }
            java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x02af }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x02af }
            r11.setRequestProperty(r13, r14)     // Catch:{ all -> 0x02af }
            goto L_0x0083
        L_0x0099:
            int r0 = r24.zza()     // Catch:{ all -> 0x02af }
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02af }
            byte[] r0 = r24.zzn()     // Catch:{ all -> 0x02af }
            if (r0 == 0) goto L_0x00cf
            r11.setDoOutput(r7)     // Catch:{ all -> 0x02af }
            java.util.Map r12 = r11.getRequestProperties()     // Catch:{ all -> 0x02af }
            boolean r12 = r12.containsKey(r3)     // Catch:{ all -> 0x02af }
            if (r12 != 0) goto L_0x00ba
            r11.setRequestProperty(r3, r10)     // Catch:{ all -> 0x02af }
        L_0x00ba:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x02af }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ all -> 0x02af }
            r10.<init>(r12)     // Catch:{ all -> 0x02af }
            r10.write(r0)     // Catch:{ all -> 0x02af }
            r10.close()     // Catch:{ all -> 0x02af }
            goto L_0x00cf
        L_0x00ca:
            java.lang.String r0 = "GET"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02af }
        L_0x00cf:
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x02af }
            r10 = -1
            if (r0 == r10) goto L_0x02a3
            r24.zza()     // Catch:{ all -> 0x02af }
            r12 = 100
            r13 = 304(0x130, float:4.26E-43)
            r14 = 200(0xc8, float:2.8E-43)
            if (r0 < r12) goto L_0x00e3
            if (r0 < r14) goto L_0x0105
        L_0x00e3:
            r12 = 204(0xcc, float:2.86E-43)
            if (r0 == r12) goto L_0x0105
            if (r0 == r13) goto L_0x0105
            com.google.android.gms.internal.ads.zzba r12 = new com.google.android.gms.internal.ads.zzba     // Catch:{ all -> 0x0100 }
            java.util.Map r15 = r11.getHeaderFields()     // Catch:{ all -> 0x0100 }
            java.util.List r15 = com.google.android.gms.internal.ads.zzbd.zza(r15)     // Catch:{ all -> 0x0100 }
            int r14 = r11.getContentLength()     // Catch:{ all -> 0x0100 }
            com.google.android.gms.internal.ads.zzbb r6 = new com.google.android.gms.internal.ads.zzbb     // Catch:{ all -> 0x0100 }
            r6.<init>(r11)     // Catch:{ all -> 0x0100 }
            r12.<init>(r0, r15, r14, r6)     // Catch:{ all -> 0x0100 }
            goto L_0x0115
        L_0x0100:
            r0 = move-exception
            r14 = r23
            goto L_0x02b3
        L_0x0105:
            com.google.android.gms.internal.ads.zzba r12 = new com.google.android.gms.internal.ads.zzba     // Catch:{ all -> 0x02af }
            java.util.Map r6 = r11.getHeaderFields()     // Catch:{ all -> 0x02af }
            java.util.List r6 = com.google.android.gms.internal.ads.zzbd.zza(r6)     // Catch:{ all -> 0x02af }
            r12.<init>(r0, r6, r10, r8)     // Catch:{ all -> 0x02af }
            r11.disconnect()     // Catch:{ IOException -> 0x02bb }
        L_0x0115:
            int r0 = r12.zza()     // Catch:{ IOException -> 0x029f }
            java.util.List r6 = r12.zzb()     // Catch:{ IOException -> 0x029f }
            if (r0 != r13) goto L_0x01e0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x029f }
            long r20 = r10 - r4
            com.google.android.gms.internal.ads.zzl r0 = r24.zzk()     // Catch:{ IOException -> 0x029f }
            if (r0 != 0) goto L_0x013c
            com.google.android.gms.internal.ads.zzy r0 = new com.google.android.gms.internal.ads.zzy     // Catch:{ IOException -> 0x029f }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            r16 = r0
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzu>) r22)     // Catch:{ IOException -> 0x029f }
            goto L_0x01df
        L_0x013c:
            java.util.TreeSet r10 = new java.util.TreeSet     // Catch:{ IOException -> 0x029f }
            java.util.Comparator r11 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x029f }
            r10.<init>(r11)     // Catch:{ IOException -> 0x029f }
            boolean r11 = r6.isEmpty()     // Catch:{ IOException -> 0x029f }
            if (r11 != 0) goto L_0x0161
            java.util.Iterator r11 = r6.iterator()     // Catch:{ IOException -> 0x029f }
        L_0x014d:
            boolean r13 = r11.hasNext()     // Catch:{ IOException -> 0x029f }
            if (r13 == 0) goto L_0x0161
            java.lang.Object r13 = r11.next()     // Catch:{ IOException -> 0x029f }
            com.google.android.gms.internal.ads.zzu r13 = (com.google.android.gms.internal.ads.zzu) r13     // Catch:{ IOException -> 0x029f }
            java.lang.String r13 = r13.zza()     // Catch:{ IOException -> 0x029f }
            r10.add(r13)     // Catch:{ IOException -> 0x029f }
            goto L_0x014d
        L_0x0161:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ IOException -> 0x029f }
            r11.<init>(r6)     // Catch:{ IOException -> 0x029f }
            java.util.List<com.google.android.gms.internal.ads.zzu> r6 = r0.zzh     // Catch:{ IOException -> 0x029f }
            if (r6 == 0) goto L_0x0190
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x029f }
            if (r6 != 0) goto L_0x01cd
            java.util.List<com.google.android.gms.internal.ads.zzu> r6 = r0.zzh     // Catch:{ IOException -> 0x029f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x029f }
        L_0x0176:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x029f }
            if (r13 == 0) goto L_0x01cd
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x029f }
            com.google.android.gms.internal.ads.zzu r13 = (com.google.android.gms.internal.ads.zzu) r13     // Catch:{ IOException -> 0x029f }
            java.lang.String r14 = r13.zza()     // Catch:{ IOException -> 0x029f }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x029f }
            if (r14 != 0) goto L_0x0176
            r11.add(r13)     // Catch:{ IOException -> 0x029f }
            goto L_0x0176
        L_0x0190:
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.zzg     // Catch:{ IOException -> 0x029f }
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x029f }
            if (r6 != 0) goto L_0x01cd
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.zzg     // Catch:{ IOException -> 0x029f }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x029f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x029f }
        L_0x01a2:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x029f }
            if (r13 == 0) goto L_0x01cd
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x029f }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x029f }
            java.lang.Object r14 = r13.getKey()     // Catch:{ IOException -> 0x029f }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x029f }
            if (r14 != 0) goto L_0x01a2
            com.google.android.gms.internal.ads.zzu r14 = new com.google.android.gms.internal.ads.zzu     // Catch:{ IOException -> 0x029f }
            java.lang.Object r15 = r13.getKey()     // Catch:{ IOException -> 0x029f }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x029f }
            java.lang.Object r13 = r13.getValue()     // Catch:{ IOException -> 0x029f }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x029f }
            r14.<init>(r15, r13)     // Catch:{ IOException -> 0x029f }
            r11.add(r14)     // Catch:{ IOException -> 0x029f }
            goto L_0x01a2
        L_0x01cd:
            com.google.android.gms.internal.ads.zzy r6 = new com.google.android.gms.internal.ads.zzy     // Catch:{ IOException -> 0x029f }
            r17 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.zza     // Catch:{ IOException -> 0x029f }
            r19 = 1
            r16 = r6
            r18 = r0
            r22 = r11
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzu>) r22)     // Catch:{ IOException -> 0x029f }
            r0 = r6
        L_0x01df:
            return r0
        L_0x01e0:
            java.io.InputStream r11 = r12.zzd()     // Catch:{ IOException -> 0x029f }
            if (r11 == 0) goto L_0x022b
            int r13 = r12.zzc()     // Catch:{ IOException -> 0x029f }
            r14 = r23
            com.google.android.gms.internal.ads.zzat r15 = r14.zza     // Catch:{ IOException -> 0x029d }
            com.google.android.gms.internal.ads.zzbg r8 = new com.google.android.gms.internal.ads.zzbg     // Catch:{ IOException -> 0x029d }
            r8.<init>(r15, r13)     // Catch:{ IOException -> 0x029d }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r15.zza(r13)     // Catch:{ all -> 0x0219 }
        L_0x01f9:
            int r7 = r11.read(r13)     // Catch:{ all -> 0x0217 }
            if (r7 == r10) goto L_0x0203
            r8.write(r13, r9, r7)     // Catch:{ all -> 0x0217 }
            goto L_0x01f9
        L_0x0203:
            byte[] r7 = r8.toByteArray()     // Catch:{ all -> 0x0217 }
            r11.close()     // Catch:{ IOException -> 0x020b }
            goto L_0x0210
        L_0x020b:
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x029d }
            com.google.android.gms.internal.ads.zzao.zza(r2, r10)     // Catch:{ IOException -> 0x029d }
        L_0x0210:
            r15.zzb(r13)     // Catch:{ IOException -> 0x029d }
            r8.close()     // Catch:{ IOException -> 0x029d }
            goto L_0x022f
        L_0x0217:
            r0 = move-exception
            goto L_0x021b
        L_0x0219:
            r0 = move-exception
            r13 = 0
        L_0x021b:
            r11.close()     // Catch:{ IOException -> 0x021f }
            goto L_0x0224
        L_0x021f:
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x029d }
            com.google.android.gms.internal.ads.zzao.zza(r2, r6)     // Catch:{ IOException -> 0x029d }
        L_0x0224:
            r15.zzb(r13)     // Catch:{ IOException -> 0x029d }
            r8.close()     // Catch:{ IOException -> 0x029d }
            throw r0     // Catch:{ IOException -> 0x029d }
        L_0x022b:
            r14 = r23
            byte[] r7 = new byte[r9]     // Catch:{ IOException -> 0x029d }
        L_0x022f:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0299 }
            long r10 = r10 - r4
            boolean r8 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ IOException -> 0x0299 }
            if (r8 != 0) goto L_0x0242
            r16 = 3000(0xbb8, double:1.482E-320)
            int r8 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x023f
            goto L_0x0242
        L_0x023f:
            r8 = 200(0xc8, float:2.8E-43)
            goto L_0x0277
        L_0x0242:
            java.lang.String r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r13 = 5
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0299 }
            r13[r9] = r1     // Catch:{ IOException -> 0x0299 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0299 }
            r11 = 1
            r13[r11] = r10     // Catch:{ IOException -> 0x0299 }
            if (r7 == 0) goto L_0x0258
            int r10 = r7.length     // Catch:{ IOException -> 0x0299 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0299 }
            goto L_0x025a
        L_0x0258:
            java.lang.String r10 = "null"
        L_0x025a:
            r11 = 2
            r13[r11] = r10     // Catch:{ IOException -> 0x0299 }
            r10 = 3
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0299 }
            r13[r10] = r11     // Catch:{ IOException -> 0x0299 }
            r10 = 4
            com.google.android.gms.internal.ads.zzq r11 = r24.zzy()     // Catch:{ IOException -> 0x0299 }
            int r11 = r11.zzb()     // Catch:{ IOException -> 0x0299 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException -> 0x0299 }
            r13[r10] = r11     // Catch:{ IOException -> 0x0299 }
            com.google.android.gms.internal.ads.zzao.zzb(r8, r13)     // Catch:{ IOException -> 0x0299 }
            goto L_0x023f
        L_0x0277:
            if (r0 < r8) goto L_0x0293
            r8 = 299(0x12b, float:4.19E-43)
            if (r0 > r8) goto L_0x0293
            com.google.android.gms.internal.ads.zzy r8 = new com.google.android.gms.internal.ads.zzy     // Catch:{ IOException -> 0x0299 }
            r19 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0299 }
            long r20 = r10 - r4
            r16 = r8
            r17 = r0
            r18 = r7
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzu>) r22)     // Catch:{ IOException -> 0x0299 }
            return r8
        L_0x0293:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0299 }
            r0.<init>()     // Catch:{ IOException -> 0x0299 }
            throw r0     // Catch:{ IOException -> 0x0299 }
        L_0x0299:
            r0 = move-exception
            r18 = r7
            goto L_0x02c1
        L_0x029d:
            r0 = move-exception
            goto L_0x02bf
        L_0x029f:
            r0 = move-exception
            r14 = r23
            goto L_0x02bf
        L_0x02a3:
            r14 = r23
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02ad }
            java.lang.String r6 = "Could not retrieve response code from HttpUrlConnection."
            r0.<init>(r6)     // Catch:{ all -> 0x02ad }
            throw r0     // Catch:{ all -> 0x02ad }
        L_0x02ad:
            r0 = move-exception
            goto L_0x02b2
        L_0x02af:
            r0 = move-exception
            r14 = r23
        L_0x02b2:
            r7 = 0
        L_0x02b3:
            if (r7 != 0) goto L_0x02b8
            r11.disconnect()     // Catch:{ IOException -> 0x02b9 }
        L_0x02b8:
            throw r0     // Catch:{ IOException -> 0x02b9 }
        L_0x02b9:
            r0 = move-exception
            goto L_0x02be
        L_0x02bb:
            r0 = move-exception
            r14 = r23
        L_0x02be:
            r12 = 0
        L_0x02bf:
            r18 = 0
        L_0x02c1:
            boolean r6 = r0 instanceof java.net.SocketTimeoutException
            if (r6 == 0) goto L_0x02d5
            com.google.android.gms.internal.ads.zzbf r0 = new com.google.android.gms.internal.ads.zzbf
            com.google.android.gms.internal.ads.zzak r6 = new com.google.android.gms.internal.ads.zzak
            r6.<init>()
            java.lang.String r7 = "socket"
            r8 = 0
            r0.<init>(r7, r6, r8)
        L_0x02d2:
            r6 = r0
            goto L_0x0366
        L_0x02d5:
            boolean r6 = r0 instanceof java.net.MalformedURLException
            if (r6 == 0) goto L_0x02f9
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r1 = r24.zzh()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Bad URL "
            int r4 = r1.length()
            if (r4 == 0) goto L_0x02f0
            java.lang.String r1 = r3.concat(r1)
            goto L_0x02f5
        L_0x02f0:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x02f5:
            r2.<init>(r1, r0)
            throw r2
        L_0x02f9:
            if (r12 == 0) goto L_0x03ab
            int r0 = r12.zza()
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r7[r9] = r6
            java.lang.String r6 = r24.zzh()
            r8 = 1
            r7[r8] = r6
            java.lang.String r6 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzao.zzc(r6, r7)
            if (r18 == 0) goto L_0x0357
            java.util.List r22 = r12.zzb()
            com.google.android.gms.internal.ads.zzy r6 = new com.google.android.gms.internal.ads.zzy
            r19 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r20 = r7 - r4
            r16 = r6
            r17 = r0
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List<com.google.android.gms.internal.ads.zzu>) r22)
            r7 = 401(0x191, float:5.62E-43)
            if (r0 == r7) goto L_0x0348
            r7 = 403(0x193, float:5.65E-43)
            if (r0 != r7) goto L_0x0334
            goto L_0x0348
        L_0x0334:
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L_0x0342
            r1 = 499(0x1f3, float:6.99E-43)
            if (r0 > r1) goto L_0x0342
            com.google.android.gms.internal.ads.zzp r0 = new com.google.android.gms.internal.ads.zzp
            r0.<init>(r6)
            throw r0
        L_0x0342:
            com.google.android.gms.internal.ads.zzaj r0 = new com.google.android.gms.internal.ads.zzaj
            r0.<init>(r6)
            throw r0
        L_0x0348:
            com.google.android.gms.internal.ads.zzbf r0 = new com.google.android.gms.internal.ads.zzbf
            com.google.android.gms.internal.ads.zzk r7 = new com.google.android.gms.internal.ads.zzk
            r7.<init>(r6)
            java.lang.String r6 = "auth"
            r8 = 0
            r0.<init>(r6, r7, r8)
            goto L_0x02d2
        L_0x0357:
            r8 = 0
            com.google.android.gms.internal.ads.zzbf r0 = new com.google.android.gms.internal.ads.zzbf
            com.google.android.gms.internal.ads.zzx r6 = new com.google.android.gms.internal.ads.zzx
            r6.<init>()
            java.lang.String r7 = "network"
            r0.<init>(r7, r6, r8)
            goto L_0x02d2
        L_0x0366:
            com.google.android.gms.internal.ads.zzq r0 = r24.zzy()
            int r7 = r24.zzo()
            com.google.android.gms.internal.ads.zzal r8 = r6.zzb     // Catch:{ zzal -> 0x0390 }
            r0.zzc(r8)     // Catch:{ zzal -> 0x0390 }
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r6 = r6.zza
            r0[r9] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r0[r7] = r6
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r1.zzc(r0)
            goto L_0x000a
        L_0x0390:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r6.zza
            r2[r9] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.zzc(r2)
            throw r0
        L_0x03ab:
            com.google.android.gms.internal.ads.zzz r1 = new com.google.android.gms.internal.ads.zzz
            r1.<init>(r0)
            goto L_0x03b2
        L_0x03b1:
            throw r1
        L_0x03b2:
            goto L_0x03b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzar.zza(com.google.android.gms.internal.ads.zzac):com.google.android.gms.internal.ads.zzy");
    }
}
