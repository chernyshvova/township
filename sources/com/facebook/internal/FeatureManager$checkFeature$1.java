package com.facebook.internal;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;

/* compiled from: FeatureManager.kt */
public final class FeatureManager$checkFeature$1 implements FetchedAppGateKeepersManager.Callback {
    public final /* synthetic */ FeatureManager.Callback $callback;
    public final /* synthetic */ FeatureManager.Feature $feature;

    public FeatureManager$checkFeature$1(FeatureManager.Callback callback, FeatureManager.Feature feature) {
        this.$callback = callback;
        this.$feature = feature;
    }

    public void onCompleted() {
        FeatureManager.Callback callback = this.$callback;
        FeatureManager featureManager = FeatureManager.INSTANCE;
        callback.onCompleted(FeatureManager.isEnabled(this.$feature));
    }
}
