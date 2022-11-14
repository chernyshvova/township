package com.helpshift.conversation.activeconversation.model;

import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.ConversationDMListener;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSCloneable;
import com.helpshift.util.HSObservableList;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Conversation implements Observer, ConversationServerInfo, HSCloneable {
    public String acid;
    public ConversationDMListener conversationDMListener;
    public String createdAt;
    public String createdRequestId;
    public Long csatExpiryAt;
    public String csatFeedback;
    public int csatRating;
    public ConversationCSATState csatState = ConversationCSATState.NONE;
    public boolean enableMessageClickOnResolutionRejected;
    public long epochCreatedAtTime;
    public boolean isAutoFilledPreIssue;
    public boolean isConversationEndedDelegateSent;
    public boolean isFeedbackBotEnabled;
    public boolean isInBetweenBotExecution;
    public boolean isRedacted;
    public boolean isStartNewConversationClicked;
    public String issueType;
    public long lastUserActivityTime;
    public Long localId;
    public String localUUID;
    public String messageCursor;
    public HSObservableList<MessageDM> messageDMs = new HSObservableList<>();
    public String preConversationServerId;
    public String publishId;
    public Long resolutionExpiryAt;
    public String serverId;
    public boolean shouldAllowNewConversationCreation;
    public boolean shouldIncrementMessageCount;
    public List<String> smartIntentIds;
    public String smartIntentTreeId;
    public String smartIntentUserQuery;
    public IssueState state;
    public String title;
    public final Map<String, RequestForReopenMessageDM> unansweredRequestForReopenMessageDMs;
    public String updatedAt;
    public long userLocalId;
    public boolean wasFullPrivacyEnabledAtCreation;

    public Conversation(String str, IssueState issueState, String str2, long j, String str3, String str4, String str5, String str6, String str7) {
        this.title = str;
        this.createdAt = str2;
        this.epochCreatedAtTime = j;
        this.updatedAt = str3;
        this.publishId = str4;
        this.messageCursor = str5;
        this.state = issueState;
        this.issueType = str6;
        this.acid = str7;
        this.unansweredRequestForReopenMessageDMs = new HashMap();
    }

    private void updateStateBasedOnMessages() {
        HSObservableList<MessageDM> hSObservableList;
        if (this.state == IssueState.RESOLUTION_REQUESTED && (hSObservableList = this.messageDMs) != null && hSObservableList.size() > 0) {
            MessageDM messageDM = null;
            for (int size = this.messageDMs.size() - 1; size >= 0; size--) {
                messageDM = (MessageDM) this.messageDMs.get(size);
                if (!(messageDM instanceof FollowupRejectedMessageDM) && !(messageDM instanceof RequestForReopenMessageDM)) {
                    break;
                }
            }
            if (messageDM instanceof ConfirmationAcceptedMessageDM) {
                this.state = IssueState.RESOLUTION_ACCEPTED;
            } else if (messageDM instanceof ConfirmationRejectedMessageDM) {
                this.state = IssueState.RESOLUTION_REJECTED;
            }
        }
    }

    public String getAnalyticConversationId() {
        return this.acid;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public long getEpochCreatedAtTime() {
        return this.epochCreatedAtTime;
    }

    public String getIssueId() {
        return this.serverId;
    }

    public String getPreIssueId() {
        return this.preConversationServerId;
    }

    public boolean isInPreIssueMode() {
        return IssueType.PRE_ISSUE.equals(this.issueType);
    }

    public boolean isIssueInProgress() {
        return ConversationUtil.isInProgressState(this.state);
    }

    public boolean isLocalPreIssue() {
        return StringUtils.isEmpty(this.preConversationServerId) && StringUtils.isEmpty(this.serverId);
    }

    public void registerMessagesObserver() {
        Iterator<E> it = this.messageDMs.iterator();
        while (it.hasNext()) {
            ((MessageDM) it.next()).addObserver(this);
        }
    }

    public void setCreatedAt(String str) {
        if (!StringUtils.isEmpty(str)) {
            this.createdAt = str;
        }
    }

    public void setEpochCreatedAtTime(long j) {
        this.epochCreatedAtTime = j;
    }

    public void setListener(ConversationDMListener conversationDMListener2) {
        this.conversationDMListener = conversationDMListener2;
    }

    public void setLocalId(long j) {
        this.localId = Long.valueOf(j);
        Iterator<E> it = this.messageDMs.iterator();
        while (it.hasNext()) {
            ((MessageDM) it.next()).conversationLocalId = this.localId;
        }
    }

    public void setMessageDMs(List<MessageDM> list) {
        this.messageDMs = new HSObservableList<>(list);
        updateStateBasedOnMessages();
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof MessageDM) {
            MessageDM messageDM = (MessageDM) observable;
            this.messageDMs.setAndNotifyObserver(this.messageDMs.indexOf(messageDM), messageDM);
        }
    }

    public Conversation deepClone() {
        return new Conversation(this);
    }

    public Conversation(Conversation conversation) {
        this.localId = conversation.localId;
        this.serverId = conversation.serverId;
        this.preConversationServerId = conversation.preConversationServerId;
        this.localUUID = conversation.localUUID;
        this.title = conversation.title;
        this.state = conversation.state;
        this.issueType = conversation.issueType;
        this.acid = conversation.acid;
        this.smartIntentIds = conversation.smartIntentIds;
        this.smartIntentTreeId = conversation.smartIntentTreeId;
        this.smartIntentUserQuery = conversation.smartIntentUserQuery;
        this.updatedAt = conversation.updatedAt;
        this.publishId = conversation.publishId;
        this.messageCursor = conversation.messageCursor;
        this.shouldIncrementMessageCount = conversation.shouldIncrementMessageCount;
        this.isConversationEndedDelegateSent = conversation.isConversationEndedDelegateSent;
        this.csatState = conversation.csatState;
        this.csatRating = conversation.csatRating;
        this.csatFeedback = conversation.csatFeedback;
        this.isStartNewConversationClicked = conversation.isStartNewConversationClicked;
        this.userLocalId = conversation.userLocalId;
        this.lastUserActivityTime = conversation.lastUserActivityTime;
        this.createdRequestId = conversation.createdRequestId;
        this.wasFullPrivacyEnabledAtCreation = conversation.wasFullPrivacyEnabledAtCreation;
        this.isRedacted = conversation.isRedacted;
        this.isInBetweenBotExecution = conversation.isInBetweenBotExecution;
        this.createdAt = conversation.createdAt;
        this.epochCreatedAtTime = conversation.epochCreatedAtTime;
        this.enableMessageClickOnResolutionRejected = conversation.enableMessageClickOnResolutionRejected;
        this.conversationDMListener = conversation.conversationDMListener;
        this.isAutoFilledPreIssue = conversation.isAutoFilledPreIssue;
        this.unansweredRequestForReopenMessageDMs = CloneUtil.deepClone(conversation.unansweredRequestForReopenMessageDMs);
        this.resolutionExpiryAt = conversation.resolutionExpiryAt;
        this.csatExpiryAt = conversation.csatExpiryAt;
        this.messageDMs = CloneUtil.deepClone(conversation.messageDMs);
        this.isFeedbackBotEnabled = conversation.isFeedbackBotEnabled;
        this.shouldAllowNewConversationCreation = conversation.shouldAllowNewConversationCreation;
    }
}
