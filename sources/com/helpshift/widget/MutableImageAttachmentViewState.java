package com.helpshift.widget;

import com.helpshift.conversation.dto.AttachmentPickerFile;

public class MutableImageAttachmentViewState extends ImageAttachmentViewState {
    public void setAttachmentPickerFile(AttachmentPickerFile attachmentPickerFile) {
        this.attachmentPickerFile = attachmentPickerFile;
        notifyChange(this);
    }

    public void setClickable(boolean z) {
        this.clickable = z;
        notifyChange(this);
    }
}
