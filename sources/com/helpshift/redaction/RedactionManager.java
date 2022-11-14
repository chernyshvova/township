package com.helpshift.redaction;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.domainmodel.ConversationController;
import java.lang.ref.WeakReference;

public class RedactionManager {
    public Domain domain;
    public RedactionDAO redactionDAO;
    public WeakReference<RedactionManagerListener> redactionManagerListener;
    public UserDM userDM;

    public interface RedactionManagerListener {
        void redactionStateChanged(UserDM userDM, RedactionState redactionState, RedactionState redactionState2);
    }

    public RedactionManager(Platform platform, Domain domain2, UserDM userDM2, RedactionManagerListener redactionManagerListener2) {
        this.domain = domain2;
        this.userDM = userDM2;
        this.redactionManagerListener = new WeakReference<>(redactionManagerListener2);
        this.redactionDAO = platform.getRedactionDAO();
    }

    /* access modifiers changed from: private */
    public void updateUserRedactionState(final RedactionState redactionState, final RedactionState redactionState2) {
        if (redactionState2 == RedactionState.COMPLETED) {
            this.redactionDAO.deleteRedactionDetail(this.userDM.getLocalId().longValue());
        } else {
            this.redactionDAO.updateRedactionState(this.userDM.getLocalId().longValue(), redactionState2);
        }
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                RedactionManagerListener redactionManagerListener = (RedactionManagerListener) RedactionManager.this.redactionManagerListener.get();
                if (redactionManagerListener != null) {
                    redactionManagerListener.redactionStateChanged(RedactionManager.this.userDM, redactionState, redactionState2);
                }
            }
        });
    }

    public synchronized void executeRedaction() {
        RedactionState redactionState = getRedactionState();
        if (redactionState == RedactionState.PENDING) {
            updateUserRedactionState(redactionState, RedactionState.IN_PROGRESS);
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    ConversationController conversationInboxDM = RedactionManager.this.domain.getConversationInboxManagerDM().getConversationInboxDM(RedactionManager.this.userDM);
                    conversationInboxDM.getConversationInboxPoller().stop();
                    conversationInboxDM.redactConversations();
                    RedactionManager.this.domain.getUserManagerDM().resetSyncState(RedactionManager.this.userDM);
                    RedactionManager.this.updateUserRedactionState(RedactionState.IN_PROGRESS, RedactionState.COMPLETED);
                }
            });
        }
    }

    public RedactionState getRedactionState() {
        RedactionDetail redactionDetail = this.redactionDAO.getRedactionDetail(this.userDM.getLocalId().longValue());
        if (redactionDetail == null) {
            return RedactionState.COMPLETED;
        }
        return redactionDetail.redactionState;
    }

    public void setAppropriateInitialState() {
        RedactionState redactionState = getRedactionState();
        if (redactionState == RedactionState.IN_PROGRESS) {
            updateUserRedactionState(redactionState, RedactionState.PENDING);
        }
    }
}
