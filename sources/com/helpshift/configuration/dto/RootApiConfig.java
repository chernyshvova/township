package com.helpshift.configuration.dto;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.util.MapUtil;
import com.helpshift.util.StringUtils;
import java.util.Map;

public class RootApiConfig {
    public final String conversationPrefillText;
    public final EnableContactUs enableContactUs;
    public final Boolean enableDefaultConversationalFiling;
    public final Boolean enableFullPrivacy;
    public final Boolean enableTypingIndicator;
    public final Boolean gotoConversationAfterContactUs;
    public final Boolean hideNameAndEmail;
    public final String initialUserMessageToAutoSend;
    public final Boolean requireEmail;
    public final Boolean showConversationInfoScreen;
    public final Boolean showConversationResolutionQuestion;
    public final Boolean showSearchOnNewConversation;

    public enum EnableContactUs {
        ALWAYS(0),
        NEVER(1),
        AFTER_VIEWING_FAQS(2),
        AFTER_MARKING_ANSWER_UNHELPFUL(3);
        
        public final int value;

        /* access modifiers changed from: public */
        EnableContactUs(int i) {
            this.value = i;
        }

        public static EnableContactUs fromInt(int i) {
            for (EnableContactUs enableContactUs : values()) {
                if (enableContactUs.getValue() == i) {
                    return enableContactUs;
                }
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class RootApiConfigBuilder {
        public String conversationPrefillText = "";
        public EnableContactUs enableContactUs;
        public Boolean enableDefaultConversationalFiling;
        public Boolean enableFullPrivacy;
        public Boolean enableTypingIndicator;
        public Boolean gotoConversationAfterContactUs;
        public Boolean hideNameAndEmail;
        public String initialUserMessageToAutoSend = "";
        public Boolean requireEmail;
        public Boolean showConversationInfoScreen;
        public Boolean showConversationResolutionQuestion;
        public Boolean showSearchOnNewConversation;

        public RootApiConfigBuilder applyMap(Map<String, Object> map) {
            Class cls = String.class;
            Class cls2 = Boolean.class;
            Integer num = (Integer) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_CONTACT_US, Integer.class, null);
            if (num != null) {
                this.enableContactUs = EnableContactUs.fromInt(num.intValue());
            }
            String str = SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US;
            if (!map.containsKey(str)) {
                str = map.containsKey("gotoCoversationAfterContactUs") ? "gotoCoversationAfterContactUs" : "";
            }
            this.gotoConversationAfterContactUs = (Boolean) MapUtil.getValue(map, str, cls2, this.gotoConversationAfterContactUs);
            this.requireEmail = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.REQUIRE_EMAIL, cls2, this.requireEmail);
            this.hideNameAndEmail = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.HIDE_NAME_AND_EMAIL, cls2, this.hideNameAndEmail);
            this.enableFullPrivacy = (Boolean) MapUtil.getValue(map, "enableFullPrivacy", cls2, this.enableFullPrivacy);
            this.showSearchOnNewConversation = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, cls2, this.showSearchOnNewConversation);
            this.showConversationResolutionQuestion = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, cls2, this.showConversationResolutionQuestion);
            String str2 = (String) MapUtil.getValue(map, SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT, cls, this.conversationPrefillText);
            this.conversationPrefillText = str2;
            if (StringUtils.isEmpty(str2)) {
                this.conversationPrefillText = "";
            }
            this.showConversationInfoScreen = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, cls2, this.showConversationInfoScreen);
            this.enableTypingIndicator = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_TYPING_INDICATOR, cls2, this.enableTypingIndicator);
            this.enableDefaultConversationalFiling = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_DEFAULT_CONVERSATIONAL_FILING, cls2, this.enableDefaultConversationalFiling);
            String str3 = (String) MapUtil.getValue(map, "initialUserMessage", cls, this.initialUserMessageToAutoSend);
            this.initialUserMessageToAutoSend = str3;
            String trim = str3.trim();
            this.initialUserMessageToAutoSend = trim;
            if (StringUtils.isEmpty(trim)) {
                this.initialUserMessageToAutoSend = "";
            }
            return this;
        }

        public RootApiConfig build() {
            return new RootApiConfig(this.gotoConversationAfterContactUs, this.requireEmail, this.hideNameAndEmail, this.enableFullPrivacy, this.showSearchOnNewConversation, this.showConversationResolutionQuestion, this.enableContactUs, this.conversationPrefillText, this.showConversationInfoScreen, this.enableTypingIndicator, this.enableDefaultConversationalFiling, this.initialUserMessageToAutoSend);
        }
    }

    public RootApiConfig(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, EnableContactUs enableContactUs2, String str, Boolean bool7, Boolean bool8, Boolean bool9, String str2) {
        this.enableContactUs = enableContactUs2;
        this.gotoConversationAfterContactUs = bool;
        this.requireEmail = bool2;
        this.hideNameAndEmail = bool3;
        this.conversationPrefillText = str;
        this.enableFullPrivacy = bool4;
        this.showSearchOnNewConversation = bool5;
        this.showConversationResolutionQuestion = bool6;
        this.showConversationInfoScreen = bool7;
        this.enableTypingIndicator = bool8;
        this.enableDefaultConversationalFiling = bool9;
        this.initialUserMessageToAutoSend = str2;
    }
}
