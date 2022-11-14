package com.helpshift.conversation.activeconversation.message;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.message.input.TextInput;

public class AdminMessageWithTextInputDM extends AdminMessageDM {
    public TextInput input;
    public final boolean isMessageEmpty;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminMessageWithTextInputDM(String str, String str2, String str3, long j, Author author, String str4, String str5, boolean z, String str6, String str7, int i, boolean z2) {
        super(str, str2, str3, j, author, MessageType.ADMIN_TEXT_WITH_TEXT_INPUT);
        this.input = new TextInput(str4, z, str6, str7, str5, i);
        this.isMessageEmpty = z2;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof AdminMessageWithTextInputDM) {
            this.input = ((AdminMessageWithTextInputDM) messageDM).input;
        }
    }

    public void setDependencies(Domain domain, Platform platform) {
        super.setDependencies(domain, platform);
        this.input.setDependencies(domain);
    }

    public AdminMessageWithTextInputDM(AdminMessageWithTextInputDM adminMessageWithTextInputDM) {
        super(adminMessageWithTextInputDM);
        this.isMessageEmpty = adminMessageWithTextInputDM.isMessageEmpty;
        this.input = adminMessageWithTextInputDM.input.deepClone();
    }

    public AdminMessageWithTextInputDM deepClone() {
        return new AdminMessageWithTextInputDM(this);
    }
}
