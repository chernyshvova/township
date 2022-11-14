package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdmy implements zzblu {
    public final /* synthetic */ zzdnu zza;
    public final /* synthetic */ ViewGroup zzb;

    public zzdmy(zzdnu zzdnu, ViewGroup viewGroup) {
        this.zza = zzdnu;
        this.zzb = viewGroup;
    }

    public final void zza() {
        zzdnu zzdnu = this.zza;
        zzfml<String> zzfml = zzdmv.zza;
        Map<String, WeakReference<View>> zzk = zzdnu.zzk();
        if (zzk != null) {
            int size = zzfml.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (zzk.get(zzfml.get(i)) == null) {
                    i = i2;
                } else {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }

    public final JSONObject zzc() {
        return this.zza.zzp();
    }

    public final JSONObject zzd() {
        return this.zza.zzq();
    }
}
