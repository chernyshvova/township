package com.helpshift.conversation.pollersync.merger;

import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.pollersync.model.MessagesDiff;
import com.helpshift.conversation.pollersync.model.MessagesLookup;
import com.helpshift.util.CloneUtil;
import java.util.ArrayList;
import java.util.List;

public class MessagesDataMerger {
    public PollerSyncDataProvider syncDataProvider;

    public MessagesDataMerger(PollerSyncDataProvider pollerSyncDataProvider) {
        this.syncDataProvider = pollerSyncDataProvider;
    }

    private void deriveMessagePropertiesForNewMessages(Conversation conversation, MessageDM messageDM) {
        messageDM.conversationLocalId = conversation.localId;
    }

    private void mergeProperties(MessageDM messageDM, MessageDM messageDM2) {
        messageDM.merge(messageDM2);
    }

    public MessagesDiff mergeMessages(Conversation conversation, List<MessageDM> list, List<MessageDM> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<T> deepClone = CloneUtil.deepClone(list);
        MessagesLookup messagesLookup = new MessagesLookup(conversation, list, this.syncDataProvider);
        for (MessageDM next : list2) {
            MessageDM find = messagesLookup.find(next);
            if (find == null) {
                deriveMessagePropertiesForNewMessages(conversation, next);
                arrayList.add(next);
            } else {
                mergeProperties(find, next);
                arrayList2.add(find);
            }
        }
        return new MessagesDiff(deepClone, arrayList, arrayList2);
    }
}
