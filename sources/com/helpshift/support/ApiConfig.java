package com.helpshift.support;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.fragments.MainFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiConfig {
    public final String conversationPrefillText;
    public final List<Flow> customContactUsFlows;
    public final Map<String, String[]> customIssueFields;
    public final Metadata customMetadata;
    public final Integer enableContactUs;
    public final boolean enableFullPrivacy;
    public final boolean enableTypingIndicator;
    public final Map<String, Object> extras;
    public final boolean gotoConversationAfterContactUs;
    public final boolean hideNameAndEmail;
    public final boolean requireEmail;
    public final boolean showConversationInfoScreen;
    public final boolean showConversationResolutionQuestion;
    public final boolean showSearchOnNewConversation;
    public final int toolbarId;
    public final FaqTagFilter withTagsMatching;

    public static class Builder {
        public String conversationPrefillText;
        public List<Flow> customContactUsFlows;
        public Map<String, String[]> customIssueFields;
        public Metadata customMetadata;
        public Integer enableContactUs = SupportInternal.EnableContactUs.ALWAYS;
        public boolean enableFullPrivacy = false;
        public boolean enableTypingIndicator = false;
        public Map<String, Object> extras;
        public boolean gotoConversationAfterContactUs = false;
        public boolean hideNameAndEmail = false;
        public boolean isGotoConversationAfterContactUsSet = false;
        public boolean requireEmail = false;
        public boolean showConversationInfoScreen = false;
        public boolean showConversationResolutionQuestion = false;
        public boolean showSearchOnNewConversation = false;
        public int toolbarId;
        public FaqTagFilter withTagsMatching;

        public ApiConfig build() {
            return new ApiConfig(this.enableContactUs, this.gotoConversationAfterContactUs, this.requireEmail, this.hideNameAndEmail, this.conversationPrefillText, this.enableFullPrivacy, this.showSearchOnNewConversation, this.showConversationResolutionQuestion, this.customContactUsFlows, this.withTagsMatching, this.customMetadata, this.toolbarId, this.showConversationInfoScreen, this.enableTypingIndicator, this.customIssueFields, this.extras);
        }

        public Builder setConversationPrefillText(String str) {
            this.conversationPrefillText = str;
            return this;
        }

        public Builder setCustomContactUsFlows(List<Flow> list) {
            this.customContactUsFlows = list;
            return this;
        }

        public Builder setCustomIssueFields(Map<String, String[]> map) {
            this.customIssueFields = map;
            return this;
        }

        public Builder setCustomMetadata(Metadata metadata) {
            this.customMetadata = metadata;
            return this;
        }

        public Builder setEnableContactUs(Integer num) {
            if (num != null && SupportInternal.EnableContactUs.valueSet.contains(num)) {
                this.enableContactUs = num;
            }
            return this;
        }

        public Builder setEnableFullPrivacy(boolean z) {
            this.enableFullPrivacy = z;
            return this;
        }

        @Deprecated
        public Builder setEnableTypingIndicator(boolean z) {
            this.enableTypingIndicator = z;
            return this;
        }

        public Builder setExtras(Map<String, Object> map) {
            this.extras = map;
            return this;
        }

        @Deprecated
        public Builder setGotoConversationAfterContactUs(boolean z) {
            this.gotoConversationAfterContactUs = z;
            this.isGotoConversationAfterContactUsSet = true;
            return this;
        }

        @Deprecated
        public Builder setHideNameAndEmail(boolean z) {
            this.hideNameAndEmail = z;
            return this;
        }

        @Deprecated
        public Builder setRequireEmail(boolean z) {
            this.requireEmail = z;
            return this;
        }

        public Builder setShowConversationInfoScreen(boolean z) {
            this.showConversationInfoScreen = z;
            return this;
        }

        @Deprecated
        public Builder setShowConversationResolutionQuestion(boolean z) {
            this.showConversationResolutionQuestion = z;
            return this;
        }

        @Deprecated
        public Builder setShowSearchOnNewConversation(boolean z) {
            this.showSearchOnNewConversation = z;
            return this;
        }

        public Builder setToolbarId(int i) {
            this.toolbarId = i;
            return this;
        }

        public Builder setWithTagsMatching(FaqTagFilter faqTagFilter) {
            this.withTagsMatching = faqTagFilter;
            return this;
        }
    }

    public ApiConfig(Integer num, boolean z, boolean z2, boolean z3, String str, boolean z4, boolean z5, boolean z6, List<Flow> list, FaqTagFilter faqTagFilter, Metadata metadata, int i, boolean z7, boolean z8, Map<String, String[]> map, Map<String, Object> map2) {
        this.enableContactUs = num;
        this.gotoConversationAfterContactUs = z;
        this.requireEmail = z2;
        this.hideNameAndEmail = z3;
        this.conversationPrefillText = str;
        this.enableFullPrivacy = z4;
        this.showSearchOnNewConversation = z5;
        this.showConversationResolutionQuestion = z6;
        this.customContactUsFlows = list;
        this.withTagsMatching = faqTagFilter;
        this.customMetadata = metadata;
        this.toolbarId = i;
        this.showConversationInfoScreen = z7;
        this.enableTypingIndicator = z8;
        this.customIssueFields = map;
        this.extras = map2;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConfigurationDM.ENABLE_CONTACT_US, this.enableContactUs);
        hashMap.put(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US, Boolean.valueOf(this.gotoConversationAfterContactUs));
        hashMap.put(SDKConfigurationDM.REQUIRE_EMAIL, Boolean.valueOf(this.requireEmail));
        hashMap.put(SDKConfigurationDM.HIDE_NAME_AND_EMAIL, Boolean.valueOf(this.hideNameAndEmail));
        hashMap.put("enableFullPrivacy", Boolean.valueOf(this.enableFullPrivacy));
        hashMap.put(SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, Boolean.valueOf(this.showSearchOnNewConversation));
        hashMap.put(SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, Boolean.valueOf(this.showConversationResolutionQuestion));
        hashMap.put(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, Boolean.valueOf(this.showConversationInfoScreen));
        hashMap.put(SDKConfigurationDM.ENABLE_TYPING_INDICATOR, Boolean.valueOf(this.enableTypingIndicator));
        String str = this.conversationPrefillText;
        if (str != null && str.length() > 0) {
            hashMap.put(SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT, this.conversationPrefillText);
        }
        List<Flow> list = this.customContactUsFlows;
        if (list != null) {
            hashMap.put("customContactUsFlows", list);
        }
        FaqTagFilter faqTagFilter = this.withTagsMatching;
        if (!(faqTagFilter == null || (map = faqTagFilter.toMap()) == null)) {
            hashMap.put("withTagsMatching", map);
        }
        Metadata metadata = this.customMetadata;
        if (metadata != null) {
            Map<String, Object> map2 = metadata.toMap();
            if (map2.size() > 0) {
                hashMap.put("hs-custom-metadata", map2);
            }
        }
        Map<String, String[]> map3 = this.customIssueFields;
        if (map3 != null) {
            hashMap.put(Support.CustomIssueFieldKey, map3);
        }
        int i = this.toolbarId;
        if (i != 0) {
            hashMap.put(MainFragment.TOOLBAR_ID, Integer.valueOf(i));
        }
        Map<String, Object> map4 = this.extras;
        if (map4 != null) {
            for (String next : map4.keySet()) {
                if (this.extras.get(next) != null) {
                    hashMap.put(next, this.extras.get(next));
                }
            }
        }
        return hashMap;
    }
}
