package com.helpshift.conversation.pollersync.model;

import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesLookup {
    public final Map<String, MessageDM> lookupByRequestId = new HashMap();
    public final Map<String, MessageDM> lookupByServerId = new HashMap();

    public MessagesLookup(Conversation conversation, List<MessageDM> list, PollerSyncDataProvider pollerSyncDataProvider) {
        populateLookup(pollerSyncDataProvider, conversation, list);
    }

    private void populateLookup(PollerSyncDataProvider pollerSyncDataProvider, Conversation conversation, List<MessageDM> list) {
        if (!ListUtils.isEmpty(list)) {
            Map<String, String> messagesLocalIdToPendingRequestIdMap = pollerSyncDataProvider.getMessagesLocalIdToPendingRequestIdMap(conversation);
            for (MessageDM next : list) {
                if (!StringUtils.isEmpty(next.serverId)) {
                    this.lookupByServerId.put(next.serverId, next);
                }
                Long l = next.localId;
                if (l != null) {
                    String valueOf = String.valueOf(l);
                    if (messagesLocalIdToPendingRequestIdMap != null && messagesLocalIdToPendingRequestIdMap.containsKey(valueOf)) {
                        this.lookupByRequestId.put(messagesLocalIdToPendingRequestIdMap.get(valueOf), next);
                    }
                }
            }
        }
    }

    public MessageDM find(MessageDM messageDM) {
        String str = messageDM.serverId;
        String str2 = messageDM.createdRequestId;
        if (this.lookupByServerId.containsKey(str)) {
            return this.lookupByServerId.get(str);
        }
        if (this.lookupByRequestId.containsKey(str2)) {
            return this.lookupByRequestId.get(str2);
        }
        return null;
    }
}
