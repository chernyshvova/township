package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfy {
    public final Clock zza;
    public final zzcgh zzb;
    @GuardedBy("lock")
    public final LinkedList<zzcfx> zzc;
    public final Object zzd = new Object();
    public final String zze;
    public final String zzf;
    @GuardedBy("lock")
    public long zzg = -1;
    @GuardedBy("lock")
    public long zzh = -1;
    @GuardedBy("lock")
    public long zzi = 0;
    @GuardedBy("lock")
    public long zzj = -1;
    @GuardedBy("lock")
    public long zzk = -1;

    public zzcfy(Clock clock, zzcgh zzcgh, String str, String str2) {
        this.zza = clock;
        this.zzb = zzcgh;
        this.zze = str;
        this.zzf = str2;
        this.zzc = new LinkedList<>();
    }

    public final void zza(zzbdk zzbdk) {
        synchronized (this.zzd) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            this.zzj = elapsedRealtime;
            this.zzb.zzf(zzbdk, elapsedRealtime);
        }
    }

    public final void zzb() {
        synchronized (this.zzd) {
            this.zzb.zzg();
        }
    }

    public final void zzc() {
        synchronized (this.zzd) {
            this.zzb.zzh();
        }
    }

    public final void zzd(long j) {
        synchronized (this.zzd) {
            this.zzk = j;
            if (j != -1) {
                this.zzb.zzb(this);
            }
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && this.zzg == -1) {
                this.zzg = this.zza.elapsedRealtime();
                this.zzb.zzb(this);
            }
            this.zzb.zze();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                zzcfx zzcfx = new zzcfx(this);
                zzcfx.zzc();
                this.zzc.add(zzcfx);
                this.zzi++;
                this.zzb.zzd();
                this.zzb.zzb(this);
            }
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && !this.zzc.isEmpty()) {
                zzcfx last = this.zzc.getLast();
                if (last.zza() == -1) {
                    last.zzb();
                    this.zzb.zzb(this);
                }
            }
        }
    }

    public final void zzh(boolean z) {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                this.zzh = this.zza.elapsedRealtime();
            }
        }
    }

    public final Bundle zzi() {
        Bundle bundle;
        synchronized (this.zzd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zze);
            bundle.putString("slotid", this.zzf);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzj);
            bundle.putLong("tresponse", this.zzk);
            bundle.putLong("timp", this.zzg);
            bundle.putLong("tload", this.zzh);
            bundle.putLong("pcc", this.zzi);
            bundle.putLong("tfetch", -1);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzcfx) it.next()).zzd());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzj() {
        return this.zze;
    }
}
