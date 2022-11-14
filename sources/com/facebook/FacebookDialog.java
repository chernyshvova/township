package com.facebook;

import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;

/* compiled from: FacebookDialog.kt */
public interface FacebookDialog<CONTENT, RESULT> {
    boolean canShow(CONTENT content);

    ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager);

    void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback);

    void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback, int i);

    void show(CONTENT content);
}
