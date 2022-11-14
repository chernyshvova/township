package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewObserver.kt */
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_TEXT_LENGTH = 300;
    public static final Map<Integer, ViewObserver> observers = new HashMap();
    public final WeakReference<Activity> activityWeakReference;
    public final AtomicBoolean isTracking;
    public final Handler uiThreadHandler;

    /* compiled from: ViewObserver.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            int hashCode = activity.hashCode();
            Map access$getObservers$cp = ViewObserver.access$getObservers$cp();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = access$getObservers$cp.get(valueOf);
            if (obj == null) {
                obj = new ViewObserver(activity, (DefaultConstructorMarker) null);
                access$getObservers$cp.put(valueOf, obj);
            }
            ViewObserver.access$startTracking((ViewObserver) obj);
        }

        public final void stopTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            ViewObserver viewObserver = (ViewObserver) ViewObserver.access$getObservers$cp().remove(Integer.valueOf(activity.hashCode()));
            if (viewObserver != null) {
                ViewObserver.access$stopTracking(viewObserver);
            }
        }
    }

    public ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    public /* synthetic */ ViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public static final /* synthetic */ Map access$getObservers$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return null;
        }
        try {
            return observers;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$startTracking(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                viewObserver.startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    public static final /* synthetic */ void access$stopTracking(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                viewObserver.stopTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    private final void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                $$Lambda$nUCensw0nSAvmui3ddkjIj25lYc r0 = new Runnable() {
                    public final void run() {
                        ViewObserver.m3594process$lambda0(ViewObserver.this);
                    }
                };
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    m3594process$lambda0(ViewObserver.this);
                } else {
                    this.uiThreadHandler.post(r0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m3594process$lambda0(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Intrinsics.checkNotNullParameter(viewObserver, "this$0");
                try {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView((Activity) viewObserver.activityWeakReference.get());
                    Activity activity = (Activity) viewObserver.activityWeakReference.get();
                    if (rootView == null) {
                        return;
                    }
                    if (activity != null) {
                        SuggestedEventViewHierarchy suggestedEventViewHierarchy = SuggestedEventViewHierarchy.INSTANCE;
                        for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                            SensitiveUserDataUtils sensitiveUserDataUtils = SensitiveUserDataUtils.INSTANCE;
                            if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                SuggestedEventViewHierarchy suggestedEventViewHierarchy2 = SuggestedEventViewHierarchy.INSTANCE;
                                String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                                if ((textOfViewRecursively.length() > 0) && textOfViewRecursively.length() <= 300) {
                                    ViewOnClickListener.Companion companion = ViewOnClickListener.Companion;
                                    String localClassName = activity.getLocalClassName();
                                    Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
                                    companion.attachListener$facebook_core_release(next, rootView, localClassName);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    private final void startTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!this.isTracking.getAndSet(true)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            process();
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void startTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Companion.startTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    private final void stopTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.isTracking.getAndSet(false)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void stopTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Companion.stopTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            }
        }
    }

    public void onGlobalLayout() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
