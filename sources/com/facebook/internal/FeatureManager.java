package com.facebook.internal;

import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: FeatureManager.kt */
public final class FeatureManager {
    public static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    public static final FeatureManager INSTANCE = new FeatureManager();
    public static final Map<Feature, String[]> featureMapping = new HashMap();

    /* compiled from: FeatureManager.kt */
    public interface Callback {
        void onCompleted(boolean z);
    }

    /* compiled from: FeatureManager.kt */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(196608),
        ServiceUpdateCompliance(196864),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        BypassAppSwitch(16973824),
        Share(33554432);
        
        public static final Companion Companion = null;
        public final int code;

        /* compiled from: FeatureManager.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Feature fromInt(int i) {
                Feature[] values = Feature.values();
                int length = values.length;
                int i2 = 0;
                while (i2 < length) {
                    Feature feature = values[i2];
                    i2++;
                    if (feature.code == i) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }
        }

        /* compiled from: FeatureManager.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Feature.values().length];
                Feature feature = Feature.Core;
                iArr[1] = 1;
                Feature feature2 = Feature.AppEvents;
                iArr[2] = 2;
                Feature feature3 = Feature.CodelessEvents;
                iArr[3] = 3;
                Feature feature4 = Feature.RestrictiveDataFiltering;
                iArr[5] = 4;
                Feature feature5 = Feature.Instrument;
                iArr[16] = 5;
                Feature feature6 = Feature.CrashReport;
                iArr[17] = 6;
                Feature feature7 = Feature.CrashShield;
                iArr[18] = 7;
                Feature feature8 = Feature.ThreadCheck;
                iArr[19] = 8;
                Feature feature9 = Feature.ErrorReport;
                iArr[20] = 9;
                Feature feature10 = Feature.AnrReport;
                iArr[21] = 10;
                Feature feature11 = Feature.AAM;
                iArr[6] = 11;
                Feature feature12 = Feature.CloudBridge;
                iArr[4] = 12;
                Feature feature13 = Feature.PrivacyProtection;
                iArr[7] = 13;
                Feature feature14 = Feature.SuggestedEvents;
                iArr[8] = 14;
                Feature feature15 = Feature.IntelligentIntegrity;
                iArr[9] = 15;
                Feature feature16 = Feature.ModelRequest;
                iArr[10] = 16;
                Feature feature17 = Feature.EventDeactivation;
                iArr[11] = 17;
                Feature feature18 = Feature.OnDeviceEventProcessing;
                iArr[12] = 18;
                Feature feature19 = Feature.OnDevicePostInstallEventProcessing;
                iArr[13] = 19;
                Feature feature20 = Feature.IapLogging;
                iArr[14] = 20;
                Feature feature21 = Feature.IapLoggingLib2;
                iArr[15] = 21;
                Feature feature22 = Feature.Monitoring;
                iArr[22] = 22;
                Feature feature23 = Feature.ServiceUpdateCompliance;
                iArr[23] = 23;
                Feature feature24 = Feature.Login;
                iArr[24] = 24;
                Feature feature25 = Feature.ChromeCustomTabsPrefetching;
                iArr[25] = 25;
                Feature feature26 = Feature.IgnoreAppSwitchToLoggedOut;
                iArr[26] = 26;
                Feature feature27 = Feature.BypassAppSwitch;
                iArr[27] = 27;
                Feature feature28 = Feature.Share;
                iArr[28] = 28;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        Feature(int i) {
            this.code = i;
        }

        public final Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return Companion.fromInt(i & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i) > 0) {
                return Companion.fromInt(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return Companion.fromInt(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return Companion.fromInt(0);
        }

        public final String toKey() {
            return Intrinsics.stringPlus("FBSDKFeature", this);
        }

        public String toString() {
            switch (ordinal()) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "AppEventsCloudbridge";
                case 5:
                    return "RestrictiveDataFiltering";
                case 6:
                    return "AAM";
                case 7:
                    return "PrivacyProtection";
                case 8:
                    return "SuggestedEvents";
                case 9:
                    return "IntelligentIntegrity";
                case 10:
                    return "ModelRequest";
                case 11:
                    return "EventDeactivation";
                case 12:
                    return "OnDeviceEventProcessing";
                case 13:
                    return "OnDevicePostInstallEventProcessing";
                case 14:
                    return "IAPLogging";
                case 15:
                    return "IAPLoggingLib2";
                case 16:
                    return "Instrument";
                case 17:
                    return "CrashReport";
                case 18:
                    return "CrashShield";
                case 19:
                    return "ThreadCheck";
                case 20:
                    return "ErrorReport";
                case 21:
                    return "AnrReport";
                case 22:
                    return "Monitoring";
                case 23:
                    return "ServiceUpdateCompliance";
                case 24:
                    return "LoginKit";
                case 25:
                    return "ChromeCustomTabsPrefetching";
                case 26:
                    return "IgnoreAppSwitchToLoggedOut";
                case 27:
                    return "BypassAppSwitch";
                case 28:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }
    }

    /* compiled from: FeatureManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.values().length];
            Feature feature = Feature.RestrictiveDataFiltering;
            iArr[5] = 1;
            Feature feature2 = Feature.Instrument;
            iArr[16] = 2;
            Feature feature3 = Feature.CrashReport;
            iArr[17] = 3;
            Feature feature4 = Feature.CrashShield;
            iArr[18] = 4;
            Feature feature5 = Feature.ThreadCheck;
            iArr[19] = 5;
            Feature feature6 = Feature.ErrorReport;
            iArr[20] = 6;
            Feature feature7 = Feature.AnrReport;
            iArr[21] = 7;
            Feature feature8 = Feature.AAM;
            iArr[6] = 8;
            Feature feature9 = Feature.CloudBridge;
            iArr[4] = 9;
            Feature feature10 = Feature.PrivacyProtection;
            iArr[7] = 10;
            Feature feature11 = Feature.SuggestedEvents;
            iArr[8] = 11;
            Feature feature12 = Feature.IntelligentIntegrity;
            iArr[9] = 12;
            Feature feature13 = Feature.ModelRequest;
            iArr[10] = 13;
            Feature feature14 = Feature.EventDeactivation;
            iArr[11] = 14;
            Feature feature15 = Feature.OnDeviceEventProcessing;
            iArr[12] = 15;
            Feature feature16 = Feature.OnDevicePostInstallEventProcessing;
            iArr[13] = 16;
            Feature feature17 = Feature.IapLogging;
            iArr[14] = 17;
            Feature feature18 = Feature.IapLoggingLib2;
            iArr[15] = 18;
            Feature feature19 = Feature.ChromeCustomTabsPrefetching;
            iArr[25] = 19;
            Feature feature20 = Feature.Monitoring;
            iArr[22] = 20;
            Feature feature21 = Feature.IgnoreAppSwitchToLoggedOut;
            iArr[26] = 21;
            Feature feature22 = Feature.BypassAppSwitch;
            iArr[27] = 22;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void checkFeature(Feature feature, Callback callback) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FeatureManager$checkFeature$1(callback, feature));
    }

    private final boolean defaultStatus(Feature feature) {
        switch (feature.ordinal()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 25:
            case 26:
            case 27:
                return false;
            default:
                return true;
        }
    }

    public static final void disableFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences.Editor edit = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit();
        String key = feature.toKey();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        edit.putString(key, FacebookSdk.getSdkVersion()).apply();
    }

    public static final Feature getFeature(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry next : featureMapping.entrySet()) {
            Feature feature = (Feature) next.getKey();
            String[] strArr = (String[]) next.getValue();
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str2 = strArr[i];
                    i++;
                    if (CharsKt__CharKt.startsWith$default(str, str2, false, 2)) {
                        return feature;
                    }
                }
            }
        }
        return Feature.Unknown;
    }

    private final boolean getGKStatus(Feature feature) {
        boolean defaultStatus = defaultStatus(feature);
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        String key = feature.toKey();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FetchedAppGateKeepersManager.getGateKeeperForKey(key, FacebookSdk.getApplicationId(), defaultStatus);
    }

    private final synchronized void initializeFeatureMapping() {
        if (featureMapping.isEmpty()) {
            featureMapping.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            featureMapping.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            featureMapping.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
            featureMapping.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            featureMapping.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            featureMapping.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            featureMapping.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            featureMapping.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            featureMapping.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            featureMapping.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            featureMapping.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            featureMapping.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            featureMapping.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    public static final boolean isEnabled(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), (String) null);
        if (string != null) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (Intrinsics.areEqual(string, FacebookSdk.getSdkVersion())) {
                return false;
            }
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return INSTANCE.getGKStatus(feature);
        }
        if (!isEnabled(parent) || !INSTANCE.getGKStatus(feature)) {
            return false;
        }
        return true;
    }
}
