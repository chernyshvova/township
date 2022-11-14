package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSCloneable;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FAQListMessageDM extends AdminMessageDM {
    public List<FAQ> faqs;
    public boolean isSuggestionsReadEventSent = false;
    public final String source;
    public String suggestionsReadFAQPublishId = "";

    public static final class FAQ implements HSCloneable {
        public final String language;
        public final String publishId;
        public final String title;

        public FAQ(String str, String str2, String str3) {
            this.title = str;
            this.publishId = str2;
            this.language = str3;
        }

        public FAQ deepClone() {
            return new FAQ(this);
        }

        public FAQ(FAQ faq) {
            this.title = faq.title;
            this.publishId = faq.publishId;
            this.language = faq.language;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FAQListMessageDM(String str, String str2, String str3, long j, Author author, List<FAQ> list, String str4, MessageType messageType) {
        super(str, str2, str3, j, author, messageType);
        this.faqs = list;
        this.source = str4;
    }

    private void markSuggestionsReadEventAsSent() {
        this.isSuggestionsReadEventSent = true;
        this.platform.getConversationDAO().insertOrUpdateMessage(this);
    }

    public void handleSuggestionClick(ConversationServerInfo conversationServerInfo, UserDM userDM, String str, String str2) {
        if (StringUtils.isEmpty(this.suggestionsReadFAQPublishId)) {
            if (StringUtils.isEmpty(this.suggestionsReadFAQPublishId)) {
                this.suggestionsReadFAQPublishId = str2;
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
            }
            if (isSuggestionsReadEventPending()) {
                sendSuggestionReadEvent(conversationServerInfo, userDM);
            }
        }
    }

    public boolean isSuggestionsReadEventPending() {
        return !this.isSuggestionsReadEventSent;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof FAQListMessageDM) {
            this.faqs = ((FAQListMessageDM) messageDM).faqs;
        }
    }

    public void sendSuggestionReadEvent(ConversationServerInfo conversationServerInfo, UserDM userDM) {
        if (!StringUtils.isEmpty(this.suggestionsReadFAQPublishId)) {
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
            if (conversationServerInfo.isInPreIssueMode()) {
                userRequestData.put(AnalyticsEventKey.PREISSUE_ID, conversationServerInfo.getPreIssueId());
            } else {
                userRequestData.put(AnalyticsEventKey.ISSUE_ID, conversationServerInfo.getIssueId());
            }
            userRequestData.put("message_id", this.serverId);
            userRequestData.put("faq_publish_id", this.suggestionsReadFAQPublishId);
            try {
                new GuardOKNetwork(new FailedAPICallNetworkDecorator(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork("/faqs_suggestion_read/", this.domain, this.platform), this.platform, getIdempotentPolicy(), "/faqs_suggestion_read/", this.serverId), this.platform))).makeRequest(new RequestData((Map<String, String>) userRequestData));
                markSuggestionsReadEventAsSent();
            } catch (RootAPIException e) {
                if (e.exceptionType == NetworkException.NON_RETRIABLE) {
                    markSuggestionsReadEventAsSent();
                    return;
                }
                throw e;
            }
        }
    }

    public FAQListMessageDM deepClone() {
        return new FAQListMessageDM(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FAQListMessageDM(String str, String str2, String str3, long j, Author author, List<FAQ> list, String str4) {
        super(str, str2, str3, j, author, MessageType.FAQ_LIST);
        this.faqs = list;
        this.source = str4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FAQListMessageDM(String str, String str2, String str3, long j, Author author, List<FAQ> list, String str4, boolean z, String str5) {
        super(str, str2, str3, j, author, MessageType.FAQ_LIST);
        this.faqs = list;
        this.isSuggestionsReadEventSent = z;
        this.suggestionsReadFAQPublishId = str5;
        this.source = str4;
    }

    public FAQListMessageDM(FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM) {
        super(fAQListMessageWithOptionInputDM.serverId, fAQListMessageWithOptionInputDM.body, fAQListMessageWithOptionInputDM.getCreatedAt(), fAQListMessageWithOptionInputDM.getEpochCreatedAtTime(), fAQListMessageWithOptionInputDM.author, MessageType.FAQ_LIST);
        this.faqs = fAQListMessageWithOptionInputDM.faqs;
        this.conversationLocalId = fAQListMessageWithOptionInputDM.conversationLocalId;
        this.source = fAQListMessageWithOptionInputDM.source;
    }

    public FAQListMessageDM(FAQListMessageDM fAQListMessageDM) {
        super(fAQListMessageDM);
        this.faqs = CloneUtil.deepClone(fAQListMessageDM.faqs);
        this.isSuggestionsReadEventSent = fAQListMessageDM.isSuggestionsReadEventSent;
        this.suggestionsReadFAQPublishId = fAQListMessageDM.suggestionsReadFAQPublishId;
        this.source = fAQListMessageDM.source;
    }
}
