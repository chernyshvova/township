package com.helpshift.conversation.activeconversation.message;

public class RequestForReopenMessageDM extends MessageDM {
    public boolean isAnswered;

    public RequestForReopenMessageDM(String str, String str2, String str3, long j, Author author) {
        super(str2, str3, j, author, true, MessageType.REQUEST_FOR_REOPEN);
        this.serverId = str;
    }

    public boolean isAnswered() {
        return this.isAnswered;
    }

    public boolean isUISupportedMessage() {
        return this.isAnswered;
    }

    public void setAnswered(boolean z) {
        this.isAnswered = z;
    }

    public void setAnsweredAndNotify(boolean z) {
        if (this.isAnswered != z) {
            setAnswered(z);
            notifyUpdated();
        }
    }

    public RequestForReopenMessageDM(RequestForReopenMessageDM requestForReopenMessageDM) {
        super(requestForReopenMessageDM);
        this.isAnswered = requestForReopenMessageDM.isAnswered;
    }

    public RequestForReopenMessageDM deepClone() {
        return new RequestForReopenMessageDM(this);
    }
}
