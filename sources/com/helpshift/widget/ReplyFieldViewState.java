package com.helpshift.widget;

public class ReplyFieldViewState extends HSBaseObservable {
    public boolean isEnabled;
    public String replyText = "";

    public String getReplyText() {
        return this.replyText;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
