package com.helpshift.conversation.pollersync;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.pollersync.listener.DBPollerDataChangeListener;
import com.helpshift.conversation.pollersync.listener.IMPollerDataChangeListener;
import com.helpshift.conversation.pollersync.listener.PollerDataChangeListener;
import com.helpshift.conversation.pollersync.model.ConversationsDiff;
import com.helpshift.conversation.pollersync.model.ConversationsLookup;
import com.helpshift.conversation.pollersync.model.MessagesDiff;
import com.helpshift.conversation.pollersync.updater.DBPollerDataUpdater;
import com.helpshift.conversation.pollersync.updater.IMPollerDataUpdater;
import com.helpshift.conversation.pollersync.updater.PollerDataUpdater;
import com.helpshift.conversation.util.predicate.ConversationPredicates;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.Filters;
import com.helpshift.util.ListUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PollerSyncManager {
    public static final String TAG = "HS_PollerSyncManager";
    public ConversationManager conversationManager;
    public PollerDataChangeListener dbDataChangeListener;
    public PollerDataUpdater dbDataUpdater;
    public PollerDataChangeListener imDataChangeListener;
    public PollerDataUpdater imDataUpdater;
    public PollerSyncDataProvider syncDataProvider;

    public PollerSyncManager(Domain domain, Platform platform, UserDM userDM, PollerSyncDataProvider pollerSyncDataProvider, ConversationManager conversationManager2) {
        this.conversationManager = conversationManager2;
        this.syncDataProvider = pollerSyncDataProvider;
        this.dbDataUpdater = new DBPollerDataUpdater(platform, domain, userDM, pollerSyncDataProvider);
        this.imDataUpdater = new IMPollerDataUpdater(platform, domain, pollerSyncDataProvider);
        this.dbDataChangeListener = new DBPollerDataChangeListener(conversationManager2, pollerSyncDataProvider);
        this.imDataChangeListener = new IMPollerDataChangeListener(domain, platform, conversationManager2, pollerSyncDataProvider);
    }

    private List<Conversation> createRemoteConversationsForIMDataUpdater(ConversationsDiff conversationsDiff) {
        ArrayList arrayList = new ArrayList();
        for (Conversation next : conversationsDiff.updatedConversations) {
            Conversation deepClone = next.deepClone();
            MessagesDiff messagesDiff = conversationsDiff.messagesDiffMap.get(next);
            if (messagesDiff != null) {
                deepClone.messageDMs.addAll(CloneUtil.deepClone(messagesDiff.updatedMessages));
                deepClone.messageDMs.addAll(CloneUtil.deepClone(messagesDiff.newMessages));
            }
            arrayList.add(deepClone);
        }
        return arrayList;
    }

    private void dispatchListenerCallbacks(PollerDataChangeListener pollerDataChangeListener, ConversationsDiff conversationsDiff) {
        if (pollerDataChangeListener != null && conversationsDiff != null) {
            List<Conversation> list = conversationsDiff.existingConversations;
            List<Conversation> list2 = conversationsDiff.updatedConversations;
            ConversationsLookup conversationsLookup = new ConversationsLookup(list, this.syncDataProvider);
            for (Conversation next : list2) {
                ValuePair<ConversationsLookup.MatchingID, Conversation> find = conversationsLookup.find(next);
                if (find != null) {
                    pollerDataChangeListener.onConversationUpdated((Conversation) find.second, next);
                }
                MessagesDiff messagesDiff = conversationsDiff.messagesDiffMap.get(next);
                if (messagesDiff != null) {
                    List<MessageDM> list3 = messagesDiff.newMessages;
                    if (!ListUtils.isEmpty(list3)) {
                        pollerDataChangeListener.onMessagesAdded(next, list3);
                    }
                    List<MessageDM> list4 = messagesDiff.updatedMessages;
                    if (!ListUtils.isEmpty(list4)) {
                        pollerDataChangeListener.onMessagesUpdated(messagesDiff.existingMessages, list4);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.util.List<com.helpshift.conversation.activeconversation.model.Conversation>> divideIntoChunksIfNeeded(java.util.List<com.helpshift.conversation.activeconversation.model.Conversation> r7, boolean r8) {
        /*
            r6 = this;
            if (r8 != 0) goto L_0x005a
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1 = 0
            java.util.Iterator r2 = r7.iterator()
        L_0x0011:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r2.next()
            com.helpshift.conversation.activeconversation.model.Conversation r3 = (com.helpshift.conversation.activeconversation.model.Conversation) r3
            java.lang.String r5 = r3.preConversationServerId
            boolean r5 = com.helpshift.util.StringUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0035
            java.lang.String r5 = r3.preConversationServerId
            boolean r5 = r8.contains(r5)
            if (r5 == 0) goto L_0x0030
        L_0x002e:
            r1 = 1
            goto L_0x004c
        L_0x0030:
            java.lang.String r5 = r3.preConversationServerId
            r8.add(r5)
        L_0x0035:
            java.lang.String r5 = r3.serverId
            boolean r5 = com.helpshift.util.StringUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0011
            java.lang.String r5 = r3.serverId
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x0046
            goto L_0x002e
        L_0x0046:
            java.lang.String r3 = r3.serverId
            r0.add(r3)
            goto L_0x0011
        L_0x004c:
            if (r1 == 0) goto L_0x005a
            java.lang.String r8 = "HS_PollerSyncManager"
            java.lang.String r0 = "Found duplicate conversations in same response, will chunk the data for processing"
            com.helpshift.util.HSLogger.m3237d(r8, r0)
            java.util.List r7 = com.helpshift.util.ListUtils.unflatten(r7)
            return r7
        L_0x005a:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r8.add(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.pollersync.PollerSyncManager.divideIntoChunksIfNeeded(java.util.List, boolean):java.util.List");
    }

    private List<Conversation> filterAndSort(List<Conversation> list) {
        List<Conversation> filter = Filters.filter(list, ConversationPredicates.allMessagesAfterLastMessageInDbPredicate(this.conversationManager));
        ConversationUtil.sortConversationsBasedOnCreatedAt(filter);
        return filter;
    }

    private void onConversationsSyncComplete(List<Conversation> list, ConversationsDiff conversationsDiff) {
        this.conversationManager.clearRequestIdForPendingCreateConversationCalls(list);
        for (Map.Entry next : conversationsDiff.messagesDiffMap.entrySet()) {
            this.conversationManager.clearRequestIdForPendingSendMessageCalls((Conversation) next.getKey(), ((MessagesDiff) next.getValue()).updatedMessages);
        }
    }

    private void syncInternal(List<Conversation> list) throws PollerSyncException {
        ConversationsDiff updateData = this.dbDataUpdater.updateData(list);
        dispatchListenerCallbacks(this.dbDataChangeListener, updateData);
        if (this.syncDataProvider.getAliveViewableConversation() != null) {
            List<Conversation> createRemoteConversationsForIMDataUpdater = createRemoteConversationsForIMDataUpdater(updateData);
            if (!ListUtils.isEmpty(createRemoteConversationsForIMDataUpdater)) {
                dispatchListenerCallbacks(this.imDataChangeListener, this.imDataUpdater.updateData(createRemoteConversationsForIMDataUpdater));
            }
        }
        onConversationsSyncComplete(list, updateData);
    }

    public void sync(List<Conversation> list, boolean z) throws PollerSyncException {
        if (!ListUtils.isEmpty(list)) {
            List<Conversation> filterAndSort = filterAndSort(list);
            if (!ListUtils.isEmpty(filterAndSort)) {
                for (List<Conversation> syncInternal : divideIntoChunksIfNeeded(filterAndSort, z)) {
                    syncInternal(syncInternal);
                }
            }
        }
    }
}
