package com.helpshift.conversation.loaders;

import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class ConversationDBLoader {
    public ConversationDAO conversationDAO;
    public boolean hasMoreMessages = true;

    public ConversationDBLoader(ConversationDAO conversationDAO2) {
        this.conversationDAO = conversationDAO2;
    }

    public int compareEpochTime(long j, long j2) {
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public abstract List<Conversation> fetchMessages(String str, String str2, long j);

    public List<MessageDM> filterMessages(String str, long j, List<MessageDM> list) {
        if (ListUtils.isEmpty(list) || j < 1) {
            return new ArrayList();
        }
        ConversationUtil.sortMessagesBasedOnCreatedAt(list);
        if (!StringUtils.isEmpty(str)) {
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(str);
            ArrayList arrayList = new ArrayList();
            for (MessageDM next : list) {
                if (convertToEpochTime <= next.getEpochCreatedAtTime()) {
                    break;
                }
                arrayList.add(next);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return new ArrayList();
            }
            list = arrayList;
        }
        int size = list.size();
        return list.subList(Math.max(0, (int) (((long) size) - j)), size);
    }

    public boolean hasMoreMessages() {
        return this.hasMoreMessages;
    }

    public void setHasMoreMessages(boolean z) {
        this.hasMoreMessages = z;
    }
}
