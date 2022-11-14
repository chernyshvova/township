package com.helpshift.account.domainmodel;

import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import java.lang.ref.WeakReference;

public class UserSyncDM {
    public Domain domain;
    public Platform platform;
    public UserDM userDM;
    public UserManagerDM userManagerDM;
    public IUserSyncExecutor userSyncExecutor;
    public WeakReference<UserSyncListener> userSyncListener;

    public interface UserSyncListener {
        void userSyncStateChanged(UserDM userDM, UserSyncStatus userSyncStatus, UserSyncStatus userSyncStatus2);
    }

    public UserSyncDM(Platform platform2, Domain domain2, UserDM userDM2, UserManagerDM userManagerDM2, IUserSyncExecutor iUserSyncExecutor, UserSyncListener userSyncListener2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.userManagerDM = userManagerDM2;
        this.userSyncExecutor = iUserSyncExecutor;
        this.userSyncListener = new WeakReference<>(userSyncListener2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void syncUserInternal() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.helpshift.account.domainmodel.UserSyncStatus r0 = r5.getSyncState()     // Catch:{ all -> 0x0060 }
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.NOT_STARTED     // Catch:{ all -> 0x0060 }
            if (r0 == r1) goto L_0x000f
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.FAILED     // Catch:{ all -> 0x0060 }
            if (r0 == r1) goto L_0x000f
            monitor-exit(r5)
            return
        L_0x000f:
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.IN_PROGRESS     // Catch:{ all -> 0x0060 }
            r5.updateUserSyncState(r0, r1)     // Catch:{ all -> 0x0060 }
            com.helpshift.account.domainmodel.IUserSyncExecutor r1 = r5.userSyncExecutor     // Catch:{ RootAPIException -> 0x001f }
            r1.executeUserSync()     // Catch:{ RootAPIException -> 0x001f }
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.COMPLETED     // Catch:{ RootAPIException -> 0x001f }
            r5.updateUserSyncState(r0, r1)     // Catch:{ RootAPIException -> 0x001f }
            goto L_0x0058
        L_0x001f:
            r1 = move-exception
            int r2 = r1.getServerStatusCode()     // Catch:{ all -> 0x0060 }
            java.lang.Integer r3 = com.helpshift.common.domain.network.NetworkErrorCodes.CONTENT_NOT_FOUND     // Catch:{ all -> 0x0060 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0060 }
            if (r2 != r3) goto L_0x004d
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.COMPLETED     // Catch:{ all -> 0x0060 }
            r5.updateUserSyncState(r0, r1)     // Catch:{ all -> 0x0060 }
            com.helpshift.account.domainmodel.UserManagerDM r0 = r5.userManagerDM     // Catch:{ all -> 0x0060 }
            com.helpshift.account.domainmodel.UserDM r1 = r5.userDM     // Catch:{ all -> 0x0060 }
            r2 = 0
            r0.updateIssueExists(r1, r2)     // Catch:{ all -> 0x0060 }
            com.helpshift.common.platform.Platform r0 = r5.platform     // Catch:{ all -> 0x0060 }
            com.helpshift.conversation.dao.ConversationInboxDAO r0 = r0.getConversationInboxDAO()     // Catch:{ all -> 0x0060 }
            com.helpshift.account.domainmodel.UserDM r1 = r5.userDM     // Catch:{ all -> 0x0060 }
            java.lang.Long r1 = r1.getLocalId()     // Catch:{ all -> 0x0060 }
            long r3 = r1.longValue()     // Catch:{ all -> 0x0060 }
            r0.saveHasOlderMessages(r3, r2)     // Catch:{ all -> 0x0060 }
            goto L_0x0058
        L_0x004d:
            com.helpshift.common.exception.ExceptionType r2 = r1.exceptionType     // Catch:{ all -> 0x0060 }
            com.helpshift.common.exception.NetworkException r3 = com.helpshift.common.exception.NetworkException.NON_RETRIABLE     // Catch:{ all -> 0x0060 }
            if (r2 != r3) goto L_0x005a
            com.helpshift.account.domainmodel.UserSyncStatus r1 = com.helpshift.account.domainmodel.UserSyncStatus.FAILED     // Catch:{ all -> 0x0060 }
            r5.updateUserSyncState(r0, r1)     // Catch:{ all -> 0x0060 }
        L_0x0058:
            monitor-exit(r5)
            return
        L_0x005a:
            com.helpshift.account.domainmodel.UserSyncStatus r2 = com.helpshift.account.domainmodel.UserSyncStatus.FAILED     // Catch:{ all -> 0x0060 }
            r5.updateUserSyncState(r0, r2)     // Catch:{ all -> 0x0060 }
            throw r1     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserSyncDM.syncUserInternal():void");
    }

    private void updateUserSyncState(final UserSyncStatus userSyncStatus, final UserSyncStatus userSyncStatus2) {
        WeakReference<UserSyncListener> weakReference = this.userSyncListener;
        final UserSyncListener userSyncListener2 = weakReference != null ? (UserSyncListener) weakReference.get() : null;
        this.userManagerDM.updateSyncState(this.userDM, userSyncStatus2);
        if (userSyncListener2 != null) {
            this.domain.runSerial(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    userSyncListener2.userSyncStateChanged(UserSyncDM.this.userDM, userSyncStatus, userSyncStatus2);
                }
            });
        }
    }

    public UserSyncStatus getSyncState() {
        return this.userDM.getSyncState();
    }

    public void retry() {
        syncUserInternal();
    }

    public void setAppropriateInitialState() {
        UserSyncStatus syncState = getSyncState();
        UserSyncStatus userSyncStatus = UserSyncStatus.IN_PROGRESS;
        if (syncState == userSyncStatus) {
            updateUserSyncState(userSyncStatus, UserSyncStatus.NOT_STARTED);
        }
    }

    public void syncUser() {
        UserSyncStatus syncState = getSyncState();
        if (syncState != UserSyncStatus.COMPLETED && syncState != UserSyncStatus.IN_PROGRESS) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        UserSyncDM.this.syncUserInternal();
                    } catch (RootAPIException e) {
                        UserSyncDM.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.SYNC_USER, e.getServerStatusCode());
                        throw e;
                    }
                }
            });
        }
    }
}
