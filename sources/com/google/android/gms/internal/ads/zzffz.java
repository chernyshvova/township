package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffz implements zzffe {
    public static final zzffz zza = new zzffz();
    public static final Handler zzb = new Handler(Looper.getMainLooper());
    public static Handler zzc = null;
    public static final Runnable zzj = new zzffv();
    public static final Runnable zzk = new zzffw();
    public final List<zzffy> zzd = new ArrayList();
    public int zze;
    public final zzffg zzf = new zzffg();
    public final zzffs zzg = new zzffs();
    public final zzfft zzh = new zzfft(new zzfgc());
    public long zzi;

    public static zzffz zzb() {
        return zza;
    }

    public static /* synthetic */ void zzg(zzffz zzffz) {
        zzffz.zze = 0;
        zzffz.zzi = System.nanoTime();
        zzffz.zzg.zzd();
        long nanoTime = System.nanoTime();
        zzfff zza2 = zzffz.zzf.zza();
        if (zzffz.zzg.zzb().size() > 0) {
            Iterator<String> it = zzffz.zzg.zzb().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject zzb2 = zzffn.zzb(0, 0, 0, 0);
                View zzh2 = zzffz.zzg.zzh(next);
                zzfff zzb3 = zzffz.zzf.zzb();
                String zzc2 = zzffz.zzg.zzc(next);
                if (zzc2 != null) {
                    JSONObject zza3 = zzb3.zza(zzh2);
                    zzffn.zzd(zza3, next);
                    zzffn.zze(zza3, zzc2);
                    zzffn.zzg(zzb2, zza3);
                }
                zzffn.zzh(zzb2);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                zzffz.zzh.zzb(zzb2, hashSet, nanoTime);
            }
        }
        if (zzffz.zzg.zza().size() > 0) {
            JSONObject zzb4 = zzffn.zzb(0, 0, 0, 0);
            zzffz.zzk((View) null, zza2, zzb4, 1);
            zzffn.zzh(zzb4);
            zzffz.zzh.zza(zzb4, zzffz.zzg.zza(), nanoTime);
        } else {
            zzffz.zzh.zzc();
        }
        zzffz.zzg.zze();
        long nanoTime2 = System.nanoTime() - zzffz.zzi;
        if (zzffz.zzd.size() > 0) {
            for (zzffy next2 : zzffz.zzd) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                next2.zzb();
                if (next2 instanceof zzffx) {
                    ((zzffx) next2).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfff zzfff, JSONObject jSONObject, int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        zzfff.zzb(view, jSONObject, this, z);
    }

    public static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zzk);
            zzc = null;
        }
    }

    public final void zza(View view, zzfff zzfff, JSONObject jSONObject) {
        int zzj2;
        if (zzffq.zzb(view) == null && (zzj2 = this.zzg.zzj(view)) != 3) {
            JSONObject zza2 = zzfff.zza(view);
            zzffn.zzg(jSONObject, zza2);
            String zzg2 = this.zzg.zzg(view);
            if (zzg2 != null) {
                zzffn.zzd(zza2, zzg2);
                this.zzg.zzf();
            } else {
                zzffr zzi2 = this.zzg.zzi(view);
                if (zzi2 != null) {
                    zzffn.zzf(zza2, zzi2);
                }
                zzk(view, zzfff, zza2, zzj2);
            }
            this.zze++;
        }
    }

    public final void zzc() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzj);
            zzc.postDelayed(zzk, 200);
        }
    }

    public final void zzd() {
        zzl();
        this.zzd.clear();
        zzb.post(new zzffu(this));
    }

    public final void zze() {
        zzl();
    }
}
