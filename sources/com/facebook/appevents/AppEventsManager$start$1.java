package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.p030ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

/* compiled from: AppEventsManager.kt */
public final class AppEventsManager$start$1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m3555onSuccess$lambda0(boolean z) {
        if (z) {
            MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
            MetadataIndexer.enable();
        }
    }

    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m3556onSuccess$lambda1(boolean z) {
        if (z) {
            RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
            RestrictiveDataManager.enable();
        }
    }

    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m3557onSuccess$lambda2(boolean z) {
        if (z) {
            ModelManager modelManager = ModelManager.INSTANCE;
            ModelManager.enable();
        }
    }

    /* renamed from: onSuccess$lambda-3  reason: not valid java name */
    public static final void m3558onSuccess$lambda3(boolean z) {
        if (z) {
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            EventDeactivationManager.enable();
        }
    }

    /* renamed from: onSuccess$lambda-4  reason: not valid java name */
    public static final void m3559onSuccess$lambda4(boolean z) {
        if (z) {
            InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
            InAppPurchaseManager.enableAutoLogging();
        }
    }

    /* renamed from: onSuccess$lambda-5  reason: not valid java name */
    public static final void m3560onSuccess$lambda5(boolean z) {
        if (z) {
            AppEventsCAPIManager appEventsCAPIManager = AppEventsCAPIManager.INSTANCE;
            AppEventsCAPIManager.enable();
        }
    }

    public void onError() {
    }

    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.AAM, $$Lambda$4nn3_uw4ywWJWXJ_cgelB6dzU3M.INSTANCE);
        FeatureManager featureManager2 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, $$Lambda$BPR80qquJ5Ti2m1zBPILQqqnmws.INSTANCE);
        FeatureManager featureManager3 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, $$Lambda$2TzN31hkw99zRJLMhQ9xbXcKt28.INSTANCE);
        FeatureManager featureManager4 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, $$Lambda$rqxljRI9tf8q5UZP6iCZY7dBIY.INSTANCE);
        FeatureManager featureManager5 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, $$Lambda$t3xA2PHvArcTfJcS085meRN4OWg.INSTANCE);
        FeatureManager featureManager6 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, $$Lambda$WTzROiUaEiYR8NY0YJVVwfJWuqg.INSTANCE);
    }
}
