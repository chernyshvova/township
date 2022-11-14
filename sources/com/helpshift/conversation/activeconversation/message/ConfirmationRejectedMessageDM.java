package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardAgainstConversationArchivalNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationReOpenExpiryNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.domain.network.UserPreConditionsFailedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class ConfirmationRejectedMessageDM extends AutoRetriableMessageDM {
    public ConfirmationRejectedMessageDM(String str, String str2, long j, Author author, int i) {
        super(str, str2, j, author, false, MessageType.CONFIRMATION_REJECTED, i);
    }

    public Network getSendMessageNetwork(String str) {
        return new GuardOKNetwork(new FailedAPICallNetworkDecorator(new GuardAgainstConversationArchivalNetwork(new GuardAgainstConversationReOpenExpiryNetwork(new UserPreConditionsFailedNetwork(new AuthenticationFailureNetwork(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork(str, this.domain, this.platform), this.platform, getIdempotentPolicy(), str, String.valueOf(this.localId)), this.platform))), this.platform))));
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public Response makeNetworkRequest(String str, Map<String, String> map) {
        try {
            return super.makeNetworkRequest(str, map);
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                updateSyncStatusIntoMemoryAndDB(3);
            }
            throw e;
        }
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        if (!StringUtils.isEmpty(conversationServerInfo.getIssueId())) {
            HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
            userRequestData.put("body", this.body);
            userRequestData.put("type", "ncr");
            userRequestData.put("refers", "");
            try {
                ConfirmationRejectedMessageDM parseConfirmationRejectedMessageDM = this.platform.getResponseParser().parseConfirmationRejectedMessageDM(makeNetworkRequest(getIssueSendMessageRoute(conversationServerInfo), userRequestData).responseString);
                merge(parseConfirmationRejectedMessageDM);
                this.serverId = parseConfirmationRejectedMessageDM.serverId;
                this.author = parseConfirmationRejectedMessageDM.author;
                notifyUpdated();
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
                }
                throw e;
            }
        } else {
            throw new UnsupportedOperationException("ConfirmationRejectedMessageDM send called with conversation in pre issue mode.");
        }
    }

    public ConfirmationRejectedMessageDM(ConfirmationRejectedMessageDM confirmationRejectedMessageDM) {
        super(confirmationRejectedMessageDM);
    }

    public ConfirmationRejectedMessageDM deepClone() {
        return new ConfirmationRejectedMessageDM(this);
    }
}
