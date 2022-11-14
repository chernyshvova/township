package com.helpshift.conversation.domainmodel;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.UserDataStore;
import com.helpshift.account.domainmodel.IUserSyncExecutor;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserSyncStatus;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.One;
import com.helpshift.common.domain.Poller;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.domain.idempotent.SuccessOrNonRetriableStatusCodeIdempotentPolicy;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.MetaCorrectedNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.PUTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.PollerException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationInboxPoller;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.CreatePreIssueDM;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.LiveUpdateDM;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.ViewableSingleConversation;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dao.ConversationInboxDAO;
import com.helpshift.conversation.dao.PushNotificationData;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.ConversationDetailDTO;
import com.helpshift.conversation.dto.ConversationInbox;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.loaders.RemoteConversationLoader;
import com.helpshift.conversation.loaders.SingleConversationLoader;
import com.helpshift.conversation.pollersync.PollerSyncManager;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.conversation.util.predicate.ConversationPredicates;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.faq.domainmodel.FAQSearchDM;
import com.helpshift.providers.ICampaignsModuleAPIs;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.Filters;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSObservableList;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ConversationController implements AutoRetriableDM, IUserSyncExecutor {
    public static final long ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT = 60000;
    public static final String CREATE_ISSUE_ROUTE = "/issues/";
    public static final String CREATE_ISSUE_UNIQUE_MAPPING_KEY = "issue_default_unique_key";
    public static final String CREATE_PRE_ISSUE_ROUTE = "/preissues/";
    public static final String CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY = "preissue_default_unique_key";
    public static final long INACTIVE_ISSUES_NOTIFICATION_COUNT_TIMEOUT = 300000;
    public static final String LAST_NOTIFCOUNT_FETCH_KEY = "lastNotifCountFetchTime";
    public static final int MAX_POLL_SYNC_EXCEPTION_COUNT = 10;
    public static final long MESSAGES_PAGE_SIZE = 100;
    public static final String TAG = "Helpshift_ConvInboxDM";
    public static final Object fetchConversationUpdatesLock = new Object();
    public WeakReference<ViewableConversation> aliveViewableConversation;
    public final ConversationDAO conversationDAO;
    public final ConversationInboxDAO conversationInboxDAO;
    public final ConversationInboxPoller conversationInboxPoller;
    public final ConversationManager conversationManager;
    public int conversationViewState = -1;
    public final Domain domain;
    public final FAQSearchDM faqSearchDM;
    public AtomicReference<FetchDataFromThread<Integer, Integer>> fetchConversationUpdatesListenerReference = null;
    public Map<String, Integer> inAppNotificationMessageCountMap = new ConcurrentHashMap();
    public HashMap<Long, One> inProgressPreIssueCreators = new HashMap<>();
    public boolean isCreateConversationInProgress;
    public final KVStore kvStore;
    public final LiveUpdateDM liveUpdateDM;
    public final Platform platform;
    public int pollSyncExceptionCount;
    public PollerSyncManager pollerSyncManager;
    public RemoteConversationLoader remoteConversationLoader;
    public final SDKConfigurationDM sdkConfigurationDM;
    public boolean shouldDropCustomMetadata;
    public WeakReference<StartNewConversationListener> startNewConversationListenerRef;
    public boolean userCanReadMessages;
    public final UserDM userDM;

    public class CreateConversationStateHolder {
        public final AttachmentPickerFile attachmentPickerFile;
        public final String description;
        public final C2500F startNewConversationInternalF = new One(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                CreateConversationStateHolder createConversationStateHolder = CreateConversationStateHolder.this;
                ConversationController.this.startNewConversationInternal(createConversationStateHolder.description, createConversationStateHolder.userProvidedName, createConversationStateHolder.userProvidedEmail, createConversationStateHolder.attachmentPickerFile);
            }
        });
        public final String userProvidedEmail;
        public final String userProvidedName;

        public CreateConversationStateHolder(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile2) {
            this.description = str;
            this.userProvidedName = str2;
            this.userProvidedEmail = str3;
            this.attachmentPickerFile = attachmentPickerFile2;
        }

        public C2500F getStartNewConversationInternalF() {
            return this.startNewConversationInternalF;
        }
    }

    public class PollerSyncDataProviderImpl implements PollerSyncDataProvider {
        public PollerSyncDataProviderImpl() {
        }

        public Conversation getActiveConversationFromStorage() {
            return ConversationController.this.getActiveConversationFromStorage();
        }

        public ViewableConversation getAliveViewableConversation() {
            return ConversationController.this.getAliveViewableConversation();
        }

        public int getCurrentConversationViewState() {
            return ConversationController.this.conversationViewState;
        }

        public Map<String, String> getMessagesLocalIdToPendingRequestIdMap(Conversation conversation) {
            return ConversationController.this.conversationManager.getMessagesLocalIdToPendingRequestIdMap(conversation);
        }

        public String getPendingRequestIdForPreissue() {
            return ConversationController.this.platform.getNetworkRequestDAO().getPendingRequestId(ConversationController.CREATE_PRE_ISSUE_ROUTE, ConversationController.CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY);
        }
    }

    public interface StartNewConversationListener {
        void onCreateConversationFailure(Exception exc);

        void onCreateConversationSuccess(long j);
    }

    public ConversationController(Platform platform2, Domain domain2, UserDM userDM2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.conversationInboxDAO = platform2.getConversationInboxDAO();
        this.conversationDAO = platform2.getConversationDAO();
        this.kvStore = platform2.getKVStore();
        this.faqSearchDM = platform2.getFAQSearchDM();
        SDKConfigurationDM sDKConfigurationDM = domain2.getSDKConfigurationDM();
        this.sdkConfigurationDM = sDKConfigurationDM;
        this.conversationInboxPoller = new ConversationInboxPoller(userDM2, sDKConfigurationDM, getPoller(), this.conversationDAO);
        this.liveUpdateDM = new LiveUpdateDM(domain2, platform2);
        ConversationManager conversationManager2 = new ConversationManager(platform2, domain2, userDM2);
        this.conversationManager = conversationManager2;
        this.remoteConversationLoader = new RemoteConversationLoader(platform2, domain2, userDM2, conversationManager2);
        this.pollerSyncManager = new PollerSyncManager(domain2, platform2, userDM2, new PollerSyncDataProviderImpl(), this.conversationManager);
    }

    private Network buildForwardPollerNetwork() {
        return new GuardOKNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new AuthenticationFailureNetwork(new POSTNetwork("/conversations/updates/", this.domain, this.platform))), this.platform));
    }

    private RequestData buildForwardPollerRequestData(String str) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        if (!StringUtils.isEmpty(str)) {
            userRequestData.put("cursor", str);
        }
        Conversation lastViewableSyncedConversation = getLastViewableSyncedConversation();
        if (lastViewableSyncedConversation != null) {
            if (!StringUtils.isEmpty(lastViewableSyncedConversation.serverId)) {
                userRequestData.put(AnalyticsEventKey.ISSUE_ID, lastViewableSyncedConversation.serverId);
            } else if (!StringUtils.isEmpty(lastViewableSyncedConversation.preConversationServerId)) {
                userRequestData.put(AnalyticsEventKey.PREISSUE_ID, lastViewableSyncedConversation.preConversationServerId);
            }
        }
        userRequestData.put("ucrm", String.valueOf(this.userCanReadMessages));
        return new RequestData((Map<String, String>) userRequestData);
    }

    private boolean canShowNotificationForConversation(Conversation conversation) {
        Conversation conversation2;
        if (conversation == null || this.userDM.getLocalId().longValue() != conversation.userLocalId || StringUtils.isEmpty(conversation.localUUID)) {
            return false;
        }
        ViewableConversation aliveViewableConversation2 = getAliveViewableConversation();
        if (aliveViewableConversation2 != null && aliveViewableConversation2.isVisibleOnUI()) {
            return false;
        }
        if (aliveViewableConversation2 == null) {
            conversation2 = getActiveConversationFromStorage();
        } else {
            conversation2 = aliveViewableConversation2.getActiveConversation();
        }
        if (conversation2 != null) {
            return conversation.localUUID.equals(conversation2.localUUID);
        }
        return true;
    }

    private void checkAndGenerateNotification() {
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        if (shouldShowInAppNotification(activeConversationFromUIOrStorage)) {
            activeConversationFromUIOrStorage.userLocalId = this.userDM.getLocalId().longValue();
            showInAppNotification(activeConversationFromUIOrStorage, getMessageCountForShowingInAppNotification(activeConversationFromUIOrStorage));
        }
    }

    private void checkAndTryToUploadImage(Conversation conversation, AttachmentPickerFile attachmentPickerFile) {
        if (attachmentPickerFile != null && attachmentPickerFile.filePath != null) {
            try {
                this.conversationManager.sendAttachment(conversation, attachmentPickerFile, (String) null);
            } catch (Exception unused) {
            }
            saveImageAttachmentDraft((AttachmentPickerFile) null);
        }
    }

    private void clearInAppNotificationCountCache() {
        this.inAppNotificationMessageCountMap.clear();
    }

    private void createPreIssue(final Conversation conversation, String str, String str2, List<String> list, StartNewConversationListener startNewConversationListener) {
        One one = this.inProgressPreIssueCreators.get(conversation.localId);
        if (one != null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Pre issue creation already in progress: ");
            outline24.append(conversation.localId);
            HSLogger.m3237d(TAG, outline24.toString());
            ((CreatePreIssueDM) one.getF()).setListener(startNewConversationListener);
            return;
        }
        final One one2 = new One(new CreatePreIssueDM(this, this.conversationManager, conversation, startNewConversationListener, str, str2, list));
        this.inProgressPreIssueCreators.put(conversation.localId, one2);
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    synchronized (ConversationController.fetchConversationUpdatesLock) {
                        one2.mo33949f();
                    }
                    ConversationController.this.inProgressPreIssueCreators.remove(conversation.localId);
                } catch (Throwable th) {
                    ConversationController.this.inProgressPreIssueCreators.remove(conversation.localId);
                    throw th;
                }
            }
        });
    }

    private void deleteConversationsAndMessages() {
        long longValue = this.userDM.getLocalId().longValue();
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(longValue).getData()) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            this.conversationManager.deleteCachedAttachmentFiles(conversation);
        }
        this.conversationDAO.deleteConversations(longValue);
    }

    private void fetchConversationHistory() {
        synchronized (fetchConversationUpdatesLock) {
            this.remoteConversationLoader.loadMoreMessages();
        }
    }

    private ConversationInbox fetchConversationUpdatesInternal(String str, boolean z) {
        ViewableConversation aliveViewableConversation2;
        Network buildForwardPollerNetwork = buildForwardPollerNetwork();
        RequestData buildForwardPollerRequestData = buildForwardPollerRequestData(str);
        try {
            ConversationInbox parseConversationInbox = this.platform.getResponseParser().parseConversationInbox(buildForwardPollerNetwork.makeRequest(buildForwardPollerRequestData).responseString);
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, parseConversationInbox.issueExists);
            if (!buildForwardPollerRequestData.body.containsKey("cursor") && parseConversationInbox.hasOlderMessages != null) {
                this.conversationInboxDAO.saveHasOlderMessages(this.userDM.getLocalId().longValue(), parseConversationInbox.hasOlderMessages.booleanValue());
            }
            try {
                this.pollerSyncManager.sync(parseConversationInbox.conversations, z);
                ViewableConversation aliveViewableConversation3 = getAliveViewableConversation();
                if (aliveViewableConversation3 != null) {
                    aliveViewableConversation3.dispatchPollSuccessCallback();
                }
                if (!this.userDM.isPushTokenSynced() && this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION)) {
                    checkAndGenerateNotification();
                }
                sendUnreadCountUpdate();
                this.conversationInboxDAO.saveConversationInboxTimestamp(this.userDM.getLocalId().longValue(), parseConversationInbox.cursor);
                this.pollSyncExceptionCount = 0;
            } catch (PollerSyncException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Caught poller sync exception: ");
                outline24.append(e.getMessage());
                outline24.append(", Not updating cursor.");
                HSLogger.m3241e(TAG, outline24.toString());
                int i = this.pollSyncExceptionCount + 1;
                this.pollSyncExceptionCount = i;
                if (!z && i >= 10) {
                    HSLogger.m3241e(TAG, "Max poller sync exception limit reached, stopping poller");
                    ViewableConversation aliveViewableConversation4 = getAliveViewableConversation();
                    if (aliveViewableConversation4 != null) {
                        aliveViewableConversation4.dispatchPollFailureCallback();
                    }
                    throw RootAPIException.wrap(e, PollerException.SYNC_FAILURE_MAX_LIMIT_REACHED);
                }
            }
            return parseConversationInbox;
        } catch (RootAPIException e2) {
            ExceptionType exceptionType = e2.exceptionType;
            if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e2.exceptionType);
            } else if ((exceptionType instanceof NetworkException) && (aliveViewableConversation2 = getAliveViewableConversation()) != null && aliveViewableConversation2.isVisibleOnUI()) {
                aliveViewableConversation2.dispatchPollFailureCallback();
            }
            throw e2;
        }
    }

    private Conversation getActiveConversationFromUIOrStorage() {
        ViewableConversation aliveViewableConversation2 = getAliveViewableConversation();
        if (aliveViewableConversation2 != null) {
            return aliveViewableConversation2.getActiveConversation();
        }
        Conversation activeConversationFromStorage = getActiveConversationFromStorage();
        if (activeConversationFromStorage == null) {
            return null;
        }
        activeConversationFromStorage.userLocalId = this.userDM.getLocalId().longValue();
        return activeConversationFromStorage;
    }

    /* access modifiers changed from: private */
    public ViewableConversation getAliveViewableConversation() {
        WeakReference<ViewableConversation> weakReference = this.aliveViewableConversation;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (ViewableConversation) this.aliveViewableConversation.get();
    }

    private String getCampaignDID() {
        ICampaignsModuleAPIs campaignModuleAPIs = this.platform.getCampaignModuleAPIs();
        if (campaignModuleAPIs == null) {
            return null;
        }
        return campaignModuleAPIs.getDeviceIdentifier();
    }

    private String getCampaignUID() {
        ICampaignsModuleAPIs campaignModuleAPIs = this.platform.getCampaignModuleAPIs();
        if (campaignModuleAPIs == null) {
            return null;
        }
        return campaignModuleAPIs.getUserIdentifier();
    }

    private int getInAppNotificationCountCache(String str) {
        Integer num = this.inAppNotificationMessageCountMap.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private Conversation getLastViewableSyncedConversation() {
        ViewableConversation aliveViewableConversation2 = getAliveViewableConversation();
        if (aliveViewableConversation2 == null) {
            return getLastViewableSyncedConversationFromStorage();
        }
        Conversation activeConversation = aliveViewableConversation2.getActiveConversation();
        if (this.conversationManager.isSynced(activeConversation)) {
            return activeConversation;
        }
        return getLastViewableSyncedConversationFromStorage();
    }

    private Conversation getLastViewableSyncedConversationFromStorage() {
        List data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (data.isEmpty()) {
            return null;
        }
        List<Conversation> filter = Filters.filter(data, ConversationPredicates.newSyncedConversationPredicate(this.conversationManager));
        List<Conversation> filter2 = Filters.filter(filter, ConversationPredicates.newInProgressConversationPredicate());
        if (ListUtils.isEmpty(filter)) {
            return null;
        }
        if (filter2.isEmpty()) {
            return ConversationUtil.getLastConversationBasedOnCreatedAt(filter);
        }
        return ConversationUtil.getLastConversationBasedOnCreatedAt(filter2);
    }

    private int getMessageCountForShowingInAppNotification(Conversation conversation) {
        int inAppNotificationCountCache = getInAppNotificationCountCache(conversation.localUUID);
        int unSeenMessageCount = this.conversationManager.getUnSeenMessageCount(conversation);
        if (unSeenMessageCount > 0 && unSeenMessageCount != inAppNotificationCountCache) {
            return unSeenMessageCount;
        }
        return 0;
    }

    private Poller getPoller() {
        return new Poller(this.domain, new C2500F() {
            /* renamed from: f */
            public synchronized void mo33949f() {
                ConversationController.this.fetchConversationUpdates();
            }
        });
    }

    private boolean isAtLeastOneConversationNonActionable(List<Conversation> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (Conversation next : list) {
            next.userLocalId = this.userDM.getLocalId().longValue();
            if (!next.isIssueInProgress()) {
                return true;
            }
        }
        return false;
    }

    private boolean isMessageBoxVisibleInConversationResolutionRejectedState(Conversation conversation, ViewableConversation viewableConversation) {
        ConversationVMCallback conversationVMCallback;
        if (conversation == null || conversation.state != IssueState.RESOLUTION_REJECTED) {
            return false;
        }
        if (viewableConversation != null && (conversationVMCallback = viewableConversation.getConversationVMCallback()) != null) {
            return conversationVMCallback.isMessageBoxVisible();
        }
        boolean persistMessageBox = this.conversationInboxDAO.getPersistMessageBox(this.userDM.getLocalId().longValue());
        String userReplyDraft = this.conversationInboxDAO.getUserReplyDraft(this.userDM.getLocalId().longValue());
        if (persistMessageBox || !StringUtils.isEmpty(userReplyDraft)) {
            return true;
        }
        return false;
    }

    private synchronized void removeInMemoryConversation() {
        this.aliveViewableConversation = null;
    }

    private void retryCallsForConversation(Conversation conversation, boolean z) {
        conversation.userLocalId = this.userDM.getLocalId().longValue();
        if (this.conversationManager.canAutoRetryMessages(conversation)) {
            this.conversationManager.retryMessages(conversation, z);
        }
        if (conversation.csatState == ConversationCSATState.SUBMITTED_NOT_SYNCED) {
            try {
                this.conversationManager.sendCSATSurveyInternal(conversation);
            } catch (RootAPIException e) {
                if (e.exceptionType != NetworkException.NON_RETRIABLE) {
                    throw e;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendUnreadCountUpdate() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<com.helpshift.util.FetchDataFromThread<java.lang.Integer, java.lang.Integer>> r0 = r3.fetchConversationUpdatesListenerReference
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r0.get()
            com.helpshift.util.FetchDataFromThread r0 = (com.helpshift.util.FetchDataFromThread) r0
            if (r0 == 0) goto L_0x0016
            com.helpshift.common.domain.Domain r1 = r3.domain
            com.helpshift.conversation.domainmodel.ConversationController$3 r2 = new com.helpshift.conversation.domainmodel.ConversationController$3
            r2.<init>(r0)
            r1.runOnUI(r2)
        L_0x0016:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.domainmodel.ConversationController.sendUnreadCountUpdate():void");
    }

    private synchronized void setAliveConversation(ViewableConversation viewableConversation) {
        this.aliveViewableConversation = new WeakReference<>(viewableConversation);
    }

    private boolean shouldShowInAppNotification(Conversation conversation) {
        if (this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION)) {
            return canShowNotificationForConversation(conversation);
        }
        return false;
    }

    private void showInAppNotification(Conversation conversation, int i) {
        if (i > 0) {
            showNotificationOnUI(conversation.localId, conversation.localUUID, i, this.platform.getDevice().getAppName(), true);
            updateInAppNotificationCountCache(conversation.localUUID, i);
        }
    }

    private void showNotificationOnUI(Long l, String str, int i, String str2, boolean z) {
        if (i > 0) {
            final Long l2 = l;
            final String str3 = str;
            final int i2 = i;
            final String str4 = str2;
            final boolean z2 = z;
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    ConversationController.this.platform.showNotification(l2, str3, i2, str4, z2);
                }
            });
        }
    }

    private void updateInAppNotificationCountCache(String str, int i) {
        this.inAppNotificationMessageCountMap.put(str, Integer.valueOf(i));
    }

    public void checkAndDropCustomMeta(Conversation conversation) {
        if (this.shouldDropCustomMetadata) {
            this.conversationManager.dropCustomMetaData();
        }
    }

    public void clearNotification(final Conversation conversation) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationController.this.platform.clearNotifications(conversation.localUUID);
            }
        });
        clearInAppNotificationCountCache();
    }

    public void clearPushNotifications() {
        for (Conversation clearNotification : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
            clearNotification(clearNotification);
        }
    }

    public Conversation createConversation(String str, String str2, String str3) {
        this.domain.getUserManagerDM().registerUserWithServer(this.userDM);
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        userRequestData.put("user_provided_emails", this.platform.getJsonifier().jsonify((Collection) Collections.singletonList(str3)).toString());
        userRequestData.put("user_provided_name", str2);
        userRequestData.put("body", str);
        userRequestData.put("cuid", getCampaignUID());
        userRequestData.put("cdid", getCampaignDID());
        userRequestData.put("device_language", this.domain.getLocaleProviderDM().getDefaultLanguage());
        String sDKLanguage = this.domain.getLocaleProviderDM().getSDKLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            userRequestData.put("developer_set_language", sDKLanguage);
        }
        userRequestData.put("meta", this.domain.getMetaDataDM().getMetaInfo().toString());
        boolean z = this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY);
        Object customIssueFieldData = this.domain.getCustomIssueFieldDM().getCustomIssueFieldData();
        if (customIssueFieldData != null) {
            userRequestData.put("custom_fields", customIssueFieldData.toString());
        }
        try {
            Conversation parseReadableConversation = this.platform.getResponseParser().parseReadableConversation(new GuardOKNetwork(new MetaCorrectedNetwork(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new IdempotentNetwork(new POSTNetwork(CREATE_ISSUE_ROUTE, this.domain, this.platform), this.platform, new SuccessOrNonRetriableStatusCodeIdempotentPolicy(), CREATE_ISSUE_ROUTE, CREATE_ISSUE_UNIQUE_MAPPING_KEY)), this.platform), this.platform)).makeRequest(new RequestData((Map<String, String>) userRequestData)).responseString);
            parseReadableConversation.wasFullPrivacyEnabledAtCreation = z;
            parseReadableConversation.userLocalId = this.userDM.getLocalId().longValue();
            if (this.conversationDAO.readConversationWithoutMessages(parseReadableConversation.serverId) == null) {
                this.conversationDAO.insertConversation(parseReadableConversation);
            }
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, true);
            this.domain.getUserManagerDM().sendPushToken();
            this.conversationInboxPoller.startAppPoller(true);
            return parseReadableConversation;
        } catch (RootAPIException e) {
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            }
            throw e;
        }
    }

    public Conversation createLocalPreIssueConversation() {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str = (String) currentAdjustedTimeForStorage.first;
        long longValue = ((Long) currentAdjustedTimeForStorage.second).longValue();
        Conversation conversation = new Conversation("Pre Issue Conversation", IssueState.NEW, str, longValue, str, (String) null, (String) null, IssueType.PRE_ISSUE, UUID.randomUUID().toString());
        conversation.userLocalId = this.userDM.getLocalId().longValue();
        conversation.lastUserActivityTime = System.currentTimeMillis();
        this.conversationDAO.insertPreIssueConversation(conversation);
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_GREETING_MESSAGE);
        if (!StringUtils.isEmpty(string)) {
            AdminMessageDM adminMessageDM = new AdminMessageDM((String) null, string, str, longValue, new Author("", "", Author.AuthorRole.SYSTEM));
            adminMessageDM.conversationLocalId = conversation.localId;
            adminMessageDM.deliveryState = 1;
            adminMessageDM.setDependencies(this.domain, this.platform);
            this.conversationDAO.insertOrUpdateMessage(adminMessageDM);
            conversation.messageDMs.add(adminMessageDM);
        }
        return conversation;
    }

    public void createPreIssueNetwork(Conversation conversation, String str, String str2, List<String> list) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        String name = this.userDM.getName();
        String email = this.userDM.getEmail();
        if (!StringUtils.isEmpty(name)) {
            userRequestData.put("name", name);
        }
        if (!StringUtils.isEmpty(email)) {
            userRequestData.put("email", email);
        }
        userRequestData.put("cuid", getCampaignUID());
        userRequestData.put("cdid", getCampaignDID());
        userRequestData.put("device_language", this.domain.getLocaleProviderDM().getDefaultLanguage());
        String sDKLanguage = this.domain.getLocaleProviderDM().getSDKLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            userRequestData.put("developer_set_language", sDKLanguage);
        }
        userRequestData.put("meta", this.domain.getMetaDataDM().getMetaInfo().toString());
        boolean z = this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY);
        Object customIssueFieldData = this.domain.getCustomIssueFieldDM().getCustomIssueFieldData();
        if (customIssueFieldData != null) {
            userRequestData.put("custom_fields", customIssueFieldData.toString());
        }
        if (StringUtils.isNotEmpty(str)) {
            userRequestData.put("greeting", str);
        }
        if (StringUtils.isNotEmpty(str2)) {
            userRequestData.put("user_message", str2);
        }
        userRequestData.put("is_prefilled", String.valueOf(conversation.isAutoFilledPreIssue));
        if (StringUtils.isNotEmpty(conversation.acid)) {
            userRequestData.put("acid", conversation.acid);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentTreeId)) {
            userRequestData.put("tree_id", conversation.smartIntentTreeId);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentUserQuery)) {
            userRequestData.put(UserDataStore.STATE, conversation.smartIntentUserQuery);
        }
        if (ListUtils.isNotEmpty(conversation.smartIntentIds)) {
            userRequestData.put("intent", this.platform.getJsonifier().jsonifyListToJsonArray(conversation.smartIntentIds).toString());
        }
        if (ListUtils.isNotEmpty(list)) {
            userRequestData.put("intent_labels", this.platform.getJsonifier().jsonifyListToJsonArray(list).toString());
        }
        try {
            Conversation parseReadableConversation = this.platform.getResponseParser().parseReadableConversation(new GuardOKNetwork(new MetaCorrectedNetwork(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new IdempotentNetwork(new POSTNetwork(CREATE_PRE_ISSUE_ROUTE, this.domain, this.platform), this.platform, new SuccessOrNonRetriableStatusCodeIdempotentPolicy(), CREATE_PRE_ISSUE_ROUTE, CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY)), this.platform), this.platform)).makeRequest(new RequestData((Map<String, String>) userRequestData)).responseString);
            if (conversation.serverId == null) {
                conversation.serverId = parseReadableConversation.serverId;
            }
            conversation.issueType = parseReadableConversation.issueType;
            conversation.title = parseReadableConversation.title;
            conversation.setCreatedAt(parseReadableConversation.getCreatedAt());
            conversation.setEpochCreatedAtTime(parseReadableConversation.getEpochCreatedAtTime());
            conversation.updatedAt = parseReadableConversation.updatedAt;
            conversation.publishId = parseReadableConversation.publishId;
            conversation.state = parseReadableConversation.state;
            conversation.wasFullPrivacyEnabledAtCreation = z;
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            conversation.acid = parseReadableConversation.acid;
            conversation.smartIntentIds = parseReadableConversation.smartIntentIds;
            this.conversationDAO.deleteMessagesForConversation(conversation.localId.longValue());
            HSObservableList<MessageDM> hSObservableList = parseReadableConversation.messageDMs;
            conversation.messageDMs = hSObservableList;
            Iterator<E> it = hSObservableList.iterator();
            while (it.hasNext()) {
                MessageDM messageDM = (MessageDM) it.next();
                messageDM.conversationLocalId = conversation.localId;
                if (messageDM instanceof AdminMessageDM) {
                    messageDM.deliveryState = 1;
                } else if (messageDM instanceof UserMessageDM) {
                    messageDM.deliveryState = 2;
                }
            }
            conversation.preConversationServerId = parseReadableConversation.preConversationServerId;
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, true);
            this.domain.getUserManagerDM().sendPushToken();
            this.conversationDAO.updateConversation(conversation);
            if (ListUtils.isNotEmpty(list)) {
                str2 = ListUtils.serializeWithDelimiter(list, ",");
            } else if (!StringUtils.isNotEmpty(str2)) {
                str2 = "";
            }
            this.domain.getDelegate().newConversationStarted(str2);
            if (IssueType.ISSUE.equals(parseReadableConversation.issueType)) {
                HSLogger.m3237d(TAG, "Preissue creation skipped, issue created directly.");
                this.conversationManager.sendConversationPostedEvent(parseReadableConversation);
                return;
            }
            this.conversationManager.sendMessageAddedEventOnPreissueCreation(conversation);
        } catch (RootAPIException e) {
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            }
            throw e;
        }
    }

    public void createPreIssueViaConversationalFlow(Conversation conversation, String str, String str2, StartNewConversationListener startNewConversationListener) {
        createPreIssue(conversation, str, str2, (List<String>) null, startNewConversationListener);
    }

    public void createPreIssueViaSmartIntent(Conversation conversation, String str, String str2, List<String> list, StartNewConversationListener startNewConversationListener) {
        createPreIssue(conversation, str, str2, list, startNewConversationListener);
    }

    public void deleteAllConversationsData() {
        deleteConversationsAndMessages();
        this.conversationInboxDAO.deleteUserData(this.userDM.getLocalId().longValue());
    }

    public void deleteCachedFilesForResolvedConversations() {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationController conversationController = ConversationController.this;
                for (Conversation conversation : conversationController.conversationDAO.readConversationsWithoutMessages(conversationController.userDM.getLocalId().longValue()).getData()) {
                    conversation.userLocalId = ConversationController.this.userDM.getLocalId().longValue();
                    if (!ConversationController.this.conversationManager.shouldOpen(conversation)) {
                        ConversationController.this.conversationManager.deleteCachedAttachmentFiles(conversation);
                    }
                }
            }
        });
    }

    public void executeUserSync() {
        fetchInitialConversationUpdates();
        List data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (!isAtLeastOneConversationNonActionable(data)) {
            int i = 0;
            boolean hasMoreMessage = this.remoteConversationLoader.hasMoreMessage();
            while (!isAtLeastOneConversationNonActionable(data) && hasMoreMessage && i < 3) {
                fetchConversationHistory();
                data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
                hasMoreMessage = this.remoteConversationLoader.hasMoreMessage();
                i++;
            }
        }
    }

    public ConversationInbox fetchConversationUpdates() {
        ConversationInbox fetchConversationUpdatesInternal;
        synchronized (fetchConversationUpdatesLock) {
            fetchConversationUpdatesInternal = fetchConversationUpdatesInternal(this.conversationInboxDAO.getConversationInboxTimestamp(this.userDM.getLocalId().longValue()), false);
        }
        return fetchConversationUpdatesInternal;
    }

    public ValuePair<Integer, Boolean> fetchConversationsAndGetNotificationCount() {
        UserDM userDM2 = this.userDM;
        if (userDM2 == null || !userDM2.issueExists()) {
            return new ValuePair<>(-1, Boolean.TRUE);
        }
        int i = 0;
        if (this.userCanReadMessages) {
            return new ValuePair<>(0, Boolean.TRUE);
        }
        List data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (ListUtils.isEmpty(data)) {
            return new ValuePair<>(0, Boolean.TRUE);
        }
        if (System.currentTimeMillis() - this.kvStore.getLong(LAST_NOTIFCOUNT_FETCH_KEY, 0L).longValue() < (ConversationUtil.shouldPollActivelyForConversations(data) ? ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT : 300000)) {
            return new ValuePair<>(Integer.valueOf(getNotificationCountSync()), Boolean.TRUE);
        }
        this.kvStore.setLong(LAST_NOTIFCOUNT_FETCH_KEY, Long.valueOf(System.currentTimeMillis()));
        fetchConversationUpdates();
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        if (activeConversationFromUIOrStorage != null) {
            i = this.conversationManager.getUnSeenMessageCount(activeConversationFromUIOrStorage);
        }
        return new ValuePair<>(Integer.valueOf(i), Boolean.FALSE);
    }

    public ConversationInbox fetchInitialConversationUpdates() {
        ConversationInbox fetchConversationUpdatesInternal;
        synchronized (fetchConversationUpdatesLock) {
            fetchConversationUpdatesInternal = fetchConversationUpdatesInternal((String) null, true);
        }
        return fetchConversationUpdatesInternal;
    }

    public Conversation getActiveConversationFromStorage() {
        if (!this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION)) {
            ArrayList arrayList = new ArrayList();
            for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
                conversation.userLocalId = this.userDM.getLocalId().longValue();
                if (this.conversationManager.shouldOpen(conversation)) {
                    arrayList.add(conversation);
                }
            }
            if (arrayList.size() > 0) {
                return ConversationUtil.getLastConversationBasedOnCreatedAt(arrayList);
            }
        }
        return null;
    }

    public Conversation getActiveConversationOrPreIssue() {
        Conversation activeConversationFromStorage = getActiveConversationFromStorage();
        return (activeConversationFromStorage != null || !this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.CONVERSATIONAL_ISSUE_FILING)) ? activeConversationFromStorage : createLocalPreIssueConversation();
    }

    public String getConversationArchivalPrefillText() {
        return this.conversationInboxDAO.getConversationArchivalPrefillText(this.userDM.getLocalId().longValue());
    }

    public ConversationDetailDTO getConversationDetail() {
        return this.conversationInboxDAO.getDescriptionDetail(this.userDM.getLocalId().longValue());
    }

    public ConversationInboxPoller getConversationInboxPoller() {
        return this.conversationInboxPoller;
    }

    public ConversationManager getConversationManager() {
        return this.conversationManager;
    }

    public String getEmail() {
        String email = this.conversationInboxDAO.getEmail(this.userDM.getLocalId().longValue());
        return StringUtils.isEmpty(email) ? this.userDM.getEmail() : email;
    }

    public ArrayList getFAQSearchResults(String str) {
        return this.faqSearchDM.getSearchResults(str);
    }

    public AttachmentPickerFile getImageAttachmentDraft() {
        return this.conversationInboxDAO.getImageAttachment(this.userDM.getLocalId().longValue());
    }

    public Long getLastConversationsRedactionTime() {
        return this.conversationInboxDAO.getLastConversationsRedactionTime(this.userDM.getLocalId().longValue());
    }

    public String getName() {
        String name = this.conversationInboxDAO.getName(this.userDM.getLocalId().longValue());
        return StringUtils.isEmpty(name) ? this.userDM.getName() : name;
    }

    public int getNotificationCountSync() {
        Conversation activeConversationFromUIOrStorage;
        int i = 0;
        if (this.userCanReadMessages || (activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage()) == null) {
            return 0;
        }
        int unSeenMessageCount = this.conversationManager.getUnSeenMessageCount(activeConversationFromUIOrStorage);
        PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(activeConversationFromUIOrStorage.localUUID);
        if (pushNotificationData != null) {
            i = pushNotificationData.count;
        }
        return Math.max(unSeenMessageCount, i);
    }

    public Long getOldestConversationCreatedAtTime() {
        return this.conversationDAO.getOldestConversationCreatedAtTime(this.userDM.getLocalId().longValue());
    }

    public Conversation getOpenConversationWithMessages() {
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        ArrayList arrayList = new ArrayList();
        if (data.isEmpty()) {
            return null;
        }
        for (Conversation conversation : data) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            if (conversation.isIssueInProgress()) {
                arrayList.add(conversation);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Conversation lastConversationBasedOnCreatedAt = ConversationUtil.getLastConversationBasedOnCreatedAt(arrayList);
        lastConversationBasedOnCreatedAt.setMessageDMs(this.conversationDAO.readMessages(lastConversationBasedOnCreatedAt.localId.longValue()).getData());
        return lastConversationBasedOnCreatedAt;
    }

    public String getUserReplyText() {
        return this.conversationInboxDAO.getUserReplyDraft(this.userDM.getLocalId().longValue());
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.helpshift.conversation.activeconversation.ViewableConversation] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.helpshift.conversation.activeconversation.ViewableSingleConversation] */
    /* JADX WARNING: type inference failed for: r1v7, types: [com.helpshift.conversation.activeconversation.ViewableConversationHistory] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.helpshift.conversation.activeconversation.ViewableConversationHistory] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.conversation.activeconversation.ViewableConversation getViewableConversation(boolean r9, java.lang.Long r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x004a
            com.helpshift.conversation.activeconversation.ViewableConversation r9 = r8.getAliveViewableConversation()
            if (r9 == 0) goto L_0x0015
            com.helpshift.conversation.activeconversation.ViewableConversation$ConversationType r10 = r9.getType()
            com.helpshift.conversation.activeconversation.ViewableConversation$ConversationType r1 = com.helpshift.conversation.activeconversation.ViewableConversation.ConversationType.SINGLE
            if (r10 != r1) goto L_0x0015
            r8.removeInMemoryConversation()
            goto L_0x0016
        L_0x0015:
            r0 = r9
        L_0x0016:
            if (r0 != 0) goto L_0x0080
            com.helpshift.conversation.loaders.ConversationHistoryLoader r9 = new com.helpshift.conversation.loaders.ConversationHistoryLoader
            com.helpshift.common.platform.Platform r2 = r8.platform
            com.helpshift.account.domainmodel.UserDM r3 = r8.userDM
            com.helpshift.conversation.loaders.RemoteConversationLoader r4 = r8.remoteConversationLoader
            r5 = 100
            r1 = r9
            r1.<init>(r2, r3, r4, r5)
            com.helpshift.conversation.activeconversation.ViewableConversationHistory r0 = new com.helpshift.conversation.activeconversation.ViewableConversationHistory
            com.helpshift.common.platform.Platform r2 = r8.platform
            com.helpshift.common.domain.Domain r3 = r8.domain
            com.helpshift.account.domainmodel.UserDM r4 = r8.userDM
            com.helpshift.conversation.activeconversation.ConversationManager r6 = r8.conversationManager
            r1 = r0
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r0.init()
            java.util.List r9 = r0.getAllConversations()
            boolean r9 = com.helpshift.util.ListUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x0080
            com.helpshift.conversation.activeconversation.model.Conversation r9 = r8.createLocalPreIssueConversation()
            r0.onNewConversationStarted(r9)
            goto L_0x0080
        L_0x004a:
            com.helpshift.conversation.activeconversation.ViewableConversation r9 = r8.getAliveViewableConversation(r10)
            if (r9 == 0) goto L_0x005c
            com.helpshift.conversation.activeconversation.ViewableConversation$ConversationType r1 = r9.getType()
            com.helpshift.conversation.activeconversation.ViewableConversation$ConversationType r2 = com.helpshift.conversation.activeconversation.ViewableConversation.ConversationType.HISTORY
            if (r1 != r2) goto L_0x005c
            r8.removeInMemoryConversation()
            goto L_0x005d
        L_0x005c:
            r0 = r9
        L_0x005d:
            if (r0 != 0) goto L_0x0080
            com.helpshift.conversation.loaders.SingleConversationLoader r9 = new com.helpshift.conversation.loaders.SingleConversationLoader
            com.helpshift.common.platform.Platform r2 = r8.platform
            com.helpshift.account.domainmodel.UserDM r3 = r8.userDM
            com.helpshift.conversation.loaders.RemoteConversationLoader r5 = r8.remoteConversationLoader
            r6 = 100
            r1 = r9
            r4 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            com.helpshift.conversation.activeconversation.ViewableSingleConversation r0 = new com.helpshift.conversation.activeconversation.ViewableSingleConversation
            com.helpshift.common.platform.Platform r2 = r8.platform
            com.helpshift.common.domain.Domain r3 = r8.domain
            com.helpshift.account.domainmodel.UserDM r4 = r8.userDM
            com.helpshift.conversation.activeconversation.ConversationManager r6 = r8.conversationManager
            r1 = r0
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r0.init()
        L_0x0080:
            com.helpshift.conversation.activeconversation.LiveUpdateDM r9 = r8.liveUpdateDM
            r0.setLiveUpdateDM(r9)
            r8.setAliveConversation(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.domainmodel.ConversationController.getViewableConversation(boolean, java.lang.Long):com.helpshift.conversation.activeconversation.ViewableConversation");
    }

    public void handlePushNotification(String str, String str2, String str3) {
        Conversation conversation;
        String str4;
        int i;
        if (IssueType.ISSUE.equals(str)) {
            conversation = this.conversationDAO.readConversationWithoutMessages(str2);
        } else if (IssueType.PRE_ISSUE.equals(str)) {
            conversation = this.conversationDAO.readPreConversationWithoutMessages(str2);
        } else {
            HSLogger.m3241e(TAG, "Cannot handle push for unknown issue type. " + str);
            return;
        }
        if (conversation != null) {
            if (StringUtils.isEmpty(str3)) {
                str3 = this.platform.getDevice().getAppName();
            }
            String str5 = str3;
            PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(conversation.localUUID);
            if (pushNotificationData == null) {
                str4 = str5;
                i = 1;
            } else {
                str4 = pushNotificationData.title;
                i = pushNotificationData.count + 1;
            }
            this.conversationInboxDAO.setPushNotificationData(conversation.localUUID, new PushNotificationData(i, str4));
            if (i > 0 && canShowNotificationForConversation(conversation)) {
                showNotificationOnUI(conversation.localId, conversation.localUUID, i, str5, false);
            }
            sendUnreadCountUpdate();
        }
    }

    public void initialize() {
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.CONVERSATION, this);
        if (this.userDM.getSyncState() == UserSyncStatus.COMPLETED) {
            this.userDM.addObserver(getConversationInboxPoller());
        }
    }

    public boolean isActiveConversationActionable() {
        ViewableConversation aliveViewableConversation2 = getAliveViewableConversation();
        Conversation activeConversation = aliveViewableConversation2 != null ? aliveViewableConversation2.getActiveConversation() : null;
        if (activeConversation == null) {
            activeConversation = getActiveConversationFromStorage();
        }
        return this.conversationManager.isConversationActionable(activeConversation, isMessageBoxVisibleInConversationResolutionRejectedState(activeConversation, aliveViewableConversation2));
    }

    public boolean isCreateConversationInProgress() {
        return this.isCreateConversationInProgress;
    }

    public boolean isPreissueCreationInProgress(long j) {
        return this.inProgressPreIssueCreators.containsKey(Long.valueOf(j));
    }

    public void redactConversations() {
        synchronized (fetchConversationUpdatesLock) {
            deleteConversationsAndMessages();
            if (this.aliveViewableConversation != null) {
                this.aliveViewableConversation.clear();
            }
            this.conversationInboxDAO.resetDataAfterConversationsDeletion(this.userDM.getLocalId().longValue());
        }
    }

    public void registerStartNewConversationListener(StartNewConversationListener startNewConversationListener) {
        this.startNewConversationListenerRef = new WeakReference<>(startNewConversationListener);
    }

    public void resetLastNotificationCountFetchTime() {
        this.kvStore.setLong(LAST_NOTIFCOUNT_FETCH_KEY, 0L);
    }

    public void resetPreIssueConversationsForUser(final UserDM userDM2) {
        HSLogger.m3237d(TAG, "Starting preissues reset.");
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(userDM2.getLocalId().longValue()).getData();
        if (data != null && data.size() != 0) {
            long preissueResetInterval = this.sdkConfigurationDM.getPreissueResetInterval() * 1000;
            for (final Conversation conversation : data) {
                if (conversation.isInPreIssueMode()) {
                    if (System.currentTimeMillis() - conversation.lastUserActivityTime >= preissueResetInterval) {
                        if (StringUtils.isEmpty(conversation.preConversationServerId) && StringUtils.isEmpty(conversation.serverId)) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Deleting offline preissue : ");
                            outline24.append(conversation.localId);
                            HSLogger.m3237d(TAG, outline24.toString());
                            this.conversationDAO.deleteConversation(conversation.localId.longValue());
                            removeInMemoryConversation();
                        } else if (conversation.isIssueInProgress() || conversation.state == IssueState.UNKNOWN) {
                            clearNotification(conversation);
                            this.domain.runParallel(new C2500F() {
                                /* renamed from: f */
                                public void mo33949f() {
                                    Conversation conversation;
                                    try {
                                        HSLogger.m3237d(ConversationController.TAG, "Reseting preissue on backend: " + conversation.preConversationServerId);
                                        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM2);
                                        userRequestData.put("state", String.valueOf(IssueState.REJECTED.getValue()));
                                        new GuardOKNetwork(new TSCorrectedNetwork(new PUTNetwork(ConversationController.CREATE_PRE_ISSUE_ROUTE + conversation.preConversationServerId + "/", ConversationController.this.domain, ConversationController.this.platform), ConversationController.this.platform)).makeRequest(new RequestData((Map<String, String>) userRequestData));
                                        ViewableConversation access$300 = ConversationController.this.getAliveViewableConversation(conversation.localId);
                                        if (access$300 == null) {
                                            conversation = conversation;
                                        } else {
                                            conversation = access$300.getActiveConversation();
                                        }
                                        ConversationController.this.conversationManager.updateIssueStatus(conversation, IssueState.REJECTED);
                                    } catch (RootAPIException e) {
                                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error resetting preissue : ");
                                        outline24.append(conversation.preConversationServerId);
                                        HSLogger.m3242e(ConversationController.TAG, outline24.toString(), e);
                                        throw e;
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public void resetPushNotificationCount(Conversation conversation) {
        this.conversationInboxDAO.setPushNotificationData(conversation.localUUID, (PushNotificationData) null);
        this.domain.getDelegate().didReceiveNotification(0);
    }

    public void saveDescriptionDetail(String str, int i) {
        this.conversationInboxDAO.saveDescriptionDetail(this.userDM.getLocalId().longValue(), new ConversationDetailDTO(str, System.nanoTime(), i));
    }

    public void saveEmail(String str) {
        this.conversationInboxDAO.saveEmail(this.userDM.getLocalId().longValue(), str);
    }

    public void saveImageAttachmentDraft(AttachmentPickerFile attachmentPickerFile) {
        this.conversationInboxDAO.saveImageAttachment(this.userDM.getLocalId().longValue(), attachmentPickerFile);
    }

    public void saveLastConversationsRedactionTime(long j) {
        this.conversationInboxDAO.saveLastConversationsRedactionTime(this.userDM.getLocalId().longValue(), j);
    }

    public void saveName(String str) {
        this.conversationInboxDAO.saveName(this.userDM.getLocalId().longValue(), str);
    }

    public void saveUserReplyText(String str) {
        this.conversationInboxDAO.saveUserReplyDraft(this.userDM.getLocalId().longValue(), str);
    }

    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
            ViewableConversation aliveViewableConversation2 = getAliveViewableConversation(conversation.localId);
            if (aliveViewableConversation2 != null) {
                retryCallsForConversation(aliveViewableConversation2.getActiveConversation(), true);
            } else {
                retryCallsForConversation(conversation, false);
            }
        }
    }

    public void setConversationViewState(int i) {
        this.conversationViewState = i;
    }

    public void setPersistMessageBox(boolean z) {
        this.conversationInboxDAO.savePersistMessageBox(this.userDM.getLocalId().longValue(), z);
    }

    public void setShouldDropCustomMetadata(boolean z) {
        this.shouldDropCustomMetadata = z;
    }

    public void setUserCanReadMessages(boolean z) {
        this.userCanReadMessages = z;
    }

    public boolean shouldOpenConversationFromNotification(long j) {
        Conversation readConversationWithoutMessages;
        ViewableConversation aliveViewableConversation2 = getAliveViewableConversation(Long.valueOf(j));
        if ((aliveViewableConversation2 != null && aliveViewableConversation2.getActiveConversation() != null) || (readConversationWithoutMessages = this.conversationDAO.readConversationWithoutMessages(Long.valueOf(j))) == null) {
            return aliveViewableConversation2 != null && aliveViewableConversation2.shouldOpen();
        }
        readConversationWithoutMessages.userLocalId = this.userDM.getLocalId().longValue();
        return this.conversationManager.shouldOpen(readConversationWithoutMessages);
    }

    public boolean shouldPersistMessageBox() {
        return this.conversationInboxDAO.getPersistMessageBox(this.userDM.getLocalId().longValue());
    }

    public void showPushNotifications() {
        int i;
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
            PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(conversation.localUUID);
            if (pushNotificationData != null && (i = pushNotificationData.count) > 0) {
                showNotificationOnUI(conversation.localId, conversation.localUUID, i, pushNotificationData.title, false);
            }
        }
    }

    public void startNewConversation(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile) {
        this.domain.runParallel(new CreateConversationStateHolder(str, str2, str3, attachmentPickerFile).getStartNewConversationInternalF());
    }

    public void startNewConversationInternal(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile) {
        this.isCreateConversationInProgress = true;
        Conversation tryToStartNewConversation = tryToStartNewConversation(str, str2, str3);
        ViewableSingleConversation viewableSingleConversation = new ViewableSingleConversation(this.platform, this.domain, this.userDM, new SingleConversationLoader(this.platform, this.userDM, tryToStartNewConversation.localId, this.remoteConversationLoader, 100), this.conversationManager);
        viewableSingleConversation.init();
        viewableSingleConversation.setLiveUpdateDM(this.liveUpdateDM);
        setAliveConversation(viewableSingleConversation);
        checkAndTryToUploadImage(viewableSingleConversation.getActiveConversation(), attachmentPickerFile);
        this.isCreateConversationInProgress = false;
        WeakReference<StartNewConversationListener> weakReference = this.startNewConversationListenerRef;
        if (weakReference != null && weakReference.get() != null) {
            ((StartNewConversationListener) this.startNewConversationListenerRef.get()).onCreateConversationSuccess(tryToStartNewConversation.localId.longValue());
        }
    }

    public void triggerFAQSearchIndexing() {
        this.faqSearchDM.startFAQSearchIndexing();
    }

    public Conversation tryToStartNewConversation(String str, String str2, String str3) {
        Conversation createConversation;
        try {
            synchronized (fetchConversationUpdatesLock) {
                createConversation = createConversation(str, str2, str3);
            }
            saveDescriptionDetail("", 0);
            if (!this.sdkConfigurationDM.shouldCreateConversationAnonymously()) {
                saveName(str2);
                saveEmail(str3);
            }
            this.conversationInboxDAO.saveConversationArchivalPrefillText(this.userDM.getLocalId().longValue(), (String) null);
            checkAndDropCustomMeta(createConversation);
            this.conversationManager.sendConversationPostedEvent(createConversation);
            this.domain.getDelegate().newConversationStarted(str);
            return createConversation;
        } catch (Exception e) {
            this.isCreateConversationInProgress = false;
            if (this.startNewConversationListenerRef.get() != null) {
                ((StartNewConversationListener) this.startNewConversationListenerRef.get()).onCreateConversationFailure(e);
            }
            throw e;
        }
    }

    public void unregisterStartNewConversationListener(StartNewConversationListener startNewConversationListener) {
        WeakReference<StartNewConversationListener> weakReference = this.startNewConversationListenerRef;
        if (weakReference != null && weakReference.get() == startNewConversationListener) {
            this.startNewConversationListenerRef = new WeakReference<>((Object) null);
        }
    }

    public void updateActiveConversationExpiryProperties() {
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        if (activeConversationFromUIOrStorage != null) {
            this.conversationManager.updateConversationExpiryProperties(activeConversationFromUIOrStorage);
        }
    }

    /* access modifiers changed from: private */
    public ViewableConversation getAliveViewableConversation(Long l) {
        WeakReference<ViewableConversation> weakReference = this.aliveViewableConversation;
        if (!(weakReference == null || weakReference.get() == null)) {
            ViewableConversation viewableConversation = (ViewableConversation) this.aliveViewableConversation.get();
            if (l.equals(viewableConversation.getActiveConversation().localId)) {
                return viewableConversation;
            }
        }
        return null;
    }
}
