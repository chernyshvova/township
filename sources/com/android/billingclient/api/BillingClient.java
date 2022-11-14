package com.android.billingclient.api;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.android.billingclient.api.Purchase;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public abstract class BillingClient {
    @UiThread
    public abstract void endConnection();

    @UiThread
    public abstract BillingResult launchBillingFlow(@NonNull Activity activity, @NonNull BillingFlowParams billingFlowParams);

    public abstract Purchase.PurchasesResult queryPurchases(@NonNull String str);

    @UiThread
    public abstract void startConnection(@NonNull BillingClientStateListener billingClientStateListener);
}
