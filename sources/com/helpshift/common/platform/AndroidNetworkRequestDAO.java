package com.helpshift.common.platform;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.util.HSLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AndroidNetworkRequestDAO implements NetworkRequestDAO {
    public static final String KEY_IDEMPOTENT_REQUEST_ID_PREFIX = "idempotent_";
    public static final String KEY_ROUTE_ETAG_MAP = "route_etag_map";
    public static final String KEY_SERVER_TIME_DELTA = "server_time_delta";
    public KVStore kvStore;
    public Set<String> successfulRequestIds = new HashSet();

    public AndroidNetworkRequestDAO(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    public void clearSuccessfulRequestIds() {
        this.successfulRequestIds.clear();
    }

    public void deletePendingRequestId(String str, String str2) {
        String outline16 = GeneratedOutlineSupport.outline16(KEY_IDEMPOTENT_REQUEST_ID_PREFIX, str);
        Object serializable = this.kvStore.getSerializable(outline16);
        if (serializable instanceof HashMap) {
            HashMap hashMap = (HashMap) serializable;
            hashMap.remove(str2);
            this.kvStore.setSerializable(outline16, hashMap);
        }
    }

    public Set<String> getAllSuccessfulRequestIds() {
        return this.successfulRequestIds;
    }

    public String getETag(String str) {
        Object serializable = this.kvStore.getSerializable(KEY_ROUTE_ETAG_MAP);
        if (serializable == null) {
            return null;
        }
        return (String) ((HashMap) serializable).get(str);
    }

    public String getPendingRequestId(String str, String str2) {
        KVStore kVStore = this.kvStore;
        Object serializable = kVStore.getSerializable(KEY_IDEMPOTENT_REQUEST_ID_PREFIX + str);
        if (serializable == null) {
            return null;
        }
        return (String) ((HashMap) serializable).get(str2);
    }

    public Map<String, String> getPendingRequestIdMapForRoute(String str) {
        KVStore kVStore = this.kvStore;
        Object serializable = kVStore.getSerializable(KEY_IDEMPOTENT_REQUEST_ID_PREFIX + str);
        if (serializable == null) {
            return null;
        }
        return (HashMap) serializable;
    }

    public float getServerTimeDelta() {
        return this.kvStore.getFloat(KEY_SERVER_TIME_DELTA, Float.valueOf(0.0f)).floatValue();
    }

    public void removeETag(String str) {
        Object serializable;
        if (str != null && (serializable = this.kvStore.getSerializable(KEY_ROUTE_ETAG_MAP)) != null) {
            HashMap hashMap = (HashMap) serializable;
            if (hashMap.containsKey(str)) {
                hashMap.remove(str);
                this.kvStore.setSerializable(KEY_ROUTE_ETAG_MAP, hashMap);
            }
        }
    }

    public void storeETag(String str, String str2) {
        HashMap hashMap;
        Object serializable = this.kvStore.getSerializable(KEY_ROUTE_ETAG_MAP);
        if (serializable == null) {
            hashMap = new HashMap();
        } else {
            hashMap = (HashMap) serializable;
        }
        hashMap.put(str, str2);
        this.kvStore.setSerializable(KEY_ROUTE_ETAG_MAP, hashMap);
    }

    public void storePendingRequestId(String str, String str2, String str3) {
        HashMap hashMap;
        String outline16 = GeneratedOutlineSupport.outline16(KEY_IDEMPOTENT_REQUEST_ID_PREFIX, str);
        Object serializable = this.kvStore.getSerializable(outline16);
        if (serializable == null) {
            hashMap = new HashMap();
        } else {
            hashMap = (HashMap) serializable;
        }
        hashMap.put(str2, str3);
        this.kvStore.setSerializable(outline16, hashMap);
    }

    public void storeServerTimeDelta(float f) {
        this.kvStore.setFloat(KEY_SERVER_TIME_DELTA, Float.valueOf(f));
        HSLogger.updateTimeStampDelta(f);
    }

    public void storeSuccessfulRequestId(String str) {
        this.successfulRequestIds.add(str);
    }
}
