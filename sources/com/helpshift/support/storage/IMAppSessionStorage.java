package com.helpshift.support.storage;

import com.helpshift.storage.KeyValueStorage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IMAppSessionStorage implements KeyValueStorage {
    public Lock readLock;
    public Map<String, Serializable> sessionStorage = new HashMap();
    public Lock writeLock;

    public static class LazyHolder {
        public static final IMAppSessionStorage INSTANCE = new IMAppSessionStorage();
    }

    public IMAppSessionStorage() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
    }

    public static IMAppSessionStorage getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void removeAllKeys() {
        this.writeLock.lock();
        this.sessionStorage.clear();
        this.writeLock.unlock();
    }

    public void removeKey(String str) {
        if (str != null) {
            this.writeLock.lock();
            this.sessionStorage.remove(str);
            this.writeLock.unlock();
        }
    }

    public boolean set(String str, Serializable serializable) {
        if (str == null) {
            return false;
        }
        this.writeLock.lock();
        this.sessionStorage.put(str, serializable);
        this.writeLock.unlock();
        return true;
    }

    public boolean setKeyValues(Map<String, Serializable> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        this.writeLock.lock();
        this.sessionStorage.putAll(map);
        this.writeLock.unlock();
        return true;
    }

    public Serializable get(String str) {
        if (str == null) {
            return null;
        }
        this.readLock.lock();
        Serializable serializable = this.sessionStorage.get(str);
        this.readLock.unlock();
        return serializable;
    }
}
