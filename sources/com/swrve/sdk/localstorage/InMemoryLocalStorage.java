package com.swrve.sdk.localstorage;

import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveUser;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLocalStorage implements LocalStorage {
    public static final int MAX_ELEMENTS = 2000;
    public Map<String, Map<String, SwrveCacheItem>> cachePerUserId = new HashMap();
    public Map<String, List<SwrveEventItem>> eventsPerUserId = new HashMap();

    private int getCacheSize() {
        int i = 0;
        for (Map.Entry<String, Map<String, SwrveCacheItem>> value : this.cachePerUserId.entrySet()) {
            i += ((Map) value.getValue()).size();
        }
        return i;
    }

    private int getEventsSize() {
        int i = 0;
        for (Map.Entry<String, List<SwrveEventItem>> value : this.eventsPerUserId.entrySet()) {
            i += ((List) value.getValue()).size();
        }
        return i;
    }

    public synchronized long addEvent(String str, String str2) {
        long j;
        j = 0;
        if (str == null || str2 == null) {
            SwrveLogger.m2754e("Cannot set null value for event in userId:%s eventJSON:%s", str, str2);
        } else if (getEventsSize() >= 2000) {
            SwrveLogger.m2758w("The number of In Memory event items has reached its limit. Cannot store anymore until a new session.", new Object[0]);
        } else {
            List list = this.eventsPerUserId.get(str);
            if (list == null) {
                list = new ArrayList();
            }
            SwrveEventItem swrveEventItem = new SwrveEventItem();
            swrveEventItem.userId = str;
            swrveEventItem.event = str2;
            list.add(swrveEventItem);
            this.eventsPerUserId.put(str, list);
            j = swrveEventItem.f2794id;
        }
        return j;
    }

    public void deleteNotificationsAuthenticated() {
    }

    public void deleteUser(String str) {
    }

    public synchronized SwrveCacheItem getCacheItem(String str, String str2) {
        Map map;
        map = this.cachePerUserId.get(str);
        if (map == null) {
            map = new HashMap();
        }
        return (SwrveCacheItem) map.get(str2);
    }

    public synchronized LinkedHashMap<Long, String> getFirstNEvents(Integer num, String str) {
        LinkedHashMap<Long, String> linkedHashMap;
        linkedHashMap = new LinkedHashMap<>();
        List list = this.eventsPerUserId.get(str);
        if (list != null && list.size() > 0) {
            int intValue = num.intValue();
            Iterator it = list.iterator();
            while (it.hasNext() && intValue > 0) {
                SwrveEventItem swrveEventItem = (SwrveEventItem) it.next();
                linkedHashMap.put(Long.valueOf(swrveEventItem.f2794id), swrveEventItem.event);
                intValue--;
            }
        }
        return linkedHashMap;
    }

    public List<Integer> getNotificationsAuthenticated() {
        return null;
    }

    public String getOfflineCampaign(String str, String str2) {
        return null;
    }

    public synchronized String getSecureCacheEntryForUser(String str, String str2, String str3) throws SecurityException {
        String str4;
        SwrveCacheItem cacheItem = getCacheItem(str, str2);
        SwrveCacheItem cacheItem2 = getCacheItem(str, str2 + LocalStorage.SIGNATURE_SUFFIX);
        if (cacheItem == null || cacheItem2 == null) {
            return null;
        }
        str4 = cacheItem.rawData;
        String str5 = cacheItem2.rawData;
        try {
            String createHMACWithMD5 = SwrveHelper.createHMACWithMD5(str4, str3);
            if (SwrveHelper.isNullOrEmpty(createHMACWithMD5) || SwrveHelper.isNullOrEmpty(str5) || !str5.equals(createHMACWithMD5)) {
                throw new SecurityException("Signature validation failed");
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
        }
        return str4;
    }

    public SwrveUser getUserByExternalUserId(String str) {
        return null;
    }

    public SwrveUser getUserBySwrveUserId(String str) {
        return null;
    }

    public synchronized void removeEvents(String str, Collection<Long> collection) {
        Iterator it = this.eventsPerUserId.get(str).iterator();
        while (it.hasNext()) {
            if (collection.contains(Long.valueOf(((SwrveEventItem) it.next()).f2794id))) {
                it.remove();
            }
        }
    }

    public void saveNotificationAuthenticated(int i, long j) {
    }

    public void saveOfflineCampaign(String str, String str2, String str3) {
    }

    public void saveUser(SwrveUser swrveUser) {
    }

    public synchronized void setCacheEntry(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            SwrveLogger.m2754e("Cannot set null value in cache entry for userId:%s category:%s rawData:%s.", str, str2, str3);
        } else if (getCacheSize() >= 2000) {
            SwrveLogger.m2758w("The number of In Memory cache items has reached its limit. Cannot store anymore until a new session.", new Object[0]);
        } else {
            Map map = this.cachePerUserId.get(str);
            if (map == null) {
                map = new HashMap();
            }
            SwrveCacheItem swrveCacheItem = (SwrveCacheItem) map.get(str2);
            if (swrveCacheItem == null) {
                swrveCacheItem = new SwrveCacheItem(str, str2, str3);
            } else {
                swrveCacheItem.userId = str;
                swrveCacheItem.category = str2;
                swrveCacheItem.rawData = str3;
            }
            map.put(str2, swrveCacheItem);
            this.cachePerUserId.put(str, map);
        }
    }

    public synchronized void setSecureCacheEntryForUser(String str, String str2, String str3, String str4) {
        setCacheEntry(str, str2, str3);
        setCacheEntry(str, str2 + LocalStorage.SIGNATURE_SUFFIX, str4);
    }

    public void truncateNotificationsAuthenticated(int i) {
    }
}
