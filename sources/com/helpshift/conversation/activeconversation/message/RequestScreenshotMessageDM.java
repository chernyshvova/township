package com.helpshift.conversation.activeconversation.message;

import com.helpshift.common.platform.Platform;

public class RequestScreenshotMessageDM extends MessageDM {
    public boolean isAnswered;
    public boolean isAttachmentButtonClickable;
    public Boolean isImageWhiteListed;

    public RequestScreenshotMessageDM(String str, String str2, String str3, long j, Author author, boolean z) {
        super(str2, str3, j, author, true, MessageType.REQUESTED_SCREENSHOT);
        this.serverId = str;
        this.isAnswered = z;
        this.isAttachmentButtonClickable = true;
    }

    public boolean isAttachmentAllowed() {
        if (this.isImageWhiteListed == null) {
            this.isImageWhiteListed = Boolean.valueOf(this.domain.getSDKConfigurationDM().isImageWhiteListed());
        }
        return !this.isAnswered && this.isImageWhiteListed.booleanValue();
    }

    public boolean isAttachmentButtonClickable() {
        return !this.isAnswered && this.isAttachmentButtonClickable;
    }

    public boolean isUISupportedMessage() {
        return true;
    }

    public void merge(MessageDM messageDM) {
        super.merge(messageDM);
        if (messageDM instanceof RequestScreenshotMessageDM) {
            this.isAnswered = ((RequestScreenshotMessageDM) messageDM).isAnswered;
        }
    }

    public void setAttachmentButtonClickable(boolean z) {
        this.isAttachmentButtonClickable = z;
        notifyUpdated();
    }

    public void setIsAnswered(Platform platform, boolean z) {
        this.isAnswered = z;
        platform.getConversationDAO().insertOrUpdateMessage(this);
        notifyUpdated();
    }

    public RequestScreenshotMessageDM deepClone() {
        return new RequestScreenshotMessageDM(this);
    }

    public RequestScreenshotMessageDM(RequestScreenshotMessageDM requestScreenshotMessageDM) {
        super(requestScreenshotMessageDM);
        this.isAnswered = requestScreenshotMessageDM.isAnswered;
        this.isAttachmentButtonClickable = requestScreenshotMessageDM.isAttachmentButtonClickable;
        this.isImageWhiteListed = requestScreenshotMessageDM.isImageWhiteListed;
    }
}
