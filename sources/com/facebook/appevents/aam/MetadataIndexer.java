package com.facebook.appevents.aam;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: MetadataIndexer.kt */
public final class MetadataIndexer {
    public static final MetadataIndexer INSTANCE = new MetadataIndexer();
    public static final String TAG = MetadataIndexer.class.getCanonicalName();
    public static boolean enabled;

    public static final void enable() {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute($$Lambda$HwZfI6_dusrQWeo0giyGr_AOY_o.INSTANCE);
            } catch (Exception e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m3564enable$lambda0() {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (!AttributionIdentifiers.Companion.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                    INSTANCE.updateRules();
                    enabled = true;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @UiThread
    public static final void onActivityResumed(Activity activity) {
        Class<MetadataIndexer> cls = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                try {
                    if (!enabled) {
                        return;
                    }
                    if (!MetadataRule.Companion.getRules().isEmpty()) {
                        MetadataViewObserver.Companion.startTrackingActivity(activity);
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void updateRules() {
        String rawAamRules;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (rawAamRules = queryAppSettings.getRawAamRules()) != null) {
                    MetadataRule.Companion.updateRules(rawAamRules);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
