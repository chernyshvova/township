package com.helpshift.conversation.activeconversation;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.loaders.ConversationHistoryLoader;
import com.helpshift.util.HSListObserver;
import com.helpshift.util.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ViewableConversationHistory extends ViewableConversation {
    public List<Conversation> conversations = new ArrayList();

    public ViewableConversationHistory(Platform platform, Domain domain, UserDM userDM, ConversationHistoryLoader conversationHistoryLoader, ConversationManager conversationManager) {
        super(platform, domain, userDM, conversationHistoryLoader, conversationManager);
    }

    public synchronized Conversation getActiveConversation() {
        return this.conversations.get(this.conversations.size() - 1);
    }

    public synchronized List<Conversation> getAllConversations() {
        return new ArrayList(this.conversations);
    }

    public synchronized PaginationCursor getPaginationCursor() {
        if (ListUtils.isEmpty(this.conversations)) {
            return null;
        }
        return buildPaginationCursor(this.conversations.get(0));
    }

    public ViewableConversation.ConversationType getType() {
        return ViewableConversation.ConversationType.HISTORY;
    }

    public synchronized void init() {
        List<Conversation> fetchInitialConversations = this.conversationLoader.fetchInitialConversations();
        this.conversations = fetchInitialConversations;
        for (Conversation next : fetchInitialConversations) {
            next.userLocalId = this.userDM.getLocalId().longValue();
            this.conversationManager.updateStateBasedOnMessages(next);
            Iterator<E> it = next.messageDMs.iterator();
            while (it.hasNext()) {
                ((MessageDM) it.next()).setDependencies(this.domain, this.platform);
            }
        }
    }

    public synchronized void initializeConversationsForUI() {
        long longValue = getActiveConversation().localId.longValue();
        for (Conversation next : this.conversations) {
            this.conversationManager.initializeMessagesForUI(next, next.localId.equals(Long.valueOf(longValue)));
        }
    }

    public synchronized void onNewConversationStarted(Conversation conversation) {
        conversation.setListener(this);
        this.conversations.add(conversation);
    }

    public synchronized void prependConversations(List<Conversation> list) {
        HashMap hashMap = new HashMap();
        for (Conversation next : this.conversations) {
            hashMap.put(next.localId, next);
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            Conversation conversation = list.get(i);
            Conversation conversation2 = (Conversation) hashMap.get(conversation.localId);
            if (conversation2 != null) {
                conversation2.messageDMs.prependItems(conversation.messageDMs);
            } else {
                arrayList.add(conversation);
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.conversations.addAll(0, arrayList);
        }
    }

    public synchronized void registerMessagesObserver(HSListObserver<MessageDM> hSListObserver) {
        for (Conversation next : this.conversations) {
            next.messageDMs.setObserver(hSListObserver);
            next.registerMessagesObserver();
        }
    }

    public boolean shouldOpen() {
        return true;
    }
}
