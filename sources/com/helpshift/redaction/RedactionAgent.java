package com.helpshift.redaction;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.domainmodel.ConversationController;

public class RedactionAgent {
    public Domain domain;
    public Platform platform;

    public RedactionAgent(Platform platform2, Domain domain2) {
        this.platform = platform2;
        this.domain = domain2;
    }

    private boolean isConversationRedacted(Long l, Long l2) {
        return l != null && (l2 == null || l2.longValue() < l.longValue());
    }

    private boolean isUserRedacted(Long l, Long l2) {
        return l2 != null && (l == null || l.longValue() > l2.longValue());
    }

    private void updateRedaction(UserDM userDM, RedactionType redactionType) {
        RedactionDetail redactionDetail = new RedactionDetail(userDM.getLocalId().longValue(), RedactionState.PENDING, redactionType);
        RedactionDAO redactionDAO = this.platform.getRedactionDAO();
        if (redactionDAO.getRedactionDetail(userDM.getLocalId().longValue()) == null) {
            redactionDAO.insertRedactionDetail(redactionDetail);
        } else {
            redactionDAO.updateRedactionRedail(redactionDetail);
        }
    }

    public void checkAndUpdateRedactionState(UserDM userDM, Long l, Long l2) {
        ConversationController conversationInboxDM = this.domain.getConversationInboxManagerDM().getConversationInboxDM(userDM);
        if (isUserRedacted(l, conversationInboxDM.getOldestConversationCreatedAtTime())) {
            updateRedaction(userDM, RedactionType.USER);
        } else if (isConversationRedacted(l2, conversationInboxDM.getLastConversationsRedactionTime())) {
            updateRedaction(userDM, RedactionType.CONVERSATION);
        }
        if (l2 != null) {
            conversationInboxDM.saveLastConversationsRedactionTime(l2.longValue());
        }
    }
}
