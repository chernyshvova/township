package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import java.util.HashMap;
import java.util.Map;

public class UserResponseMessageForCSATInput extends UserMessageDM {
    public String botInfo;
    public boolean isNewConversationStarted;
    public int messageSyncState;
    public String optionData;
    public int rating;
    public String referredMessageId;
    public final MessageType referredMessageType = MessageType.ADMIN_CSAT_MESSAGE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserResponseMessageForCSATInput(String str, String str2, long j, Author author, int i, boolean z, String str3, String str4, String str5, int i2) {
        super(str, str2, j, author, MessageType.USER_RESP_FOR_CSAT);
        this.botInfo = str3;
        this.optionData = str4;
        this.referredMessageId = str5;
        this.isNewConversationStarted = z;
        this.rating = i;
        this.messageSyncState = i2;
    }

    public Map<String, String> getData() {
        HashMap hashMap = new HashMap();
        hashMap.put("chatbot_info", this.botInfo);
        hashMap.put("new_conv_started", String.valueOf(this.isNewConversationStarted));
        if (!this.isNewConversationStarted) {
            hashMap.put("rating_data", this.optionData);
        }
        return hashMap;
    }

    public String getMessageTypeForRequest() {
        return "rsp_txt_csat_msg_with_option_input";
    }

    public String getReferredMessageId() {
        return this.referredMessageId;
    }

    public boolean isUISupportedMessage() {
        return !this.isNewConversationStarted;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof UserResponseMessageForCSATInput) {
            UserResponseMessageForCSATInput userResponseMessageForCSATInput = (UserResponseMessageForCSATInput) messageDM;
            this.botInfo = userResponseMessageForCSATInput.botInfo;
            this.optionData = userResponseMessageForCSATInput.optionData;
            this.referredMessageId = userResponseMessageForCSATInput.referredMessageId;
            this.isNewConversationStarted = userResponseMessageForCSATInput.isNewConversationStarted;
            this.rating = userResponseMessageForCSATInput.rating;
            this.messageSyncState = userResponseMessageForCSATInput.messageSyncState;
        }
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        super.send(userDM, conversationServerInfo);
        this.messageSyncState = 2;
        this.platform.getConversationDAO().insertOrUpdateMessage(this);
    }

    public UserResponseMessageForCSATInput parseResponse(Response response) {
        return this.platform.getResponseParser().parseResponseMessageForCSATInput(response.responseString);
    }

    public UserResponseMessageForCSATInput deepClone() {
        return new UserResponseMessageForCSATInput(this);
    }

    public UserResponseMessageForCSATInput(UserResponseMessageForCSATInput userResponseMessageForCSATInput) {
        super(userResponseMessageForCSATInput);
        this.botInfo = userResponseMessageForCSATInput.botInfo;
        this.optionData = userResponseMessageForCSATInput.optionData;
        this.referredMessageId = userResponseMessageForCSATInput.referredMessageId;
        this.isNewConversationStarted = userResponseMessageForCSATInput.isNewConversationStarted;
        this.rating = userResponseMessageForCSATInput.rating;
        this.messageSyncState = userResponseMessageForCSATInput.messageSyncState;
    }
}
