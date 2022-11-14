package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final BackgroundDetector zza = new BackgroundDetector();
    public final AtomicBoolean zzb = new AtomicBoolean();
    public final AtomicBoolean zzc = new AtomicBoolean();
    @GuardedBy("sInstance")
    public final ArrayList<BackgroundStateChangeListener> zzd = new ArrayList<>();
    @GuardedBy("sInstance")
    public boolean zze = false;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zza;
    }

    @KeepForSdk
    public static void initialize(@RecentlyNonNull Application application) {
        synchronized (zza) {
            if (!zza.zze) {
                application.registerActivityLifecycleCallbacks(zza);
                application.registerComponentCallbacks(zza);
                zza.zze = true;
            }
        }
    }

    private final void zza(boolean z) {
        synchronized (zza) {
            Iterator<BackgroundStateChangeListener> it = this.zzd.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundStateChanged(z);
            }
        }
    }

    @KeepForSdk
    public void addListener(@RecentlyNonNull BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (zza) {
            this.zzd.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean isInBackground() {
        return this.zzb.get();
    }

    public final void onActivityCreated(@RecentlyNonNull Activity activity, @Nullable Bundle bundle) {
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        this.zzc.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    public final void onActivityDestroyed(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityPaused(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityResumed(@RecentlyNonNull Activity activity) {
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        this.zzc.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    public final void onActivitySaveInstanceState(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle) {
    }

    public final void onActivityStarted(@RecentlyNonNull Activity activity) {
    }

    public final void onActivityStopped(@RecentlyNonNull Activity activity) {
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzb.compareAndSet(false, true)) {
            this.zzc.set(true);
            zza(true);
        }
    }

    @TargetApi(16)
    @KeepForSdk
    public boolean readCurrentStateIfPossible(boolean z) {
        if (!this.zzc.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzb.set(true);
            }
        }
        return isInBackground();
    }
}
