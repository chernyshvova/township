package com.helpshift.storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CachedKeyValueStorage implements KeyValueStorage {
    public HashMap<String, Object> cacheMap = new HashMap<>();
    public Set<String> cacheWhitelistKeys;
    public KeyValueStorage storage;

    public CachedKeyValueStorage(KeyValueStorage keyValueStorage, Set<String> set) {
        this.storage = keyValueStorage;
        this.cacheWhitelistKeys = new HashSet(set);
    }

    private void removeFromCache(Set<String> set) {
        if (set != null) {
            for (String remove : set) {
                this.cacheMap.remove(remove);
            }
        }
    }

    private void setInCache(String str, Object obj) {
        if (this.cacheWhitelistKeys.contains(str)) {
            this.cacheMap.put(str, obj);
        }
    }

    public synchronized Object get(String str) {
        if (this.cacheMap.containsKey(str)) {
            return this.cacheMap.get(str);
        }
        Object obj = this.storage.get(str);
        setInCache(str, obj);
        return obj;
    }

    public synchronized void removeAllKeys() {
        this.storage.removeAllKeys();
        this.cacheMap.clear();
    }

    public synchronized void removeKey(String str) {
        this.storage.removeKey(str);
        this.cacheMap.remove(str);
    }

    public synchronized boolean set(String str, Serializable serializable) {
        boolean z;
        this.cacheMap.remove(str);
        z = this.storage.set(str, serializable);
        if (z) {
            setInCache(str, serializable);
        }
        return z;
    }

    public boolean setKeyValues(Map<String, Serializable> map) {
        removeFromCache(map.keySet());
        boolean keyValues = this.storage.setKeyValues(map);
        if (keyValues) {
            setInCache(map);
        }
        return keyValues;
    }

    private void setInCache(Map<String, Serializable> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (this.cacheWhitelistKeys.contains(next.getKey())) {
                    this.cacheMap.put(next.getKey(), next.getValue());
                }
            }
        }
    }
}
