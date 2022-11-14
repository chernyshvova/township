package com.swrve.sdk;

import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.swrve.sdk.-$$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE implements OnFailureListener {
    public static final /* synthetic */ $$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE INSTANCE = new $$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE();

    private /* synthetic */ $$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE() {
    }

    public final void onFailure(Exception exc) {
        SwrveLogger.m2753e("SwrveSDK Couldn't obtain the Firebase registration id for the device", exc, new Object[0]);
    }
}
