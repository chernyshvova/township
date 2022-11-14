package com.helpshift.conversation.activeconversation;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.loaders.SingleConversationLoader;
import com.helpshift.util.HSListObserver;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ViewableSingleConversation extends ViewableConversation {
    public Conversation conversation;

    public ViewableSingleConversation(Platform platform, Domain domain, UserDM userDM, SingleConversationLoader singleConversationLoader, ConversationManager conversationManager) {
        super(platform, domain, userDM, singleConversationLoader, conversationManager);
    }

    public Conversation getActiveConversation() {
        return this.conversation;
    }

    public List<Conversation> getAllConversations() {
        return Collections.singletonList(this.conversation);
    }

    public PaginationCursor getPaginationCursor() {
        return buildPaginationCursor(this.conversation);
    }

    public ViewableConversation.ConversationType getType() {
        return ViewableConversation.ConversationType.SINGLE;
    }

    public synchronized void init() {
        Conversation conversation2 = this.conversationLoader.fetchInitialConversations().get(0);
        this.conversation = conversation2;
        conversation2.userLocalId = this.userDM.getLocalId().longValue();
        Iterator<E> it = this.conversation.messageDMs.iterator();
        while (it.hasNext()) {
            ((MessageDM) it.next()).setDependencies(this.domain, this.platform);
        }
    }

    public void initializeConversationsForUI() {
        this.conversationManager.initializeMessagesForUI(this.conversation, true);
    }

    public void onNewConversationStarted(Conversation conversation2) {
    }

    public void prependConversations(List<Conversation> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation2 = list.get(i);
            if (this.conversation.localId.equals(conversation2.localId)) {
                this.conversation.messageDMs.prependItems(conversation2.messageDMs);
            }
        }
    }

    public void registerMessagesObserver(HSListObserver<MessageDM> hSListObserver) {
        this.conversation.messageDMs.setObserver(hSListObserver);
        this.conversation.registerMessagesObserver();
    }

    public boolean shouldOpen() {
        return this.conversationManager.shouldOpen(this.conversation);
    }
}
