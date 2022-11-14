package com.helpshift.widget;

public class MutableReplyFieldViewState extends ReplyFieldViewState {
    public void clearReplyText() {
        this.replyText = "";
        notifyChange(this);
    }

    public void setReplyText(String str) {
        if (str != null && !str.equals(this.replyText)) {
            this.replyText = str;
            notifyChange(this);
        }
    }
}
