package com.helpshift.conversation.activeconversation.message;

import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.util.ValuePair;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.conversations.p035ui.ConversationActivity;
import java.util.HashMap;
import java.util.Map;

public class RequestAppReviewMessageDM extends MessageDM {
    public boolean isAnswered;
    public boolean isReviewButtonClickable;

    public RequestAppReviewMessageDM(String str, String str2, String str3, long j, Author author, boolean z) {
        super(str2, str3, j, author, true, MessageType.REQUESTED_APP_REVIEW);
        this.serverId = str;
        this.isAnswered = z;
        this.isReviewButtonClickable = true;
    }

    public void handleAcceptedReviewSuccess(Platform platform) {
        this.isReviewButtonClickable = false;
        this.isAnswered = true;
        notifyUpdated();
        platform.getConversationDAO().insertOrUpdateMessage(this);
    }

    public AcceptedAppReviewMessageDM handleRequestReviewClick(Domain domain, Platform platform) {
        if (this.isAnswered) {
            return null;
        }
        setIsReviewButtonClickable(false);
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(platform);
        AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = new AcceptedAppReviewMessageDM("Accepted review request", (String) currentAdjustedTimeForStorage.first, ((Long) currentAdjustedTimeForStorage.second).longValue(), new Author(ISwrveCommon.DEVICE_TYPE_MOBILE, "", Author.AuthorRole.SYSTEM), this.serverId, 1);
        acceptedAppReviewMessageDM.conversationLocalId = this.conversationLocalId;
        acceptedAppReviewMessageDM.setDependencies(domain, platform);
        platform.getConversationDAO().insertOrUpdateMessage(acceptedAppReviewMessageDM);
        HashMap hashMap = new HashMap();
        hashMap.put("type", ConversationActivity.EXTRA_CONVERSATION_KEY);
        domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.REVIEWED_APP, (Map<String, Object>) hashMap);
        domain.getDelegate().userRepliedToConversation("User reviewed the app");
        return acceptedAppReviewMessageDM;
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof RequestAppReviewMessageDM) {
            this.isAnswered = ((RequestAppReviewMessageDM) messageDM).isAnswered;
        }
    }

    public void setIsReviewButtonClickable(boolean z) {
        this.isReviewButtonClickable = z;
        notifyUpdated();
    }

    public RequestAppReviewMessageDM deepClone() {
        return new RequestAppReviewMessageDM(this);
    }

    public RequestAppReviewMessageDM(RequestAppReviewMessageDM requestAppReviewMessageDM) {
        super(requestAppReviewMessageDM);
        this.isAnswered = requestAppReviewMessageDM.isAnswered;
        this.isReviewButtonClickable = requestAppReviewMessageDM.isReviewButtonClickable;
    }
}
