package com.playrix.engine;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.playrix.firebase.BuildConfig;

public class FirebaseWrapper {
    public static final DeferredExecuteQueue mDeferredTasks = new DeferredExecuteQueue();
    public static volatile FirebaseAnalytics mFirebaseAnalytics;

    public static String getAttributeName(String str) {
        try {
            return (String) FirebaseAnalytics.Param.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getEventName(String str) {
        try {
            return (String) FirebaseAnalytics.Event.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSdkVersion() {
        return BuildConfig.FIREBASE_VERSION;
    }

    public static boolean initialize() {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                FirebaseAnalytics unused = FirebaseWrapper.mFirebaseAnalytics = FirebaseAnalytics.getInstance(Engine.getApplication());
                FirebaseWrapper.mDeferredTasks.process();
            }
        });
    }

    public static void setUserId(final String str) {
        mDeferredTasks.execute(new Runnable() {
            public void run() {
                String str = str;
                if (str == null || str.isEmpty()) {
                    FirebaseWrapper.mFirebaseAnalytics.zzb.zza(Boolean.FALSE);
                    return;
                }
                FirebaseWrapper.mFirebaseAnalytics.zzb.zza(Boolean.TRUE);
                FirebaseAnalytics access$000 = FirebaseWrapper.mFirebaseAnalytics;
                access$000.zzb.zza(str);
            }
        });
    }

    public static void trackEvent(final String str, final Bundle bundle) {
        mDeferredTasks.execute(new Runnable() {
            public void run() {
                FirebaseAnalytics access$000 = FirebaseWrapper.mFirebaseAnalytics;
                access$000.zzb.zza(str, bundle);
            }
        });
    }
}
