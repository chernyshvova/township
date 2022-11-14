package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabActivity.kt */
public final class CustomTabActivity$onActivityResult$closeReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ CustomTabActivity this$0;

    public CustomTabActivity$onActivityResult$closeReceiver$1(CustomTabActivity customTabActivity) {
        this.this$0 = customTabActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.this$0.finish();
    }
}
