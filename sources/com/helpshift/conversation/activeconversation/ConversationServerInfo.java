package com.helpshift.conversation.activeconversation;

public interface ConversationServerInfo {
    String getAnalyticConversationId();

    String getIssueId();

    String getPreIssueId();

    boolean isInPreIssueMode();
}
