package com.vungle.warren.persistence;

import android.util.Log;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;

public class GraphicDesigner implements Designer, CacheManager.Listener {
    public static final String FOLDER_NAME = "vungle";
    public static final String TAG = "GraphicDesigner";
    public CacheManager cacheManager;

    public GraphicDesigner(@NonNull CacheManager cacheManager2) {
        this.cacheManager = cacheManager2;
        cacheManager2.addListener(this);
        FileUtility.printDirectoryTree(getCacheDirectory());
    }

    public void clearCache() {
        CacheManager cacheManager2 = this.cacheManager;
        if (cacheManager2 != null && cacheManager2.getCache() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.cacheManager.getCache().getPath());
            File file = new File(GeneratedOutlineSupport.outline18(sb, File.separator, FOLDER_NAME));
            if (file.exists()) {
                try {
                    FileUtility.delete(file);
                } catch (IOException e) {
                    String str = TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to delete cached files. Reason: ");
                    outline24.append(e.getLocalizedMessage());
                    Log.e(str, outline24.toString());
                }
            }
            if (!file.exists()) {
                file.mkdir();
            }
        }
    }

    public void deleteAssets(String str) throws IOException, IllegalStateException {
        File[] listFiles = getCacheDirectory().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory() && file.getName().equals(str)) {
                    FileUtility.delete(file);
                }
            }
        }
    }

    public File getAssetDirectory(String str) throws IllegalStateException {
        StringBuilder sb = new StringBuilder();
        sb.append(getCacheDirectory().getPath());
        File file = new File(GeneratedOutlineSupport.outline18(sb, File.separator, str));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public File getCacheDirectory() throws IllegalStateException {
        if (this.cacheManager != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.cacheManager.getCache());
            File file = new File(GeneratedOutlineSupport.outline18(sb, File.separator, FOLDER_NAME));
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
        throw new IllegalStateException("Context has expired, cannot continue.");
    }

    public void onCacheChanged() {
        CacheManager cacheManager2 = this.cacheManager;
        if (cacheManager2 != null) {
            for (File next : cacheManager2.getOldCaches()) {
                try {
                    FileUtility.delete(new File(next.getPath() + File.separator + FOLDER_NAME));
                } catch (IOException e) {
                    String str = TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to delete cached files. Reason: ");
                    outline24.append(e.getLocalizedMessage());
                    Log.e(str, outline24.toString());
                }
            }
        }
    }
}
