package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaee {
    public final int zza;
    @Nullable
    public final zzadv zzb;
    public final CopyOnWriteArrayList<zzaed> zzc;

    public zzaee() {
        this(new CopyOnWriteArrayList(), 0, (zzadv) null, 0);
    }

    public zzaee(CopyOnWriteArrayList<zzaed> copyOnWriteArrayList, int i, @Nullable zzadv zzadv, long j) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i;
        this.zzb = zzadv;
    }

    public static final long zzn(long j) {
        long zza2 = zzig.zza(j);
        if (zza2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zza2;
    }

    @CheckResult
    public final zzaee zza(int i, @Nullable zzadv zzadv, long j) {
        return new zzaee(this.zzc, i, zzadv, 0);
    }

    public final void zzb(Handler handler, zzaef zzaef) {
        this.zzc.add(new zzaed(handler, zzaef));
    }

    public final void zzc(zzaef zzaef) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            if (next.zzb == zzaef) {
                this.zzc.remove(next);
            }
        }
    }

    public final void zzd(zzadm zzadm, int i, int i2, @Nullable zzkc zzkc, int i3, @Nullable Object obj, long j, long j2) {
        zzadm zzadm2 = zzadm;
        zze(zzadm, new zzadr(1, -1, (zzkc) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zze(zzadm zzadm, zzadr zzadr) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            zzalh.zzj(next.zza, new zzady(this, next.zzb, zzadm, zzadr));
        }
    }

    public final void zzf(zzadm zzadm, int i, int i2, @Nullable zzkc zzkc, int i3, @Nullable Object obj, long j, long j2) {
        zzadm zzadm2 = zzadm;
        zzg(zzadm, new zzadr(1, -1, (zzkc) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zzg(zzadm zzadm, zzadr zzadr) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            zzalh.zzj(next.zza, new zzadz(this, next.zzb, zzadm, zzadr));
        }
    }

    public final void zzh(zzadm zzadm, int i, int i2, @Nullable zzkc zzkc, int i3, @Nullable Object obj, long j, long j2) {
        zzadm zzadm2 = zzadm;
        zzi(zzadm, new zzadr(1, -1, (zzkc) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zzi(zzadm zzadm, zzadr zzadr) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            zzalh.zzj(next.zza, new zzaea(this, next.zzb, zzadm, zzadr));
        }
    }

    public final void zzj(zzadm zzadm, int i, int i2, @Nullable zzkc zzkc, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
        zzadm zzadm2 = zzadm;
        zzk(zzadm, new zzadr(1, -1, (zzkc) null, 0, (Object) null, zzn(j), zzn(j2)), iOException, z);
    }

    public final void zzk(zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            zzalh.zzj(next.zza, new zzaeb(this, next.zzb, zzadm, zzadr, iOException, z));
        }
    }

    public final void zzl(int i, @Nullable zzkc zzkc, int i2, @Nullable Object obj, long j) {
        zzm(new zzadr(1, i, zzkc, 0, (Object) null, zzn(j), -9223372036854775807L));
    }

    public final void zzm(zzadr zzadr) {
        Iterator<zzaed> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzaed next = it.next();
            zzalh.zzj(next.zza, new zzaec(this, next.zzb, zzadr));
        }
    }
}
