package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeln implements zzelg<zzcxi> {
    @GuardedBy("this")
    public final zzeyv zza;
    public final zzcop zzb;
    public final Context zzc;
    public final zzeld zzd;
    @GuardedBy("this")
    @Nullable
    public zzcxw zze;

    public zzeln(zzcop zzcop, Context context, zzeld zzeld, zzeyv zzeyv) {
        this.zzb = zzcop;
        this.zzc = context;
        this.zzd = zzeld;
        this.zza = zzeyv;
        zzeyv.zzs(zzeld.zzc());
    }

    public final boolean zza(zzbdk zzbdk, String str, zzele zzele, zzelf<? super zzcxi> zzelf) throws RemoteException {
        zzs.zzc();
        if (zzr.zzK(this.zzc) && zzbdk.zzs == null) {
            zzcgs.zzf("Failed to load the ad because app ID is missing.");
            this.zzb.zze().execute(new zzeli(this));
            return false;
        } else if (str == null) {
            zzcgs.zzf("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zze().execute(new zzelj(this));
            return false;
        } else {
            zzezm.zzb(this.zzc, zzbdk.zzf);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgb)).booleanValue() && zzbdk.zzf) {
                this.zzb.zzz().zzc(true);
            }
            int i = ((zzelh) zzele).zza;
            zzeyv zzeyv = this.zza;
            zzeyv.zza(zzbdk);
            zzeyv.zzk(i);
            zzeyw zzu = zzeyv.zzu();
            if (zzu.zzn != null) {
                this.zzd.zzc().zzo(zzu.zzn);
            }
            zzdko zzr = this.zzb.zzr();
            zzdao zzdao = new zzdao();
            zzdao.zza(this.zzc);
            zzdao.zzb(zzu);
            zzr.zzd(zzdao.zzd());
            zzdgh zzdgh = new zzdgh();
            zzdgh.zze(this.zzd.zzc(), this.zzb.zze());
            zzr.zze(zzdgh.zzm());
            zzr.zzc(this.zzd.zzb());
            zzr.zzb(new zzcvg((ViewGroup) null));
            zzdkp zza2 = zzr.zza();
            this.zzb.zzy().zza(1);
            zzfqo zzfqo = zzche.zza;
            zzgjp.zzb(zzfqo);
            ScheduledExecutorService zzf = this.zzb.zzf();
            zzcyl<zzcxp> zza3 = zza2.zza();
            zzcxw zzcxw = new zzcxw(zzfqo, zzf, zza3.zzc(zza3.zzb()));
            this.zze = zzcxw;
            zzcxw.zza(new zzelm(this, zzelf, zza2));
            return true;
        }
    }

    public final boolean zzb() {
        zzcxw zzcxw = this.zze;
        return zzcxw != null && zzcxw.zzb();
    }

    public final /* synthetic */ void zzc() {
        this.zzd.zze().zzbT(zzezr.zzd(6, (String) null, (zzbdd) null));
    }

    public final /* synthetic */ void zzd() {
        this.zzd.zze().zzbT(zzezr.zzd(4, (String) null, (zzbdd) null));
    }
}
