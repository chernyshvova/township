package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajb extends zzahm {
    public final Resources zza;
    public final String zzb;
    @Nullable
    public Uri zzc;
    @Nullable
    public AssetFileDescriptor zzd;
    @Nullable
    public InputStream zze;
    public long zzf;
    public boolean zzg;

    public zzajb(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i);
        return Uri.parse(sb.toString());
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaja {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzf;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzaja((Throwable) e);
            }
        }
        InputStream inputStream = this.zze;
        int i3 = zzalh.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.zzf;
            if (j2 != -1) {
                this.zzf = j2 - ((long) read);
            }
            zzi(read);
            return read;
        } else if (this.zzf == -1) {
            return -1;
        } else {
            throw new zzaja((Throwable) new EOFException());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r1.matches("\\d+") != false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzc(com.google.android.gms.internal.ads.zzahx r13) throws com.google.android.gms.internal.ads.zzaja {
        /*
            r12 = this;
            android.net.Uri r0 = r13.zza
            r12.zzc = r0
            java.lang.String r1 = r0.getScheme()
            java.lang.String r2 = "rawresource"
            boolean r1 = android.text.TextUtils.equals(r2, r1)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x00a1
            java.lang.String r1 = r0.getScheme()
            java.lang.String r4 = "android.resource"
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            if (r1 == 0) goto L_0x0038
            java.util.List r1 = r0.getPathSegments()
            int r1 = r1.size()
            if (r1 != r3) goto L_0x0038
            java.lang.String r1 = r0.getLastPathSegment()
            if (r1 == 0) goto L_0x0037
            java.lang.String r5 = "\\d+"
            boolean r1 = r1.matches(r5)
            if (r1 == 0) goto L_0x0038
            goto L_0x00a1
        L_0x0037:
            throw r2
        L_0x0038:
            java.lang.String r1 = r0.getScheme()
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = r0.getPath()
            if (r1 == 0) goto L_0x0098
            java.lang.String r2 = "/"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0054
            java.lang.String r1 = r1.substring(r3)
        L_0x0054:
            java.lang.String r2 = r0.getHost()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0061
            java.lang.String r2 = ""
            goto L_0x006b
        L_0x0061:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = ":"
            java.lang.String r2 = r2.concat(r4)
        L_0x006b:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x007e
            java.lang.String r1 = r2.concat(r1)
            goto L_0x0083
        L_0x007e:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x0083:
            android.content.res.Resources r2 = r12.zza
            java.lang.String r4 = r12.zzb
            java.lang.String r5 = "raw"
            int r1 = r2.getIdentifier(r1, r5, r4)
            if (r1 == 0) goto L_0x0090
            goto L_0x00ab
        L_0x0090:
            com.google.android.gms.internal.ads.zzaja r13 = new com.google.android.gms.internal.ads.zzaja
            java.lang.String r0 = "Resource not found."
            r13.<init>((java.lang.String) r0)
            throw r13
        L_0x0098:
            throw r2
        L_0x0099:
            com.google.android.gms.internal.ads.zzaja r13 = new com.google.android.gms.internal.ads.zzaja
            java.lang.String r0 = "URI must either use scheme rawresource or android.resource"
            r13.<init>((java.lang.String) r0)
            throw r13
        L_0x00a1:
            java.lang.String r1 = r0.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0175 }
            if (r1 == 0) goto L_0x0174
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0175 }
        L_0x00ab:
            r12.zzg(r13)
            android.content.res.Resources r2 = r12.zza     // Catch:{ NotFoundException -> 0x016d }
            android.content.res.AssetFileDescriptor r1 = r2.openRawResourceFd(r1)     // Catch:{ NotFoundException -> 0x016d }
            r12.zzd = r1
            if (r1 == 0) goto L_0x0152
            long r4 = r1.getLength()
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.io.FileDescriptor r2 = r1.getFileDescriptor()
            r0.<init>(r2)
            r12.zze = r0
            r2 = 0
            r6 = -1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00db
            long r8 = r13.zzf     // Catch:{ IOException -> 0x014b }
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x00d5
            goto L_0x00db
        L_0x00d5:
            com.google.android.gms.internal.ads.zzahu r13 = new com.google.android.gms.internal.ads.zzahu     // Catch:{ IOException -> 0x014b }
            r13.<init>(r2)     // Catch:{ IOException -> 0x014b }
            throw r13     // Catch:{ IOException -> 0x014b }
        L_0x00db:
            long r8 = r1.getStartOffset()     // Catch:{ IOException -> 0x014b }
            long r10 = r13.zzf     // Catch:{ IOException -> 0x014b }
            long r10 = r10 + r8
            long r10 = r0.skip(r10)     // Catch:{ IOException -> 0x014b }
            long r10 = r10 - r8
            long r8 = r13.zzf     // Catch:{ IOException -> 0x014b }
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0145
            r8 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0119
            java.nio.channels.FileChannel r0 = r0.getChannel()     // Catch:{ IOException -> 0x014b }
            long r4 = r0.size()     // Catch:{ IOException -> 0x014b }
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0103
            r12.zzf = r6     // Catch:{ IOException -> 0x014b }
            r4 = r6
            goto L_0x0120
        L_0x0103:
            long r4 = r0.size()     // Catch:{ IOException -> 0x014b }
            long r0 = r0.position()     // Catch:{ IOException -> 0x014b }
            long r4 = r4 - r0
            r12.zzf = r4     // Catch:{ IOException -> 0x014b }
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0113
            goto L_0x0120
        L_0x0113:
            com.google.android.gms.internal.ads.zzahu r13 = new com.google.android.gms.internal.ads.zzahu     // Catch:{ IOException -> 0x014b }
            r13.<init>(r2)     // Catch:{ IOException -> 0x014b }
            throw r13     // Catch:{ IOException -> 0x014b }
        L_0x0119:
            long r4 = r4 - r10
            r12.zzf = r4     // Catch:{ IOException -> 0x014b }
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x013f
        L_0x0120:
            long r0 = r13.zzg
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0130
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x012e
            long r0 = java.lang.Math.min(r4, r0)
        L_0x012e:
            r12.zzf = r0
        L_0x0130:
            r12.zzg = r3
            r12.zzh(r13)
            long r0 = r13.zzg
            int r13 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x013c
            return r0
        L_0x013c:
            long r0 = r12.zzf
            return r0
        L_0x013f:
            com.google.android.gms.internal.ads.zzahu r13 = new com.google.android.gms.internal.ads.zzahu     // Catch:{ IOException -> 0x014b }
            r13.<init>(r2)     // Catch:{ IOException -> 0x014b }
            throw r13     // Catch:{ IOException -> 0x014b }
        L_0x0145:
            com.google.android.gms.internal.ads.zzahu r13 = new com.google.android.gms.internal.ads.zzahu     // Catch:{ IOException -> 0x014b }
            r13.<init>(r2)     // Catch:{ IOException -> 0x014b }
            throw r13     // Catch:{ IOException -> 0x014b }
        L_0x014b:
            r13 = move-exception
            com.google.android.gms.internal.ads.zzaja r0 = new com.google.android.gms.internal.ads.zzaja
            r0.<init>((java.lang.Throwable) r13)
            throw r0
        L_0x0152:
            com.google.android.gms.internal.ads.zzaja r13 = new com.google.android.gms.internal.ads.zzaja
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 24
            r2.<init>(r1)
            java.lang.String r1 = "Resource is compressed: "
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r2, r1, r0)
            r13.<init>((java.lang.String) r0)
            throw r13
        L_0x016d:
            r13 = move-exception
            com.google.android.gms.internal.ads.zzaja r0 = new com.google.android.gms.internal.ads.zzaja
            r0.<init>((java.lang.Throwable) r13)
            throw r0
        L_0x0174:
            throw r2     // Catch:{ NumberFormatException -> 0x0175 }
        L_0x0175:
            com.google.android.gms.internal.ads.zzaja r13 = new com.google.android.gms.internal.ads.zzaja
            java.lang.String r0 = "Resource identifier must be an integer."
            r13.<init>((java.lang.String) r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajb.zzc(com.google.android.gms.internal.ads.zzahx):long");
    }

    @Nullable
    public final Uri zzd() {
        return this.zzc;
    }

    public final void zzf() throws zzaja {
        this.zzc = null;
        try {
            InputStream inputStream = this.zze;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzd;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzj();
                }
            } catch (IOException e) {
                throw new zzaja((Throwable) e);
            } catch (Throwable th) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzj();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new zzaja((Throwable) e2);
        } catch (Throwable th2) {
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzd;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzj();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzaja((Throwable) e3);
            } catch (Throwable th3) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzj();
                }
                throw th3;
            }
        }
    }
}
