package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzaq;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbj;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzfqn;
import com.google.android.gms.internal.ads.zzk;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbp {
    @Deprecated
    public static final zzbl<Void> zza = new zzbi();
    public static zzaf zzb;
    public static final Object zzc = new Object();

    public zzbp(Context context) {
        zzaf zzaf;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbjn.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcK)).booleanValue()) {
                        zzaf = zzaz.zzb(context);
                        zzb = zzaf;
                    }
                }
                zzaf = zzbj.zza(context, (zzaq) null);
                zzb = zzaf;
            }
        }
    }

    public final zzfqn<zzy> zza(String str) {
        zzchj zzchj = new zzchj();
        zzb.zzb(new zzbo(str, (Map<String, String>) null, zzchj));
        return zzchj;
    }

    public final zzfqn<String> zzb(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        String str2 = str;
        zzbm zzbm = new zzbm((zzbi) null);
        zzbj zzbj = new zzbj(this, str2, zzbm);
        zzcgr zzcgr = new zzcgr((String) null);
        zzbk zzbk = new zzbk(this, i, str, zzbm, zzbj, bArr, map, zzcgr);
        if (zzcgr.zzj()) {
            try {
                zzcgr.zzb(str2, "GET", zzbk.zzm(), zzbk.zzn());
            } catch (zzk e) {
                zzcgs.zzi(e.getMessage());
            }
        }
        zzb.zzb(zzbk);
        return zzbm;
    }
}
