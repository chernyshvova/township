package com.helpshift.conversation.activeconversation.message;

import com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput;
import java.util.List;

public class AdminCSATMessageWithOptions extends AdminMessageDM {
    public CSATRatingsInput csatRatingsInput;

    public AdminCSATMessageWithOptions(String str, String str2, String str3, long j, Author author, String str4, boolean z, String str5, String str6, String str7, boolean z2, String str8, List<CSATRatingsInput.Rating> list, CSATRatingsInput.Type type) {
        super(str, str2, str3, j, author, MessageType.ADMIN_CSAT_MESSAGE);
        this.csatRatingsInput = new CSATRatingsInput(str4, z, str5, str6, str7, z2, str8, list, type);
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof AdminCSATMessageWithOptions) {
            this.csatRatingsInput = ((AdminCSATMessageWithOptions) messageDM).csatRatingsInput;
        }
    }

    public AdminCSATMessageWithOptions(AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        super(adminCSATMessageWithOptions);
        this.csatRatingsInput = adminCSATMessageWithOptions.csatRatingsInput.deepClone();
    }

    public AdminCSATMessageWithOptions deepClone() {
        return new AdminCSATMessageWithOptions(this);
    }
}
