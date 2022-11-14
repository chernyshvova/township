package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.internal.ads.zzcay;
import com.google.android.gms.internal.ads.zzcdz;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzb {
    public final Context zza;
    public boolean zzb;
    @Nullable
    public final zzcdz zzc;
    public final zzcay zzd = new zzcay(false, Collections.emptyList());

    public zzb(Context context, @Nullable zzcdz zzcdz, @Nullable zzcay zzcay) {
        this.zza = context;
        this.zzc = zzcdz;
    }

    private final boolean zzd() {
        zzcdz zzcdz = this.zzc;
        return (zzcdz != null && zzcdz.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        return !zzd() || this.zzb;
    }

    public final void zzc(@Nullable String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcdz zzcdz = this.zzc;
            if (zzcdz != null) {
                zzcdz.zze(str, (Map<String, String>) null, 3);
                return;
            }
            zzcay zzcay = this.zzd;
            if (zzcay.zza && (list = zzcay.zzb) != null) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzs.zzc();
                        zzr.zzN(this.zza, "", replace);
                    }
                }
            }
        }
    }
}
