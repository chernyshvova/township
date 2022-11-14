package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzacx implements zzadx {
    public final ArrayList<zzadw> zza = new ArrayList<>(1);
    public final HashSet<zzadw> zzb = new HashSet<>(1);
    public final zzaee zzc = new zzaee();
    public final zzsd zzd = new zzsd();
    @Nullable
    public Looper zze;
    @Nullable
    public zzmv zzf;

    public void zzF() {
    }

    public abstract void zza(@Nullable zzajd zzajd);

    public void zzc() {
    }

    public abstract void zzd();

    public final void zze(zzmv zzmv) {
        this.zzf = zzmv;
        ArrayList<zzadw> arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).zza(this, zzmv);
        }
    }

    public final zzaee zzf(@Nullable zzadv zzadv) {
        return this.zzc.zza(0, zzadv, 0);
    }

    public final zzaee zzg(int i, @Nullable zzadv zzadv, long j) {
        return this.zzc.zza(i, zzadv, 0);
    }

    public final zzsd zzh(@Nullable zzadv zzadv) {
        return this.zzd.zza(0, zzadv);
    }

    public final zzsd zzi(int i, @Nullable zzadv zzadv) {
        return this.zzd.zza(i, zzadv);
    }

    public final boolean zzj() {
        return !this.zzb.isEmpty();
    }

    public final void zzk(Handler handler, zzaef zzaef) {
        if (handler == null) {
            throw null;
        } else if (zzaef != null) {
            this.zzc.zzb(handler, zzaef);
        } else {
            throw null;
        }
    }

    public final void zzl(zzaef zzaef) {
        this.zzc.zzc(zzaef);
    }

    public final void zzm(Handler handler, zzse zzse) {
        if (zzse != null) {
            this.zzd.zzb(handler, zzse);
            return;
        }
        throw null;
    }

    public final void zzn(zzse zzse) {
        this.zzd.zzc(zzse);
    }

    public final void zzo(zzadw zzadw, @Nullable zzajd zzajd) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzajg.zza(z);
        zzmv zzmv = this.zzf;
        this.zza.add(zzadw);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzadw);
            zza(zzajd);
        } else if (zzmv != null) {
            zzp(zzadw);
            zzadw.zza(this, zzmv);
        }
    }

    public final void zzp(zzadw zzadw) {
        if (this.zze != null) {
            boolean isEmpty = this.zzb.isEmpty();
            this.zzb.add(zzadw);
            if (isEmpty) {
                zzF();
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzq(zzadw zzadw) {
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.remove(zzadw);
        if ((!isEmpty) && this.zzb.isEmpty()) {
            zzc();
        }
    }

    public final void zzr(zzadw zzadw) {
        this.zza.remove(zzadw);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzb.clear();
            zzd();
            return;
        }
        zzq(zzadw);
    }

    public final zzmv zzs() {
        return null;
    }

    public final boolean zzt() {
        return true;
    }
}
