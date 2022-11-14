package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzg extends zzd {
    public boolean zza;

    public zzg(zzfu zzfu) {
        super(zzfu);
        this.zzy.zza(this);
    }

    public final boolean zzu() {
        return this.zza;
    }

    public final void zzv() {
        if (!zzu()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzy()) {
            this.zzy.zzae();
            this.zza = true;
        }
    }

    public final void zzx() {
        if (!this.zza) {
            zzz();
            this.zzy.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzy();

    public void zzz() {
    }
}
