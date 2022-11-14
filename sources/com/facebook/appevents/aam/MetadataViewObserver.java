package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.ActivityChooserModel;
import com.android.billingclient.api.zzam;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: MetadataViewObserver.kt */
public final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_TEXT_LENGTH = 100;
    public static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    public final WeakReference<Activity> activityWeakReference;
    public final AtomicBoolean isTracking;
    public final Set<String> processedText;
    public final Handler uiThreadHandler;

    /* compiled from: MetadataViewObserver.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String preNormalize(String str, String str2) {
            return Intrinsics.areEqual("r2", str) ? new Regex("[^\\d.]").replace(str2, "") : str2;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
            if (r6.equals("r5") == false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            if (r6.equals("r4") == false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            r7 = new kotlin.text.Regex("[^a-z]+").replace(r7, "");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void putUserData(java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7) {
            /*
                r4 = this;
                int r0 = r6.hashCode()
                r1 = 2
                r2 = 0
                switch(r0) {
                    case 3585: goto L_0x005b;
                    case 3586: goto L_0x0044;
                    case 3587: goto L_0x003b;
                    case 3588: goto L_0x000b;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x0081
            L_0x000b:
                java.lang.String r0 = "r6"
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L_0x0015
                goto L_0x0081
            L_0x0015:
                java.lang.String r0 = "-"
                boolean r1 = kotlin.text.CharsKt__CharKt.contains$default(r7, r0, r2, r1)
                if (r1 == 0) goto L_0x0081
                kotlin.text.Regex r1 = new kotlin.text.Regex
                r1.<init>((java.lang.String) r0)
                java.util.List r7 = r1.split(r7, r2)
                java.lang.String[] r0 = new java.lang.String[r2]
                java.lang.Object[] r7 = r7.toArray(r0)
                if (r7 == 0) goto L_0x0033
                java.lang.String[] r7 = (java.lang.String[]) r7
                r7 = r7[r2]
                goto L_0x0081
            L_0x0033:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException
                java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
                r5.<init>(r6)
                throw r5
            L_0x003b:
                java.lang.String r0 = "r5"
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L_0x004d
                goto L_0x0081
            L_0x0044:
                java.lang.String r0 = "r4"
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L_0x004d
                goto L_0x0081
            L_0x004d:
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "[^a-z]+"
                r0.<init>((java.lang.String) r1)
                java.lang.String r1 = ""
                java.lang.String r7 = r0.replace(r7, r1)
                goto L_0x0081
            L_0x005b:
                java.lang.String r0 = "r3"
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L_0x0064
                goto L_0x0081
            L_0x0064:
                java.lang.String r0 = "m"
                boolean r3 = kotlin.text.CharsKt__CharKt.startsWith$default(r7, r0, r2, r1)
                if (r3 != 0) goto L_0x0080
                java.lang.String r3 = "b"
                boolean r3 = kotlin.text.CharsKt__CharKt.startsWith$default(r7, r3, r2, r1)
                if (r3 != 0) goto L_0x0080
                java.lang.String r3 = "ge"
                boolean r7 = kotlin.text.CharsKt__CharKt.startsWith$default(r7, r3, r2, r1)
                if (r7 == 0) goto L_0x007d
                goto L_0x0080
            L_0x007d:
                java.lang.String r7 = "f"
                goto L_0x0081
            L_0x0080:
                r7 = r0
            L_0x0081:
                r5.put(r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataViewObserver.Companion.putUserData(java.util.Map, java.lang.String, java.lang.String):void");
        }

        @UiThread
        public final void startTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            int hashCode = activity.hashCode();
            Map access$getObservers$cp = MetadataViewObserver.access$getObservers$cp();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = access$getObservers$cp.get(valueOf);
            if (obj == null) {
                obj = new MetadataViewObserver(activity, (DefaultConstructorMarker) null);
                access$getObservers$cp.put(valueOf, obj);
            }
            MetadataViewObserver.access$startTracking((MetadataViewObserver) obj);
        }

        @UiThread
        public final void stopTrackingActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            MetadataViewObserver metadataViewObserver = (MetadataViewObserver) MetadataViewObserver.access$getObservers$cp().remove(Integer.valueOf(activity.hashCode()));
            if (metadataViewObserver != null) {
                MetadataViewObserver.access$stopTracking(metadataViewObserver);
            }
        }
    }

    public MetadataViewObserver(Activity activity) {
        this.processedText = new LinkedHashSet();
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.activityWeakReference = new WeakReference<>(activity);
        this.isTracking = new AtomicBoolean(false);
    }

    public /* synthetic */ MetadataViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public static final /* synthetic */ Map access$getObservers$cp() {
        if (CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            return null;
        }
        try {
            return observers;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$startTracking(MetadataViewObserver metadataViewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                metadataViewObserver.startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            }
        }
    }

    public static final /* synthetic */ void access$stopTracking(MetadataViewObserver metadataViewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                metadataViewObserver.stopTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            }
        }
    }

    private final void process(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                runOnUIThread(new Runnable(view, this) {
                    public final /* synthetic */ View f$0;
                    public final /* synthetic */ MetadataViewObserver f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MetadataViewObserver.m3565process$lambda0(this.f$0, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m3565process$lambda0(View view, MetadataViewObserver metadataViewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                Intrinsics.checkNotNullParameter(view, "$view");
                Intrinsics.checkNotNullParameter(metadataViewObserver, "this$0");
                if (view instanceof EditText) {
                    metadataViewObserver.processEditText(view);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            }
        }
    }

    private final void processEditText(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String obj = ((EditText) view).getText().toString();
                if (obj != null) {
                    Intrinsics.checkNotNullParameter(obj, "$this$trim");
                    int length = obj.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (true) {
                        if (i > length) {
                            break;
                        }
                        boolean isWhitespace = zzam.isWhitespace(obj.charAt(!z ? i : length));
                        if (!z) {
                            if (!isWhitespace) {
                                z = true;
                            } else {
                                i++;
                            }
                        } else if (!isWhitespace) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String obj2 = obj.subSequence(i, length + 1).toString();
                    if (obj2 != null) {
                        String lowerCase = obj2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (!(lowerCase.length() == 0) && !this.processedText.contains(lowerCase)) {
                            if (lowerCase.length() <= 100) {
                                this.processedText.add(lowerCase);
                                HashMap hashMap = new HashMap();
                                MetadataMatcher metadataMatcher = MetadataMatcher.INSTANCE;
                                List<String> currentViewIndicators = MetadataMatcher.getCurrentViewIndicators(view);
                                List<String> list = null;
                                for (MetadataRule next : MetadataRule.Companion.getRules()) {
                                    String access$preNormalize = Companion.preNormalize(next.getName(), lowerCase);
                                    if (next.getValRule().length() > 0) {
                                        MetadataMatcher metadataMatcher2 = MetadataMatcher.INSTANCE;
                                        if (!MetadataMatcher.matchValue(access$preNormalize, next.getValRule())) {
                                        }
                                    }
                                    MetadataMatcher metadataMatcher3 = MetadataMatcher.INSTANCE;
                                    if (MetadataMatcher.matchIndicator(currentViewIndicators, next.getKeyRules())) {
                                        Companion.putUserData(hashMap, next.getName(), access$preNormalize);
                                    } else {
                                        if (list == null) {
                                            MetadataMatcher metadataMatcher4 = MetadataMatcher.INSTANCE;
                                            list = MetadataMatcher.getAroundViewIndicators(view);
                                        }
                                        MetadataMatcher metadataMatcher5 = MetadataMatcher.INSTANCE;
                                        if (MetadataMatcher.matchIndicator(list, next.getKeyRules())) {
                                            Companion.putUserData(hashMap, next.getName(), access$preNormalize);
                                        }
                                    }
                                }
                                InternalAppEventsLogger.Companion.setInternalUserData(hashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    runnable.run();
                } else {
                    this.uiThreadHandler.post(runnable);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
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
                            viewTreeObserver.addOnGlobalFocusChangeListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @UiThread
    public static final void startTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                Companion.startTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
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
                            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @UiThread
    public static final void stopTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class)) {
            try {
                Companion.stopTrackingActivity(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MetadataViewObserver.class);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (view != null) {
                try {
                    process(view);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return;
                }
            }
            if (view2 != null) {
                process(view2);
            }
        }
    }
}
