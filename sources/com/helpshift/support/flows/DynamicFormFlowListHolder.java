package com.helpshift.support.flows;

import java.util.List;

public class DynamicFormFlowListHolder {
    public static List<Flow> flowList;

    public static List<Flow> getFlowList() {
        return flowList;
    }

    public static void setFlowList(List<Flow> list) {
        flowList = list;
    }
}
