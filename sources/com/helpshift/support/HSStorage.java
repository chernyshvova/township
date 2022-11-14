package com.helpshift.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.helpshift.constants.CommonSharedPrefrences;
import com.helpshift.support.model.FaqSearchIndex;
import com.helpshift.support.search.storage.SearchTokenDaoImpl;
import com.helpshift.support.storage.FaqsDataSource;
import com.helpshift.util.HSLogger;
import com.helpshift.util.IOUtils;
import com.swrve.sdk.SwrveImp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class HSStorage {
    public static final String TAG = "HelpShiftDebug";
    public static FaqSearchIndex cachedSearchIndex;
    public Context context;
    public final String dbFile = "fullIndex.db";
    public Map<String, String> migrationBackupData = new HashMap();
    public SharedPreferences storage;

    public HSStorage(Context context2) {
        this.context = context2;
        this.storage = context2.getSharedPreferences(CommonSharedPrefrences.JSON_PREFS, 0);
    }

    private String storageGet(String str) {
        return this.storage.getString(str, "");
    }

    private JSONArray storageGetArr(String str) throws JSONException {
        return new JSONArray(this.storage.getString(str, SwrveImp.EMPTY_JSON_ARRAY));
    }

    private Integer storageGetInt(String str) {
        return storageGetInt(str, 0);
    }

    private Long storageGetLong(String str) {
        return Long.valueOf(this.storage.getLong(str, 0));
    }

    private JSONObject storageGetObj(String str) throws JSONException {
        return new JSONObject(this.storage.getString(str, JsonUtils.EMPTY_JSON));
    }

    private void storageSet(String str, JSONArray jSONArray) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, jSONArray.toString());
        edit.apply();
    }

    public void backupForMigration() {
        this.migrationBackupData.put(CommonSharedPrefrences.INSTALL_CREDS_HASH, getString(CommonSharedPrefrences.INSTALL_CREDS_HASH));
    }

    public void clearDatabase() {
        FaqsDataSource.getInstance().clearDB();
        SharedPreferences.Editor edit = this.storage.edit();
        edit.clear();
        edit.apply();
    }

    public void clearLegacySearchIndexFile() {
        this.context.deleteFile("tfidf.db");
    }

    public boolean contains(String str) {
        return this.storage.contains(str);
    }

    public void deleteIndex() {
        cachedSearchIndex = null;
        SearchTokenDaoImpl.getInstance().clear();
        this.context.deleteFile("fullIndex.db");
        unsetDBFlag();
    }

    public String getApplicationVersion() {
        return storageGet("applicationVersion");
    }

    public Boolean getDBFlag() {
        return storageGetBoolean("dbFlag");
    }

    public JSONObject getFailedApiCalls() throws JSONException {
        return storageGetObj("failedApiCalls");
    }

    public long getLastErrorReportedTime() {
        return storageGetLong("lastErrorReportedTime").longValue();
    }

    public int getLaunchReviewCounter() {
        return storageGetInt("launchReviewCounter").intValue();
    }

    public String getLibraryVersion() {
        return storageGet(CommonSharedPrefrences.LIBRARY_VERSION);
    }

    public int getReviewCounter() {
        return storageGetInt("reviewCounter").intValue();
    }

    public JSONArray getStoredFiles() throws JSONException {
        return storageGetArr("cachedImages");
    }

    public String getString(String str) {
        return this.storage.getString(str, "");
    }

    public boolean isCacheSearchIndexNull() {
        return cachedSearchIndex == null;
    }

    public void loadIndex() throws IOException, ClassCastException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        Throwable th;
        if (cachedSearchIndex == null) {
            try {
                fileInputStream = this.context.openFileInput("fullIndex.db");
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        cachedSearchIndex = (FaqSearchIndex) objectInputStream.readObject();
                        IOUtils.closeQuitely(fileInputStream);
                        IOUtils.closeQuitely(objectInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuitely(fileInputStream);
                        IOUtils.closeQuitely(objectInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    objectInputStream = null;
                    th = th4;
                    IOUtils.closeQuitely(fileInputStream);
                    IOUtils.closeQuitely(objectInputStream);
                    throw th;
                }
            } catch (Throwable th5) {
                objectInputStream = null;
                th = th5;
                fileInputStream = null;
                IOUtils.closeQuitely(fileInputStream);
                IOUtils.closeQuitely(objectInputStream);
                throw th;
            }
        }
    }

    public FaqSearchIndex readIndex() {
        return cachedSearchIndex;
    }

    public void restoreMigrationData() {
        for (Map.Entry next : this.migrationBackupData.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                storageSet((String) next.getKey(), (String) next.getValue());
            }
        }
        this.migrationBackupData.clear();
    }

    public void setApplicationVersion(String str) {
        storageSet("applicationVersion", str);
    }

    public void setDBFlag() {
        storageSet("dbFlag", Boolean.TRUE);
    }

    public void setLastErrorReportedTime(long j) {
        storageSet("lastErrorReportedTime", Long.valueOf(j));
    }

    public void setLaunchReviewCounter(int i) {
        storageSet("launchReviewCounter", Integer.valueOf(i));
    }

    public void setLibraryVersion(String str) {
        storageSet(CommonSharedPrefrences.LIBRARY_VERSION, str);
    }

    public void setReviewCounter(int i) {
        storageSet("reviewCounter", Integer.valueOf(i));
    }

    public void setStoredFiles(JSONArray jSONArray) {
        storageSet("cachedImages", jSONArray);
    }

    public Boolean storageGetBoolean(String str) {
        return Boolean.valueOf(this.storage.getBoolean(str, false));
    }

    public Float storageGetFloat(String str) {
        return Float.valueOf(this.storage.getFloat(str, 0.0f));
    }

    public void storeFailedApiCall(String str, JSONObject jSONObject) throws JSONException {
        JSONObject failedApiCalls = getFailedApiCalls();
        failedApiCalls.put(str, jSONObject);
        storageSet("failedApiCalls", failedApiCalls);
    }

    public void storeIndex(FaqSearchIndex faqSearchIndex) {
        ObjectOutputStream objectOutputStream;
        cachedSearchIndex = faqSearchIndex;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream openFileOutput = this.context.openFileOutput("fullIndex.db", 0);
            try {
                objectOutputStream = new ObjectOutputStream(openFileOutput);
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
                fileOutputStream = openFileOutput;
                try {
                    HSLogger.m3238d("HelpShiftDebug", "store index", (Throwable) e);
                    IOUtils.closeQuitely(fileOutputStream);
                    IOUtils.closeQuitely(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuitely(fileOutputStream);
                    IOUtils.closeQuitely(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
                fileOutputStream = openFileOutput;
                IOUtils.closeQuitely(fileOutputStream);
                IOUtils.closeQuitely(objectOutputStream);
                throw th;
            }
            try {
                objectOutputStream.writeObject(faqSearchIndex);
                objectOutputStream.flush();
                setDBFlag();
                IOUtils.closeQuitely(openFileOutput);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = openFileOutput;
                HSLogger.m3238d("HelpShiftDebug", "store index", (Throwable) e);
                IOUtils.closeQuitely(fileOutputStream);
                IOUtils.closeQuitely(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = openFileOutput;
                IOUtils.closeQuitely(fileOutputStream);
                IOUtils.closeQuitely(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream = null;
            HSLogger.m3238d("HelpShiftDebug", "store index", (Throwable) e);
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(objectOutputStream);
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
            IOUtils.closeQuitely(fileOutputStream);
            IOUtils.closeQuitely(objectOutputStream);
            throw th;
        }
        IOUtils.closeQuitely(objectOutputStream);
    }

    public void unsetDBFlag() {
        storageSet("dbFlag", Boolean.FALSE);
    }

    private Integer storageGetInt(String str, int i) {
        return Integer.valueOf(this.storage.getInt(str, i));
    }

    private void storageSet(String str, JSONObject jSONObject) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, jSONObject.toString());
        edit.apply();
    }

    private void storageSet(String str, String str2) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private void storageSet(String str, Integer num) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putInt(str, num.intValue());
        edit.apply();
    }

    private void storageSet(String str, Boolean bool) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.apply();
    }

    private void storageSet(String str, Long l) {
        SharedPreferences.Editor edit = this.storage.edit();
        edit.putLong(str, l.longValue());
        edit.apply();
    }
}
