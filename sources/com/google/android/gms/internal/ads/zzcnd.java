package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcnd {
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcmr] */
    public static final zzcmr zza(Context context, zzcoh zzcoh, String str, boolean z, boolean z2, @Nullable zzfb zzfb, zzbkm zzbkm, zzcgy zzcgy, zzbkc zzbkc, zzl zzl, zza zza, zzayx zzayx, zzeye zzeye, zzeyh zzeyh) throws zzcnc {
        StrictMode.ThreadPolicy threadPolicy;
        zzbjn.zza(context);
        try {
            zzcna zzcna = new zzcna(context, zzcoh, str, z, z2, zzfb, zzbkm, zzcgy, (zzbkc) null, zzl, zza, zzayx, zzeye, zzeyh);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzcna.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzcnc("Webview initialization failed.", th);
        }
    }

    public static final zzfqn<zzcmr> zzb(Context context, zzcgy zzcgy, String str, zzfb zzfb, zza zza) {
        return zzfqe.zzi(zzfqe.zza(null), new zzcmz(context, zzfb, zzcgy, zza, str), zzche.zze);
    }
}
