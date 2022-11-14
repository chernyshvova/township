package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajj {
    public final zzajh zza;
    public boolean zzb;

    public zzajj() {
        throw null;
    }

    public zzajj(zzajh zzajh) {
        this.zza = zzajh;
    }

    public final synchronized boolean zza() {
        if (this.zzb) {
            return false;
        }
        this.zzb = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzb() {
        boolean z;
        z = this.zzb;
        this.zzb = false;
        return z;
    }

    public final synchronized void zzc() throws InterruptedException {
        while (!this.zzb) {
            wait();
        }
    }

    public final synchronized void zzd() {
        boolean z = false;
        while (!this.zzb) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean zze() {
        return this.zzb;
    }
}
