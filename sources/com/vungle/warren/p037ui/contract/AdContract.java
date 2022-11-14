package com.vungle.warren.p037ui.contract;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p037ui.JavascriptBridge;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.utility.ActivityManager;

/* renamed from: com.vungle.warren.ui.contract.AdContract */
public interface AdContract {

    /* renamed from: com.vungle.warren.ui.contract.AdContract$AdStopReason */
    public @interface AdStopReason {
        public static final int IS_AD_FINISHED_BY_API = 4;
        public static final int IS_AD_FINISHING = 2;
        public static final int IS_CHANGING_CONFIGURATION = 1;
    }

    /* renamed from: com.vungle.warren.ui.contract.AdContract$AdView */
    public interface AdView<T extends AdvertisementPresenter> {
        void close();

        void destroyAdView(long j);

        String getWebsiteUrl();

        boolean hasWebView();

        void open(@NonNull String str, ActivityManager.LeftApplicationCallback leftApplicationCallback);

        void pauseWeb();

        void refreshDialogIfVisible();

        void removeWebView();

        void resumeWeb();

        void setImmersiveMode();

        void setOrientation(int i);

        void setPresenter(@NonNull T t);

        void showCloseButton();

        void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener);

        void showWebsite(@NonNull String str);
    }

    /* renamed from: com.vungle.warren.ui.contract.AdContract$AdvertisementBus */
    public interface AdvertisementBus {
        public static final String ACTION = "AdvertisementBus";
        public static final String COMMAND = "command";
        public static final String PLACEMENT = "placement";
        public static final String STOP_ALL = "stopAll";
    }

    /* renamed from: com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter */
    public interface AdvertisementPresenter<T extends AdView> extends JavascriptBridge.MraidHandler {

        /* renamed from: com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener */
        public interface EventListener {
            void onError(@NonNull VungleException vungleException, @Nullable String str);

            void onNext(@NonNull String str, @Nullable String str2, @Nullable String str3);
        }

        void attach(@NonNull T t, @Nullable OptionsState optionsState);

        void detach(@AdStopReason int i);

        void generateSaveState(@Nullable OptionsState optionsState);

        boolean handleExit();

        void onViewConfigurationChanged();

        void restoreFromSave(@Nullable OptionsState optionsState);

        void setEventListener(@Nullable EventListener eventListener);

        void start();

        void stop(@AdStopReason int i);
    }
}
