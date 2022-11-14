package com.helpshift.storage;

import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.util.HSLogger;
import java.io.Serializable;
import java.util.Map;

public abstract class BaseRetryKeyValueStorage implements KeyValueStorage {
    public static final int MAX_RETRY_COUNT = 1;
    public static final String TAG = "Helpshift_RetryKeyValue";
    public KeyValueStorage keyValueStorage;

    public synchronized Object get(String str) {
        int i = 0;
        do {
            try {
            } catch (Exception e) {
                if (i == 0) {
                    HSLogger.m3242e(TAG, "Exception getting value for : " + str + ", retry count : " + i, e);
                } else {
                    HSLogger.m3245f(TAG, "Exception getting value for : " + str + ", retry count : " + i, (Throwable) e, new ILogExtrasModel[0]);
                }
                reInitiateDbInstance();
                i++;
                if (i > 1) {
                    return null;
                }
            }
        } while (i > 1);
        return null;
        return this.keyValueStorage.get(str);
    }

    public abstract void reInitiateDbInstance();

    public synchronized void removeAllKeys() {
        int i = 0;
        do {
            try {
                this.keyValueStorage.removeAllKeys();
            } catch (Exception e) {
                if (i == 0) {
                    HSLogger.m3242e(TAG, "Exception removing all keys, retry count : " + i, e);
                } else {
                    HSLogger.m3245f(TAG, "Exception removing all keys, retry count : " + i, (Throwable) e, new ILogExtrasModel[0]);
                }
                reInitiateDbInstance();
                i++;
                if (i > 1) {
                }
            }
        } while (i > 1);
    }

    public synchronized void removeKey(String str) {
        int i = 0;
        do {
            try {
                this.keyValueStorage.removeKey(str);
            } catch (Exception e) {
                if (i == 0) {
                    HSLogger.m3242e(TAG, "Exception removing key : " + str + ", retry count : " + i, e);
                } else {
                    HSLogger.m3245f(TAG, "Exception removing key : " + str + ", retry count : " + i, (Throwable) e, new ILogExtrasModel[0]);
                }
                reInitiateDbInstance();
                i++;
                if (i > 1) {
                }
            }
        } while (i > 1);
    }

    public synchronized boolean set(String str, Serializable serializable) {
        int i = 0;
        do {
            try {
            } catch (Exception e) {
                if (i == 0) {
                    HSLogger.m3242e(TAG, "Exception in setting value for key : " + str + ", retry count : " + i, e);
                } else {
                    HSLogger.m3245f(TAG, "Exception in setting value for key : " + str + ", retry count : " + i, (Throwable) e, new ILogExtrasModel[0]);
                }
                reInitiateDbInstance();
                i++;
                if (i > 1) {
                    return false;
                }
            }
        } while (i > 1);
        return false;
        return this.keyValueStorage.set(str, serializable);
    }

    public synchronized boolean setKeyValues(Map<String, Serializable> map) {
        int i = 0;
        do {
            try {
            } catch (Exception e) {
                if (i == 0) {
                    HSLogger.m3242e(TAG, "Exception in bulk insert, retry count : " + i, e);
                } else {
                    HSLogger.m3245f(TAG, "Exception in bulk insert, retry count : " + i, (Throwable) e, new ILogExtrasModel[0]);
                }
                reInitiateDbInstance();
                i++;
                if (i > 1) {
                    return false;
                }
            }
        } while (i > 1);
        return false;
        return this.keyValueStorage.setKeyValues(map);
    }
}
