package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;

/* compiled from: ShareDialog.kt */
public final class ShareDialog$ShareStoryHandler$createAppCall$1 implements DialogPresenter.ParameterProvider {
    public final /* synthetic */ AppCall $appCall;
    public final /* synthetic */ ShareContent<?, ?> $content;
    public final /* synthetic */ boolean $shouldFailOnDataError;

    public ShareDialog$ShareStoryHandler$createAppCall$1(AppCall appCall, ShareContent<?, ?> shareContent, boolean z) {
        this.$appCall = appCall;
        this.$content = shareContent;
        this.$shouldFailOnDataError = z;
    }

    public Bundle getLegacyParameters() {
        LegacyNativeDialogParameters legacyNativeDialogParameters = LegacyNativeDialogParameters.INSTANCE;
        return LegacyNativeDialogParameters.create(this.$appCall.getCallId(), this.$content, this.$shouldFailOnDataError);
    }

    public Bundle getParameters() {
        NativeDialogParameters nativeDialogParameters = NativeDialogParameters.INSTANCE;
        return NativeDialogParameters.create(this.$appCall.getCallId(), this.$content, this.$shouldFailOnDataError);
    }
}
