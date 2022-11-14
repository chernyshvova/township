package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawr implements Application.ActivityLifecycleCallbacks {
    @Nullable
    public Activity zza;
    public Context zzb;
    public final Object zzc = new Object();
    public boolean zzd = true;
    public boolean zze = false;
    @GuardedBy("lock")
    public final List<zzaws> zzf = new ArrayList();
    @GuardedBy("lock")
    public final List<zzaxg> zzg = new ArrayList();
    public Runnable zzh;
    public boolean zzi = false;
    public long zzj;

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator<zzaxg> it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza()) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzcgs.zzg("", e);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzaxg zzb2 : this.zzg) {
                try {
                    zzb2.zzb();
                } catch (Exception e) {
                    zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzcgs.zzg("", e);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzr.zza.removeCallbacks(runnable);
        }
        zzfjj zzfjj = zzr.zza;
        zzawq zzawq = new zzawq(this);
        this.zzh = zzawq;
        zzfjj.postDelayed(zzawq, this.zzj);
    }

    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            zzr.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            for (zzaxg zzc2 : this.zzg) {
                try {
                    zzc2.zzc();
                } catch (Exception e) {
                    zzs.zzg().zzg(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzcgs.zzg("", e);
                }
            }
            if (z) {
                for (zzaws zza2 : this.zzf) {
                    try {
                        zza2.zza(true);
                    } catch (Exception e2) {
                        zzcgs.zzg("", e2);
                    }
                }
            } else {
                zzcgs.zzd("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) zzbex.zzc().zzb(zzbjn.zzaD)).longValue();
            this.zzi = true;
        }
    }

    public final void zzb(zzaws zzaws) {
        synchronized (this.zzc) {
            this.zzf.add(zzaws);
        }
    }

    public final void zzc(zzaws zzaws) {
        synchronized (this.zzc) {
            this.zzf.remove(zzaws);
        }
    }

    @Nullable
    public final Activity zzd() {
        return this.zza;
    }

    @Nullable
    public final Context zze() {
        return this.zzb;
    }
}
