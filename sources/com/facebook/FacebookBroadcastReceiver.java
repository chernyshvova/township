package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookBroadcastReceiver.kt */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onFailedAppCall(String str, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "appCallId");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(bundle, "extras");
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        Bundle extras = intent.getExtras();
        if (stringExtra != null && stringExtra2 != null && extras != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.isErrorResult(intent)) {
                onFailedAppCall(stringExtra, stringExtra2, extras);
            } else {
                onSuccessfulAppCall(stringExtra, stringExtra2, extras);
            }
        }
    }

    public void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "appCallId");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(bundle, "extras");
    }
}
