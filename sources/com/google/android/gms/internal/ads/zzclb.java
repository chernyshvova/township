package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzclb extends zzckx {
    public zzclb(zzciz zzciz) {
        super(zzciz);
    }

    public final boolean zza(String str) {
        String zzd = zzcgl.zzd(str);
        zzciz zzciz = (zzciz) this.zzc.get();
        if (!(zzciz == null || zzd == null)) {
            zzciz.zzu(zzd, this);
        }
        zzcgs.zzi("VideoStreamNoopCache is doing nothing.");
        zzn(str, zzd, "noop", "Noop cache is a noop.");
        return false;
    }

    public final void zzg() {
    }
}
