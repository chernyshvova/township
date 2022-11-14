package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzan {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final zzap zze;
    public final String zzf;

    public zzan(zzfu zzfu, String str, String str2, String str3, long j, long j2, zzap zzap) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzap);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfu.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId, name", zzeq.zza(str2), zzeq.zza(str3));
        }
        this.zze = zzap;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder outline23 = GeneratedOutlineSupport.outline23(valueOf.length() + GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 33)), "Event{appId='", str, "', name='", str2);
        outline23.append("', params=");
        outline23.append(valueOf);
        outline23.append('}');
        return outline23.toString();
    }

    public final zzan zza(zzfu zzfu, long j) {
        return new zzan(zzfu, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public zzan(zzfu zzfu, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzap zzap;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfu.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId", zzeq.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzap = new zzap(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzfu.zzq().zze().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzfu.zzh().zza(str4, bundle2.get(str4));
                    if (zza2 == null) {
                        zzfu.zzq().zzh().zza("Param value can't be null", zzfu.zzi().zzb(str4));
                        it.remove();
                    } else {
                        zzfu.zzh().zza(bundle2, str4, zza2);
                    }
                }
            }
            zzap = new zzap(bundle2);
        }
        this.zze = zzap;
    }
}
