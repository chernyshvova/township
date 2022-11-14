package com.helpshift.conversation.loaders;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.platform.Platform;

public class ConversationHistoryLoader extends ConversationsLoader {
    public ConversationHistoryLoader(Platform platform, UserDM userDM, RemoteConversationLoader remoteConversationLoader, long j) {
        super(platform, new ConversationHistoryDBLoader(userDM, platform.getConversationDAO()), remoteConversationLoader, j);
    }

    public boolean hasMoreMessages() {
        return this.conversationDBLoader.hasMoreMessages() || this.remoteConversationLoader.hasMoreMessage();
    }
}
