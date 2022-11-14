package com.playrix.engine;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class SharedContentProvider extends ContentProvider {
    public static final long INCREMENT_VERSION = -1;
    public static final String KEY_COLUMN = "key";
    public static final String QUERY_PATH = "/shared_vars";
    public static final String STORAGE_FILE_NAME = "shared_vars.json";
    public static final String VALUE_COLUMN = "value";
    public static final String VERSION_COLUMN = "version";
    public static final int _deferredSyncDelay = 1000;
    public static WeakReference<SharedContentProvider> _instance;
    public static final Object _instanceLocker = new Object();
    public final Map<String, Value> _localStorage = new HashMap();
    public boolean _localStorageIsLoaded = false;
    public boolean _localStorageIsModified = false;
    public boolean _processingDeferredSaveLocalStorage = false;
    public boolean _processingRemoteRequest = false;
    public String[] _remoteAppNames = null;

    public static class KeyAndValue {
        public String key;
        public String value;
    }

    public static class Value {
        public String value;
        public long version = 0;
    }

    private void WaitRemoteRequest() {
        while (true) {
            synchronized (this._localStorage) {
                if (!this._processingRemoteRequest) {
                    return;
                }
            }
            Thread.yield();
        }
        while (true) {
        }
    }

    public static Uri createUri(String str) {
        return new Uri.Builder().scheme("content").authority(str).path(QUERY_PATH).build();
    }

    /* access modifiers changed from: private */
    public void deferredSaveStorage() {
        synchronized (this._localStorage) {
            if (!this._processingDeferredSaveLocalStorage) {
                this._processingDeferredSaveLocalStorage = true;
                new Thread(new Runnable() {
                    public void run() {
                        SharedContentProvider sharedContentProvider;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException unused) {
                        }
                        synchronized (SharedContentProvider.this._localStorage) {
                            try {
                                SharedContentProvider.this.saveStorage();
                                sharedContentProvider = SharedContentProvider.this;
                            } catch (Exception e) {
                                try {
                                    Logger.logError("Error deferred save shared_vars.json : " + e.toString());
                                    sharedContentProvider = SharedContentProvider.this;
                                } catch (Throwable th) {
                                    boolean unused2 = SharedContentProvider.this._processingDeferredSaveLocalStorage = false;
                                    throw th;
                                }
                            }
                            boolean unused3 = sharedContentProvider._processingDeferredSaveLocalStorage = false;
                        }
                    }
                }).start();
            }
        }
    }

    public static Map<String, Value> doRequestContent(ContentResolver contentResolver, String[] strArr) {
        String[] strArr2 = strArr;
        HashMap hashMap = new HashMap();
        String providerUrlPrefix = getProviderUrlPrefix();
        if (!(strArr2 == null || strArr2.length == 0 || contentResolver == null || providerUrlPrefix == null)) {
            for (String str : strArr2) {
                Cursor cursor = null;
                try {
                    cursor = contentResolver.query(createUri(providerUrlPrefix + str), (String[]) null, (String) null, (String[]) null, (String) null);
                } catch (Exception unused) {
                }
                if (cursor != null) {
                    try {
                        int columnIndex = cursor.getColumnIndex("key");
                        int columnIndex2 = cursor.getColumnIndex("value");
                        int columnIndex3 = cursor.getColumnIndex("version");
                        if (columnIndex >= 0 && columnIndex2 >= 0) {
                            if (columnIndex3 >= 0) {
                                if (cursor.moveToFirst()) {
                                    do {
                                        try {
                                            String string = cursor.getString(columnIndex);
                                            String string2 = cursor.getString(columnIndex2);
                                            long j = cursor.getLong(columnIndex3);
                                            if (j > 0) {
                                                putValueToStorage(string, string2, j, hashMap);
                                            }
                                        } catch (Exception e) {
                                            Logger.logError("Error request row : " + e.toString());
                                        }
                                    } while (cursor.moveToNext());
                                }
                            }
                        }
                    } catch (Exception e2) {
                        Logger.logError("Error request : " + e2.toString());
                    } catch (Throwable th) {
                        cursor.close();
                        throw th;
                    }
                    cursor.close();
                }
            }
        }
        return hashMap;
    }

    public static void doUpdateRequest(ContentResolver contentResolver, String[] strArr, String str, String str2, long j) {
        String providerUrlPrefix = getProviderUrlPrefix();
        if (strArr != null && strArr.length != 0 && contentResolver != null && providerUrlPrefix != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            contentValues.put("version", Long.valueOf(j));
            for (String str3 : strArr) {
                try {
                    contentResolver.update(createUri(providerUrlPrefix + str3), contentValues, (String) null, (String[]) null);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static KeyAndValue[] getAllValues() {
        SharedContentProvider instance = getInstance();
        if (instance == null) {
            return null;
        }
        return instance.getAllValuesImpl();
    }

    private KeyAndValue[] getAllValuesImpl() {
        KeyAndValue[] keyAndValueArr;
        WaitRemoteRequest();
        synchronized (this._localStorage) {
            loadStorage();
            Set<String> keySet = this._localStorage.keySet();
            int size = keySet.size();
            String[] strArr = (String[]) keySet.toArray(new String[size]);
            keyAndValueArr = new KeyAndValue[size];
            for (int i = 0; i < size; i++) {
                keyAndValueArr[i] = new KeyAndValue();
                keyAndValueArr[i].key = strArr[i];
                keyAndValueArr[i].value = this._localStorage.get(strArr[i]).value;
            }
        }
        return keyAndValueArr;
    }

    public static SharedContentProvider getInstance() {
        SharedContentProvider sharedContentProvider;
        synchronized (_instanceLocker) {
            sharedContentProvider = _instance != null ? (SharedContentProvider) _instance.get() : null;
        }
        return sharedContentProvider;
    }

    public static String getProviderUrlPrefix() {
        try {
            Object obj = Class.forName("com.playrix.add.BuildConfig").getField("SHARED_CONTENT_PROVIDER_PREFIX").get((Object) null);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private String getStorageFilePath() {
        return GeneratedOutlineSupport.outline19(new StringBuilder(), getContext().getApplicationInfo().dataDir, "/", STORAGE_FILE_NAME);
    }

    public static String getValue(String str) {
        SharedContentProvider instance = getInstance();
        if (instance == null) {
            return null;
        }
        return instance.getValueImpl(str);
    }

    private String getValueImpl(String str) {
        String str2;
        WaitRemoteRequest();
        synchronized (this._localStorage) {
            loadStorage();
            Value value = this._localStorage.get(str);
            str2 = value != null ? value.value : null;
        }
        return str2;
    }

    public static boolean initialize(String[] strArr) {
        SharedContentProvider instance;
        if (strArr == null || (instance = getInstance()) == null) {
            return false;
        }
        instance.initializeImpl(strArr);
        return true;
    }

    private void initializeImpl(final String[] strArr) {
        synchronized (this._localStorage) {
            this._remoteAppNames = strArr;
            if (!this._processingRemoteRequest) {
                this._processingRemoteRequest = true;
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Map access$300 = SharedContentProvider.doRequestContent(SharedContentProvider.this.getContext().getContentResolver(), strArr);
                            synchronized (SharedContentProvider.this._localStorage) {
                                for (Map.Entry entry : access$300.entrySet()) {
                                    if (SharedContentProvider.putValueToStorage((String) entry.getKey(), ((Value) entry.getValue()).value, ((Value) entry.getValue()).version, SharedContentProvider.this._localStorage) != null) {
                                        boolean unused = SharedContentProvider.this._localStorageIsModified = true;
                                        SharedContentProvider.this.deferredSaveStorage();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            try {
                                Logger.logError("Error remote shared vars request : " + e.toString());
                            } catch (Throwable th) {
                                boolean unused2 = SharedContentProvider.this._processingRemoteRequest = false;
                                throw th;
                            }
                        }
                        boolean unused3 = SharedContentProvider.this._processingRemoteRequest = false;
                    }
                }).start();
            }
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private void loadStorage() {
        synchronized (this._localStorage) {
            if (!this._localStorageIsLoaded) {
                this._localStorageIsLoaded = true;
                this._localStorage.clear();
                String readFileToString = readFileToString(getStorageFilePath(), Charset.forName("UTF-8"));
                if (!isNullOrEmpty(readFileToString)) {
                    try {
                        JSONObject jSONObject = new JSONObject(readFileToString);
                        for (int i = 0; i < jSONObject.names().length(); i++) {
                            String string = jSONObject.names().getString(i);
                            JSONObject jSONObject2 = jSONObject.getJSONObject(string);
                            if (jSONObject2 != null) {
                                putValueToStorage(string, jSONObject2.getString("value"), jSONObject2.getLong("version"), this._localStorage);
                            }
                        }
                    } catch (Exception e) {
                        Logger.logError("Error load shared_vars.json : " + e.toString());
                    }
                }
            }
        }
    }

    public static Value putValueToStorage(String str, String str2, long j, Map<String, Value> map) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        Value value = map.get(str);
        if (value != null) {
            if (str2.equals(value.value)) {
                if (j == -1 || j <= value.version) {
                    return null;
                }
            } else if (j != -1 && j <= value.version) {
                return null;
            }
        }
        Value value2 = new Value();
        value2.value = str2;
        if (j != -1) {
            value2.version = j;
        } else if (value != null) {
            value2.version = value.version + 1;
        } else {
            value2.version = 1;
        }
        map.put(str, value2);
        return value2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[SYNTHETIC, Splitter:B:13:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0030 A[SYNTHETIC, Splitter:B:21:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileToString(java.lang.String r3, java.nio.charset.Charset r4) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            long r1 = r1.length()     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            int r2 = (int) r1     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            byte[] r1 = new byte[r2]     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            r3.read(r1)     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            r2.<init>(r1, r4)     // Catch:{ Exception -> 0x002e, all -> 0x0023 }
            r3.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return r2
        L_0x0023:
            r4 = move-exception
            r0 = r3
            goto L_0x0027
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r0.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            throw r4
        L_0x002d:
            r3 = r0
        L_0x002e:
            if (r3 == 0) goto L_0x0033
            r3.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.SharedContentProvider.readFileToString(java.lang.String, java.nio.charset.Charset):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void saveStorage() {
        try {
            JSONObject jSONObject = new JSONObject();
            synchronized (this._localStorage) {
                if (this._localStorageIsModified) {
                    this._localStorageIsModified = false;
                    for (Map.Entry next : this._localStorage.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("value", ((Value) next.getValue()).value);
                        jSONObject2.put("version", ((Value) next.getValue()).version);
                        jSONObject.put((String) next.getKey(), jSONObject2);
                    }
                    writeStringToFile(getStorageFilePath(), jSONObject.toString(), Charset.forName("UTF-8"));
                }
            }
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("Error save shared_vars.json : "));
        }
    }

    public static void setValue(String str, String str2) {
        SharedContentProvider instance = getInstance();
        if (instance != null) {
            instance.setValueImpl(str, str2);
        }
    }

    private void setValueImpl(String str, String str2) {
        WaitRemoteRequest();
        synchronized (this._localStorage) {
            loadStorage();
            Value putValueToStorage = putValueToStorage(str, str2, -1, this._localStorage);
            if (putValueToStorage != null) {
                this._localStorageIsModified = true;
                deferredSaveStorage();
                updateRequest(str, putValueToStorage.value, putValueToStorage.version);
            }
        }
    }

    public static void sync() {
        SharedContentProvider instance = getInstance();
        if (instance != null) {
            instance.saveStorage();
        }
    }

    private void updateRequest(String str, String str2, long j) {
        synchronized (this._localStorage) {
            if (this._remoteAppNames != null) {
                if (this._remoteAppNames.length != 0) {
                    final String[] strArr = this._remoteAppNames;
                    final String str3 = str;
                    final String str4 = str2;
                    final long j2 = j;
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                SharedContentProvider.doUpdateRequest(SharedContentProvider.this.getContext().getContentResolver(), strArr, str3, str4, j2);
                            } catch (Exception e) {
                                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("Error update shared vars request : "));
                            }
                        }
                    }).start();
                }
            }
        }
    }

    public static void writeStringToFile(String str, String str2, Charset charset) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
        try {
            bufferedWriter.write(str2);
        } finally {
            bufferedWriter.close();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        synchronized (_instanceLocker) {
            _instance = new WeakReference<>(this);
        }
        loadStorage();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        if (uri == null || !uri.getPath().equals(QUERY_PATH) || strArr != null || str != null || strArr2 != null || str2 != null) {
            return null;
        }
        synchronized (this._localStorage) {
            matrixCursor = new MatrixCursor(new String[]{"key", "value", "version"}, this._localStorage.size());
            for (Map.Entry next : this._localStorage.entrySet()) {
                matrixCursor.addRow(new Object[]{next.getKey(), ((Value) next.getValue()).value, Long.valueOf(((Value) next.getValue()).version)});
            }
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (uri == null || !uri.getPath().equals(QUERY_PATH) || contentValues == null || str != null || strArr != null) {
            return 0;
        }
        synchronized (this._localStorage) {
            if (putValueToStorage(contentValues.getAsString("key"), contentValues.getAsString("value"), contentValues.getAsLong("version").longValue(), this._localStorage) != null) {
                this._localStorageIsModified = true;
                deferredSaveStorage();
            }
        }
        return 0;
    }
}
