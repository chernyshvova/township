package com.helpshift.configuration.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.configuration.dto.RootApiConfig;
import com.helpshift.configuration.dto.RootInstallConfig;
import com.helpshift.configuration.response.AvatarConfig;
import com.helpshift.configuration.response.PeriodicReview;
import com.helpshift.configuration.response.RootServerConfig;
import com.helpshift.conversation.activeconversation.message.AvatarImageDownloader;
import com.helpshift.logger.constants.LogLevel;
import com.helpshift.util.AttachmentConstants;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SDKConfigurationDM {
    public static final String ACTIVELY_SYNC_APP_LAUNCH_EVENT = "activelySyncAppLaunchEvent";
    public static final String AGENT_FALLBACK_IMAGE_LOCAL_PATH = "agentFallbackImageLocalPath";
    public static final String AGENT_FALLBACK_IMAGE_URL = "agentFallbackImageUrl";
    public static final String ALLOW_USER_ATTACHMENTS = "allowUserAttachments";
    public static final String API_KEY = "apiKey";
    public static final String APP_REVIEWED = "app_reviewed";
    public static final String AUTO_FILL_FIRST_PREISSUE_MESSAGE = "autoFillFirstPreIssueMessage";
    public static final String AVATAR_CACHE_EXPIRY = "avatarCacheExpiry";
    public static final long AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL = 14400000;
    public static final String AVATAR_IMAGE_LOCAL_PATH = "avatar_image_local_path";
    public static final String AVATAR_IMAGE_TEMPLATE_URL = "avatarTemplateUrl";
    public static final String AVATAR_IMAGE_URL = "avatar_image_url";
    public static final String BOT_FALLBACK_IMAGE_LOCAL_PATH = "botFallbackImageLocalPath";
    public static final String BOT_FALLBACK_IMAGE_URL = "botFallbackImageUrl";
    public static final String BREADCRUMB_LIMIT = "breadcrumbLimit";
    public static final String CONVERSATIONAL_ISSUE_FILING = "conversationalIssueFiling";
    public static final String CONVERSATION_GREETING_MESSAGE = "conversationGreetingMessage";
    public static final String CONVERSATION_PRE_FILL_TEXT = "conversationPrefillText";
    public static final String CUSTOMER_SATISFACTION_SURVEY = "customerSatisfactionSurvey";
    public static final String DEBUG_LOG_LIMIT = "debugLogLimit";
    public static final String DEFAULT_FALLBACK_LANGUAGE_ENABLE = "defaultFallbackLanguageEnable";
    public static final String DISABLE_ANIMATION = "disableAnimations";
    public static final String DISABLE_APP_LAUNCH_EVENT = "disableAppLaunchEvent";
    public static final String DISABLE_ERROR_LOGGING = "disableErrorLogging";
    public static final String DISABLE_IN_APP_CONVERSATION = "disableInAppConversation";
    public static final String DOMAIN_NAME = "domainName";
    public static final String ENABLE_CONTACT_US = "enableContactUs";
    public static final String ENABLE_DEFAULT_CONVERSATIONAL_FILING = "enableDefaultConversationalFiling";
    public static final String ENABLE_FULL_PRIVACY = "fullPrivacy";
    public static final String ENABLE_IN_APP_NOTIFICATION = "enableInAppNotification";
    public static final String ENABLE_TYPING_INDICATOR = "enableTypingIndicator";
    public static final String ENABLE_TYPING_INDICATOR_AGENT = "enableTypingIndicatorAgent";
    public static final String FONT_PATH = "fontPath";
    public static final String GOTO_CONVERSATION_AFTER_CONTACT_US = "gotoConversationAfterContactUs";
    public static final String HEADER_IMAGE_LOCAL_PATH = "headerImageLocalPath";
    public static final String HEADER_IMAGE_URL = "headerImageUrl";
    public static final String HEADER_TITLE_TEXT = "headerText";
    public static final String HELPSHIFT_BRANDING_DISABLE_AGENT = "disableHelpshiftBrandingAgent";
    public static final String HELPSHIFT_BRANDING_DISABLE_INSTALL = "disableHelpshiftBranding";
    public static final String HIDE_NAME_AND_EMAIL = "hideNameAndEmail";
    public static final String INBOX_POLLING_ENABLE = "inboxPollingEnable";
    public static final String INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE = "initialUserMessageToAutoSendInPreissue";
    public static final String IS_AVATAR_ENABLED_IN_CHAT_FEED = "showAvatarEnabled";
    public static final String IS_CUSTOM_HEADER_ENABLED = "showHeaderEnabled";
    public static final String IS_PERSONALISED_CONVERSATION_ENABLED = "personalisedConversationEnabled";
    public static final String IS_SMART_INTENT_ENABLED = "smartIntentEnabled";
    public static final String LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME = "lastSuccessfulAppLaunchEventTime";
    public static final String LAST_SUCCESSFUL_CONFIG_FETCH_TIME = "lastSuccessfulConfigFetchTime";
    public static final Long MINIMUM_PERIODIC_FETCH_INTERVAL = 60L;
    public static final Long MINIMUM_PREISSUE_RESET_INTERVAL = 43200L;
    public static final String NOTIFICATION_ICON_ID = "notificationIconId";
    public static final String NOTIFICATION_LARGE_ICON_ID = "notificationLargeIconId";
    public static final String NOTIFICATION_MUTE_ENABLE = "notificationMute";
    public static final String NOTIFICATION_SOUND_ID = "notificationSoundId";
    public static final String PERIODIC_FETCH_INTERVAL = "periodicFetchInterval";
    public static final String PERIODIC_REVIEW_ENABLED = "periodicReviewEnabled";
    public static final String PERIODIC_REVIEW_INTERVAL = "periodicReviewInterval";
    public static final String PERIODIC_REVIEW_TYPE = "periodicReviewType";
    public static final String PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL = "periodicSyncAppLaunchEventInterval";
    public static final String PLATFORM_ID = "platformId";
    public static final String PLUGIN_VERSION = "pluginVersion";
    public static final String PREISSUE_RESET_INTERVAL = "preissueResetInterval";
    public static final String PROFILE_FORM_ENABLE = "profileFormEnable";
    public static final String REQUIRED_LOG_LEVEL_FOR_REPORTING = "logLevelForReporting";
    public static final String REQUIRE_EMAIL = "requireEmail";
    public static final String REQUIRE_NAME_AND_EMAIL = "requireNameAndEmail";
    public static final String REVIEW_URL = "reviewUrl";
    public static final String RUNTIME_VERSION = "runtimeVersion";
    public static final String SDK_LANGUAGE = "sdkLanguage";
    public static final String SDK_TYPE = "sdkType";
    public static final String SHOULD_SHOW_CONVERSATION_HISTORY_AGENT = "showConversationHistoryAgent";
    public static final String SHOW_CONVERSATION_INFO_SCREEN = "showConversationInfoScreen";
    public static final String SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT = "showConversationResolutionQuestionAgent";
    public static final String SHOW_CONVERSATION_RESOLUTION_QUESTION_API = "showConversationResolutionQuestion";
    public static final String SHOW_PERSONALIZED_AGENT_AVATAR = "personalizedAgent";
    public static final String SHOW_PERSONALIZED_BOT_AVATAR = "personalizedBot";
    public static final String SHOW_SEARCH_ON_NEW_CONVERSATION = "showSearchOnNewConversation";
    public static final long SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL = 259200000;
    public static final String SMART_INTENT_CLIENT_CACHE_INTERVAL = "smartIntentClientCache";
    public static final long SMART_INTENT_MODEL_REFRESH_DEFAULT_INTERVAL = 600000;
    public static final String SMART_INTENT_MODEL_REFRESH_INTERVAL = "smartIntentModelSLA";
    public static final long SMART_INTENT_TREE_REFRESH_DEFAULT_INTERVAL = 600000;
    public static final String SMART_INTENT_TREE_REFRESH_INTERVAL = "smartIntentTreeSLA";
    public static final String SUPPORT_NOTIFICATION_CHANNEL_ID = "supportNotificationChannelId";
    public static final String SYSTEM_MESSAGE_NICKNAME = "systemMessageNickname";
    public static final String TAG = "Helpshift_SDKConfigDM";
    public static final String WHITELISTED_ATTACHMENT = "whiteListedAttachment";
    public final Domain domain;
    public final KVStore kvStore;
    public final Platform platform;
    public final ResponseParser responseParser;

    public SDKConfigurationDM(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
        this.responseParser = platform2.getResponseParser();
        this.kvStore = platform2.getKVStore();
    }

    private void downloadFallbackAndHeaderImages(boolean z, boolean z2, boolean z3) {
        if (isAvatarEnabledInChatFeed()) {
            if (z) {
                AvatarImageDownloader.downloadAgentFallbackImage(this.platform, this.domain);
            }
            if (z2) {
                AvatarImageDownloader.downloadBotFallbackImage(this.platform, this.domain);
            }
        }
        if (z3) {
            AvatarImageDownloader.downloadConversationHeaderImage(this.platform, this.domain);
        }
    }

    private void removeNullValues(Map<String, Serializable> map) {
        Iterator<Map.Entry<String, Serializable>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == null) {
                it.remove();
            }
        }
    }

    public String getAgentFallbackImageLocalPath() {
        return this.kvStore.getString(AGENT_FALLBACK_IMAGE_LOCAL_PATH, "");
    }

    public String getAgentFallbackImageUrl() {
        return this.kvStore.getString(AGENT_FALLBACK_IMAGE_URL, "");
    }

    public long getAppLaunchEventSyncInterval() {
        return this.kvStore.getLong(PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL, 0L).longValue();
    }

    public long getAvatarCacheExpiry() {
        return this.kvStore.getLong(AVATAR_CACHE_EXPIRY, Long.valueOf(AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL)).longValue();
    }

    public String getAvatarImageTemplateUrl() {
        return this.kvStore.getString(AVATAR_IMAGE_TEMPLATE_URL);
    }

    public String getAvatarImageUrl(String str) {
        String avatarImageTemplateUrl = getAvatarImageTemplateUrl();
        return StringUtils.isNotEmpty(avatarImageTemplateUrl) ? avatarImageTemplateUrl.replace("{{avatar_id}}", str) : "";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getBoolean(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1703140188: goto L_0x0040;
                case -591814160: goto L_0x0036;
                case -366496336: goto L_0x002c;
                case -338380156: goto L_0x0022;
                case 1262906910: goto L_0x0018;
                case 1423623260: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "allowUserAttachments"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 4
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "defaultFallbackLanguageEnable"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 2
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "enableInAppNotification"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 1
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "enableTypingIndicatorAgent"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 3
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "profileFormEnable"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 0
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "conversationalIssueFiling"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x004a
            r0 = 5
            goto L_0x004b
        L_0x004a:
            r0 = -1
        L_0x004b:
            if (r0 == 0) goto L_0x0067
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0067
            if (r0 == r4) goto L_0x0067
            if (r0 == r3) goto L_0x0067
            if (r0 == r2) goto L_0x0058
            goto L_0x0068
        L_0x0058:
            com.helpshift.common.platform.KVStore r0 = r7.kvStore
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "enableDefaultConversationalFiling"
            java.lang.Boolean r0 = r0.getBoolean(r2, r1)
            boolean r1 = r0.booleanValue()
            goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            com.helpshift.common.platform.KVStore r0 = r7.kvStore
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r8 = r0.getBoolean(r8, r1)
            boolean r8 = r8.booleanValue()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.configuration.domainmodel.SDKConfigurationDM.getBoolean(java.lang.String):boolean");
    }

    public String getBotFallbackImageLocalPath() {
        return this.kvStore.getString(BOT_FALLBACK_IMAGE_LOCAL_PATH, "");
    }

    public String getBotFallbackImageUrl() {
        return this.kvStore.getString(BOT_FALLBACK_IMAGE_URL, "");
    }

    public String getConversationHeaderImageLocalPath() {
        return this.kvStore.getString(HEADER_IMAGE_LOCAL_PATH, "");
    }

    public String getConversationHeaderImageUrl() {
        return this.kvStore.getString(HEADER_IMAGE_URL, "");
    }

    public String getCustomHeaderTitle() {
        return this.kvStore.getString(HEADER_TITLE_TEXT, "");
    }

    public RootApiConfig.EnableContactUs getEnableContactUs() {
        return RootApiConfig.EnableContactUs.fromInt(this.kvStore.getInt(ENABLE_CONTACT_US, 0).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Integer getInt(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -71624118(0xfffffffffbbb1a4a, float:-1.9429854E36)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 1384494456(0x5285b578, float:2.87137595E11)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "breadcrumbLimit"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "debugLogLimit"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x002b
            if (r0 == r2) goto L_0x002b
            r0 = 0
            goto L_0x0031
        L_0x002b:
            r0 = 100
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0031:
            com.helpshift.common.platform.KVStore r1 = r3.kvStore
            java.lang.Integer r4 = r1.getInt(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.configuration.domainmodel.SDKConfigurationDM.getInt(java.lang.String):java.lang.Integer");
    }

    public Long getLastSuccessfulAppLaunchEventSyncTime() {
        return this.kvStore.getLong(LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME, 0L);
    }

    public Long getLastSuccessfulConfigFetchTime() {
        return this.kvStore.getLong(LAST_SUCCESSFUL_CONFIG_FETCH_TIME, 0L);
    }

    public int getMinimumConversationDescriptionLength() {
        return this.platform.getMinimumConversationDescriptionLength();
    }

    public long getPeriodicFetchInterval() {
        return Math.max(this.kvStore.getLong(PERIODIC_FETCH_INTERVAL, 0L).longValue(), MINIMUM_PERIODIC_FETCH_INTERVAL.longValue());
    }

    public PeriodicReview getPeriodicReview() {
        return new PeriodicReview(this.kvStore.getBoolean(PERIODIC_REVIEW_ENABLED, Boolean.FALSE).booleanValue(), this.kvStore.getInt(PERIODIC_REVIEW_INTERVAL, 0).intValue(), this.kvStore.getString(PERIODIC_REVIEW_TYPE, ""));
    }

    public long getPreissueResetInterval() {
        return Math.max(this.kvStore.getLong(PREISSUE_RESET_INTERVAL, 0L).longValue(), MINIMUM_PREISSUE_RESET_INTERVAL.longValue());
    }

    public int getRequiredLogCachingLevel() {
        return this.kvStore.getInt(REQUIRED_LOG_LEVEL_FOR_REPORTING, Integer.valueOf(LogLevel.FATAL.getValue())).intValue();
    }

    public long getSmartIntentClientCacheExpiryInterval() {
        return this.kvStore.getLong(SMART_INTENT_CLIENT_CACHE_INTERVAL, 259200000L).longValue();
    }

    public long getSmartIntentModelRefreshInterval() {
        return this.kvStore.getLong(SMART_INTENT_MODEL_REFRESH_INTERVAL, 600000L).longValue();
    }

    public long getSmartIntentTreeRefreshInterval() {
        return this.kvStore.getLong(SMART_INTENT_TREE_REFRESH_INTERVAL, 600000L).longValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getString(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -340534862: goto L_0x0029;
                case 365503764: goto L_0x001f;
                case 493025015: goto L_0x0015;
                case 1948062356: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "sdkType"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "reviewUrl"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "fontPath"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "sdkLanguage"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x0041
            if (r0 == r3) goto L_0x0041
            if (r0 == r2) goto L_0x0041
            if (r0 == r1) goto L_0x003e
            r0 = 0
            goto L_0x0043
        L_0x003e:
            java.lang.String r0 = "android"
            goto L_0x0043
        L_0x0041:
            java.lang.String r0 = ""
        L_0x0043:
            com.helpshift.common.platform.KVStore r1 = r4.kvStore
            java.lang.String r5 = r1.getString(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.configuration.domainmodel.SDKConfigurationDM.getString(java.lang.String):java.lang.String");
    }

    public String getSystemMessageNickname() {
        return this.kvStore.getString(SYSTEM_MESSAGE_NICKNAME, "");
    }

    public List<String> getWhiteListAttachmentMimeTypes() {
        Object serializable = this.kvStore.getSerializable(WHITELISTED_ATTACHMENT);
        if (serializable != null) {
            return ListUtils.flatten((List) serializable);
        }
        return Arrays.asList(new String[]{AttachmentConstants.ALLOW_ALL_MIME});
    }

    public boolean isActivelySyncAppLaunchEventEnabled() {
        return this.kvStore.getBoolean(ACTIVELY_SYNC_APP_LAUNCH_EVENT, Boolean.TRUE).booleanValue();
    }

    public boolean isAvatarEnabledInChatFeed() {
        return this.kvStore.getBoolean(IS_AVATAR_ENABLED_IN_CHAT_FEED, Boolean.TRUE).booleanValue() && isPersonalisedConversationEnabled();
    }

    public boolean isConversationHeaderEnabled() {
        return this.kvStore.getBoolean(IS_CUSTOM_HEADER_ENABLED, Boolean.TRUE).booleanValue();
    }

    public boolean isHelpshiftBrandingDisabled() {
        return this.kvStore.getBoolean("disableHelpshiftBranding", Boolean.FALSE).booleanValue() || this.kvStore.getBoolean(HELPSHIFT_BRANDING_DISABLE_AGENT, Boolean.FALSE).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isImageWhiteListed() {
        /*
            r3 = this;
            java.util.List r0 = r3.getWhiteListAttachmentMimeTypes()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "image/"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L_0x0024
            java.lang.String r2 = "*/*"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0008
        L_0x0024:
            r0 = 1
            return r0
        L_0x0026:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.configuration.domainmodel.SDKConfigurationDM.isImageWhiteListed():boolean");
    }

    public boolean isPersonalisedAgentEnabled() {
        return this.kvStore.getBoolean(SHOW_PERSONALIZED_AGENT_AVATAR, Boolean.FALSE).booleanValue() && isAvatarEnabledInChatFeed();
    }

    public boolean isPersonalisedBotEnabled() {
        return this.kvStore.getBoolean(SHOW_PERSONALIZED_BOT_AVATAR, Boolean.FALSE).booleanValue() && isAvatarEnabledInChatFeed();
    }

    public boolean isPersonalisedConversationEnabled() {
        return this.kvStore.getBoolean(IS_PERSONALISED_CONVERSATION_ENABLED, Boolean.TRUE).booleanValue();
    }

    public boolean isSmartIntentsEnabled() {
        return this.kvStore.getBoolean(IS_SMART_INTENT_ENABLED, Boolean.FALSE).booleanValue();
    }

    public void setAgentAvatarImagePath(String str) {
        this.kvStore.setString(AGENT_FALLBACK_IMAGE_LOCAL_PATH, str);
    }

    public void setAppReviewed(boolean z) {
        this.kvStore.setBoolean(APP_REVIEWED, Boolean.valueOf(z));
    }

    public void setBotAvatarImagePath(String str) {
        this.kvStore.setString(BOT_FALLBACK_IMAGE_LOCAL_PATH, str);
    }

    public void setHeaderAvatarImagePath(String str) {
        this.kvStore.setString(HEADER_IMAGE_LOCAL_PATH, str);
    }

    public void setSdkLanguage(String str) {
        String str2;
        String string = getString(SDK_LANGUAGE);
        if (StringUtils.isEmpty(string)) {
            string = "";
        }
        if (StringUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (!str2.equals(string)) {
            this.platform.getNetworkRequestDAO().storeETag(NetworkConstants.SUPPORT_CONFIG_ROUTE, "");
        }
        this.kvStore.setString(SDK_LANGUAGE, str);
    }

    public boolean shouldAutoFillPreissueFirstMessage() {
        return this.kvStore.getBoolean(AUTO_FILL_FIRST_PREISSUE_MESSAGE, Boolean.FALSE).booleanValue();
    }

    public boolean shouldCreateConversationAnonymously() {
        return getBoolean(ENABLE_FULL_PRIVACY) || ((!getBoolean(REQUIRE_NAME_AND_EMAIL) || !getBoolean(HIDE_NAME_AND_EMAIL)) && !getBoolean(PROFILE_FORM_ENABLE));
    }

    public boolean shouldEnableTypingIndicator() {
        return getBoolean(ENABLE_TYPING_INDICATOR_AGENT) || getBoolean(ENABLE_TYPING_INDICATOR);
    }

    public boolean shouldShowConversationHistory() {
        if (!getBoolean(SHOULD_SHOW_CONVERSATION_HISTORY_AGENT) || !getBoolean(CONVERSATIONAL_ISSUE_FILING)) {
            return false;
        }
        return !getBoolean(ENABLE_FULL_PRIVACY);
    }

    public boolean shouldShowConversationResolutionQuestion() {
        return getBoolean(SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT) || getBoolean(SHOW_CONVERSATION_RESOLUTION_QUESTION_API);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void storeDownloadedImage(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -996622595(0xffffffffc498befd, float:-1221.9684)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 662817729(0x2781cbc1, float:3.6025603E-15)
            if (r0 == r1) goto L_0x0020
            r1 = 1628981307(0x6118483b, float:1.7556937E20)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "agentFallbackImageUrl"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "headerImageUrl"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "botFallbackImageUrl"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0034
            r6 = 2
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 == 0) goto L_0x0044
            if (r6 == r3) goto L_0x0040
            if (r6 == r2) goto L_0x003c
            goto L_0x0047
        L_0x003c:
            r4.setBotAvatarImagePath(r5)
            goto L_0x0047
        L_0x0040:
            r4.setAgentAvatarImagePath(r5)
            goto L_0x0047
        L_0x0044:
            r4.setHeaderAvatarImagePath(r5)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.configuration.domainmodel.SDKConfigurationDM.storeDownloadedImage(java.lang.String, java.lang.String):void");
    }

    public void updateApiConfig(RootApiConfig rootApiConfig) {
        HashMap hashMap = new HashMap();
        hashMap.put(CONVERSATION_PRE_FILL_TEXT, rootApiConfig.conversationPrefillText);
        hashMap.put(INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE, rootApiConfig.initialUserMessageToAutoSend);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ENABLE_FULL_PRIVACY, rootApiConfig.enableFullPrivacy);
        hashMap2.put(HIDE_NAME_AND_EMAIL, rootApiConfig.hideNameAndEmail);
        hashMap2.put(REQUIRE_EMAIL, rootApiConfig.requireEmail);
        hashMap2.put(SHOW_SEARCH_ON_NEW_CONVERSATION, rootApiConfig.showSearchOnNewConversation);
        hashMap2.put(GOTO_CONVERSATION_AFTER_CONTACT_US, rootApiConfig.gotoConversationAfterContactUs);
        hashMap2.put(SHOW_CONVERSATION_RESOLUTION_QUESTION_API, rootApiConfig.showConversationResolutionQuestion);
        hashMap2.put(SHOW_CONVERSATION_INFO_SCREEN, rootApiConfig.showConversationInfoScreen);
        hashMap2.put(ENABLE_TYPING_INDICATOR, rootApiConfig.enableTypingIndicator);
        RootApiConfig.EnableContactUs enableContactUs = rootApiConfig.enableContactUs;
        if (enableContactUs != null) {
            hashMap2.put(ENABLE_CONTACT_US, Integer.valueOf(enableContactUs.getValue()));
        }
        hashMap2.put(ENABLE_DEFAULT_CONVERSATIONAL_FILING, rootApiConfig.enableDefaultConversationalFiling);
        removeNullValues(hashMap2);
        hashMap2.putAll(hashMap);
        this.kvStore.setKeyValues(hashMap2);
    }

    public void updateInstallConfig(RootInstallConfig rootInstallConfig) {
        HashMap hashMap = new HashMap();
        String str = rootInstallConfig.supportNotificationChannelId;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = rootInstallConfig.fontPath;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put(SUPPORT_NOTIFICATION_CHANNEL_ID, str);
        hashMap.put(FONT_PATH, str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ENABLE_IN_APP_NOTIFICATION, rootInstallConfig.enableInAppNotification);
        hashMap2.put(DEFAULT_FALLBACK_LANGUAGE_ENABLE, rootInstallConfig.enableDefaultFallbackLanguage);
        hashMap2.put(INBOX_POLLING_ENABLE, rootInstallConfig.enableInboxPolling);
        hashMap2.put(NOTIFICATION_MUTE_ENABLE, rootInstallConfig.enableNotificationMute);
        hashMap2.put(DISABLE_ANIMATION, rootInstallConfig.disableAnimations);
        hashMap2.put("disableHelpshiftBranding", rootInstallConfig.disableHelpshiftBranding);
        hashMap2.put(DISABLE_ERROR_LOGGING, rootInstallConfig.disableErrorLogging);
        hashMap2.put(DISABLE_APP_LAUNCH_EVENT, rootInstallConfig.disableAppLaunchEvent);
        hashMap2.put(NOTIFICATION_SOUND_ID, rootInstallConfig.notificationSound);
        hashMap2.put(NOTIFICATION_ICON_ID, rootInstallConfig.notificationIcon);
        hashMap2.put(NOTIFICATION_LARGE_ICON_ID, rootInstallConfig.largeNotificationIcon);
        hashMap2.put(SDK_TYPE, rootInstallConfig.sdkType);
        hashMap2.put(PLUGIN_VERSION, rootInstallConfig.pluginVersion);
        hashMap2.put(RUNTIME_VERSION, rootInstallConfig.runtimeVersion);
        removeNullValues(hashMap2);
        hashMap2.putAll(hashMap);
        this.kvStore.setKeyValues(hashMap2);
    }

    public void updateLastSuccessfulAppLaunchEventSyncTime() {
        this.kvStore.setLong(LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME, Long.valueOf(System.currentTimeMillis()));
    }

    public void updateLastSuccessfulConfigFetchTime() {
        this.kvStore.setLong(LAST_SUCCESSFUL_CONFIG_FETCH_TIME, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    public void updateServerConfig(RootServerConfig rootServerConfig) {
        boolean z;
        boolean z2;
        RootServerConfig rootServerConfig2 = rootServerConfig;
        HashMap hashMap = new HashMap();
        hashMap.put(REQUIRE_NAME_AND_EMAIL, Boolean.valueOf(rootServerConfig2.requireNameAndEmail));
        hashMap.put(PROFILE_FORM_ENABLE, Boolean.valueOf(rootServerConfig2.profileFormEnable));
        hashMap.put(CUSTOMER_SATISFACTION_SURVEY, Boolean.valueOf(rootServerConfig2.customerSatisfactionSurvey));
        hashMap.put(DISABLE_IN_APP_CONVERSATION, Boolean.valueOf(rootServerConfig2.disableInAppConversation));
        hashMap.put(HELPSHIFT_BRANDING_DISABLE_AGENT, Boolean.valueOf(rootServerConfig2.disableHelpshiftBranding));
        hashMap.put(DEBUG_LOG_LIMIT, Integer.valueOf(rootServerConfig2.debugLogLimit));
        hashMap.put(BREADCRUMB_LIMIT, Integer.valueOf(rootServerConfig2.breadcrumbLimit));
        hashMap.put(REVIEW_URL, rootServerConfig2.reviewUrl);
        PeriodicReview periodicReview = rootServerConfig2.periodicReview;
        boolean z3 = false;
        if (periodicReview == null) {
            periodicReview = new PeriodicReview(false, 0, (String) null);
        }
        hashMap.put(PERIODIC_REVIEW_ENABLED, Boolean.valueOf(periodicReview.isEnabled));
        hashMap.put(PERIODIC_REVIEW_INTERVAL, Integer.valueOf(periodicReview.interval));
        hashMap.put(PERIODIC_REVIEW_TYPE, periodicReview.type);
        hashMap.put(CONVERSATION_GREETING_MESSAGE, rootServerConfig2.conversationGreetingMessage);
        hashMap.put(CONVERSATIONAL_ISSUE_FILING, Boolean.valueOf(rootServerConfig2.conversationalIssueFiling));
        hashMap.put(ENABLE_TYPING_INDICATOR_AGENT, Boolean.valueOf(rootServerConfig2.enableTypingIndicator));
        hashMap.put(SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT, Boolean.valueOf(rootServerConfig2.showConversationResolutionQuestion));
        hashMap.put(SHOULD_SHOW_CONVERSATION_HISTORY_AGENT, Boolean.valueOf(rootServerConfig2.shouldShowConversationHistory));
        hashMap.put(ALLOW_USER_ATTACHMENTS, Boolean.valueOf(rootServerConfig2.allowUserAttachments));
        hashMap.put(PERIODIC_FETCH_INTERVAL, Long.valueOf(rootServerConfig2.periodicFetchInterval));
        hashMap.put(PREISSUE_RESET_INTERVAL, Long.valueOf(rootServerConfig2.preissueResetInterval));
        hashMap.put(AUTO_FILL_FIRST_PREISSUE_MESSAGE, Boolean.valueOf(rootServerConfig2.autoFillFirstPreissueMessage));
        hashMap.put(IS_SMART_INTENT_ENABLED, Boolean.valueOf(rootServerConfig2.isSmartIntentEnabled));
        hashMap.put(SMART_INTENT_MODEL_REFRESH_INTERVAL, rootServerConfig2.smartIntentSearchModelRefreshInterval);
        hashMap.put(SMART_INTENT_TREE_REFRESH_INTERVAL, rootServerConfig2.smartIntentTreeRefreshInterval);
        hashMap.put(SMART_INTENT_CLIENT_CACHE_INTERVAL, rootServerConfig2.smartIntentClientCacheInterval);
        hashMap.put(WHITELISTED_ATTACHMENT, rootServerConfig2.whiteListedAttachments);
        hashMap.put(REQUIRED_LOG_LEVEL_FOR_REPORTING, Integer.valueOf(rootServerConfig2.logLevel));
        hashMap.put(ACTIVELY_SYNC_APP_LAUNCH_EVENT, Boolean.valueOf(rootServerConfig2.activelySyncAppLaunchEvent));
        hashMap.put(PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL, Long.valueOf(rootServerConfig2.periodicSyncAppLaunchEventInterval));
        AvatarConfig avatarConfig = rootServerConfig2.avatarConfig;
        boolean z4 = avatarConfig != null;
        if (avatarConfig == null) {
            avatarConfig = new AvatarConfig(false, false, "", false, "", "", "", 0);
        }
        if (avatarConfig.isShowAvatarInChatFeedEnabled) {
            z3 = !rootServerConfig2.conversationHeaderImageUrl.equals(getConversationHeaderImageUrl());
            z2 = !avatarConfig.botFallbackImageUrl.equals(getBotFallbackImageUrl());
            z = !avatarConfig.agentFallbackImageUrl.equals(getAgentFallbackImageUrl());
        } else {
            z2 = false;
            z = false;
        }
        if (rootServerConfig2.isShowConversationHeaderEnabled) {
            z3 = !rootServerConfig2.conversationHeaderImageUrl.equals(getConversationHeaderImageUrl());
        }
        hashMap.put(IS_PERSONALISED_CONVERSATION_ENABLED, Boolean.valueOf(z4));
        hashMap.put(IS_CUSTOM_HEADER_ENABLED, Boolean.valueOf(rootServerConfig2.isShowConversationHeaderEnabled));
        hashMap.put(IS_AVATAR_ENABLED_IN_CHAT_FEED, Boolean.valueOf(avatarConfig.isShowAvatarInChatFeedEnabled));
        hashMap.put(HEADER_TITLE_TEXT, rootServerConfig2.conversationHeaderTitleText);
        hashMap.put(HEADER_IMAGE_URL, rootServerConfig2.conversationHeaderImageUrl);
        hashMap.put(SHOW_PERSONALIZED_AGENT_AVATAR, Boolean.valueOf(avatarConfig.isPersonalisedAgentEnabled));
        hashMap.put(AGENT_FALLBACK_IMAGE_URL, avatarConfig.agentFallbackImageUrl);
        hashMap.put(SHOW_PERSONALIZED_BOT_AVATAR, Boolean.valueOf(avatarConfig.isPersonalisedBotEnabled));
        hashMap.put(BOT_FALLBACK_IMAGE_URL, avatarConfig.botFallbackImageUrl);
        hashMap.put(SYSTEM_MESSAGE_NICKNAME, avatarConfig.systemMessageNickname);
        hashMap.put(AVATAR_IMAGE_TEMPLATE_URL, avatarConfig.templateUrl);
        hashMap.put(AVATAR_CACHE_EXPIRY, Long.valueOf(avatarConfig.cacheExpiry));
        this.kvStore.setKeyValues(hashMap);
        downloadFallbackAndHeaderImages(z, z2, z3);
    }

    public void updateUserConfig(UserDM userDM, RootServerConfig rootServerConfig, UserManagerDM userManagerDM) {
        userManagerDM.updateIssueExists(userDM, rootServerConfig.issueExists);
    }
}
