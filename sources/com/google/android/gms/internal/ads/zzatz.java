package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatz implements zzaue {
    public static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> zzc = new AtomicReference<>();
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final zzaud zzg = new zzaud();
    public final zzauk<? super zzatz> zzh;
    public zzatx zzi;
    public HttpURLConnection zzj;
    public InputStream zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public long zzo;
    public long zzp;

    public zzatz(String str, zzauv<String> zzauv, zzauk<? super zzatz> zzauk, int i, int i2, boolean z, zzaud zzaud) {
        zzaul.zzf(str);
        this.zzf = str;
        this.zzh = zzauk;
        this.zzd = i;
        this.zze = i2;
    }

    private final void zzf() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fc, code lost:
        if (r3 != 0) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzatx r21) throws com.google.android.gms.internal.ads.zzaub {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "Unable to connect to "
            r1.zzi = r2
            r4 = 0
            r1.zzp = r4
            r1.zzo = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02b2 }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x02b2 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x02b2 }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x02b2 }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x02b2 }
            r12 = 0
        L_0x001e:
            int r13 = r12 + 1
            r14 = 20
            if (r12 > r14) goto L_0x0299
            java.net.URLConnection r12 = r0.openConnection()     // Catch:{ IOException -> 0x02b2 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x02b2 }
            int r15 = r1.zzd     // Catch:{ IOException -> 0x02b2 }
            r12.setConnectTimeout(r15)     // Catch:{ IOException -> 0x02b2 }
            int r15 = r1.zze     // Catch:{ IOException -> 0x02b2 }
            r12.setReadTimeout(r15)     // Catch:{ IOException -> 0x02b2 }
            com.google.android.gms.internal.ads.zzaud r15 = r1.zzg     // Catch:{ IOException -> 0x02b2 }
            java.util.Map r15 = r15.zza()     // Catch:{ IOException -> 0x02b2 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ IOException -> 0x02b2 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ IOException -> 0x02b2 }
        L_0x0042:
            boolean r16 = r15.hasNext()     // Catch:{ IOException -> 0x02b2 }
            if (r16 == 0) goto L_0x0062
            java.lang.Object r16 = r15.next()     // Catch:{ IOException -> 0x02b2 }
            java.util.Map$Entry r16 = (java.util.Map.Entry) r16     // Catch:{ IOException -> 0x02b2 }
            java.lang.Object r17 = r16.getKey()     // Catch:{ IOException -> 0x02b2 }
            r6 = r17
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x02b2 }
            java.lang.Object r16 = r16.getValue()     // Catch:{ IOException -> 0x02b2 }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x02b2 }
            r12.setRequestProperty(r6, r11)     // Catch:{ IOException -> 0x02b2 }
            goto L_0x0042
        L_0x0062:
            r6 = 27
            r15 = -1
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x006e
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x00a9
        L_0x006e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b2 }
            r11.<init>(r6)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r6 = "bytes="
            r11.append(r6)     // Catch:{ IOException -> 0x02b2 }
            r11.append(r7)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r6 = "-"
            r11.append(r6)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r6 = r11.toString()     // Catch:{ IOException -> 0x02b2 }
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x00a4
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x02b2 }
            long r18 = r7 + r9
            long r4 = r18 + r15
            int r11 = r6.length()     // Catch:{ IOException -> 0x02b2 }
            int r11 = r11 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b2 }
            r14.<init>(r11)     // Catch:{ IOException -> 0x02b2 }
            r14.append(r6)     // Catch:{ IOException -> 0x02b2 }
            r14.append(r4)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r6 = r14.toString()     // Catch:{ IOException -> 0x02b2 }
        L_0x00a4:
            java.lang.String r4 = "Range"
            r12.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x02b2 }
        L_0x00a9:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzf     // Catch:{ IOException -> 0x02b2 }
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r12.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x02b2 }
            r4 = 0
            r12.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x02b2 }
            r12.setDoOutput(r4)     // Catch:{ IOException -> 0x02b2 }
            r12.connect()     // Catch:{ IOException -> 0x02b2 }
            int r4 = r12.getResponseCode()     // Catch:{ IOException -> 0x02b2 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x0248
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0248
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0248
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x0248
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x0248
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00df
            goto L_0x0248
        L_0x00df:
            r1.zzj = r12     // Catch:{ IOException -> 0x02b2 }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x0221 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x0205
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x00ef
            goto L_0x0205
        L_0x00ef:
            java.net.HttpURLConnection r4 = r1.zzj
            r4.getContentType()
            if (r0 != r3) goto L_0x00ff
            long r3 = r2.zzc
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r3 = 0
        L_0x0101:
            r1.zzm = r3
            long r3 = r2.zzd
            int r0 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x010d
            r1.zzn = r3
            goto L_0x01e5
        L_0x010d:
            java.net.HttpURLConnection r0 = r1.zzj
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "DefaultHttpDataSource"
            java.lang.String r6 = "]"
            if (r4 != 0) goto L_0x0145
            long r7 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0124 }
            goto L_0x0146
        L_0x0124:
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r4 = r4 + 28
            r7.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Length ["
            r7.append(r4)
            r7.append(r3)
            r7.append(r6)
            java.lang.String r4 = r7.toString()
            android.util.Log.e(r5, r4)
        L_0x0145:
            r7 = r15
        L_0x0146:
            java.lang.String r4 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01da
            java.util.regex.Pattern r4 = zzb
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r9 = r4.find()
            if (r9 == 0) goto L_0x01da
            r9 = 2
            java.lang.String r9 = r4.group(r9)     // Catch:{ NumberFormatException -> 0x01b8 }
            long r9 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x01b8 }
            r11 = 1
            java.lang.String r4 = r4.group(r11)     // Catch:{ NumberFormatException -> 0x01b8 }
            long r11 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x01b8 }
            long r9 = r9 - r11
            r11 = 1
            long r9 = r9 + r11
            r18 = 0
            int r4 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r4 >= 0) goto L_0x017c
            r7 = r9
            goto L_0x01da
        L_0x017c:
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x01da
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x01b8 }
            int r4 = r4.length()     // Catch:{ NumberFormatException -> 0x01b8 }
            int r4 = r4 + 26
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01b8 }
            int r11 = r11.length()     // Catch:{ NumberFormatException -> 0x01b8 }
            int r4 = r4 + r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01b8 }
            r11.<init>(r4)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r4 = "Inconsistent headers ["
            r11.append(r4)     // Catch:{ NumberFormatException -> 0x01b8 }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r3 = "] ["
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x01b8 }
            r11.append(r0)     // Catch:{ NumberFormatException -> 0x01b8 }
            r11.append(r6)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r3 = r11.toString()     // Catch:{ NumberFormatException -> 0x01b8 }
            android.util.Log.w(r5, r3)     // Catch:{ NumberFormatException -> 0x01b8 }
            long r3 = java.lang.Math.max(r7, r9)     // Catch:{ NumberFormatException -> 0x01b8 }
            r7 = r3
            goto L_0x01da
        L_0x01b8:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r9 = 27
            int r3 = r3 + r9
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Range ["
            r4.append(r3)
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r5, r0)
        L_0x01da:
            int r0 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x01e2
            long r3 = r1.zzm
            long r15 = r7 - r3
        L_0x01e2:
            r3 = r15
            r1.zzn = r3
        L_0x01e5:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x01fa }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01fa }
            r1.zzk = r0     // Catch:{ IOException -> 0x01fa }
            r3 = 1
            r1.zzl = r3
            com.google.android.gms.internal.ads.zzauk<? super com.google.android.gms.internal.ads.zzatz> r0 = r1.zzh
            if (r0 == 0) goto L_0x01f7
            r0.zzj(r1, r2)
        L_0x01f7:
            long r2 = r1.zzn
            return r2
        L_0x01fa:
            r0 = move-exception
            r20.zzf()
            com.google.android.gms.internal.ads.zzaub r3 = new com.google.android.gms.internal.ads.zzaub
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzatx) r2, (int) r4)
            throw r3
        L_0x0205:
            java.net.HttpURLConnection r3 = r1.zzj
            java.util.Map r3 = r3.getHeaderFields()
            r20.zzf()
            com.google.android.gms.internal.ads.zzauc r4 = new com.google.android.gms.internal.ads.zzauc
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x0220
            com.google.android.gms.internal.ads.zzatw r0 = new com.google.android.gms.internal.ads.zzatw
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x0220:
            throw r4
        L_0x0221:
            r0 = move-exception
            r4 = r0
            r20.zzf()
            com.google.android.gms.internal.ads.zzaub r0 = new com.google.android.gms.internal.ads.zzaub
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x023d
            java.lang.String r3 = r3.concat(r5)
            goto L_0x0243
        L_0x023d:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x0243:
            r5 = 1
            r0.<init>(r3, r4, r2, r5)
            throw r0
        L_0x0248:
            r5 = 0
            r18 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r12.getHeaderField(r4)     // Catch:{ IOException -> 0x02b2 }
            r12.disconnect()     // Catch:{ IOException -> 0x02b2 }
            if (r4 == 0) goto L_0x0291
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x02b2 }
            r6.<init>(r0, r4)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r0 = r6.getProtocol()     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b2 }
            if (r4 != 0) goto L_0x028b
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r0)     // Catch:{ IOException -> 0x02b2 }
            if (r4 != 0) goto L_0x028b
            java.net.ProtocolException r4 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02b2 }
            int r6 = r0.length()     // Catch:{ IOException -> 0x02b2 }
            if (r6 == 0) goto L_0x0282
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x02b2 }
            goto L_0x0287
        L_0x0282:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x02b2 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x02b2 }
        L_0x0287:
            r4.<init>(r0)     // Catch:{ IOException -> 0x02b2 }
            throw r4     // Catch:{ IOException -> 0x02b2 }
        L_0x028b:
            r0 = r6
            r12 = r13
            r4 = r18
            goto L_0x001e
        L_0x0291:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b2 }
            throw r0     // Catch:{ IOException -> 0x02b2 }
        L_0x0299:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02b2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02b2 }
            r5 = 31
            r4.<init>(r5)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x02b2 }
            r4.append(r13)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02b2 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x02b2 }
            throw r0     // Catch:{ IOException -> 0x02b2 }
        L_0x02b2:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaub r4 = new com.google.android.gms.internal.ads.zzaub
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x02ca
            java.lang.String r3 = r3.concat(r5)
            goto L_0x02d0
        L_0x02ca:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x02d0:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            goto L_0x02d6
        L_0x02d5:
            throw r4
        L_0x02d6:
            goto L_0x02d5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatz.zza(com.google.android.gms.internal.ads.zzatx):long");
    }

    public final int zzb(byte[] bArr, int i, int i2) throws zzaub {
        try {
            if (this.zzo != this.zzm) {
                byte[] andSet = zzc.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzc.set(andSet);
                        break;
                    }
                    int read = this.zzk.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzo += (long) read;
                        zzauk<? super zzatz> zzauk = this.zzh;
                        if (zzauk != null) {
                            zzauk.zzk(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzp += (long) read2;
                zzauk<? super zzatz> zzauk2 = this.zzh;
                if (zzauk2 == null) {
                    return read2;
                }
                zzauk2.zzk(this, read2);
                return read2;
            } else if (this.zzn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzaub(e, this.zzi, 2);
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
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
            java.io.InputStream r2 = r9.zzk     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzj     // Catch:{ all -> 0x0085 }
            long r3 = r9.zzn     // Catch:{ all -> 0x0085 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzp     // Catch:{ all -> 0x0085 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ all -> 0x0085 }
            r8 = 19
            if (r7 == r8) goto L_0x0021
            int r7 = com.google.android.gms.internal.ads.zzava.zza     // Catch:{ all -> 0x0085 }
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
            com.google.android.gms.internal.ads.zzaub r3 = new com.google.android.gms.internal.ads.zzaub     // Catch:{ all -> 0x0085 }
            com.google.android.gms.internal.ads.zzatx r4 = r9.zzi     // Catch:{ all -> 0x0085 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzatx) r4, (int) r5)     // Catch:{ all -> 0x0085 }
            throw r3     // Catch:{ all -> 0x0085 }
        L_0x0079:
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0084
            r9.zzl = r1
        L_0x0084:
            return
        L_0x0085:
            r2 = move-exception
            r9.zzk = r0
            r9.zzf()
            boolean r0 = r9.zzl
            if (r0 == 0) goto L_0x0091
            r9.zzl = r1
        L_0x0091:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatz.zzd():void");
    }

    public final Map<String, List<String>> zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }
}
