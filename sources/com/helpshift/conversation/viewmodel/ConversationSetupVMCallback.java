package com.helpshift.conversation.viewmodel;

import com.helpshift.conversation.domainmodel.ConversationSetupDM;

public interface ConversationSetupVMCallback {
    void onConversationSetupStateUpdate(ConversationSetupDM.ConversationSetupState conversationSetupState);
}
