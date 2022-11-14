package com.helpshift.common.platform;

import android.content.Context;
import com.helpshift.common.conversation.ConversationDB;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.conversation.activeconversation.ConversationUpdate;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dao.FAQSuggestionsDAO;
import com.helpshift.conversation.pollersync.model.MessagesDiff;
import com.helpshift.support.Faq;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AndroidConversationDAO implements ConversationDAO, FAQSuggestionsDAO {
    public final String TAG = "Helpshift_CnDAO";
    public final ConversationDB conversationDB;

    public AndroidConversationDAO(Context context) {
        this.conversationDB = ConversationDB.getInstance(context);
    }

    public synchronized void deleteConversation(long j) {
        if (j != 0) {
            this.conversationDB.deleteConversationWithLocalId(j);
        }
    }

    public void deleteConversations(long j) {
        if (j > 0) {
            this.conversationDB.deleteConversations(j);
        }
    }

    public boolean deleteMessagesForConversation(long j) {
        return this.conversationDB.deleteMessagesForConversation(j);
    }

    public void dropAndCreateDatabase() {
        this.conversationDB.dropAndCreateDatabase();
    }

    public Object getFAQ(String str, String str2) {
        return this.conversationDB.getAdminFAQSuggestion(str, str2);
    }

    public synchronized Map<Long, Integer> getMessagesCountForConversations(List<Long> list) {
        return this.conversationDB.getMessagesCountForConversations(list, (String[]) null);
    }

    public Long getOldestConversationCreatedAtTime(long j) {
        return this.conversationDB.getOldestConversationEpochCreatedAtTime(j);
    }

    public String getOldestMessageCursor(long j) {
        return this.conversationDB.getOldestMessageCursor(j);
    }

    public void insertConversation(Conversation conversation) {
        String str = conversation.serverId;
        String str2 = conversation.preConversationServerId;
        if (str != null || str2 != null) {
            if (conversation.localUUID == null) {
                conversation.localUUID = UUID.randomUUID().toString();
            }
            long insertConversation = this.conversationDB.insertConversation(conversation);
            if (insertConversation != -1) {
                conversation.setLocalId(insertConversation);
            }
            insertOrUpdateMessages(conversation.messageDMs);
        }
    }

    public boolean insertConversations(List<Conversation> list) {
        if (list.size() == 0) {
            return true;
        }
        for (Conversation next : list) {
            if (next.localUUID == null) {
                next.localUUID = UUID.randomUUID().toString();
            }
        }
        DAOResult<List<Long>> insertConversations = this.conversationDB.insertConversations(list);
        if (!insertConversations.isSuccess()) {
            return false;
        }
        List data = insertConversations.getData();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            long longValue = ((Long) data.get(i)).longValue();
            Conversation conversation = list.get(i);
            if (longValue == -1) {
                hashSet.add(conversation);
            } else {
                conversation.setLocalId(longValue);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Conversation next2 : list) {
            if (!hashSet.contains(next2)) {
                arrayList.addAll(next2.messageDMs);
            }
        }
        return insertOrUpdateMessages(arrayList);
    }

    public void insertOrUpdateFAQ(Object obj) {
        this.conversationDB.insertOrUpdateAdminFAQSuggestion((Faq) obj);
    }

    public synchronized void insertOrUpdateMessage(MessageDM messageDM) {
        Long l = messageDM.localId;
        String str = messageDM.serverId;
        if (l == null && str == null) {
            long insertMessage = this.conversationDB.insertMessage(messageDM);
            if (insertMessage != -1) {
                messageDM.localId = Long.valueOf(insertMessage);
            }
        } else if (l == null && str != null) {
            MessageDM data = this.conversationDB.readMessageWithServerId(str).getData();
            if (data == null) {
                long insertMessage2 = this.conversationDB.insertMessage(messageDM);
                if (insertMessage2 != -1) {
                    messageDM.localId = Long.valueOf(insertMessage2);
                }
            } else {
                messageDM.localId = data.localId;
                this.conversationDB.updateMessage(messageDM);
            }
        } else if (this.conversationDB.readMessageWithLocalId(l).getData() == null) {
            long insertMessage3 = this.conversationDB.insertMessage(messageDM);
            if (insertMessage3 != -1) {
                messageDM.localId = Long.valueOf(insertMessage3);
            }
        } else {
            this.conversationDB.updateMessage(messageDM);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0075, code lost:
        r9 = r8.conversationDB.insertMessages(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
        if (r9.isSuccess() != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0082, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r9 = r9.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        if (r3 >= r0.size()) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
        r4 = ((java.lang.Long) r9.get(r3)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009d, code lost:
        if (r4 != -1) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        ((com.helpshift.conversation.activeconversation.message.MessageDM) r0.get(r3)).localId = java.lang.Long.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ac, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b6, code lost:
        return r8.conversationDB.updateMessages(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean insertOrUpdateMessages(java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r9.size()     // Catch:{ all -> 0x00b7 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00b7 }
            r0.<init>()     // Catch:{ all -> 0x00b7 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00b7 }
            r1.<init>()     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x00b7 }
        L_0x0018:
            boolean r2 = r9.hasNext()     // Catch:{ all -> 0x00b7 }
            r3 = 0
            if (r2 == 0) goto L_0x0075
            java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x00b7 }
            com.helpshift.conversation.activeconversation.message.MessageDM r2 = (com.helpshift.conversation.activeconversation.message.MessageDM) r2     // Catch:{ all -> 0x00b7 }
            java.lang.Long r4 = r2.localId     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = r2.serverId     // Catch:{ all -> 0x00b7 }
            if (r4 != 0) goto L_0x0031
            if (r5 != 0) goto L_0x0031
            r0.add(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0018
        L_0x0031:
            if (r4 != 0) goto L_0x0057
            if (r5 == 0) goto L_0x0057
            com.helpshift.common.conversation.ConversationDB r4 = r8.conversationDB     // Catch:{ all -> 0x00b7 }
            com.helpshift.common.dao.DAOResult r4 = r4.readMessageWithServerId(r5)     // Catch:{ all -> 0x00b7 }
            boolean r5 = r4.isSuccess()     // Catch:{ all -> 0x00b7 }
            if (r5 != 0) goto L_0x0043
            monitor-exit(r8)
            return r3
        L_0x0043:
            java.lang.Object r3 = r4.getData()     // Catch:{ all -> 0x00b7 }
            com.helpshift.conversation.activeconversation.message.MessageDM r3 = (com.helpshift.conversation.activeconversation.message.MessageDM) r3     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x004f
            r0.add(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0018
        L_0x004f:
            java.lang.Long r3 = r3.localId     // Catch:{ all -> 0x00b7 }
            r2.localId = r3     // Catch:{ all -> 0x00b7 }
            r1.add(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0018
        L_0x0057:
            com.helpshift.common.conversation.ConversationDB r5 = r8.conversationDB     // Catch:{ all -> 0x00b7 }
            com.helpshift.common.dao.DAOResult r4 = r5.readMessageWithLocalId(r4)     // Catch:{ all -> 0x00b7 }
            boolean r5 = r4.isSuccess()     // Catch:{ all -> 0x00b7 }
            if (r5 != 0) goto L_0x0065
            monitor-exit(r8)
            return r3
        L_0x0065:
            java.lang.Object r3 = r4.getData()     // Catch:{ all -> 0x00b7 }
            com.helpshift.conversation.activeconversation.message.MessageDM r3 = (com.helpshift.conversation.activeconversation.message.MessageDM) r3     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x0071
            r0.add(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0018
        L_0x0071:
            r1.add(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0018
        L_0x0075:
            com.helpshift.common.conversation.ConversationDB r9 = r8.conversationDB     // Catch:{ all -> 0x00b7 }
            com.helpshift.common.dao.DAOResult r9 = r9.insertMessages(r0)     // Catch:{ all -> 0x00b7 }
            boolean r2 = r9.isSuccess()     // Catch:{ all -> 0x00b7 }
            if (r2 != 0) goto L_0x0083
            monitor-exit(r8)
            return r3
        L_0x0083:
            java.lang.Object r9 = r9.getData()     // Catch:{ all -> 0x00b7 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ all -> 0x00b7 }
        L_0x0089:
            int r2 = r0.size()     // Catch:{ all -> 0x00b7 }
            if (r3 >= r2) goto L_0x00af
            java.lang.Object r2 = r9.get(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x00b7 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x00b7 }
            r6 = -1
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00a0
            goto L_0x00ac
        L_0x00a0:
            java.lang.Object r2 = r0.get(r3)     // Catch:{ all -> 0x00b7 }
            com.helpshift.conversation.activeconversation.message.MessageDM r2 = (com.helpshift.conversation.activeconversation.message.MessageDM) r2     // Catch:{ all -> 0x00b7 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00b7 }
            r2.localId = r4     // Catch:{ all -> 0x00b7 }
        L_0x00ac:
            int r3 = r3 + 1
            goto L_0x0089
        L_0x00af:
            com.helpshift.common.conversation.ConversationDB r9 = r8.conversationDB     // Catch:{ all -> 0x00b7 }
            boolean r9 = r9.updateMessages(r1)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r8)
            return r9
        L_0x00b7:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00bb
        L_0x00ba:
            throw r9
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidConversationDAO.insertOrUpdateMessages(java.util.List):boolean");
    }

    public synchronized void insertPreIssueConversation(Conversation conversation) {
        if (conversation.localUUID == null) {
            conversation.localUUID = UUID.randomUUID().toString();
        }
        long insertConversation = this.conversationDB.insertConversation(conversation);
        if (insertConversation != -1) {
            conversation.setLocalId(insertConversation);
        }
    }

    public synchronized Conversation readConversation(long j) {
        Conversation readConversationWithLocalId = this.conversationDB.readConversationWithLocalId(Long.valueOf(j));
        if (readConversationWithLocalId == null) {
            return null;
        }
        readConversationWithLocalId.setMessageDMs(this.conversationDB.readMessages(j).getData());
        return readConversationWithLocalId;
    }

    public synchronized Conversation readConversationWithoutMessages(String str) {
        return this.conversationDB.readConversationWithServerId(str);
    }

    public synchronized DAOResult<List<Conversation>> readConversationsWithoutMessages(long j) {
        return this.conversationDB.readConversationsWithLocalId(j);
    }

    public MessageDM readMessage(String str) {
        return this.conversationDB.readMessageWithServerId(str).getData();
    }

    public synchronized DAOResult<List<MessageDM>> readMessages(long j) {
        return this.conversationDB.readMessages(j);
    }

    public List<MessageDM> readMessagesForConversations(List<Long> list) {
        return this.conversationDB.readMessagesForConversations(list);
    }

    public synchronized Conversation readPreConversationWithoutMessages(String str) {
        return this.conversationDB.readPreConversationWithServerId(str);
    }

    public void removeFAQ(String str, String str2) {
        this.conversationDB.removeAdminFAQSuggestion(str, str2);
    }

    public void updateConversation(Conversation conversation) {
        String str = conversation.serverId;
        String str2 = conversation.preConversationServerId;
        if (str != null || str2 != null) {
            this.conversationDB.updateConversation(conversation);
            insertOrUpdateMessages(conversation.messageDMs);
        }
    }

    public void updateConversationWithoutMessages(Conversation conversation) {
        this.conversationDB.updateConversation(conversation);
    }

    public void updateConversations(List<Conversation> list, Map<Long, ConversationUpdate> map) {
        if (list.size() != 0) {
            this.conversationDB.updateConversations(list);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Conversation next : list) {
                if (map.containsKey(next.localId)) {
                    ConversationUpdate conversationUpdate = map.get(next.localId);
                    arrayList.addAll(conversationUpdate.newMessageDMs);
                    arrayList2.addAll(conversationUpdate.updatedMessageDMs);
                }
            }
            DAOResult<List<Long>> insertMessages = this.conversationDB.insertMessages(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                long longValue = ((Long) insertMessages.getData().get(i)).longValue();
                if (longValue != -1) {
                    ((MessageDM) arrayList.get(i)).localId = Long.valueOf(longValue);
                }
            }
            this.conversationDB.updateMessages(arrayList2);
        }
    }

    public void updateLastUserActivityTimeInConversation(Long l, long j) {
        if (l == null) {
            HSLogger.m3241e("Helpshift_CnDAO", "Trying to update last user activity time but localId is null");
        } else {
            this.conversationDB.updateLastUserActivityTimeInConversation(l, j);
        }
    }

    public synchronized Map<Long, Integer> getMessagesCountForConversations(List<Long> list, String[] strArr) {
        return this.conversationDB.getMessagesCountForConversations(list, strArr);
    }

    public Conversation readConversationWithoutMessages(Long l) {
        return this.conversationDB.readConversationWithLocalId(l);
    }

    public List<MessageDM> readMessages(long j, MessageType messageType) {
        return this.conversationDB.readMessages(j, messageType);
    }

    public boolean updateConversations(Map<Conversation, MessagesDiff> map, List<Conversation> list) {
        MessagesDiff messagesDiff;
        if (list.size() == 0) {
            return true;
        }
        if (!this.conversationDB.updateConversations(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Conversation next : list) {
            if (map.containsKey(next) && (messagesDiff = map.get(next)) != null) {
                arrayList.addAll(messagesDiff.newMessages);
                arrayList2.addAll(messagesDiff.updatedMessages);
            }
        }
        DAOResult<List<Long>> insertMessages = this.conversationDB.insertMessages(arrayList);
        if (!insertMessages.isSuccess()) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            long longValue = ((Long) insertMessages.getData().get(i)).longValue();
            if (longValue != -1) {
                ((MessageDM) arrayList.get(i)).localId = Long.valueOf(longValue);
            }
        }
        return this.conversationDB.updateMessages(arrayList2);
    }
}
