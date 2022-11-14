package com.helpshift.conversation.activeconversation.message;

import java.util.ArrayList;
import java.util.List;

public class UserSmartIntentMessageDM extends UserMessageDM {
    public List<String> intentLabels;

    public UserSmartIntentMessageDM(List<String> list, String str, long j, Author author) {
        super("", str, j, author, MessageType.USER_SMART_INTENT);
        this.intentLabels = list;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof UserSmartIntentMessageDM) {
            this.intentLabels = ((UserSmartIntentMessageDM) messageDM).intentLabels;
        }
    }

    public UserSmartIntentMessageDM(UserSmartIntentMessageDM userSmartIntentMessageDM) {
        super(userSmartIntentMessageDM);
        this.intentLabels = new ArrayList(userSmartIntentMessageDM.intentLabels);
    }

    public UserSmartIntentMessageDM deepClone() {
        return new UserSmartIntentMessageDM(this);
    }
}
