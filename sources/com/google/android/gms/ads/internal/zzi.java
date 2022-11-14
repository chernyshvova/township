package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzeu;
import com.google.android.gms.internal.ads.zzex;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzfht;
import com.google.android.gms.internal.ads.zzfin;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzi implements Runnable, zzex {
    public final CountDownLatch zza = new CountDownLatch(1);
    public final List<Object[]> zzb = new Vector();
    public final AtomicReference<zzex> zzc = new AtomicReference<>();
    public final AtomicReference<zzex> zzd = new AtomicReference<>();
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final Executor zzh;
    public final zzfgn zzi;
    public Context zzj;
    public final Context zzk;
    public zzcgy zzl;
    public final zzcgy zzm;
    public final boolean zzn;
    public int zzo;

    public zzi(Context context, zzcgy zzcgy) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzcgy;
        this.zzm = zzcgy;
        this.zzh = Executors.newCachedThreadPool();
        boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbv)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfgn.zzb(context, this.zzh, booleanValue);
        this.zzf = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbr)).booleanValue();
        this.zzg = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbw)).booleanValue();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbu)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        Context context2 = this.zzj;
        zzfgn zzfgn = this.zzi;
        zzh zzh2 = new zzh(this);
        this.zze = new zzfin(this.zzj, zzfht.zzb(context2, zzfgn), zzh2, ((Boolean) zzbex.zzc().zzb(zzbjn.zzbs)).booleanValue()).zzd(1);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbP)).booleanValue()) {
            zzche.zza.execute(this);
            return;
        }
        zzbev.zza();
        if (zzcgl.zzp()) {
            zzche.zza.execute(this);
        } else {
            run();
        }
    }

    private final void zzl() {
        zzex zzn2 = zzn();
        if (!this.zzb.isEmpty() && zzn2 != null) {
            for (Object[] next : this.zzb) {
                int length = next.length;
                if (length == 1) {
                    zzn2.zzd((MotionEvent) next[0]);
                } else if (length == 3) {
                    zzn2.zze(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzb.clear();
        }
    }

    private final void zzm(boolean z) {
        this.zzc.set(zzfa.zzs(this.zzl.zza, zzo(this.zzj), z, this.zzo));
    }

    @Nullable
    private final zzex zzn() {
        if (zzk() == 2) {
            return this.zzd.get();
        }
        return this.zzc.get();
    }

    public static final Context zzo(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            boolean z2 = this.zzl.zzd;
            z = false;
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzaH)).booleanValue() && z2) {
                z = true;
            }
            if (zzk() == 1) {
                zzm(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzg(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzeu zza2 = zzeu.zza(this.zzl.zza, zzo(this.zzj), z, this.zzn);
                this.zzd.set(zza2);
                if (this.zzg && !zza2.zzb()) {
                    this.zzo = 1;
                    zzm(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzm(z);
            this.zzi.zzd(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zza.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zza.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    public final boolean zza() {
        try {
            this.zza.await();
            return true;
        } catch (InterruptedException e) {
            zzcgs.zzj("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public final /* synthetic */ void zzb(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzeu.zza(this.zzm.zza, zzo(this.zzk), z, this.zzn).zzk();
        } catch (NullPointerException e) {
            this.zzi.zzd(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zzl();
            zzn2.zzd(motionEvent);
            return;
        }
        this.zzb.add(new Object[]{motionEvent});
    }

    public final void zze(int i, int i2, int i3) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zzl();
            zzn2.zze(i, i2, i3);
            return;
        }
        this.zzb.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zza()) {
            return "";
        }
        zzex zzn2 = zzn();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgF)).booleanValue()) {
            zzs.zzc();
            zzr.zzM(view, 4, (MotionEvent) null);
        }
        if (zzn2 == null) {
            return "";
        }
        zzl();
        return zzn2.zzf(zzo(context), str, view, activity);
    }

    public final String zzg(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final void zzh(View view) {
        zzex zzn2 = zzn();
        if (zzn2 != null) {
            zzn2.zzh(view);
        }
    }

    public final String zzi(Context context, View view, Activity activity) {
        zzex zzn2 = zzn();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgF)).booleanValue()) {
            zzs.zzc();
            zzr.zzM(view, 2, (MotionEvent) null);
        }
        return zzn2 != null ? zzn2.zzi(context, view, (Activity) null) : "";
    }

    public final String zzj(Context context) {
        zzex zzn2;
        if (!zza() || (zzn2 = zzn()) == null) {
            return "";
        }
        zzl();
        return zzn2.zzj(zzo(context));
    }

    public final int zzk() {
        if (!this.zzf || this.zze) {
            return this.zzo;
        }
        return 1;
    }
}
