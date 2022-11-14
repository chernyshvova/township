package com.helpshift.conversation.activeconversation.message;

public class AdminBotControlMessageDM extends AdminMessageDM {
    public String actionType;
    public String botInfo;
    public boolean hasNextBot;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminBotControlMessageDM(String str, String str2, String str3, long j, Author author, String str4, String str5) {
        super(str, str2, str3, j, author, MessageType.ADMIN_BOT_CONTROL);
        this.actionType = str4;
        this.botInfo = str5;
    }

    public boolean isUISupportedMessage() {
        return false;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof AdminBotControlMessageDM) {
            AdminBotControlMessageDM adminBotControlMessageDM = (AdminBotControlMessageDM) messageDM;
            this.actionType = adminBotControlMessageDM.actionType;
            this.botInfo = adminBotControlMessageDM.botInfo;
        }
    }

    public AdminBotControlMessageDM(AdminBotControlMessageDM adminBotControlMessageDM) {
        super(adminBotControlMessageDM);
        this.actionType = adminBotControlMessageDM.actionType;
        this.botInfo = adminBotControlMessageDM.botInfo;
        this.hasNextBot = adminBotControlMessageDM.hasNextBot;
    }

    public AdminBotControlMessageDM deepClone() {
        return new AdminBotControlMessageDM(this);
    }
}
