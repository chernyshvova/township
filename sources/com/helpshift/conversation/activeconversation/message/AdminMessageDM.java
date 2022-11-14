package com.helpshift.conversation.activeconversation.message;

public class AdminMessageDM extends MessageDM {
    public AdminMessageDM(String str, String str2, String str3, long j, Author author) {
        super(str2, str3, j, author, true, MessageType.ADMIN_TEXT);
        this.serverId = str;
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public AdminMessageDM(String str, String str2, String str3, long j, Author author, MessageType messageType) {
        super(str2, str3, j, author, true, messageType);
        this.serverId = str;
    }

    public AdminMessageDM deepClone() {
        return new AdminMessageDM(this);
    }

    public AdminMessageDM(AdminMessageDM adminMessageDM) {
        super(adminMessageDM);
    }
}
