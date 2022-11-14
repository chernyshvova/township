package com.microsoft.appcenter.crashes;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.crashes.ingestion.models.json.ErrorAttachmentLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.HandledErrorLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.ManagedErrorLogFactory;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.model.NativeException;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

public class Crashes extends AbstractAppCenterService {
    public static final AbstractCrashesListener DEFAULT_ERROR_REPORTING_LISTENER = new DefaultCrashesListener((C29481) null);
    @SuppressLint({"StaticFieldLeak"})
    public static Crashes sInstance = null;
    public boolean mAutomaticProcessing = true;
    public Context mContext;
    public AbstractCrashesListener mCrashesListener;
    public Device mDevice;
    public final Map<UUID, ErrorLogReport> mErrorReportCache;
    public final Map<String, LogFactory> mFactories;
    public boolean mHasReceivedMemoryWarningInLastSession;
    public long mInitializeTimestamp;
    public ErrorReport mLastSessionErrorReport;
    public DefaultLogSerializer mLogSerializer;
    public ComponentCallbacks2 mMemoryWarningListener;
    public boolean mSavedUncaughtException;
    public UncaughtExceptionHandler mUncaughtExceptionHandler;
    public final Map<UUID, ErrorLogReport> mUnprocessedErrorReports;

    public interface CallbackProcessor {
        void onCallBack(ErrorReport errorReport);
    }

    public static class DefaultCrashesListener extends AbstractCrashesListener {
        public DefaultCrashesListener(C29481 r1) {
        }
    }

    public static class ErrorLogReport {
        public final ManagedErrorLog log;
        public final ErrorReport report;

        public ErrorLogReport(ManagedErrorLog managedErrorLog, ErrorReport errorReport, C29481 r3) {
            this.log = managedErrorLog;
            this.report = errorReport;
        }
    }

    public Crashes() {
        HashMap hashMap = new HashMap();
        this.mFactories = hashMap;
        hashMap.put("managedError", ManagedErrorLogFactory.sInstance);
        this.mFactories.put("handledError", HandledErrorLogFactory.sInstance);
        this.mFactories.put("errorAttachment", ErrorAttachmentLogFactory.sInstance);
        DefaultLogSerializer defaultLogSerializer = new DefaultLogSerializer();
        this.mLogSerializer = defaultLogSerializer;
        defaultLogSerializer.mLogFactories.put("managedError", ManagedErrorLogFactory.sInstance);
        DefaultLogSerializer defaultLogSerializer2 = this.mLogSerializer;
        defaultLogSerializer2.mLogFactories.put("errorAttachment", ErrorAttachmentLogFactory.sInstance);
        this.mCrashesListener = DEFAULT_ERROR_REPORTING_LISTENER;
        this.mUnprocessedErrorReports = new LinkedHashMap();
        this.mErrorReportCache = new LinkedHashMap();
    }

    public static void access$400(int i) {
        SharedPreferences.Editor edit = SharedPreferencesManager.sSharedPreferences.edit();
        edit.putInt("com.microsoft.appcenter.crashes.memory", i);
        edit.apply();
        AppCenterLog.debug("AppCenterCrashes", String.format("The memory running level (%s) was saved.", new Object[]{Integer.valueOf(i)}));
    }

