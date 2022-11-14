package com.facebook.login;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;

/* compiled from: DeviceAuthDialog.kt */
public final class DeviceAuthDialog$onCreateDialog$dialog$1 extends Dialog {
    public final /* synthetic */ DeviceAuthDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAuthDialog$onCreateDialog$dialog$1(DeviceAuthDialog deviceAuthDialog, FragmentActivity fragmentActivity, int i) {
        super(fragmentActivity, i);
        this.this$0 = deviceAuthDialog;
    }

    public void onBackPressed() {
        this.this$0.onBackButtonPressed();
        super.onBackPressed();
    }
}
