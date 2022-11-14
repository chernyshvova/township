package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzg {
    public static final AtomicReference<zzg> zza = new AtomicReference<>();
    public final Application zzb;
    public final Application.ActivityLifecycleCallbacks zzc = new zzf(this, (zze) null);
    public final Object zzd = new Object();
    @GuardedBy("lock")
    public final Set<zzd> zze = Collections.newSetFromMap(new WeakHashMap());
    @GuardedBy("lock")
    @Nullable
    public WeakReference<Activity> zzf;
    @GuardedBy("lock")
    public boolean zzg = false;

    @VisibleForTesting(otherwise = 2)
    public zzg(Application application) {
        this.zzb = application;
    }

    public static zzg zzb(Application application) {
        Preconditions.checkNotNull(application);
        zzg zzg2 = zza.get();
        if (zzg2 != null) {
            return zzg2;
        }
        zza.compareAndSet((Object) null, new zzg(application));
        return zza.get();
    }

    public static zzg zzc(Context context) {
        return zzb((Application) context.getApplicationContext());
    }

    public static /* bridge */ /* synthetic */ void zzd(zzg zzg2, Activity activity) {
        Preconditions.checkNotNull(activity);
        synchronized (zzg2.zzd) {
            if (zzg2.zza() != activity) {
                zzg2.zzf = new WeakReference<>(activity);
                for (zzd zza2 : zzg2.zze) {
                    zza2.zza(activity);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void zze(com.google.android.gms.games.internal.zzg r2, android.app.Activity r3) {
        /*
            java.lang.Object r0 = r2.zzd
            monitor-enter(r0)
            java.lang.ref.WeakReference<android.app.Activity> r1 = r2.zzf     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0009:
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0014 }
            if (r1 != r3) goto L_0x0012
            r3 = 0
            r2.zzf = r3     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzg.zze(com.google.android.gms.games.internal.zzg, android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    @MainThread
    /* renamed from: zzi */
    public final void zzg(zzd zzd2) {
        Activity zza2 = zza();
        if (zza2 != null) {
            zzd2.zza(zza2);
        }
    }

    @Nullable
    public final Activity zza() {
        Activity activity;
        synchronized (this.zzd) {
            WeakReference<Activity> weakReference = this.zzf;
            if (weakReference == null) {
                activity = null;
            } else {
                activity = (Activity) weakReference.get();
            }
        }
        return activity;
    }

    public final void zzf(zzd zzd2) {
        Preconditions.checkNotNull(zzd2);
        synchronized (this.zzd) {
            this.zze.add(zzd2);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzg(zzd2);
        } else {
            TaskExecutors.MAIN_THREAD.execute(new zzc(this, zzd2));
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            if (!this.zzg) {
                this.zzb.registerActivityLifecycleCallbacks(this.zzc);
                this.zzg = true;
            }
        }
    }
}
