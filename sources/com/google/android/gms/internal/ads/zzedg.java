package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.overlay.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzedg implements DialogInterface.OnCancelListener {
    public final zzedb zza;
    public final String zzb;
    public final zzduu zzc;
    public final Activity zzd;
    public final zzfdh zze;
    public final zzl zzf;

    public zzedg(zzedb zzedb, String str, zzduu zzduu, Activity activity, zzfdh zzfdh, zzl zzl) {
        this.zza = zzedb;
        this.zzb = str;
        this.zzc = zzduu;
        this.zzd = activity;
        this.zze = zzfdh;
        this.zzf = zzl;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zzedb zzedb = this.zza;
        String str = this.zzb;
        zzduu zzduu = this.zzc;
        Activity activity = this.zzd;
        zzfdh zzfdh = this.zze;
        zzl zzl = this.zzf;
        zzedb.zzd(str);
        if (zzduu != null) {
            zzedj.zzh(activity, zzduu, zzfdh, zzedb, str, "dialog_click", GeneratedOutlineSupport.outline28("dialog_action", "dismiss"));
        }
        if (zzl != null) {
            zzl.zzb();
        }
    }
}
