package com.helpshift.support.providers;

import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.providers.ISupportDataProvider;
import com.helpshift.util.HelpshiftContext;

public class SupportDataProvider implements ISupportDataProvider {
    public String getActionEvents() {
        return HelpshiftContext.getPlatform().getJsonifier().jsonifyAnalyticsDTOList(HelpshiftContext.getCoreApi().getAnalyticsEventDM().getCurrentSessionEventsCopy());
    }

    public String getActiveConversationId() {
        Conversation activeConversation = HelpshiftContext.getCoreApi().getActiveConversation();
        if (activeConversation != null) {
            return activeConversation.serverId;
        }
        return null;
    }
}
