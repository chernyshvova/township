package com.swrve.sdk.conversations.engine.model;

import java.io.Serializable;

public class ChoiceInputResponse implements Serializable {
    public String answerID;
    public String answerText;
    public String fragmentTag;
    public String questionID;

    public String getAnswerID() {
        return this.answerID;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public String getFragmentTag() {
        return this.fragmentTag;
    }

    public String getQuestionID() {
        return this.questionID;
    }

    public void setAnswerID(String str) {
        this.answerID = str;
    }

    public void setAnswerText(String str) {
        this.answerText = str;
    }

    public void setFragmentTag(String str) {
        this.fragmentTag = str;
    }

    public void setQuestionID(String str) {
        this.questionID = str;
    }
}
