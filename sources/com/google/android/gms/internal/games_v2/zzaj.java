package com.google.android.gms.internal.games_v2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class zzaj {
    public final Handler zza;
    public final Object zzb = new Object();
    public boolean zzc;
    public final HashMap<String, AtomicInteger> zzd;

    public zzaj(Looper looper, int i) {
        this.zza = new zzfn(looper);
        this.zzd = new HashMap<>();
    }

    public static /* bridge */ /* synthetic */ void zzb(zzaj zzaj) {
        synchronized (zzaj.zzb) {
            zzaj.zzc = false;
            zzaj.zzd();
        }
    }

    public abstract void zza(String str, int i);

    public final void zzc(String str, int i) {
        synchronized (this.zzb) {
            if (!this.zzc) {
                this.zzc = true;
                this.zza.postDelayed(new zzai(this), 1000);
            }
            AtomicInteger atomicInteger = this.zzd.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzd.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    public final void zzd() {
        synchronized (this.zzb) {
            for (Map.Entry next : this.zzd.entrySet()) {
                zza((String) next.getKey(), ((AtomicInteger) next.getValue()).get());
            }
            this.zzd.clear();
        }
    }
}
