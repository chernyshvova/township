package com.helpshift.conversation.activeconversation;

public class PaginationCursor {
    public final String conversationCursor;
    public final String messageCursor;

    public PaginationCursor(String str, String str2) {
        this.conversationCursor = str;
        this.messageCursor = str2;
    }
}
