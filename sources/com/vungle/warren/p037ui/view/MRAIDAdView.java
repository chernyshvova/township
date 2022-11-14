package com.vungle.warren.p037ui.view;

import android.content.Context;
import androidx.annotation.NonNull;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.OrientationDelegate;
import com.vungle.warren.p037ui.contract.WebAdContract;

/* renamed from: com.vungle.warren.ui.view.MRAIDAdView */
public class MRAIDAdView extends BaseAdView<WebAdContract.WebAdPresenter> implements WebAdContract.WebAdView {
    public WebAdContract.WebAdPresenter presenter;

    public MRAIDAdView(@NonNull Context context, @NonNull FullAdWidget fullAdWidget, @NonNull OrientationDelegate orientationDelegate, @NonNull CloseDelegate closeDelegate) {
        super(context, fullAdWidget, orientationDelegate, closeDelegate);
    }

    public void setVisibility(boolean z) {
        this.view.setVisibility(z ? 0 : 8);
    }

    public void showWebsite(@NonNull String str) {
        this.view.showWebsite(str);
    }

    public void updateWindow() {
        this.view.updateWindow();
    }

    public void setPresenter(@NonNull WebAdContract.WebAdPresenter webAdPresenter) {
        this.presenter = webAdPresenter;
    }
}
