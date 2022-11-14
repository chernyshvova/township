package com.swrve.sdk.notifications.model;

public class SwrveNotificationButton {
    public String action;
    public ActionType actionType;
    public String title;

    public enum ActionType {
        OPEN_URL,
        OPEN_APP,
        OPEN_CAMPAIGN,
        DISMISS
    }

    public String getAction() {
        return this.action;
    }

    public ActionType getActionType() {
        return this.actionType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setActionType(ActionType actionType2) {
        this.actionType = actionType2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
