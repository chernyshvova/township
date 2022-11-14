package com.helpshift.support.storage;

import android.provider.Settings;
import com.applovin.sdk.AppLovinEventParameters;
import com.helpshift.CoreApi;
import com.helpshift.HelpshiftUser;
import com.helpshift.account.dao.ProfileDTO;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.migration.LegacyAnalyticsEventIDDAO;
import com.helpshift.migration.LegacyProfileMigrationDAO;
import com.helpshift.migration.MigrationState;
import com.helpshift.migration.legacyUser.LegacyProfile;
import com.helpshift.migration.legacyUser.LegacyProfileDAO;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import com.helpshift.support.HSStorage;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.VersionName;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.downloader.AssetDownloader;
import java.util.ArrayList;
import java.util.List;

public class LegacyUserDataMigrator implements SDKMigrator {
    public static final String DEFAULT_USER_LOGIN_KEY = "default_user_login";
    public static final String DEFAULT_USER_PROFILE = "default_user_profile";
    public static final String KEY_DEVICE_ID = "key_support_device_id";
    public static final String LOGIN_IDENTIFIER = "loginIdentifier";
    public BackupDAO backupDAO;
    public CoreApi coreApi;
    public String defaultIdentifier;
    public ProfileDTO defaultProfileDto;
    public Domain domain;
    public VersionName fromVersion;
    public HSStorage hsStorage;
    public KVStore kvStore;
    public LegacyAnalyticsEventIDDAO legacyAnalyticsEventIDDAO;
    public LegacyProfileDAO legacyProfileDAO;
    public LegacyProfileMigrationDAO legacyProfileMigrationDAO;
    public String loginIdentifier;
    public List<ProfileDTO> loginProfileDtos;

    public LegacyUserDataMigrator(CoreApi coreApi2, HSStorage hSStorage, KVStore kVStore, LegacyProfileDAO legacyProfileDAO2, BackupDAO backupDAO2, LegacyProfileMigrationDAO legacyProfileMigrationDAO2, LegacyAnalyticsEventIDDAO legacyAnalyticsEventIDDAO2, VersionName versionName) {
        this.coreApi = coreApi2;
        this.domain = coreApi2.getDomain();
        this.hsStorage = hSStorage;
        this.kvStore = kVStore;
        this.legacyProfileDAO = legacyProfileDAO2;
        this.backupDAO = backupDAO2;
        this.legacyProfileMigrationDAO = legacyProfileMigrationDAO2;
        this.legacyAnalyticsEventIDDAO = legacyAnalyticsEventIDDAO2;
        this.fromVersion = versionName;
    }

    public void backup(VersionName versionName) {
        if (!versionName.isGreaterThanOrEqualTo(new VersionName("7.0.0"))) {
            if (versionName.isLessThanOrEqualTo(new VersionName("4.9.1"))) {
                this.loginIdentifier = this.hsStorage.getString(LOGIN_IDENTIFIER);
                String string = this.hsStorage.getString(AssetDownloader.IDENTITY);
                String string2 = this.hsStorage.getString(ConversationTable.Columns.LOCAL_UUID);
                this.defaultIdentifier = string2;
                if (StringUtils.isEmpty(string2)) {
                    this.defaultIdentifier = Settings.Secure.getString(HelpshiftContext.getApplicationContext().getContentResolver(), VungleApiClient.ANDROID_ID);
                }
                this.defaultProfileDto = new ProfileDTO((Long) null, this.defaultIdentifier, string, this.hsStorage.getString(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER), this.hsStorage.getString("email"), (String) null, (String) null, (String) null, true);
                List<ProfileDTO> fetchProfiles = this.legacyProfileDAO.fetchProfiles();
                if (!ListUtils.isEmpty(fetchProfiles)) {
                    this.loginProfileDtos = new ArrayList();
                    for (ProfileDTO next : fetchProfiles) {
                        this.loginProfileDtos.add(new ProfileDTO(next.localId, next.identifier, next.serverId, next.name, next.email, next.identifier + "_" + next.saltedIdentifier, next.uid, next.did, next.isPushTokenSynced));
                    }
                    return;
                }
                return;
            }
            this.loginIdentifier = this.kvStore.getString(LOGIN_IDENTIFIER);
            String string3 = this.kvStore.getString(DEFAULT_USER_LOGIN_KEY);
            this.defaultIdentifier = string3;
            if (!StringUtils.isEmpty(string3)) {
                Object serializable = this.kvStore.getSerializable(DEFAULT_USER_PROFILE);
                if (serializable instanceof ProfileDTO) {
                    this.defaultProfileDto = (ProfileDTO) serializable;
                }
            }
            this.loginProfileDtos = this.legacyProfileDAO.fetchProfiles();
        }
    }

    public void dropProfileDB() {
        this.legacyProfileDAO.deleteProfiles();
    }

    public void restore() {
        if (!this.fromVersion.isGreaterThanOrEqualTo(new VersionName("7.0.0"))) {
            String str = this.defaultIdentifier;
            if (str != null) {
                this.kvStore.setString("key_support_device_id", str);
                this.backupDAO.storeValue("key_support_device_id", this.defaultIdentifier);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ProfileDTO profileDTO = this.defaultProfileDto;
            if (profileDTO != null && !StringUtils.isEmpty(profileDTO.serverId)) {
                UserDM anonymousUser = this.domain.getUserManagerDM().getAnonymousUser();
                if (anonymousUser == null) {
                    anonymousUser = this.domain.getUserManagerDM().createAnonymousUser();
                }
                String identifier = anonymousUser.getIdentifier();
                ProfileDTO profileDTO2 = this.defaultProfileDto;
                arrayList2.add(new LegacyProfile(identifier, profileDTO2.email, profileDTO2.name, profileDTO2.serverId, MigrationState.NOT_STARTED));
            }
            if (!ListUtils.isEmpty(this.loginProfileDtos)) {
                for (ProfileDTO next : this.loginProfileDtos) {
                    if (!StringUtils.isEmpty(next.serverId)) {
                        arrayList2.add(new LegacyProfile(next.identifier, next.email, next.name, next.serverId, MigrationState.NOT_STARTED));
                    }
                    arrayList.add(new KeyValuePair(next.identifier, next.saltedIdentifier));
                }
            }
            if (!ListUtils.isEmpty(arrayList2)) {
                this.legacyProfileMigrationDAO.storeLegacyProfiles(arrayList2);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.legacyAnalyticsEventIDDAO.storeLegacyAnalyticsEventIDs(arrayList);
            }
            if (StringUtils.isEmpty(this.loginIdentifier)) {
                this.coreApi.logout();
                return;
            }
            List<ProfileDTO> list = this.loginProfileDtos;
            if (list != null) {
                for (ProfileDTO next2 : list) {
                    if (this.loginIdentifier.equals(next2.identifier)) {
                        this.coreApi.login(new HelpshiftUser.Builder(next2.identifier, next2.email).setName(next2.email).build());
                        return;
                    }
                }
            }
        }
    }
}
