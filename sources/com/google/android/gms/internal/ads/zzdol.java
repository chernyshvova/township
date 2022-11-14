package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdol implements Callable {
    public final zzdom zza;
    public final zzfqn zzb;
    public final zzfqn zzc;
    public final zzfqn zzd;
    public final zzfqn zze;
    public final zzfqn zzf;
    public final JSONObject zzg;
    public final zzfqn zzh;
    public final zzfqn zzi;
    public final zzfqn zzj;
    public final zzfqn zzk;

    public zzdol(zzdom zzdom, zzfqn zzfqn, zzfqn zzfqn2, zzfqn zzfqn3, zzfqn zzfqn4, zzfqn zzfqn5, JSONObject jSONObject, zzfqn zzfqn6, zzfqn zzfqn7, zzfqn zzfqn8, zzfqn zzfqn9) {
        this.zza = zzdom;
        this.zzb = zzfqn;
        this.zzc = zzfqn2;
        this.zzd = zzfqn3;
        this.zze = zzfqn4;
        this.zzf = zzfqn5;
        this.zzg = jSONObject;
        this.zzh = zzfqn6;
        this.zzi = zzfqn7;
        this.zzj = zzfqn8;
        this.zzk = zzfqn9;
    }

    public final Object call() {
        zzfqn zzfqn = this.zzb;
        zzfqn zzfqn2 = this.zzc;
        zzfqn zzfqn3 = this.zzd;
        zzfqn zzfqn4 = this.zze;
        zzfqn zzfqn5 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzfqn zzfqn6 = this.zzh;
        zzfqn zzfqn7 = this.zzi;
        zzfqn zzfqn8 = this.zzj;
        zzfqn zzfqn9 = this.zzk;
        zzdma zzdma = (zzdma) zzfqn.get();
        zzdma.zzd((List) zzfqn2.get());
        zzdma.zzj((zzbmi) zzfqn3.get());
        zzdma.zzk((zzbmi) zzfqn4.get());
        zzdma.zzc((zzbma) zzfqn5.get());
        zzdma.zze(zzdoz.zzj(jSONObject));
        zzdma.zzf(zzdoz.zzi(jSONObject));
        zzcmr zzcmr = (zzcmr) zzfqn6.get();
        if (zzcmr != null) {
            zzdma.zzm(zzcmr);
            zzdma.zzg(zzcmr.zzH());
            zzdma.zzb(zzcmr.zzh());
        }
        zzcmr zzcmr2 = (zzcmr) zzfqn7.get();
        if (zzcmr2 != null) {
            zzdma.zzn(zzcmr2);
            zzdma.zzh(zzcmr2.zzH());
        }
        zzcmr zzcmr3 = (zzcmr) zzfqn8.get();
        if (zzcmr3 != null) {
            zzdma.zzo(zzcmr3);
        }
        for (zzdpd zzdpd : (List) zzfqn9.get()) {
            if (zzdpd.zza != 1) {
                zzdma.zzr(zzdpd.zzb, zzdpd.zzd);
            } else {
                zzdma.zzq(zzdpd.zzb, zzdpd.zzc);
            }
        }
        return zzdma;
    }
}
