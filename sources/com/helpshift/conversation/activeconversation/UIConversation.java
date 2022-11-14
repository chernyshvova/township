package com.helpshift.conversation.activeconversation;

import com.helpshift.conversation.dto.IssueState;

public class UIConversation {
    public final String createdAt;
    public final long epochCreateTime;
    public final int index;
    public final boolean isInPreIssueMode;
    public final boolean isRedacted;
    public final IssueState issueState;
    public final long localID;
    public final String publishId;

    public UIConversation(long j, int i, String str, long j2, String str2, boolean z, IssueState issueState2, boolean z2) {
        this.localID = j;
        this.index = i;
        this.createdAt = str;
        this.publishId = str2;
        this.isInPreIssueMode = z;
        this.issueState = issueState2;
        this.isRedacted = z2;
        this.epochCreateTime = j2;
    }
}
