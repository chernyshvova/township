package com.helpshift.conversation.viewmodel;

public interface MessageListVMCallback {
    void appendMessages(int i, int i2);

    void newAdminMessagesAdded();

    void newUserMessagesAdded();

    void onUIMessageListUpdated();

    void refreshAll();

    void updateMessages(int i, int i2);
}
