package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabActivity.kt */
public final class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION = Intrinsics.stringPlus(CustomTabActivity.class.getSimpleName(), ".action_customTabRedirect");
    public static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DESTROY_ACTION = Intrinsics.stringPlus(CustomTabActivity.class.getSimpleName(), ".action_destroy");
    public BroadcastReceiver closeReceiver;

    /* compiled from: CustomTabActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            CustomTabActivity$onActivityResult$closeReceiver$1 customTabActivity$onActivityResult$closeReceiver$1 = new CustomTabActivity$onActivityResult$closeReceiver$1(this);
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabActivity$onActivityResult$closeReceiver$1, new IntentFilter(DESTROY_ACTION));
            this.closeReceiver = customTabActivity$onActivityResult$closeReceiver$1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.closeReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }
}
