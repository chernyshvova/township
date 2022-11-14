package com.helpshift.conversation.util.predicate;

import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.util.Predicate;

public class MessagePredicates {
    public static Predicate<MessageDM> olderThanLastDbMessagePredicate(final long j) {
        return new Predicate<MessageDM>() {
            public boolean matches(MessageDM messageDM) {
                return messageDM.getEpochCreatedAtTime() >= j;
            }
        };
    }
}
