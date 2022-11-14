package com.google.android.gms.internal.ads;

import android.view.View;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdnk {
    public final zzdsf zza;
    public final zzdqu zzb;
    public final zzcuc zzc;
    public final zzdmi zzd;

    public zzdnk(zzdsf zzdsf, zzdqu zzdqu, zzcuc zzcuc, zzdmi zzdmi) {
        this.zza = zzdsf;
        this.zzb = zzdqu;
        this.zzc = zzcuc;
        this.zzd = zzdmi;
    }

    public final View zza() throws zzcnc {
        zzcmr zza2 = this.zza.zza(zzbdp.zzb(), (zzeye) null, (zzeyh) null);
        ((View) zza2).setVisibility(8);
        zza2.zzab("/sendMessageToSdk", new zzdne(this));
        zza2.zzab("/adMuted", new zzdnf(this));
        this.zzb.zzh(new WeakReference(zza2), "/loadHtml", new zzdng(this));
        this.zzb.zzh(new WeakReference(zza2), "/showOverlay", new zzdnh(this));
        this.zzb.zzh(new WeakReference(zza2), "/hideOverlay", new zzdni(this));
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(zzcmr zzcmr, Map map) {
        zzcgs.zzh("Hiding native ads overlay.");
        zzcmr.zzH().setVisibility(8);
        this.zzc.zze(false);
    }

    public final /* synthetic */ void zzc(zzcmr zzcmr, Map map) {
        zzcgs.zzh("Showing native ads overlay.");
        zzcmr.zzH().setVisibility(0);
        this.zzc.zze(true);
    }

    public final /* synthetic */ void zzd(Map map, boolean z) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("messageType", "htmlLoaded");
        outline28.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", outline28);
    }

    public final /* synthetic */ void zze(zzcmr zzcmr, Map map) {
        this.zzd.zzt();
    }

    public final /* synthetic */ void zzf(zzcmr zzcmr, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }
}
