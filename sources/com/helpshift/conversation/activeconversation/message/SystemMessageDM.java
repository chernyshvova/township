package com.helpshift.conversation.activeconversation.message;

import com.helpshift.conversation.activeconversation.message.Author;
import com.swrve.sdk.ISwrveCommon;

public class SystemMessageDM extends MessageDM {
    public SystemMessageDM(String str, String str2, long j, MessageType messageType) {
        super(str, str2, j, new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.SYSTEM), false, messageType);
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public SystemMessageDM(SystemMessageDM systemMessageDM) {
        super(systemMessageDM);
    }

    public SystemMessageDM deepClone() {
        return new SystemMessageDM(this);
    }
}
