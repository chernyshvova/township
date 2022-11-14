package com.helpshift.widget;

import java.util.regex.Pattern;

public class TextViewState extends HSBaseObservable {
    public static final Pattern specialCharactersPattern = Pattern.compile("\\W+");
    public TextViewStatesError error;
    public boolean isRequired;
    public String text;

    public enum TextViewStatesError {
        EMPTY,
        LESS_THAN_MINIMUM_LENGTH,
        ONLY_SPECIAL_CHARACTERS,
        INVALID_EMAIL
    }

    public TextViewState(boolean z) {
        this.isRequired = z;
    }

    public TextViewStatesError getError() {
        return this.error;
    }

    public String getText() {
        String str = this.text;
        return str == null ? "" : str.trim();
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
