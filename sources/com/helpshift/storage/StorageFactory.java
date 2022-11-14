package com.helpshift.storage;

import com.helpshift.util.HelpshiftContext;

public class StorageFactory {
    public static StorageFactory storageFactoryInstance;
    public final KeyValueStorage keyValueStorage = new RetryKeyValueDbStorage(HelpshiftContext.getApplicationContext());

    public static synchronized StorageFactory getInstance() {
        StorageFactory storageFactory;
        synchronized (StorageFactory.class) {
            if (storageFactoryInstance == null) {
                storageFactoryInstance = new StorageFactory();
            }
            storageFactory = storageFactoryInstance;
        }
        return storageFactory;
    }
}
