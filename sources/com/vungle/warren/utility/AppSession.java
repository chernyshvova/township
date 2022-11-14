package com.vungle.warren.utility;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.vungle.warren.SessionData;
import com.vungle.warren.utility.ActivityManager;

public class AppSession {
    @VisibleForTesting
    public ActivityManager.LifeCycleCallback appLifeCycleCallback = new ActivityManager.LifeCycleCallback() {
        public long timestamp;

        public void onStart() {
            if (this.timestamp > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                if (AppSession.this.sessionData != null && AppSession.this.sessionData.getTimeout() > -1 && currentTimeMillis >= AppSession.this.sessionData.getTimeout() * 1000 && AppSession.this.sessionCallback != null) {
                    AppSession.this.sessionCallback.onSessionTimeout();
                }
            }
        }

        public void onStop() {
            this.timestamp = System.currentTimeMillis();
        }
    };
    @Nullable
    public SessionCallback sessionCallback;
    @Nullable
    public SessionData sessionData;

    public interface SessionCallback {
        void onSessionTimeout();
    }

    public void observe() {
        ActivityManager.getInstance().addListener(this.appLifeCycleCallback);
    }

    public AppSession setSessionCallback(@Nullable SessionCallback sessionCallback2) {
        this.sessionCallback = sessionCallback2;
        return this;
    }

    public AppSession setSessionData(@Nullable SessionData sessionData2) {
        this.sessionData = sessionData2;
        return this;
    }
}
