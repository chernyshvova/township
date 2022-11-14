package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Timer;
import java.util.TimerTask;

public class ScarRewardedAdHandler implements IScarRewardedAdListenerWrapper {
    public boolean _finishedPlaying = false;
    public boolean _hasRewarded = false;
    public boolean _hasSentStartEvents = false;
    public Timer _playbackTimer;
    public TimerTask _playbackTimerTask = new TimerTask() {
        public void run() {
            boolean unused = ScarRewardedAdHandler.this._finishedPlaying = true;
        }
    };
    public ScarAdMetadata _scarAdMetadata;

    public ScarRewardedAdHandler(ScarAdMetadata scarAdMetadata) {
        this._scarAdMetadata = scarAdMetadata;
        this._playbackTimer = new Timer();
    }

    public void onAdImpression() {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.GMA;
        GMAEvent gMAEvent = GMAEvent.REWARDED_IMPRESSION_RECORDED;
        ScarAdMetadata scarAdMetadata = this._scarAdMetadata;
        currentApp.sendEvent(webViewEventCategory, gMAEvent, scarAdMetadata._placementId, scarAdMetadata._queryId);
    }

    public void onRewardedAdClosed() {
        if (!this._finishedPlaying) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.AD_SKIPPED, new Object[0]);
            this._playbackTimer.cancel();
        }
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.AD_CLOSED, new Object[0]);
    }

    public void onRewardedAdFailedToLoad(int i, String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.GMA;
        GMAEvent gMAEvent = GMAEvent.LOAD_ERROR;
        ScarAdMetadata scarAdMetadata = this._scarAdMetadata;
        currentApp.sendEvent(webViewEventCategory, gMAEvent, scarAdMetadata._placementId, scarAdMetadata._queryId, str, Integer.valueOf(i));
    }

    public void onRewardedAdFailedToShow(int i, String str) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.GMA;
        GMAEvent gMAEvent = GMAEvent.REWARDED_SHOW_ERROR;
        ScarAdMetadata scarAdMetadata = this._scarAdMetadata;
        currentApp.sendEvent(webViewEventCategory, gMAEvent, scarAdMetadata._placementId, scarAdMetadata._queryId, str, Integer.valueOf(i));
    }

    public void onRewardedAdLoaded() {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.GMA;
        GMAEvent gMAEvent = GMAEvent.AD_LOADED;
        ScarAdMetadata scarAdMetadata = this._scarAdMetadata;
        currentApp.sendEvent(webViewEventCategory, gMAEvent, scarAdMetadata._placementId, scarAdMetadata._queryId);
    }

    public void onRewardedAdOpened() {
        if (!this._hasSentStartEvents) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.AD_STARTED, new Object[0]);
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.FIRST_QUARTILE, new Object[0]);
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.MIDPOINT, new Object[0]);
            this._hasSentStartEvents = true;
        }
        if (!this._hasRewarded) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.AD_EARNED_REWARD, new Object[0]);
            this._hasRewarded = true;
        }
        this._finishedPlaying = false;
        this._playbackTimer.schedule(this._playbackTimerTask, (long) this._scarAdMetadata._videoLengthMs.intValue());
    }

    public void onUserEarnedReward() {
        if (!this._hasRewarded) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.GMA, GMAEvent.AD_EARNED_REWARD, new Object[0]);
            this._hasRewarded = true;
        }
    }
}
