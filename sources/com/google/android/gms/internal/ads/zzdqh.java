package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqh implements zzbps<Object> {
    @Nullable
    public final zzbnm zza;
    public final zzdqu zzb;
    public final zzgja<zzdqd> zzc;

    public zzdqh(zzdml zzdml, zzdma zzdma, zzdqu zzdqu, zzgja<zzdqd> zzgja) {
        this.zza = zzdml.zzg(zzdma.zzQ());
        this.zzb = zzdqu;
        this.zzc = zzgja;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zza.zze(this.zzc.zzb(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
            zzcgs.zzj(sb.toString(), e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzd("/nativeAdCustomClick", this);
        }
    }
}
