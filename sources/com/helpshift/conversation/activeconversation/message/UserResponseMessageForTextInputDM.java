package com.helpshift.conversation.activeconversation.message;

import com.facebook.login.LoginLogger;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.activeconversation.message.input.TextInput;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserResponseMessageForTextInputDM extends UserMessageDM {
    public String botInfo;
    public long dateInMillis;
    public final boolean isMessageEmpty;
    public int keyboard;
    public String referredMessageId;
    public boolean skipped;
    public String timeZoneId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserResponseMessageForTextInputDM(String str, String str2, long j, Author author, int i, String str3, boolean z, String str4, boolean z2) {
        super(str, str2, j, author, MessageType.USER_RESP_FOR_TEXT_INPUT);
        this.keyboard = i;
        this.botInfo = str3;
        this.skipped = z;
        this.referredMessageId = str4;
        this.isMessageEmpty = z2;
    }

    public Map<String, String> getData() throws ParseException {
        HashMap hashMap = new HashMap();
        hashMap.put("chatbot_info", this.botInfo);
        hashMap.put(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, String.valueOf(this.skipped));
        if (this.keyboard == 4 && !this.skipped) {
            Date parse = HSDateFormatSpec.getDateFormatter(HSDateFormatSpec.DISPLAY_DATE_PATTERN, this.domain.getLocaleProviderDM().getCurrentLocale()).parse(this.body.trim());
            HashMap hashMap2 = new HashMap();
            this.dateInMillis = parse.getTime();
            this.timeZoneId = this.platform.getDevice().getTimeZoneId();
            hashMap2.put("dt", Long.valueOf(this.dateInMillis));
            hashMap2.put("timezone", this.timeZoneId);
            hashMap.put("message_meta", this.platform.getJsonifier().jsonify((Map<String, Object>) hashMap2));
        }
        return hashMap;
    }

    public String getMessageTypeForRequest() {
        int i = this.keyboard;
        if (i == 1) {
            return this.isMessageEmpty ? "rsp_empty_msg_with_txt_input" : "rsp_txt_msg_with_txt_input";
        }
        if (i == 2) {
            return "rsp_txt_msg_with_email_input";
        }
        if (i != 3) {
            return i != 4 ? super.getMessageTypeForRequest() : "rsp_txt_msg_with_dt_input";
        }
        return "rsp_txt_msg_with_numeric_input";
    }

    public String getReferredMessageId() {
        return this.referredMessageId;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof UserResponseMessageForTextInputDM) {
            UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = (UserResponseMessageForTextInputDM) messageDM;
            this.keyboard = userResponseMessageForTextInputDM.keyboard;
            this.botInfo = userResponseMessageForTextInputDM.botInfo;
            this.skipped = userResponseMessageForTextInputDM.skipped;
            this.referredMessageId = userResponseMessageForTextInputDM.referredMessageId;
            this.dateInMillis = userResponseMessageForTextInputDM.dateInMillis;
            this.timeZoneId = userResponseMessageForTextInputDM.timeZoneId;
        }
    }

    public UserMessageDM parseResponse(Response response) {
        return this.platform.getResponseParser().parseResponseMessageForTextInput(response.responseString);
    }

    public UserResponseMessageForTextInputDM deepClone() {
        return new UserResponseMessageForTextInputDM(this);
    }

    public UserResponseMessageForTextInputDM(String str, String str2, long j, Author author, AdminMessageWithTextInputDM adminMessageWithTextInputDM, boolean z) {
        super(str, str2, j, author, MessageType.USER_RESP_FOR_TEXT_INPUT);
        TextInput textInput = adminMessageWithTextInputDM.input;
        this.keyboard = textInput.keyboard;
        this.botInfo = textInput.botInfo;
        this.skipped = z;
        this.referredMessageId = adminMessageWithTextInputDM.serverId;
        this.isMessageEmpty = adminMessageWithTextInputDM.isMessageEmpty;
    }

    public UserResponseMessageForTextInputDM(UserResponseMessageForTextInputDM userResponseMessageForTextInputDM) {
        super(userResponseMessageForTextInputDM);
        this.isMessageEmpty = userResponseMessageForTextInputDM.isMessageEmpty;
        this.keyboard = userResponseMessageForTextInputDM.keyboard;
        this.botInfo = userResponseMessageForTextInputDM.botInfo;
        this.skipped = userResponseMessageForTextInputDM.skipped;
        this.dateInMillis = userResponseMessageForTextInputDM.dateInMillis;
        this.timeZoneId = userResponseMessageForTextInputDM.timeZoneId;
        this.referredMessageId = userResponseMessageForTextInputDM.referredMessageId;
    }
}
