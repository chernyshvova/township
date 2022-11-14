package com.helpshift.conversation.activeconversation;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.LiveUpdateDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.loaders.ConversationsLoader;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.util.HSListObserver;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ViewableConversation implements ConversationDMListener, LiveUpdateDM.TypingIndicatorListener, ConversationsLoader.LoadMoreConversationsCallback {
    public ConversationsLoader conversationLoader;
    public ConversationManager conversationManager;
    public ConversationVMCallback conversationVMCallback;
    public Domain domain;
    public AtomicBoolean isLoadMoreInProgress = new AtomicBoolean(false);
    public LiveUpdateDM liveUpdateDM;
    public Platform platform;
    public SDKConfigurationDM sdkConfigurationDM;
    public UserDM userDM;

    /* renamed from: com.helpshift.conversation.activeconversation.ViewableConversation$1 */
    public static /* synthetic */ class C25391 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$MessageType */
        public static final /* synthetic */ int[] f3335x18a4a544;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.MessageType[] r0 = com.helpshift.conversation.activeconversation.message.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3335x18a4a544 = r0
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_IMAGE_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 11
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f3335x18a4a544     // Catch:{ NoSuchFieldError -> 0x0019 }
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 10
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.activeconversation.ViewableConversation.C25391.<clinit>():void");
        }
    }

    public enum ConversationType {
        HISTORY,
        SINGLE
    }

    public ViewableConversation(Platform platform2, Domain domain2, UserDM userDM2, ConversationsLoader conversationsLoader, ConversationManager conversationManager2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.conversationLoader = conversationsLoader;
        this.sdkConfigurationDM = domain2.getSDKConfigurationDM();
        this.conversationManager = conversationManager2;
    }

    private Conversation getConversationForLocalId(long j) {
        for (Conversation next : getAllConversations()) {
            if (next.localId.equals(Long.valueOf(j))) {
                return next;
            }
        }
        return null;
    }

    public PaginationCursor buildPaginationCursor(Conversation conversation) {
        String str;
        if (conversation == null) {
            return null;
        }
        String createdAt = conversation.getCreatedAt();
        List list = conversation.messageDMs;
        if (!ListUtils.isEmpty(list)) {
            return new PaginationCursor(createdAt, ((MessageDM) list.get(0)).getCreatedAt());
        }
        if (conversation.isRedacted || !this.conversationManager.isSynced(conversation)) {
            return new PaginationCursor(createdAt, createdAt);
        }
        DAOResult<List<MessageDM>> readMessages = this.platform.getConversationDAO().readMessages(conversation.localId.longValue());
        if (readMessages != null && readMessages.isSuccess()) {
            list = readMessages.getData();
        }
        if (ListUtils.isEmpty(list)) {
            str = createdAt;
        } else {
            ConversationUtil.sortMessagesBasedOnCreatedAt(list);
            int size = list.size() - 1;
            int i = size;
            while (true) {
                if (i < 0) {
                    break;
                } else if (((MessageDM) list.get(i)).isFeedbackMessage) {
                    i--;
                } else if (i < size) {
                    str = ((MessageDM) list.get(i + 1)).getCreatedAt();
                }
            }
            str = "";
        }
        if (StringUtils.isEmpty(str)) {
            str = createdAt;
        }
        return new PaginationCursor(createdAt, str);
    }

    public void dispatchPollFailureCallback() {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onConversationInboxPollFailure();
        }
    }

    public void dispatchPollSuccessCallback() {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onConversationInboxPollSuccess();
        }
    }

    public abstract Conversation getActiveConversation();

    public abstract List<Conversation> getAllConversations();

    public ConversationVMCallback getConversationVMCallback() {
        return this.conversationVMCallback;
    }

    public abstract PaginationCursor getPaginationCursor();

    public abstract ConversationType getType();

    public List<UIConversation> getUIConversations() {
        List<Conversation> allConversations = getAllConversations();
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(allConversations)) {
            return arrayList;
        }
        int size = allConversations.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation = allConversations.get(i);
            arrayList.add(new UIConversation(conversation.localId.longValue(), i, conversation.getCreatedAt(), conversation.getEpochCreatedAtTime(), conversation.publishId, conversation.isInPreIssueMode(), conversation.state, conversation.isRedacted));
        }
        return arrayList;
    }

    public void handleIdempotentPreIssueCreationSuccess() {
        if (this.conversationVMCallback != null) {
            init();
            this.conversationVMCallback.handleIdempotentPreIssueCreationSuccess();
        }
    }

    public boolean hasMoreMessages() {
        return this.conversationLoader.hasMoreMessages();
    }

    public abstract void init();

    public abstract void initializeConversationsForUI();

    public boolean isActiveConversationEqual(Conversation conversation) {
        Conversation activeConversation;
        if (conversation == null || (activeConversation = getActiveConversation()) == null) {
            return false;
        }
        if (activeConversation == conversation) {
            return true;
        }
        if (!StringUtils.isEmpty(activeConversation.serverId)) {
            return activeConversation.serverId.equals(conversation.serverId);
        }
        if (!StringUtils.isEmpty(activeConversation.preConversationServerId)) {
            return activeConversation.preConversationServerId.equals(conversation.preConversationServerId);
        }
        return false;
    }

    public boolean isAgentTyping() {
        LiveUpdateDM liveUpdateDM2 = this.liveUpdateDM;
        return liveUpdateDM2 != null && liveUpdateDM2.isAgentTyping() && this.sdkConfigurationDM.shouldEnableTypingIndicator();
    }

    public boolean isConversationVMAttached() {
        return this.conversationVMCallback != null;
    }

    public boolean isVisibleOnUI() {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        return conversationVMCallback2 != null && conversationVMCallback2.isVisibleOnUI();
    }

    public void loadMoreMessages() {
        if (this.isLoadMoreInProgress.compareAndSet(false, true)) {
            this.conversationLoader.loadMoreConversations(getPaginationCursor(), this);
        }
    }

    public void loading() {
        this.isLoadMoreInProgress.set(false);
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onHistoryLoadingStarted();
        }
    }

    public void onActionCardMessageClicked(AdminActionCardMessageDM adminActionCardMessageDM) {
        adminActionCardMessageDM.handleClick(getConversationForLocalId(adminActionCardMessageDM.conversationLocalId.longValue()));
    }

    public void onAdminAttachmentMessageClicked(AttachmentMessageDM attachmentMessageDM) {
        int ordinal = attachmentMessageDM.messageType.ordinal();
        if (ordinal == 10) {
            ((AdminAttachmentMessageDM) attachmentMessageDM).handleClick(this.conversationVMCallback);
        } else if (ordinal == 11) {
            ((AdminImageAttachmentMessageDM) attachmentMessageDM).handleClick(this.conversationVMCallback);
        }
    }

    public void onAgentTypingUpdate(boolean z) {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onAgentTypingUpdate(z);
        }
    }

    public void onError() {
        this.isLoadMoreInProgress.set(false);
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onHistoryLoadingError();
        }
    }

    public void onIssueStatusChange(IssueState issueState) {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onIssueStatusChange(issueState);
        }
    }

    public abstract void onNewConversationStarted(Conversation conversation);

    public void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM) {
        screenshotMessageDM.handleClick(this.conversationVMCallback);
    }

    public void onSuccess(List<Conversation> list, boolean z) {
        ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
        if (conversationVMCallback2 != null) {
            conversationVMCallback2.onHistoryLoadingSuccess();
        }
        if (ListUtils.isEmpty(list)) {
            this.isLoadMoreInProgress.set(false);
            ConversationVMCallback conversationVMCallback3 = this.conversationVMCallback;
            if (conversationVMCallback3 != null) {
                conversationVMCallback3.prependConversations(new ArrayList(), z);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Conversation next : list) {
            next.userLocalId = this.userDM.getLocalId().longValue();
            this.conversationManager.initializeHistoryMessageListForUI(next, isActiveConversationEqual(next) && this.conversationManager.shouldEnableMessagesClick(getActiveConversation()));
            arrayList.add(next);
        }
        prependConversations(arrayList);
        ConversationVMCallback conversationVMCallback4 = this.conversationVMCallback;
        if (conversationVMCallback4 != null) {
            conversationVMCallback4.prependConversations(arrayList, z);
        }
        this.isLoadMoreInProgress.set(false);
    }

    public void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM) {
        userAttachmentMessageDM.handleClick(this.conversationVMCallback);
    }

    public abstract void prependConversations(List<Conversation> list);

    public abstract void registerMessagesObserver(HSListObserver<MessageDM> hSListObserver);

    public void setConversationVMCallback(ConversationVMCallback conversationVMCallback2) {
        this.conversationVMCallback = conversationVMCallback2;
        getActiveConversation().setListener(this);
    }

    public void setLiveUpdateDM(LiveUpdateDM liveUpdateDM2) {
        this.liveUpdateDM = liveUpdateDM2;
    }

    public abstract boolean shouldOpen();

    public void startLiveUpdates() {
        Conversation activeConversation = getActiveConversation();
        if (this.liveUpdateDM != null && !activeConversation.isInPreIssueMode() && this.sdkConfigurationDM.shouldEnableTypingIndicator()) {
            this.liveUpdateDM.registerListener(this, activeConversation.serverId);
        }
    }

    public void stopLiveUpdates() {
        LiveUpdateDM liveUpdateDM2 = this.liveUpdateDM;
        if (liveUpdateDM2 != null) {
            liveUpdateDM2.unregisterListener();
        }
    }

    public void unregisterConversationVMCallback() {
        this.conversationVMCallback = null;
        getActiveConversation().setListener((ConversationDMListener) null);
    }
}
