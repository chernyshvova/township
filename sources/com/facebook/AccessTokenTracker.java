package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessTokenTracker.kt */
public abstract class AccessTokenTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG;
    public final LocalBroadcastManager broadcastManager;
    public boolean isTracking;
    public final BroadcastReceiver receiver = new CurrentAccessTokenBroadcastReceiver(this);

    /* compiled from: AccessTokenTracker.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AccessTokenTracker.kt */
    public final class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        public final /* synthetic */ AccessTokenTracker this$0;

        public CurrentAccessTokenBroadcastReceiver(AccessTokenTracker accessTokenTracker) {
            Intrinsics.checkNotNullParameter(accessTokenTracker, "this$0");
            this.this$0 = accessTokenTracker;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED, intent.getAction())) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(AccessTokenTracker.TAG, "AccessTokenChanged");
                this.this$0.onCurrentAccessTokenChanged((AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_OLD_ACCESS_TOKEN), (AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_NEW_ACCESS_TOKEN));
            }
        }
    }

    static {
        String simpleName = AccessTokenTracker.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "AccessTokenTracker::class.java.simpleName");
        TAG = simpleName;
    }

    public AccessTokenTracker() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = instance;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2);

    public final void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public final void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.unregisterReceiver(this.receiver);
            this.isTracking = false;
        }
    }
}
