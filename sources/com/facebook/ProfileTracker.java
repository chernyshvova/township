package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Validate;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileTracker.kt */
public abstract class ProfileTracker {
    public final LocalBroadcastManager broadcastManager;
    public boolean isTracking;
    public final BroadcastReceiver receiver = new ProfileBroadcastReceiver(this);

    /* compiled from: ProfileTracker.kt */
    public final class ProfileBroadcastReceiver extends BroadcastReceiver {
        public final /* synthetic */ ProfileTracker this$0;

        public ProfileBroadcastReceiver(ProfileTracker profileTracker) {
            Intrinsics.checkNotNullParameter(profileTracker, "this$0");
            this.this$0 = profileTracker;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED, intent.getAction())) {
                this.this$0.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    public ProfileTracker() {
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
        intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    public abstract void onCurrentProfileChanged(Profile profile, Profile profile2);

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