    public static void access$800(Crashes crashes, UUID uuid, Iterable iterable) {
        if (crashes == null) {
            throw null;
        } else if (iterable == null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error report: ");
            outline24.append(uuid.toString());
            outline24.append(" does not have any attachment.");
            AppCenterLog.debug("AppCenterCrashes", outline24.toString());
        } else {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                ErrorAttachmentLog errorAttachmentLog = (ErrorAttachmentLog) it.next();
                if (errorAttachmentLog != null) {
                    UUID randomUUID = UUID.randomUUID();
                    errorAttachmentLog.f3578id = randomUUID;
                    errorAttachmentLog.errorId = uuid;
                    if (!((randomUUID == null || uuid == null || errorAttachmentLog.contentType == null || errorAttachmentLog.data == null) ? false : true)) {
                        AppCenterLog.error("AppCenterCrashes", "Not all required fields are present in ErrorAttachmentLog.");
                    } else if (errorAttachmentLog.data.length > 7340032) {
                        AppCenterLog.error("AppCenterCrashes", String.format(Locale.ENGLISH, "Discarding attachment with size above %d bytes: size=%d, fileName=%s.", new Object[]{7340032, Integer.valueOf(errorAttachmentLog.data.length), errorAttachmentLog.fileName}));
                    } else {
                        ((DefaultChannel) crashes.mChannel).enqueue(errorAttachmentLog, "groupErrors", 1);
                    }
                } else {
                    AppCenterLog.warn("AppCenterCrashes", "Skipping null ErrorAttachmentLog.");
                }
            }
        }
    }

    @NonNull
    public static synchronized Crashes getInstance() {
        Crashes crashes;
        synchronized (Crashes.class) {
            if (sInstance == null) {
                sInstance = new Crashes();
            }
            crashes = sInstance;
        }
        return crashes;
    }

    public synchronized void applyEnabledState(boolean z) {
        initialize();
        if (z) {
            C29545 r7 = new ComponentCallbacks2(this) {
                public void onConfigurationChanged(@NonNull Configuration configuration) {
                }

                public void onLowMemory() {
                    Crashes.access$400(80);
                }

                public void onTrimMemory(int i) {
                    Crashes.access$400(i);
                }
            };
            this.mMemoryWarningListener = r7;
            this.mContext.registerComponentCallbacks(r7);
        } else {
            File[] listFiles = ErrorLogHelper.getErrorStorageDirectory().listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    AppCenterLog.debug("AppCenterCrashes", "Deleting file " + file);
                    if (!file.delete()) {
                        AppCenterLog.warn("AppCenterCrashes", "Failed to delete file " + file);
                    }
                }
            }
            AppCenterLog.info("AppCenterCrashes", "Deleted crashes local files");
            this.mErrorReportCache.clear();
            this.mLastSessionErrorReport = null;
            this.mContext.unregisterComponentCallbacks(this.mMemoryWarningListener);
            this.mMemoryWarningListener = null;
            SharedPreferencesManager.remove("com.microsoft.appcenter.crashes.memory");
        }
    }

    @VisibleForTesting
    public ErrorReport buildErrorReport(ManagedErrorLog managedErrorLog) {
        UUID uuid = managedErrorLog.f3577id;
        if (this.mErrorReportCache.containsKey(uuid)) {
            ErrorReport errorReport = this.mErrorReportCache.get(uuid).report;
            errorReport.device = managedErrorLog.device;
            return errorReport;
        }
        File storedFile = ErrorLogHelper.getStoredFile(uuid, ".throwable");
        if (((storedFile == null || storedFile.length() <= 0) ? null : FileManager.read(storedFile)) == null) {
            if ("minidump".equals(managedErrorLog.exception.type)) {
                Log.getStackTraceString(new NativeException());
            } else {
                Exception exception = managedErrorLog.exception;
                String format = String.format("%s: %s", new Object[]{exception.type, exception.message});
                List<StackFrame> list = exception.frames;
                if (list != null) {
                    for (StackFrame next : list) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24(format);
                        outline24.append(String.format("\n\t at %s.%s(%s:%s)", new Object[]{next.className, next.methodName, next.fileName, next.lineNumber}));
                        format = outline24.toString();
                    }
                }
            }
        }
        ErrorReport errorReport2 = new ErrorReport();
        errorReport2.f3581id = managedErrorLog.f3577id.toString();
        errorReport2.appErrorTime = managedErrorLog.timestamp;
        errorReport2.device = managedErrorLog.device;
        this.mErrorReportCache.put(uuid, new ErrorLogReport(managedErrorLog, errorReport2, (C29481) null));
        return errorReport2;
    }

    public Channel.GroupListener getChannelListener() {
        return new Channel.GroupListener() {
            public void onBeforeSending(final com.microsoft.appcenter.ingestion.models.Log log) {
                final C29582 r0 = new CallbackProcessor() {
                    public void onCallBack(ErrorReport errorReport) {
                        Crashes.this.mCrashesListener.onBeforeSending(errorReport);
                    }
                };
                Crashes.this.post(new Runnable() {
                    public void run() {
                        com.microsoft.appcenter.ingestion.models.Log log = r4;
                        if (log instanceof ManagedErrorLog) {
                            final ErrorReport buildErrorReport = Crashes.this.buildErrorReport((ManagedErrorLog) log);
                            HandlerUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    r0.onCallBack(buildErrorReport);
                                }
                            });
                        } else if (!(log instanceof ErrorAttachmentLog) && !(log instanceof HandledErrorLog)) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("A different type of log comes to crashes: ");
                            outline24.append(r4.getClass().getName());
                            AppCenterLog.warn("AppCenterCrashes", outline24.toString());
                        }
                    }
                });
            }

            public void onFailure(final com.microsoft.appcenter.ingestion.models.Log log, final Exception exc) {
                final C29604 r0 = new CallbackProcessor() {
                    public void onCallBack(ErrorReport errorReport) {
                        Crashes.this.mCrashesListener.onSendingFailed(errorReport, exc);
                    }
                };
                Crashes.this.post(new Runnable() {
                    public void run() {
                        com.microsoft.appcenter.ingestion.models.Log log = r4;
                        if (log instanceof ManagedErrorLog) {
                            final ErrorReport buildErrorReport = Crashes.this.buildErrorReport((ManagedErrorLog) log);
                            HandlerUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    r0.onCallBack(buildErrorReport);
                                }
                            });
                        } else if (!(log instanceof ErrorAttachmentLog) && !(log instanceof HandledErrorLog)) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("A different type of log comes to crashes: ");
                            outline24.append(r4.getClass().getName());
                            AppCenterLog.warn("AppCenterCrashes", outline24.toString());
                        }
                    }
                });
            }

            public void onSuccess(final com.microsoft.appcenter.ingestion.models.Log log) {
                final C29593 r0 = new CallbackProcessor() {
                    public void onCallBack(ErrorReport errorReport) {
                        Crashes.this.mCrashesListener.onSendingSucceeded(errorReport);
                    }
                };
                Crashes.this.post(new Runnable() {
                    public void run() {
                        com.microsoft.appcenter.ingestion.models.Log log = log;
                        if (log instanceof ManagedErrorLog) {
                            final ErrorReport buildErrorReport = Crashes.this.buildErrorReport((ManagedErrorLog) log);
                            HandlerUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    r0.onCallBack(buildErrorReport);
                                }
                            });
                        } else if (!(log instanceof ErrorAttachmentLog) && !(log instanceof HandledErrorLog)) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("A different type of log comes to crashes: ");
                            outline24.append(log.getClass().getName());
                            AppCenterLog.warn("AppCenterCrashes", outline24.toString());
                        }
                    }
                });
            }
        };
    }

    public String getGroupName() {
        return "groupErrors";
    }

    public Map<String, LogFactory> getLogFactories() {
        return this.mFactories;
    }

    public String getLoggerTag() {
        return "AppCenterCrashes";
    }

    public String getServiceName() {
        return "Crashes";
    }

    public int getTriggerCount() {
        return 1;
    }

    public final void initialize() {
        boolean isInstanceEnabled = isInstanceEnabled();
        this.mInitializeTimestamp = isInstanceEnabled ? System.currentTimeMillis() : -1;
        if (!isInstanceEnabled) {
            UncaughtExceptionHandler uncaughtExceptionHandler = this.mUncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler.mDefaultUncaughtExceptionHandler);
                this.mUncaughtExceptionHandler = null;
                return;
            }
            return;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler2 = new UncaughtExceptionHandler();
        this.mUncaughtExceptionHandler = uncaughtExceptionHandler2;
        if (!uncaughtExceptionHandler2.mIgnoreDefaultExceptionHandler) {
            uncaughtExceptionHandler2.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        } else {
            uncaughtExceptionHandler2.mDefaultUncaughtExceptionHandler = null;
        }
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler2);
        File[] listFiles = ErrorLogHelper.getNewMinidumpDirectory().listFiles();
        if (listFiles == null) {
            listFiles = new File[0];
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                AppCenterLog.debug("AppCenterCrashes", "Found a minidump from a previous SDK version.");
                processSingleMinidump(file, file);
            } else {
                File[] listFiles2 = file.listFiles(new FilenameFilter(this) {
                    public boolean accept(File file, String str) {
                        return str.endsWith(".dmp");
                    }
                });
                if (!(listFiles2 == null || listFiles2.length == 0)) {
                    for (File processSingleMinidump : listFiles2) {
                        processSingleMinidump(processSingleMinidump, file);
                    }
                }
            }
        }
        File lastErrorLogFile = ErrorLogHelper.getLastErrorLogFile();
        while (lastErrorLogFile != null && lastErrorLogFile.length() == 0) {
            AppCenterLog.warn("AppCenterCrashes", "Deleting empty error file: " + lastErrorLogFile);
            lastErrorLogFile.delete();
            lastErrorLogFile = ErrorLogHelper.getLastErrorLogFile();
        }
        if (lastErrorLogFile != null) {
            AppCenterLog.debug("AppCenterCrashes", "Processing crash report for the last session.");
            String read = FileManager.read(lastErrorLogFile);
            if (read == null) {
                AppCenterLog.error("AppCenterCrashes", "Error reading last session error log.");
            } else {
                try {
                    this.mLastSessionErrorReport = buildErrorReport((ManagedErrorLog) this.mLogSerializer.deserializeLog(read, (String) null));
                    AppCenterLog.debug("AppCenterCrashes", "Processed crash report for the last session.");
                } catch (JSONException e) {
                    AppCenterLog.error("AppCenterCrashes", "Error parsing last session error log.", e);
                }
            }
        }
        File[] listFiles3 = ErrorLogHelper.getNewMinidumpDirectory().listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                File file2 = ErrorLogHelper.sNewMinidumpDirectory;
                if (file2 != null) {
                    return !str.equals(file2.getName());
                }
                return true;
            }
        });
        if (listFiles3 == null || listFiles3.length == 0) {
            AppCenterLog.debug("AppCenterCrashes", "No previous minidump sub-folders.");
            return;
        }
        for (File deleteDirectory : listFiles3) {
            FileManager.deleteDirectory(deleteDirectory);
        }
    }

    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        this.mContext = context;
        if (!isInstanceEnabled()) {
            FileManager.deleteDirectory(new File(ErrorLogHelper.getErrorStorageDirectory().getAbsolutePath(), "minidump"));
            AppCenterLog.debug("AppCenterCrashes", "Clean up minidump folder.");
        }
        super.onStarted(context, channel, str, str2, z);
        if (isInstanceEnabled()) {
            processPendingErrors();
            if (this.mErrorReportCache.isEmpty()) {
                ErrorLogHelper.removeLostThrowableFiles();
            }
        }
    }

    public final void processPendingErrors() {
        for (File file : ErrorLogHelper.getStoredErrorLogFiles()) {
            AppCenterLog.debug("AppCenterCrashes", "Process pending error file: " + file);
            String read = FileManager.read(file);
            if (read != null) {
                try {
                    ManagedErrorLog managedErrorLog = (ManagedErrorLog) this.mLogSerializer.deserializeLog(read, (String) null);
                    UUID uuid = managedErrorLog.f3577id;
                    ErrorReport buildErrorReport = buildErrorReport(managedErrorLog);
                    if (this.mAutomaticProcessing) {
                        if (!this.mCrashesListener.shouldProcess(buildErrorReport)) {
                            AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldProcess returned false, clean up and ignore log: " + uuid.toString());
                            removeAllStoredErrorLogFiles(uuid);
                        }
                    }
                    if (!this.mAutomaticProcessing) {
                        AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldProcess returned true, continue processing log: " + uuid.toString());
                    }
                    this.mUnprocessedErrorReports.put(uuid, this.mErrorReportCache.get(uuid));
                } catch (JSONException e) {
                    AppCenterLog.error("AppCenterCrashes", "Error parsing error log. Deleting invalid file: " + file, e);
                    file.delete();
                }
            }
        }
        int i = SharedPreferencesManager.sSharedPreferences.getInt("com.microsoft.appcenter.crashes.memory", -1);
        boolean z = i == 5 || i == 10 || i == 15 || i == 80;
        this.mHasReceivedMemoryWarningInLastSession = z;
        if (z) {
            AppCenterLog.debug("AppCenterCrashes", "The application received a low memory warning in the last session.");
        }
        SharedPreferencesManager.remove("com.microsoft.appcenter.crashes.memory");
        if (this.mAutomaticProcessing) {
            final boolean z2 = SharedPreferencesManager.getBoolean("com.microsoft.appcenter.crashes.always.send", false);
            HandlerUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (Crashes.this.mUnprocessedErrorReports.size() <= 0) {
                        return;
                    }
                    if (z2) {
                        AppCenterLog.debug("AppCenterCrashes", "The flag for user confirmation is set to ALWAYS_SEND, will send logs.");
                        Crashes crashes = Crashes.this;
                        synchronized (crashes) {
                            crashes.post(new Runnable(0) {
                                public final /* synthetic */ int val$userConfirmation;

                                {
                                    this.val$userConfirmation = r2;
                                }

                                /* JADX WARNING: type inference failed for: r5v7, types: [com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog] */
                                /* JADX WARNING: Multi-variable type inference failed */
                                /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
                                /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3  */
                                /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A[SYNTHETIC] */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public void run() {
                                    /*
                                        r9 = this;
                                        int r0 = r9.val$userConfirmation
                                        r1 = 1
                                        if (r0 != r1) goto L_0x003c
                                        com.microsoft.appcenter.crashes.Crashes r0 = com.microsoft.appcenter.crashes.Crashes.this
                                        java.util.Map<java.util.UUID, com.microsoft.appcenter.crashes.Crashes$ErrorLogReport> r0 = r0.mUnprocessedErrorReports
                                        java.util.Set r0 = r0.keySet()
                                        java.util.Iterator r0 = r0.iterator()
                                    L_0x0011:
                                        boolean r1 = r0.hasNext()
                                        if (r1 == 0) goto L_0x0026
                                        java.lang.Object r1 = r0.next()
                                        java.util.UUID r1 = (java.util.UUID) r1
                                        r0.remove()
                                        com.microsoft.appcenter.crashes.Crashes r2 = com.microsoft.appcenter.crashes.Crashes.this
                                        r2.removeAllStoredErrorLogFiles(r1)
                                        goto L_0x0011
                                    L_0x0026:
                                        java.io.File r0 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getPendingMinidumpDirectory()
                                        java.io.File[] r0 = r0.listFiles()
                                        if (r0 == 0) goto L_0x0112
                                        int r1 = r0.length
                                        r2 = 0
                                    L_0x0032:
                                        if (r2 >= r1) goto L_0x0112
                                        r3 = r0[r2]
                                        com.microsoft.appcenter.utils.storage.FileManager.deleteDirectory(r3)
                                        int r2 = r2 + 1
                                        goto L_0x0032
                                    L_0x003c:
                                        r2 = 2
                                        if (r0 != r2) goto L_0x0044
                                        java.lang.String r0 = "com.microsoft.appcenter.crashes.always.send"
                                        com.microsoft.appcenter.utils.storage.SharedPreferencesManager.putBoolean(r0, r1)
                                    L_0x0044:
                                        com.microsoft.appcenter.crashes.Crashes r0 = com.microsoft.appcenter.crashes.Crashes.this
                                        java.util.Map<java.util.UUID, com.microsoft.appcenter.crashes.Crashes$ErrorLogReport> r0 = r0.mUnprocessedErrorReports
                                        java.util.Set r0 = r0.entrySet()
                                        java.util.Iterator r0 = r0.iterator()
                                    L_0x0050:
                                        boolean r1 = r0.hasNext()
                                        if (r1 == 0) goto L_0x0112
                                        java.lang.Object r1 = r0.next()
                                        java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                                        java.lang.Object r3 = r1.getValue()
                                        com.microsoft.appcenter.crashes.Crashes$ErrorLogReport r3 = (com.microsoft.appcenter.crashes.Crashes.ErrorLogReport) r3
                                        com.microsoft.appcenter.crashes.model.ErrorReport r4 = r3.report
                                        com.microsoft.appcenter.ingestion.models.Device r4 = r4.device
                                        r5 = 0
                                        if (r4 == 0) goto L_0x00cd
                                        java.lang.String r4 = r4.wrapperSdkName
                                        java.lang.String r6 = "appcenter.ndk"
                                        boolean r4 = r6.equals(r4)
                                        if (r4 == 0) goto L_0x00cd
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r4 = r3.log
                                        com.microsoft.appcenter.crashes.ingestion.models.Exception r4 = r4.exception
                                        java.lang.String r6 = r4.minidumpFilePath
                                        r4.minidumpFilePath = r5
                                        if (r6 != 0) goto L_0x0081
                                        java.lang.String r6 = r4.stackTrace
                                        r4.stackTrace = r5
                                    L_0x0081:
                                        if (r6 == 0) goto L_0x00c6
                                        java.io.File r4 = new java.io.File
                                        r4.<init>(r6)
                                        long r6 = r4.length()
                                        int r7 = (int) r6
                                        byte[] r6 = new byte[r7]
                                        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a6 }
                                        r7.<init>(r4)     // Catch:{ IOException -> 0x00a6 }
                                        java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ all -> 0x00a1 }
                                        r8.<init>(r7)     // Catch:{ all -> 0x00a1 }
                                        r8.readFully(r6)     // Catch:{ all -> 0x00a1 }
                                        r7.close()     // Catch:{ IOException -> 0x00a6 }
                                        r5 = r6
                                        goto L_0x00bd
                                    L_0x00a1:
                                        r6 = move-exception
                                        r7.close()     // Catch:{ IOException -> 0x00a6 }
                                        throw r6     // Catch:{ IOException -> 0x00a6 }
                                    L_0x00a6:
                                        r6 = move-exception
                                        java.lang.String r7 = "Could not read file "
                                        java.lang.StringBuilder r7 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r7)
                                        java.lang.String r8 = r4.getAbsolutePath()
                                        r7.append(r8)
                                        java.lang.String r7 = r7.toString()
                                        java.lang.String r8 = "AppCenter"
                                        com.microsoft.appcenter.utils.AppCenterLog.error(r8, r7, r6)
                                    L_0x00bd:
                                        java.lang.String r6 = "minidump.dmp"
                                        java.lang.String r7 = "application/octet-stream"
                                        com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog r5 = com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog.attachmentWithBinary(r5, r6, r7)
                                        goto L_0x00ce
                                    L_0x00c6:
                                        java.lang.String r4 = "AppCenterCrashes"
                                        java.lang.String r6 = "NativeException found without minidump."
                                        com.microsoft.appcenter.utils.AppCenterLog.warn(r4, r6)
                                    L_0x00cd:
                                        r4 = r5
                                    L_0x00ce:
                                        com.microsoft.appcenter.crashes.Crashes r6 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.channel.Channel r6 = r6.mChannel
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r7 = r3.log
                                        com.microsoft.appcenter.channel.DefaultChannel r6 = (com.microsoft.appcenter.channel.DefaultChannel) r6
                                        java.lang.String r8 = "groupErrors"
                                        r6.enqueue(r7, r8, r2)
                                        if (r5 == 0) goto L_0x00ed
                                        com.microsoft.appcenter.crashes.Crashes r6 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r7 = r3.log
                                        java.util.UUID r7 = r7.f3577id
                                        java.util.Set r5 = java.util.Collections.singleton(r5)
                                        com.microsoft.appcenter.crashes.Crashes.access$800(r6, r7, r5)
                                        r4.delete()
                                    L_0x00ed:
                                        com.microsoft.appcenter.crashes.Crashes r4 = com.microsoft.appcenter.crashes.Crashes.this
                                        boolean r5 = r4.mAutomaticProcessing
                                        if (r5 == 0) goto L_0x0104
                                        com.microsoft.appcenter.crashes.AbstractCrashesListener r4 = r4.mCrashesListener
                                        com.microsoft.appcenter.crashes.model.ErrorReport r5 = r3.report
                                        java.lang.Iterable r4 = r4.getErrorAttachments(r5)
                                        com.microsoft.appcenter.crashes.Crashes r5 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r3 = r3.log
                                        java.util.UUID r3 = r3.f3577id
                                        com.microsoft.appcenter.crashes.Crashes.access$800(r5, r3, r4)
                                    L_0x0104:
                                        r0.remove()
                                        java.lang.Object r1 = r1.getKey()
                                        java.util.UUID r1 = (java.util.UUID) r1
                                        com.microsoft.appcenter.crashes.utils.ErrorLogHelper.removeStoredErrorLogFile(r1)
                                        goto L_0x0050
                                    L_0x0112:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.crashes.Crashes.C295112.run():void");
                                }
                            });
                        }
                        return;
                    }
                    Crashes crashes2 = Crashes.this;
                    if (!crashes2.mAutomaticProcessing) {
                        AppCenterLog.debug("AppCenterCrashes", "Automatic processing disabled, will wait for explicit user confirmation.");
                    } else if (!crashes2.mCrashesListener.shouldAwaitUserConfirmation()) {
                        AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned false, will send logs.");
                        Crashes crashes3 = Crashes.this;
                        synchronized (crashes3) {
                            crashes3.post(new Runnable(0) {
                                public final /* synthetic */ int val$userConfirmation;

                                {
                                    this.val$userConfirmation = r2;
                                }

                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public void run() {
                                    /*
                                        r9 = this;
                                        int r0 = r9.val$userConfirmation
                                        r1 = 1
                                        if (r0 != r1) goto L_0x003c
                                        com.microsoft.appcenter.crashes.Crashes r0 = com.microsoft.appcenter.crashes.Crashes.this
                                        java.util.Map<java.util.UUID, com.microsoft.appcenter.crashes.Crashes$ErrorLogReport> r0 = r0.mUnprocessedErrorReports
                                        java.util.Set r0 = r0.keySet()
                                        java.util.Iterator r0 = r0.iterator()
                                    L_0x0011:
                                        boolean r1 = r0.hasNext()
                                        if (r1 == 0) goto L_0x0026
                                        java.lang.Object r1 = r0.next()
                                        java.util.UUID r1 = (java.util.UUID) r1
                                        r0.remove()
                                        com.microsoft.appcenter.crashes.Crashes r2 = com.microsoft.appcenter.crashes.Crashes.this
                                        r2.removeAllStoredErrorLogFiles(r1)
                                        goto L_0x0011
                                    L_0x0026:
                                        java.io.File r0 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getPendingMinidumpDirectory()
                                        java.io.File[] r0 = r0.listFiles()
                                        if (r0 == 0) goto L_0x0112
                                        int r1 = r0.length
                                        r2 = 0
                                    L_0x0032:
                                        if (r2 >= r1) goto L_0x0112
                                        r3 = r0[r2]
                                        com.microsoft.appcenter.utils.storage.FileManager.deleteDirectory(r3)
                                        int r2 = r2 + 1
                                        goto L_0x0032
                                    L_0x003c:
                                        r2 = 2
                                        if (r0 != r2) goto L_0x0044
                                        java.lang.String r0 = "com.microsoft.appcenter.crashes.always.send"
                                        com.microsoft.appcenter.utils.storage.SharedPreferencesManager.putBoolean(r0, r1)
                                    L_0x0044:
                                        com.microsoft.appcenter.crashes.Crashes r0 = com.microsoft.appcenter.crashes.Crashes.this
                                        java.util.Map<java.util.UUID, com.microsoft.appcenter.crashes.Crashes$ErrorLogReport> r0 = r0.mUnprocessedErrorReports
                                        java.util.Set r0 = r0.entrySet()
                                        java.util.Iterator r0 = r0.iterator()
                                    L_0x0050:
                                        boolean r1 = r0.hasNext()
                                        if (r1 == 0) goto L_0x0112
                                        java.lang.Object r1 = r0.next()
                                        java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                                        java.lang.Object r3 = r1.getValue()
                                        com.microsoft.appcenter.crashes.Crashes$ErrorLogReport r3 = (com.microsoft.appcenter.crashes.Crashes.ErrorLogReport) r3
                                        com.microsoft.appcenter.crashes.model.ErrorReport r4 = r3.report
                                        com.microsoft.appcenter.ingestion.models.Device r4 = r4.device
                                        r5 = 0
                                        if (r4 == 0) goto L_0x00cd
                                        java.lang.String r4 = r4.wrapperSdkName
                                        java.lang.String r6 = "appcenter.ndk"
                                        boolean r4 = r6.equals(r4)
                                        if (r4 == 0) goto L_0x00cd
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r4 = r3.log
                                        com.microsoft.appcenter.crashes.ingestion.models.Exception r4 = r4.exception
                                        java.lang.String r6 = r4.minidumpFilePath
                                        r4.minidumpFilePath = r5
                                        if (r6 != 0) goto L_0x0081
                                        java.lang.String r6 = r4.stackTrace
                                        r4.stackTrace = r5
                                    L_0x0081:
                                        if (r6 == 0) goto L_0x00c6
                                        java.io.File r4 = new java.io.File
                                        r4.<init>(r6)
                                        long r6 = r4.length()
                                        int r7 = (int) r6
                                        byte[] r6 = new byte[r7]
                                        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a6 }
                                        r7.<init>(r4)     // Catch:{ IOException -> 0x00a6 }
                                        java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ all -> 0x00a1 }
                                        r8.<init>(r7)     // Catch:{ all -> 0x00a1 }
                                        r8.readFully(r6)     // Catch:{ all -> 0x00a1 }
                                        r7.close()     // Catch:{ IOException -> 0x00a6 }
                                        r5 = r6
                                        goto L_0x00bd
                                    L_0x00a1:
                                        r6 = move-exception
                                        r7.close()     // Catch:{ IOException -> 0x00a6 }
                                        throw r6     // Catch:{ IOException -> 0x00a6 }
                                    L_0x00a6:
                                        r6 = move-exception
                                        java.lang.String r7 = "Could not read file "
                                        java.lang.StringBuilder r7 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r7)
                                        java.lang.String r8 = r4.getAbsolutePath()
                                        r7.append(r8)
                                        java.lang.String r7 = r7.toString()
                                        java.lang.String r8 = "AppCenter"
                                        com.microsoft.appcenter.utils.AppCenterLog.error(r8, r7, r6)
                                    L_0x00bd:
                                        java.lang.String r6 = "minidump.dmp"
                                        java.lang.String r7 = "application/octet-stream"
                                        com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog r5 = com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog.attachmentWithBinary(r5, r6, r7)
                                        goto L_0x00ce
                                    L_0x00c6:
                                        java.lang.String r4 = "AppCenterCrashes"
                                        java.lang.String r6 = "NativeException found without minidump."
                                        com.microsoft.appcenter.utils.AppCenterLog.warn(r4, r6)
                                    L_0x00cd:
                                        r4 = r5
                                    L_0x00ce:
                                        com.microsoft.appcenter.crashes.Crashes r6 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.channel.Channel r6 = r6.mChannel
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r7 = r3.log
                                        com.microsoft.appcenter.channel.DefaultChannel r6 = (com.microsoft.appcenter.channel.DefaultChannel) r6
                                        java.lang.String r8 = "groupErrors"
                                        r6.enqueue(r7, r8, r2)
                                        if (r5 == 0) goto L_0x00ed
                                        com.microsoft.appcenter.crashes.Crashes r6 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r7 = r3.log
                                        java.util.UUID r7 = r7.f3577id
                                        java.util.Set r5 = java.util.Collections.singleton(r5)
                                        com.microsoft.appcenter.crashes.Crashes.access$800(r6, r7, r5)
                                        r4.delete()
                                    L_0x00ed:
                                        com.microsoft.appcenter.crashes.Crashes r4 = com.microsoft.appcenter.crashes.Crashes.this
                                        boolean r5 = r4.mAutomaticProcessing
                                        if (r5 == 0) goto L_0x0104
                                        com.microsoft.appcenter.crashes.AbstractCrashesListener r4 = r4.mCrashesListener
                                        com.microsoft.appcenter.crashes.model.ErrorReport r5 = r3.report
                                        java.lang.Iterable r4 = r4.getErrorAttachments(r5)
                                        com.microsoft.appcenter.crashes.Crashes r5 = com.microsoft.appcenter.crashes.Crashes.this
                                        com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r3 = r3.log
                                        java.util.UUID r3 = r3.f3577id
                                        com.microsoft.appcenter.crashes.Crashes.access$800(r5, r3, r4)
                                    L_0x0104:
                                        r0.remove()
                                        java.lang.Object r1 = r1.getKey()
                                        java.util.UUID r1 = (java.util.UUID) r1
                                        com.microsoft.appcenter.crashes.utils.ErrorLogHelper.removeStoredErrorLogFile(r1)
                                        goto L_0x0050
                                    L_0x0112:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.crashes.Crashes.C295112.run():void");
                                }
                            });
                        }
                    } else {
                        AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned true, wait sending logs.");
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011e, code lost:
        r10.delete();
        removeAllStoredErrorLogFiles(r4.f3577id);
        com.microsoft.appcenter.utils.AppCenterLog.error("AppCenterCrashes", "Failed to process new minidump file: " + r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009c A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bf A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0114 A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0115 A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processSingleMinidump(java.io.File r10, java.io.File r11) {
        /*
            r9 = this;
            java.lang.String r0 = "AppCenterCrashes"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Process pending minidump file: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.microsoft.appcenter.utils.AppCenterLog.debug(r0, r1)
            long r0 = r10.lastModified()
            java.io.File r2 = new java.io.File
            java.io.File r3 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getPendingMinidumpDirectory()
            java.lang.String r4 = r10.getName()
            r2.<init>(r3, r4)
            com.microsoft.appcenter.crashes.ingestion.models.Exception r3 = new com.microsoft.appcenter.crashes.ingestion.models.Exception
            r3.<init>()
            java.lang.String r4 = "minidump"
            r3.type = r4
            java.lang.String r4 = "appcenter.ndk"
            r3.wrapperSdkName = r4
            java.lang.String r4 = r2.getPath()
            r3.minidumpFilePath = r4
            com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r4 = new com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog
            r4.<init>()
            r4.exception = r3
            java.util.Date r3 = new java.util.Date
            r3.<init>(r0)
            r4.timestamp = r3
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4.fatal = r3
            boolean r3 = r11.isDirectory()
            r5 = 0
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = r11.getName()     // Catch:{ IllegalArgumentException -> 0x005c }
            java.util.UUID r3 = java.util.UUID.fromString(r3)     // Catch:{ IllegalArgumentException -> 0x005c }
            goto L_0x0065
        L_0x005c:
            r3 = move-exception
            java.lang.String r6 = "AppCenterCrashes"
            java.lang.String r7 = "Cannot parse minidump folder name to UUID."
            com.microsoft.appcenter.utils.AppCenterLog.warn(r6, r7, r3)
        L_0x0064:
            r3 = r5
        L_0x0065:
            if (r3 != 0) goto L_0x006b
            java.util.UUID r3 = java.util.UUID.randomUUID()
        L_0x006b:
            r4.f3577id = r3
            com.microsoft.appcenter.utils.context.SessionContext r3 = com.microsoft.appcenter.utils.context.SessionContext.getInstance()
            com.microsoft.appcenter.utils.context.SessionContext$SessionInfo r3 = r3.getSessionAt(r0)
            if (r3 == 0) goto L_0x0087
            long r6 = r3.mAppLaunchTimestamp
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 > 0) goto L_0x0087
            java.util.Date r0 = new java.util.Date
            long r6 = r3.mAppLaunchTimestamp
            r0.<init>(r6)
            r4.appLaunchTimestamp = r0
            goto L_0x008b
        L_0x0087:
            java.util.Date r0 = r4.timestamp
            r4.appLaunchTimestamp = r0
        L_0x008b:
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.processId = r0
            java.lang.String r0 = ""
            r4.processName = r0
            java.lang.String r0 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getContextInformation(r11)     // Catch:{ Exception -> 0x011d }
            if (r0 != 0) goto L_0x009d
            goto L_0x00b7
        L_0x009d:
            java.lang.String r1 = "USER_ID"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00af }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x00af }
            boolean r0 = r3.has(r1)     // Catch:{ JSONException -> 0x00af }
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r3.getString(r1)     // Catch:{ JSONException -> 0x00af }
            goto L_0x00b8
        L_0x00af:
            r0 = move-exception
            java.lang.String r1 = "AppCenterCrashes"
            java.lang.String r3 = "Failed to deserialize user info."
            com.microsoft.appcenter.utils.AppCenterLog.error(r1, r3, r0)     // Catch:{ Exception -> 0x011d }
        L_0x00b7:
            r0 = r5
        L_0x00b8:
            java.lang.String r11 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getContextInformation(r11)     // Catch:{ Exception -> 0x011d }
            if (r11 != 0) goto L_0x00bf
            goto L_0x00e8
        L_0x00bf:
            java.lang.String r1 = "DEVICE_INFO"
            com.microsoft.appcenter.ingestion.models.Device r3 = new com.microsoft.appcenter.ingestion.models.Device     // Catch:{ JSONException -> 0x00e0 }
            r3.<init>()     // Catch:{ JSONException -> 0x00e0 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e0 }
            r6.<init>(r11)     // Catch:{ JSONException -> 0x00e0 }
            boolean r11 = r6.has(r1)     // Catch:{ JSONException -> 0x00e0 }
            if (r11 == 0) goto L_0x00db
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r1 = r6.getString(r1)     // Catch:{ JSONException -> 0x00e0 }
            r11.<init>(r1)     // Catch:{ JSONException -> 0x00e0 }
            r6 = r11
        L_0x00db:
            r3.read(r6)     // Catch:{ JSONException -> 0x00e0 }
            r5 = r3
            goto L_0x00e8
        L_0x00e0:
            r11 = move-exception
            java.lang.String r1 = "AppCenterCrashes"
            java.lang.String r3 = "Failed to deserialize device info."
            com.microsoft.appcenter.utils.AppCenterLog.error(r1, r3, r11)     // Catch:{ Exception -> 0x011d }
        L_0x00e8:
            if (r5 != 0) goto L_0x0102
            android.content.Context r11 = r9.mContext     // Catch:{ Exception -> 0x011d }
            monitor-enter(r9)     // Catch:{ Exception -> 0x011d }
            com.microsoft.appcenter.ingestion.models.Device r1 = r9.mDevice     // Catch:{ all -> 0x00ff }
            if (r1 != 0) goto L_0x00f7
            com.microsoft.appcenter.ingestion.models.Device r11 = com.microsoft.appcenter.utils.DeviceInfoHelper.getDeviceInfo(r11)     // Catch:{ all -> 0x00ff }
            r9.mDevice = r11     // Catch:{ all -> 0x00ff }
        L_0x00f7:
            com.microsoft.appcenter.ingestion.models.Device r5 = r9.mDevice     // Catch:{ all -> 0x00ff }
            monitor-exit(r9)     // Catch:{ Exception -> 0x011d }
            java.lang.String r11 = "appcenter.ndk"
            r5.wrapperSdkName = r11     // Catch:{ Exception -> 0x011d }
            goto L_0x0102
        L_0x00ff:
            r11 = move-exception
            monitor-exit(r9)     // Catch:{ Exception -> 0x011d }
            throw r11     // Catch:{ Exception -> 0x011d }
        L_0x0102:
            r4.device = r5     // Catch:{ Exception -> 0x011d }
            r4.userId = r0     // Catch:{ Exception -> 0x011d }
            com.microsoft.appcenter.crashes.model.NativeException r11 = new com.microsoft.appcenter.crashes.model.NativeException     // Catch:{ Exception -> 0x011d }
            r11.<init>()     // Catch:{ Exception -> 0x011d }
            r9.saveErrorLogFiles(r4)     // Catch:{ Exception -> 0x011d }
            boolean r11 = r10.renameTo(r2)     // Catch:{ Exception -> 0x011d }
            if (r11 == 0) goto L_0x0115
            goto L_0x013c
        L_0x0115:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x011d }
            java.lang.String r0 = "Failed to move file"
            r11.<init>(r0)     // Catch:{ Exception -> 0x011d }
            throw r11     // Catch:{ Exception -> 0x011d }
        L_0x011d:
            r11 = move-exception
            r10.delete()
            java.util.UUID r0 = r4.f3577id
            r9.removeAllStoredErrorLogFiles(r0)
            java.lang.String r0 = "AppCenterCrashes"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to process new minidump file: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.microsoft.appcenter.utils.AppCenterLog.error(r0, r10, r11)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.crashes.Crashes.processSingleMinidump(java.io.File, java.io.File):void");
    }

    public final void removeAllStoredErrorLogFiles(UUID uuid) {
        ErrorLogHelper.removeStoredErrorLogFile(uuid);
        this.mErrorReportCache.remove(uuid);
        WrapperSdkExceptionManager.deleteWrapperExceptionData(uuid);
    }

    @NonNull
    public final UUID saveErrorLogFiles(ManagedErrorLog managedErrorLog) throws JSONException, IOException {
        File errorStorageDirectory = ErrorLogHelper.getErrorStorageDirectory();
        UUID uuid = managedErrorLog.f3577id;
        String uuid2 = uuid.toString();
        AppCenterLog.debug("AppCenterCrashes", "Saving uncaught exception.");
        File file = new File(errorStorageDirectory, GeneratedOutlineSupport.outline16(uuid2, ".json"));
        FileManager.write(file, this.mLogSerializer.serializeLog(managedErrorLog));
        AppCenterLog.debug("AppCenterCrashes", "Saved JSON content for ingestion into " + file);
        return uuid;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|52) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0015 A[LOOP:0: B:5:0x0015->B:6:?, LOOP_START, SYNTHETIC, Splitter:B:5:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.UUID saveUncaughtException(java.lang.Thread r8, java.lang.Throwable r9, com.microsoft.appcenter.crashes.ingestion.models.Exception r10) throws org.json.JSONException, java.io.IOException {
        /*
            r7 = this;
            com.microsoft.appcenter.crashes.Crashes r9 = getInstance()
            monitor-enter(r9)
            com.microsoft.appcenter.utils.async.DefaultAppCenterFuture r0 = new com.microsoft.appcenter.utils.async.DefaultAppCenterFuture     // Catch:{ all -> 0x0121 }
            r0.<init>()     // Catch:{ all -> 0x0121 }
            com.microsoft.appcenter.AbstractAppCenterService$1 r1 = new com.microsoft.appcenter.AbstractAppCenterService$1     // Catch:{ all -> 0x0121 }
            r1.<init>(r9, r0)     // Catch:{ all -> 0x0121 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0121 }
            r9.postAsyncGetter(r1, r0, r2)     // Catch:{ all -> 0x0121 }
            monitor-exit(r9)
        L_0x0015:
            java.util.concurrent.CountDownLatch r9 = r0.mLatch     // Catch:{ InterruptedException -> 0x0015 }
            r9.await()     // Catch:{ InterruptedException -> 0x0015 }
            T r9 = r0.mResult
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0 = 0
            if (r9 != 0) goto L_0x0026
            return r0
        L_0x0026:
            boolean r9 = r7.mSavedUncaughtException
            if (r9 == 0) goto L_0x002b
            return r0
        L_0x002b:
            r9 = 1
            r7.mSavedUncaughtException = r9
            android.content.Context r9 = r7.mContext
            java.util.Map r0 = java.lang.Thread.getAllStackTraces()
            long r1 = r7.mInitializeTimestamp
            com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog r3 = new com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog
            r3.<init>()
            java.util.UUID r4 = java.util.UUID.randomUUID()
            r3.f3577id = r4
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            r3.timestamp = r4
            com.microsoft.appcenter.utils.context.UserIdContext r4 = com.microsoft.appcenter.utils.context.UserIdContext.getInstance()
            monitor-enter(r4)
            java.lang.String r5 = r4.mUserId     // Catch:{ all -> 0x011e }
            monitor-exit(r4)
            r3.userId = r5
            com.microsoft.appcenter.ingestion.models.Device r4 = com.microsoft.appcenter.utils.DeviceInfoHelper.getDeviceInfo(r9)     // Catch:{ DeviceInfoException -> 0x0059 }
            r3.device = r4     // Catch:{ DeviceInfoException -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r4 = move-exception
            java.lang.String r5 = "AppCenterCrashes"
            java.lang.String r6 = "Could not attach device properties snapshot to error log, will attach at sending time"
            com.microsoft.appcenter.utils.AppCenterLog.error(r5, r6, r4)
        L_0x0061:
            int r4 = android.os.Process.myPid()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.processId = r4
            java.lang.String r4 = "activity"
            java.lang.Object r9 = r9.getSystemService(r4)
            android.app.ActivityManager r9 = (android.app.ActivityManager) r9
            if (r9 == 0) goto L_0x0098
            java.util.List r9 = r9.getRunningAppProcesses()
            if (r9 == 0) goto L_0x0098
            java.util.Iterator r9 = r9.iterator()
        L_0x007f:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r9.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            int r6 = android.os.Process.myPid()
            if (r5 != r6) goto L_0x007f
            java.lang.String r4 = r4.processName
            r3.processName = r4
            goto L_0x007f
        L_0x0098:
            java.lang.String r9 = r3.processName
            if (r9 != 0) goto L_0x00a0
            java.lang.String r9 = ""
            r3.processName = r9
        L_0x00a0:
            int r9 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r9 < r4) goto L_0x00ac
            java.lang.String[] r9 = android.os.Build.SUPPORTED_ABIS
            r4 = 0
            r9 = r9[r4]
            goto L_0x00ae
        L_0x00ac:
            java.lang.String r9 = android.os.Build.CPU_ABI
        L_0x00ae:
            r3.architecture = r9
            long r4 = r8.getId()
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            r3.errorThreadId = r9
            java.lang.String r8 = r8.getName()
            r3.errorThreadName = r8
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r3.fatal = r8
            java.util.Date r8 = new java.util.Date
            r8.<init>(r1)
            r3.appLaunchTimestamp = r8
            r3.exception = r10
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = r0.size()
            r8.<init>(r9)
            java.util.Set r9 = r0.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x00de:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0117
            java.lang.Object r10 = r9.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            com.microsoft.appcenter.crashes.ingestion.models.Thread r0 = new com.microsoft.appcenter.crashes.ingestion.models.Thread
            r0.<init>()
            java.lang.Object r1 = r10.getKey()
            java.lang.Thread r1 = (java.lang.Thread) r1
            long r1 = r1.getId()
            r0.f3580id = r1
            java.lang.Object r1 = r10.getKey()
            java.lang.Thread r1 = (java.lang.Thread) r1
            java.lang.String r1 = r1.getName()
            r0.name = r1
            java.lang.Object r10 = r10.getValue()
            java.lang.StackTraceElement[] r10 = (java.lang.StackTraceElement[]) r10
            java.util.List r10 = com.microsoft.appcenter.crashes.utils.ErrorLogHelper.getModelFramesFromStackTrace(r10)
            r0.frames = r10
            r8.add(r0)
            goto L_0x00de
        L_0x0117:
            r3.threads = r8
            java.util.UUID r8 = r7.saveErrorLogFiles(r3)
            return r8
        L_0x011e:
            r8 = move-exception
            monitor-exit(r4)
            throw r8
        L_0x0121:
            r8 = move-exception
            monitor-exit(r9)
            goto L_0x0125
        L_0x0124:
            throw r8
        L_0x0125:
            goto L_0x0124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.crashes.Crashes.saveUncaughtException(java.lang.Thread, java.lang.Throwable, com.microsoft.appcenter.crashes.ingestion.models.Exception):java.util.UUID");
    }

    @VisibleForTesting
    public synchronized void setInstanceListener(AbstractCrashesListener abstractCrashesListener) {
        if (abstractCrashesListener == null) {
            abstractCrashesListener = DEFAULT_ERROR_REPORTING_LISTENER;
        }
        this.mCrashesListener = abstractCrashesListener;
    }
}
