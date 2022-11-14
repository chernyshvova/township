package com.helpshift.conversation.pollersync.listener;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class DBPollerDataChangeListener implements PollerDataChangeListener {
    public static final String TAG = "HS_DBPollChangeListener";
    public ConversationManager conversationManager;
    public PollerSyncDataProvider syncDataProvider;

    public DBPollerDataChangeListener(ConversationManager conversationManager2, PollerSyncDataProvider pollerSyncDataProvider) {
        this.conversationManager = conversationManager2;
        this.syncDataProvider = pollerSyncDataProvider;
    }

    private void checkAndUpdateMessageUnreadCount(Conversation conversation, Conversation conversation2) {
        ViewableConversation aliveViewableConversation = this.syncDataProvider.getAliveViewableConversation();
        if (aliveViewableConversation == null || !aliveViewableConversation.isVisibleOnUI()) {
            IssueState issueState = conversation2.state;
            if (conversation.isIssueInProgress() && (issueState == IssueState.RESOLUTION_REQUESTED || issueState == IssueState.RESOLUTION_ACCEPTED || issueState == IssueState.RESOLUTION_REJECTED || issueState == IssueState.RESOLUTION_EXPIRED)) {
                this.conversationManager.setShouldIncrementMessageCount(conversation2, true, true);
            } else if (conversation2.isIssueInProgress()) {
                this.conversationManager.setShouldIncrementMessageCount(conversation2, false, true);
            }
        }
    }

    private void checkToReopenConversation(Conversation conversation, RequestForReopenMessageDM requestForReopenMessageDM) {
        boolean z;
        String str;
        Conversation activeConversationFromStorage = this.syncDataProvider.getActiveConversationFromStorage();
        int currentConversationViewState = this.syncDataProvider.getCurrentConversationViewState();
        if (activeConversationFromStorage == null) {
            str = null;
        } else if (activeConversationFromStorage.isInPreIssueMode()) {
            str = null;
            z = true;
            this.conversationManager.checkAndReopen(conversation, requestForReopenMessageDM, currentConversationViewState, str, z);
        } else {
            str = activeConversationFromStorage.serverId;
        }
        z = false;
        this.conversationManager.checkAndReopen(conversation, requestForReopenMessageDM, currentConversationViewState, str, z);
    }

    private RequestForReopenMessageDM getRfrMessage(List<MessageDM> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            MessageDM messageDM = list.get(size);
            if (messageDM instanceof RequestForReopenMessageDM) {
                return (RequestForReopenMessageDM) messageDM;
            }
        }
        return null;
    }

    private void onCSATStateChanged(Conversation conversation, Conversation conversation2) {
        if (conversation2.csatState == ConversationCSATState.EXPIRED && conversation.csatState != ConversationCSATState.SUBMITTED_SYNCED) {
            this.conversationManager.sendCSATExpiryEvent(conversation2);
        }
    }

    private void onIssueDirectlyCreatedFromPreIssue(Conversation conversation) {
        HSLogger.m3237d(TAG, "Preissue creation skipped, issue created directly - idempotent case.");
        this.conversationManager.sendConversationPostedEvent(conversation);
    }

    private void onPreIssueCreated(Conversation conversation) {
        HSLogger.m3237d(TAG, "Preissue created from poller response");
        this.conversationManager.handlePreIssueCreationSuccess(conversation);
    }

    private void onStateChanged(Conversation conversation, Conversation conversation2) {
        IssueState issueState = conversation2.state;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("State changed for issue from ");
        outline24.append(conversation.state);
        outline24.append(" to: ");
        outline24.append(issueState);
        HSLogger.m3237d(TAG, outline24.toString());
        if (issueState == IssueState.COMPLETED_ISSUE_CREATED) {
            this.conversationManager.sendConversationPostedEvent(conversation2);
        } else if (issueState == IssueState.RESOLUTION_ACCEPTED) {
            if (conversation.isIssueInProgress() && !conversation.isInPreIssueMode()) {
                this.conversationManager.sendConfirmationAcceptedMessageAndDelegates(conversation2);
            }
            this.conversationManager.handleConversationEnded(conversation2);
        } else if (issueState == IssueState.RESOLUTION_EXPIRED) {
            this.conversationManager.sendResolutionQuestionExpiryEvent(conversation2);
            this.conversationManager.handleConversationEnded(conversation2);
        } else if (issueState == IssueState.REJECTED || issueState == IssueState.CLOSED) {
            this.conversationManager.handleConversationEnded(conversation2);
        }
        checkAndUpdateMessageUnreadCount(conversation, conversation2);
    }

    public void onConversationUpdated(Conversation conversation, Conversation conversation2) {
        HSLogger.m3237d(TAG, "onConversationUpdated called");
        if (conversation.state != conversation2.state) {
            onStateChanged(conversation, conversation2);
        }
        if (conversation.csatState != conversation2.csatState) {
            onCSATStateChanged(conversation, conversation2);
        }
        String pendingRequestIdForPreissue = this.syncDataProvider.getPendingRequestIdForPreissue();
        if (StringUtils.isEmpty(conversation.preConversationServerId) && pendingRequestIdForPreissue != null && pendingRequestIdForPreissue.equals(conversation2.createdRequestId)) {
            if (conversation2.isInPreIssueMode()) {
                onPreIssueCreated(conversation2);
            } else {
                onIssueDirectlyCreatedFromPreIssue(conversation2);
            }
        }
    }

    public void onMessagesAdded(Conversation conversation, List<MessageDM> list) {
        RequestForReopenMessageDM rfrMessage;
        if (!ListUtils.isEmpty(list)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("onMessagesAdded called with size: ");
            outline24.append(list.size());
            HSLogger.m3237d(TAG, outline24.toString());
            MessageDM messageDM = list.get(list.size() - 1);
            if (messageDM instanceof RequestForReopenMessageDM) {
                RequestForReopenMessageDM requestForReopenMessageDM = (RequestForReopenMessageDM) messageDM;
                if (!requestForReopenMessageDM.isAnswered()) {
                    checkToReopenConversation(conversation, requestForReopenMessageDM);
                }
            } else if (conversation.isFeedbackBotEnabled && conversation.state == IssueState.RESOLUTION_REQUESTED && (rfrMessage = getRfrMessage(list)) != null && !rfrMessage.isAnswered()) {
                checkToReopenConversation(conversation, rfrMessage);
            }
        }
    }

    public void onMessagesUpdated(List<MessageDM> list, List<MessageDM> list2) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("onMessagesUpdated called with size: ");
        outline24.append(list2.size());
        HSLogger.m3237d(TAG, outline24.toString());
        ArrayList arrayList = new ArrayList();
        for (MessageDM next : list2) {
            if (next.isRedacted) {
                if (next instanceof AttachmentMessageDM) {
                    arrayList.add(next);
                } else if (next instanceof AdminActionCardMessageDM) {
                    arrayList.add(next);
                }
            }
        }
        this.conversationManager.clearRedactedAttachmentsResources(arrayList);
    }
}
