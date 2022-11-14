package com.helpshift.support;

import android.content.Context;
import android.os.Environment;
import com.facebook.appevents.AppEventsConstants;
import com.helpshift.account.dao.legacy.AndroidLegacyProfileDAO;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.storage.RetryKeyValueDbStorage;
import com.helpshift.support.storage.LegacyUserDataMigrator;
import com.helpshift.support.storage.SupportDowngradeMigrator;
import com.helpshift.support.storage.SupportKVStoreMigrator;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.VersionName;
import java.io.File;
import java.util.HashSet;
import java.util.List;

public class SupportMigrator {
    public static final String TAG = "Helpshift_SupportMigr";

    public static void deleteDBLockFilesOnSDKMigration(Context context) {
        try {
            File file = new File(context.getFilesDir() + File.separator + "__hs_supportkvdb_lock");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(context.getFilesDir() + File.separator + "__hs_kvdb_lock");
            if (file2.exists()) {
                file2.delete();
            }
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(".backups/" + context.getPackageName() + "/helpshift/databases/");
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.canWrite()) {
                File file3 = new File(externalStoragePublicDirectory, "__hs__db_profiles");
                if (file3.canWrite()) {
                    file3.delete();
                }
                File file4 = new File(externalStoragePublicDirectory, RetryKeyValueDbStorage.backupFileName);
                if (file4.canWrite()) {
                    file4.delete();
                }
            }
        } catch (Exception e) {
            HSLogger.m3241e(TAG, "Error on deleting lock file: " + e);
        }
    }

    public static void fixDuplicateConversations(Platform platform, Domain domain, VersionName versionName) {
        if (versionName.isGreaterThanOrEqualTo(new VersionName("7.0.0"))) {
            List<UserDM> allUsers = domain.getUserManagerDM().getAllUsers();
            ConversationDAO conversationDAO = platform.getConversationDAO();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (UserDM next : allUsers) {
                if (domain.getConversationInboxManagerDM().getConversationInboxDM(next).getActiveConversationFromStorage() != null) {
                    List<Conversation> data = conversationDAO.readConversationsWithoutMessages(next.getLocalId().longValue()).getData();
                    if (ListUtils.isEmpty(data)) {
                        continue;
                    } else {
                        for (Conversation conversation : data) {
                            boolean z = true;
                            boolean z2 = !StringUtils.isEmpty(conversation.preConversationServerId) && hashSet2.contains(conversation.preConversationServerId);
                            if (StringUtils.isEmpty(conversation.serverId) || !hashSet.contains(conversation.serverId)) {
                                z = false;
                            }
                            if (z2 || z) {
                                conversationDAO.dropAndCreateDatabase();
                                HelpshiftContext.getCoreApi().resetUsersSyncStatusAndStartSetupForActiveUser();
                                return;
                            }
                            if (!StringUtils.isEmpty(conversation.preConversationServerId)) {
                                hashSet2.add(conversation.preConversationServerId);
                            }
                            if (!StringUtils.isEmpty(conversation.serverId)) {
                                hashSet.add(conversation.serverId);
                            }
                        }
                        continue;
                    }
                }
            }
        }
    }

    public static void migrate(Context context, Platform platform, Domain domain, HSApiData hSApiData, HSStorage hSStorage) {
        Platform platform2 = platform;
        Domain domain2 = domain;
        HSStorage hSStorage2 = hSStorage;
        String libraryVersion = hSStorage.getLibraryVersion();
        if (!StringUtils.isEmpty(libraryVersion) && !"7.11.0".equals(libraryVersion)) {
            VersionName parseSDKVersion = parseSDKVersion(libraryVersion);
            VersionName versionName = new VersionName("7.11.0");
            if (parseSDKVersion.isLessThan(versionName)) {
                if (parseSDKVersion.isLessThan(new VersionName("7.0.0"))) {
                    LegacyUserDataMigrator legacyUserDataMigrator = new LegacyUserDataMigrator(HelpshiftContext.getCoreApi(), hSStorage, platform.getKVStore(), AndroidLegacyProfileDAO.getInstance(context), platform.getBackupDAO(), platform.getLegacyUserMigrationDataSource(), platform.getLegacyAnalyticsEventIDDAO(), parseSDKVersion);
                    SupportKVStoreMigrator supportKVStoreMigrator = new SupportKVStoreMigrator(hSStorage2);
                    legacyUserDataMigrator.backup(parseSDKVersion);
                    supportKVStoreMigrator.backup(parseSDKVersion);
                    hSStorage.backupForMigration();
                    hSApiData.clearETagsForFaqs();
                    hSStorage.clearDatabase();
                    legacyUserDataMigrator.dropProfileDB();
                    platform.getConversationDAO().dropAndCreateDatabase();
                    HelpshiftContext.getCoreApi().resetUsersSyncStatusAndStartSetupForActiveUser();
                    platform.getKVStore().removeAllKeys();
                    legacyUserDataMigrator.restore();
                    supportKVStoreMigrator.restore();
                    hSStorage.restoreMigrationData();
                    domain.getUserManagerDM().getActiveUserSetupDM().startSetup();
                    hSStorage.clearLegacySearchIndexFile();
                    deleteDBLockFilesOnSDKMigration(context);
                } else {
                    fixDuplicateConversations(platform2, domain2, parseSDKVersion);
                    updateRejectConversations(platform2, domain2, parseSDKVersion);
                }
                removeConfigApiEtag(platform2, parseSDKVersion);
            } else if (parseSDKVersion.isGreaterThan(versionName)) {
                SupportDowngradeMigrator supportDowngradeMigrator = new SupportDowngradeMigrator();
                supportDowngradeMigrator.backup(parseSDKVersion);
                platform.getKVStore().removeAllKeys();
                hSApiData.clearETagsForFaqs();
                hSStorage.clearDatabase();
                platform.getConversationDAO().dropAndCreateDatabase();
                platform.getUserDAO().dropAndCreateDatabase();
                supportDowngradeMigrator.restore();
            }
        }
        if (!"7.11.0".equals(libraryVersion)) {
            hSStorage2.setLibraryVersion("7.11.0");
        }
    }

    public static VersionName parseSDKVersion(String str) {
        VersionName versionName = new VersionName(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        try {
            return new VersionName(str);
        } catch (NumberFormatException e) {
            HSLogger.m3241e(TAG, "Error in creating SemVer: " + e);
            return versionName;
        }
    }

    public static void removeConfigApiEtag(Platform platform, VersionName versionName) {
        if (versionName.isLessThan(new VersionName("7.9.0"))) {
            platform.getNetworkRequestDAO().removeETag(NetworkConstants.SUPPORT_CONFIG_ROUTE);
        }
    }

    public static void updateRejectConversations(Platform platform, Domain domain, VersionName versionName) {
        if (versionName.isGreaterThanOrEqualTo(new VersionName("7.0.0")) && versionName.isLessThanOrEqualTo(new VersionName("7.1.0"))) {
            ConversationDAO conversationDAO = platform.getConversationDAO();
            List<UserDM> allUsers = domain.getUserManagerDM().getAllUsers();
            if (!ListUtils.isEmpty(allUsers)) {
                for (UserDM next : allUsers) {
                    List<Conversation> data = conversationDAO.readConversationsWithoutMessages(next.getLocalId().longValue()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        for (Conversation conversation : data) {
                            if (conversation.state == IssueState.REJECTED && !conversation.isStartNewConversationClicked) {
                                conversation.userLocalId = next.getLocalId().longValue();
                                domain.getConversationInboxManagerDM().getConversationInboxDM(next).conversationManager.setStartNewConversationButtonClicked(conversation, true, true);
                            }
                        }
                    }
                }
            }
        }
    }
}
