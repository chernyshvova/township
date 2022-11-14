package com.helpshift.support.flows;

public interface Flow {
    String getLabel();

    int getLabelResId();

    void performAction();
}
