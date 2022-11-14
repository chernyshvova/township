package com.facebook.login;

import android.view.View;
import com.facebook.login.LoginClient;

/* compiled from: LoginFragment.kt */
public final class LoginFragment$onCreateView$1 implements LoginClient.BackgroundProcessingListener {
    public final /* synthetic */ View $progressBar;

    public LoginFragment$onCreateView$1(View view) {
        this.$progressBar = view;
    }

    public void onBackgroundProcessingStarted() {
        this.$progressBar.setVisibility(0);
    }

    public void onBackgroundProcessingStopped() {
        this.$progressBar.setVisibility(8);
    }
}
