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
public final class zzcjs implements zzaue {
    public static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    public final SSLSocketFactory zzd = new zzcjr(this);
    public final int zze;
    public final int zzf;
    public final String zzg;
    public final zzaud zzh;
    public final zzauk<? super zzcjs> zzi;
    public zzatx zzj;
    public HttpURLConnection zzk;
    public InputStream zzl;
    public boolean zzm;
    public long zzn;
    public long zzo;
    public long zzp;
    public long zzq;
    public int zzr;
    public final Set<Socket> zzs = new HashSet();

    public zzcjs(String str, zzauk<? super zzcjs> zzauk, int i, int i2, int i3) {
        zzaul.zzf(str);
        this.zzg = str;
        this.zzi = zzauk;
        this.zzh = new zzaud();
        this.zze = i;
        this.zzf = i2;
        this.zzr = i3;
    }

    private final void zzi() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzcgs.zzg("Unexpected error while disconnecting", e);
            }
            this.zzk = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0108, code lost:
        if (r6 != 0) goto L_0x010c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x00f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f0 A[Catch:{ IOException -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzatx r24) throws com.google.android.gms.internal.ads.zzaub {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "Unable to connect to "
            r1.zzj = r2
            r4 = 0
            r1.zzq = r4
            r1.zzp = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02bb }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x02bb }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x02bb }
            r0.<init>(r7)     // Catch:{ IOException -> 0x02bb }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x02bb }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x02bb }
            r12 = 0
        L_0x001e:
            int r13 = r12 + 1
            r14 = 20
            if (r12 > r14) goto L_0x02a2
            java.net.URLConnection r12 = r0.openConnection()     // Catch:{ IOException -> 0x02bb }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x02bb }
            boolean r15 = r12 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x02bb }
            if (r15 == 0) goto L_0x0036
            r15 = r12
            javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15     // Catch:{ IOException -> 0x02bb }
            javax.net.ssl.SSLSocketFactory r6 = r1.zzd     // Catch:{ IOException -> 0x02bb }
            r15.setSSLSocketFactory(r6)     // Catch:{ IOException -> 0x02bb }
        L_0x0036:
            int r6 = r1.zze     // Catch:{ IOException -> 0x02bb }
            r12.setConnectTimeout(r6)     // Catch:{ IOException -> 0x02bb }
            int r6 = r1.zzf     // Catch:{ IOException -> 0x02bb }
            r12.setReadTimeout(r6)     // Catch:{ IOException -> 0x02bb }
            com.google.android.gms.internal.ads.zzaud r6 = r1.zzh     // Catch:{ IOException -> 0x02bb }
            java.util.Map r6 = r6.zza()     // Catch:{ IOException -> 0x02bb }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x02bb }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x02bb }
        L_0x004e:
            boolean r15 = r6.hasNext()     // Catch:{ IOException -> 0x02bb }
            if (r15 == 0) goto L_0x006c
            java.lang.Object r15 = r6.next()     // Catch:{ IOException -> 0x02bb }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x02bb }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x02bb }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x02bb }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02bb }
            r12.setRequestProperty(r11, r15)     // Catch:{ IOException -> 0x02bb }
            goto L_0x004e
        L_0x006c:
            r6 = 27
            r17 = -1
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x007c
            int r11 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r11 == 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r21 = r7
            goto L_0x00bc
        L_0x007c:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r11.<init>(r6)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r15 = "bytes="
            r11.append(r15)     // Catch:{ IOException -> 0x02bb }
            r11.append(r7)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r15 = "-"
            r11.append(r15)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x02bb }
            int r15 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x00b5
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ IOException -> 0x02bb }
            long r19 = r7 + r9
            r21 = r7
            long r6 = r19 + r17
            int r15 = r11.length()     // Catch:{ IOException -> 0x02bb }
            int r15 = r15 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r14.<init>(r15)     // Catch:{ IOException -> 0x02bb }
            r14.append(r11)     // Catch:{ IOException -> 0x02bb }
            r14.append(r6)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r11 = r14.toString()     // Catch:{ IOException -> 0x02bb }
            goto L_0x00b7
        L_0x00b5:
            r21 = r7
        L_0x00b7:
            java.lang.String r6 = "Range"
            r12.setRequestProperty(r6, r11)     // Catch:{ IOException -> 0x02bb }
        L_0x00bc:
            java.lang.String r6 = "User-Agent"
            java.lang.String r7 = r1.zzg     // Catch:{ IOException -> 0x02bb }
            r12.setRequestProperty(r6, r7)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r6 = "Accept-Encoding"
            java.lang.String r7 = "identity"
            r12.setRequestProperty(r6, r7)     // Catch:{ IOException -> 0x02bb }
            r6 = 0
            r12.setInstanceFollowRedirects(r6)     // Catch:{ IOException -> 0x02bb }
            r12.setDoOutput(r6)     // Catch:{ IOException -> 0x02bb }
            r12.connect()     // Catch:{ IOException -> 0x02bb }
            int r6 = r12.getResponseCode()     // Catch:{ IOException -> 0x02bb }
            r7 = 300(0x12c, float:4.2E-43)
            if (r6 == r7) goto L_0x0253
            r7 = 301(0x12d, float:4.22E-43)
            if (r6 == r7) goto L_0x0253
            r7 = 302(0x12e, float:4.23E-43)
            if (r6 == r7) goto L_0x0253
            r7 = 303(0x12f, float:4.25E-43)
            if (r6 == r7) goto L_0x0253
            r7 = 307(0x133, float:4.3E-43)
            if (r6 == r7) goto L_0x0253
            r7 = 308(0x134, float:4.32E-43)
            if (r6 != r7) goto L_0x00f2
            goto L_0x0253
        L_0x00f2:
            r1.zzk = r12     // Catch:{ IOException -> 0x02bb }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x022c }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x0210
            r6 = 299(0x12b, float:4.19E-43)
            if (r0 <= r6) goto L_0x0102
            goto L_0x0210
        L_0x0102:
            if (r0 != r3) goto L_0x010b
            long r6 = r2.zzc
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r6 = r4
        L_0x010c:
            r1.zzn = r6
            long r6 = r2.zzd
            int r0 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0118
            r1.zzo = r6
            goto L_0x01ee
        L_0x0118:
            java.net.HttpURLConnection r0 = r1.zzk
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r7 = "]"
            if (r6 != 0) goto L_0x014e
            long r9 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x012d }
            goto L_0x0150
        L_0x012d:
            java.lang.String r6 = java.lang.String.valueOf(r3)
            int r6 = r6.length()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            int r6 = r6 + 28
            r9.<init>(r6)
            java.lang.String r6 = "Unexpected Content-Length ["
            r9.append(r6)
            r9.append(r3)
            r9.append(r7)
            java.lang.String r6 = r9.toString()
            com.google.android.gms.internal.ads.zzcgs.zzf(r6)
        L_0x014e:
            r9 = r17
        L_0x0150:
            java.lang.String r6 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x01e2
            java.util.regex.Pattern r6 = zzb
            java.util.regex.Matcher r6 = r6.matcher(r0)
            boolean r11 = r6.find()
            if (r11 == 0) goto L_0x01e2
            r11 = 2
            java.lang.String r11 = r6.group(r11)     // Catch:{ NumberFormatException -> 0x01c0 }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x01c0 }
            r13 = 1
            java.lang.String r6 = r6.group(r13)     // Catch:{ NumberFormatException -> 0x01c0 }
            long r13 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x01c0 }
            long r11 = r11 - r13
            r13 = 1
            long r11 = r11 + r13
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0184
            r9 = r11
            goto L_0x01e2
        L_0x0184:
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x01e2
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x01c0 }
            int r4 = r4.length()     // Catch:{ NumberFormatException -> 0x01c0 }
            int r4 = r4 + 26
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01c0 }
            int r5 = r5.length()     // Catch:{ NumberFormatException -> 0x01c0 }
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01c0 }
            r5.<init>(r4)     // Catch:{ NumberFormatException -> 0x01c0 }
            java.lang.String r4 = "Inconsistent headers ["
            r5.append(r4)     // Catch:{ NumberFormatException -> 0x01c0 }
            r5.append(r3)     // Catch:{ NumberFormatException -> 0x01c0 }
            java.lang.String r3 = "] ["
            r5.append(r3)     // Catch:{ NumberFormatException -> 0x01c0 }
            r5.append(r0)     // Catch:{ NumberFormatException -> 0x01c0 }
            r5.append(r7)     // Catch:{ NumberFormatException -> 0x01c0 }
            java.lang.String r3 = r5.toString()     // Catch:{ NumberFormatException -> 0x01c0 }
            com.google.android.gms.internal.ads.zzcgs.zzi(r3)     // Catch:{ NumberFormatException -> 0x01c0 }
            long r3 = java.lang.Math.max(r9, r11)     // Catch:{ NumberFormatException -> 0x01c0 }
            r9 = r3
            goto L_0x01e2
        L_0x01c0:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 27
            int r3 = r3 + r5
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r0)
            r4.append(r7)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.internal.ads.zzcgs.zzf(r0)
        L_0x01e2:
            int r0 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01ea
            long r3 = r1.zzn
            long r17 = r9 - r3
        L_0x01ea:
            r3 = r17
            r1.zzo = r3
        L_0x01ee:
            java.net.HttpURLConnection r0 = r1.zzk     // Catch:{ IOException -> 0x0205 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0205 }
            r1.zzl = r0     // Catch:{ IOException -> 0x0205 }
            r3 = 1
            r1.zzm = r3
            com.google.android.gms.internal.ads.zzauk<? super com.google.android.gms.internal.ads.zzcjs> r0 = r1.zzi
            if (r0 == 0) goto L_0x0202
            com.google.android.gms.internal.ads.zzckg r0 = (com.google.android.gms.internal.ads.zzckg) r0
            r0.zzj(r1, r2)
        L_0x0202:
            long r2 = r1.zzo
            return r2
        L_0x0205:
            r0 = move-exception
            r23.zzi()
            com.google.android.gms.internal.ads.zzaub r3 = new com.google.android.gms.internal.ads.zzaub
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzatx) r2, (int) r4)
            throw r3
        L_0x0210:
            java.net.HttpURLConnection r3 = r1.zzk
            java.util.Map r3 = r3.getHeaderFields()
            r23.zzi()
            com.google.android.gms.internal.ads.zzauc r4 = new com.google.android.gms.internal.ads.zzauc
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x022b
            com.google.android.gms.internal.ads.zzatw r0 = new com.google.android.gms.internal.ads.zzatw
            r6 = 0
            r0.<init>(r6)
            r4.initCause(r0)
        L_0x022b:
            throw r4
        L_0x022c:
            r0 = move-exception
            r4 = r0
            r23.zzi()
            com.google.android.gms.internal.ads.zzaub r0 = new com.google.android.gms.internal.ads.zzaub
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0248
            java.lang.String r3 = r3.concat(r5)
            goto L_0x024e
        L_0x0248:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x024e:
            r5 = 1
            r0.<init>(r3, r4, r2, r5)
            throw r0
        L_0x0253:
            r6 = 0
            java.lang.String r7 = "Location"
            java.lang.String r7 = r12.getHeaderField(r7)     // Catch:{ IOException -> 0x02bb }
            r12.disconnect()     // Catch:{ IOException -> 0x02bb }
            if (r7 == 0) goto L_0x029a
            java.net.URL r8 = new java.net.URL     // Catch:{ IOException -> 0x02bb }
            r8.<init>(r0, r7)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r0 = r8.getProtocol()     // Catch:{ IOException -> 0x02bb }
            java.lang.String r7 = "https"
            boolean r7 = r7.equals(r0)     // Catch:{ IOException -> 0x02bb }
            if (r7 != 0) goto L_0x0294
            java.lang.String r7 = "http"
            boolean r7 = r7.equals(r0)     // Catch:{ IOException -> 0x02bb }
            if (r7 != 0) goto L_0x0294
            java.net.ProtocolException r4 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02bb }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02bb }
            int r6 = r0.length()     // Catch:{ IOException -> 0x02bb }
            if (r6 == 0) goto L_0x028b
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x02bb }
            goto L_0x0290
        L_0x028b:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02bb }
            r0.<init>(r5)     // Catch:{ IOException -> 0x02bb }
        L_0x0290:
            r4.<init>(r0)     // Catch:{ IOException -> 0x02bb }
            throw r4     // Catch:{ IOException -> 0x02bb }
        L_0x0294:
            r0 = r8
            r12 = r13
            r7 = r21
            goto L_0x001e
        L_0x029a:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02bb }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x02bb }
            throw r0     // Catch:{ IOException -> 0x02bb }
        L_0x02a2:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02bb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02bb }
            r5 = 31
            r4.<init>(r5)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x02bb }
            r4.append(r13)     // Catch:{ IOException -> 0x02bb }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02bb }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02bb }
            throw r0     // Catch:{ IOException -> 0x02bb }
        L_0x02bb:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaub r4 = new com.google.android.gms.internal.ads.zzaub
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x02d3
            java.lang.String r3 = r3.concat(r5)
            goto L_0x02d9
        L_0x02d3:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x02d9:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            goto L_0x02df
        L_0x02de:
            throw r4
        L_0x02df:
            goto L_0x02de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjs.zza(com.google.android.gms.internal.ads.zzatx):long");
    }

    public final int zzb(byte[] bArr, int i, int i2) throws zzaub {
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
                    int read = this.zzl.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzauk<? super zzcjs> zzauk = this.zzi;
                        if (zzauk != null) {
                            ((zzckg) zzauk).zzq(this, read);
                        }
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
            int read2 = this.zzl.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzauk<? super zzcjs> zzauk2 = this.zzi;
                if (zzauk2 == null) {
                    return read2;
                }
                ((zzckg) zzauk2).zzq(this, read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzaub(e, this.zzj, 2);
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzaub {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzl     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzk     // Catch:{ all -> 0x008a }
            long r3 = r9.zzo     // Catch:{ all -> 0x008a }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzq     // Catch:{ all -> 0x008a }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ all -> 0x008a }
            r8 = 19
            if (r7 == r8) goto L_0x0021
            int r7 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ all -> 0x008a }
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
            java.io.InputStream r2 = r9.zzl     // Catch:{ IOException -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0079
        L_0x006f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzaub r3 = new com.google.android.gms.internal.ads.zzaub     // Catch:{ all -> 0x008a }
            com.google.android.gms.internal.ads.zzatx r4 = r9.zzj     // Catch:{ all -> 0x008a }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzatx) r4, (int) r5)     // Catch:{ all -> 0x008a }
            throw r3     // Catch:{ all -> 0x008a }
        L_0x0079:
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0084
            r9.zzm = r1
        L_0x0084:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            return
        L_0x008a:
            r2 = move-exception
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0096
            r9.zzm = r1
        L_0x0096:
            java.util.Set<java.net.Socket> r0 = r9.zzs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjs.zzd():void");
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzf(int i) {
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
