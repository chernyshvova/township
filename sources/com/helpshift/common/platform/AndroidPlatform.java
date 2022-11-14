package com.helpshift.common.platform;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.helpshift.C2466R;
import com.helpshift.PluginEventBridge;
import com.helpshift.account.dao.AndroidClearedUserDAO;
import com.helpshift.account.dao.AndroidLegacyAnalyticsEventIDDAO;
import com.helpshift.account.dao.AndroidLegacyProfileMigrationDAO;
import com.helpshift.account.dao.AndroidRedactionDAO;
import com.helpshift.account.dao.AndroidUserDAO;
import com.helpshift.account.dao.AndroidUserManagerDAO;
import com.helpshift.account.dao.ClearedUserDAO;
import com.helpshift.account.dao.UserDAO;
import com.helpshift.account.dao.UserDB;
import com.helpshift.account.dao.UserManagerDAO;
import com.helpshift.analytics.AnalyticsEventDAO;
import com.helpshift.android.commons.downloader.HsUriUtils;
import com.helpshift.cif.dao.CustomIssueFieldDAO;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Threader;
import com.helpshift.common.domain.network.dao.HSNetworkMetadataDAO;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.HTTPTransport;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dao.ConversationInboxDAO;
import com.helpshift.conversation.dao.FAQSuggestionsDAO;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.smartintent.dao.SmartIntentDAO;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.faq.dao.FaqEventDAO;
import com.helpshift.faq.domainmodel.FAQSearchDM;
import com.helpshift.meta.dao.MetaDataDAO;
import com.helpshift.migration.LegacyAnalyticsEventIDDAO;
import com.helpshift.migration.LegacyProfileMigrationDAO;
import com.helpshift.notifications.NotificationChannelsManager;
import com.helpshift.providers.CrossModuleDataProvider;
import com.helpshift.providers.ICampaignsModuleAPIs;
import com.helpshift.redaction.RedactionDAO;
import com.helpshift.support.HSApiData;
import com.helpshift.support.storage.AndroidAnalyticsEventDAO;
import com.helpshift.support.storage.SupportKeyValueDBStorage;
import com.helpshift.support.util.AttachmentUtil;
import com.helpshift.support.util.SupportNotification;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftConnectionUtil;
import com.helpshift.util.LocaleContextUtil;
import java.io.IOException;

public class AndroidPlatform implements Platform {
    public static final String TAG = "AndroidPlatform";
    public AnalyticsEventDAO analyticsEventDAO;
    public String apiKey;
    public String appId;
    public BackupDAO backupDAO;
    public ClearedUserDAO clearedUserDAO;
    public final Context context;
    public ConversationDAO conversationDAO;
    public ConversationInboxDAO conversationInboxDAO;
    public CustomIssueFieldDAO customIssueFieldDAO;
    public HSApiData data;
    public Device device;
    public String domain;
    public SupportDownloader downloader;
    public FaqEventDAO faqEventDAO;
    public FAQSearchDM faqSearchDM;
    public HSNetworkMetadataDAO hsNetworkMetadataDAO;
    public Jsonifier jsonifier;
    public LegacyAnalyticsEventIDDAO legacyAnalyticsEventIDDAO;
    public LegacyProfileMigrationDAO legacyProfileMigrationDAO;
    public MetaDataDAO metaDataDAO;
    public NetworkRequestDAO networkRequestDAO;
    public RedactionDAO redactionDAO;
    public SmartIntentDAO smartIntentDAO;
    public KVStore storage;
    public Context uiContext;
    public Threader uiThreader;
    public UserDAO userDAO;
    public AndroidUserManagerDAO userManagerDAO = new AndroidUserManagerDAO(this.storage);

