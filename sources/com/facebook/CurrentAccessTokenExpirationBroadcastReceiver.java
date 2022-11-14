package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrentAccessTokenExpirationBroadcastReceiver.kt */
public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED, intent.getAction())) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isInitialized()) {
                AccessTokenManager.Companion.getInstance().currentAccessTokenChanged();
            }
        }
    }
}
