package com.helpshift.account.dao;

import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.migration.LegacyAnalyticsEventIDDAO;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class AndroidLegacyAnalyticsEventIDDAO implements LegacyAnalyticsEventIDDAO {
    public UserDB userDB;

    public AndroidLegacyAnalyticsEventIDDAO(UserDB userDB2) {
        this.userDB = userDB2;
    }

    public String getLegacyAnalyticsEventId(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return this.userDB.fetchLegacyAnalyticsEventId(str);
    }

    public void storeLegacyAnalyticsEventIDs(List<KeyValuePair> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (KeyValuePair next : list) {
                if (next != null && !StringUtils.isEmpty(next.key) && !StringUtils.isEmpty(next.value)) {
                    arrayList.add(next);
                }
            }
            this.userDB.storeLegacyAnalyticsEventIds(arrayList);
        }
    }
}
