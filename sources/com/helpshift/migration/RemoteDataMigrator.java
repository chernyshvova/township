package com.helpshift.migration;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.domain.network.UserNotFoundNetwork;
import com.helpshift.common.domain.network.UserPreConditionsFailedNetwork;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.migration.legacyUser.LegacyProfile;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.helpshift.util.StringUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class RemoteDataMigrator {
    public Domain domain;
    public LegacyProfileMigrationDAO legacyProfileMigrationDAO;
    public Platform platform;
    public WeakReference<RemoteDataMigratorListener> remoteDataMigratorListener;
    public UserDM userDM;

    public interface RemoteDataMigratorListener {
        void onMigrationStateChanged(UserDM userDM, MigrationState migrationState, MigrationState migrationState2);
    }

    public RemoteDataMigrator(Platform platform2, Domain domain2, UserDM userDM2, RemoteDataMigratorListener remoteDataMigratorListener2) {
        this.platform = platform2;
        this.domain = domain2;
        this.userDM = userDM2;
        this.remoteDataMigratorListener = new WeakReference<>(remoteDataMigratorListener2);
        this.legacyProfileMigrationDAO = platform2.getLegacyUserMigrationDataSource();
    }

    /* access modifiers changed from: private */
    public void runRemoteMigrationInternal() {
        LegacyProfile fetchLegacyProfile;
        MigrationState profileMigrationState = getProfileMigrationState();
        if (profileMigrationState != MigrationState.COMPLETED && profileMigrationState != MigrationState.IN_PROGRESS && (fetchLegacyProfile = this.legacyProfileMigrationDAO.fetchLegacyProfile(this.userDM.getIdentifier())) != null) {
            MigrationState migrationState = fetchLegacyProfile.migrationState;
            if (migrationState == MigrationState.NOT_STARTED || migrationState == MigrationState.FAILED) {
                GuardOKNetwork guardOKNetwork = new GuardOKNetwork(new FailedAPICallNetworkDecorator(new UserNotFoundNetwork(new UserPreConditionsFailedNetwork(new TSCorrectedNetwork(new POSTNetwork("/migrate-profile/", this.domain, this.platform), this.platform)))));
                HashMap hashMap = new HashMap();
                hashMap.put("profile-id", fetchLegacyProfile.serverId);
                hashMap.put(ProfileTable.Columns.COLUMN_DID, this.userDM.getDeviceId());
                if (!StringUtils.isEmpty(this.userDM.getIdentifier())) {
                    hashMap.put(ProfileTable.Columns.COLUMN_UID, this.userDM.getIdentifier());
                }
                if (!StringUtils.isEmpty(this.userDM.getEmail())) {
                    hashMap.put("email", this.userDM.getEmail());
                }
                updateProfileMigrationStateUpdate(migrationState, MigrationState.IN_PROGRESS);
                try {
                    guardOKNetwork.makeRequest(new RequestData((Map<String, String>) hashMap));
                    updateProfileMigrationStateUpdate(migrationState, MigrationState.COMPLETED);
                } catch (RootAPIException e) {
                    ExceptionType exceptionType = e.exceptionType;
                    if (exceptionType == NetworkException.USER_PRE_CONDITION_FAILED || exceptionType == NetworkException.USER_NOT_FOUND) {
                        updateProfileMigrationStateUpdate(migrationState, MigrationState.COMPLETED);
                    } else if (exceptionType == NetworkException.NON_RETRIABLE) {
                        updateProfileMigrationStateUpdate(migrationState, MigrationState.COMPLETED);
                    } else {
                        updateProfileMigrationStateUpdate(migrationState, MigrationState.FAILED);
                        throw e;
                    }
                }
            }
        }
    }

    private void updateProfileMigrationStateUpdate(final MigrationState migrationState, final MigrationState migrationState2) {
        if (migrationState2 == MigrationState.COMPLETED) {
            this.legacyProfileMigrationDAO.deleteLegacyProfile(this.userDM.getIdentifier());
        } else {
            this.legacyProfileMigrationDAO.updateMigrationState(this.userDM.getIdentifier(), migrationState2);
        }
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (RemoteDataMigrator.this.remoteDataMigratorListener.get() != null) {
                    ((RemoteDataMigratorListener) RemoteDataMigrator.this.remoteDataMigratorListener.get()).onMigrationStateChanged(RemoteDataMigrator.this.userDM, migrationState, migrationState2);
                }
            }
        });
    }

    public MigrationState getProfileMigrationState() {
        if (StringUtils.isEmpty(this.userDM.getIdentifier())) {
            return MigrationState.COMPLETED;
        }
        LegacyProfile fetchLegacyProfile = this.legacyProfileMigrationDAO.fetchLegacyProfile(this.userDM.getIdentifier());
        if (fetchLegacyProfile == null) {
            return MigrationState.COMPLETED;
        }
        return fetchLegacyProfile.migrationState;
    }

    public void retry() {
        runRemoteMigrationInternal();
    }

    public void setAppropriateInitialState() {
        MigrationState profileMigrationState = getProfileMigrationState();
        MigrationState migrationState = MigrationState.IN_PROGRESS;
        if (profileMigrationState == migrationState) {
            updateProfileMigrationStateUpdate(migrationState, MigrationState.NOT_STARTED);
        }
    }

    public void startProfileMigration() {
        MigrationState profileMigrationState = getProfileMigrationState();
        if (profileMigrationState != MigrationState.COMPLETED && profileMigrationState != MigrationState.IN_PROGRESS) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        RemoteDataMigrator.this.runRemoteMigrationInternal();
                    } catch (RootAPIException e) {
                        RemoteDataMigrator.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.MIGRATION, e.getServerStatusCode());
                        throw e;
                    }
                }
            });
        }
    }
}
