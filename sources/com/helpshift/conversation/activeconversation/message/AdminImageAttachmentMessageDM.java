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

public class AdminImageAttachmentMessageDM extends ImageAttachmentMessageDM {
    public int downloadProgress;
    public AdminImageAttachmentState state;

    public enum AdminImageAttachmentState {
        DOWNLOAD_NOT_STARTED,
        THUMBNAIL_DOWNLOADING,
        THUMBNAIL_DOWNLOADED,
        IMAGE_DOWNLOADING,
        IMAGE_DOWNLOADED
    }

    public AdminImageAttachmentMessageDM(String str, String str2, String str3, long j, Author author, String str4, String str5, String str6, String str7, boolean z, int i) {
        super(str2, str3, j, author, str4, str5, str6, str7, i, true, z, MessageType.ADMIN_IMAGE_ATTACHMENT);
        this.serverId = str;
        updateState();
    }

    public String checkAndGetFilePath() {
        if (isValidUriPath(this.filePath)) {
            Platform platform = this.platform;
            if (platform != null && !platform.canReadFileAtUri(this.filePath)) {
                this.filePath = null;
            }
        } else if (!FileUtil.doesFilePathExistAndCanRead(this.filePath)) {
            this.filePath = null;
        }
        if (this.filePath == null && checkAndGetThumbnailFilePath() != null) {
            this.state = AdminImageAttachmentState.THUMBNAIL_DOWNLOADED;
        }
        return this.filePath;
    }

    public String checkAndGetThumbnailFilePath() {
        if (!FileUtil.doesFilePathExistAndCanRead(this.thumbnailFilePath)) {
            this.state = AdminImageAttachmentState.DOWNLOAD_NOT_STARTED;
            this.thumbnailFilePath = null;
        }
        return this.thumbnailFilePath;
    }

    public void downloadThumbnailImage(final Platform platform) {
        if (this.state == AdminImageAttachmentState.DOWNLOAD_NOT_STARTED) {
            setState(AdminImageAttachmentState.THUMBNAIL_DOWNLOADING);
            platform.getDownloader().startDownload(new AdminFileInfo(this.thumbnailUrl, (String) null, (String) null, this.isSecureAttachment), SupportDownloader.StorageDirType.EXTERNAL_OR_INTERNAL, new AuthDataProvider(this.domain, platform, this.attachmentUrl), new SupportDownloadStateChangeListener() {
                public void onFailure(String str, int i) {
                    AdminImageAttachmentMessageDM.this.setState(AdminImageAttachmentState.DOWNLOAD_NOT_STARTED);
                }

                public void onProgressChange(String str, int i) {
                }

                public void onSuccess(String str, String str2, String str3) {
                    AdminImageAttachmentMessageDM.this.thumbnailFilePath = str2;
                    platform.getConversationDAO().insertOrUpdateMessage(AdminImageAttachmentMessageDM.this);
                    AdminImageAttachmentMessageDM.this.setState(AdminImageAttachmentState.THUMBNAIL_DOWNLOADED);
                }
            });
        }
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
        if (this.state == AdminImageAttachmentState.IMAGE_DOWNLOADING && (i = this.downloadProgress) > 0) {
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
        AdminImageAttachmentState adminImageAttachmentState = this.state;
        if (adminImageAttachmentState == AdminImageAttachmentState.IMAGE_DOWNLOADED) {
            if (conversationVMCallback != null) {
                conversationVMCallback.launchAttachment(checkAndGetFilePath(), this.contentType);
            }
        } else if (adminImageAttachmentState == AdminImageAttachmentState.DOWNLOAD_NOT_STARTED || adminImageAttachmentState == AdminImageAttachmentState.THUMBNAIL_DOWNLOADING || adminImageAttachmentState == AdminImageAttachmentState.THUMBNAIL_DOWNLOADED) {
            setState(AdminImageAttachmentState.IMAGE_DOWNLOADING);
            this.platform.getDownloader().startDownload(new AdminFileInfo(this.attachmentUrl, this.fileName, this.contentType, this.isSecureAttachment), SupportDownloader.StorageDirType.EXTERNAL_ONLY, new AuthDataProvider(this.domain, this.platform, this.attachmentUrl), new SupportDownloadStateChangeListener() {
                public void onFailure(String str, int i) {
                    AdminImageAttachmentMessageDM.this.setState(AdminImageAttachmentState.THUMBNAIL_DOWNLOADED);
                }

                public void onProgressChange(String str, int i) {
                    int unused = AdminImageAttachmentMessageDM.this.downloadProgress = i;
                    AdminImageAttachmentMessageDM.this.notifyUpdated();
                }

                public void onSuccess(String str, String str2, String str3) {
                    AdminImageAttachmentMessageDM adminImageAttachmentMessageDM = AdminImageAttachmentMessageDM.this;
                    adminImageAttachmentMessageDM.filePath = str2;
                    adminImageAttachmentMessageDM.platform.getConversationDAO().insertOrUpdateMessage(AdminImageAttachmentMessageDM.this);
                    AdminImageAttachmentMessageDM.this.setState(AdminImageAttachmentState.IMAGE_DOWNLOADED);
                }
            });
        }
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public void setDependencies(Domain domain, Platform platform) {
        super.setDependencies(domain, platform);
        if (isValidUriPath(this.filePath)) {
            updateState();
        }
    }

    public void setState(AdminImageAttachmentState adminImageAttachmentState) {
        this.state = adminImageAttachmentState;
        notifyUpdated();
    }

    public void updateState() {
        if (checkAndGetFilePath() != null) {
            this.state = AdminImageAttachmentState.IMAGE_DOWNLOADED;
        } else if (checkAndGetThumbnailFilePath() != null) {
            this.state = AdminImageAttachmentState.THUMBNAIL_DOWNLOADED;
        } else {
            this.state = AdminImageAttachmentState.DOWNLOAD_NOT_STARTED;
        }
    }

    public AdminImageAttachmentMessageDM deepClone() {
        return new AdminImageAttachmentMessageDM(this);
    }

    public AdminImageAttachmentMessageDM(AdminImageAttachmentMessageDM adminImageAttachmentMessageDM) {
        super(adminImageAttachmentMessageDM);
        this.state = adminImageAttachmentMessageDM.state;
        this.downloadProgress = adminImageAttachmentMessageDM.downloadProgress;
    }
}
