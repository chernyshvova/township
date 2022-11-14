package com.facebook.appevents.internal;

import com.facebook.internal.FeatureManager;

/* renamed from: com.facebook.appevents.internal.-$$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM implements FeatureManager.Callback {
    public static final /* synthetic */ $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM INSTANCE = new $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM();

    private /* synthetic */ $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM() {
    }

    public final void onCompleted(boolean z) {
        ActivityLifecycleTracker.m3585startTracking$lambda0(z);
    }
}
