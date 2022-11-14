package com.helpshift.model;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.dao.BackupDAO;
import com.helpshift.common.platform.Platform;
import com.helpshift.storage.KeyValueStorage;
import java.util.HashMap;
import java.util.HashSet;

public class SdkInfoModel {
    public static final String CHANGE_SET_ID_PREFIX = "hs__change_set_id:";
    public static final String KEY_DEVICE_ID = "hs-device-id";
    public static final String KEY_SYNCED_USER_ID = "hs-synced-user-id";
    public static final String SDK_LANGUAGE = "sdk-language";
    public static final String SDK_THEME = "sdk-theme";
    public BackupDAO backupStorage;
    public HashMap<String, String> etags;
    public KeyValueStorage storage;

    public SdkInfoModel(KeyValueStorage keyValueStorage, Platform platform) {
        this.storage = keyValueStorage;
        this.backupStorage = platform.getBackupDAO();
        HashMap<String, String> hashMap = (HashMap) this.storage.get("etags");
        this.etags = hashMap;
        if (hashMap == null) {
            this.etags = new HashMap<>();
        }
        updateBackupStorageWithInternalStorage();
    }

    private void updateBackupStorageWithInternalStorage() {
        String str = (String) this.storage.get(KEY_DEVICE_ID);
        if (str != null) {
            this.backupStorage.storeValue(KEY_DEVICE_ID, str);
        }
        String str2 = (String) this.storage.get(KEY_SYNCED_USER_ID);
        if (str2 != null) {
            this.backupStorage.storeValue(KEY_SYNCED_USER_ID, str2);
        }
    }

    public void addDeviceId(String str) throws IllegalArgumentException {
        if (str != null) {
            str = str.trim();
        }
        if (!TextUtils.isEmpty(str)) {
            this.storage.set(KEY_DEVICE_ID, str);
            this.backupStorage.storeValue(KEY_DEVICE_ID, str);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void addEtag(String str, String str2) {
        this.etags.put(str2, str);
        this.storage.set("etags", this.etags);
    }

    public void clearEtag(String str) {
        if (this.etags.containsKey(str)) {
            this.etags.remove(str);
            this.storage.set("etags", this.etags);
        }
    }

    public String getChangeSetId(String str) {
        return (String) this.storage.get(GeneratedOutlineSupport.outline16(CHANGE_SET_ID_PREFIX, str));
    }

    public String getCurrentLoggedInId() {
        return (String) this.storage.get("current-logged-in-id");
    }

    public String getDeviceId() {
        String str = (String) this.storage.get(KEY_DEVICE_ID);
        return str == null ? (String) this.backupStorage.getValue(KEY_DEVICE_ID) : str;
    }

    public Boolean getDevicePropertiesSyncImmediately() {
        Boolean bool = (Boolean) this.storage.get("hs-device-properties-sync-immediately");
        return bool == null ? Boolean.FALSE : bool;
    }

    public String getEtag(String str) {
        return this.etags.get(str);
    }

    public Boolean getFirstLaunch() {
        return (Boolean) this.storage.get("hs-first-launch");
    }

    public Boolean getOneCampaignFetchSuccessful() {
        return (Boolean) this.storage.get("hs-one-campaign-fetch-successful");
    }

    public String getSdkLanguage() {
        return (String) this.storage.get(SDK_LANGUAGE);
    }

    public Float getServerTimeDelta() {
        return (Float) this.storage.get("server-time-delta");
    }

    public Integer getTheme() {
        return (Integer) this.storage.get(SDK_THEME);
    }

    public String getUserIdSyncedWithBackend() {
        String str = (String) this.storage.get(KEY_SYNCED_USER_ID);
        return str == null ? (String) this.backupStorage.getValue(KEY_SYNCED_USER_ID) : str;
    }

    public boolean isDuplicateNotification(String str, String str2) {
        HashMap hashMap = (HashMap) this.storage.get("hs__received_push_campaigns");
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        HashSet hashSet = (HashSet) hashMap.get(str2);
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        if (hashSet.contains(str)) {
            return true;
        }
        hashSet.add(str);
        hashMap.put(str2, hashSet);
        this.storage.set("hs__received_push_campaigns", hashMap);
        return false;
    }

    public void setChangeSetId(String str, String str2) {
        this.storage.set(GeneratedOutlineSupport.outline16(CHANGE_SET_ID_PREFIX, str2), str);
    }

    public void setCurrentLoggedInId(String str) throws IllegalArgumentException {
        if (str != null) {
            str = str.trim();
        }
        if (!TextUtils.isEmpty(str)) {
            this.storage.set("current-logged-in-id", str);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setDevicePropertiesSyncImmediately(Boolean bool) {
        this.storage.set("hs-device-properties-sync-immediately", bool);
    }

    public void setFirstLaunch(Boolean bool) {
        this.storage.set("hs-first-launch", bool);
    }

    public void setOneCampaignFetchSuccessful(Boolean bool) {
        this.storage.set("hs-one-campaign-fetch-successful", bool);
    }

    public void setSdkLanguage(String str) {
        this.storage.set(SDK_LANGUAGE, str);
    }

    public void setServerTimeDelta(Float f) {
        this.storage.set("server-time-delta", f);
    }

    public void setTheme(int i) {
        this.storage.set(SDK_THEME, Integer.valueOf(i));
    }

    public void setUserIdSyncedWithBackend(String str) {
        this.storage.set(KEY_SYNCED_USER_ID, str);
        this.backupStorage.storeValue(KEY_SYNCED_USER_ID, str);
    }
}
