package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.C1541R;
import com.facebook.login.LoginClient;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginFragment.kt */
public class LoginFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_REQUEST = "request";
    public static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    public static final String SAVED_LOGIN_CLIENT = "loginClient";
    public static final String TAG = "LoginFragment";
    public String callingPackage;
    public LoginClient loginClient;
    public LoginClient.Request request;

    /* compiled from: LoginFragment.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m3660onCreate$lambda0(LoginFragment loginFragment, LoginClient.Result result) {
        Intrinsics.checkNotNullParameter(loginFragment, "this$0");
        Intrinsics.checkNotNullParameter(result, "outcome");
        loginFragment.onLoginClientCompleted(result);
    }

    private final void onLoginClientCompleted(LoginClient.Result result) {
        this.request = null;
        int i = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    @LayoutRes
    public int getLayoutResId() {
        return C1541R.layout.com_facebook_login_fragment;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SAVED_LOGIN_CLIENT);
        throw null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getLoginClient().onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        LoginClient loginClient2;
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            loginClient2 = null;
        } else {
            loginClient2 = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
        }
        if (loginClient2 != null) {
            loginClient2.setFragment(this);
        } else {
            loginClient2 = createLoginClient();
        }
        this.loginClient = loginClient2;
        getLoginClient().setOnCompletedListener(new LoginClient.OnCompletedListener() {
            public final void onCompleted(LoginClient.Result result) {
                LoginFragment.m3660onCreate$lambda0(LoginFragment.this, result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (intent != null && (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) != null) {
                this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        getLoginClient().setBackgroundProcessingListener(new LoginFragment$onCreateView$1(inflate.findViewById(C1541R.C1543id.com_facebook_login_fragment_progress_bar)));
        return inflate;
    }

    public void onDestroy() {
        getLoginClient().cancelCurrentHandler();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(C1541R.C1543id.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        getLoginClient().startOrContinueAuth(this.request);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, getLoginClient());
    }
}
