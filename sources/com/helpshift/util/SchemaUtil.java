package com.helpshift.util;

import com.helpshift.exceptions.InstallException;

public class SchemaUtil {
    public static boolean validateApiKey(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean validateDomainName(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static boolean validateInputForComponent(String str, String str2) {
        return !TextUtils.isEmpty(str) && HSPattern.getComponentPlaceHolderPattern(str2).matcher(str).matches();
    }

    public static boolean validateInstallCredentials(String str, String str2, String str3) throws InstallException {
        if (!validateApiKey(str)) {
            throw new InstallException("The api key used in the Core.install(application, apiKey, domain, appId) is not valid!");
        } else if (!validateDomainName(str2)) {
            throw new InstallException("The domain name used in the Core.install(application, apiKey, domain, appId) is not valid!");
        } else if (validatePlatformId(str3)) {
            return true;
        } else {
            throw new InstallException("The app id used in the Core.install(application, apiKey, domain, appId) is not valid!");
        }
    }

    public static boolean validatePlatformId(String str) {
        return !TextUtils.isEmpty(str) && validateInputForComponent(str, "platform");
    }

    public static boolean validatePropertyKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return HSPattern.getPropertyKeyPattern().matcher(str).matches();
    }

    public static boolean validateTimestamp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return HSPattern.getTimeStampPattern().matcher(str).matches();
    }
}
