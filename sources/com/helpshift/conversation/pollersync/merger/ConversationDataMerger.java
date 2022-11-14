package com.helpshift.conversation.pollersync.merger;

import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;

public class ConversationDataMerger {
    public static final String TAG = "HS_PollConvDataMerger";
    public Platform platform;
    public SDKConfigurationDM sdkConfigurationDM;

    public ConversationDataMerger(Platform platform2, SDKConfigurationDM sDKConfigurationDM) {
        this.platform = platform2;
        this.sdkConfigurationDM = sDKConfigurationDM;
    }

    private boolean canMergeConversationProperties(String str, String str2) {
        if (!IssueType.ISSUE.equals(str) || !IssueType.PRE_ISSUE.equals(str2)) {
            return true;
        }
        HSLogger.m3237d(TAG, "Not merging conversation data since remote type is preissue and local type is issue");
        return false;
    }

    private void mergeCommonConversationProperties(Conversation conversation, Conversation conversation2) {
        HSLogger.m3237d(TAG, "Merging conversation properties");
        conversation.preConversationServerId = conversation2.preConversationServerId;
        conversation.serverId = conversation2.serverId;
        conversation.issueType = conversation2.issueType;
        conversation.title = conversation2.title;
        conversation.publishId = conversation2.publishId;
        conversation.createdAt = conversation2.createdAt;
        conversation.epochCreatedAtTime = conversation2.getEpochCreatedAtTime();
        conversation.updatedAt = conversation2.updatedAt;
        conversation.shouldIncrementMessageCount = conversation2.shouldIncrementMessageCount;
        conversation.shouldAllowNewConversationCreation = conversation2.shouldAllowNewConversationCreation;
        conversation.isFeedbackBotEnabled = conversation2.isFeedbackBotEnabled;
        String str = conversation2.messageCursor;
        if (str != null) {
            conversation.messageCursor = str;
        }
        if (!StringUtils.isEmpty(conversation2.createdRequestId)) {
            conversation.createdRequestId = conversation2.createdRequestId;
        }
        conversation.state = getIssueStateToUpdate(conversation, conversation2);
    }

    private void mergeIssueUniqueProperties(Conversation conversation, Conversation conversation2) {
        conversation.isRedacted = conversation2.isRedacted;
        conversation.resolutionExpiryAt = conversation2.resolutionExpiryAt;
        conversation.csatExpiryAt = conversation2.csatExpiryAt;
        ConversationCSATState conversationCSATState = conversation2.csatState;
        if (conversationCSATState == ConversationCSATState.SUBMITTED_SYNCED) {
            conversation.csatState = conversationCSATState;
        } else if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            conversation.csatState = ConversationCSATState.EXPIRED;
        }
    }

    public IssueState getIssueStateToUpdate(Conversation conversation, Conversation conversation2) {
        IssueState issueState = conversation.state;
        IssueState issueState2 = conversation2.state;
        String str = conversation2.issueType;
        if (conversation2.shouldAllowNewConversationCreation) {
            return IssueState.CLOSED;
        }
        if (conversation2.isFeedbackBotEnabled) {
            return (issueState2 != IssueState.RESOLUTION_REQUESTED || !IssueType.PRE_ISSUE.equals(str)) ? issueState2 : IssueState.RESOLUTION_ACCEPTED;
        }
        if (issueState2 == IssueState.RESOLUTION_REQUESTED) {
            if (IssueType.PRE_ISSUE.equals(str)) {
                issueState2 = IssueState.RESOLUTION_ACCEPTED;
            } else {
                if (!(issueState == IssueState.RESOLUTION_ACCEPTED || issueState == IssueState.RESOLUTION_EXPIRED)) {
                    if (ConversationUtil.isResolutionQuestionExpired(this.platform, conversation2)) {
                        issueState2 = IssueState.RESOLUTION_EXPIRED;
                    } else if (issueState != IssueState.RESOLUTION_REJECTED) {
                        if (!this.sdkConfigurationDM.shouldShowConversationResolutionQuestion()) {
                            issueState2 = IssueState.RESOLUTION_ACCEPTED;
                        }
                    }
                }
                issueState2 = issueState;
            }
        }
        HSLogger.m3237d(TAG, "Updating conversation state from " + issueState + " to: " + issueState2);
        return issueState2;
    }

    public void mergeProperties(Conversation conversation, Conversation conversation2) {
        if (canMergeConversationProperties(conversation.issueType, conversation2.issueType)) {
            mergeCommonConversationProperties(conversation, conversation2);
            if (!conversation2.isInPreIssueMode()) {
                mergeIssueUniqueProperties(conversation, conversation2);
            }
        }
    }
}
