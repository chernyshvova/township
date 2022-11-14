package com.helpshift.conversation.viewmodel;

import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.usersetup.ConversationSetupRenderer;
import com.helpshift.conversation.domainmodel.ConversationSetupDM;
import com.helpshift.util.HSLogger;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.MutableBaseViewState;

public class ConversationSetupVM implements AuthenticationFailureDM.AuthenticationFailureObserver, ConversationSetupVMCallback {
    public static final String TAG = "Helpshift_ConvStpVM";
    public ConversationSetupDM conversationSetupDM;
    public Domain domain;
    public final MutableBaseViewState errorViewState = new MutableBaseViewState();
    public Platform platform;
    public final MutableBaseViewState progressBarViewState = buildProgressBarWidget();
    public final MutableBaseViewState progressDescriptionViewState = new MutableBaseViewState();
    public ConversationSetupRenderer renderer;

    /* renamed from: com.helpshift.conversation.viewmodel.ConversationSetupVM$5 */
    public static /* synthetic */ class C25755 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$domainmodel$ConversationSetupDM$ConversationSetupState */
        public static final /* synthetic */ int[] f3338x25662d92;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState[] r0 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3338x25662d92 = r0
                r1 = 1
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r2 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r2 = 3
                int[] r3 = f3338x25662d92     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r4 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.FAILED     // Catch:{ NoSuchFieldError -> 0x0017 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r3 = f3338x25662d92     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r4 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r1 = f3338x25662d92     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.helpshift.conversation.domainmodel.ConversationSetupDM$ConversationSetupState r2 = com.helpshift.conversation.domainmodel.ConversationSetupDM.ConversationSetupState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.conversation.viewmodel.ConversationSetupVM.C25755.<clinit>():void");
        }
    }

    public ConversationSetupVM(Platform platform2, Domain domain2, ConversationSetupDM conversationSetupDM2, ConversationSetupRenderer conversationSetupRenderer) {
        this.platform = platform2;
        this.conversationSetupDM = conversationSetupDM2;
        this.renderer = conversationSetupRenderer;
        this.domain = domain2;
        conversationSetupDM2.init();
        conversationSetupDM2.setCallback(this);
        this.domain.getAuthenticationFailureDM().registerListener(this);
    }

    private MutableBaseViewState buildProgressBarWidget() {
        MutableBaseViewState mutableBaseViewState = new MutableBaseViewState();
        mutableBaseViewState.setVisible(this.conversationSetupDM.getState() == ConversationSetupDM.ConversationSetupState.IN_PROGRESS);
        return mutableBaseViewState;
    }

    private void handleConversationSetupComplete() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ConversationSetupVM.this.renderer != null) {
                    HSLogger.m3237d(ConversationSetupVM.TAG, "Handling setup complete.");
                    ConversationSetupVM.this.renderer.onConversationSetupComplete();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void showOfflineError() {
        this.progressBarViewState.setVisible(false);
        this.progressDescriptionViewState.setVisible(false);
        this.errorViewState.setVisible(true);
    }

    public BaseViewState getDescriptionProgressViewState() {
        return this.progressDescriptionViewState;
    }

    public BaseViewState getProgressBarViewState() {
        return this.progressBarViewState;
    }

    public BaseViewState getUserOfflineErrorViewState() {
        return this.errorViewState;
    }

    public void onAuthenticationFailure() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ConversationSetupVM.this.renderer != null) {
                    ConversationSetupVM.this.renderer.onAuthenticationFailure();
                }
            }
        });
    }

    public void onConversationSetupStateUpdate(ConversationSetupDM.ConversationSetupState conversationSetupState) {
        if (!this.platform.isOnline()) {
            onNetworkUnavailable();
            return;
        }
        int ordinal = conversationSetupState.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                this.progressBarViewState.setVisible(true);
                this.errorViewState.setVisible(false);
                return;
            } else if (ordinal == 2) {
                handleConversationSetupComplete();
                return;
            } else if (ordinal != 3) {
                return;
            }
        }
        this.progressDescriptionViewState.setVisible(true);
        this.progressBarViewState.setVisible(true);
    }

    public void onDestroyView() {
        this.renderer = null;
        this.conversationSetupDM.setCallback((ConversationSetupVMCallback) null);
        this.domain.getAuthenticationFailureDM().unregisterListener(this);
    }

    public void onNetworkAvailable() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationSetupVM.this.progressBarViewState.setVisible(true);
                ConversationSetupVM.this.errorViewState.setVisible(false);
            }
        });
    }

    public void onNetworkUnavailable() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                ConversationSetupVM.this.showOfflineError();
            }
        });
    }

    public void onResume() {
        if (this.conversationSetupDM.getState() == ConversationSetupDM.ConversationSetupState.COMPLETED) {
            HSLogger.m3237d(TAG, "Conversation setup already complete.");
            handleConversationSetupComplete();
            return;
        }
        this.conversationSetupDM.startSetup();
    }
}
