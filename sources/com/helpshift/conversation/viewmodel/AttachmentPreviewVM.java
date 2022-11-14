package com.helpshift.conversation.viewmodel;

import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.activeconversation.AttachmentPreviewRenderer;

public class AttachmentPreviewVM implements AuthenticationFailureDM.AuthenticationFailureObserver {
    public final Domain domain;
    public AttachmentPreviewRenderer renderer;

    public AttachmentPreviewVM(Domain domain2, AttachmentPreviewRenderer attachmentPreviewRenderer) {
        this.domain = domain2;
        this.renderer = attachmentPreviewRenderer;
        domain2.getAuthenticationFailureDM().registerListener(this);
    }

    public void onAuthenticationFailure() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (AttachmentPreviewVM.this.renderer != null) {
                    AttachmentPreviewVM.this.renderer.onAuthenticationFailure();
                }
            }
        });
    }

    public void unregisterRenderer() {
        this.renderer = null;
        this.domain.getAuthenticationFailureDM().unregisterListener(this);
    }
}
