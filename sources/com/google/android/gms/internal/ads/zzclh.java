package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzclh extends zzahm implements zzaip {
    public static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    public final SSLSocketFactory zzd = new zzclg(this);
    public final int zze;
    public final int zzf;
    public final String zzg;
    public final zzaio zzh;
    public zzahx zzi;
    public HttpURLConnection zzj;
    public InputStream zzk;
    public boolean zzl;
    public int zzm;
    public long zzn;
    public long zzo;
    public long zzp;
    public long zzq;
    public int zzr;
    public final Set<Socket> zzs = new HashSet();

    public zzclh(String str, zzajd zzajd, int i, int i2, int i3) {
        super(true);
        zzajg.zzf(str);
        this.zzg = str;
        this.zzh = new zzaio();
        this.zze = i;
        this.zzf = i2;
        this.zzr = i3;
        if (zzajd != null) {
            zzb(zzajd);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzcgs.zzg("Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaim {
        try {
            if (this.zzp != this.zzn) {
                byte[] andSet = zzc.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.zzp;
                    long j2 = this.zzn;
                    if (j == j2) {
                        zzc.set(andSet);
                        break;
                    }
                    int read = this.zzk.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzi(read);
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzo;
            if (j3 != -1) {
                long j4 = j3 - this.zzq;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzi(read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzaim(e, this.zzi, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010f, code lost:
        if (r2 != 0) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzc(com.google.android.gms.internal.ads.zzahx r22) throws com.google.android.gms.internal.ads.zzaim {
        /*
            r21 = this;
            r1 = r21
            r6 = r22
            java.lang.String r2 = "Unable to connect to "
            r1.zzi = r6
            r3 = 0
            r1.zzq = r3
            r1.zzp = r3
            r5 = 1
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02d7 }
            android.net.Uri r7 = r6.zza     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x02d7 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x02d7 }
            long r7 = r6.zzf     // Catch:{ IOException -> 0x02d7 }
            long r9 = r6.zzg     // Catch:{ IOException -> 0x02d7 }
            boolean r11 = r6.zza(r5)     // Catch:{ IOException -> 0x02d7 }
            r13 = 0
        L_0x0023:
            int r14 = r13 + 1
            r15 = 20
            if (r13 > r15) goto L_0x02be
            java.net.URLConnection r13 = r0.openConnection()     // Catch:{ IOException -> 0x02d7 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x02d7 }
            boolean r5 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x02d7 }
            if (r5 == 0) goto L_0x003b
            r5 = r13
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x02d7 }
            javax.net.ssl.SSLSocketFactory r12 = r1.zzd     // Catch:{ IOException -> 0x02d7 }
            r5.setSSLSocketFactory(r12)     // Catch:{ IOException -> 0x02d7 }
        L_0x003b:
            int r5 = r1.zze     // Catch:{ IOException -> 0x02d7 }
            r13.setConnectTimeout(r5)     // Catch:{ IOException -> 0x02d7 }
            int r5 = r1.zzf     // Catch:{ IOException -> 0x02d7 }
            r13.setReadTimeout(r5)     // Catch:{ IOException -> 0x02d7 }
            com.google.android.gms.internal.ads.zzaio r5 = r1.zzh     // Catch:{ IOException -> 0x02d7 }
            java.util.Map r5 = r5.zza()     // Catch:{ IOException -> 0x02d7 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x02d7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x02d7 }
        L_0x0053:
            boolean r12 = r5.hasNext()     // Catch:{ IOException -> 0x02d7 }
            if (r12 == 0) goto L_0x0073
            java.lang.Object r12 = r5.next()     // Catch:{ IOException -> 0x02d7 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IOException -> 0x02d7 }
            java.lang.Object r16 = r12.getKey()     // Catch:{ IOException -> 0x02d7 }
            r15 = r16
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02d7 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x02d7 }
            r13.setRequestProperty(r15, r12)     // Catch:{ IOException -> 0x02d7 }
            r15 = 20
            goto L_0x0053
        L_0x0073:
            r5 = 27
            r17 = -1
            int r12 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r12 != 0) goto L_0x007f
            int r12 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r12 == 0) goto L_0x00bd
        L_0x007f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02d7 }
            r12.<init>(r5)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r15 = "bytes="
            r12.append(r15)     // Catch:{ IOException -> 0x02d7 }
            r12.append(r7)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r15 = "-"
            r12.append(r15)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x02d7 }
            int r15 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x00b8
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x02d7 }
            long r19 = r7 + r9
            long r3 = r19 + r17
            int r15 = r12.length()     // Catch:{ IOException -> 0x02d7 }
            r16 = 20
            int r15 = r15 + 20
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02d7 }
            r5.<init>(r15)     // Catch:{ IOException -> 0x02d7 }
            r5.append(r12)     // Catch:{ IOException -> 0x02d7 }
            r5.append(r3)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r12 = r5.toString()     // Catch:{ IOException -> 0x02d7 }
        L_0x00b8:
            java.lang.String r3 = "Range"
            r13.setRequestProperty(r3, r12)     // Catch:{ IOException -> 0x02d7 }
        L_0x00bd:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzg     // Catch:{ IOException -> 0x02d7 }
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02d7 }
            if (r11 != 0) goto L_0x00cd
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02d7 }
        L_0x00cd:
            r3 = 0
            r13.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x02d7 }
            r13.setDoOutput(r3)     // Catch:{ IOException -> 0x02d7 }
            r13.connect()     // Catch:{ IOException -> 0x02d7 }
            int r3 = r13.getResponseCode()     // Catch:{ IOException -> 0x02d7 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 == r4) goto L_0x026c
            r4 = 301(0x12d, float:4.22E-43)
            if (r3 == r4) goto L_0x026c
            r4 = 302(0x12e, float:4.23E-43)
            if (r3 == r4) goto L_0x026c
            r4 = 303(0x12f, float:4.25E-43)
            if (r3 == r4) goto L_0x026c
            r4 = 307(0x133, float:4.3E-43)
            if (r3 == r4) goto L_0x026c
            r4 = 308(0x134, float:4.32E-43)
            if (r3 != r4) goto L_0x00f5
            goto L_0x026c
        L_0x00f5:
            r1.zzj = r13     // Catch:{ IOException -> 0x02d7 }
            int r0 = r13.getResponseCode()     // Catch:{ IOException -> 0x0246 }
            r1.zzm = r0     // Catch:{ IOException -> 0x0246 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x0220
            r3 = 299(0x12b, float:4.19E-43)
            if (r0 <= r3) goto L_0x0107
            goto L_0x0220
        L_0x0107:
            if (r0 != r2) goto L_0x0112
            long r2 = r6.zzf
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r2 = 0
        L_0x0114:
            r1.zzn = r2
            r2 = 1
            boolean r0 = r6.zza(r2)
            if (r0 != 0) goto L_0x0200
            long r2 = r6.zzg
            int r0 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
            r1.zzo = r2
            goto L_0x0204
        L_0x0127:
            java.net.HttpURLConnection r0 = r1.zzj
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r0.getHeaderField(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "]"
            if (r3 != 0) goto L_0x015d
            long r7 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x013c }
            goto L_0x015f
        L_0x013c:
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r3 = r3 + 28
            r5.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Length ["
            r5.append(r3)
            r5.append(r2)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            com.google.android.gms.internal.ads.zzcgs.zzf(r3)
        L_0x015d:
            r7 = r17
        L_0x015f:
            java.lang.String r3 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01f3
            java.util.regex.Pattern r3 = zzb
            java.util.regex.Matcher r3 = r3.matcher(r0)
            boolean r5 = r3.find()
            if (r5 == 0) goto L_0x01f3
            r5 = 2
            java.lang.String r5 = r3.group(r5)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r9 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x01d1 }
            r5 = 1
            java.lang.String r3 = r3.group(r5)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r11 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r9 = r9 - r11
            r11 = 1
            long r9 = r9 + r11
            r19 = 0
            int r3 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0195
            r7 = r9
            goto L_0x01f3
        L_0x0195:
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x01f3
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3.length()     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3 + 26
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01d1 }
            int r5 = r5.length()     // Catch:{ NumberFormatException -> 0x01d1 }
            int r3 = r3 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01d1 }
            r5.<init>(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r3 = "Inconsistent headers ["
            r5.append(r3)     // Catch:{ NumberFormatException -> 0x01d1 }
            r5.append(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r2 = "] ["
            r5.append(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            r5.append(r0)     // Catch:{ NumberFormatException -> 0x01d1 }
            r5.append(r4)     // Catch:{ NumberFormatException -> 0x01d1 }
            java.lang.String r2 = r5.toString()     // Catch:{ NumberFormatException -> 0x01d1 }
            com.google.android.gms.internal.ads.zzcgs.zzi(r2)     // Catch:{ NumberFormatException -> 0x01d1 }
            long r2 = java.lang.Math.max(r7, r9)     // Catch:{ NumberFormatException -> 0x01d1 }
            r7 = r2
            goto L_0x01f3
        L_0x01d1:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r5 = 27
            int r2 = r2 + r5
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected Content-Range ["
            r3.append(r2)
            r3.append(r0)
            r3.append(r4)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzcgs.zzf(r0)
        L_0x01f3:
            int r0 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01fb
            long r2 = r1.zzn
            long r17 = r7 - r2
        L_0x01fb:
            r2 = r17
            r1.zzo = r2
            goto L_0x0204
        L_0x0200:
            long r2 = r6.zzg
            r1.zzo = r2
        L_0x0204:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x0215 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0215 }
            r1.zzk = r0     // Catch:{ IOException -> 0x0215 }
            r2 = 1
            r1.zzl = r2
            r21.zzh(r22)
            long r2 = r1.zzo
            return r2
        L_0x0215:
            r0 = move-exception
            r21.zzn()
            com.google.android.gms.internal.ads.zzaim r2 = new com.google.android.gms.internal.ads.zzaim
            r3 = 1
            r2.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzahx) r6, (int) r3)
            throw r2
        L_0x0220:
            java.net.HttpURLConnection r0 = r1.zzj
            java.util.Map r5 = r0.getHeaderFields()
            r21.zzn()
            com.google.android.gms.internal.ads.zzain r0 = new com.google.android.gms.internal.ads.zzain
            int r3 = r1.zzm
            r4 = 0
            byte[] r7 = com.google.android.gms.internal.ads.zzalh.zzf
            r2 = r0
            r6 = r22
            r2.<init>(r3, r4, r5, r6, r7)
            int r2 = r1.zzm
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 != r3) goto L_0x0245
            com.google.android.gms.internal.ads.zzahu r2 = new com.google.android.gms.internal.ads.zzahu
            r3 = 0
            r2.<init>(r3)
            r0.initCause(r2)
        L_0x0245:
            throw r0
        L_0x0246:
            r0 = move-exception
            r21.zzn()
            com.google.android.gms.internal.ads.zzaim r3 = new com.google.android.gms.internal.ads.zzaim
            android.net.Uri r4 = r6.zza
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x0261
            java.lang.String r2 = r2.concat(r4)
            goto L_0x0267
        L_0x0261:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2)
            r2 = r4
        L_0x0267:
            r4 = 1
            r3.<init>(r2, r0, r6, r4)
            throw r3
        L_0x026c:
            r3 = 0
            r19 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r13.getHeaderField(r4)     // Catch:{ IOException -> 0x02d7 }
            r13.disconnect()     // Catch:{ IOException -> 0x02d7 }
            if (r4 == 0) goto L_0x02b6
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x02d7 }
            r5.<init>(r0, r4)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r0 = r5.getProtocol()     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02d7 }
            if (r4 != 0) goto L_0x02af
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02d7 }
            if (r4 != 0) goto L_0x02af
            java.net.ProtocolException r3 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r4 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02d7 }
            int r5 = r0.length()     // Catch:{ IOException -> 0x02d7 }
            if (r5 == 0) goto L_0x02a6
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x02d7 }
            goto L_0x02ab
        L_0x02a6:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02d7 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02d7 }
        L_0x02ab:
            r3.<init>(r0)     // Catch:{ IOException -> 0x02d7 }
            throw r3     // Catch:{ IOException -> 0x02d7 }
        L_0x02af:
            r0 = r5
            r13 = r14
            r3 = r19
            r5 = 1
            goto L_0x0023
        L_0x02b6:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x02d7 }
            throw r0     // Catch:{ IOException -> 0x02d7 }
        L_0x02be:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02d7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02d7 }
            r4 = 31
            r3.<init>(r4)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x02d7 }
            r3.append(r14)     // Catch:{ IOException -> 0x02d7 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x02d7 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x02d7 }
            throw r0     // Catch:{ IOException -> 0x02d7 }
        L_0x02d7:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaim r3 = new com.google.android.gms.internal.ads.zzaim
            android.net.Uri r4 = r6.zza
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x02ef
            java.lang.String r2 = r2.concat(r4)
            goto L_0x02f5
        L_0x02ef:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2)
            r2 = r4
        L_0x02f5:
            r4 = 1
            r3.<init>(r2, r0, r6, r4)
            goto L_0x02fb
        L_0x02fa:
            throw r3
        L_0x02fb:
            goto L_0x02fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzc(com.google.android.gms.internal.ads.zzahx):long");
    }

    public final Uri zzd() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() throws com.google.android.gms.internal.ads.zzaim {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzk     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzj     // Catch:{ all -> 0x008d }
            long r3 = r9.zzo     // Catch:{ all -> 0x008d }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzq     // Catch:{ all -> 0x008d }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x008d }
            r8 = 19
            if (r7 == r8) goto L_0x0021
            int r7 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ all -> 0x008d }
            r8 = 20
            if (r7 == r8) goto L_0x0021
            goto L_0x0069
        L_0x0021:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0069 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0031
            int r3 = r2.read()     // Catch:{ Exception -> 0x0069 }
            r4 = -1
            if (r3 == r4) goto L_0x0069
            goto L_0x0038
        L_0x0031:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0038
            goto L_0x0069
        L_0x0038:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0069
        L_0x0050:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0069 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            java.io.InputStream r2 = r9.zzk     // Catch:{ IOException -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0079
        L_0x006f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzaim r3 = new com.google.android.gms.internal.ads.zzaim     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzahx r4 = r9.zzi     // Catch:{ all -> 0x008d }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzahx) r4, (int) r5)     // Catch:{ all -> 0x008d }
            throw r3     // Catch:{ all -> 0x008d }
        L_0x0079:
            r9.zzk = r0
            r9.zzn()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0087
            r9.zzl = r1
            r9.zzj()
        L_0x0087:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            return
        L_0x008d:
            r2 = move-exception
            r9.zzk = r0
            r9.zzn()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x009c
            r9.zzl = r1
            r9.zzj()
        L_0x009c:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzf():void");
    }

    public final void zzk(int i) {
        this.zzr = i;
        for (Socket next : this.zzs) {
            if (!next.isClosed()) {
                try {
                    next.setReceiveBufferSize(this.zzr);
                } catch (SocketException e) {
                    zzcgs.zzj("Failed to update receive buffer size.", e);
                }
            }
        }
    }
}
