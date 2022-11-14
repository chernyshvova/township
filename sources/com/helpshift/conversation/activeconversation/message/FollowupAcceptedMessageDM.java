package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.util.HashMap;

public class FollowupAcceptedMessageDM extends AutoRetriableMessageDM {
    public String referredMessageId;

    public FollowupAcceptedMessageDM(String str, String str2, long j, Author author, String str3, int i) {
        super(str, str2, j, author, false, MessageType.FOLLOWUP_ACCEPTED, i);
        this.referredMessageId = str3;
    }

    public boolean isUISupportedMessage() {
        return false;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof FollowupAcceptedMessageDM) {
            this.referredMessageId = ((FollowupAcceptedMessageDM) messageDM).referredMessageId;
        }
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        if (!StringUtils.isEmpty(conversationServerInfo.getIssueId())) {
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
            userRequestData.put("body", "Accepted the follow-up");
            userRequestData.put("type", "ra");
            userRequestData.put("refers", this.referredMessageId);
            try {
                FollowupAcceptedMessageDM parseFollowupAcceptedMessage = this.platform.getResponseParser().parseFollowupAcceptedMessage(makeNetworkRequest(getIssueSendMessageRoute(conversationServerInfo), userRequestData).responseString);
                merge(parseFollowupAcceptedMessage);
                this.author = parseFollowupAcceptedMessage.author;
                this.serverId = parseFollowupAcceptedMessage.serverId;
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
                }
                throw e;
            }
        } else {
            throw new UnsupportedOperationException("FollowupAcceptedMessageDM send called with conversation in pre issue mode.");
        }
    }

    public FollowupAcceptedMessageDM(FollowupAcceptedMessageDM followupAcceptedMessageDM) {
        super(followupAcceptedMessageDM);
        this.referredMessageId = followupAcceptedMessageDM.referredMessageId;
    }

    public FollowupAcceptedMessageDM deepClone() {
        return new FollowupAcceptedMessageDM(this);
    }
}
