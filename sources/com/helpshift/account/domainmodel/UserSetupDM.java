package com.helpshift.account.domainmodel;

import com.helpshift.account.domainmodel.UserSyncDM;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.ConversationInboxPoller;
import com.helpshift.migration.MigrationState;
import com.helpshift.migration.RemoteDataMigrator;
import com.helpshift.redaction.RedactionManager;
import com.helpshift.redaction.RedactionState;
import java.lang.ref.WeakReference;

public class UserSetupDM implements UserSyncDM.UserSyncListener, RemoteDataMigrator.RemoteDataMigratorListener, RedactionManager.RedactionManagerListener, AutoRetriableDM {
    public Domain domain;
    public RedactionManager redactionManager;
    public RemoteDataMigrator remoteDataMigrator;
    public UserDM userDM;
    public WeakReference<UserSetupListener> userSetupListener;
    public UserSyncDM userSyncDM;

    /* renamed from: com.helpshift.account.domainmodel.UserSetupDM$3 */
    public static /* synthetic */ class C24763 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.helpshift.common.AutoRetryFailedEventDM$EventType[] r0 = com.helpshift.common.AutoRetryFailedEventDM.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType = r0
                r1 = 1
                com.helpshift.common.AutoRetryFailedEventDM$EventType r2 = com.helpshift.common.AutoRetryFailedEventDM.EventType.MIGRATION     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.AutoRetryFailedEventDM$EventType r2 = com.helpshift.common.AutoRetryFailedEventDM.EventType.SYNC_USER     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.domainmodel.UserSetupDM.C24763.<clinit>():void");
        }
    }

    public interface UserSetupListener {
        void userSetupStateChanged(UserDM userDM, UserSetupState userSetupState);
    }

    public UserSetupDM(Platform platform, Domain domain2, UserDM userDM2, UserManagerDM userManagerDM, IUserSyncExecutor iUserSyncExecutor) {
        this.domain = domain2;
        this.userDM = userDM2;
        this.userSyncDM = new UserSyncDM(platform, domain2, userDM2, userManagerDM, iUserSyncExecutor, this);
        this.remoteDataMigrator = new RemoteDataMigrator(platform, domain2, userDM2, this);
        this.redactionManager = new RedactionManager(platform, domain2, userDM2, this);
    }

    private void onMigrationStateChange(MigrationState migrationState) {
        if (migrationState == MigrationState.COMPLETED) {
            UserSyncStatus syncState = this.userSyncDM.getSyncState();
            if (syncState == UserSyncStatus.COMPLETED || syncState == UserSyncStatus.IN_PROGRESS) {
                onUserSyncStateChange(syncState);
            } else {
                this.userSyncDM.syncUser();
            }
        } else if (migrationState == MigrationState.IN_PROGRESS) {
            updateUserSetupStateChange(UserSetupState.IN_PROGRESS);
        } else if (migrationState == MigrationState.FAILED) {
            updateUserSetupStateChange(UserSetupState.FAILED);
        } else if (migrationState == MigrationState.NOT_STARTED) {
            updateUserSetupStateChange(UserSetupState.NON_STARTED);
        }
    }

    private void onRedactionStateChange(RedactionState redactionState) {
        if (redactionState == RedactionState.COMPLETED) {
            MigrationState profileMigrationState = this.remoteDataMigrator.getProfileMigrationState();
            if (profileMigrationState == MigrationState.COMPLETED || profileMigrationState == MigrationState.IN_PROGRESS) {
                onMigrationStateChange(profileMigrationState);
            } else {
                this.remoteDataMigrator.startProfileMigration();
            }
        } else if (redactionState == RedactionState.IN_PROGRESS) {
            updateUserSetupStateChange(UserSetupState.IN_PROGRESS);
        } else if (redactionState == RedactionState.PENDING) {
            updateUserSetupStateChange(UserSetupState.NON_STARTED);
        }
    }

    private void onUserSyncStateChange(UserSyncStatus userSyncStatus) {
        if (userSyncStatus == UserSyncStatus.COMPLETED) {
            updateUserSetupStateChange(UserSetupState.COMPLETED);
        } else if (userSyncStatus == UserSyncStatus.IN_PROGRESS) {
            updateUserSetupStateChange(UserSetupState.IN_PROGRESS);
        } else if (userSyncStatus == UserSyncStatus.FAILED) {
            updateUserSetupStateChange(UserSetupState.FAILED);
        } else if (userSyncStatus == UserSyncStatus.NOT_STARTED) {
            updateUserSetupStateChange(UserSetupState.NON_STARTED);
        }
    }

    private void updateUserSetupStateChange(final UserSetupState userSetupState) {
        WeakReference<UserSetupListener> weakReference = this.userSetupListener;
        final UserSetupListener userSetupListener2 = weakReference == null ? null : (UserSetupListener) weakReference.get();
        if (userSetupListener2 != null) {
            this.domain.runSerial(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    userSetupListener2.userSetupStateChanged(UserSetupDM.this.userDM, userSetupState);
                }
            });
        }
        if (userSetupState == UserSetupState.COMPLETED) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        UserSetupDM.this.domain.getUserManagerDM().sendPushTokenSync();
                    } finally {
                        ConversationInboxPoller conversationInboxPoller = UserSetupDM.this.domain.getConversationInboxManagerDM().getActiveConversationInboxDM().getConversationInboxPoller();
                        UserSetupDM.this.userDM.addObserver(conversationInboxPoller);
                        conversationInboxPoller.refreshPoller(false);
                    }
                }
            });
        }
    }

    public UserSetupState getState() {
        RedactionState redactionState = this.redactionManager.getRedactionState();
        if (redactionState == RedactionState.PENDING) {
            return UserSetupState.NON_STARTED;
        }
        if (redactionState == RedactionState.IN_PROGRESS) {
            return UserSetupState.IN_PROGRESS;
        }
        MigrationState profileMigrationState = this.remoteDataMigrator.getProfileMigrationState();
        if (profileMigrationState == MigrationState.NOT_STARTED) {
            return UserSetupState.NON_STARTED;
        }
        if (profileMigrationState == MigrationState.FAILED) {
            return UserSetupState.FAILED;
        }
        if (profileMigrationState == MigrationState.IN_PROGRESS) {
            return UserSetupState.IN_PROGRESS;
        }
        UserSyncStatus syncState = this.userSyncDM.getSyncState();
        if (syncState == UserSyncStatus.NOT_STARTED) {
            return UserSetupState.NON_STARTED;
        }
        if (syncState == UserSyncStatus.FAILED) {
            return UserSetupState.FAILED;
        }
        if (syncState == UserSyncStatus.IN_PROGRESS) {
            return UserSetupState.IN_PROGRESS;
        }
        return UserSetupState.COMPLETED;
    }

    public void init() {
        this.redactionManager.setAppropriateInitialState();
        this.remoteDataMigrator.setAppropriateInitialState();
        this.userSyncDM.setAppropriateInitialState();
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.MIGRATION, this);
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.SYNC_USER, this);
    }

    public void onMigrationStateChanged(UserDM userDM2, MigrationState migrationState, MigrationState migrationState2) {
        onMigrationStateChange(migrationState2);
    }

    public void redactionStateChanged(UserDM userDM2, RedactionState redactionState, RedactionState redactionState2) {
        onRedactionStateChange(redactionState2);
    }

    public void registerUserSetupListener(UserSetupListener userSetupListener2) {
        if (userSetupListener2 == null) {
            this.userSetupListener = null;
        } else {
            this.userSetupListener = new WeakReference<>(userSetupListener2);
        }
    }

    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        if (this.redactionManager.getRedactionState() == RedactionState.COMPLETED) {
            int ordinal = eventType.ordinal();
            if (ordinal == 0) {
                this.remoteDataMigrator.retry();
                if (this.remoteDataMigrator.getProfileMigrationState() == MigrationState.COMPLETED) {
                    this.userSyncDM.syncUser();
                }
            } else if (ordinal == 1 && this.remoteDataMigrator.getProfileMigrationState() == MigrationState.COMPLETED) {
                this.userSyncDM.retry();
            }
        }
    }

    public void startSetup() {
        UserSetupState state = getState();
        if (state != UserSetupState.IN_PROGRESS && state != UserSetupState.COMPLETED) {
            RedactionState redactionState = this.redactionManager.getRedactionState();
            onRedactionStateChange(redactionState);
            if (redactionState == RedactionState.PENDING) {
                this.redactionManager.executeRedaction();
            }
        }
    }

    public void userSyncStateChanged(UserDM userDM2, UserSyncStatus userSyncStatus, UserSyncStatus userSyncStatus2) {
        onUserSyncStateChange(userSyncStatus2);
    }
}
