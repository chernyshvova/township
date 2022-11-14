package com.helpshift.conversation.activeconversation.message;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.util.FileUtil;
import com.helpshift.util.StringUtils;

public class AdminAttachmentMessageDM extends AttachmentMessageDM {
    public int downloadProgress = 0;
    public AdminGenericAttachmentState state;

    public enum AdminGenericAttachmentState {
        DOWNLOAD_NOT_STARTED,
        DOWNLOADING,
        DOWNLOADED
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminAttachmentMessageDM(String str, String str2, String str3, long j, Author author, int i, String str4, String str5, String str6, boolean z) {
        super(str2, str3, j, author, i, str4, str5, str6, true, z, MessageType.ADMIN_ATTACHMENT);
        this.serverId = str;
        updateState();
    }

    public String checkAndGetFilePath() {
        if (isValidUriPath(this.filePath)) {
            Platform platform = this.platform;
            if (platform != null && !platform.canReadFileAtUri(this.filePath)) {
                this.filePath = null;
                this.state = AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED;
            }
        } else if (!FileUtil.doesFilePathExistAndCanRead(this.filePath)) {
            this.filePath = null;
            this.state = AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED;
        }
        return this.filePath;
    }

    public String getDownloadProgressAndFileSize() {
        String downloadedProgressSize = getDownloadedProgressSize();
        if (StringUtils.isEmpty(downloadedProgressSize)) {
            return getFormattedFileSize();
        }
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(downloadedProgressSize, "/");
        outline26.append(getFormattedFileSize());
        return outline26.toString();
    }

    public String getDownloadedProgressSize() {
        int i;
        if (this.state == AdminGenericAttachmentState.DOWNLOADING && (i = this.downloadProgress) > 0) {
            int i2 = this.size;
            double d = (double) (i * i2);
            Double.isNaN(d);
            double d2 = d / 100.0d;
            if (d2 < ((double) i2)) {
                return getFormattedFileSize(d2);
            }
        }
        return null;
    }

    public void handleClick(ConversationVMCallback conversationVMCallback) {
        AdminGenericAttachmentState adminGenericAttachmentState = this.state;
        if (adminGenericAttachmentState == AdminGenericAttachmentState.DOWNLOADED) {
            if (conversationVMCallback != null) {
                conversationVMCallback.launchAttachment(checkAndGetFilePath(), this.contentType);
            }
        } else if (adminGenericAttachmentState == AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED) {
            setState(AdminGenericAttachmentState.DOWNLOADING);
            this.platform.getDownloader().startDownload(new AdminFileInfo(this.attachmentUrl, this.fileName, this.contentType, this.isSecureAttachment), SupportDownloader.StorageDirType.EXTERNAL_ONLY, new AuthDataProvider(this.domain, this.platform, this.attachmentUrl), new SupportDownloadStateChangeListener() {
                public void onFailure(String str, int i) {
                    AdminAttachmentMessageDM.this.setState(AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED);
                }

                public void onProgressChange(String str, int i) {
                    AdminAttachmentMessageDM adminAttachmentMessageDM = AdminAttachmentMessageDM.this;
                    adminAttachmentMessageDM.downloadProgress = i;
                    adminAttachmentMessageDM.notifyUpdated();
                }

                public void onSuccess(String str, String str2, String str3) {
                    String unused = AdminAttachmentMessageDM.this.filePath = str2;
                    AdminAttachmentMessageDM.this.platform.getConversationDAO().insertOrUpdateMessage(AdminAttachmentMessageDM.this);
                    AdminAttachmentMessageDM.this.setState(AdminGenericAttachmentState.DOWNLOADED);
                }
            });
        }
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public boolean isWriteStoragePermissionRequired() {
        return this.state == AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED;
    }

    public void setDependencies(Domain domain, Platform platform) {
        super.setDependencies(domain, platform);
        if (isValidUriPath(this.filePath)) {
            updateState();
        }
    }

    public void setState(AdminGenericAttachmentState adminGenericAttachmentState) {
        this.state = adminGenericAttachmentState;
        notifyUpdated();
    }

    public void updateState() {
        if (checkAndGetFilePath() != null) {
            this.state = AdminGenericAttachmentState.DOWNLOADED;
        } else {
            this.state = AdminGenericAttachmentState.DOWNLOAD_NOT_STARTED;
        }
    }

    public AdminAttachmentMessageDM deepClone() {
        return new AdminAttachmentMessageDM(this);
    }

    public AdminAttachmentMessageDM(AdminAttachmentMessageDM adminAttachmentMessageDM) {
        super(adminAttachmentMessageDM);
        this.state = adminAttachmentMessageDM.state;
        this.downloadProgress = adminAttachmentMessageDM.downloadProgress;
    }
}
