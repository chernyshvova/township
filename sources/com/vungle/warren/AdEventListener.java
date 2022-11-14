package com.vungle.warren;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.VideoUploader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.SendReportsJob;
import com.vungle.warren.utility.Constants;
import java.util.Map;

public class AdEventListener implements AdContract.AdvertisementPresenter.EventListener {
    public static final String TAG = "com.vungle.warren.AdEventListener";
    public final AdLoader adLoader;
    public boolean adRewarded;
    public Advertisement advertisement;
    public final JobRunner jobRunner;
    public int percentViewed = -1;
    public Placement placement;
    public final PlayAdCallback playAdCallback;
    public final Map<String, Boolean> playOperations;
    public final Repository repository;
    public final AdRequest request;
    public boolean successfulView;
    public final VisionController visionController;

    public AdEventListener(@NonNull AdRequest adRequest, @NonNull Map<String, Boolean> map, @Nullable PlayAdCallback playAdCallback2, @NonNull Repository repository2, @NonNull AdLoader adLoader2, @NonNull JobRunner jobRunner2, @NonNull VisionController visionController2, @Nullable Placement placement2, @Nullable Advertisement advertisement2) {
        this.request = adRequest;
        this.playOperations = map;
        this.playAdCallback = playAdCallback2;
        this.repository = repository2;
        this.adLoader = adLoader2;
        this.jobRunner = jobRunner2;
        this.visionController = visionController2;
        this.placement = placement2;
        this.advertisement = advertisement2;
        map.put(adRequest.getPlacementId(), Boolean.TRUE);
    }

    private void loadAdvertisement() {
        if (this.advertisement == null) {
            this.advertisement = this.repository.findValidAdvertisementForPlacement(this.request.getPlacementId(), this.request.getEventId()).get();
        }
    }

    private void loadPlacement() {
        if (this.placement == null) {
            this.placement = this.repository.load(this.request.getPlacementId(), Placement.class).get();
        }
    }

