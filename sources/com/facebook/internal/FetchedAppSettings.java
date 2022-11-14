package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FetchedAppSettings.kt */
public final class FetchedAppSettings {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final boolean automaticLoggingEnabled;
    public final boolean codelessEventsEnabled;
    public final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
    public final FacebookRequestErrorClassification errorClassification;
    public final JSONArray eventBindings;
    public final boolean iAPAutomaticLoggingEnabled;
    public final boolean monitorViaDialogEnabled;
    public final String nuxContent;
    public final boolean nuxEnabled;
    public final String rawAamRules;
    public final String restrictiveDataSetting;
    public final String sdkUpdateMessage;
    public final int sessionTimeoutInSeconds;
    public final String smartLoginBookmarkIconURL;
    public final String smartLoginMenuIconURL;
    public final EnumSet<SmartLoginOption> smartLoginOptions;
    public final String suggestedEventsSetting;
    public final boolean supportsImplicitLogging;
    public final boolean trackUninstallEnabled;

    /* compiled from: FetchedAppSettings.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
            Map map;
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(str2, "actionName");
            Intrinsics.checkNotNullParameter(str3, "featureName");
            boolean z = true;
            if (!(str2.length() == 0)) {
                if (str3.length() != 0) {
                    z = false;
                }
                if (!z) {
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str);
                    if (appSettingsWithoutQuery == null) {
                        map = null;
                    } else {
                        map = appSettingsWithoutQuery.getDialogConfigurations().get(str2);
                    }
                    if (map != null) {
                        return (DialogFeatureConfig) map.get(str3);
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: FetchedAppSettings.kt */
    public static final class DialogFeatureConfig {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        public static final String DIALOG_CONFIG_NAME_KEY = "name";
        public static final String DIALOG_CONFIG_URL_KEY = "url";
        public static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        public final String dialogName;
        public final Uri fallbackUrl;
        public final String featureName;
        public final int[] versionSpec;

        /* compiled from: FetchedAppSettings.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int[] parseVersionSpec(JSONArray jSONArray) {
                if (jSONArray == null) {
                    return null;
                }
                int length = jSONArray.length();
                int[] iArr = new int[length];
                int i = 0;
                if (length <= 0) {
                    return iArr;
                }
                while (true) {
                    int i2 = i + 1;
                    int i3 = -1;
                    int optInt = jSONArray.optInt(i, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i);
                        Utility utility = Utility.INSTANCE;
                        if (!Utility.isNullOrEmpty(optString)) {
                            try {
                                Intrinsics.checkNotNullExpressionValue(optString, "versionString");
                                i3 = Integer.parseInt(optString);
                            } catch (NumberFormatException e) {
                                Utility utility2 = Utility.INSTANCE;
                                Utility.logd(Utility.LOG_TAG, (Exception) e);
                            }
                            optInt = i3;
                        }
                    }
                    iArr[i] = optInt;
                    if (i2 >= length) {
                        return iArr;
                    }
                    i = i2;
                }
            }

            public final DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "dialogConfigJSON");
                String optString = jSONObject.optString("name");
                Utility utility = Utility.INSTANCE;
                Uri uri = null;
                if (Utility.isNullOrEmpty(optString)) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(optString, "dialogNameWithFeature");
                List split$default = CharsKt__CharKt.split$default(optString, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6);
                if (split$default.size() != 2) {
                    return null;
                }
                String str = (String) CollectionsKt__CollectionsKt.first(split$default);
                String str2 = (String) CollectionsKt__CollectionsKt.last(split$default);
                Utility utility2 = Utility.INSTANCE;
                if (!Utility.isNullOrEmpty(str)) {
                    Utility utility3 = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(str2)) {
                        String optString2 = jSONObject.optString("url");
                        Utility utility4 = Utility.INSTANCE;
                        if (!Utility.isNullOrEmpty(optString2)) {
                            uri = Uri.parse(optString2);
                        }
                        return new DialogFeatureConfig(str, str2, uri, parseVersionSpec(jSONObject.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), (DefaultConstructorMarker) null);
                    }
                }
                return null;
            }
        }

        public DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, uri, iArr);
        }

        public final String getDialogName() {
            return this.dialogName;
        }

        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        public final int[] getVersionSpec() {
            return this.versionSpec;
        }
    }

    public FetchedAppSettings(boolean z, String str, boolean z2, int i, EnumSet<SmartLoginOption> enumSet, Map<String, ? extends Map<String, DialogFeatureConfig>> map, boolean z3, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z6, boolean z7, String str5, String str6, String str7) {
        FacebookRequestErrorClassification facebookRequestErrorClassification2 = facebookRequestErrorClassification;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str, "nuxContent");
        Intrinsics.checkNotNullParameter(enumSet, "smartLoginOptions");
        Intrinsics.checkNotNullParameter(map, "dialogConfigurations");
        Intrinsics.checkNotNullParameter(facebookRequestErrorClassification2, "errorClassification");
        Intrinsics.checkNotNullParameter(str8, "smartLoginBookmarkIconURL");
        Intrinsics.checkNotNullParameter(str9, "smartLoginMenuIconURL");
        Intrinsics.checkNotNullParameter(str10, "sdkUpdateMessage");
        this.supportsImplicitLogging = z;
        this.nuxContent = str;
        this.nuxEnabled = z2;
        this.sessionTimeoutInSeconds = i;
        this.smartLoginOptions = enumSet;
        this.dialogConfigurations = map;
        this.automaticLoggingEnabled = z3;
        this.errorClassification = facebookRequestErrorClassification2;
        this.smartLoginBookmarkIconURL = str8;
        this.smartLoginMenuIconURL = str9;
        this.iAPAutomaticLoggingEnabled = z4;
        this.codelessEventsEnabled = z5;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str10;
        this.trackUninstallEnabled = z6;
        this.monitorViaDialogEnabled = z7;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }

    public static final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        return Companion.getDialogFeatureConfig(str, str2, str3);
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
