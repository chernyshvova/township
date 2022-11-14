package com.vungle.warren;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.vungle.warren.tasks.CacheBustJob;
import com.vungle.warren.tasks.CleanupJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.ActivityManager;

public class CacheBustManager implements CacheBustCallback {
    public static final String CACHE_BUST_INTERVAL = "cache_bust_interval";
    public static final int DEFAULT_REFRESH_RATE = 0;
    @VisibleForTesting
    public static final long MINIMUM_REFRESH_RATE = 900000;
    public static final String NEXT_CACHE_BUST = "next_cache_bust";
    public static final int NO_VALUE = Integer.MIN_VALUE;
    public boolean hasStopped;
    public JobRunner jobRunner;
    public long overrideRefreshRate = -2147483648L;
    @VisibleForTesting
    public long refreshRate = 0;

    public CacheBustManager(@NonNull JobRunner jobRunner2) {
        Class<CacheBustManager> cls = CacheBustManager.class;
        this.jobRunner = jobRunner2;
        if (ActivityManager.getInstance().isInitialized()) {
            setLifecycleListener();
            return;
        }
        Log.e(cls.getSimpleName(), "No lifecycle listener set");
        VungleLogger.error(cls.getSimpleName() + "#deliverError", "No lifecycle listener set");
    }

    private void setLifecycleListener() {
        ActivityManager.getInstance().addListener(new ActivityManager.LifeCycleCallback() {
            public void onStart() {
                super.onStart();
                if (CacheBustManager.this.hasStopped) {
                    CacheBustManager cacheBustManager = CacheBustManager.this;
                    if (cacheBustManager.refreshRate != 0) {
                        boolean unused = cacheBustManager.hasStopped = false;
                        Bundle bundle = new Bundle();
                        bundle.putLong(CacheBustManager.CACHE_BUST_INTERVAL, CacheBustManager.this.refreshRate);
                        bundle.putLong(CacheBustManager.NEXT_CACHE_BUST, SystemClock.elapsedRealtime() + CacheBustManager.this.refreshRate);
                        CacheBustManager.this.jobRunner.execute(CacheBustJob.makeJobInfo().setDelay(CacheBustManager.this.refreshRate).setReschedulePolicy(CacheBustManager.this.refreshRate, 0).setExtras(bundle));
                    }
                }
            }

            public void onStop() {
                super.onStop();
                CacheBustManager.this.jobRunner.cancelPendingJob(CacheBustJob.TAG);
                boolean unused = CacheBustManager.this.hasStopped = true;
            }
        });
    }

    public void onCacheBust() {
        this.jobRunner.execute(CleanupJob.makeJobInfo());
    }

    @VisibleForTesting
    public void overrideRefreshRate(long j) {
        this.overrideRefreshRate = j;
        this.refreshRate = j;
    }

    public void setRefreshRate(long j) {
        long j2 = this.overrideRefreshRate;
        if (j2 != -2147483648L) {
            this.refreshRate = j2;
            return;
        }
        long j3 = 0;
        if (j > 0) {
            j3 = Math.max(j, 900000);
        }
        this.refreshRate = j3;
    }

    public void startBust() {
        if (this.refreshRate == 0) {
            this.jobRunner.execute(CacheBustJob.makeJobInfo());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(CACHE_BUST_INTERVAL, this.refreshRate);
        bundle.putLong(NEXT_CACHE_BUST, SystemClock.elapsedRealtime() + this.refreshRate);
        this.jobRunner.execute(CacheBustJob.makeJobInfo().setReschedulePolicy(this.refreshRate, 0).setExtras(bundle));
    }
}