    public void onError(VungleException vungleException, String str) {
        loadAdvertisement();
        if (this.advertisement == null || vungleException.getExceptionCode() != 27) {
            if (!(this.advertisement == null || vungleException.getExceptionCode() == 15 || vungleException.getExceptionCode() == 25 || vungleException.getExceptionCode() == 36)) {
                try {
                    this.repository.saveAndApplyState(this.advertisement, str, 4);
                    loadPlacement();
                    if (this.placement != null) {
                        this.adLoader.loadEndlessIfNeeded(this.placement, this.placement.getAdSize(), 0);
                    }
                } catch (DatabaseHelper.DBException unused) {
                    vungleException = new VungleException(26);
                }
            }
            onFinished();
            PlayAdCallback playAdCallback2 = this.playAdCallback;
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, vungleException);
                VungleLogger.error("AdEventListener#PlayAdCallback", vungleException.getLocalizedMessage() + " :" + str);
                return;
            }
            return;
        }
        this.adLoader.dropCache(this.advertisement.getId());
    }

    public void onFinished() {
        this.playOperations.remove(this.request.getPlacementId());
    }

    public void onNext(@NonNull String str, String str2, String str3) {
        boolean z;
        loadAdvertisement();
        if (this.advertisement == null) {
            Log.e(TAG, "No Advertisement for ID");
            onFinished();
            PlayAdCallback playAdCallback2 = this.playAdCallback;
            if (playAdCallback2 != null) {
                playAdCallback2.onError(this.request.getPlacementId(), new VungleException(10));
                VungleLogger.error("AdEventListener#PlayAdCallback", str3 + ": AD_UNABLE_TO_PLAY");
                return;
            }
            return;
        }
        loadPlacement();
        if (this.placement == null) {
            Log.e(TAG, "No Placement for ID");
            onFinished();
            PlayAdCallback playAdCallback3 = this.playAdCallback;
            if (playAdCallback3 != null) {
                playAdCallback3.onError(this.request.getPlacementId(), new VungleException(13));
                VungleLogger.error("AdEventListener#PlayAdCallback", "PLACEMENT_NOT_FOUND: " + str3);
                return;
            }
            return;
        }
        try {
            boolean z2 = false;
            if (str.equals(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE)) {
                this.repository.saveAndApplyState(this.advertisement, str3, 2);
                if (this.playAdCallback != null) {
                    this.playAdCallback.onAdStart(str3);
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdStart: " + str3);
                }
                this.percentViewed = 0;
                Placement placement2 = this.repository.load(this.request.getPlacementId(), Placement.class).get();
                this.placement = placement2;
                if (placement2 != null) {
                    this.adLoader.loadEndlessIfNeeded(placement2, placement2.getAdSize(), 0);
                }
                if (this.visionController.isEnabled()) {
                    this.visionController.reportData(this.advertisement.getCreativeId(), this.advertisement.getCampaignId(), this.advertisement.getAdvertiserAppId());
                }
            } else if (str.equals("end")) {
                Log.d(BuildConfig.OMSDK_PARTNER_NAME, "Cleaning up metadata and assets for placement " + str3 + " and advertisement " + this.advertisement.getId());
                this.repository.saveAndApplyState(this.advertisement, str3, 3);
                this.repository.updateAndSaveReportState(str3, this.advertisement.getAppID(), 0, 1);
                this.jobRunner.execute(SendReportsJob.makeJobInfo(false));
                onFinished();
                if (this.playAdCallback != null) {
                    PlayAdCallback playAdCallback4 = this.playAdCallback;
                    if (!this.successfulView) {
                        if (this.percentViewed < 80) {
                            z = false;
                            if (str2 != null && str2.equals("isCTAClicked")) {
                                z2 = true;
                            }
                            playAdCallback4.onAdEnd(str3, z, z2);
                            this.playAdCallback.onAdEnd(str3);
                            VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdEnd: " + str3);
                        }
                    }
                    z = true;
                    z2 = true;
                    playAdCallback4.onAdEnd(str3, z, z2);
                    this.playAdCallback.onAdEnd(str3);
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdEnd: " + str3);
                }
            } else {
                if (this.placement.isIncentivized()) {
                    if (str.equals(MRAIDAdPresenter.SUCCESSFUL_VIEW)) {
                        this.successfulView = true;
                        if (!this.adRewarded) {
                            this.adRewarded = true;
                            if (this.playAdCallback != null) {
                                this.playAdCallback.onAdRewarded(str3);
                                VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdRewarded: " + str3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (str.startsWith("percentViewed") && this.placement.isIncentivized()) {
                    String[] split = str.split(CertificateUtil.DELIMITER);
                    if (split.length == 2) {
                        this.percentViewed = Integer.parseInt(split[1]);
                    }
                    if (!this.adRewarded && this.percentViewed >= 80) {
                        this.adRewarded = true;
                        if (this.playAdCallback != null) {
                            this.playAdCallback.onAdRewarded(str3);
                            VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdRewarded: " + str3);
                        }
                    }
                } else if (!MRAIDAdPresenter.OPEN.equals(str) || this.playAdCallback == null) {
                    if ("adViewed".equals(str) && this.playAdCallback != null) {
                        this.playAdCallback.onAdViewed(str3);
                    } else if (Constants.ATTACH.equals(str) && this.playAdCallback != null) {
                        this.playAdCallback.creativeId(str2);
                    }
                } else if ("adClick".equals(str2)) {
                    this.playAdCallback.onAdClick(str3);
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdClick: " + str3);
                } else if ("adLeftApplication".equals(str2)) {
                    this.playAdCallback.onAdLeftApplication(str3);
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdLeftApplication: " + str3);
                }
            }
        } catch (DatabaseHelper.DBException unused) {
            onError(new VungleException(26), str3);
        }
    }
}
