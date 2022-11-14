package com.helpshift.support.flows;

import com.helpshift.support.controllers.SupportController;
import java.util.List;

public class DynamicFormFlow implements Flow {
    public final List<Flow> flowList;
    public final String label;
    public final int labelResId;
    public SupportController supportController;

    public DynamicFormFlow(int i, List<Flow> list) {
        this.labelResId = i;
        this.flowList = list;
        this.label = null;
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelResId() {
        return this.labelResId;
    }

    public void performAction() {
        int i = this.labelResId;
        if (i != 0) {
            this.supportController.startDynamicForm(i, this.flowList, true);
        } else {
            this.supportController.startDynamicForm(this.label, this.flowList, true);
        }
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public DynamicFormFlow(String str, List<Flow> list) {
        this.label = str;
        this.flowList = list;
        this.labelResId = 0;
    }
}
