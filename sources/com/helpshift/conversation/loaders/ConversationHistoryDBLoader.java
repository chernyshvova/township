package com.helpshift.conversation.loaders;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConversationHistoryDBLoader extends ConversationDBLoader {
    public UserDM userDM;

    public ConversationHistoryDBLoader(UserDM userDM2, ConversationDAO conversationDAO) {
        super(conversationDAO);
        this.userDM = userDM2;
    }

    private List<Conversation> filterOutConversationCreatedAfterCursor(String str, List<Conversation> list) {
        if (ListUtils.isEmpty(list) || StringUtils.isEmpty(str)) {
            return list;
        }
        long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(str);
        ArrayList arrayList = new ArrayList();
        for (Conversation next : list) {
            if (compareEpochTime(next.getEpochCreatedAtTime(), convertToEpochTime) > 0) {
                break;
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private List<Conversation> filterOutConversationsForWhichMessagesLimitExceed(long j, List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : list) {
            arrayList.add(conversation.localId);
        }
        Map<Long, Integer> messagesCountForConversations = this.conversationDAO.getMessagesCountForConversations(arrayList);
        int i = 0;
        ArrayList arrayList2 = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Conversation conversation2 = list.get(size);
            int intValue = messagesCountForConversations.get(conversation2.localId).intValue();
            arrayList2.add(conversation2);
            i += intValue;
            if (((long) i) >= j) {
                break;
            }
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private List<Conversation> filterOutFullPrivacyEnabledConversations(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation = list.get(i);
            if (!conversation.wasFullPrivacyEnabledAtCreation) {
                arrayList.add(conversation);
            }
        }
        return arrayList;
    }

    private List<Conversation> filterOutMultipleOpenConversations(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (Conversation next : list) {
            if (!next.isIssueInProgress()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<Conversation> filterOutRejectedEmptyPreIssues(List<Conversation> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Conversation next : list) {
            if (next.state == IssueState.REJECTED && IssueType.PRE_ISSUE.equals(next.issueType)) {
                arrayList2.add(next.localId);
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList.addAll(list);
            return arrayList;
        }
        Map<Long, Integer> userMessageCountForConversationLocalIds = ConversationUtil.getUserMessageCountForConversationLocalIds(this.conversationDAO, arrayList2);
        for (Conversation next2 : list) {
            Integer num = userMessageCountForConversationLocalIds.get(next2.localId);
            if (num == null || num.intValue() != 0) {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    private Conversation getLastOpenConversation(List<Conversation> list) {
        Conversation conversation = null;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        for (Conversation next : list) {
            if (next.isIssueInProgress()) {
                conversation = next;
            }
        }
        return conversation;
    }

    public List<Conversation> fetchMessages(String str, String str2, long j) {
        List<Conversation> list;
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (data.isEmpty()) {
            return new ArrayList();
        }
        ConversationUtil.sortConversationsBasedOnCreatedAt(data);
        boolean isEmpty = StringUtils.isEmpty(str);
        ArrayList arrayList = new ArrayList();
        if (!isEmpty) {
            data = filterOutConversationCreatedAfterCursor(str, data);
            if (!ListUtils.isEmpty(data)) {
                Conversation conversation = data.get(data.size() - 1);
                if (conversation.getCreatedAt().equals(str)) {
                    List<MessageDM> filterMessages = filterMessages(str2, j, this.conversationDAO.readMessages(conversation.localId.longValue()).getData());
                    if (!ListUtils.isEmpty(filterMessages)) {
                        conversation.setMessageDMs(filterMessages);
                        arrayList.add(conversation);
                        j -= (long) filterMessages.size();
                    }
                    data.remove(conversation);
                }
            }
        }
        if (j < 1) {
            return arrayList;
        }
        if (isEmpty) {
            int size = data.size();
            if (size > 1) {
                int i = size - 1;
                data = filterOutFullPrivacyEnabledConversations(data.subList(0, i));
                data.add(data.get(i));
            }
        } else {
            data = filterOutFullPrivacyEnabledConversations(data);
        }
        List<Conversation> filterOutRejectedEmptyPreIssues = filterOutRejectedEmptyPreIssues(data);
        if (isEmpty) {
            Conversation lastOpenConversation = getLastOpenConversation(filterOutRejectedEmptyPreIssues);
            list = filterOutMultipleOpenConversations(filterOutRejectedEmptyPreIssues);
            if (lastOpenConversation != null) {
                list.add(lastOpenConversation);
            }
        } else {
            list = filterOutMultipleOpenConversations(filterOutRejectedEmptyPreIssues);
        }
        List<Conversation> filterOutConversationsForWhichMessagesLimitExceed = filterOutConversationsForWhichMessagesLimitExceed(j, list);
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Conversation next : filterOutConversationsForWhichMessagesLimitExceed) {
            arrayList2.add(next.localId);
            hashMap.put(next.localId, next);
        }
        for (MessageDM next2 : this.conversationDAO.readMessagesForConversations(arrayList2)) {
            if (hashMap.containsKey(next2.conversationLocalId)) {
                ((Conversation) hashMap.get(next2.conversationLocalId)).messageDMs.add(next2);
            }
        }
        int i2 = 0;
        for (int size2 = filterOutConversationsForWhichMessagesLimitExceed.size() - 1; size2 >= 0; size2--) {
            Conversation conversation2 = filterOutConversationsForWhichMessagesLimitExceed.get(size2);
            if (((long) (conversation2.messageDMs.size() + i2)) > j) {
                ConversationUtil.sortMessagesBasedOnCreatedAt(conversation2.messageDMs);
                ArrayList arrayList3 = new ArrayList(conversation2.messageDMs);
                conversation2.messageDMs.clear();
                conversation2.messageDMs.addAll(arrayList3.subList(arrayList3.size() - ((int) (j - ((long) i2))), arrayList3.size()));
            } else {
                i2 += conversation2.messageDMs.size();
            }
        }
        arrayList.addAll(0, filterOutConversationsForWhichMessagesLimitExceed);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConversationUtil.sortMessagesBasedOnCreatedAt(((Conversation) it.next()).messageDMs);
        }
        return arrayList;
    }
}
