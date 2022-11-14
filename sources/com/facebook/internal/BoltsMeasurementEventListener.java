package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: BoltsMeasurementEventListener.kt */
public final class BoltsMeasurementEventListener extends BroadcastReceiver {
    public static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    public static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    public static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    public static BoltsMeasurementEventListener singleton;
    public final Context applicationContext;

    /* compiled from: BoltsMeasurementEventListener.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        /* renamed from: getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations */
        public static /* synthetic */ void m2716x83b588fd() {
        }

        public final BoltsMeasurementEventListener getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            if (BoltsMeasurementEventListener.access$getSingleton$cp() != null) {
                return BoltsMeasurementEventListener.access$getSingleton$cp();
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener = new BoltsMeasurementEventListener(context, (DefaultConstructorMarker) null);
            BoltsMeasurementEventListener.access$open(boltsMeasurementEventListener);
            BoltsMeasurementEventListener.access$setSingleton$cp(boltsMeasurementEventListener);
            return BoltsMeasurementEventListener.access$getSingleton$cp();
        }

        public final String getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release() {
            return BoltsMeasurementEventListener.access$getMEASUREMENT_EVENT_NOTIFICATION_NAME$cp();
        }
    }

    public BoltsMeasurementEventListener(Context context) {
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        this.applicationContext = applicationContext2;
    }

    public /* synthetic */ BoltsMeasurementEventListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final /* synthetic */ String access$getMEASUREMENT_EVENT_NOTIFICATION_NAME$cp() {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            return MEASUREMENT_EVENT_NOTIFICATION_NAME;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    public static final /* synthetic */ BoltsMeasurementEventListener access$getSingleton$cp() {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            return singleton;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$open(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        if (!CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            try {
                boltsMeasurementEventListener.open();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            }
        }
    }

    public static final /* synthetic */ void access$setSingleton$cp(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        if (!CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            try {
                singleton = boltsMeasurementEventListener;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            }
        }
    }

    private final void close() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.applicationContext);
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                instance.unregisterReceiver(this);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final BoltsMeasurementEventListener getInstance(Context context) {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            return Companion.getInstance(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    private final void open() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.applicationContext);
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                instance.registerReceiver(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void finalize() throws Throwable {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                close();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        Bundle bundle;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
                Set<String> set = null;
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY);
                }
                String stringPlus = Intrinsics.stringPlus(BOLTS_MEASUREMENT_EVENT_PREFIX, str);
                if (intent == null) {
                    bundle = null;
                } else {
                    bundle = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
                }
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    set = bundle.keySet();
                }
                if (set != null) {
                    for (String str2 : set) {
                        Intrinsics.checkNotNullExpressionValue(str2, "key");
                        bundle2.putString(new Regex("[ -]*$").replace(new Regex("^[ -]*").replace(new Regex("[^0-9a-zA-Z _-]").replace(str2, "-"), ""), ""), (String) bundle.get(str2));
                    }
                }
                internalAppEventsLogger.logEvent(stringPlus, bundle2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
