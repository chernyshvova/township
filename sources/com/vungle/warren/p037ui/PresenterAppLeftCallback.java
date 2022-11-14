package com.vungle.warren.p037ui;

import androidx.annotation.Nullable;
import com.vungle.warren.model.Placement;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.utility.ActivityManager;

/* renamed from: com.vungle.warren.ui.PresenterAppLeftCallback */
public class PresenterAppLeftCallback implements ActivityManager.LeftApplicationCallback {
    public final AdContract.AdvertisementPresenter.EventListener bus;
    public final Placement placement;

    public PresenterAppLeftCallback(@Nullable AdContract.AdvertisementPresenter.EventListener eventListener, @Nullable Placement placement2) {
        this.bus = eventListener;
        this.placement = placement2;
    }

    public void onLeftApplication() {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            Placement placement2 = this.placement;
            eventListener.onNext(MRAIDAdPresenter.OPEN, "adLeftApplication", placement2 == null ? null : placement2.getId());
        }
    }
}
