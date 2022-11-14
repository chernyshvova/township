package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcvm extends zzcvj {
    public final Context zzc;
    public final View zzd;
    @Nullable
    public final zzcmr zze;
    public final zzeyf zzf;
    public final zzcxg zzg;
    public final zzdml zzh;
    public final zzdie zzi;
    public final zzgja<zzejt> zzj;
    public final Executor zzk;
    public zzbdp zzl;

    public zzcvm(zzcxh zzcxh, Context context, zzeyf zzeyf, View view, @Nullable zzcmr zzcmr, zzcxg zzcxg, zzdml zzdml, zzdie zzdie, zzgja<zzejt> zzgja, Executor executor) {
        super(zzcxh);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcmr;
        this.zzf = zzeyf;
        this.zzg = zzcxg;
        this.zzh = zzdml;
        this.zzi = zzdie;
        this.zzj = zzgja;
        this.zzk = executor;
    }

    public final void zzS() {
        this.zzk.execute(new zzcvl(this));
        super.zzS();
    }

    public final View zza() {
        return this.zzd;
    }

    public final void zzb(ViewGroup viewGroup, zzbdp zzbdp) {
        zzcmr zzcmr;
        if (viewGroup != null && (zzcmr = this.zze) != null) {
            zzcmr.zzaf(zzcoh.zza(zzbdp));
            viewGroup.setMinimumHeight(zzbdp.zzc);
            viewGroup.setMinimumWidth(zzbdp.zzf);
            this.zzl = zzbdp;
        }
    }

    public final zzbhg zzc() {
        try {
            return this.zzg.zza();
        } catch (zzezb unused) {
            return null;
        }
    }

    public final zzeyf zze() {
        zzbdp zzbdp = this.zzl;
        if (zzbdp != null) {
            return zzeza.zzc(zzbdp);
        }
        zzeye zzeye = this.zzb;
        if (zzeye.zzX) {
            for (String next : zzeye.zza) {
                if (next == null || !next.contains("FirstParty")) {
                }
            }
            return new zzeyf(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return zzeza.zza(this.zzb.zzr, this.zzf);
    }

    public final zzeyf zzf() {
        return this.zzf;
    }

    public final int zzg() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() && this.zzb.zzac) {
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfo)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final void zzh() {
        this.zzi.zza();
    }

    public final /* bridge */ /* synthetic */ void zzj() {
        if (this.zzh.zzd() != null) {
            try {
                this.zzh.zzd().zze(this.zzj.zzb(), ObjectWrapper.wrap(this.zzc));
            } catch (RemoteException e) {
                zzcgs.zzg("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
