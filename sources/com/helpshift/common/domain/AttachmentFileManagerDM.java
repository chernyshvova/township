package com.helpshift.common.domain;

import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import java.io.File;

public class AttachmentFileManagerDM {
    public static final String LOCAL_RSC_MESSAGE_PREFIX = "localRscMessage_";
    public Domain domain;
    public Platform platform;

    public interface Listener {
        void onCompressAndCopyFailure(RootAPIException rootAPIException);

        void onCompressAndCopySuccess(AttachmentPickerFile attachmentPickerFile);
    }

    public AttachmentFileManagerDM(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
    }

    public void compressAndCopyAttachment(final AttachmentPickerFile attachmentPickerFile, final Listener listener) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                try {
                    AttachmentFileManagerDM.this.platform.compressAndCopyAttachment(attachmentPickerFile);
                    listener.onCompressAndCopySuccess(attachmentPickerFile);
                } catch (RootAPIException e) {
                    listener.onCompressAndCopyFailure(e);
                    throw e;
                }
            }
        });
    }

    public void deleteAttachmentLocalCopy(AttachmentPickerFile attachmentPickerFile) {
        if (attachmentPickerFile != null && attachmentPickerFile.filePath != null && attachmentPickerFile.isFileCompressionAndCopyingDone) {
            new File(attachmentPickerFile.filePath).delete();
        }
    }
}
