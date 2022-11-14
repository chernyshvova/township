package com.vungle.warren.p037ui.contract;

import com.vungle.warren.p037ui.contract.AdContract;

/* renamed from: com.vungle.warren.ui.contract.WebAdContract */
public interface WebAdContract {

    /* renamed from: com.vungle.warren.ui.contract.WebAdContract$WebAdPresenter */
    public interface WebAdPresenter extends AdContract.AdvertisementPresenter<WebAdView> {
        void setAdVisibility(boolean z);
    }

    /* renamed from: com.vungle.warren.ui.contract.WebAdContract$WebAdView */
    public interface WebAdView extends AdContract.AdView<WebAdPresenter> {
        void setVisibility(boolean z);

        void updateWindow();
    }
}
