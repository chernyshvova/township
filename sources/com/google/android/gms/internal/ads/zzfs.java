package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.LegacyTokenHelper;
import com.facebook.appevents.aam.MetadataRule;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfs implements zzfiq {
    public final zzfgp zza;
    public final zzfhg zzb;
    public final zzgf zzc;
    public final zzfr zzd;

    public zzfs(@NonNull zzfgp zzfgp, @NonNull zzfhg zzfhg, @NonNull zzgf zzgf, @NonNull zzfr zzfr) {
        this.zza = zzfgp;
        this.zzb = zzfhg;
        this.zzc = zzgf;
        this.zzd = zzfr;
    }

    private final Map<String, Object> zze() {
        HashMap hashMap = new HashMap();
        zzdc zzc2 = this.zzb.zzc();
        hashMap.put(MetadataRule.FIELD_V, this.zza.zza());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put(LegacyTokenHelper.TYPE_INTEGER, zzc2.zzc());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    public final void zza(View view) {
        this.zzc.zza(view);
    }

    public final Map<String, Object> zzb() {
        Map<String, Object> zze = zze();
        zzdc zzb2 = this.zzb.zzb();
        zze.put("gai", Boolean.valueOf(this.zza.zzb()));
        zze.put(ProfileTable.Columns.COLUMN_DID, zzb2.zzd());
        zze.put("dst", Integer.valueOf(zzb2.zze().zza()));
        zze.put("doo", Boolean.valueOf(zzb2.zzf()));
        return zze;
    }

    public final Map<String, Object> zzc() {
        return zze();
    }

    public final Map<String, Object> zzd() {
        Map<String, Object> zze = zze();
        zze.put("lts", Long.valueOf(this.zzc.zzc()));
        return zze;
    }
}
