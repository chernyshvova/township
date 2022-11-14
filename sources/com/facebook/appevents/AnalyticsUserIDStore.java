package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsUserIDStore.kt */
public final class AnalyticsUserIDStore {
    public static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    public static final AnalyticsUserIDStore INSTANCE = new AnalyticsUserIDStore();
    public static final String TAG;
    public static volatile boolean initialized;
    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static String userID;

    static {
        String simpleName = AnalyticsUserIDStore.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "AnalyticsUserIDStore::class.java.simpleName");
        TAG = simpleName;
    }

    public static final String getUserID() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        lock.readLock().lock();
        try {
            return userID;
        } finally {
            lock.readLock().unlock();
        }
    }

    private final void initAndWait() {
        if (!initialized) {
            lock.writeLock().lock();
            try {
                if (!initialized) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, (String) null);
                    initialized = true;
                    lock.writeLock().unlock();
                }
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static final void initStore() {
        if (!initialized) {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute($$Lambda$tbenDbD_e_3vWhw1CCsMI8yNRVU.INSTANCE);
        }
    }

    /* renamed from: initStore$lambda-0  reason: not valid java name */
    public static final void m3545initStore$lambda0() {
        INSTANCE.initAndWait();
    }

    public static final void setUserID(String str) {
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new Runnable(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                AnalyticsUserIDStore.m3546setUserID$lambda1(this.f$0);
            }
        });
    }

    /* renamed from: setUserID$lambda-1  reason: not valid java name */
    public static final void m3546setUserID$lambda1(String str) {
        lock.writeLock().lock();
        try {
            userID = str;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.putString(ANALYTICS_USER_ID_KEY, userID);
            edit.apply();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
