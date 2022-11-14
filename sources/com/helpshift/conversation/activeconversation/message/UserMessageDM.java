package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class UserMessageDM extends MessageDM {
    public UserMessageState state;

    public UserMessageDM(String str, String str2, long j, Author author) {
        super(str, str2, j, author, false, MessageType.USER_TEXT);
    }

    private void setStateAsUnsentRetryable() {
        if (StringUtils.isEmpty(this.serverId)) {
            setState(UserMessageState.UNSENT_RETRYABLE);
        }
    }

    public Map<String, String> getData() throws ParseException {
        return new HashMap();
    }

    public String getMessageTypeForRequest() {
        return "txt";
    }

    public String getReferredMessageId() {
        return "";
    }

    public UserMessageState getState() {
        return this.state;
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public UserMessageDM parseResponse(Response response) {
        return this.platform.getResponseParser().parseReadableUserMessage(response.responseString);
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        String str;
        UserMessageState userMessageState = this.state;
        if (userMessageState != UserMessageState.SENDING && userMessageState != UserMessageState.SENT && userMessageState != UserMessageState.UNSENT_NOT_RETRYABLE) {
            setState(UserMessageState.SENDING);
            if (conversationServerInfo.isInPreIssueMode()) {
                str = getPreIssueSendMessageRoute(conversationServerInfo);
            } else {
                str = getIssueSendMessageRoute(conversationServerInfo);
            }
            try {
                Map<String, String> data = getData();
                data.putAll(NetworkDataRequestUtil.getUserRequestData(userDM));
                data.put("body", this.body);
                data.put("type", getMessageTypeForRequest());
                data.put("refers", getReferredMessageId());
                UserMessageDM parseResponse = parseResponse(getSendMessageNetwork(str).makeRequest(new RequestData(data)));
                this.state = UserMessageState.SENT;
                merge(parseResponse);
                this.serverId = parseResponse.serverId;
                this.platform.getConversationDAO().insertOrUpdateMessage(this);
                this.author = parseResponse.author;
                notifyUpdated();
                HashMap hashMap = new HashMap();
                if (StringUtils.isNotEmpty(conversationServerInfo.getIssueId())) {
                    hashMap.put("id", conversationServerInfo.getIssueId());
                }
                hashMap.put("type", "txt");
                if (StringUtils.isNotEmpty(conversationServerInfo.getAnalyticConversationId())) {
                    hashMap.put("acid", conversationServerInfo.getAnalyticConversationId());
                }
                this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.MESSAGE_ADDED, (Map<String, Object>) hashMap);
                this.domain.getDelegate().userRepliedToConversation(this.body);
            } catch (RootAPIException e) {
                ExceptionType exceptionType = e.exceptionType;
                if (exceptionType == NetworkException.INVALID_AUTH_TOKEN || exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    setStateAsUnsentRetryable();
                    this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
                } else if (!(exceptionType == NetworkException.CONVERSATION_ARCHIVED || exceptionType == NetworkException.USER_PRE_CONDITION_FAILED)) {
                    setStateAsUnsentRetryable();
                }
                throw RootAPIException.wrap(e);
            } catch (ParseException e2) {
                setStateAsUnsentRetryable();
                throw RootAPIException.wrap(e2);
            }
        }
    }

    public void setState(UserMessageState userMessageState) {
        UserMessageState userMessageState2 = this.state;
        this.state = userMessageState;
        if (userMessageState2 != userMessageState) {
            notifyUpdated();
        }
    }

    public void updateState(boolean z) {
        if (!StringUtils.isEmpty(this.serverId)) {
            setState(UserMessageState.SENT);
        } else if (this.state != UserMessageState.SENDING) {
            if (z) {
                setState(UserMessageState.UNSENT_RETRYABLE);
            } else {
                setState(UserMessageState.UNSENT_NOT_RETRYABLE);
            }
        }
    }

    public UserMessageDM(String str, String str2, long j, Author author, MessageType messageType) {
        super(str, str2, j, author, false, messageType);
    }

    public UserMessageDM(UserMessageDM userMessageDM) {
        super(userMessageDM);
        this.state = userMessageDM.state;
    }

    public UserMessageDM deepClone() {
        return new UserMessageDM(this);
    }
}
