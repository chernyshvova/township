package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemb implements zzeqo<Bundle> {
    public final zzbdp zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzemb(zzbdp zzbdp, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzbdp, "the adSize must not be null");
        this.zza = zzbdp;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = str3;
        this.zzi = z2;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzezi.zzb(bundle, "smart_w", "full", this.zza.zze == -1);
        zzezi.zzb(bundle, "smart_h", "auto", this.zza.zzb == -2);
        Boolean bool = Boolean.TRUE;
        zzezi.zzd(bundle, "ene", bool, this.zza.zzj);
        zzezi.zzb(bundle, "rafmt", "102", this.zza.zzm);
        zzezi.zzb(bundle, "rafmt", "103", this.zza.zzn);
        zzezi.zzb(bundle, "rafmt", "105", this.zza.zzo);
        zzezi.zzd(bundle, "inline_adaptive_slot", bool, this.zzi);
        zzezi.zzd(bundle, "interscroller_slot", bool, this.zza.zzo);
        zzezi.zze(bundle, GraphRequest.FORMAT_PARAM, this.zzb);
        zzezi.zzb(bundle, "fluid", "height", this.zzc);
        String str = this.zzd;
        zzezi.zzb(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        String str2 = this.zzh;
        zzezi.zzb(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzbdp[] zzbdpArr = this.zza.zzg;
        if (zzbdpArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (zzbdp zzbdp : zzbdpArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzbdp.zzi);
                bundle3.putInt("height", zzbdp.zzb);
                bundle3.putInt("width", zzbdp.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
