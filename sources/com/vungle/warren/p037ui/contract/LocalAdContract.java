package com.vungle.warren.p037ui.contract;

import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.presenter.LocalAdPresenter;
import java.io.File;

/* renamed from: com.vungle.warren.ui.contract.LocalAdContract */
public interface LocalAdContract {

    /* renamed from: com.vungle.warren.ui.contract.LocalAdContract$LocalPresenter */
    public interface LocalPresenter extends AdContract.AdvertisementPresenter<LocalView> {
        void onDownload();

        boolean onMediaError(String str);

        void onMute(boolean z);

        void onPrivacy();

        void onProgressUpdate(int i, float f);

        void onVideoStart(int i, float f);
    }

    /* renamed from: com.vungle.warren.ui.contract.LocalAdContract$LocalView */
    public interface LocalView extends AdContract.AdView<LocalAdPresenter> {
        int getVideoPosition();

        boolean isDialogVisible();

        boolean isVideoPlaying();

        void pauseVideo();

        void playVideo(File file, boolean z, int i);

        void showCTAOverlay(boolean z, boolean z2);
    }
}
