package com.swrve.sdk.localstorage;

import com.swrve.sdk.SwrveUser;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public interface LocalStorage {
    public static final String SIGNATURE_SUFFIX = "_SGT";

    long addEvent(String str, String str2) throws Exception;

    void deleteNotificationsAuthenticated();

    void deleteUser(String str);

    SwrveCacheItem getCacheItem(String str, String str2);

    LinkedHashMap<Long, String> getFirstNEvents(Integer num, String str);

    List<Integer> getNotificationsAuthenticated();

    String getOfflineCampaign(String str, String str2);

    String getSecureCacheEntryForUser(String str, String str2, String str3) throws SecurityException;

    SwrveUser getUserByExternalUserId(String str);

    SwrveUser getUserBySwrveUserId(String str);

    void removeEvents(String str, Collection<Long> collection);

    void saveNotificationAuthenticated(int i, long j);

    void saveOfflineCampaign(String str, String str2, String str3);

    void saveUser(SwrveUser swrveUser);

    void setCacheEntry(String str, String str2, String str3);

    void setSecureCacheEntryForUser(String str, String str2, String str3, String str4);

    void truncateNotificationsAuthenticated(int i);
}