    public AndroidPlatform(Context context2, String str, String str2, String str3) {
        this.context = context2;
        this.apiKey = str;
        this.domain = str2;
        this.appId = str3;
        this.storage = new SupportKeyValueDBStorage(context2);
        AndroidBackupDAO androidBackupDAO = new AndroidBackupDAO();
        this.backupDAO = androidBackupDAO;
        AndroidDevice androidDevice = new AndroidDevice(context2, this.storage, androidBackupDAO);
        androidDevice.updateDeviceIdInBackupDAO();
        this.device = androidDevice;
        this.userDAO = new AndroidUserDAO(UserDB.getInstance(context2));
        this.clearedUserDAO = new AndroidClearedUserDAO(UserDB.getInstance(context2));
        this.jsonifier = new AndroidJsonifier();
        this.analyticsEventDAO = new AndroidAnalyticsEventDAO(this.storage);
        this.metaDataDAO = new AndroidMetadataDAO(this.storage);
    }

    private synchronized HSApiData getData() {
        if (this.data == null) {
            this.data = new HSApiData(this.context);
        }
        return this.data;
    }

    public boolean canReadFileAtUri(String str) {
        return HsUriUtils.canReadFileAtUri(this.context, str);
    }

    public void clearNotifications(String str) {
        ApplicationUtil.cancelNotification(this.context, str, 1);
    }

    public void compressAndCopyAttachment(AttachmentPickerFile attachmentPickerFile) throws RootAPIException {
        try {
            AttachmentUtil.copyAttachment(attachmentPickerFile);
        } catch (Exception e) {
            throw RootAPIException.wrap(e);
        }
    }

    public String compressAndStoreScreenshot(String str) {
        try {
            String copyAttachment = AttachmentUtil.copyAttachment(str);
            if (copyAttachment == null) {
                return str;
            }
            return copyAttachment;
        } catch (IOException e) {
            HSLogger.m3238d(TAG, "Saving attachment", (Throwable) e);
            return str;
        }
    }

    public String getAPIKey() {
        return this.apiKey;
    }

    public AnalyticsEventDAO getAnalyticsEventDAO() {
        return this.analyticsEventDAO;
    }

    public String getAppId() {
        return this.appId;
    }

    public BackupDAO getBackupDAO() {
        return this.backupDAO;
    }

    public ICampaignsModuleAPIs getCampaignModuleAPIs() {
        return CrossModuleDataProvider.getCampaignModuleAPIs();
    }

    public ClearedUserDAO getClearedUserDAO() {
        return this.clearedUserDAO;
    }

    public synchronized ConversationDAO getConversationDAO() {
        if (this.conversationDAO == null) {
            this.conversationDAO = new AndroidConversationDAO(this.context);
        }
        return this.conversationDAO;
    }

    public synchronized ConversationInboxDAO getConversationInboxDAO() {
        if (this.conversationInboxDAO == null) {
            this.conversationInboxDAO = new AndroidConversationInboxDAO(this.context, getKVStore());
        }
        return this.conversationInboxDAO;
    }

    public synchronized CustomIssueFieldDAO getCustomIssueFieldDAO() {
        if (this.customIssueFieldDAO == null) {
            this.customIssueFieldDAO = new AndroidCustomIssueFieldDAO(getKVStore());
        }
        return this.customIssueFieldDAO;
    }

    public Device getDevice() {
        return this.device;
    }

    public String getDomain() {
        return this.domain;
    }

    public synchronized SupportDownloader getDownloader() {
        if (this.downloader == null) {
            this.downloader = new AndroidSupportDownloader(this.context, getKVStore());
        }
        return this.downloader;
    }

    public synchronized FAQSearchDM getFAQSearchDM() {
        if (this.faqSearchDM == null) {
            this.faqSearchDM = new AndroidFAQSearchDM(getData());
        }
        return this.faqSearchDM;
    }

    public synchronized FAQSuggestionsDAO getFAQSuggestionsDAO() {
        if (this.conversationDAO == null) {
            this.conversationDAO = new AndroidConversationDAO(this.context);
        }
        return (FAQSuggestionsDAO) this.conversationDAO;
    }

    public synchronized FaqEventDAO getFaqEventDAO() {
        if (this.faqEventDAO == null) {
            this.faqEventDAO = new AndroidFaqEventDAO(getKVStore());
        }
        return this.faqEventDAO;
    }

    public synchronized HSNetworkMetadataDAO getHSNetworkMetadataDAO() {
        if (this.hsNetworkMetadataDAO == null) {
            this.hsNetworkMetadataDAO = new AndroidHSNetworkMetadataDAO(this.context);
        }
        return this.hsNetworkMetadataDAO;
    }

