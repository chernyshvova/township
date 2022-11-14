package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcgh implements zzaws {
    @VisibleForTesting
    public final zzcge zza;
    @VisibleForTesting
    public final HashSet<zzcfy> zzb = new HashSet<>();
    @VisibleForTesting
    public final HashSet<zzcgg> zzc = new HashSet<>();
    public final Object zzd = new Object();
    public final zzg zze;
    public final zzcgf zzf;
    public boolean zzg = false;

    public zzcgh(String str, zzg zzg2) {
        this.zza = new zzcge(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcgf();
    }

    public final void zza(boolean z) {
        long currentTimeMillis = zzs.zzj().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zze.zzr() > ((Long) zzbex.zzc().zzb(zzbjn.zzaE)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzt();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzq(currentTimeMillis);
        this.zze.zzs(this.zza.zzd);
    }

    public final void zzb(zzcfy zzcfy) {
        synchronized (this.zzd) {
            this.zzb.add(zzcfy);
        }
    }

    public final void zzc(HashSet<zzcfy> hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final void zzd() {
        synchronized (this.zzd) {
            this.zza.zza();
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zzf(zzbdk zzbdk, long j) {
        synchronized (this.zzd) {
            this.zza.zzc(zzbdk, j);
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final zzcfy zzi(Clock clock, String str) {
        return new zzcfy(clock, this, this.zzf.zza(), str);
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final Bundle zzk(Context context, zzezw zzezw) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zzf(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator<zzcgg> it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzcfy) it2.next()).zzi());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzezw.zzb(hashSet);
            return bundle;
        }
        zzcgg next = it.next();
        throw null;
    }
}
