package com.vungle.warren.log;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class LogPersister {
    public static final String SDK_CRASH_LOG_FILE_PATTERN = "crash_";
    public static final String SDK_LOGS_DIR = "sdk_logs";
    public static final String SDK_LOG_FILE_CRASH = "_crash";
    public static final String SDK_LOG_FILE_PATTERN = "log_";
    public static final String SDK_LOG_FILE_PENDING = "_pending";
    public static final String TAG = "LogPersister";
    public int entryCount;
    public LogManager.SdkLoggingEventListener listener;
    @Nullable
    public File logDir;
    public File logFile;
    public int maximumEntries = 100;

    public LogPersister(@Nullable File file) {
        if (file != null) {
            File orCreateLogDir = getOrCreateLogDir(file);
            this.logDir = orCreateLogDir;
            if (orCreateLogDir != null) {
                this.logFile = getOrCreateLogFile(orCreateLogDir);
            }
        }
    }

    @Nullable
    private File createFileOrDirectory(@NonNull File file, @NonNull String str, boolean z) {
        boolean z2;
        File file2 = new File(file, str);
        if (file2.exists()) {
            z2 = true;
        } else if (!z) {
            try {
                z2 = file2.createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "", e);
                z2 = false;
            }
        } else {
            z2 = file2.mkdir();
        }
        if (z2) {
            return file2;
        }
        return null;
    }

    public static String getDateText(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    public static int getFileLineCount(@NonNull String str) {
        LineNumberReader lineNumberReader = null;
        try {
            LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(str));
            while (lineNumberReader2.readLine() != null) {
                try {
                } catch (Exception unused) {
                    lineNumberReader = lineNumberReader2;
                    FileUtility.closeQuietly(lineNumberReader);
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    lineNumberReader = lineNumberReader2;
                    FileUtility.closeQuietly(lineNumberReader);
                    throw th;
                }
            }
            int lineNumber = lineNumberReader2.getLineNumber();
            FileUtility.closeQuietly(lineNumberReader2);
            return lineNumber;
        } catch (Exception unused2) {
            FileUtility.closeQuietly(lineNumberReader);
            return -1;
        } catch (Throwable th2) {
            th = th2;
            FileUtility.closeQuietly(lineNumberReader);
            throw th;
        }
    }

    @Nullable
    private File getOrCreateLogDir(@NonNull File file) {
        File createFileOrDirectory = createFileOrDirectory(file, SDK_LOGS_DIR, true);
        if (createFileOrDirectory != null && createFileOrDirectory.exists()) {
            return createFileOrDirectory;
        }
        Log.e(TAG, "Failed to create vungle logs dir");
        return null;
    }

    private boolean renameFile(@NonNull File file, @NonNull String str) {
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(this.logDir, str);
        if (file2.exists()) {
            return false;
        }
        return file.renameTo(file2);
    }

    @Nullable
    public File[] getCrashReportFiles(int i) {
        File file = this.logDir;
        if (file == null) {
            Log.w(TAG, "No log cache dir found.");
            return null;
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(LogPersister.SDK_LOG_FILE_CRASH);
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        return (File[]) Arrays.copyOfRange(listFiles, 0, Math.min(listFiles.length, i));
    }

    @Nullable
    public File getOrCreateLogFile(@NonNull File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return !str.endsWith(LogPersister.SDK_LOG_FILE_PENDING);
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            this.entryCount = 0;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(SDK_LOG_FILE_PATTERN);
            outline24.append(System.currentTimeMillis());
            outline24.append(UUID.randomUUID().toString());
            return createFileOrDirectory(file, outline24.toString(), false);
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        File file2 = listFiles[0];
        int fileLineCount = getFileLineCount(file2.getAbsolutePath());
        if (fileLineCount <= 0 || fileLineCount < this.maximumEntries) {
            this.entryCount = fileLineCount;
            return file2;
        }
        File file3 = null;
        try {
            File file4 = this.logFile;
            if (renameFile(file4, this.logFile.getName() + SDK_LOG_FILE_PENDING)) {
                file3 = getOrCreateLogFile(file);
            }
        } catch (Exception unused) {
        }
        if (file3 != null) {
            return file3;
        }
        this.entryCount = fileLineCount;
        return file2;
    }

    @Nullable
    public File[] getPendingFiles() {
        File file = this.logDir;
        if (file != null) {
            return file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(LogPersister.SDK_LOG_FILE_PENDING);
                }
            });
        }
        Log.w(TAG, "No log cache dir found.");
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveCrashLogData(@androidx.annotation.NonNull java.lang.String r15, @androidx.annotation.NonNull java.lang.String r16, @androidx.annotation.NonNull java.lang.String r17, @androidx.annotation.Nullable java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, @androidx.annotation.Nullable java.lang.String r20, @androidx.annotation.Nullable java.lang.String r21, @androidx.annotation.Nullable java.lang.String r22, @androidx.annotation.Nullable java.lang.String r23) {
        /*
            r14 = this;
            r1 = r14
            java.io.File r0 = r1.logDir
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = TAG
            java.lang.String r2 = "No log cache dir found."
            android.util.Log.w(r0, r2)
            return
        L_0x000d:
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.lang.String r9 = r0.getID()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = getDateText(r2)
            com.vungle.warren.log.LogEntry r0 = new com.vungle.warren.log.LogEntry
            r2 = r0
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.String r2 = "crash_"
            java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.io.File r3 = r1.logDir
            r4 = 0
            java.io.File r2 = r14.createFileOrDirectory(r3, r2, r4)
            if (r2 == 0) goto L_0x0094
            r3 = 0
            r5 = 1
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ IOException -> 0x006a }
            r6.<init>(r2, r5)     // Catch:{ IOException -> 0x006a }
            java.lang.String r0 = r0.toJsonString()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r6.append(r0)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r6.flush()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r6)
            r4 = 1
            goto L_0x0074
        L_0x0064:
            r0 = move-exception
            goto L_0x0090
        L_0x0066:
            r3 = r6
            goto L_0x006a
        L_0x0068:
            r0 = move-exception
            goto L_0x008f
        L_0x006a:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = "Failed to write crash log."
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x0068 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r3)
        L_0x0074:
            if (r4 == 0) goto L_0x0094
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r2.getName()
            r0.append(r3)
            java.lang.String r3 = "_crash"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r14.renameFile(r2, r0)
            goto L_0x0094
        L_0x008f:
            r6 = r3
        L_0x0090:
            com.vungle.warren.utility.FileUtility.closeQuietly(r6)
            throw r0
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogPersister.saveCrashLogData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x007f */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveLogData(@androidx.annotation.NonNull java.lang.String r15, @androidx.annotation.NonNull java.lang.String r16, @androidx.annotation.NonNull java.lang.String r17, @androidx.annotation.Nullable java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, @androidx.annotation.Nullable java.lang.String r20, @androidx.annotation.Nullable java.lang.String r21, @androidx.annotation.Nullable java.lang.String r22, @androidx.annotation.Nullable java.lang.String r23) {
        /*
            r14 = this;
            r1 = r14
            java.io.File r0 = r1.logDir
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = TAG
            java.lang.String r2 = "No log cache dir found."
            android.util.Log.w(r0, r2)
            return
        L_0x000d:
            java.io.File r0 = r1.logFile
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0030
        L_0x0017:
            java.lang.String r0 = TAG
            java.lang.String r2 = "current log file maybe deleted, create new one."
            android.util.Log.d(r0, r2)
            java.io.File r0 = r1.logDir
            java.io.File r0 = r14.getOrCreateLogFile(r0)
            r1.logFile = r0
            if (r0 == 0) goto L_0x00c8
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0030
            goto L_0x00c8
        L_0x0030:
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.lang.String r9 = r0.getID()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = getDateText(r2)
            com.vungle.warren.log.LogEntry r0 = new com.vungle.warren.log.LogEntry
            r2 = r0
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = 0
            r3 = 1
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x007f }
            java.io.File r5 = r1.logFile     // Catch:{ IOException -> 0x007f }
            r4.<init>(r5, r3)     // Catch:{ IOException -> 0x007f }
            int r2 = r1.entryCount     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            if (r2 <= 0) goto L_0x0069
            java.lang.String r2 = "\n"
            r4.append(r2)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
        L_0x0069:
            java.lang.String r0 = r0.toJsonString()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r4.append(r0)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r4.flush()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            com.vungle.warren.utility.FileUtility.closeQuietly(r4)
            r0 = 1
            goto L_0x008a
        L_0x0078:
            r0 = move-exception
            r2 = r4
            goto L_0x00c4
        L_0x007b:
            r2 = r4
            goto L_0x007f
        L_0x007d:
            r0 = move-exception
            goto L_0x00c4
        L_0x007f:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "Failed to write sdk logs."
            android.util.Log.e(r0, r4)     // Catch:{ all -> 0x007d }
            r0 = 0
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
        L_0x008a:
            if (r0 == 0) goto L_0x00c3
            int r0 = r1.entryCount
            int r0 = r0 + r3
            r1.entryCount = r0
            int r2 = r1.maximumEntries
            if (r0 < r2) goto L_0x00c3
            java.io.File r0 = r1.logFile
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r1.logFile
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = "_pending"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r0 = r14.renameFile(r0, r2)
            if (r0 == 0) goto L_0x00bc
            java.io.File r0 = r1.logDir
            java.io.File r0 = r14.getOrCreateLogFile(r0)
            r1.logFile = r0
        L_0x00bc:
            com.vungle.warren.log.LogManager$SdkLoggingEventListener r0 = r1.listener
            if (r0 == 0) goto L_0x00c3
            r0.sendPendingLogs()
        L_0x00c3:
            return
        L_0x00c4:
            com.vungle.warren.utility.FileUtility.closeQuietly(r2)
            throw r0
        L_0x00c8:
            java.lang.String r0 = TAG
            java.lang.String r2 = "Can't create log file, maybe no space left."
            android.util.Log.w(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogPersister.saveLogData(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void setMaximumEntries(int i) {
        if (i <= 0) {
            i = 100;
        }
        this.maximumEntries = i;
    }

    public void setSdkLoggingEventListener(@NonNull LogManager.SdkLoggingEventListener sdkLoggingEventListener) {
        this.listener = sdkLoggingEventListener;
    }
}
