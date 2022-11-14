package com.helpshift.conversation.activeconversation.message;

public class SystemRedactedConversationMessageDM extends SystemMessageDM {
    public int contiguousRedactedConversationsCount;

    public SystemRedactedConversationMessageDM(String str, long j, int i) {
        super("", str, j, MessageType.SYSTEM_CONVERSATION_REDACTED);
        this.contiguousRedactedConversationsCount = i;
    }

    public SystemRedactedConversationMessageDM(SystemRedactedConversationMessageDM systemRedactedConversationMessageDM) {
        super(systemRedactedConversationMessageDM);
        this.contiguousRedactedConversationsCount = systemRedactedConversationMessageDM.contiguousRedactedConversationsCount;
    }

    public SystemRedactedConversationMessageDM deepClone() {
        return new SystemRedactedConversationMessageDM(this);
    }
}
