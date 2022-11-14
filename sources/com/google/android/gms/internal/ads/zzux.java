package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzux extends zzto {
    public final long zza;

    public zzux(zztb zztb, long j) {
        super(zztb);
        zzajg.zza(zztb.zzn() >= j);
        this.zza = j;
    }

    public final long zzm() {
        return super.zzm() - this.zza;
    }

    public final long zzn() {
        return super.zzn() - this.zza;
    }

    public final long zzo() {
        return super.zzo() - this.zza;
    }
}
