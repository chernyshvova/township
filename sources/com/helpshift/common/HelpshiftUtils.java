package com.helpshift.common;

import com.helpshift.HelpshiftUser;
import com.helpshift.util.StringUtils;

public class HelpshiftUtils {
    public static boolean isValidHelpshiftUser(HelpshiftUser helpshiftUser) {
        if (helpshiftUser == null) {
            return false;
        }
        if (!StringUtils.isEmptyWithoutTrim(helpshiftUser.getIdentifier()) || !StringUtils.isEmptyWithoutTrim(helpshiftUser.getEmail())) {
            return true;
        }
        return false;
    }
}
