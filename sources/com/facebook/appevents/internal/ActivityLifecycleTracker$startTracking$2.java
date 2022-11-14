package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityLifecycleTracker.kt */
public final class ActivityLifecycleTracker$startTracking$2 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.onActivityCreated(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
        ActivityLifecycleTracker.INSTANCE.onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.INSTANCE.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences = ActivityLifecycleTracker.activityReferences + 1;
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
        AppEventsLogger.Companion.onContextStop();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences = ActivityLifecycleTracker.activityReferences - 1;
    }
}
