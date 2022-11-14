package com.helpshift.widget;

import com.helpshift.widget.TextViewState;

public class MutableTextViewState extends TextViewState {
    public MutableTextViewState(boolean z) {
        super(z);
    }

    public void setError(TextViewState.TextViewStatesError textViewStatesError) {
        this.error = textViewStatesError;
        notifyChange(this);
    }

    public void setText(String str) {
        if (!getText().equals(str)) {
            this.text = str;
            if (getError() != null) {
                setError((TextViewState.TextViewStatesError) null);
            }
        }
    }
}
