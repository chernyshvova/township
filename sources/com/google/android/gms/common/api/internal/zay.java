package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class zay extends zal {
    public final ArraySet<ApiKey<?>> zad;
    public final GoogleApiManager zae;

    public zay(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager) {
        this(lifecycleFragment, googleApiManager, GoogleApiAvailability.getInstance());
    }

    @MainThread
    public static void zaa(Activity activity, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zay zay = (zay) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zay.class);
        if (zay == null) {
            zay = new zay(fragment, googleApiManager);
        }
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zay.zad.add(apiKey);
        googleApiManager.zaa(zay);
    }

    private final void zad() {
        if (!this.zad.isEmpty()) {
            this.zae.zaa(this);
        }
    }

    public void onResume() {
        super.onResume();
        zad();
    }

    public void onStart() {
        super.onStart();
        zad();
    }

    public void onStop() {
        super.onStop();
        this.zae.zab(this);
    }

    public final ArraySet<ApiKey<?>> zac() {
        return this.zad;
    }

    @VisibleForTesting
    public zay(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.zad = new ArraySet<>();
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zae.zab(connectionResult, i);
    }

    public final void zaa() {
        this.zae.zac();
    }
}
