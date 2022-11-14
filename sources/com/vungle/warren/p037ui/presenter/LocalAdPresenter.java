package com.vungle.warren.p037ui.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.VideoUploader;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.swrve.sdk.ISwrveCommon;
import com.vungle.warren.SessionData;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.analytics.AnalyticsEvent;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.p037ui.DurationRecorder;
import com.vungle.warren.p037ui.PresenterAppLeftCallback;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.LocalAdContract;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.p037ui.view.WebViewAPI;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.AsyncFileUtils;
import com.vungle.warren.utility.Constants;
import com.vungle.warren.utility.Scheduler;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.presenter.LocalAdPresenter */
public class LocalAdPresenter implements LocalAdContract.LocalPresenter, WebViewAPI.WebClientErrorHandler {
    public static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    public static final String EXTRA_IN_POST = "in_post_roll";
    public static final String EXTRA_IS_MUTED = "is_muted_mode";
    public static final String EXTRA_REPORT = "saved_report";
    public static final String EXTRA_VIDEO_POSITION = "videoPosition";
    public static final String HTTPS_VUNGLE_COM_PRIVACY = "https://vungle.com/privacy/";
    public static final int INCENTIVIZED_TRESHOLD = 75;
    public static final String TAG = "LocalAdPresenter";
    public LocalAdContract.LocalView adView;
    public boolean adViewed;
    public Advertisement advertisement;
    public final AdAnalytics analytics;
    public File assetDir;
    public AdContract.AdvertisementPresenter.EventListener bus;
    public AtomicBoolean busy = new AtomicBoolean(false);
    public LinkedList<Advertisement.Checkpoint> checkpointList = new LinkedList<>();
    public final Map<String, Cookie> cookies = new HashMap();
    public String dialogBody = "If you exit now, you will not get your reward";
    public String dialogClose = "Close";
    public String dialogContinue = "Continue";
    public String dialogTitle = "Are you sure?";
    public int duration;
    public DurationRecorder durationRecorder;
    public AsyncFileUtils.ExistenceOperation fileExistenceOperation;
    @Nullable
    public final String[] impressionUrls;
    public boolean inPost;
    public AtomicBoolean isDestroying = new AtomicBoolean(false);
    public boolean muted;
    @NonNull
    public Placement placement;
    public int progress;
    public Repository.SaveCallback repoCallback = new Repository.SaveCallback() {
        public boolean errorHappened = false;

        public void onError(Exception exc) {
            if (!this.errorHappened) {
                this.errorHappened = true;
                LocalAdPresenter.this.makeBusError(26);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
                LocalAdPresenter.this.closeAndReport();
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
    public boolean userExitEnabled;
    public int videoPosition;
    public final WebViewAPI webViewAPI;

    public LocalAdPresenter(@NonNull Advertisement advertisement2, @NonNull Placement placement2, @NonNull Repository repository2, @NonNull Scheduler scheduler2, @NonNull AdAnalytics adAnalytics, @NonNull WebViewAPI webViewAPI2, @Nullable OptionsState optionsState, @NonNull File file, @NonNull SessionData sessionData2, @Nullable String[] strArr) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.scheduler = scheduler2;
        this.analytics = adAnalytics;
        this.webViewAPI = webViewAPI2;
        this.repository = repository2;
        this.assetDir = file;
        this.sessionData = sessionData2;
        this.impressionUrls = strArr;
        if (advertisement2.getCheckpoints() != null) {
            this.checkpointList.addAll(advertisement2.getCheckpoints());
            Collections.sort(this.checkpointList);
        }
        loadData(optionsState);
    }

    /* access modifiers changed from: private */
    public void closeAndReport() {
        if (this.busy.get()) {
            Log.w(TAG, "Busy with closing");
            return;
        }
        this.busy.set(true);
        reportAction("close", (String) null);
        this.scheduler.cancelAll();
        this.adView.close();
    }

    /* access modifiers changed from: private */
    public void continueWithPostroll() {
        if (this.advertisement.hasPostroll()) {
            playPost();
        } else {
            closeAndReport();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006e A[Catch:{ ActivityNotFoundException -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void download() {
        /*
            r6 = this;
            java.lang.String r0 = "LocalAdPresenter"
            java.lang.String r1 = "cta"
            java.lang.String r2 = ""
            r6.reportAction(r1, r2)
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r3 = "postroll_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r3 = "click_url"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r2 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r3 = "video_click"
            java.lang.String[] r2 = r2.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.ping(r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.analytics.AdAnalytics r1 = r6.analytics     // Catch:{ ActivityNotFoundException -> 0x007e }
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r4 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r2 = r4.getCTAURL(r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r4 = 0
            r3[r4] = r2     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.ping(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r1 = "download"
            r2 = 0
            r6.reportAction(r1, r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r1 = r6.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r1 = r1.getCTAURL(r4)     // Catch:{ ActivityNotFoundException -> 0x007e }
            if (r1 == 0) goto L_0x0065
            boolean r2 = r1.isEmpty()     // Catch:{ ActivityNotFoundException -> 0x007e }
            if (r2 == 0) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            com.vungle.warren.ui.contract.LocalAdContract$LocalView r2 = r6.adView     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.ui.PresenterAppLeftCallback r3 = new com.vungle.warren.ui.PresenterAppLeftCallback     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r4 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Placement r5 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x007e }
            r3.<init>(r4, r5)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r2.open(r1, r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            goto L_0x006a
        L_0x0065:
            java.lang.String r1 = "CTA destination URL is not configured properly"
            android.util.Log.e(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x007e }
        L_0x006a:
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x007e }
            if (r1 == 0) goto L_0x009f
            com.vungle.warren.ui.contract.AdContract$AdvertisementPresenter$EventListener r1 = r6.bus     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r2 = "open"
            java.lang.String r3 = "adClick"
            com.vungle.warren.model.Placement r4 = r6.placement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r4 = r4.getId()     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.onNext(r2, r3, r4)     // Catch:{ ActivityNotFoundException -> 0x007e }
            goto L_0x009f
        L_0x007e:
            java.lang.String r1 = "Unable to find destination activity"
            android.util.Log.e(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.LocalAdPresenter> r1 = com.vungle.warren.p037ui.presenter.LocalAdPresenter.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "#download"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Download - Activity Not Found"
            com.vungle.warren.VungleLogger.error(r0, r1)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p037ui.presenter.LocalAdPresenter.download():void");
    }

    private void handleWebViewException(@VungleException.ExceptionCode int i) {
        LocalAdContract.LocalView localView = this.adView;
        if (localView != null) {
            localView.removeWebView();
        }
        reportErrorAndCloseAd(i);
    }

    private boolean isWebPageBlank() {
        String websiteUrl = this.adView.getWebsiteUrl();
        return TextUtils.isEmpty(websiteUrl) || "about:blank".equalsIgnoreCase(websiteUrl);
    }

    private void loadData(OptionsState optionsState) {
        Class<Cookie> cls = Cookie.class;
        this.cookies.put(Cookie.INCENTIVIZED_TEXT_COOKIE, this.repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, cls).get());
        this.cookies.put(Cookie.CONSENT_COOKIE, this.repository.load(Cookie.CONSENT_COOKIE, cls).get());
        this.cookies.put(Cookie.CONFIG_COOKIE, this.repository.load(Cookie.CONFIG_COOKIE, cls).get());
        if (optionsState != null) {
            String string = optionsState.getString("saved_report");
            Report report2 = TextUtils.isEmpty(string) ? null : this.repository.load(string, Report.class).get();
            if (report2 != null) {
                this.report = report2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void makeBusError(@VungleException.ExceptionCode int i) {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onError(new VungleException(i), this.placement.getId());
        }
    }

    private boolean needShowGDPR(@Nullable Cookie cookie) {
        return cookie != null && cookie.getBoolean("is_country_data_protected").booleanValue() && "unknown".equals(cookie.getString("consent_status"));
    }

    private void playPost() {
        File file = new File(this.assetDir.getPath());
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        final File file2 = new File(GeneratedOutlineSupport.outline18(sb, File.separator, "index.html"));
        this.fileExistenceOperation = AsyncFileUtils.isFileExistAsync(file2, new AsyncFileUtils.FileExistCallback() {
            public void status(boolean z) {
                if (z) {
                    LocalAdContract.LocalView access$200 = LocalAdPresenter.this.adView;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24(Advertisement.FILE_SCHEME);
                    outline24.append(file2.getPath());
                    access$200.showWebsite(outline24.toString());
                    LocalAdPresenter.this.analytics.ping(LocalAdPresenter.this.advertisement.getTpatUrls(AnalyticsEvent.C1956Ad.postrollView));
                    boolean unused = LocalAdPresenter.this.inPost = true;
                    return;
                }
                LocalAdPresenter.this.makeBusError(27);
                LocalAdPresenter.this.makeBusError(10);
                VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#playPost", "Error Rendering Postroll");
                LocalAdPresenter.this.closeAndReport();
            }
        });
    }

    private void prepare(@Nullable OptionsState optionsState) {
        String str;
        restoreFromSave(optionsState);
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
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
        this.webViewAPI.setErrorHandler(this);
        this.adView.showCTAOverlay(this.advertisement.isCtaOverlayEnabled(), this.advertisement.getCtaClickArea());
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, (String) null, this.placement.getId());
        }
    }

    private void reportError(@NonNull String str) {
        this.report.recordError(str);
        this.repository.save(this.report, this.repoCallback);
        makeBusError(27);
        if (this.inPost || !this.advertisement.hasPostroll()) {
            makeBusError(10);
            this.adView.close();
            return;
        }
        playPost();
    }

    private void reportErrorAndCloseAd(@VungleException.ExceptionCode int i) {
        makeBusError(i);
        String simpleName = LocalAdPresenter.class.getSimpleName();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("WebViewException: ");
        outline24.append(new VungleException(i).getLocalizedMessage());
        VungleLogger.error(simpleName, outline24.toString());
        closeAndReport();
    }

    private void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.adView.pauseVideo();
        this.adView.showDialog(str, str2, str3, str4, onClickListener);
    }

    private void showGDPR(@NonNull final Cookie cookie) {
        C20183 r5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                cookie.putValue("consent_status", i == -2 ? Cookie.CONSENT_STATUS_OPTED_OUT : i == -1 ? Cookie.CONSENT_STATUS_OPTED_IN : "opted_out_by_timeout");
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "vungle_modal");
                LocalAdPresenter.this.repository.save(cookie, (Repository.SaveCallback) null);
                LocalAdPresenter.this.start();
            }
        };
        cookie.putValue("consent_status", "opted_out_by_timeout");
        cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        cookie.putValue("consent_source", "vungle_modal");
        this.repository.save(cookie, this.repoCallback);
        showDialog(cookie.getString("consent_title"), cookie.getString("consent_message"), cookie.getString("button_accept"), cookie.getString("button_deny"), r5);
    }

    private void showIncetivizedDialog() {
        String str = this.dialogTitle;
        String str2 = this.dialogBody;
        String str3 = this.dialogContinue;
        String str4 = this.dialogClose;
        Cookie cookie = this.cookies.get(Cookie.INCENTIVIZED_TEXT_COOKIE);
        if (cookie != null) {
            str = cookie.getString("title");
            if (TextUtils.isEmpty(str)) {
                str = this.dialogTitle;
            }
            str2 = cookie.getString("body");
            if (TextUtils.isEmpty(str2)) {
                str2 = this.dialogBody;
            }
            str3 = cookie.getString("continue");
            if (TextUtils.isEmpty(str3)) {
                str3 = this.dialogContinue;
            }
            str4 = cookie.getString("close");
            if (TextUtils.isEmpty(str4)) {
                str4 = this.dialogClose;
            }
        }
        showDialog(str, str2, str3, str4, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    LocalAdPresenter.this.reportAction(AnalyticsEvent.C1956Ad.videoClose, (String) null);
                    LocalAdPresenter.this.continueWithPostroll();
                }
            }
        });
    }

    public void detach(@AdContract.AdStopReason int i) {
        AsyncFileUtils.ExistenceOperation existenceOperation = this.fileExistenceOperation;
        if (existenceOperation != null) {
            existenceOperation.cancel();
        }
        stop(i);
        this.adView.destroyAdView(0);
    }

    public void generateSaveState(@Nullable OptionsState optionsState) {
        if (optionsState != null) {
            this.repository.save(this.report, this.repoCallback);
            Report report2 = this.report;
            optionsState.put("saved_report", report2 == null ? null : report2.getId());
            optionsState.put("incentivized_sent", this.sendReportIncentivized.get());
            optionsState.put(EXTRA_IN_POST, this.inPost);
            optionsState.put(EXTRA_IS_MUTED, this.muted);
            LocalAdContract.LocalView localView = this.adView;
            optionsState.put(EXTRA_VIDEO_POSITION, (localView == null || !localView.isVideoPlaying()) ? this.videoPosition : this.adView.getVideoPosition());
        }
    }

    public boolean handleExit() {
        if (this.inPost) {
            closeAndReport();
            return true;
        } else if (!this.userExitEnabled) {
            return false;
        } else {
            if (!this.placement.isIncentivized() || this.progress > 75) {
                reportAction(AnalyticsEvent.C1956Ad.videoClose, (String) null);
                if (this.advertisement.hasPostroll()) {
                    playPost();
                    return false;
                }
                closeAndReport();
                return true;
            }
            showIncetivizedDialog();
            return false;
        }
    }

    public void onDownload() {
        download();
    }

    public boolean onMediaError(@NonNull String str) {
        reportError(str);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onMediaError", "Media Error: " + str);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
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
            if (r0 == 0) goto L_0x006b
            if (r0 == r3) goto L_0x0064
            if (r0 != r2) goto L_0x003c
            goto L_0x006e
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.vungle.warren.ui.presenter.LocalAdPresenter> r1 = com.vungle.warren.p037ui.presenter.LocalAdPresenter.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = "#onMraidAction"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Unknown MRAID Command"
            com.vungle.warren.VungleLogger.error(r0, r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unknown action "
            java.lang.String r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r1, r5)
            r0.<init>(r5)
            throw r0
        L_0x0064:
            r4.download()
            r4.closeAndReport()
            goto L_0x006e
        L_0x006b:
            r4.closeAndReport()
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.p037ui.presenter.LocalAdPresenter.onMraidAction(java.lang.String):void");
    }

    public void onMute(boolean z) {
        this.muted = z;
        if (z) {
            reportAction(AnalyticsEvent.C1956Ad.mute, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        } else {
            reportAction(AnalyticsEvent.C1956Ad.unmute, "false");
        }
    }

    public void onPrivacy() {
        this.adView.open(HTTPS_VUNGLE_COM_PRIVACY, new PresenterAppLeftCallback(this.bus, this.placement));
    }

    public void onProgressUpdate(int i, float f) {
        this.progress = (int) ((((float) i) / f) * 100.0f);
        this.videoPosition = i;
        this.durationRecorder.update();
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("percentViewed:");
            outline24.append(this.progress);
            eventListener.onNext(outline24.toString(), (String) null, this.placement.getId());
        }
        AdContract.AdvertisementPresenter.EventListener eventListener2 = this.bus;
        if (eventListener2 != null && i > 0 && !this.adViewed) {
            this.adViewed = true;
            eventListener2.onNext("adViewed", (String) null, this.placement.getId());
            String[] strArr = this.impressionUrls;
            if (strArr != null) {
                this.analytics.ping(strArr);
            }
        }
        reportAction("video_viewed", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)}));
        if (this.progress == 100) {
            if (this.checkpointList.peekLast() != null && this.checkpointList.peekLast().getPercentage() == 100) {
                this.analytics.ping(this.checkpointList.pollLast().getUrls());
            }
            continueWithPostroll();
        }
        this.report.recordProgress(this.videoPosition);
        this.repository.save(this.report, this.repoCallback);
        while (this.checkpointList.peek() != null && this.progress > this.checkpointList.peek().getPercentage()) {
            this.analytics.ping(this.checkpointList.poll().getUrls());
        }
        Cookie cookie = this.cookies.get(Cookie.CONFIG_COOKIE);
        if (this.placement.isIncentivized() && this.progress > 75 && cookie != null && cookie.getBoolean("isReportIncentivizedEnabled").booleanValue() && !this.sendReportIncentivized.getAndSet(true)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.members.put("placement_reference_id", new JsonPrimitive(this.placement.getId()));
            jsonObject.members.put("app_id", new JsonPrimitive(this.advertisement.getAppID()));
            jsonObject.members.put(ReportDBAdapter.ReportColumns.COLUMN_AD_START_TIME, new JsonPrimitive((Number) Long.valueOf(this.report.getAdStartTime())));
            jsonObject.members.put(ISwrveCommon.BATCH_EVENT_KEY_USER, new JsonPrimitive(this.report.getUserID()));
            this.analytics.mo21860ri(jsonObject);
        }
    }

    public void onReceivedError(String str, boolean z) {
        Report report2 = this.report;
        if (report2 != null) {
            report2.recordError(str);
            this.repository.save(this.report, this.repoCallback);
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "onReceivedError", str);
        }
    }

    public void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException(32);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    public void onVideoStart(int i, float f) {
        reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf((int) f)}));
    }

    public void onViewConfigurationChanged() {
        this.webViewAPI.notifyPropertiesChange(true);
        this.adView.refreshDialogIfVisible();
    }

    public boolean onWebRenderingProcessGone(WebView webView, boolean z) {
        handleWebViewException(31);
        VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    public void reportAction(@NonNull String str, @Nullable String str2) {
        if (str.equals("videoLength")) {
            int parseInt = Integer.parseInt(str2);
            this.duration = parseInt;
            this.report.setVideoLength((long) parseInt);
            this.repository.save(this.report, this.repoCallback);
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -840405966) {
            if (hashCode != 3363353) {
                if (hashCode == 1370606900 && str.equals(AnalyticsEvent.C1956Ad.videoClose)) {
                    c = 2;
                }
            } else if (str.equals(AnalyticsEvent.C1956Ad.mute)) {
                c = 0;
            }
        } else if (str.equals(AnalyticsEvent.C1956Ad.unmute)) {
            c = 1;
        }
        if (c == 0 || c == 1 || c == 2) {
            this.analytics.ping(this.advertisement.getTpatUrls(str));
        }
        this.report.recordAction(str, str2, System.currentTimeMillis());
        this.repository.save(this.report, this.repoCallback);
    }

    public void restoreFromSave(@Nullable OptionsState optionsState) {
        if (optionsState != null) {
            if (optionsState.getBoolean("incentivized_sent", false)) {
                this.sendReportIncentivized.set(true);
            }
            this.inPost = optionsState.getBoolean(EXTRA_IN_POST, this.inPost);
            this.muted = optionsState.getBoolean(EXTRA_IS_MUTED, this.muted);
            this.videoPosition = optionsState.getInt(EXTRA_VIDEO_POSITION, this.videoPosition).intValue();
        }
    }

    public void setEventListener(@Nullable AdContract.AdvertisementPresenter.EventListener eventListener) {
        this.bus = eventListener;
    }

    public void start() {
        this.durationRecorder.start();
        if (!this.adView.hasWebView()) {
            reportErrorAndCloseAd(31);
            VungleLogger.error(LocalAdPresenter.class.getSimpleName() + "#start", new VungleException(31).getLocalizedMessage());
            return;
        }
        this.adView.setImmersiveMode();
        this.adView.resumeWeb();
        Cookie cookie = this.cookies.get(Cookie.CONSENT_COOKIE);
        if (needShowGDPR(cookie)) {
            showGDPR(cookie);
        } else if (this.inPost) {
            if (isWebPageBlank()) {
                playPost();
            }
        } else if (!this.adView.isVideoPlaying() && !this.adView.isDialogVisible()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.assetDir.getPath());
            this.adView.playVideo(new File(GeneratedOutlineSupport.outline18(sb, File.separator, "video")), this.muted, this.videoPosition);
            int showCloseDelay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
            if (showCloseDelay > 0) {
                this.scheduler.schedule(new Runnable() {
                    public void run() {
                        boolean unused = LocalAdPresenter.this.userExitEnabled = true;
                        if (!LocalAdPresenter.this.inPost) {
                            LocalAdPresenter.this.adView.showCloseButton();
                        }
                    }
                }, (long) showCloseDelay);
                return;
            }
            this.userExitEnabled = true;
            this.adView.showCloseButton();
        }
    }

    public void stop(@AdContract.AdStopReason int i) {
        this.durationRecorder.stop();
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        this.adView.pauseWeb();
        if (this.adView.isVideoPlaying()) {
            this.videoPosition = this.adView.getVideoPosition();
            this.adView.pauseVideo();
        }
        if (z2 || !z) {
            if (this.inPost || z) {
                this.adView.showWebsite("about:blank");
            }
        } else if (!this.isDestroying.getAndSet(true)) {
            String str = null;
            reportAction("close", (String) null);
            this.scheduler.cancelAll();
            AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str, this.placement.getId());
            }
        }
    }

    public void attach(@NonNull LocalAdContract.LocalView localView, @Nullable OptionsState optionsState) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = localView;
        localView.setPresenter(this);
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            eventListener.onNext(Constants.ATTACH, this.advertisement.getCreativeId(), this.placement.getId());
        }
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            if ((settings & 2) == 2) {
                z = true;
            }
            this.userExitEnabled = z;
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
        Log.d(TAG, "Requested Orientation " + i2);
        localView.setOrientation(i2);
        prepare(optionsState);
    }
}
