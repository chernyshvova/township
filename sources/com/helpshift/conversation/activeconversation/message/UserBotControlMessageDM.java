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
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.swrve.sdk.ISwrveCommon;
import java.util.HashMap;

public class UserBotControlMessageDM extends AutoRetriableMessageDM {
    public String actionType;
    public String botInfo;
    public String reason;
    public String refersMessageId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserBotControlMessageDM(String str, String str2, long j, Author author, String str3, String str4, String str5, String str6, int i) {
        super(str, str2, j, author, false, MessageType.USER_BOT_CONTROL, i);
        this.actionType = str3;
        this.reason = str4;
        this.botInfo = str5;
        this.refersMessageId = str6;
    }

    public Network getSendMessageNetwork(String str) {
        return new GuardOKNetwork(new FailedAPICallNetworkDecorator(new GuardAgainstConversationArchivalNetwork(new GuardAgainstConversationReOpenExpiryNetwork(new UserPreConditionsFailedNetwork(new AuthenticationFailureNetwork(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork(str, this.domain, this.platform), this.platform, getIdempotentPolicy(), str, String.valueOf(this.localId)), this.platform))), this.platform))));
    }

    public boolean isUISupportedMessage() {
        return false;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof UserBotControlMessageDM) {
            UserBotControlMessageDM userBotControlMessageDM = (UserBotControlMessageDM) messageDM;
            this.actionType = userBotControlMessageDM.actionType;
            this.reason = userBotControlMessageDM.reason;
            this.botInfo = userBotControlMessageDM.botInfo;
            this.refersMessageId = userBotControlMessageDM.refersMessageId;
        }
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        String str;
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("origin", ISwrveCommon.DEVICE_TYPE_MOBILE);
        userRequestData.put("type", this.actionType);
        userRequestData.put("chatbot_cancelled_reason", this.reason);
        userRequestData.put("body", this.body);
        userRequestData.put("chatbot_info", this.botInfo);
        userRequestData.put("refers", this.refersMessageId);
        if (conversationServerInfo.isInPreIssueMode()) {
            str = getPreIssueSendMessageRoute(conversationServerInfo);
        } else {
            str = getIssueSendMessageRoute(conversationServerInfo);
        }
        try {
            UserBotControlMessageDM userBotControlMessageDM = (UserBotControlMessageDM) this.platform.getResponseParser().parseBotControlMessage(makeNetworkRequest(str, userRequestData).responseString, false);
            merge(userBotControlMessageDM);
            this.serverId = userBotControlMessageDM.serverId;
            this.platform.getConversationDAO().insertOrUpdateMessage(this);
        } catch (RootAPIException e) {
            ExceptionType exceptionType = e.exceptionType;
            if (exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED || exceptionType == NetworkException.INVALID_AUTH_TOKEN) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
            }
            throw e;
        }
    }

    public UserBotControlMessageDM deepClone() {
        return new UserBotControlMessageDM(this);
    }

    public UserBotControlMessageDM(UserBotControlMessageDM userBotControlMessageDM) {
        super(userBotControlMessageDM);
        this.actionType = userBotControlMessageDM.actionType;
        this.reason = userBotControlMessageDM.reason;
        this.botInfo = userBotControlMessageDM.botInfo;
        this.refersMessageId = userBotControlMessageDM.refersMessageId;
    }
}
