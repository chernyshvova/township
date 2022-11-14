package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.C1541R;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookActivity.kt */
public class FacebookActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FRAGMENT_TAG = "SingleFragment";
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    public static final String TAG;
    public Fragment currentFragment;

    /* compiled from: FacebookActivity.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String name = FacebookActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "FacebookActivity::class.java.name");
        TAG = name;
    }

    private final void handlePassThroughError() {
        Intent intent = getIntent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(intent, "requestIntent");
        Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(methodArgumentsFromIntent);
        NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        setResult(0, NativeProtocol.createProtocolResultIntent(intent2, (Bundle) null, exceptionFromErrorData));
        finish();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(str, "prefix");
                Intrinsics.checkNotNullParameter(printWriter, "writer");
                EndToEndDumper instance = EndToEndDumper.Companion.getInstance();
                if (!Intrinsics.areEqual(instance == null ? null : Boolean.valueOf(instance.maybeDump(str, printWriter, strArr)), Boolean.TRUE)) {
                    super.dump(str, fileDescriptor, printWriter, strArr);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.facebook.internal.FacebookDialogFragment, androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.fragment.app.Fragment getFragment() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            androidx.fragment.app.FragmentManager r1 = r4.getSupportFragmentManager()
            java.lang.String r2 = "supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "SingleFragment"
            androidx.fragment.app.Fragment r3 = r1.findFragmentByTag(r2)
            if (r3 != 0) goto L_0x0044
            java.lang.String r0 = r0.getAction()
            java.lang.String r3 = "FacebookDialogFragment"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            r3 = 1
            if (r0 == 0) goto L_0x002e
            com.facebook.internal.FacebookDialogFragment r0 = new com.facebook.internal.FacebookDialogFragment
            r0.<init>()
            r0.setRetainInstance(r3)
            r0.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r2)
            goto L_0x0043
        L_0x002e:
            com.facebook.login.LoginFragment r0 = new com.facebook.login.LoginFragment
            r0.<init>()
            r0.setRetainInstance(r3)
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            int r3 = com.facebook.common.C1541R.C1543id.com_facebook_fragment_container
            androidx.fragment.app.FragmentTransaction r1 = r1.add((int) r3, (androidx.fragment.app.Fragment) r0, (java.lang.String) r2)
            r1.commit()
        L_0x0043:
            r3 = r0
        L_0x0044:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookActivity.getFragment():androidx.fragment.app.Fragment");
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isInitialized()) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            FacebookSdk.sdkInitialize(applicationContext);
        }
        setContentView(C1541R.layout.com_facebook_activity_layout);
        if (Intrinsics.areEqual(PASS_THROUGH_CANCEL_ACTION, intent.getAction())) {
            handlePassThroughError();
        } else {
            this.currentFragment = getFragment();
        }
    }
}
