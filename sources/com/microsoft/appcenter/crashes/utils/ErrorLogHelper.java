package com.microsoft.appcenter.crashes.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.FileManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ErrorLogHelper {
    public static File sErrorLogDirectory;
    public static File sNewMinidumpDirectory;
    public static File sPendingMinidumpDirectory;

    public static String getContextInformation(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.equals("deviceInfo");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            AppCenterLog.warn("AppCenterCrashes", "No stored deviceinfo file found in a minidump folder.");
            return null;
        }
        String read = FileManager.read(listFiles[0]);
        if (read != null) {
            return read;
        }
        AppCenterLog.error("AppCenterCrashes", "Failed to read stored device info.");
        return null;
    }

    @NonNull
    public static synchronized File getErrorStorageDirectory() {
        File file;
        synchronized (ErrorLogHelper.class) {
            if (sErrorLogDirectory == null) {
                File file2 = new File(Constants.FILES_PATH, "error");
                sErrorLogDirectory = file2;
                FileManager.mkdir(file2.getAbsolutePath());
            }
            file = sErrorLogDirectory;
        }
        return file;
    }

    @Nullable
    public static File getLastErrorLogFile() {
        File errorStorageDirectory = getErrorStorageDirectory();
        C29644 r1 = new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        };
        File file = null;
        if (errorStorageDirectory.exists()) {
            File[] listFiles = errorStorageDirectory.listFiles(r1);
            long j = 0;
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.lastModified() > j) {
                        j = file2.lastModified();
                        file = file2;
                    }
                }
            }
        }
        return file;
    }

    @NonNull
    public static Exception getModelExceptionFromThrowable(@NonNull Throwable th) {
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.add(th);
            th = th.getCause();
        }
        if (linkedList.size() > 16) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Crash causes truncated from ");
            outline24.append(linkedList.size());
            outline24.append(" to ");
            outline24.append(16);
            outline24.append(" causes.");
            AppCenterLog.warn("AppCenterCrashes", outline24.toString());
            linkedList.subList(8, linkedList.size() - 8).clear();
        }
        Iterator it = linkedList.iterator();
        Exception exception = null;
        Exception exception2 = null;
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            Exception exception3 = new Exception();
            exception3.type = th2.getClass().getName();
            exception3.message = th2.getMessage();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace.length > 256) {
                StackTraceElement[] stackTraceElementArr = new StackTraceElement[256];
                System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, 128);
                System.arraycopy(stackTrace, stackTrace.length - 128, stackTraceElementArr, 128, 128);
                th2.setStackTrace(stackTraceElementArr);
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Crash frames truncated from ");
                outline242.append(stackTrace.length);
                outline242.append(" to ");
                outline242.append(256);
                outline242.append(" frames.");
                AppCenterLog.warn("AppCenterCrashes", outline242.toString());
                stackTrace = stackTraceElementArr;
            }
            exception3.frames = getModelFramesFromStackTrace(stackTrace);
            if (exception == null) {
                exception = exception3;
            } else {
                exception2.innerExceptions = Collections.singletonList(exception3);
            }
            exception2 = exception3;
        }
        return exception;
    }

    @NonNull
    public static List<StackFrame> getModelFramesFromStackTrace(@NonNull StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            StackFrame stackFrame = new StackFrame();
            stackFrame.className = stackTraceElement.getClassName();
            stackFrame.methodName = stackTraceElement.getMethodName();
            stackFrame.lineNumber = Integer.valueOf(stackTraceElement.getLineNumber());
            stackFrame.fileName = stackTraceElement.getFileName();
            arrayList.add(stackFrame);
        }
        return arrayList;
    }

    @NonNull
    public static synchronized File getNewMinidumpDirectory() {
        File file;
        synchronized (ErrorLogHelper.class) {
            file = new File(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"), "new");
        }
        return file;
    }

    @NonNull
    public static synchronized File getNewMinidumpSubfolder() {
        File file;
        synchronized (ErrorLogHelper.class) {
            if (sNewMinidumpDirectory == null) {
                File file2 = new File(getNewMinidumpDirectory(), UUID.randomUUID().toString());
                sNewMinidumpDirectory = file2;
                FileManager.mkdir(file2.getPath());
            }
            file = sNewMinidumpDirectory;
        }
        return file;
    }

    @NonNull
    public static synchronized File getPendingMinidumpDirectory() {
        File file;
        synchronized (ErrorLogHelper.class) {
            if (sPendingMinidumpDirectory == null) {
                File file2 = new File(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"), "pending");
                sPendingMinidumpDirectory = file2;
                FileManager.mkdir(file2.getPath());
            }
            file = sPendingMinidumpDirectory;
        }
        return file;
    }

    @NonNull
    public static File[] getStoredErrorLogFiles() {
        File[] listFiles = getErrorStorageDirectory().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
        return listFiles != null ? listFiles : new File[0];
    }

    @Nullable
    public static File getStoredFile(@NonNull final UUID uuid, @NonNull final String str) {
        File[] listFiles = getErrorStorageDirectory().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith(uuid.toString()) && str.endsWith(str);
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        return listFiles[0];
    }

    public static void removeLostThrowableFiles() {
        File[] listFiles = getErrorStorageDirectory().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".throwable");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File name : listFiles) {
                File storedFile = getStoredFile(UUID.fromString(name.getName().replaceFirst("\\.[^.]+$", "")), ".throwable");
                if (storedFile != null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Deleting throwable file ");
                    outline24.append(storedFile.getName());
                    AppCenterLog.info("AppCenterCrashes", outline24.toString());
                    storedFile.delete();
                }
            }
        }
    }

    public static void removeStoredErrorLogFile(@NonNull UUID uuid) {
        File storedFile = getStoredFile(uuid, ".json");
        if (storedFile != null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Deleting error log file ");
            outline24.append(storedFile.getName());
            AppCenterLog.info("AppCenterCrashes", outline24.toString());
            storedFile.delete();
        }
    }
}
