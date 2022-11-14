package com.helpshift.conversation.activeconversation.message;

public class SystemPublishIdMessageDM extends SystemMessageDM {
    public boolean isFirstMessageInList;

    public SystemPublishIdMessageDM(String str, String str2, long j, boolean z) {
        super(str, str2, j, MessageType.SYSTEM_PUBLISH_ID);
        this.isFirstMessageInList = z;
    }

    public SystemPublishIdMessageDM(SystemPublishIdMessageDM systemPublishIdMessageDM) {
        super(systemPublishIdMessageDM);
        this.isFirstMessageInList = systemPublishIdMessageDM.isFirstMessageInList;
    }

    public SystemPublishIdMessageDM deepClone() {
        return new SystemPublishIdMessageDM(this);
    }
}
