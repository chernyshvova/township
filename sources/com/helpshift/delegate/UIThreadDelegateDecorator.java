package com.helpshift.delegate;

import com.helpshift.HelpshiftUser;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.activeconversation.model.ActionType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UIThreadDelegateDecorator {
    public Map<String, Boolean> authenticationFailedCalledList = new HashMap();
    public RootDelegate delegate;
    public Domain domain;

    public UIThreadDelegateDecorator(Domain domain2) {
        this.domain = domain2;
    }

    public void authenticationFailed(UserDM userDM, final AuthenticationFailureReason authenticationFailureReason) {
        if (this.delegate != null && userDM.isActiveUser()) {
            String str = userDM.getLocalId() + "_" + userDM.getAuthToken();
            if (!this.authenticationFailedCalledList.containsKey(str) || !this.authenticationFailedCalledList.get(str).booleanValue()) {
                this.authenticationFailedCalledList.put(str, Boolean.TRUE);
                final HelpshiftUser build = new HelpshiftUser.Builder(userDM.getIdentifier(), userDM.getEmail()).setName(userDM.getName()).setAuthToken(userDM.getAuthToken()).build();
                this.domain.runOnUI(new C2500F() {
                    /* renamed from: f */
                    public void mo33949f() {
                        UIThreadDelegateDecorator.this.delegate.authenticationFailed(build, authenticationFailureReason);
                    }
                });
            }
        }
    }

    public void conversationEnded() {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.conversationEnded();
                }
            });
        }
    }

    public void didReceiveNotification(final int i) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.didReceiveNotification(i);
                }
            });
        }
    }

    public void displayAttachmentFile(final File file) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.displayAttachmentFile(file);
                }
            });
        }
    }

    public RootDelegate getDelegate() {
        return this.delegate;
    }

    public boolean isDelegateRegistered() {
        return this.delegate != null;
    }

    public void newConversationStarted(final String str) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.newConversationStarted(str);
                }
            });
        }
    }

    public void sessionBegan() {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.sessionBegan();
                }
            });
        }
    }

    public void sessionEnded() {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.sessionEnded();
                }
            });
        }
    }

    public void setDelegate(RootDelegate rootDelegate) {
        this.delegate = rootDelegate;
    }

    public void userClickOnAction(final ActionType actionType, final String str) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.userClickOnAction(actionType, str);
                }
            });
        }
    }

    public void userCompletedCustomerSatisfactionSurvey(final int i, final String str) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.userCompletedCustomerSatisfactionSurvey(i, str);
                }
            });
        }
    }

    public void userRepliedToConversation(final String str) {
        if (this.delegate != null) {
            this.domain.runOnUI(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    UIThreadDelegateDecorator.this.delegate.userRepliedToConversation(str);
                }
            });
        }
    }
}
