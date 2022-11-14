package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzadf<T> extends zzacx {
    public final HashMap<T, zzade<T>> zza = new HashMap<>();
    @Nullable
    public Handler zzb;
    @Nullable
    public zzajd zzc;

    @CallSuper
    public final void zzF() {
        for (zzade next : this.zza.values()) {
            next.zza.zzp(next.zzb);
        }
    }

    @CallSuper
    public void zza(@Nullable zzajd zzajd) {
        this.zzc = zzajd;
        this.zzb = zzalh.zzh((Handler.Callback) null);
    }

    @CallSuper
    public final void zzc() {
        for (zzade next : this.zza.values()) {
            next.zza.zzq(next.zzb);
        }
    }

    @CallSuper
    public void zzd() {
        for (zzade next : this.zza.values()) {
            next.zza.zzr(next.zzb);
            next.zza.zzl(next.zzc);
            next.zza.zzn(next.zzc);
        }
        this.zza.clear();
    }

    @CallSuper
    public void zzu() throws IOException {
        for (zzade<T> zzade : this.zza.values()) {
            zzade.zza.zzu();
        }
    }

    public abstract void zzv(T t, zzadx zzadx, zzmv zzmv);

    public final void zzw(T t, zzadx zzadx) {
        zzajg.zza(!this.zza.containsKey(t));
        zzadc zzadc = new zzadc(this, t);
        zzadd zzadd = new zzadd(this, t);
        this.zza.put(t, new zzade(zzadx, zzadc, zzadd));
        Handler handler = this.zzb;
        if (handler != null) {
            zzadx.zzk(handler, zzadd);
            Handler handler2 = this.zzb;
            if (handler2 != null) {
                zzadx.zzm(handler2, zzadd);
                zzadx.zzo(zzadc, this.zzc);
                if (!zzj()) {
                    zzadx.zzq(zzadc);
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    @Nullable
    public zzadv zzx(T t, zzadv zzadv) {
        throw null;
    }
}
