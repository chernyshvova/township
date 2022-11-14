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

/* compiled from: AuthenticationTokenTracker.kt */
public abstract class AuthenticationTokenTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG;
    public final LocalBroadcastManager broadcastManager;
    public boolean isTracking;
    public final BroadcastReceiver receiver = new CurrentAuthenticationTokenBroadcastReceiver(this);

    /* compiled from: AuthenticationTokenTracker.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AuthenticationTokenTracker.kt */
    public final class CurrentAuthenticationTokenBroadcastReceiver extends BroadcastReceiver {
        public final /* synthetic */ AuthenticationTokenTracker this$0;

        public CurrentAuthenticationTokenBroadcastReceiver(AuthenticationTokenTracker authenticationTokenTracker) {
            Intrinsics.checkNotNullParameter(authenticationTokenTracker, "this$0");
            this.this$0 = authenticationTokenTracker;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED, intent.getAction())) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(AuthenticationTokenTracker.TAG, "AuthenticationTokenChanged");
                this.this$0.onCurrentAuthenticationTokenChanged((AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_OLD_AUTHENTICATION_TOKEN), (AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_NEW_AUTHENTICATION_TOKEN));
            }
        }
    }

    static {
        String simpleName = AuthenticationTokenTracker.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "AuthenticationTokenTracker::class.java.simpleName");
        TAG = simpleName;
    }

    public AuthenticationTokenTracker() {
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
        intentFilter.addAction(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentAuthenticationTokenChanged(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2);

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
