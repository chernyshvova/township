package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhd extends zzhg {
    public final View zzi;

    public zzhd(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2, View view) {
        super(zzfy, "omAlF62gEMrNCr0H2QBW8XF28QiQE0CMIbyOpElqQZ4tBrxF8DZXvihPhTWIx0tC", "dyzDhPt8uBzEduoVVJNMFQS7AR2KfsUmAWoQzpkryTU=", zzcn, i, 57);
        this.zzi = view;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzbex.zzc().zzb(zzbjn.zzbT);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzgc zzgc = new zzgc((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool}));
            zzda zza = zzdb.zza();
            zza.zza(zzgc.zza.longValue());
            zza.zzb(zzgc.zzb.longValue());
            zza.zzc(zzgc.zzc.longValue());
            if (bool.booleanValue()) {
                zza.zzd(zzgc.zzd.longValue());
            }
            this.zze.zzO((zzdb) zza.zzah());
        }
    }
}
