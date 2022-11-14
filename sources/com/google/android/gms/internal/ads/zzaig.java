package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.vungle.warren.downloader.AssetDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaig extends zzahm implements zzaip {
    public final boolean zzb;
    public final int zzc;
    public final int zzd;
    @Nullable
    public final String zze;
    @Nullable
    public final zzaio zzf;
    public final zzaio zzg;
    @Nullable
    public zzahx zzh;
    @Nullable
    public HttpURLConnection zzi;
    @Nullable
    public InputStream zzj;
    public boolean zzk;
    public int zzl;
    public long zzm;
    public long zzn;

    @Deprecated
    public zzaig() {
        this((String) null, 8000, 8000, false, (zzaio) null, (zzfkf<String>) null);
    }

    private final HttpURLConnection zzk(URL url, int i, @Nullable byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        String str;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zzf.zza());
        hashMap.putAll(this.zzg.zza());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j == 0 && j2 == -1) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            str = sb.toString();
        }
        if (str != null) {
            httpURLConnection.setRequestProperty(AssetDownloader.RANGE, str);
        }
        String str2 = this.zze;
        if (str2 != null) {
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, str2);
        }
        httpURLConnection.setRequestProperty(AssetDownloader.ACCEPT_ENCODING, true != z ? AssetDownloader.IDENTITY : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final void zzl() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzaka.zzb("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaim {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            if (j != -1) {
                long j2 = j - this.zzn;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j2);
            }
            InputStream inputStream = this.zzj;
            int i3 = zzalh.zza;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.zzn += (long) read;
            zzi(read);
            return read;
        } catch (IOException e) {
            zzahx zzahx = this.zzh;
            int i4 = zzalh.zza;
            throw new zzaim(e, zzahx, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        if (r10 != r20) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzc(com.google.android.gms.internal.ads.zzahx r27) throws com.google.android.gms.internal.ads.zzaim {
        /*
            r26 = this;
            r12 = r26
            r13 = r27
            java.lang.String r14 = "Unable to connect"
            r12.zzh = r13
            r10 = 0
            r12.zzn = r10
            r12.zzm = r10
            r26.zzg(r27)
            r15 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x021e }
            android.net.Uri r0 = r13.zza     // Catch:{ IOException -> 0x021e }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x021e }
            r2.<init>(r0)     // Catch:{ IOException -> 0x021e }
            long r7 = r13.zzf     // Catch:{ IOException -> 0x021e }
            long r5 = r13.zzg     // Catch:{ IOException -> 0x021e }
            boolean r0 = r13.zza(r15)     // Catch:{ IOException -> 0x021e }
            boolean r1 = r12.zzb     // Catch:{ IOException -> 0x021e }
            r9 = 0
            if (r1 != 0) goto L_0x0045
            r3 = 1
            r4 = 0
            r16 = 1
            java.util.Map<java.lang.String, java.lang.String> r1 = r13.zzd     // Catch:{ IOException -> 0x021e }
            r17 = r1
            r1 = r26
            r18 = r5
            r5 = r7
            r7 = r18
            r9 = r0
            r20 = r10
            r10 = r16
            r11 = r17
            java.net.HttpURLConnection r0 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x021e }
            goto L_0x0093
        L_0x0045:
            r18 = r5
            r20 = r10
            r11 = r2
            r9 = 0
        L_0x004b:
            int r10 = r9 + 1
            r1 = 20
            if (r9 > r1) goto L_0x0201
            r3 = 1
            r4 = 0
            r16 = 0
            java.util.Map<java.lang.String, java.lang.String> r9 = r13.zzd     // Catch:{ IOException -> 0x021e }
            r1 = r26
            r2 = r11
            r5 = r7
            r22 = r7
            r7 = r18
            r17 = r9
            r9 = r0
            r24 = r10
            r10 = r16
            r25 = r11
            r11 = r17
            java.net.HttpURLConnection r1 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x021e }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x021e }
            java.lang.String r3 = "Location"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ IOException -> 0x021e }
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 == r4) goto L_0x01b6
            r4 = 301(0x12d, float:4.22E-43)
            if (r2 == r4) goto L_0x01b6
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 == r4) goto L_0x01b6
            r4 = 303(0x12f, float:4.25E-43)
            if (r2 == r4) goto L_0x01b6
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x01b6
            r4 = 308(0x134, float:4.32E-43)
            if (r2 != r4) goto L_0x0092
            goto L_0x01b6
        L_0x0092:
            r0 = r1
        L_0x0093:
            r12.zzi = r0     // Catch:{ IOException -> 0x021e }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x01ac }
            r12.zzl = r1     // Catch:{ IOException -> 0x01ac }
            java.lang.String r3 = r0.getResponseMessage()     // Catch:{ IOException -> 0x01ac }
            int r1 = r12.zzl
            java.lang.String r2 = "Content-Range"
            r4 = 200(0xc8, float:2.8E-43)
            r5 = -1
            if (r1 < r4) goto L_0x015a
            r7 = 299(0x12b, float:4.19E-43)
            if (r1 <= r7) goto L_0x00af
            goto L_0x015a
        L_0x00af:
            r0.getContentType()
            int r1 = r12.zzl
            if (r1 != r4) goto L_0x00bd
            long r10 = r13.zzf
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r10 = r20
        L_0x00bf:
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r1 = r0.getHeaderField(r1)
            java.lang.String r3 = "gzip"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00ed
            long r3 = r13.zzg
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00d6
            r12.zzm = r3
            goto L_0x00f1
        L_0x00d6:
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            java.lang.String r2 = r0.getHeaderField(r2)
            long r2 = com.google.android.gms.internal.ads.zzaiq.zzb(r3, r2)
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x00ea
            long r5 = r2 - r10
        L_0x00ea:
            r12.zzm = r5
            goto L_0x00f1
        L_0x00ed:
            long r2 = r13.zzg
            r12.zzm = r2
        L_0x00f1:
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0150 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0150 }
            if (r1 == 0) goto L_0x0102
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0150 }
            java.io.InputStream r1 = r12.zzj     // Catch:{ IOException -> 0x0150 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0150 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0150 }
        L_0x0102:
            r12.zzk = r15
            r26.zzh(r27)
            int r0 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x010c
            goto L_0x0143
        L_0x010c:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0146 }
        L_0x0110:
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0143
            r1 = 4096(0x1000, double:2.0237E-320)
            long r1 = java.lang.Math.min(r10, r1)     // Catch:{ IOException -> 0x0146 }
            int r2 = (int) r1     // Catch:{ IOException -> 0x0146 }
            java.io.InputStream r1 = r12.zzj     // Catch:{ IOException -> 0x0146 }
            int r3 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ IOException -> 0x0146 }
            r7 = 0
            int r1 = r1.read(r0, r7, r2)     // Catch:{ IOException -> 0x0146 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x0146 }
            boolean r2 = r2.isInterrupted()     // Catch:{ IOException -> 0x0146 }
            if (r2 != 0) goto L_0x013d
            r2 = -1
            if (r1 == r2) goto L_0x0137
            long r2 = (long) r1     // Catch:{ IOException -> 0x0146 }
            long r10 = r10 - r2
            r12.zzi(r1)     // Catch:{ IOException -> 0x0146 }
            goto L_0x0110
        L_0x0137:
            com.google.android.gms.internal.ads.zzahu r0 = new com.google.android.gms.internal.ads.zzahu     // Catch:{ IOException -> 0x0146 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0146 }
            throw r0     // Catch:{ IOException -> 0x0146 }
        L_0x013d:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ IOException -> 0x0146 }
            r0.<init>()     // Catch:{ IOException -> 0x0146 }
            throw r0     // Catch:{ IOException -> 0x0146 }
        L_0x0143:
            long r0 = r12.zzm
            return r0
        L_0x0146:
            r0 = move-exception
            r26.zzl()
            com.google.android.gms.internal.ads.zzaim r1 = new com.google.android.gms.internal.ads.zzaim
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzahx) r13, (int) r15)
            throw r1
        L_0x0150:
            r0 = move-exception
            r26.zzl()
            com.google.android.gms.internal.ads.zzaim r1 = new com.google.android.gms.internal.ads.zzaim
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzahx) r13, (int) r15)
            throw r1
        L_0x015a:
            r7 = 0
            java.util.Map r4 = r0.getHeaderFields()
            int r1 = r12.zzl
            r8 = 416(0x1a0, float:5.83E-43)
            if (r1 != r8) goto L_0x0180
            java.lang.String r1 = r0.getHeaderField(r2)
            long r1 = com.google.android.gms.internal.ads.zzaiq.zza(r1)
            long r9 = r13.zzf
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 != 0) goto L_0x0180
            r12.zzk = r15
            r26.zzh(r27)
            long r0 = r13.zzg
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x017f
            return r0
        L_0x017f:
            return r20
        L_0x0180:
            java.io.InputStream r0 = r0.getErrorStream()
            if (r0 == 0) goto L_0x018b
            byte[] r0 = com.google.android.gms.internal.ads.zzalh.zza(r0)     // Catch:{ IOException -> 0x018f }
            goto L_0x018d
        L_0x018b:
            byte[] r0 = com.google.android.gms.internal.ads.zzalh.zzf     // Catch:{ IOException -> 0x018f }
        L_0x018d:
            r6 = r0
            goto L_0x0192
        L_0x018f:
            byte[] r0 = com.google.android.gms.internal.ads.zzalh.zzf
            goto L_0x018d
        L_0x0192:
            r26.zzl()
            com.google.android.gms.internal.ads.zzain r0 = new com.google.android.gms.internal.ads.zzain
            int r2 = r12.zzl
            r1 = r0
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6)
            int r1 = r12.zzl
            if (r1 != r8) goto L_0x01ab
            com.google.android.gms.internal.ads.zzahu r1 = new com.google.android.gms.internal.ads.zzahu
            r1.<init>(r7)
            r0.initCause(r1)
        L_0x01ab:
            throw r0
        L_0x01ac:
            r0 = move-exception
            r26.zzl()
            com.google.android.gms.internal.ads.zzaim r1 = new com.google.android.gms.internal.ads.zzaim
            r1.<init>(r14, r0, r13, r15)
            throw r1
        L_0x01b6:
            r7 = 0
            r1.disconnect()     // Catch:{ IOException -> 0x021e }
            if (r3 == 0) goto L_0x01f9
            java.net.URL r11 = new java.net.URL     // Catch:{ IOException -> 0x021e }
            r2 = r25
            r11.<init>(r2, r3)     // Catch:{ IOException -> 0x021e }
            java.lang.String r1 = r11.getProtocol()     // Catch:{ IOException -> 0x021e }
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x021e }
            if (r2 != 0) goto L_0x01f3
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x021e }
            if (r2 != 0) goto L_0x01f3
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x021e }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x021e }
            java.lang.String r2 = "Unsupported protocol redirect: "
            int r3 = r1.length()     // Catch:{ IOException -> 0x021e }
            if (r3 == 0) goto L_0x01ea
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException -> 0x021e }
            goto L_0x01ef
        L_0x01ea:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x021e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x021e }
        L_0x01ef:
            r0.<init>(r1)     // Catch:{ IOException -> 0x021e }
            throw r0     // Catch:{ IOException -> 0x021e }
        L_0x01f3:
            r7 = r22
            r9 = r24
            goto L_0x004b
        L_0x01f9:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x021e }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x021e }
            throw r0     // Catch:{ IOException -> 0x021e }
        L_0x0201:
            r24 = r10
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x021e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x021e }
            r2 = 31
            r1.<init>(r2)     // Catch:{ IOException -> 0x021e }
            java.lang.String r2 = "Too many redirects: "
            r1.append(r2)     // Catch:{ IOException -> 0x021e }
            r9 = r24
            r1.append(r9)     // Catch:{ IOException -> 0x021e }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x021e }
            r0.<init>(r1)     // Catch:{ IOException -> 0x021e }
            throw r0     // Catch:{ IOException -> 0x021e }
        L_0x021e:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0237
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfjm.zza(r1)
            java.lang.String r2 = "cleartext http traffic.*not permitted.*"
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0237
            com.google.android.gms.internal.ads.zzail r1 = new com.google.android.gms.internal.ads.zzail
            r1.<init>(r0, r13)
            throw r1
        L_0x0237:
            com.google.android.gms.internal.ads.zzaim r1 = new com.google.android.gms.internal.ads.zzaim
            r1.<init>(r14, r0, r13, r15)
            goto L_0x023e
        L_0x023d:
            throw r1
        L_0x023e:
            goto L_0x023d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaig.zzc(com.google.android.gms.internal.ads.zzahx):long");
    }

    @Nullable
    public final Uri zzd() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:15|16|(2:18|(1:20))(2:21|(1:23))|24|(2:28|(1:30)(1:31)))|32|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() throws com.google.android.gms.internal.ads.zzaim {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.zzj     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0080
            long r3 = r10.zzm     // Catch:{ all -> 0x008f }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0010
            r3 = r5
            goto L_0x0013
        L_0x0010:
            long r7 = r10.zzn     // Catch:{ all -> 0x008f }
            long r3 = r3 - r7
        L_0x0013:
            java.net.HttpURLConnection r7 = r10.zzi     // Catch:{ all -> 0x008f }
            if (r7 == 0) goto L_0x0070
            int r8 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x008f }
            r9 = 19
            if (r8 < r9) goto L_0x0070
            int r8 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x008f }
            r9 = 20
            if (r8 <= r9) goto L_0x0024
            goto L_0x0070
        L_0x0024:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0070 }
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0034
            int r3 = r7.read()     // Catch:{ Exception -> 0x0070 }
            r4 = -1
            if (r3 == r4) goto L_0x0070
            goto L_0x003b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x003b
            goto L_0x0070
        L_0x003b:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x0070 }
            if (r4 != 0) goto L_0x0053
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x0070 }
            if (r3 == 0) goto L_0x0070
        L_0x0053:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x0070 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0070 }
            if (r3 == 0) goto L_0x006f
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0070 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0070 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0070 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0070 }
            r3.invoke(r7, r4)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0070
        L_0x006f:
            throw r0     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            r2.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0080
        L_0x0074:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzaim r3 = new com.google.android.gms.internal.ads.zzaim     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzahx r4 = r10.zzh     // Catch:{ all -> 0x008f }
            int r5 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x008f }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzahx) r4, (int) r5)     // Catch:{ all -> 0x008f }
            throw r3     // Catch:{ all -> 0x008f }
        L_0x0080:
            r10.zzj = r0
            r10.zzl()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x008e
            r10.zzk = r1
            r10.zzj()
        L_0x008e:
            return
        L_0x008f:
            r2 = move-exception
            r10.zzj = r0
            r10.zzl()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x009e
            r10.zzk = r1
            r10.zzj()
        L_0x009e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaig.zzf():void");
    }

    public zzaig(@Nullable String str, int i, int i2, boolean z, @Nullable zzaio zzaio, @Nullable zzfkf<String> zzfkf) {
        super(true);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzb = z;
        this.zzf = zzaio;
        this.zzg = new zzaio();
    }

    public /* synthetic */ zzaig(String str, int i, int i2, boolean z, zzaio zzaio, zzfkf zzfkf, zzaie zzaie) {
        this(str, i, i2, z, zzaio, (zzfkf<String>) null);
    }
}
