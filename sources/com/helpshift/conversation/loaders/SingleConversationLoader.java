package com.helpshift.conversation.loaders;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.ListUtils;
import java.util.Iterator;
import java.util.List;

public class SingleConversationLoader extends ConversationsLoader {
    public Long activeConversationId;
    public boolean isActiveConversationFullyFetched = false;
    public Platform platform;
    public UserDM userDM;

    public SingleConversationLoader(Platform platform2, UserDM userDM2, Long l, RemoteConversationLoader remoteConversationLoader, long j) {
        super(platform2, new SingleConversationDBLoader(platform2.getConversationDAO(), l), remoteConversationLoader, j);
        this.platform = platform2;
        this.userDM = userDM2;
        this.activeConversationId = l;
    }

    public boolean hasMoreMessages() {
        if (this.isActiveConversationFullyFetched) {
            return false;
        }
        if (this.conversationDBLoader.hasMoreMessages()) {
            return true;
        }
        List<Conversation> data = this.platform.getConversationDAO().readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (!ListUtils.isEmpty(data)) {
            long j = 0;
            Iterator it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Conversation conversation = (Conversation) it.next();
                if (conversation.localId.equals(this.activeConversationId)) {
                    j = conversation.getEpochCreatedAtTime();
                    break;
                }
            }
            for (Conversation conversation2 : data) {
                if (!conversation2.localId.equals(this.activeConversationId) && j > conversation2.getEpochCreatedAtTime()) {
                    this.isActiveConversationFullyFetched = true;
                    return false;
                }
            }
        }
        return this.remoteConversationLoader.hasMoreMessage();
    }
}
