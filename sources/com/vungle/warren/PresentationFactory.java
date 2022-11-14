package com.vungle.warren;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.OrientationDelegate;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.WebAdContract;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.p037ui.view.FullAdWidget;
import com.vungle.warren.p037ui.view.VungleWebClient;

public interface PresentationFactory {

    public interface FullScreenCallback {
        void onResult(@NonNull Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, @Nullable VungleException vungleException);
    }

    public interface ViewCallback {
        void onResult(@NonNull Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, @Nullable VungleException vungleException);
    }

    void destroy();

    void getFullScreenPresentation(@NonNull Context context, @NonNull AdRequest adRequest, @NonNull FullAdWidget fullAdWidget, @Nullable OptionsState optionsState, @NonNull CloseDelegate closeDelegate, @NonNull OrientationDelegate orientationDelegate, @Nullable Bundle bundle, @NonNull FullScreenCallback fullScreenCallback);

    void getNativeViewPresentation(@NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull CloseDelegate closeDelegate, @NonNull ViewCallback viewCallback);

    void saveState(Bundle bundle);
}
