package com.helpshift.widget;

import com.helpshift.conversation.activeconversation.message.input.Input;

public class MutableReplyBoxViewState extends ReplyBoxViewState {
    public void setInput(Input input) {
        if (input == null || !input.equals(this.input)) {
            this.isVisible = true;
            this.input = input;
            notifyChange(this);
        }
    }

    public void setStandardTextInput() {
        if (this.input != null || !this.isVisible) {
            this.input = null;
            this.isVisible = true;
            notifyChange(this);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.isVisible) {
            this.isVisible = z;
            this.input = null;
            notifyChange(this);
        }
    }
}
