package com.helpshift.conversation.pollersync.listener;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.util.List;

public class IMPollerDataChangeListener implements PollerDataChangeListener {
    public static final String TAG = "HS_IMPollChangeListener";
    public ConversationManager conversationManager;
    public Domain domain;
    public Platform platform;
    public PollerSyncDataProvider syncDataProvider;

    public IMPollerDataChangeListener(Domain domain2, Platform platform2, ConversationManager conversationManager2, PollerSyncDataProvider pollerSyncDataProvider) {
        this.domain = domain2;
        this.platform = platform2;
        this.conversationManager = conversationManager2;
        this.syncDataProvider = pollerSyncDataProvider;
    }

    private void addDependenciesOnNewMessages(Conversation conversation, List<MessageDM> list) {
        for (MessageDM next : list) {
            next.setDependencies(this.domain, this.platform);
            if (next instanceof UserMessageDM) {
                ((UserMessageDM) next).setState(UserMessageState.SENT);
            } else if (next instanceof ScreenshotMessageDM) {
                ((ScreenshotMessageDM) next).setState(UserMessageState.SENT);
            } else if (next instanceof UserAttachmentMessageDM) {
                ((UserAttachmentMessageDM) next).setState(UserAttachmentMessageDM.UserGenericAttachmentState.SENT);
            }
            next.addObserver(conversation);
        }
    }

    private ViewableConversation getAliveViewableConversation() {
        return this.syncDataProvider.getAliveViewableConversation();
    }

    private void initializeMessagesForActiveConversation(Conversation conversation, List<MessageDM> list) {
        ConversationUtil.sortMessagesBasedOnCreatedAt(list);
        conversation.isInBetweenBotExecution = this.conversationManager.evaluateBotExecutionState(list, conversation.isInBetweenBotExecution);
        conversation.messageDMs.addAll(list);
        for (MessageDM next : list) {
            if (next instanceof AdminImageAttachmentMessageDM) {
                ((AdminImageAttachmentMessageDM) next).downloadThumbnailImage(this.platform);
            } else if (next instanceof RequestScreenshotMessageDM) {
                ((RequestScreenshotMessageDM) next).setAttachmentButtonClickable(this.conversationManager.shouldEnableMessagesClick(conversation));
            } else if (next instanceof AdminActionCardMessageDM) {
                ((AdminActionCardMessageDM) next).downloadImage(this.platform);
            }
            this.conversationManager.updateAcceptedRequestForReopenMessageDMs(conversation, next);
        }
    }

    private void onPreIssueCreated() {
        HSLogger.m3237d(TAG, "Preissue created from poller response");
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null) {
            aliveViewableConversation.handleIdempotentPreIssueCreationSuccess();
        }
    }

    private void onPreIssueToIssueConversion() {
        HSLogger.m3237d(TAG, "Preissue converted to issue");
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null) {
            aliveViewableConversation.startLiveUpdates();
        }
    }

    private void onStateChangedForIssue(Conversation conversation, Conversation conversation2) {
        IssueState issueState = conversation.state;
        IssueState issueState2 = conversation2.state;
        HSLogger.m3237d(TAG, "State changed for issue from " + issueState + " to: " + issueState2);
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null) {
            this.conversationManager.updateMessagesOnIssueStatusUpdate(conversation2);
            boolean z = true;
            boolean z2 = conversation2.isIssueInProgress() && conversation.isIssueInProgress();
            if (issueState != IssueState.COMPLETED_ISSUE_CREATED) {
                z = false;
            }
            if (z || !z2) {
                aliveViewableConversation.onIssueStatusChange(issueState2);
            }
        }
    }

    private void onStateChangedForPreIssue(Conversation conversation) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("State changed for preissue to: ");
        outline24.append(conversation.state);
        HSLogger.m3237d(TAG, outline24.toString());
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null) {
            IssueState issueState = conversation.state;
            this.conversationManager.updateMessagesOnIssueStatusUpdate(conversation);
            aliveViewableConversation.onIssueStatusChange(issueState);
        }
    }

    public void onConversationUpdated(Conversation conversation, Conversation conversation2) {
        HSLogger.m3237d(TAG, "onConversationUpdated called");
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation == null) {
            HSLogger.m3237d(TAG, "No in-memory conversation found for updates, hence returning!");
        } else if (!aliveViewableConversation.isActiveConversationEqual(conversation2)) {
            HSLogger.m3237d(TAG, "Updates received for different conversation than in-memory, hence returning!");
        } else {
            String pendingRequestIdForPreissue = this.syncDataProvider.getPendingRequestIdForPreissue();
            if (StringUtils.isEmpty(conversation.preConversationServerId) && pendingRequestIdForPreissue != null && pendingRequestIdForPreissue.equals(conversation2.createdRequestId) && conversation2.isInPreIssueMode()) {
                onPreIssueCreated();
            }
            if (conversation.isInPreIssueMode() && !conversation2.isInPreIssueMode()) {
                onPreIssueToIssueConversion();
            }
            if (conversation.state == conversation2.state) {
                return;
            }
            if (conversation2.isInPreIssueMode()) {
                onStateChangedForPreIssue(conversation2);
            } else {
                onStateChangedForIssue(conversation, conversation2);
            }
        }
    }

    public void onMessagesAdded(Conversation conversation, List<MessageDM> list) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("onMessagesAdded called with size: ");
        outline24.append(list.size());
        HSLogger.m3237d(TAG, outline24.toString());
        addDependenciesOnNewMessages(conversation, list);
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation == null || !aliveViewableConversation.isActiveConversationEqual(conversation)) {
            conversation.messageDMs.addAll(list);
        } else {
            initializeMessagesForActiveConversation(conversation, list);
        }
        this.conversationManager.evaluateBotControlMessages(conversation, list);
    }

    public void onMessagesUpdated(List<MessageDM> list, List<MessageDM> list2) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("onMessagesUpdated called with size: ");
        outline24.append(list2.size());
        HSLogger.m3237d(TAG, outline24.toString());
        for (MessageDM next : list2) {
            if (next instanceof UserMessageDM) {
                ((UserMessageDM) next).setState(UserMessageState.SENT);
            } else if (next instanceof ScreenshotMessageDM) {
                ((ScreenshotMessageDM) next).setState(UserMessageState.SENT);
            } else if (next instanceof UserAttachmentMessageDM) {
                ((UserAttachmentMessageDM) next).setState(UserAttachmentMessageDM.UserGenericAttachmentState.SENT);
            } else {
                next.notifyUpdated();
            }
        }
    }
}
