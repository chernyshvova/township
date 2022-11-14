package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WorkerThread
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzif implements Runnable {
    public final URL zza;
    public final byte[] zzb = null;
    public final zzic zzc;
    public final String zzd;
    public final Map<String, String> zze;
    public final /* synthetic */ zzid zzf;

    public zzif(zzid zzid, String str, URL url, byte[] bArr, Map<String, String> map, zzic zzic) {
        this.zzf = zzid;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzic);
        this.zza = url;
        this.zzc = zzic;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzp().zza((Runnable) new zzie(this, i, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzid r0 = r5.zzf
            r0.zzb()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzid r2 = r5.zzf     // Catch:{ IOException -> 0x003a, all -> 0x002e }
            java.net.URL r3 = r5.zza     // Catch:{ IOException -> 0x003a, all -> 0x002e }
            java.net.HttpURLConnection r2 = r2.zza((java.net.URL) r3)     // Catch:{ IOException -> 0x003a, all -> 0x002e }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            com.google.android.gms.measurement.internal.zzid r4 = r5.zzf     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            byte[] r4 = com.google.android.gms.measurement.internal.zzid.zza((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            r2.disconnect()
            r5.zzb(r1, r0, r4, r3)
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            r4 = move-exception
            goto L_0x003d
        L_0x0028:
            r4 = move-exception
            r3 = r0
            goto L_0x0031
        L_0x002b:
            r4 = move-exception
            r3 = r0
            goto L_0x003d
        L_0x002e:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x0031:
            if (r2 == 0) goto L_0x0036
            r2.disconnect()
        L_0x0036:
            r5.zzb(r1, r0, r0, r3)
            throw r4
        L_0x003a:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            r2.disconnect()
        L_0x0042:
            r5.zzb(r1, r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzif.run():void");
    }

    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
