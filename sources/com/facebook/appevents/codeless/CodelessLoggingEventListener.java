package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: CodelessLoggingEventListener.kt */
public final class CodelessLoggingEventListener {
    public static final CodelessLoggingEventListener INSTANCE = new CodelessLoggingEventListener();

    /* compiled from: CodelessLoggingEventListener.kt */
    public static final class AutoLoggingOnClickListener implements View.OnClickListener {
        public View.OnClickListener existingOnClickListener;
        public WeakReference<View> hostView;
        public EventBinding mapping;
        public WeakReference<View> rootView;
        public boolean supportCodelessLogging = true;

        public AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2) {
            Intrinsics.checkNotNullParameter(eventBinding, "mapping");
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public void onClick(View view) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                    View.OnClickListener onClickListener = this.existingOnClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    View view2 = (View) this.rootView.get();
                    View view3 = (View) this.hostView.get();
                    if (view2 != null && view3 != null) {
                        CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                        CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, view3);
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    /* compiled from: CodelessLoggingEventListener.kt */
    public static final class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        public AdapterView.OnItemClickListener existingOnItemClickListener;
        public WeakReference<AdapterView<?>> hostView;
        public EventBinding mapping;
        public WeakReference<View> rootView;
        public boolean supportCodelessLogging = true;

        public AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView<?> adapterView) {
            Intrinsics.checkNotNullParameter(eventBinding, "mapping");
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(adapterView, "hostView");
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(adapterView);
            this.rootView = new WeakReference<>(view);
            this.existingOnItemClickListener = adapterView.getOnItemClickListener();
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            AdapterView.OnItemClickListener onItemClickListener = this.existingOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            View view2 = (View) this.rootView.get();
            AdapterView adapterView2 = (AdapterView) this.hostView.get();
            if (view2 != null && adapterView2 != null) {
                CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view2, adapterView2);
            }
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    public static final AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(eventBinding, "mapping");
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            return new AutoLoggingOnClickListener(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView<?> adapterView) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(eventBinding, "mapping");
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(adapterView, "hostView");
            return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void logEvent$facebook_core_release(EventBinding eventBinding, View view, View view2) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(eventBinding, "mapping");
                Intrinsics.checkNotNullParameter(view, "rootView");
                Intrinsics.checkNotNullParameter(view2, "hostView");
                String eventName = eventBinding.getEventName();
                Bundle parameters = CodelessMatcher.Companion.getParameters(eventBinding, view, view2);
                INSTANCE.updateParameters$facebook_core_release(parameters);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(eventName, parameters) {
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ Bundle f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        CodelessLoggingEventListener.m3569logEvent$lambda0(this.f$0, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: logEvent$lambda-0  reason: not valid java name */
    public static final void m3569logEvent$lambda0(String str, Bundle bundle) {
        Class<CodelessLoggingEventListener> cls = CodelessLoggingEventListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$eventName");
                Intrinsics.checkNotNullParameter(bundle, "$parameters");
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                AppEventsLogger.Companion.newLogger(FacebookSdk.getApplicationContext()).logEvent(str, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void updateParameters$facebook_core_release(Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(bundle, "parameters");
                String string = bundle.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM);
                if (string != null) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    bundle.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(string));
                }
                bundle.putString(Constants.IS_CODELESS_EVENT_KEY, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
