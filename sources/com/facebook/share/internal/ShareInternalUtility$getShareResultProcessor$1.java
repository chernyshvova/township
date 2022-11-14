package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.Sharer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ShareInternalUtility.kt */
public final class ShareInternalUtility$getShareResultProcessor$1 extends ResultProcessor {
    public final /* synthetic */ FacebookCallback<Sharer.Result> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareInternalUtility$getShareResultProcessor$1(FacebookCallback<Sharer.Result> facebookCallback) {
        super(facebookCallback);
        this.$callback = facebookCallback;
    }

    public void onCancel(AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
    }

    public void onError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(facebookException, "error");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.invokeOnErrorCallback(this.$callback, facebookException);
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (bundle != null) {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
            if (nativeDialogCompletionGesture == null || CharsKt__CharKt.equals("post", nativeDialogCompletionGesture, true)) {
                ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnSuccessCallback(this.$callback, ShareInternalUtility.getShareDialogPostId(bundle));
            } else if (CharsKt__CharKt.equals("cancel", nativeDialogCompletionGesture, true)) {
                ShareInternalUtility shareInternalUtility3 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            } else {
                ShareInternalUtility shareInternalUtility4 = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
            }
        }
    }
}
