package com.facebook;

/* compiled from: FacebookCallback.kt */
public interface FacebookCallback<RESULT> {
    void onCancel();

    void onError(FacebookException facebookException);

    void onSuccess(RESULT result);
}
