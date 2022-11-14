package com.vungle.warren.p037ui.presenter;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.share.internal.VideoUploader;
import com.vungle.warren.SessionData;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.omsdk.WebViewObserver;
import com.vungle.warren.p037ui.DurationRecorder;
import com.vungle.warren.p037ui.PresenterAppLeftCallback;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.WebAdContract;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.p037ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Constants;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.MRAIDAdPresenter */
public class MRAIDAdPresenter implements WebAdContract.WebAdPresenter, WebViewAPI.MRAIDDelegate, WebViewAPI.WebClientErrorHandler {
    public static final String ACTION = "action";
    public static final String ACTION_WITH_VALUE = "actionWithValue";
    public static final String CLOSE = "close";
    public static final String CONSENT_ACTION = "consentAction";
    public static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    public static final String EXTRA_REPORT = "saved_report";
    public static final String OPEN = "open";
    public static final String OPEN_NON_MRAID = "openNonMraid";
    public static final String OPEN_PRIVACY = "openPrivacy";
    public static final String SUCCESSFUL_VIEW = "successfulView";
    public static final String TAG = "com.vungle.warren.ui.presenter.MRAIDAdPresenter";
    public static final String TPAT = "tpat";
    public static final String USE_CUSTOM_CLOSE = "useCustomClose";
    public static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    public static final String VIDEO_VIEWED = "videoViewed";
    public WebAdContract.WebAdView adView;
    public boolean adViewed;
    public Advertisement advertisement;
    public final AdAnalytics analytics;
    public File assetDir;
    public boolean backEnabled;
    public AdContract.AdvertisementPresenter.EventListener bus;
    public Map<String, Cookie> cookieMap = new HashMap();
    public long duration;
    public DurationRecorder durationRecorder;
    public AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    @Nullable
    public final String[] impressionUrls;
    public AtomicBoolean isDestroying = new AtomicBoolean(false);
    public final OMTracker omTracker;
    @NonNull
    public final Placement placement;
    public Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        public boolean errorHappened = false;

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                MRAIDAdPresenter.this.makeBusError(26);
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName(), new VungleException(26).getLocalizedMessage());
                MRAIDAdPresenter.this.closeView();
            }
        }

        public void onSaved() {
        }
    };
    public Report report;
    public Repository repository;
    public final Scheduler scheduler;
    public AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    public SessionData sessionData;
    public WebViewAPI webClient;

    public MRAIDAdPresenter(@NonNull Advertisement advertisement2, @NonNull Placement placement2, @NonNull Repository repository2, @NonNull Scheduler scheduler2, @NonNull AdAnalytics adAnalytics, @NonNull WebViewAPI webViewAPI, @Nullable OptionsState optionsState, @NonNull File file, @NonNull SessionData sessionData2, @NonNull OMTracker oMTracker, @Nullable String[] strArr) {
        this.advertisement = advertisement2;
        this.repository = repository2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webClient = webViewAPI;
        this.assetDir = file;
        this.sessionData = sessionData2;
        this.omTracker = oMTracker;
        this.impressionUrls = strArr;
        loadData(optionsState);
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.scheduler.cancelAll();
    }

    private void download() {
        reportAction("cta", "");
        try {
            this.analytics.ping(new String[]{this.advertisement.getCTAURL(true)});
            this.adView.open(this.advertisement.getCTAURL(false), new PresenterAppLeftCallback(this.bus, this.placement));
        } catch (ActivityNotFoundException unused) {
            VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    private void handleWebViewException(@VungleException.ExceptionCode int i) {
        WebAdContract.WebAdView webAdView = this.adView;
        if (webAdView != null) {
            webAdView.removeWebView();
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("WebViewException: ");
        outline24.append(new VungleException(i).getLocalizedMessage());
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#handleWebViewException", outline24.toString());
        reportErrorAndCloseAd(i);
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookieMap.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, cls).get());
        this.cookieMap.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, cls).get());
        this.cookieMap.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, cls).get());
        if (optionsState != null) {
            String string = optionsState.getString("saved_report");
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    private void loadMraid(@NonNull File file) {
        File file2 = new File(file.getParent());
        StringBuilder sb = new StringBuilder();
        sb.append(file2.getPath());
        final File file3 = new File(GeneratedOutlineSupport.outline18(sb, File.separator, "index.html"));
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file3, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (!z) {
                    MRAIDAdPresenter.this.makeBusError(27);
                    MRAIDAdPresenter.this.makeBusError(10);
                    MRAIDAdPresenter.this.adView.close();
                    return;
                }
                WebAdContract.WebAdView access$300 = MRAIDAdPresenter.this.adView;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24(Advertisement.FILE_SCHEME);
                outline24.append(file3.getPath());
                access$300.showWebsite(outline24.toString());
                MRAIDAdPresenter.this.recordPlayRemoteUrl();
            }
        });
    }

    /* access modifiers changed from: private */
    public void makeBusError(@VungleException.ExceptionCode int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }

    private void prepare(@Nullable OptionsState optionsState) {
        String str;
        this.webClient.setMRAIDDelegate(this);
        this.webClient.setErrorHandler(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.assetDir.getPath());
        loadMraid(new File(GeneratedOutlineSupport.outline18(sb, File.separator, "template")));
        Cookie cookie = this.cookieMap.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie != null) {
            this.advertisement.setIncentivizedText(cookie.getString("title"), cookie.getString("body"), cookie.getString("continue"), cookie.getString("close"));
        }
        if (cookie == null) {
            str = null;
        } else {
            str = cookie.getString("userID");
        }
        if (this.report == null) {
            Report report2 = new Report(this.advertisement, this.placement, System.currentTimeMillis(), str, this.sessionData);
            this.report = report2;
            report2.setTtDownload(this.advertisement.getTtDownload());
            this.repository.save(this.report, this.repoCallback);
        }
        if (this.durationRecorder == null) {
            this.durationRecorder = new DurationRecorder(this.report, this.repository, this.repoCallback);
        }
        Cookie cookie2 = this.cookieMap.get(Cookie.CONSENT_COOKIE);
        if (cookie2 != null) {
            boolean z = cookie2.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie2.getString("consent_status"));
            this.webClient.setConsentStatus(z, cookie2.getString("consent_title"), cookie2.getString("consent_message"), cookie2.getString("button_accept"), cookie2.getString("button_deny"));
            if (z) {
                cookie2.putValue("consent_status", "opted_out_by_timeout");
                cookie2.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie2.putValue("consent_source", "vungle_modal");
                this.repository.save(cookie2, this.repoCallback);
            }
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
        if (showCloseDelay > 0) {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    boolean unused = MRAIDAdPresenter.this.backEnabled = true;
                }
            }, (long) showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        this.adView.updateWindow();
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, (String) null, this.placement.getId());
        }
    }

    /* access modifiers changed from: private */
    public void recordPlayRemoteUrl() {
        Report report2;
        Advertisement advertisement2 = this.repository.load(this.advertisement.getId(), Advertisement.class).get();
        if (advertisement2 != null && (report2 = this.report) != null) {
            report2.setAllAssetDownloaded(advertisement2.assetsFullyDownloaded);
            this.repository.save(this.report, this.repoCallback);
        }
    }

    private void reportErrorAndCloseAd(@VungleException.ExceptionCode int i) {
        makeBusError(i);
        closeView();
    }

    public void detach(@AdContract.AdStopReason int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.webClient.setWebViewObserver((WebViewObserver) null);
        this.adView.destroyAdView(this.omTracker.stop());
    }

    public void generateSaveState(@Nullable OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            optionsState.put("saved_report", this.report.getId());
            optionsState.put("incentivized_sent", this.sendReportIncentivized.get());
        }
    }

    public boolean handleExit() {
        if (!this.backEnabled) {
            return false;
        }
        this.adView.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMraidAction(@androidx.annotation.NonNull java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -314498168(0xffffffffed412388, float:-3.7358476E27)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 1427818632(0x551ac888, float:1.06366291E13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "download"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "close"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "privacy"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x004c
            if (r0 == r3) goto L_0x0048
            if (r0 != r2) goto L_0x003c
            goto L_0x004f
        L_0x003c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown action "
            java.lang.String r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r1, r5)
            r0.<init>(r5)
            throw r0
        L_0x0048:
            r4.download()
            goto L_0x004f
        L_0x004c:
            r4.closeView()
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p037ui.presenter.MRAIDAdPresenter.onMraidAction(java.lang.String):void");
    }

    public void onReceivedError(String str, boolean z) {
        Report report2 = this.report;
        if (report2 != null) {
            report2.recordError(str);
            this.repository.save(this.report, this.repoCallback);
        }
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onReceivedError", str);
        if (z) {
            reportErrorAndCloseAd(38);
        }
    }

    public void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    public void onViewConfigurationChanged() {
        this.adView.updateWindow();
        this.webClient.notifyPropertiesChange(true);
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(@androidx.annotation.NonNull java.lang.String r19, @androidx.annotation.NonNull com.google.gson.JsonObject r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int r3 = r19.hashCode()
            java.lang.String r4 = "useCustomPrivacy"
            java.lang.String r5 = "openNonMraid"
            java.lang.String r6 = "successfulView"
            java.lang.String r7 = "open"
            switch(r3) {
                case -1912374177: goto L_0x0078;
                case -1422950858: goto L_0x006e;
                case -735200587: goto L_0x0064;
                case -660787472: goto L_0x005a;
                case -511324706: goto L_0x004f;
                case -418575596: goto L_0x0047;
                case -348095344: goto L_0x003e;
                case 3417674: goto L_0x0036;
                case 3566511: goto L_0x002c;
                case 94756344: goto L_0x0022;
                case 1614272768: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0081
        L_0x0017:
            java.lang.String r3 = "useCustomClose"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 7
            goto L_0x0082
        L_0x0022:
            java.lang.String r3 = "close"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 0
            goto L_0x0082
        L_0x002c:
            java.lang.String r3 = "tpat"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 3
            goto L_0x0082
        L_0x0036:
            boolean r3 = r1.equals(r7)
            if (r3 == 0) goto L_0x0081
            r3 = 5
            goto L_0x0082
        L_0x003e:
            boolean r3 = r1.equals(r4)
            if (r3 == 0) goto L_0x0081
            r3 = 8
            goto L_0x0082
        L_0x0047:
            boolean r3 = r1.equals(r5)
            if (r3 == 0) goto L_0x0081
            r3 = 6
            goto L_0x0082
        L_0x004f:
            java.lang.String r3 = "openPrivacy"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 9
            goto L_0x0082
        L_0x005a:
            java.lang.String r3 = "consentAction"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 1
            goto L_0x0082
        L_0x0064:
            java.lang.String r3 = "actionWithValue"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 2
            goto L_0x0082
        L_0x006e:
            java.lang.String r3 = "action"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0081
            r3 = 4
            goto L_0x0082
        L_0x0078:
            boolean r3 = r1.equals(r6)
            if (r3 == 0) goto L_0x0081
            r3 = 10
            goto L_0x0082
        L_0x0081:
            r3 = -1
        L_0x0082:
            java.lang.String r8 = "adStartTime"
            java.lang.String r9 = "app_id"
            java.lang.String r10 = "placement_reference_id"
            java.lang.String r11 = "isReportIncentivizedEnabled"
            java.lang.String r12 = "Unknown value "
            java.lang.String r13 = "configSettings"
            java.lang.String r14 = "gone"
            java.lang.String r15 = "url"
            r16 = r5
            java.lang.String r5 = "event"
            r17 = r5
            r5 = 0
            switch(r3) {
                case 0: goto L_0x03c5;
                case 1: goto L_0x0384;
                case 2: goto L_0x0264;
                case 3: goto L_0x024d;
                case 4: goto L_0x024b;
                case 5: goto L_0x01f5;
                case 6: goto L_0x01f5;
                case 7: goto L_0x01a4;
                case 8: goto L_0x0156;
                case 9: goto L_0x013e;
                case 10: goto L_0x00ba;
                default: goto L_0x009c;
            }
        L_0x009c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.MRAIDAdPresenter> r2 = com.vungle.warren.p037ui.presenter.MRAIDAdPresenter.class
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = "#processCommand"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Unknown MRAID Command"
            com.vungle.warren.VungleLogger.error(r1, r2)
            r1 = 0
            return r1
        L_0x00ba:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x00c7
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            r1.onNext(r6, r5, r2)
        L_0x00c7:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.Object r1 = r1.get(r13)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            com.vungle.warren.model.Placement r2 = r0.placement
            boolean r2 = r2.isIncentivized()
            if (r2 == 0) goto L_0x013c
            if (r1 == 0) goto L_0x013c
            java.lang.Boolean r1 = r1.getBoolean(r11)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x013c
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            r2 = 1
            boolean r1 = r1.getAndSet(r2)
            if (r1 != 0) goto L_0x013c
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            r2.<init>((java.lang.String) r3)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r3 = r1.members
            r3.put(r10, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r3 = r0.advertisement
            java.lang.String r3 = r3.getAppID()
            r2.<init>((java.lang.String) r3)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r3 = r1.members
            r3.put(r9, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            long r3 = r3.getAdStartTime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.<init>((java.lang.Number) r3)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r3 = r1.members
            r3.put(r8, r2)
            com.google.gson.JsonPrimitive r2 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r3 = r0.report
            java.lang.String r3 = r3.getUserID()
            r2.<init>((java.lang.String) r3)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r3 = r1.members
            java.lang.String r4 = "user"
            r3.put(r4, r2)
            com.vungle.warren.analytics.AdAnalytics r2 = r0.analytics
            r2.mo21860ri(r1)
        L_0x013c:
            r1 = 1
            return r1
        L_0x013e:
            r1 = 1
            com.google.gson.JsonElement r2 = r2.get(r15)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r3 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r4 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r5 = r0.bus
            com.vungle.warren.model.Placement r6 = r0.placement
            r4.<init>(r5, r6)
            r3.open(r2, r4)
            return r1
        L_0x0156:
            com.google.gson.JsonElement r1 = r2.get(r4)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            r3 = 3178655(0x30809f, float:4.454244E-39)
            if (r2 == r3) goto L_0x0186
            r3 = 3569038(0x36758e, float:5.001287E-39)
            if (r2 == r3) goto L_0x017c
            r3 = 97196323(0x5cb1923, float:1.9099262E-35)
            if (r2 == r3) goto L_0x0172
            goto L_0x018e
        L_0x0172:
            java.lang.String r2 = "false"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018e
            r2 = 2
            goto L_0x018f
        L_0x017c:
            java.lang.String r2 = "true"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x018e
            r2 = 1
            goto L_0x018f
        L_0x0186:
            boolean r2 = r1.equals(r14)
            if (r2 == 0) goto L_0x018e
            r2 = 0
            goto L_0x018f
        L_0x018e:
            r2 = -1
        L_0x018f:
            if (r2 == 0) goto L_0x01a2
            r3 = 1
            if (r2 == r3) goto L_0x01a2
            r3 = 2
            if (r2 != r3) goto L_0x0198
            goto L_0x01a2
        L_0x0198:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r12, r1)
            r2.<init>(r1)
            throw r2
        L_0x01a2:
            r1 = 1
            return r1
        L_0x01a4:
            java.lang.String r1 = "sdkCloseButton"
            com.google.gson.JsonElement r1 = r2.get(r1)
            java.lang.String r1 = r1.getAsString()
            int r2 = r1.hashCode()
            r3 = -1901805651(0xffffffff8ea4bfad, float:-4.06137E-30)
            if (r2 == r3) goto L_0x01d5
            r3 = 3178655(0x30809f, float:4.454244E-39)
            if (r2 == r3) goto L_0x01cd
            r3 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r2 == r3) goto L_0x01c2
            goto L_0x01df
        L_0x01c2:
            java.lang.String r2 = "visible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01df
            r2 = 2
            goto L_0x01e0
        L_0x01cd:
            boolean r2 = r1.equals(r14)
            if (r2 == 0) goto L_0x01df
            r2 = 0
            goto L_0x01e0
        L_0x01d5:
            java.lang.String r2 = "invisible"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01df
            r2 = 1
            goto L_0x01e0
        L_0x01df:
            r2 = -1
        L_0x01e0:
            if (r2 == 0) goto L_0x01f3
            r3 = 1
            if (r2 == r3) goto L_0x01f3
            r3 = 2
            if (r2 != r3) goto L_0x01e9
            goto L_0x01f3
        L_0x01e9:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r12, r1)
            r2.<init>(r1)
            throw r2
        L_0x01f3:
            r1 = 1
            return r1
        L_0x01f5:
            java.lang.String r3 = "download"
            r0.reportAction(r3, r5)
            boolean r3 = r7.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0206
            java.lang.String r1 = "mraidOpen"
            r0.reportAction(r1, r5)
            goto L_0x0213
        L_0x0206:
            r3 = r16
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0213
            java.lang.String r1 = "nonMraidOpen"
            r0.reportAction(r1, r5)
        L_0x0213:
            com.google.gson.JsonElement r1 = r2.get(r15)
            java.lang.String r1 = r1.getAsString()
            if (r1 == 0) goto L_0x0233
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0224
            goto L_0x0233
        L_0x0224:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r2 = r0.adView
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            com.vungle.warren.model.Placement r5 = r0.placement
            r3.<init>(r4, r5)
            r2.open(r1, r3)
            goto L_0x023a
        L_0x0233:
            java.lang.String r1 = TAG
            java.lang.String r2 = "CTA destination URL is not configured properly"
            android.util.Log.e(r1, r2)
        L_0x023a:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r0.bus
            if (r1 == 0) goto L_0x0249
            com.vungle.warren.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = "adClick"
            r1.onNext(r7, r3, r2)
        L_0x0249:
            r1 = 1
            return r1
        L_0x024b:
            r1 = 1
            return r1
        L_0x024d:
            r1 = 1
            r3 = r17
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.analytics.AdAnalytics r3 = r0.analytics
            com.vungle.warren.model.Advertisement r4 = r0.advertisement
            java.lang.String[] r2 = r4.getTpatUrls(r2)
            r3.ping(r2)
            return r1
        L_0x0264:
            r3 = r17
            com.google.gson.JsonElement r1 = r2.get(r3)
            java.lang.String r1 = r1.getAsString()
            java.lang.String r3 = "value"
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            com.vungle.warren.model.Report r3 = r0.report
            long r6 = java.lang.System.currentTimeMillis()
            r3.recordAction(r1, r2, r6)
            com.vungle.warren.persistence.Repository r3 = r0.repository
            com.vungle.warren.model.Report r4 = r0.report
            com.vungle.warren.persistence.Repository$SaveCallback r6 = r0.repoCallback
            r3.save(r4, r6)
            java.lang.String r3 = "videoViewed"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0365
            r3 = 0
            float r4 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0298 }
            goto L_0x02a0
        L_0x0298:
            java.lang.String r4 = TAG
            java.lang.String r6 = "value for videoViewed is null !"
            android.util.Log.e(r4, r6)
            r4 = 0
        L_0x02a0:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r6 = r0.bus
            if (r6 == 0) goto L_0x02c3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x02c3
            boolean r3 = r0.adViewed
            if (r3 != 0) goto L_0x02c3
            r3 = 1
            r0.adViewed = r3
            com.vungle.warren.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getId()
            java.lang.String r7 = "adViewed"
            r6.onNext(r7, r5, r3)
            java.lang.String[] r3 = r0.impressionUrls
            if (r3 == 0) goto L_0x02c3
            com.vungle.warren.analytics.AdAnalytics r6 = r0.analytics
            r6.ping(r3)
        L_0x02c3:
            long r6 = r0.duration
            r14 = 0
            int r3 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x0365
            float r3 = (float) r6
            float r4 = r4 / r3
            r3 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r3
            int r3 = (int) r4
            if (r3 <= 0) goto L_0x0360
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r0.bus
            if (r4 == 0) goto L_0x02e7
            java.lang.String r6 = "percentViewed:"
            java.lang.String r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline14(r6, r3)
            com.vungle.warren.model.Placement r7 = r0.placement
            java.lang.String r7 = r7.getId()
            r4.onNext(r6, r5, r7)
        L_0x02e7:
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r4 = r0.cookieMap
            java.lang.Object r4 = r4.get(r13)
            com.vungle.warren.model.Cookie r4 = (com.vungle.warren.model.Cookie) r4
            com.vungle.warren.model.Placement r5 = r0.placement
            boolean r5 = r5.isIncentivized()
            if (r5 == 0) goto L_0x0360
            r5 = 75
            if (r3 <= r5) goto L_0x0360
            if (r4 == 0) goto L_0x0360
            java.lang.Boolean r3 = r4.getBoolean(r11)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0360
            java.util.concurrent.atomic.AtomicBoolean r3 = r0.sendReportIncentivized
            r4 = 1
            boolean r3 = r3.getAndSet(r4)
            if (r3 != 0) goto L_0x0360
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Placement r5 = r0.placement
            java.lang.String r5 = r5.getId()
            r4.<init>((java.lang.String) r5)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r3.members
            r5.put(r10, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Advertisement r5 = r0.advertisement
            java.lang.String r5 = r5.getAppID()
            r4.<init>((java.lang.String) r5)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r3.members
            r5.put(r9, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            long r5 = r5.getAdStartTime()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4.<init>((java.lang.Number) r5)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r3.members
            r5.put(r8, r4)
            com.google.gson.JsonPrimitive r4 = new com.google.gson.JsonPrimitive
            com.vungle.warren.model.Report r5 = r0.report
            java.lang.String r5 = r5.getUserID()
            r4.<init>((java.lang.String) r5)
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r3.members
            java.lang.String r6 = "user"
            r5.put(r6, r4)
            com.vungle.warren.analytics.AdAnalytics r4 = r0.analytics
            r4.mo21860ri(r3)
        L_0x0360:
            com.vungle.warren.ui.DurationRecorder r3 = r0.durationRecorder
            r3.update()
        L_0x0365:
            java.lang.String r3 = "videoLength"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x037d
            long r4 = java.lang.Long.parseLong(r2)
            r0.duration = r4
            r0.reportAction(r3, r2)
            com.vungle.warren.ui.view.WebViewAPI r1 = r0.webClient
            r2 = 1
            r1.notifyPropertiesChange(r2)
            goto L_0x037e
        L_0x037d:
            r2 = 1
        L_0x037e:
            com.vungle.warren.ui.contract.WebAdContract$WebAdView r1 = r0.adView
            r1.setVisibility(r2)
            return r2
        L_0x0384:
            r3 = r17
            java.util.Map<java.lang.String, com.vungle.warren.model.Cookie> r1 = r0.cookieMap
            java.lang.String r4 = "consentIsImportantToVungle"
            java.lang.Object r1 = r1.get(r4)
            com.vungle.warren.model.Cookie r1 = (com.vungle.warren.model.Cookie) r1
            if (r1 != 0) goto L_0x0397
            com.vungle.warren.model.Cookie r1 = new com.vungle.warren.model.Cookie
            r1.<init>(r4)
        L_0x0397:
            com.google.gson.JsonElement r2 = r2.get(r3)
            java.lang.String r2 = r2.getAsString()
            java.lang.String r3 = "consent_status"
            r1.putValue(r3, r2)
            java.lang.String r2 = "consent_source"
            java.lang.String r3 = "vungle_modal"
            r1.putValue(r2, r3)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "timestamp"
            r1.putValue(r3, r2)
            com.vungle.warren.persistence.Repository r2 = r0.repository
            com.vungle.warren.persistence.Repository$SaveCallback r3 = r0.repoCallback
            r2.save(r1, r3)
            r1 = 1
            return r1
        L_0x03c5:
            r1 = 1
            java.lang.String r2 = "mraidClose"
            r0.reportAction(r2, r5)
            r18.closeView()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p037ui.presenter.MRAIDAdPresenter.processCommand(java.lang.String, com.google.gson.JsonObject):boolean");
    }

    public void reportAction(@NonNull String str, @Nullable String str2) {
        if (str.equals("videoLength")) {
            long parseLong = Long.parseLong(str2);
            this.duration = parseLong;
            this.report.setVideoLength(parseLong);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void restoreFromSave(@Nullable OptionsState optionsState) {
        if (optionsState != null) {
            boolean z = optionsState.getBoolean("incentivized_sent", false);
            if (z) {
                this.sendReportIncentivized.set(z);
            }
            if (this.report == null) {
                this.adView.close();
                VungleLogger.error(MRAIDAdPresenter.class.getSimpleName() + "#restoreFromSave", "The advertisement was not started and cannot be restored.");
            }
        }
    }

    public void setAdVisibility(boolean z) {
        this.webClient.setAdVisibility(z);
        if (z) {
            this.durationRecorder.start();
        } else {
            this.durationRecorder.stop();
        }
    }

    public void setEventListener(@Nullable AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void start() {
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        setAdVisibility(true);
    }

    public void stop(@AdContract.AdStopReason int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        this.adView.pauseWeb();
        setAdVisibility(false);
        if (!z && z2 && !this.isDestroying.getAndSet(true)) {
            WebViewAPI webViewAPI = this.webClient;
            String str = null;
            if (webViewAPI != null) {
                webViewAPI.setMRAIDDelegate((WebViewAPI.MRAIDDelegate) null);
            }
            if (z3) {
                reportAction("mraidCloseByApi", (String) null);
            }
            this.repository.save(this.report, this.repoCallback);
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void attach(@NonNull WebAdContract.WebAdView webAdView, @Nullable OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = webAdView;
        webAdView.setPresenter(this);
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(Constants.ATTACH, this.advertisement.getCreativeId(), this.placement.getId());
        }
        this.omTracker.start();
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            if ((settings & 2) == 2) {
                z = true;
            }
            this.backEnabled = z;
        }
        int i = -1;
        int adOrientation = this.advertisement.getAdConfig().getAdOrientation();
        int i2 = 6;
        if (adOrientation == 3) {
            int orientation = this.advertisement.getOrientation();
            if (orientation == 0) {
                i = 7;
            } else if (orientation == 1) {
                i = 6;
            }
            i2 = i;
        } else if (adOrientation == 0) {
            i2 = 7;
        } else if (adOrientation != 1) {
            i2 = 4;
        }
        String str = TAG;
        Log.d(str, "Requested Orientation " + i2);
        webAdView.setOrientation(i2);
        prepare(optionsState);
    }
}
