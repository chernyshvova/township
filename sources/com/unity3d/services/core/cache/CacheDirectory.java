package com.unity3d.services.core.cache;

import android.content.Context;
import android.os.Environment;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CacheDirectory {
    public static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    public String _cacheDirName;
    public File _cacheDirectory = null;
    public boolean _initialized = false;
    public CacheDirectoryType _type = null;

    public CacheDirectory(String str) {
        this._cacheDirName = str;
    }

    private void createNoMediaFile(File file) {
        try {
            if (new File(file, ".nomedia").createNewFile()) {
                DeviceLog.debug("Successfully created .nomedia file");
            } else {
                DeviceLog.debug("Using existing .nomedia file");
            }
        } catch (Exception e) {
            DeviceLog.exception("Failed to create .nomedia file", e);
        }
    }

    public File createCacheDirectory(File file, String str) {
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        if (file2.isDirectory()) {
            return file2;
        }
        return null;
    }

    public File getCacheDirectory(Context context) {
        File file;
        if (this._initialized) {
            return this._cacheDirectory;
        }
        this._initialized = true;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                file = createCacheDirectory(context.getExternalCacheDir(), this._cacheDirName);
            } catch (Exception e) {
                DeviceLog.exception("Creating external cache directory failed", e);
                file = null;
            }
            if (testCacheDirectory(file)) {
                createNoMediaFile(file);
                this._cacheDirectory = file;
                this._type = CacheDirectoryType.EXTERNAL;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads is using external cache directory: ");
                outline24.append(file.getAbsolutePath());
                DeviceLog.debug(outline24.toString());
                return this._cacheDirectory;
            }
        } else {
            DeviceLog.debug("External media not mounted");
        }
        File filesDir = context.getFilesDir();
        if (testCacheDirectory(filesDir)) {
            this._cacheDirectory = filesDir;
            this._type = CacheDirectoryType.INTERNAL;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Unity Ads is using internal cache directory: ");
            outline242.append(filesDir.getAbsolutePath());
            DeviceLog.debug(outline242.toString());
            return this._cacheDirectory;
        }
        DeviceLog.error("Unity Ads failed to initialize cache directory");
        return null;
    }

    public CacheDirectoryType getType() {
        return this._type;
    }

    public boolean testCacheDirectory(File file) {
        if (file != null && file.isDirectory()) {
            try {
                byte[] bytes = "test".getBytes("UTF-8");
                int length = bytes.length;
                byte[] bArr = new byte[length];
                File file2 = new File(file, TEST_FILE_NAME);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                FileInputStream fileInputStream = new FileInputStream(file2);
                int read = fileInputStream.read(bArr, 0, length);
                fileInputStream.close();
                if (!file2.delete()) {
                    DeviceLog.debug("Failed to delete testfile " + file2.getAbsoluteFile());
                    return false;
                } else if (read != length) {
                    DeviceLog.debug("Read buffer size mismatch");
                    return false;
                } else if (new String(bArr, "UTF-8").equals("test")) {
                    return true;
                } else {
                    DeviceLog.debug("Read buffer content mismatch");
                    return false;
                }
            } catch (Exception e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads exception while testing cache directory ");
                outline24.append(file.getAbsolutePath());
                outline24.append(": ");
                outline24.append(e.getMessage());
                DeviceLog.debug(outline24.toString());
            }
        }
        return false;
    }
}
