package com.microsoft.appcenter.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ApplicationLifecycleListener implements Application.ActivityLifecycleCallbacks {
    public Runnable mDelayedPauseRunnable = new Runnable() {
        public void run() {
            ApplicationLifecycleListener applicationLifecycleListener = ApplicationLifecycleListener.this;
            if (applicationLifecycleListener.mResumedCounter == 0) {
                applicationLifecycleListener.mPauseSent = true;
            }
            ApplicationLifecycleListener.this.dispatchStopIfNeeded();
        }
    };
    public Handler mHandler;
    public final Set<ApplicationLifecycleCallbacks> mLifecycleCallbacks = new CopyOnWriteArraySet();
    public boolean mPauseSent = true;
    public int mResumedCounter = 0;
    public int mStartedCounter = 0;
    public boolean mStopSent = true;

    public interface ApplicationLifecycleCallbacks {
        void onApplicationEnterBackground();

        void onApplicationEnterForeground();
    }

    public ApplicationLifecycleListener(Handler handler) {
        this.mHandler = handler;
    }

    public final void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            for (ApplicationLifecycleCallbacks onApplicationEnterBackground : this.mLifecycleCallbacks) {
                onApplicationEnterBackground.onApplicationEnterBackground();
            }
            this.mStopSent = true;
        }
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
        if (this.mStartedCounter == 0) {
            this.mStopSent = false;
        }
        if (this.mResumedCounter == 0) {
            this.mPauseSent = false;
        }
        int max = Math.max(this.mResumedCounter - 1, 0);
        this.mResumedCounter = max;
        if (max == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700);
        }
    }

    public void onActivityResumed(@NonNull Activity activity) {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mPauseSent = false;
        } else {
            this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
        }
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            for (ApplicationLifecycleCallbacks onApplicationEnterForeground : this.mLifecycleCallbacks) {
                onApplicationEnterForeground.onApplicationEnterForeground();
            }
            this.mStopSent = false;
        }
    }

    public void onActivityStopped(@NonNull Activity activity) {
        this.mStartedCounter = Math.max(this.mStartedCounter - 1, 0);
        dispatchStopIfNeeded();
    }
}
