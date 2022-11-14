package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.util.HashMap;

public class AcceptedAppReviewMessageDM extends AutoRetriableMessageDM {
    public String referredMessageId;

    public AcceptedAppReviewMessageDM(String str, String str2, long j, Author author, String str3, int i) {
        super(str, str2, j, author, false, MessageType.ACCEPTED_APP_REVIEW, i);
        this.referredMessageId = str3;
    }

    public boolean isUISupportedMessage() {
        return false;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof AcceptedAppReviewMessageDM) {
            this.referredMessageId = ((AcceptedAppReviewMessageDM) messageDM).referredMessageId;
        }
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) throws RootAPIException {
        if (!StringUtils.isEmpty(conversationServerInfo.getIssueId())) {
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
            userRequestData.put("body", this.body);
            userRequestData.put("type", "ar");
            userRequestData.put("refers", this.referredMessageId);
            try {
                AcceptedAppReviewMessageDM parseAcceptedAppReviewMessageDM = this.platform.getResponseParser().parseAcceptedAppReviewMessageDM(makeNetworkRequest(getIssueSendMessageRoute(conversationServerInfo), userRequestData).responseString);
                merge(parseAcceptedAppReviewMessageDM);
                this.serverId = parseAcceptedAppReviewMessageDM.serverId;
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
                }
                throw e;
            }
        } else {
            throw new UnsupportedOperationException("AcceptedAppReviewMessageDM send called with conversation in pre issue mode.");
        }
    }

    public AcceptedAppReviewMessageDM(AcceptedAppReviewMessageDM acceptedAppReviewMessageDM) {
        super(acceptedAppReviewMessageDM);
        this.referredMessageId = acceptedAppReviewMessageDM.referredMessageId;
    }

    public AcceptedAppReviewMessageDM deepClone() {
        return new AcceptedAppReviewMessageDM(this);
    }
}
