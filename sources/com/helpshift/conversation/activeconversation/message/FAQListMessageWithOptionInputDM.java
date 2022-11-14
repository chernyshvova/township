package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import java.util.ArrayList;
import java.util.List;

public class FAQListMessageWithOptionInputDM extends FAQListMessageDM {
    public static final String KEY_SUGGESTIONS_READ_FAQ_PREFIX = "read_faq_";
    public OptionInput input;
    public ArrayList<String> readFAQs;

    public FAQListMessageWithOptionInputDM(String str, String str2, String str3, long j, Author author, List<FAQListMessageDM.FAQ> list, String str4, String str5, boolean z, String str6, String str7, List<OptionInput.Option> list2) {
        super(str, str2, str3, j, author, list, str4, MessageType.FAQ_LIST_WITH_OPTION_INPUT);
        this.input = new OptionInput(str5, z, str6, str7, list2, OptionInput.Type.PILL);
    }

    private void populateReadFAQs() {
        if (this.readFAQs == null) {
            this.readFAQs = new ArrayList<>();
            KVStore kVStore = this.platform.getKVStore();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(KEY_SUGGESTIONS_READ_FAQ_PREFIX);
            outline24.append(this.serverId);
            Object serializable = kVStore.getSerializable(outline24.toString());
            if (serializable instanceof ArrayList) {
                this.readFAQs = (ArrayList) serializable;
            }
        }
    }

    public void handleSuggestionClick(ConversationServerInfo conversationServerInfo, UserDM userDM, String str, String str2) {
        if (this.readFAQs.size() < 10) {
            this.readFAQs.add(str);
            KVStore kVStore = this.platform.getKVStore();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(KEY_SUGGESTIONS_READ_FAQ_PREFIX);
            outline24.append(this.serverId);
            kVStore.setSerializable(outline24.toString(), this.readFAQs);
        }
        super.handleSuggestionClick(conversationServerInfo, userDM, str, str2);
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof FAQListMessageWithOptionInputDM) {
            this.input = ((FAQListMessageWithOptionInputDM) messageDM).input;
        }
    }

    public void setDependencies(Domain domain, Platform platform) {
        super.setDependencies(domain, platform);
        populateReadFAQs();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FAQListMessageWithOptionInputDM(String str, String str2, String str3, long j, Author author, List<FAQListMessageDM.FAQ> list, String str4, String str5, boolean z, String str6, String str7, List<OptionInput.Option> list2, boolean z2, String str8) {
        super(str, str2, str3, j, author, list, str4, MessageType.FAQ_LIST_WITH_OPTION_INPUT);
        this.input = new OptionInput(str5, z, str6, str7, list2, OptionInput.Type.PILL);
        this.isSuggestionsReadEventSent = z2;
        this.suggestionsReadFAQPublishId = str8;
    }

    public FAQListMessageWithOptionInputDM deepClone() {
        return new FAQListMessageWithOptionInputDM(this);
    }

    public FAQListMessageWithOptionInputDM(FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM) {
        super((FAQListMessageDM) fAQListMessageWithOptionInputDM);
        this.input = fAQListMessageWithOptionInputDM.input.deepClone();
        this.readFAQs = fAQListMessageWithOptionInputDM.readFAQs == null ? null : new ArrayList<>(fAQListMessageWithOptionInputDM.readFAQs);
    }
}
