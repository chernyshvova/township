package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallbackManagerImpl.kt */
public final class CallbackManagerImpl implements CallbackManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Map<Integer, Callback> staticCallbacks = new HashMap();
    public final Map<Integer, Callback> callbacks = new HashMap();

    /* compiled from: CallbackManagerImpl.kt */
    public interface Callback {
        boolean onActivityResult(int i, Intent intent);
    }

    /* compiled from: CallbackManagerImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final synchronized Callback getStaticCallback(int i) {
            return (Callback) CallbackManagerImpl.staticCallbacks.get(Integer.valueOf(i));
        }

        /* access modifiers changed from: private */
        public final boolean runStaticCallback(int i, int i2, Intent intent) {
            Callback staticCallback = getStaticCallback(i);
            if (staticCallback == null) {
                return false;
            }
            return staticCallback.onActivityResult(i2, intent);
        }

        public final synchronized void registerStaticCallback(int i, Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (!CallbackManagerImpl.staticCallbacks.containsKey(Integer.valueOf(i))) {
                CallbackManagerImpl.staticCallbacks.put(Integer.valueOf(i), callback);
            }
        }
    }

    /* compiled from: CallbackManagerImpl.kt */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15);
        
        public final int offset;

        /* access modifiers changed from: public */
        RequestCodeOffset(int i) {
            this.offset = i;
        }

        public final int toRequestCode() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    public static final synchronized void registerStaticCallback(int i, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Companion.registerStaticCallback(i, callback);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Callback callback = this.callbacks.get(Integer.valueOf(i));
        if (callback == null) {
            return Companion.runStaticCallback(i, i2, intent);
        }
        return callback.onActivityResult(i2, intent);
    }

    public final void registerCallback(int i, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.put(Integer.valueOf(i), callback);
    }

    public final void unregisterCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }
}
