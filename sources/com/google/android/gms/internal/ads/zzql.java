package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzql implements zzpn {
    public zzpl zzb;
    public zzpl zzc;
    public zzpl zzd;
    public zzpl zze;
    public ByteBuffer zzf;
    public ByteBuffer zzg;
    public boolean zzh;

    public zzql() {
        ByteBuffer byteBuffer = zzpn.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzpl zzpl = zzpl.zza;
        this.zzd = zzpl;
        this.zze = zzpl;
        this.zzb = zzpl;
        this.zzc = zzpl;
    }

    public final zzpl zza(zzpl zzpl) throws zzpm {
        this.zzd = zzpl;
        this.zze = zzk(zzpl);
        return zzb() ? this.zze : zzpl.zza;
    }

    public boolean zzb() {
        return this.zze != zzpl.zza;
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    @CallSuper
    public ByteBuffer zze() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzpn.zza;
        return byteBuffer;
    }

    @CallSuper
    public boolean zzf() {
        return this.zzh && this.zzg == zzpn.zza;
    }

    public final void zzg() {
        this.zzg = zzpn.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzm();
    }

    public final void zzh() {
        zzg();
        this.zzf = zzpn.zza;
        zzpl zzpl = zzpl.zza;
        this.zzd = zzpl;
        this.zze = zzpl;
        this.zzb = zzpl;
        this.zzc = zzpl;
        zzn();
    }

    public final ByteBuffer zzi(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    public final boolean zzj() {
        return this.zzg.hasRemaining();
    }

    public zzpl zzk(zzpl zzpl) throws zzpm {
        throw null;
    }

    public void zzl() {
    }

    public void zzm() {
    }

    public void zzn() {
    }
}
