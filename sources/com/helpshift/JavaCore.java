package com.helpshift;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserLoginManager;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.analytics.domainmodel.AnalyticsEventDM;
import com.helpshift.cif.CustomIssueFieldDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.AttachmentFileManagerDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.Threader;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.configuration.domainmodel.ConfigFetchDM;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.configuration.dto.RootApiConfig;
import com.helpshift.configuration.dto.RootInstallConfig;
import com.helpshift.conversation.ConversationInboxPoller;
import com.helpshift.conversation.activeconversation.AttachmentPreviewRenderer;
import com.helpshift.conversation.activeconversation.ConversationInfoRenderer;
import com.helpshift.conversation.activeconversation.ConversationalRenderer;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.activeconversation.usersetup.ConversationSetupRenderer;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.domainmodel.ConversationInboxManagerDM;
import com.helpshift.conversation.domainmodel.ConversationSetupDM;
import com.helpshift.conversation.viewmodel.AttachmentPreviewVM;
import com.helpshift.conversation.viewmodel.ConversationInfoVM;
import com.helpshift.conversation.viewmodel.ConversationSetupVM;
import com.helpshift.conversation.viewmodel.ConversationalVM;
import com.helpshift.conversation.viewmodel.NewConversationRenderer;
import com.helpshift.conversation.viewmodel.NewConversationVM;
import com.helpshift.crypto.CryptoDM;
import com.helpshift.delegate.RootDelegate;
import com.helpshift.delegate.UIThreadDelegateDecorator;
import com.helpshift.faq.FaqsDM;
import com.helpshift.localeprovider.domainmodel.LocaleProviderDM;
import com.helpshift.logger.ErrorReportsDM;
import com.helpshift.meta.MetaDataDM;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.ValuePair;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class JavaCore implements CoreApi {
    public static final String TAG = "Helpshift_JavaCore";
    public final AnalyticsEventDM analyticsEventDM;
    public Domain domain;
    public boolean isSDKSessionActive = false;
    public final MetaDataDM metaDataDM;
    public final Threader parallelThreader;
    public final Platform platform;
    public final SDKConfigurationDM sdkConfigurationDM;
    public UserManagerDM userManagerDM;

    public JavaCore(Platform platform2) {
        this.platform = platform2;
        Domain domain2 = new Domain(platform2);
        this.domain = domain2;
        this.userManagerDM = domain2.getUserManagerDM();
        this.parallelThreader = this.domain.getParallelThreader();
        this.sdkConfigurationDM = this.domain.getSDKConfigurationDM();
        this.analyticsEventDM = this.domain.getAnalyticsEventDM();
        this.metaDataDM = this.domain.getMetaDataDM();
    }

    private void runParallel(C2500F f) {
        this.parallelThreader.thread(f).mo33949f();
    }

    public synchronized boolean clearAnonymousUser() {
        return new UserLoginManager(this, this.domain, this.platform).clearAnonymousUser();
    }

    public Conversation getActiveConversation() {
        return getConversationController().getActiveConversationFromStorage();
    }

    public Conversation getActiveConversationOrPreIssue() {
        return getConversationController().getActiveConversationOrPreIssue();
    }

    public AnalyticsEventDM getAnalyticsEventDM() {
        return this.analyticsEventDM;
    }

    public AttachmentFileManagerDM getAttachmentFileManagerDM() {
        return this.domain.getAttachmentFileManagerDM();
    }

    public AttachmentPreviewVM getAttachmentPreviewModel(AttachmentPreviewRenderer attachmentPreviewRenderer) {
        return new AttachmentPreviewVM(this.domain, attachmentPreviewRenderer);
    }

    public AutoRetryFailedEventDM getAutoRetryFailedEventDM() {
        return this.domain.getAutoRetryFailedEventDM();
    }

    public ConfigFetchDM getConfigFetchDM() {
        return this.domain.getConfigFetchDM();
    }

    public ConversationController getConversationController() {
        return getConversationInboxManagerDM().getActiveConversationInboxDM();
    }

    public ConversationInboxManagerDM getConversationInboxManagerDM() {
        return this.domain.getConversationInboxManagerDM();
    }

    public ConversationInboxPoller getConversationInboxPoller() {
        return getConversationController().getConversationInboxPoller();
    }

    public ConversationInfoVM getConversationInfoViewModel(ConversationInfoRenderer conversationInfoRenderer) {
        return new ConversationInfoVM(this.domain, conversationInfoRenderer);
    }

    public ConversationSetupVM getConversationSetupVM(ConversationSetupRenderer conversationSetupRenderer) {
        return new ConversationSetupVM(this.platform, this.domain, new ConversationSetupDM(this.platform, this.domain.getConfigFetchDM(), this.userManagerDM.getActiveUserSetupDM()), conversationSetupRenderer);
    }

    public ConversationalVM getConversationalViewModel(boolean z, Long l, ConversationalRenderer conversationalRenderer, boolean z2) {
        return new ConversationalVM(this.platform, this.domain, getConversationController(), getConversationController().getViewableConversation(z, l), conversationalRenderer, z, z2);
    }

    public CryptoDM getCryptoDM() {
        return this.domain.getCryptoDM();
    }

    public CustomIssueFieldDM getCustomIssueFieldDM() {
        return this.domain.getCustomIssueFieldDM();
    }

    public UIThreadDelegateDecorator getDelegate() {
        return this.domain.getDelegate();
    }

    public Domain getDomain() {
        return this.domain;
    }

    public ErrorReportsDM getErrorReportsDM() {
        return this.domain.getErrorReportsDM();
    }

    public FaqsDM getFaqDM() {
        return this.domain.getFaqsDM();
    }

    public LocaleProviderDM getLocaleProviderDM() {
        return this.domain.getLocaleProviderDM();
    }

    public MetaDataDM getMetaDataDM() {
        return this.metaDataDM;
    }

    public NewConversationVM getNewConversationViewModel(NewConversationRenderer newConversationRenderer) {
        return new NewConversationVM(this.platform, this.domain, getConversationController(), newConversationRenderer);
    }

    public void getNotificationCountAsync(final FetchDataFromThread<ValuePair<Integer, Boolean>, Object> fetchDataFromThread) {
        this.domain.runParallel(new C2500F() {
            /* JADX INFO: finally extract failed */
            /* renamed from: f */
            public void mo33949f() {
                try {
                    ValuePair<Integer, Boolean> fetchConversationsAndGetNotificationCount = JavaCore.this.getConversationController().fetchConversationsAndGetNotificationCount();
                    if (fetchDataFromThread == null) {
                        return;
                    }
                    if (fetchConversationsAndGetNotificationCount == null || ((Integer) fetchConversationsAndGetNotificationCount.first).intValue() < 0) {
                        fetchDataFromThread.onFailure(fetchConversationsAndGetNotificationCount);
                    } else {
                        fetchDataFromThread.onDataFetched(fetchConversationsAndGetNotificationCount);
                    }
                } catch (Throwable th) {
                    FetchDataFromThread fetchDataFromThread = fetchDataFromThread;
                    if (fetchDataFromThread != null) {
                        fetchDataFromThread.onFailure(null);
                    }
                    throw th;
                }
            }
        });
    }

    public int getNotificationCountSync() {
        return getConversationController().getNotificationCountSync();
    }

    public SDKConfigurationDM getSDKConfigurationDM() {
        return this.sdkConfigurationDM;
    }

    public UserManagerDM getUserManagerDM() {
        return this.userManagerDM;
    }

    public void handlePushNotification(String str, String str2, String str3) {
        getConversationController().handlePushNotification(str, str2, str3);
    }

    public boolean isActiveConversationActionable() {
        return getConversationController().isActiveConversationActionable();
    }

    public boolean isSDKSessionActive() {
        return this.isSDKSessionActive;
    }

    public synchronized boolean login(HelpshiftUser helpshiftUser) {
        return new UserLoginManager(this, this.domain, this.platform).login(helpshiftUser);
    }

    public synchronized boolean logout() {
        return new UserLoginManager(this, this.domain, this.platform).logout();
    }

    public void onSDKSessionEnded() {
        this.isSDKSessionActive = false;
        getDelegate().sessionEnded();
    }

    public void onSDKSessionStarted() {
        this.isSDKSessionActive = true;
        getDelegate().sessionBegan();
    }

    public void refreshPoller() {
        getConversationInboxPoller().refreshPoller(false);
    }

    public void resetPreIssueConversations() {
        this.domain.getConversationInboxManagerDM().resetPreIssueConversations();
    }

    public void resetUsersSyncStatusAndStartSetupForActiveUser() {
        getUserManagerDM().resetSyncStateForAllUsers();
        getUserManagerDM().getActiveUserSetupDM().startSetup();
    }

    public void sendAnalyticsEvent() {
        runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                JavaCore javaCore = JavaCore.this;
                AnalyticsEventDM analyticsEventDM = javaCore.analyticsEventDM;
                if (analyticsEventDM != null) {
                    analyticsEventDM.sendEventsToServer(javaCore.getUserManagerDM().getActiveUser());
                }
            }
        });
    }

    public void sendAppStartEvent() {
        runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                JavaCore javaCore = JavaCore.this;
                javaCore.analyticsEventDM.sendAppStartEvent(javaCore.getUserManagerDM().getActiveUser());
            }
        });
    }

    public void sendFailedApiCalls() {
        getFaqDM();
        UserManagerDM userManagerDM2 = getUserManagerDM();
        getConversationController();
        userManagerDM2.getActiveUserSetupDM();
        getAnalyticsEventDM();
        this.domain.getAutoRetryFailedEventDM().sendAllEvents();
    }

    public void sendRequestIdsForSuccessfulApiCalls() {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                TSCorrectedNetwork tSCorrectedNetwork = new TSCorrectedNetwork(new POSTNetwork("/clear-idempotent-cache/", JavaCore.this.domain, JavaCore.this.platform), JavaCore.this.platform);
                Set<String> allSuccessfulRequestIds = JavaCore.this.platform.getNetworkRequestDAO().getAllSuccessfulRequestIds();
                if (!allSuccessfulRequestIds.isEmpty()) {
                    tSCorrectedNetwork.makeRequest(new RequestData((Map<String, String>) GeneratedOutlineSupport.outline28("request_ids", JavaCore.this.platform.getJsonifier().jsonify((Collection) allSuccessfulRequestIds))));
                    JavaCore.this.platform.getNetworkRequestDAO().clearSuccessfulRequestIds();
                }
            }
        });
    }

    public void setDelegateListener(RootDelegate rootDelegate) {
        this.domain.setDelegate(rootDelegate);
    }

    public void setNameAndEmail(String str, String str2) {
        getConversationController().saveName(str);
        getConversationController().saveEmail(str2);
    }

    public void setPushToken(String str) {
        if (str != null && !str.equals(this.platform.getDevice().getPushToken())) {
            this.platform.getDevice().setPushToken(str);
            getUserManagerDM().resetPushTokenSyncStatusForUsers();
            getUserManagerDM().sendPushToken();
        }
    }

    public void updateApiConfig(RootApiConfig rootApiConfig) {
        this.sdkConfigurationDM.updateApiConfig(rootApiConfig);
        Boolean bool = rootApiConfig.enableFullPrivacy;
        if (bool != null && bool.booleanValue()) {
            new UserLoginManager(this, this.domain, this.platform).clearPersonallyIdentifiableInformation();
        }
    }

    public void updateConversationExpiryProperties() {
        ConversationController conversationController = getConversationController();
        if (conversationController != null) {
            conversationController.updateActiveConversationExpiryProperties();
        }
    }

    public void updateInstallConfig(RootInstallConfig rootInstallConfig) {
        this.sdkConfigurationDM.updateInstallConfig(rootInstallConfig);
    }
}
