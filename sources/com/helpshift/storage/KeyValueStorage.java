package com.helpshift.storage;

import java.io.Serializable;
import java.util.Map;

public interface KeyValueStorage {
    Object get(String str);

    void removeAllKeys();

    void removeKey(String str);

    boolean set(String str, Serializable serializable);

    boolean setKeyValues(Map<String, Serializable> map);
}
