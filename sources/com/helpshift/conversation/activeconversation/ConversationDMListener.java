package com.helpshift.conversation.activeconversation;

import com.helpshift.conversation.dto.IssueState;

public interface ConversationDMListener {
    void onIssueStatusChange(IssueState issueState);
}
