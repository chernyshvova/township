package com.helpshift.widget;

import com.helpshift.conversation.dto.AttachmentPickerFile;

public class ImageAttachmentViewState extends HSBaseObservable {
    public AttachmentPickerFile attachmentPickerFile;
    public boolean clickable = true;

    public AttachmentPickerFile getAttachmentPickerFile() {
        return this.attachmentPickerFile;
    }

    public String getImagePath() {
        String str;
        AttachmentPickerFile attachmentPickerFile2 = this.attachmentPickerFile;
        if (attachmentPickerFile2 == null || (str = attachmentPickerFile2.filePath) == null) {
            return "";
        }
        return str;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
