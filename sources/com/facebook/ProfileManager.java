package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.transition.Transition;
import com.facebook.internal.Utility;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileManager.kt */
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    public static volatile ProfileManager instance;
    public Profile currentProfileField;
    public final LocalBroadcastManager localBroadcastManager;
    public final ProfileCache profileCache;

    /* compiled from: ProfileManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized ProfileManager getInstance() {
            ProfileManager access$getInstance$cp;
            if (ProfileManager.instance == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                ProfileManager.instance = new ProfileManager(instance, new ProfileCache());
            }
            access$getInstance$cp = ProfileManager.instance;
            if (access$getInstance$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Transition.MATCH_INSTANCE_STR);
                throw null;
            }
            return access$getInstance$cp;
        }
    }

    public ProfileManager(LocalBroadcastManager localBroadcastManager2, ProfileCache profileCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(profileCache2, "profileCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.profileCache = profileCache2;
    }

    public static final synchronized ProfileManager getInstance() {
        ProfileManager instance2;
        synchronized (ProfileManager.class) {
            instance2 = Companion.getInstance();
        }
        return instance2;
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    public final boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    public final void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private final void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        Utility utility = Utility.INSTANCE;
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }
}
