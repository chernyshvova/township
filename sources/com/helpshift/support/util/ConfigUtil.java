package com.helpshift.support.util;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.model.AppInfoModel;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.SupportInternal;
import java.util.HashMap;
import java.util.Map;

public class ConfigUtil {
    public static final Map<String, Object> defaultApiConfig = new HashMap();
    public static final Map<String, Object> defaultInstallConfig = new HashMap();

    public static Map<String, Object> getDefaultApiConfig() {
        if (defaultApiConfig.size() == 0) {
            defaultApiConfig.put(SDKConfigurationDM.ENABLE_CONTACT_US, SupportInternal.EnableContactUs.ALWAYS);
            defaultApiConfig.put(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US, Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.REQUIRE_EMAIL, Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.HIDE_NAME_AND_EMAIL, Boolean.FALSE);
            defaultApiConfig.put("enableFullPrivacy", Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, Boolean.FALSE);
            defaultApiConfig.put(SDKConfigurationDM.ENABLE_TYPING_INDICATOR, Boolean.FALSE);
        }
        return defaultApiConfig;
    }

    public static Map<String, Object> getDefaultInstallConfig() {
        if (defaultInstallConfig.size() == 0) {
            defaultInstallConfig.put("enableLogging", Boolean.FALSE);
            defaultInstallConfig.put("disableHelpshiftBranding", Boolean.FALSE);
            defaultInstallConfig.put(SDKConfigurationDM.DISABLE_APP_LAUNCH_EVENT, Boolean.FALSE);
            defaultInstallConfig.put(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION, Boolean.TRUE);
            defaultInstallConfig.put("enableDefaultFallbackLanguage", Boolean.TRUE);
            defaultInstallConfig.put(SDKConfigurationDM.DISABLE_ANIMATION, Boolean.FALSE);
            defaultInstallConfig.put("font", (Object) null);
            defaultInstallConfig.put(SDKConfigurationDM.SUPPORT_NOTIFICATION_CHANNEL_ID, (Object) null);
            defaultInstallConfig.put(AppInfoModel.SCREEN_ORIENTATION_KEY, -1);
            defaultInstallConfig.put("manualLifecycleTracking", Boolean.FALSE);
        }
        return defaultInstallConfig;
    }

    public static Map<String, Object> validateAndConvertToMap(ApiConfig apiConfig) {
        HashMap hashMap = new HashMap();
        if (apiConfig != null) {
            hashMap.putAll(apiConfig.toMap());
        }
        return hashMap;
    }
}
