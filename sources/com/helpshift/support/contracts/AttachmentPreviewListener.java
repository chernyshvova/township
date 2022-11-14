package com.helpshift.support.contracts;

import android.os.Bundle;
import com.helpshift.conversation.dto.AttachmentPickerFile;

public interface AttachmentPreviewListener {
    void addAttachment(AttachmentPickerFile attachmentPickerFile);

    void changeAttachment(Bundle bundle);

    void removeAttachment();

    void removeAttachmentPreviewFragment();

    void sendAttachment(AttachmentPickerFile attachmentPickerFile, String str);
}
