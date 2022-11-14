package com.helpshift.conversation.viewmodel;

import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.activeconversation.ConversationInfoRenderer;

public class ConversationInfoVM implements AuthenticationFailureDM.AuthenticationFailureObserver {
    public final Domain domain;
    public ConversationInfoRenderer renderer;

    public ConversationInfoVM(Domain domain2, ConversationInfoRenderer conversationInfoRenderer) {
        this.domain = domain2;
        this.renderer = conversationInfoRenderer;
        domain2.getAuthenticationFailureDM().registerListener(this);
    }

    public void onAuthenticationFailure() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ConversationInfoVM.this.renderer != null) {
                    ConversationInfoVM.this.renderer.onAuthenticationFailure();
                }
            }
        });
    }

    public void unregisterRenderer() {
        this.renderer = null;
        this.domain.getAuthenticationFailureDM().unregisterListener(this);
    }
}
