package com.playrix.engine;

import android.content.Context;
import androidx.core.content.FileProvider;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FilesProvider {
    public static final String FILES_PATH = "/provided_files";
    public static final String FILE_PROVIDER = "fileProvider";
    public static final String TAG = "[FilesProvider] ";
    public static int fileId = 1;

    public static String addData(String str, byte[] bArr) {
        try {
            File file = new File(makeFileDirectory(), str);
            createFile(bArr, file);
            return provideFile(file);
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline27("[FilesProvider] Error add data file ", str, " : "));
            return null;
        }
    }

    public static String addFile(String str) {
        try {
            File file = new File(str);
            File file2 = new File(makeFileDirectory(), file.getName());
            copyFile(file, file2);
            return provideFile(file2);
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline27("[FilesProvider] Error add file ", str, " : "));
            return null;
        }
    }

    public static void clearCache() {
        try {
            File filesDirectory = getFilesDirectory();
            deleteDirectoryContents(filesDirectory);
            filesDirectory.delete();
            fileId = 1;
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("[FilesProvider] Error clear cache : "));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r9, java.io.File r10) throws java.lang.Exception {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002a }
            r1.<init>(r9)     // Catch:{ all -> 0x002a }
            java.nio.channels.FileChannel r9 = r1.getChannel()     // Catch:{ all -> 0x002a }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0025 }
            r1.<init>(r10)     // Catch:{ all -> 0x0025 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0025 }
            r4 = 0
            long r6 = r9.size()     // Catch:{ all -> 0x0025 }
            r2 = r0
            r3 = r9
            r2.transferFrom(r3, r4, r6)     // Catch:{ all -> 0x0025 }
            r9.close()
            r0.close()
            return
        L_0x0025:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x002c
        L_0x002a:
            r10 = move-exception
            r9 = r0
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            if (r9 == 0) goto L_0x0036
            r9.close()
        L_0x0036:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.FilesProvider.copyFile(java.io.File, java.io.File):void");
    }

    public static void createFile(byte[] bArr, File file) throws Exception {
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileOutputStream(file).getChannel();
            fileChannel.write(ByteBuffer.wrap(bArr, 0, bArr.length));
            fileChannel.close();
        } catch (Throwable th) {
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void deleteDirectoryContents(File file) throws Exception {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteDirectoryContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new Exception("Failed to delete " + file2);
                }
            }
        }
    }

    public static File getFilesDirectory() throws Exception {
        File externalCacheDir = Engine.getContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            return new File(externalCacheDir.getAbsolutePath() + FILES_PATH);
        }
        throw new Exception("External cache unavailable");
    }

    public static File makeFileDirectory() throws Exception {
        File file = new File(getFilesDirectory().getAbsolutePath() + "/" + String.valueOf(fileId));
        fileId = fileId + 1;
        if (file.mkdirs()) {
            return file;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Can't create directory ");
        outline24.append(file.getAbsolutePath());
        throw new Exception(outline24.toString());
    }

    public static String provideFile(File file) {
        Context context = Engine.getContext();
        return FileProvider.getUriForFile(context, context.getPackageName() + CodelessMatcher.CURRENT_CLASS_NAME + FILE_PROVIDER, file).toString();
    }
}