    public HTTPTransport getHTTPTransport() {
        return new AndroidHTTPTransport();
    }

    public Jsonifier getJsonifier() {
        return this.jsonifier;
    }

    public KVStore getKVStore() {
        return this.storage;
    }

    public synchronized LegacyAnalyticsEventIDDAO getLegacyAnalyticsEventIDDAO() {
        if (this.legacyAnalyticsEventIDDAO == null) {
            this.legacyAnalyticsEventIDDAO = new AndroidLegacyAnalyticsEventIDDAO(UserDB.getInstance(this.context));
        }
        return this.legacyAnalyticsEventIDDAO;
    }

    public synchronized LegacyProfileMigrationDAO getLegacyUserMigrationDataSource() {
        if (this.legacyProfileMigrationDAO == null) {
            this.legacyProfileMigrationDAO = new AndroidLegacyProfileMigrationDAO(UserDB.getInstance(this.context));
        }
        return this.legacyProfileMigrationDAO;
    }

    public MetaDataDAO getMetaDataDAO() {
        return this.metaDataDAO;
    }

    public String getMimeTypeForFile(String str) {
        return AndroidFileUtil.getMimeType(str);
    }

    public int getMinimumConversationDescriptionLength() {
        Context context2 = this.uiContext;
        if (context2 == null) {
            context2 = this.context;
        }
        return context2.getResources().getInteger(C2466R.integer.hs__issue_description_min_chars);
    }

    public synchronized NetworkRequestDAO getNetworkRequestDAO() {
        if (this.networkRequestDAO == null) {
            this.networkRequestDAO = new AndroidNetworkRequestDAO(getKVStore());
        }
        return this.networkRequestDAO;
    }

    public synchronized RedactionDAO getRedactionDAO() {
        if (this.redactionDAO == null) {
            this.redactionDAO = new AndroidRedactionDAO(UserDB.getInstance(this.context));
        }
        return this.redactionDAO;
    }

    public ResponseParser getResponseParser() {
        return new AndroidResponseParser();
    }

    public synchronized SmartIntentDAO getSmartIntentDAO() {
        if (this.smartIntentDAO == null) {
            this.smartIntentDAO = new AndroidSmartIntentDAO(this.context);
        }
        return this.smartIntentDAO;
    }

    public synchronized Threader getUIThreader() {
        if (this.uiThreader == null) {
            this.uiThreader = new Threader() {
                public C2500F thread(final C2500F f) {
                    return new C2500F() {
                        /* renamed from: f */
                        public void mo33949f() {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    f.mo33949f();
                                }
                            });
                        }
                    };
                }
            };
        }
        return this.uiThreader;
    }

    public UserDAO getUserDAO() {
        return this.userDAO;
    }

    public UserManagerDAO getUserManagerDAO() {
        return this.userManagerDAO;
    }

    public boolean isCurrentThreadUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean isOnline() {
        return HelpshiftConnectionUtil.isOnline(this.context);
    }

    public boolean isSupportedMimeType(String str) {
        return AndroidFileUtil.isSupportedMimeType(str);
    }

    public void setUIContext(Object obj) {
        if (obj == null) {
            this.uiContext = null;
        } else if (obj instanceof Context) {
            this.uiContext = (Context) obj;
        }
    }

    public void showNotification(Long l, String str, int i, String str2, boolean z) {
        Context context2 = this.uiContext;
        if (context2 == null) {
            context2 = LocaleContextUtil.getContextWithUpdatedLocale(this.context);
        }
        NotificationCompat.Builder createNotification = SupportNotification.createNotification(context2, l, str, i, str2);
        if (createNotification != null) {
            ApplicationUtil.showNotification(this.context, str, new NotificationChannelsManager(this.context).attachChannelId(createNotification.build(), NotificationChannelsManager.NotificationChannelType.SUPPORT));
            if (z) {
                PluginEventBridge.sendMessage("didReceiveInAppNotificationCount", "" + i);
            }
        }
    }
}
