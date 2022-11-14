package com.swrve.sdk.localstorage;

import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveUser;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SwrveMultiLayerLocalStorage {
    public static final Object EVENT_LOCK = new Object();
    public int NOTIFICATIONS_AUTHENICATED_MAX_ROWS = 100;
    public Object cacheLock = new Object();
    public LocalStorage primaryStorage;
    public LocalStorage secondaryStorage;

    public SwrveMultiLayerLocalStorage(LocalStorage localStorage) {
        this.primaryStorage = localStorage;
    }

    private synchronized void flushCache(Map<String, Map<String, SwrveCacheItem>> map, SQLiteLocalStorage sQLiteLocalStorage) {
        for (Map.Entry<String, Map<String, SwrveCacheItem>> value : map.entrySet()) {
            sQLiteLocalStorage.saveMultipleCacheItems((Map) value.getValue());
        }
        map.clear();
    }

    private synchronized void flushEvents(Map<String, List<SwrveEventItem>> map, SQLiteLocalStorage sQLiteLocalStorage) {
        for (Map.Entry<String, List<SwrveEventItem>> value : map.entrySet()) {
            sQLiteLocalStorage.saveMultipleEventItems((List) value.getValue());
        }
        map.clear();
    }

    public long addEvent(String str, String str2) throws Exception {
        long addEvent;
        synchronized (EVENT_LOCK) {
            addEvent = this.primaryStorage.addEvent(str, str2);
        }
        return addEvent;
    }

    public void deleteNotificationsAuthenticated() {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            localStorage.deleteNotificationsAuthenticated();
        }
    }

    public void deleteUser(String str) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            localStorage.deleteUser(str);
        }
    }

    public void flush() {
        LocalStorage localStorage = this.primaryStorage;
        LocalStorage localStorage2 = this.secondaryStorage;
        if (localStorage != localStorage2 && (localStorage instanceof InMemoryLocalStorage) && (localStorage2 instanceof SQLiteLocalStorage)) {
            InMemoryLocalStorage inMemoryLocalStorage = (InMemoryLocalStorage) localStorage;
            SQLiteLocalStorage sQLiteLocalStorage = (SQLiteLocalStorage) localStorage2;
            synchronized (EVENT_LOCK) {
                flushEvents(inMemoryLocalStorage.eventsPerUserId, sQLiteLocalStorage);
            }
            synchronized (this.cacheLock) {
                flushCache(inMemoryLocalStorage.cachePerUserId, sQLiteLocalStorage);
            }
        }
    }

    public String getCacheEntry(String str, String str2) {
        String str3;
        SwrveCacheItem cacheItem;
        synchronized (this.cacheLock) {
            str3 = null;
            SwrveCacheItem cacheItem2 = this.primaryStorage.getCacheItem(str, str2);
            if (cacheItem2 != null) {
                str3 = cacheItem2.rawData;
            }
            if (!(str3 != null || this.secondaryStorage == null || (cacheItem = this.secondaryStorage.getCacheItem(str, str2)) == null)) {
                str3 = cacheItem.rawData;
                this.primaryStorage.setCacheEntry(str, str2, str3);
            }
        }
        return str3;
    }

    public LinkedHashMap<LocalStorage, LinkedHashMap<Long, String>> getCombinedFirstNEvents(Integer num, String str) {
        LinkedHashMap<LocalStorage, LinkedHashMap<Long, String>> linkedHashMap;
        synchronized (EVENT_LOCK) {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            if (this.secondaryStorage != null) {
                LinkedHashMap<Long, String> firstNEvents = this.secondaryStorage.getFirstNEvents(num, str);
                int size = firstNEvents.size();
                if (size > 0) {
                    linkedHashMap.put(this.secondaryStorage, firstNEvents);
                }
                i = size;
            }
            if (num.intValue() - i > 0) {
                LinkedHashMap<Long, String> firstNEvents2 = this.primaryStorage.getFirstNEvents(Integer.valueOf(num.intValue() - i), str);
                if (firstNEvents2.size() > 0) {
                    linkedHashMap.put(this.primaryStorage, firstNEvents2);
                }
            }
        }
        return linkedHashMap;
    }

    public List<Integer> getNotificationsAuthenticated() {
        ArrayList arrayList = new ArrayList();
        LocalStorage localStorage = this.secondaryStorage;
        return localStorage != null ? localStorage.getNotificationsAuthenticated() : arrayList;
    }

    public String getOfflineCampaign(String str, String str2) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            return localStorage.getOfflineCampaign(str, str2);
        }
        return null;
    }

    public LocalStorage getPrimaryStorage() {
        return this.primaryStorage;
    }

    public LocalStorage getSecondaryStorage() {
        return this.secondaryStorage;
    }

    public String getSecureCacheEntryForUser(String str, String str2, String str3) throws SecurityException {
        String str4 = "";
        String str5 = "";
        synchronized (this.cacheLock) {
            SwrveCacheItem cacheItem = this.primaryStorage.getCacheItem(str, str2);
            LocalStorage localStorage = this.primaryStorage;
            SwrveCacheItem cacheItem2 = localStorage.getCacheItem(str, str2 + LocalStorage.SIGNATURE_SUFFIX);
            if (!(cacheItem == null || cacheItem2 == null)) {
                str4 = cacheItem.rawData;
                str5 = cacheItem2.rawData;
            }
            if (SwrveHelper.isNullOrEmpty(str4) && this.secondaryStorage != null) {
                SwrveCacheItem cacheItem3 = this.secondaryStorage.getCacheItem(str, str2);
                LocalStorage localStorage2 = this.secondaryStorage;
                SwrveCacheItem cacheItem4 = localStorage2.getCacheItem(str, str2 + LocalStorage.SIGNATURE_SUFFIX);
                if (!(cacheItem3 == null || cacheItem4 == null)) {
                    str4 = cacheItem3.rawData;
                    str5 = cacheItem4.rawData;
                }
            }
        }
        if (SwrveHelper.isNullOrEmpty(str4)) {
            return null;
        }
        try {
            String createHMACWithMD5 = SwrveHelper.createHMACWithMD5(str4, str3);
            if (!SwrveHelper.isNullOrEmpty(createHMACWithMD5) && !SwrveHelper.isNullOrEmpty(str5) && str5.equals(createHMACWithMD5)) {
                return str4;
            }
            throw new SecurityException("Signature validation failed");
        } catch (NoSuchAlgorithmException unused) {
            SwrveLogger.m2755i("Computing signature failed because of invalid algorithm", new Object[0]);
            return null;
        } catch (InvalidKeyException unused2) {
            SwrveLogger.m2755i("Computing signature failed because of an invalid key", new Object[0]);
            return null;
        }
    }

    public SwrveUser getUserByExternalUserId(String str) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            return localStorage.getUserByExternalUserId(str);
        }
        return null;
    }

    public SwrveUser getUserBySwrveUserId(String str) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            return localStorage.getUserBySwrveUserId(str);
        }
        return null;
    }

    public boolean hasQueuedEvents(String str) {
        return !getCombinedFirstNEvents(1, str).isEmpty();
    }

    public void saveNotificationAuthenticated(int i) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            localStorage.saveNotificationAuthenticated(i, System.currentTimeMillis());
            this.secondaryStorage.truncateNotificationsAuthenticated(this.NOTIFICATIONS_AUTHENICATED_MAX_ROWS);
        }
    }

    public void saveOfflineCampaign(String str, String str2, String str3) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            localStorage.saveOfflineCampaign(str, str2, str3);
        }
    }

    public void saveUser(SwrveUser swrveUser) {
        LocalStorage localStorage = this.secondaryStorage;
        if (localStorage != null) {
            localStorage.saveUser(swrveUser);
        }
    }

    public void setAndFlushSecureSharedEntryForUser(String str, String str2, String str3, String str4) {
        synchronized (this.cacheLock) {
            try {
                String createHMACWithMD5 = SwrveHelper.createHMACWithMD5(str3, str4);
                this.primaryStorage.setSecureCacheEntryForUser(str, str2, str3, createHMACWithMD5);
                if (this.secondaryStorage != null) {
                    this.secondaryStorage.setSecureCacheEntryForUser(str, str2, str3, createHMACWithMD5);
                }
            } catch (NoSuchAlgorithmException unused) {
                SwrveLogger.m2755i("Computing signature failed because of invalid algorithm", new Object[0]);
                this.primaryStorage.setCacheEntry(str, str2, str3);
                if (this.secondaryStorage != null) {
                    this.secondaryStorage.setCacheEntry(str, str2, str3);
                }
            } catch (InvalidKeyException unused2) {
                SwrveLogger.m2755i("Computing signature failed because of an invalid key", new Object[0]);
            }
        }
    }

    public void setCacheEntry(String str, String str2, String str3) {
        synchronized (this.cacheLock) {
            this.primaryStorage.setCacheEntry(str, str2, str3);
            if (this.secondaryStorage != null) {
                this.secondaryStorage.setCacheEntry(str, str2, str3);
            }
        }
    }

    public void setSecondaryStorage(LocalStorage localStorage) {
        this.secondaryStorage = localStorage;
    }
}
