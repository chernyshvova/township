package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzgq extends zzgr {
    public boolean zza;

    public zzgq(zzfu zzfu) {
        super(zzfu);
        this.zzy.zza(this);
    }

    /* renamed from: g_ */
    public void mo31500g_() {
    }

    public final boolean zzaa() {
        return this.zza;
    }

    public final void zzab() {
        if (!zzaa()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzd()) {
            this.zzy.zzae();
            this.zza = true;
        }
    }

    public final void zzad() {
        if (!this.zza) {
            mo31500g_();
            this.zzy.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzd();
}
