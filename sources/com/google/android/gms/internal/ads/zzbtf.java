package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzcb;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtf implements zzbps<zzbtu> {
    public final /* synthetic */ zzbso zza;
    public final /* synthetic */ zzcb zzb;
    public final /* synthetic */ zzbtt zzc;

    public zzbtf(zzbtt zzbtt, zzfb zzfb, zzbso zzbso, zzcb zzcb) {
        this.zzc = zzbtt;
        this.zza = zzbso;
        this.zzb = zzcb;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbps, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbtu zzbtu = (zzbtu) obj;
        synchronized (this.zzc.zza) {
            zzcgs.zzh("JS Engine is requesting an update");
            if (this.zzc.zzh == 0) {
                zzcgs.zzh("Starting reload.");
                int unused = this.zzc.zzh = 2;
                this.zzc.zza((zzfb) null);
            }
            this.zza.zzm("/requestReload", this.zzb.zza());
        }
    }
}
