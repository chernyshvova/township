package com.facebook;

/* compiled from: LoginStatusCallback.kt */
public interface LoginStatusCallback {
    void onCompleted(AccessToken accessToken);

    void onError(Exception exc);

    void onFailure();
}
