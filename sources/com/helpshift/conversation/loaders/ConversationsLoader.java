package com.helpshift.conversation.loaders;

import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.ListUtils;
import java.util.List;

public abstract class ConversationsLoader {
    public final ConversationDBLoader conversationDBLoader;
    public final long messagesPageSize;
    public final RemoteConversationLoader remoteConversationLoader;

    public interface LoadMoreConversationsCallback {
        void loading();

        void onError();

        void onSuccess(List<Conversation> list, boolean z);
    }

    public ConversationsLoader(Platform platform, ConversationDBLoader conversationDBLoader2, RemoteConversationLoader remoteConversationLoader2, long j) {
        this.conversationDBLoader = conversationDBLoader2;
        this.remoteConversationLoader = remoteConversationLoader2;
        this.messagesPageSize = j;
    }

    private void updateLocalCache(List<Conversation> list) {
        if (ListUtils.isEmpty(list)) {
            this.conversationDBLoader.setHasMoreMessages(false);
        }
        int i = 0;
        for (Conversation conversation : list) {
            i += conversation.messageDMs.size();
        }
        if (i == 0) {
            this.conversationDBLoader.setHasMoreMessages(false);
        }
    }

    public List<Conversation> fetchInitialConversations() {
        List<Conversation> fetchMessages = this.conversationDBLoader.fetchMessages((String) null, (String) null, this.messagesPageSize);
        updateLocalCache(fetchMessages);
        return fetchMessages;
    }

    public abstract boolean hasMoreMessages();

    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r8.onError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0098, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0092 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0099=Splitter:B:39:0x0099, B:22:0x004b=Splitter:B:22:0x004b, B:28:0x005d=Splitter:B:28:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadMoreConversations(com.helpshift.conversation.activeconversation.PaginationCursor r7, com.helpshift.conversation.loaders.ConversationsLoader.LoadMoreConversationsCallback r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r8 != 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            r0 = 0
            if (r7 == 0) goto L_0x0099
            boolean r1 = r6.hasMoreMessages()     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0099
        L_0x0010:
            java.lang.String r1 = r7.conversationCursor     // Catch:{ all -> 0x00a3 }
            boolean r1 = com.helpshift.util.StringUtils.isEmpty(r1)     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0097
            java.lang.String r1 = r7.messageCursor     // Catch:{ all -> 0x00a3 }
            boolean r1 = com.helpshift.util.StringUtils.isEmpty(r1)     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0022
            goto L_0x0097
        L_0x0022:
            r8.loading()     // Catch:{ all -> 0x00a3 }
            com.helpshift.conversation.loaders.ConversationDBLoader r1 = r6.conversationDBLoader     // Catch:{ all -> 0x00a3 }
            boolean r1 = r1.hasMoreMessages()     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x004b
            com.helpshift.conversation.loaders.ConversationDBLoader r1 = r6.conversationDBLoader     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = r7.conversationCursor     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = r7.messageCursor     // Catch:{ all -> 0x00a3 }
            long r4 = r6.messagesPageSize     // Catch:{ all -> 0x00a3 }
            java.util.List r1 = r1.fetchMessages(r2, r3, r4)     // Catch:{ all -> 0x00a3 }
            r6.updateLocalCache(r1)     // Catch:{ all -> 0x00a3 }
            boolean r2 = com.helpshift.util.ListUtils.isEmpty(r1)     // Catch:{ all -> 0x00a3 }
            if (r2 != 0) goto L_0x004b
            boolean r7 = r6.hasMoreMessages()     // Catch:{ all -> 0x00a3 }
            r8.onSuccess(r1, r7)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x004b:
            com.helpshift.conversation.loaders.RemoteConversationLoader r1 = r6.remoteConversationLoader     // Catch:{ all -> 0x00a3 }
            boolean r1 = r1.hasMoreMessage()     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x005d
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00a3 }
            r7.<init>()     // Catch:{ all -> 0x00a3 }
            r8.onSuccess(r7, r0)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x005d:
            r8.loading()     // Catch:{ RootAPIException -> 0x0092 }
            com.helpshift.conversation.loaders.RemoteConversationLoader r0 = r6.remoteConversationLoader     // Catch:{ RootAPIException -> 0x0092 }
            boolean r0 = r0.loadMoreMessages()     // Catch:{ RootAPIException -> 0x0092 }
            if (r0 == 0) goto L_0x0085
            com.helpshift.conversation.loaders.ConversationDBLoader r0 = r6.conversationDBLoader     // Catch:{ RootAPIException -> 0x0092 }
            r1 = 1
            r0.setHasMoreMessages(r1)     // Catch:{ RootAPIException -> 0x0092 }
            com.helpshift.conversation.loaders.ConversationDBLoader r0 = r6.conversationDBLoader     // Catch:{ RootAPIException -> 0x0092 }
            java.lang.String r1 = r7.conversationCursor     // Catch:{ RootAPIException -> 0x0092 }
            java.lang.String r7 = r7.messageCursor     // Catch:{ RootAPIException -> 0x0092 }
            long r2 = r6.messagesPageSize     // Catch:{ RootAPIException -> 0x0092 }
            java.util.List r7 = r0.fetchMessages(r1, r7, r2)     // Catch:{ RootAPIException -> 0x0092 }
            r6.updateLocalCache(r7)     // Catch:{ RootAPIException -> 0x0092 }
            boolean r0 = r6.hasMoreMessages()     // Catch:{ RootAPIException -> 0x0092 }
            r8.onSuccess(r7, r0)     // Catch:{ RootAPIException -> 0x0092 }
            goto L_0x0095
        L_0x0085:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ RootAPIException -> 0x0092 }
            r7.<init>()     // Catch:{ RootAPIException -> 0x0092 }
            boolean r0 = r6.hasMoreMessages()     // Catch:{ RootAPIException -> 0x0092 }
            r8.onSuccess(r7, r0)     // Catch:{ RootAPIException -> 0x0092 }
            goto L_0x0095
        L_0x0092:
            r8.onError()     // Catch:{ all -> 0x00a3 }
        L_0x0095:
            monitor-exit(r6)
            return
        L_0x0097:
            monitor-exit(r6)
            return
        L_0x0099:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00a3 }
            r7.<init>()     // Catch:{ all -> 0x00a3 }
            r8.onSuccess(r7, r0)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x00a3:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.loaders.ConversationsLoader.loadMoreConversations(com.helpshift.conversation.activeconversation.PaginationCursor, com.helpshift.conversation.loaders.ConversationsLoader$LoadMoreConversationsCallback):void");
    }
}
