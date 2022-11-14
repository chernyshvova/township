package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzciy {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final boolean zzn;

    public zzciy(String str) {
        String str2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbjn.zzD);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbjn.zzj);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbjn.zzr);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbjn.zzf);
        zzbjf zzbjf = zzbjn.zze;
        if (jSONObject != null) {
            try {
                str2 = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = str2;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbjn.zzg);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbjn.zzh);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbjn.zzi);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbjn.zzk);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbjn.zzcC);
            this.zzk = zzb(jSONObject, "min_retry_count", zzbjn.zzl);
            this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbjn.zzo);
            this.zzm = zza(jSONObject, "using_official_exo_player", zzbjn.zzbk);
            this.zzn = zza(jSONObject, "using_official_simple_exo_player", zzbjn.zzbl);
        }
        str2 = (String) zzbex.zzc().zzb(zzbjf);
        this.zze = str2;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbjn.zzg);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbjn.zzh);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbjn.zzi);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbjn.zzk);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbjn.zzcC);
        this.zzk = zzb(jSONObject, "min_retry_count", zzbjn.zzl);
        this.zzl = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbjn.zzo);
        this.zzm = zza(jSONObject, "using_official_exo_player", zzbjn.zzbk);
        this.zzn = zza(jSONObject, "using_official_simple_exo_player", zzbjn.zzbl);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzbjf, com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r0.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r1 == 0) goto L_0x0014
            boolean r3 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0014 }
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciy.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzbjf):boolean");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzbjf<java.lang.Integer>, com.google.android.gms.internal.ads.zzbjf] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r0.zzb(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciy.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzbjf):int");
    }
}
