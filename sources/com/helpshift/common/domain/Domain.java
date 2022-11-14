package com.helpshift.common.domain;

import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.analytics.domainmodel.AnalyticsEventDM;
import com.helpshift.auth.domainmodel.WebSocketAuthDM;
import com.helpshift.cif.CustomIssueFieldDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.HSBlockReason;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.poller.Delay;
import com.helpshift.common.poller.HttpBackoff;
import com.helpshift.configuration.domainmodel.ConfigFetchDM;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.domainmodel.ConversationInboxManagerDM;
import com.helpshift.conversation.smartintent.SmartIntentDM;
import com.helpshift.crypto.CryptoDM;
import com.helpshift.delegate.RootDelegate;
import com.helpshift.delegate.UIThreadDelegateDecorator;
import com.helpshift.faq.FaqsDM;
import com.helpshift.localeprovider.domainmodel.LocaleProviderDM;
import com.helpshift.logger.ErrorReportsDM;
import com.helpshift.meta.MetaDataDM;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Domain {
    public AnalyticsEventDM analyticsEventDM;
    public AttachmentFileManagerDM attachmentFileManagerDM;
    public Threader attachmentUploadThreader;
    public AuthenticationFailureDM authenticationFailureDM;
    public AutoRetryFailedEventDM autoRetryFailedEventDM;
    public ConfigFetchDM configFetchDM;
    public ConversationInboxManagerDM conversationInboxManagerDM;
    public CryptoDM cryptoDM;
    public CustomIssueFieldDM customIssueFieldDM;
    public DelayedThreader delayedThreader;
    public ErrorReportsDM errorReportsDM;
    public FaqsDM faqsDM;
    public HSBlockReason hsBlockReason;
    public LocaleProviderDM localeProviderDM;
    public MetaDataDM metaDataDM;
    public Threader parallelThreader;
    public final Platform platform;
    public SDKConfigurationDM sdkConfigurationDM;
    public Threader serialThreader;
    public SmartIntentDM smartIntentDM;
    public UIThreadDelegateDecorator uiThreadDelegateDecorator = new UIThreadDelegateDecorator(this);
    public UserManagerDM userManagerDM;
    public WebSocketAuthDM webSocketAuthDM;

    public Domain(Platform platform2) {
        this.platform = platform2;
        this.autoRetryFailedEventDM = new AutoRetryFailedEventDM(this, platform2, new HttpBackoff.Builder().setBaseInterval(Delay.m3078of(5, TimeUnit.SECONDS)).setMaxInterval(Delay.m3078of(60, TimeUnit.SECONDS)).setMaxAttempts(10).setRandomness(0.1f).setMultiplier(2.0f).setRetryPolicy(HttpBackoff.RetryPolicy.FAILURE).build());
        UserManagerDM userManagerDM2 = new UserManagerDM(platform2, this);
        this.userManagerDM = userManagerDM2;
        userManagerDM2.init();
        this.serialThreader = new BackgroundThreader(Executors.newSingleThreadExecutor(new HSThreadFactory("core-s")));
        this.attachmentUploadThreader = new BackgroundThreader(Executors.newSingleThreadExecutor(new HSThreadFactory("core-at")));
        this.parallelThreader = new BackgroundThreader(Executors.newCachedThreadPool(new HSThreadFactory("core-p")));
        this.sdkConfigurationDM = new SDKConfigurationDM(this, platform2);
        this.configFetchDM = new ConfigFetchDM(platform2, this);
        this.metaDataDM = new MetaDataDM(this, platform2, this.sdkConfigurationDM);
        this.analyticsEventDM = new AnalyticsEventDM(this, platform2);
        this.conversationInboxManagerDM = new ConversationInboxManagerDM(platform2, this, this.userManagerDM);
        this.localeProviderDM = new LocaleProviderDM(this.sdkConfigurationDM, platform2);
        this.authenticationFailureDM = new AuthenticationFailureDM(this);
    }

    private synchronized DelayedThreader getDelayedThreader() {
        if (this.delayedThreader == null) {
            this.delayedThreader = new BackgroundDelayedThreader(Executors.newScheduledThreadPool(1, new HSThreadFactory("core-d")));
        }
        return this.delayedThreader;
    }

    public void blockPublicAPI(HSBlockReason hSBlockReason) {
        this.hsBlockReason = hSBlockReason;
    }

    public AnalyticsEventDM getAnalyticsEventDM() {
        return this.analyticsEventDM;
    }

    public synchronized AttachmentFileManagerDM getAttachmentFileManagerDM() {
        if (this.attachmentFileManagerDM == null) {
            this.attachmentFileManagerDM = new AttachmentFileManagerDM(this, this.platform);
        }
        return this.attachmentFileManagerDM;
    }

    public Threader getAttachmentUploadThreader() {
        return this.attachmentUploadThreader;
    }

    public AuthenticationFailureDM getAuthenticationFailureDM() {
        return this.authenticationFailureDM;
    }

    public AutoRetryFailedEventDM getAutoRetryFailedEventDM() {
        return this.autoRetryFailedEventDM;
    }

    public ConfigFetchDM getConfigFetchDM() {
        return this.configFetchDM;
    }

    public ConversationInboxManagerDM getConversationInboxManagerDM() {
        return this.conversationInboxManagerDM;
    }

    public synchronized CryptoDM getCryptoDM() {
        if (this.cryptoDM == null) {
            this.cryptoDM = new CryptoDM();
        }
        return this.cryptoDM;
    }

    public synchronized CustomIssueFieldDM getCustomIssueFieldDM() {
        if (this.customIssueFieldDM == null) {
            this.customIssueFieldDM = new CustomIssueFieldDM(this, this.platform);
        }
        return this.customIssueFieldDM;
    }

    public UIThreadDelegateDecorator getDelegate() {
        return this.uiThreadDelegateDecorator;
    }

    public synchronized ErrorReportsDM getErrorReportsDM() {
        if (this.errorReportsDM == null) {
            this.errorReportsDM = new ErrorReportsDM(this.platform, this);
        }
        return this.errorReportsDM;
    }

    public synchronized FaqsDM getFaqsDM() {
        if (this.faqsDM == null) {
            this.faqsDM = new FaqsDM(this, this.platform);
        }
        return this.faqsDM;
    }

    public LocaleProviderDM getLocaleProviderDM() {
        return this.localeProviderDM;
    }

    public MetaDataDM getMetaDataDM() {
        return this.metaDataDM;
    }

    public Threader getParallelThreader() {
        return this.parallelThreader;
    }

    public HSBlockReason getReasonForBlockAPI() {
        return this.hsBlockReason;
    }

    public SDKConfigurationDM getSDKConfigurationDM() {
        return this.sdkConfigurationDM;
    }

    public Threader getSerialThreader() {
        return this.serialThreader;
    }

    public synchronized SmartIntentDM getSmartIntentDM() {
        if (this.smartIntentDM == null) {
            this.smartIntentDM = new SmartIntentDM(this.platform, this);
        }
        return this.smartIntentDM;
    }

    public UserManagerDM getUserManagerDM() {
        return this.userManagerDM;
    }

    public synchronized WebSocketAuthDM getWebSocketAuthDM() {
        if (this.webSocketAuthDM == null) {
            this.webSocketAuthDM = new WebSocketAuthDM(this, this.platform);
        }
        return this.webSocketAuthDM;
    }

    public void runDelayed(C2500F f, long j) {
        getDelayedThreader().thread(f, j).mo33949f();
    }

    public void runDelayedInParallel(final C2500F f, long j) {
        runDelayed(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                Domain.this.runParallel(f);
            }
        }, j);
    }

    public void runOnUI(C2500F f) {
        if (this.platform.isCurrentThreadUIThread()) {
            f.mo33949f();
        } else {
            this.platform.getUIThreader().thread(f).mo33949f();
        }
    }

    public void runParallel(C2500F f) {
        getParallelThreader().thread(f).mo33949f();
    }

    public void runSerial(C2500F f) {
        getSerialThreader().thread(f).mo33949f();
    }

    public void setDelegate(RootDelegate rootDelegate) {
        if (rootDelegate != null) {
            this.uiThreadDelegateDecorator.setDelegate(rootDelegate);
        }
    }
}
