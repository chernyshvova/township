package com.helpshift.analytics.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.platform.Platform;
import com.helpshift.util.StringUtils;

public class LegacyAnalyticsEventDM {
    public Platform platform;

    public LegacyAnalyticsEventDM(Platform platform2) {
        this.platform = platform2;
    }

    public String getLegacyAnalyticsEventId(UserDM userDM) {
        if (!userDM.isAnonymousUser() && !StringUtils.isEmpty(userDM.getIdentifier())) {
            return this.platform.getLegacyAnalyticsEventIDDAO().getLegacyAnalyticsEventId(userDM.getIdentifier());
        }
        return null;
    }
}
