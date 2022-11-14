package com.helpshift.conversation.activeconversation.usersetup;

public interface ConversationSetupRenderer {
    void hideNoInternetView();

    void hideProgressBar();

    void hideProgressDescription();

    void onAuthenticationFailure();

    void onConversationSetupComplete();

    void showNoInternetView();

    void showProgressBar();

    void showProgressDescription();
}
