package com.helpshift.configuration.dto;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.util.MapUtil;
import java.util.Map;

public class RootInstallConfig {
    public final Boolean disableAnimations;
    public final Boolean disableAppLaunchEvent;
    public final Boolean disableErrorLogging;
    public final Boolean disableHelpshiftBranding;
    public final Boolean enableDefaultFallbackLanguage;
    public final Boolean enableInAppNotification;
    public final Boolean enableInboxPolling;
    public final Boolean enableNotificationMute;
    public final String fontPath;
    public final Integer largeNotificationIcon;
    public final Integer notificationIcon;
    public final Integer notificationSound;
    public final String pluginVersion;
    public final String runtimeVersion;
    public final String sdkType;
    public final String supportNotificationChannelId;

    public static final class RootInstallConfigBuilder {
        public Boolean disableAnimations;
        public Boolean disableAppLaunchEvent;
        public Boolean disableErrorLogging;
        public Boolean disableHelpshiftBranding;
        public Boolean enableDefaultFallbackLanguage;
        public Boolean enableInAppNotification;
        public Boolean enableInboxPolling;
        public Boolean enableNotificationMute;
        public String fontPath;
        public Integer largeNotificationIcon;
        public Integer notificationIcon;
        public Integer notificationSound;
        public String pluginVersion;
        public String runtimeVersion;
        public String sdkType;
        public String supportNotificationChannelId;

        public RootInstallConfigBuilder applyMap(Map<String, Object> map) {
            Class cls = Integer.class;
            Class cls2 = String.class;
            Class cls3 = Boolean.class;
            this.enableInAppNotification = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION, cls3, this.enableInAppNotification);
            this.enableDefaultFallbackLanguage = (Boolean) MapUtil.getValue(map, "enableDefaultFallbackLanguage", cls3, this.enableDefaultFallbackLanguage);
            this.enableInboxPolling = (Boolean) MapUtil.getValue(map, "enableInboxPolling", cls3, this.enableInboxPolling);
            this.enableNotificationMute = (Boolean) MapUtil.getValue(map, "enableNotificationMute", cls3, this.enableNotificationMute);
            this.disableHelpshiftBranding = (Boolean) MapUtil.getValue(map, "disableHelpshiftBranding", cls3, this.disableHelpshiftBranding);
            this.disableErrorLogging = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.DISABLE_ERROR_LOGGING, cls3, this.disableErrorLogging);
            this.disableAppLaunchEvent = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.DISABLE_APP_LAUNCH_EVENT, cls3, this.disableAppLaunchEvent);
            this.disableAnimations = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.DISABLE_ANIMATION, cls3, this.disableAnimations);
            this.notificationIcon = (Integer) MapUtil.getValue(map, "notificationIcon", cls, this.notificationIcon);
            this.largeNotificationIcon = (Integer) MapUtil.getValue(map, "largeNotificationIcon", cls, this.largeNotificationIcon);
            this.notificationSound = (Integer) MapUtil.getValue(map, "notificationSound", cls, this.notificationSound);
            this.fontPath = (String) MapUtil.getValue(map, "font", cls2, this.fontPath);
            this.sdkType = (String) MapUtil.getValue(map, SDKConfigurationDM.SDK_TYPE, cls2, this.sdkType);
            this.pluginVersion = (String) MapUtil.getValue(map, SDKConfigurationDM.PLUGIN_VERSION, cls2, this.pluginVersion);
            this.runtimeVersion = (String) MapUtil.getValue(map, SDKConfigurationDM.RUNTIME_VERSION, cls2, this.runtimeVersion);
            this.supportNotificationChannelId = (String) MapUtil.getValue(map, SDKConfigurationDM.SUPPORT_NOTIFICATION_CHANNEL_ID, cls2, this.supportNotificationChannelId);
            return this;
        }

        public RootInstallConfig build() {
            return new RootInstallConfig(this.enableInAppNotification, this.enableDefaultFallbackLanguage, this.enableInboxPolling, this.enableNotificationMute, this.disableHelpshiftBranding, this.disableAnimations, this.disableErrorLogging, this.disableAppLaunchEvent, this.notificationIcon, this.largeNotificationIcon, this.notificationSound, this.fontPath, this.sdkType, this.pluginVersion, this.runtimeVersion, this.supportNotificationChannelId);
        }
    }

    public RootInstallConfig(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, String str5) {
        this.enableInAppNotification = bool;
        this.enableNotificationMute = bool4;
        this.disableHelpshiftBranding = bool5;
        this.disableAnimations = bool6;
        this.disableErrorLogging = bool7;
        this.disableAppLaunchEvent = bool8;
        this.notificationIcon = num;
        this.largeNotificationIcon = num2;
        this.notificationSound = num3;
        this.enableDefaultFallbackLanguage = bool2;
        this.enableInboxPolling = bool3;
        this.fontPath = str;
        this.sdkType = str2;
        this.pluginVersion = str3;
        this.runtimeVersion = str4;
        this.supportNotificationChannelId = str5;
    }
}
