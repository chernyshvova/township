package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.login.LoginLogger;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResponseMessageForOptionInput extends UserMessageDM {
    public String botInfo;
    public String optionData;
    public String referredMessageId;
    public MessageType referredMessageType;
    public boolean skipped;

    /* renamed from: com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput$1 */
    public static /* synthetic */ class C25511 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$MessageType */
        public static final /* synthetic */ int[] f3337x18a4a544;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.MessageType[] r0 = com.helpshift.conversation.activeconversation.message.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3337x18a4a544 = r0
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 14
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f3337x18a4a544     // Catch:{ NoSuchFieldError -> 0x0019 }
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.FAQ_LIST_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 16
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = f3337x18a4a544     // Catch:{ NoSuchFieldError -> 0x0022 }
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 30
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput.C25511.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserResponseMessageForOptionInput(String str, String str2, long j, Author author, String str3, boolean z, String str4, String str5, MessageType messageType) {
        super(str, str2, j, author, MessageType.USER_RESP_FOR_OPTION_INPUT);
        this.botInfo = str3;
        this.skipped = z;
        this.optionData = str4;
        this.referredMessageId = str5;
        this.referredMessageType = messageType;
    }

    private String getSelectedOptionData(List<OptionInput.Option> list) {
        for (OptionInput.Option next : list) {
            if (next.title.equals(this.body)) {
                return next.jsonData;
            }
        }
        return JsonUtils.EMPTY_JSON;
    }

    public Map<String, String> getData() {
        HashMap hashMap = new HashMap();
        hashMap.put("chatbot_info", this.botInfo);
        hashMap.put(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, String.valueOf(this.skipped));
        if (!this.skipped) {
            hashMap.put("option_data", this.optionData);
        }
        if (this.referredMessageType == MessageType.FAQ_LIST_WITH_OPTION_INPUT) {
            List arrayList = new ArrayList();
            KVStore kVStore = this.platform.getKVStore();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(FAQListMessageWithOptionInputDM.KEY_SUGGESTIONS_READ_FAQ_PREFIX);
            outline24.append(this.referredMessageId);
            Object serializable = kVStore.getSerializable(outline24.toString());
            if (serializable instanceof ArrayList) {
                arrayList = (List) serializable;
            }
            hashMap.put("read_faqs", this.platform.getJsonifier().jsonifyListToJsonArray(arrayList).toString());
        }
        return hashMap;
    }

    public String getMessageTypeForRequest() {
        int ordinal = this.referredMessageType.ordinal();
        if (ordinal == 14) {
            return "rsp_txt_msg_with_option_input";
        }
        if (ordinal != 16) {
            return ordinal != 30 ? super.getMessageTypeForRequest() : "rsp_txt_resolution_msg_with_option_input";
        }
        return "rsp_faq_list_msg_with_option_input";
    }

    public String getReferredMessageId() {
        return this.referredMessageId;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof UserResponseMessageForOptionInput) {
            UserResponseMessageForOptionInput userResponseMessageForOptionInput = (UserResponseMessageForOptionInput) messageDM;
            this.botInfo = userResponseMessageForOptionInput.botInfo;
            this.skipped = userResponseMessageForOptionInput.skipped;
            this.optionData = userResponseMessageForOptionInput.optionData;
            this.referredMessageId = userResponseMessageForOptionInput.referredMessageId;
            this.referredMessageType = userResponseMessageForOptionInput.referredMessageType;
        }
    }

    public UserMessageDM parseResponse(Response response) {
        return this.platform.getResponseParser().parseResponseMessageForOptionInput(response.responseString);
    }

    public UserResponseMessageForOptionInput deepClone() {
        return new UserResponseMessageForOptionInput(this);
    }

    public UserResponseMessageForOptionInput(String str, String str2, long j, Author author, OptionInputMessageDM optionInputMessageDM, boolean z) {
        super(str, str2, j, author, MessageType.USER_RESP_FOR_OPTION_INPUT);
        OptionInput optionInput = optionInputMessageDM.input;
        this.botInfo = optionInput.botInfo;
        this.skipped = z;
        this.optionData = getSelectedOptionData(optionInput.options);
        this.referredMessageId = optionInputMessageDM.serverId;
        this.referredMessageType = optionInputMessageDM.referredMessageType;
    }

    public UserResponseMessageForOptionInput(UserResponseMessageForOptionInput userResponseMessageForOptionInput) {
        super(userResponseMessageForOptionInput);
        this.botInfo = userResponseMessageForOptionInput.botInfo;
        this.skipped = userResponseMessageForOptionInput.skipped;
        this.optionData = userResponseMessageForOptionInput.optionData;
        this.referredMessageType = userResponseMessageForOptionInput.referredMessageType;
        this.referredMessageId = userResponseMessageForOptionInput.referredMessageId;
    }
}
