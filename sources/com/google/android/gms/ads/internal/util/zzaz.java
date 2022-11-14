package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzal;
import com.google.android.gms.internal.ads.zzaq;
import com.google.android.gms.internal.ads.zzar;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzbc;
import com.google.android.gms.internal.ads.zzbd;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzy;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaz extends zzar {
    public final Context zzc;

    public zzaz(Context context, zzaq zzaq) {
        super(zzaq);
        this.zzc = context;
    }

    public static zzaf zzb(Context context) {
        zzaf zzaf = new zzaf(new zzay(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzaz(context, new zzbd((zzbc) null, (SSLSocketFactory) null)), 4);
        zzaf.zza();
        return zzaf;
    }

    public final zzy zza(zzac<?> zzac) throws zzal {
        String str;
        if (zzac.zza() == 0) {
            if (Pattern.matches((String) zzbex.zzc().zzb(zzbjn.zzcL), zzac.zzh())) {
                zzbev.zza();
                if (zzcgl.zzn(this.zzc, 13400000)) {
                    zzy zza = new zzbrl(this.zzc).zza(zzac);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzac.zzh());
                        zze.zza(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzac.zzh());
                    if (valueOf2.length() != 0) {
                        str = "Failed to get gmscore asset response: ".concat(valueOf2);
                    } else {
                        str = new String("Failed to get gmscore asset response: ");
                    }
                    zze.zza(str);
                }
            }
        }
        return super.zza(zzac);
    }
}
