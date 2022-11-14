package com.helpshift.support.conversations;

import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.support.Faq;
import java.util.ArrayList;

public interface NewConversationRouter {
    void exitNewConversationView();

    void onAuthenticationFailure();

    void showAttachmentPreviewScreenFromDraft(AttachmentPickerFile attachmentPickerFile);

    void showConversationScreen();

    void showSearchResultFragment(ArrayList<Faq> arrayList);
}
