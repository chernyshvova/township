package com.google.firebase.analytics.connector.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzgx;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzd {
    public static final List<String> zzb = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"});
    public static final List<String> zzc = Arrays.asList(new String[]{"auto", "app", "am"});
    public static final List<String> zzd = Arrays.asList(new String[]{"_r", "_dbg"});
    public static final List<String> zze = Arrays.asList((String[]) ArrayUtils.concat(zzgx.zza, zzgx.zzb));
    public static final List<String> zzf = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    static {
        new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));
    }

    public static boolean zza(@NonNull String str) {
        return !zzc.contains(str);
    }
}
