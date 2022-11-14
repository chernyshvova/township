package com.facebook.login;

import android.app.Activity;
import android.content.Intent;

/* compiled from: StartActivityDelegate.kt */
public interface StartActivityDelegate {
    Activity getActivityContext();

    void startActivityForResult(Intent intent, int i);
}
