package com.helpshift.conversation.util.predicate;

import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.Predicate;

public class ConversationPredicates {
    public static Predicate<Conversation> allMessagesAfterLastMessageInDbPredicate(final ConversationManager conversationManager) {
        return new Predicate<Conversation>() {
            public boolean matches(Conversation conversation) {
                return !conversationManager.filterMessagesOlderThanLastMessageInDb(conversation);
            }
        };
    }

    public static Predicate<Conversation> newInProgressConversationPredicate() {
        return new Predicate<Conversation>() {
            public boolean matches(Conversation conversation) {
                return conversation.isIssueInProgress();
            }
        };
    }

    public static Predicate<Conversation> newSyncedConversationPredicate(final ConversationManager conversationManager) {
        return new Predicate<Conversation>() {
            public boolean matches(Conversation conversation) {
                return conversationManager.isSynced(conversation);
            }
        };
    }
}
