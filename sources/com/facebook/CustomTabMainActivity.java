package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabMainActivity.kt */
public final class CustomTabMainActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ACTION = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".extra_action");
    public static final String EXTRA_CHROME_PACKAGE = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".extra_chromePackage");
    public static final String EXTRA_PARAMS = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".extra_params");
    public static final String EXTRA_TARGET_APP = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".extra_targetApp");
    public static final String EXTRA_URL = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".extra_url");
    public static final String NO_ACTIVITY_EXCEPTION = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".no_activity_exception");
    public static final String REFRESH_ACTION = Intrinsics.stringPlus(CustomTabMainActivity.class.getSimpleName(), ".action_refresh");
    public BroadcastReceiver redirectReceiver;
    public boolean shouldCloseCustomTab = true;

    /* compiled from: CustomTabMainActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Bundle parseResponseUri(String str) {
            Uri parse = Uri.parse(str);
            Utility utility = Utility.INSTANCE;
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            Utility utility2 = Utility.INSTANCE;
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            return parseUrlQueryString;
        }
    }

    /* compiled from: CustomTabMainActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            LoginTargetApp loginTargetApp = LoginTargetApp.INSTAGRAM;
            iArr[1] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void sendResult(int i, Intent intent) {
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            Bundle access$parseResponseUri = stringExtra != null ? Companion.parseResponseUri(stringExtra) : new Bundle();
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Intent createProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, access$parseResponseUri, (FacebookException) null);
            if (createProtocolResultIntent != null) {
                intent = createProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            setResult(i, NativeProtocol.createProtocolResultIntent(intent3, (Bundle) null, (FacebookException) null));
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        String stringExtra;
        CustomTab customTab;
        super.onCreate(bundle);
        if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null && (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) != null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
            if (WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1) {
                customTab = new InstagramCustomTab(stringExtra, bundleExtra);
            } else {
                customTab = new CustomTab(stringExtra, bundleExtra);
            }
            boolean openCustomTab = customTab.openCustomTab(this, stringExtra2);
            this.shouldCloseCustomTab = false;
            if (!openCustomTab) {
                setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
                finish();
                return;
            }
            CustomTabMainActivity$onCreate$redirectReceiver$1 customTabMainActivity$onCreate$redirectReceiver$1 = new CustomTabMainActivity$onCreate$redirectReceiver$1(this);
            this.redirectReceiver = customTabMainActivity$onCreate$redirectReceiver$1;
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabMainActivity$onCreate$redirectReceiver$1, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (Intrinsics.areEqual(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, (Intent) null);
        }
        this.shouldCloseCustomTab = true;
    }
}
