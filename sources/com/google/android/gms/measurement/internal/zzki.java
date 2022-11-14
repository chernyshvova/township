package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public abstract class zzki extends zzkj {
    public boolean zzb;

    public zzki(zzkl zzkl) {
        super(zzkl);
        this.zza.zza(this);
    }

    public final boolean zzai() {
        return this.zzb;
    }

    public final void zzaj() {
        if (!zzai()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzak() {
        if (!this.zzb) {
            zzd();
            this.zza.zzs();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzd();
}
