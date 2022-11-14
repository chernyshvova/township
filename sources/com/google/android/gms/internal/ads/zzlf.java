package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlf {
    public final List<zzld> zza = new ArrayList();
    public final IdentityHashMap<zzadt, zzld> zzb = new IdentityHashMap<>();
    public final Map<Object, zzld> zzc = new HashMap();
    public final zzle zzd;
    public final zzaee zze = new zzaee();
    public final zzsd zzf = new zzsd();
    public final HashMap<zzld, zzlc> zzg = new HashMap<>();
    public final Set<zzld> zzh = new HashSet();
    public boolean zzi;
    @Nullable
    public zzajd zzj;
    public zzafm zzk = new zzafm(0);

    public zzlf(zzle zzle, @Nullable zzou zzou, Handler handler) {
        this.zzd = zzle;
        if (zzou != null) {
            this.zze.zzb(handler, zzou);
            this.zzf.zzb(handler, zzou);
        }
    }

    private final void zzp() {
        Iterator<zzld> it = this.zzh.iterator();
        while (it.hasNext()) {
            zzld next = it.next();
            if (next.zzc.isEmpty()) {
                zzq(next);
                it.remove();
            }
        }
    }

    private final void zzq(zzld zzld) {
        zzlc zzlc = this.zzg.get(zzld);
        if (zzlc != null) {
            zzlc.zza.zzq(zzlc.zzb);
        }
    }

    private final void zzr(int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= i) {
                zzld remove = this.zza.remove(i2);
                this.zzc.remove(remove.zzb);
                zzs(i2, -remove.zza.zzy().zzr());
                remove.zze = true;
                if (this.zzi) {
                    zzu(remove);
                }
            } else {
                return;
            }
        }
    }

    private final void zzs(int i, int i2) {
        while (i < this.zza.size()) {
            this.zza.get(i).zzd += i2;
            i++;
        }
    }

    private final void zzt(zzld zzld) {
        zzadq zzadq = zzld.zza;
        zzla zzla = new zzla(this);
        zzlb zzlb = new zzlb(this, zzld);
        this.zzg.put(zzld, new zzlc(zzadq, zzla, zzlb));
        zzadq.zzk(new Handler(zzalh.zzk(), (Handler.Callback) null), zzlb);
        zzadq.zzm(new Handler(zzalh.zzk(), (Handler.Callback) null), zzlb);
        zzadq.zzo(zzla, this.zzj);
    }

    private final void zzu(zzld zzld) {
        if (zzld.zze && zzld.zzc.isEmpty()) {
            zzlc remove = this.zzg.remove(zzld);
            if (remove != null) {
                remove.zza.zzr(remove.zzb);
                remove.zza.zzl(remove.zzc);
                remove.zza.zzn(remove.zzc);
                this.zzh.remove(zzld);
                return;
            }
            throw null;
        }
    }

    public final boolean zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final void zzc(@Nullable zzajd zzajd) {
        zzajg.zzd(!this.zzi);
        this.zzj = zzajd;
        for (int i = 0; i < this.zza.size(); i++) {
            zzld zzld = this.zza.get(i);
            zzt(zzld);
            this.zzh.add(zzld);
        }
        this.zzi = true;
    }

    public final void zzd(zzadt zzadt) {
        zzld remove = this.zzb.remove(zzadt);
        if (remove != null) {
            remove.zza.zzA(zzadt);
            remove.zzc.remove(((zzadn) zzadt).zza);
            if (!this.zzb.isEmpty()) {
                zzp();
            }
            zzu(remove);
            return;
        }
        throw null;
    }

    public final void zze() {
        for (zzlc next : this.zzg.values()) {
            try {
                next.zza.zzr(next.zzb);
            } catch (RuntimeException e) {
                zzaka.zzb("MediaSourceList", "Failed to release child source.", e);
            }
            next.zza.zzl(next.zzc);
            next.zza.zzn(next.zzc);
        }
        this.zzg.clear();
        this.zzh.clear();
        this.zzi = false;
    }

    public final zzmv zzf() {
        if (this.zza.isEmpty()) {
            return zzmv.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            zzld zzld = this.zza.get(i2);
            zzld.zzd = i;
            i += zzld.zza.zzy().zzr();
        }
        return new zzly(this.zza, this.zzk, (zzafm) null);
    }

    public final /* synthetic */ void zzg(zzadx zzadx, zzmv zzmv) {
        this.zzd.zzi();
    }

    public final zzmv zzj(List<zzld> list, zzafm zzafm) {
        zzr(0, this.zza.size());
        return zzk(this.zza.size(), list, zzafm);
    }

    public final zzmv zzk(int i, List<zzld> list, zzafm zzafm) {
        if (!list.isEmpty()) {
            this.zzk = zzafm;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzld zzld = list.get(i2 - i);
                if (i2 > 0) {
                    zzld zzld2 = this.zza.get(i2 - 1);
                    zzmv zzy = zzld2.zza.zzy();
                    zzld.zzc(zzy.zzr() + zzld2.zzd);
                } else {
                    zzld.zzc(0);
                }
                zzs(i2, zzld.zza.zzy().zzr());
                this.zza.add(i2, zzld);
                this.zzc.put(zzld.zzb, zzld);
                if (this.zzi) {
                    zzt(zzld);
                    if (this.zzb.isEmpty()) {
                        this.zzh.add(zzld);
                    } else {
                        zzq(zzld);
                    }
                }
            }
        }
        return zzf();
    }

    public final zzmv zzl(int i, int i2, zzafm zzafm) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zzb()) {
            z = true;
        }
        zzajg.zza(z);
        this.zzk = zzafm;
        zzr(i, i2);
        return zzf();
    }

    public final zzmv zzm(int i, int i2, int i3, zzafm zzafm) {
        zzajg.zza(zzb() >= 0);
        this.zzk = null;
        return zzf();
    }

    public final zzmv zzn(zzafm zzafm) {
        int zzb2 = zzb();
        if (zzafm.zza() != zzb2) {
            zzafm = zzafm.zzh().zzf(0, zzb2);
        }
        this.zzk = zzafm;
        return zzf();
    }

    public final zzadt zzo(zzadv zzadv, zzahy zzahy, long j) {
        Object obj = zzadv.zza;
        Object obj2 = ((Pair) obj).first;
        zzadv zzc2 = zzadv.zzc(((Pair) obj).second);
        zzld zzld = this.zzc.get(obj2);
        if (zzld != null) {
            this.zzh.add(zzld);
            zzlc zzlc = this.zzg.get(zzld);
            if (zzlc != null) {
                zzlc.zza.zzp(zzlc.zzb);
            }
            zzld.zzc.add(zzc2);
            zzadn zzB = zzld.zza.zzC(zzc2, zzahy, j);
            this.zzb.put(zzB, zzld);
            zzp();
            return zzB;
        }
        throw null;
    }
}
