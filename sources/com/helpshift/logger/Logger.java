package com.helpshift.logger;

import android.content.Context;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.logger.constants.LogLevel;
import com.helpshift.logger.database.LogSQLiteStorage;
import com.helpshift.logger.database.LogStorage;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.model.LogModel;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Logger implements ILogger {
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    public static final String FATAL = "FATAL";
    public static final int MAX_EXTRAS_COUNT = 20;
    public static final int MAX_LOG_SIZE = 5000;
    public static final String WARN = "WARN";
    public final String TAG = Logger.class.getSimpleName();
    public int consoleLoggingLevel = 4;
    public boolean enableConsoleLogging;
    public boolean enableLogCaching;
    public LogStorage logStorage;
    public int requiredLogCachingLevel = LogLevel.FATAL.getValue();
    public final String sdkVersion;
    public final SimpleDateFormat simpleDateFormat;
    public ThreadPoolExecutor threadPoolExecutor;
    public long timestampDelta;

    public Logger(Context context, String str, String str2) {
        this.logStorage = new LogSQLiteStorage(context, str);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.simpleDateFormat = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.sdkVersion = str2;
    }

    private boolean containsUnknownHostException(Throwable[] thArr) {
        if (thArr == null) {
            return false;
        }
        for (Throwable th : thArr) {
            if (th instanceof UnknownHostException) {
                return true;
            }
        }
        return false;
    }

    private List<String> convertMaskToLogLevel(int i) {
        if (i == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 8) != 0) {
            arrayList.add(ERROR);
        }
        if ((i & 4) != 0) {
            arrayList.add(WARN);
        }
        if ((i & 16) != 0) {
            arrayList.add(FATAL);
        }
        return arrayList;
    }

    private String getExtrasForConsoleLogging(ILogExtrasModel[] iLogExtrasModelArr) {
        if (iLogExtrasModelArr == null || iLogExtrasModelArr.length <= 0) {
            return " ";
        }
        StringBuilder sb = new StringBuilder(" ");
        for (ILogExtrasModel iLogExtrasModel : iLogExtrasModelArr) {
            if (iLogExtrasModel != null) {
                sb.append(iLogExtrasModel.getConsoleLoggingMessage());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String getStackTraceString(Throwable[] thArr) {
        if (thArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (containsUnknownHostException(thArr)) {
            return "UnknownHostException";
        }
        for (Throwable stackTraceString : thArr) {
            sb.append(Log.getStackTraceString(stackTraceString));
        }
        return sb.toString();
    }

    private boolean isConsoleLoggingEnabled() {
        return this.enableConsoleLogging;
    }

    private Future logMessageToDatabase(String str, String str2, String str3, ILogExtrasModel[] iLogExtrasModelArr) {
        LogMessage logMessage = new LogMessage();
        logMessage.level = str;
        logMessage.extras = iLogExtrasModelArr;
        logMessage.message = str2;
        logMessage.timeStamp = System.currentTimeMillis() + this.timestampDelta;
        logMessage.stacktrace = str3;
        logMessage.sdkVersion = this.sdkVersion;
        try {
            return this.threadPoolExecutor.submit(new WorkerThread(logMessage, this.logStorage, this.simpleDateFormat));
        } catch (RejectedExecutionException e) {
            String str4 = this.TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rejected execution of log message : ");
            outline24.append(logMessage.message);
            Log.e(str4, outline24.toString(), e);
            return null;
        }
    }

    private boolean shouldAddLogToDatabase(LogLevel logLevel) {
        return this.enableLogCaching && logLevel.getValue() <= this.requiredLogCachingLevel;
    }

    /* renamed from: d */
    public void mo35415d(String str, String str2) {
        mo35418d(str, str2, (Throwable[]) null, (ILogExtrasModel[]) null);
    }

    public void deleteAllCachedLogs() {
        this.logStorage.deleteAll();
    }

    /* renamed from: e */
    public void mo35420e(String str, String str2) {
        mo35423e(str, str2, (Throwable[]) null, (ILogExtrasModel[]) null);
    }

    public void enableLogging(boolean z, boolean z2) {
        this.enableConsoleLogging = z;
        if (this.enableLogCaching != z2) {
            this.enableLogCaching = z2;
            if (z2) {
                this.threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "HS-Logger");
                    }
                });
                return;
            }
            ThreadPoolExecutor threadPoolExecutor2 = this.threadPoolExecutor;
            if (threadPoolExecutor2 != null) {
                threadPoolExecutor2.shutdown();
            }
        }
    }

    /* renamed from: f */
    public void mo35425f(String str, String str2, Throwable[] thArr) {
        mo35426f(str, str2, thArr, (ILogExtrasModel[]) null);
    }

    public List<LogModel> getAll() {
        return this.logStorage.getAll();
    }

    public void setConsoleLoggingLevel(int i) {
        this.consoleLoggingLevel = i;
    }

    public void setLogCachingLevel(int i) {
        this.requiredLogCachingLevel = i;
    }

    public void setTimestampDelta(long j) {
        this.timestampDelta = j;
    }

    /* renamed from: w */
    public void mo35431w(String str, String str2) {
        mo35434w(str, str2, (Throwable[]) null, (ILogExtrasModel[]) null);
    }

    /* renamed from: d */
    public void mo35417d(String str, String str2, Throwable[] thArr) {
        mo35418d(str, str2, thArr, (ILogExtrasModel[]) null);
    }

    /* renamed from: e */
    public void mo35422e(String str, String str2, Throwable[] thArr) {
        mo35423e(str, str2, thArr, (ILogExtrasModel[]) null);
    }

    /* renamed from: f */
    public void mo35426f(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        String str3;
        if (!isConsoleLoggingEnabled() || this.consoleLoggingLevel > 16) {
            str3 = null;
        } else {
            str3 = getStackTraceString(thArr);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(str2);
            outline24.append(getExtrasForConsoleLogging(iLogExtrasModelArr));
            outline24.append(str3);
            Log.e(str, outline24.toString());
        }
        if (shouldAddLogToDatabase(LogLevel.FATAL)) {
            if (str3 == null) {
                str3 = getStackTraceString(thArr);
            }
            Future logMessageToDatabase = logMessageToDatabase(FATAL, str2, str3, iLogExtrasModelArr);
            if (logMessageToDatabase != null) {
                try {
                    logMessageToDatabase.get();
                } catch (Exception e) {
                    String str4 = this.TAG;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Error logging fatal log : ");
                    outline242.append(e.getMessage());
                    Log.e(str4, outline242.toString());
                }
            }
        }
    }

    /* renamed from: w */
    public void mo35433w(String str, String str2, Throwable[] thArr) {
        mo35434w(str, str2, thArr, (ILogExtrasModel[]) null);
    }

    /* renamed from: d */
    public void mo35416d(String str, String str2, ILogExtrasModel... iLogExtrasModelArr) {
        mo35418d(str, str2, (Throwable[]) null, iLogExtrasModelArr);
    }

    /* renamed from: e */
    public void mo35421e(String str, String str2, ILogExtrasModel... iLogExtrasModelArr) {
        mo35423e(str, str2, (Throwable[]) null, iLogExtrasModelArr);
    }

    /* renamed from: w */
    public void mo35432w(String str, String str2, ILogExtrasModel... iLogExtrasModelArr) {
        mo35434w(str, str2, (Throwable[]) null, iLogExtrasModelArr);
    }

    /* renamed from: d */
    public void mo35418d(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        if (isConsoleLoggingEnabled() && this.consoleLoggingLevel <= 2) {
            String stackTraceString = getStackTraceString(thArr);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(str2);
            outline24.append(getExtrasForConsoleLogging(iLogExtrasModelArr));
            outline24.append(stackTraceString);
            Log.d(str, outline24.toString());
        }
    }

    /* renamed from: e */
    public void mo35423e(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        String str3;
        if (!isConsoleLoggingEnabled() || this.consoleLoggingLevel > 8) {
            str3 = null;
        } else {
            str3 = getStackTraceString(thArr);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(str2);
            outline24.append(getExtrasForConsoleLogging(iLogExtrasModelArr));
            outline24.append(str3);
            Log.e(str, outline24.toString());
        }
        if (shouldAddLogToDatabase(LogLevel.ERROR) && !containsUnknownHostException(thArr)) {
            if (str3 == null) {
                str3 = getStackTraceString(thArr);
            }
            logMessageToDatabase(ERROR, str2, str3, iLogExtrasModelArr);
        }
    }

    /* renamed from: w */
    public void mo35434w(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        String str3;
        if (!isConsoleLoggingEnabled() || this.consoleLoggingLevel > 4) {
            str3 = null;
        } else {
            str3 = getStackTraceString(thArr);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24(str2);
            outline24.append(getExtrasForConsoleLogging(iLogExtrasModelArr));
            outline24.append(str3);
            Log.w(str, outline24.toString());
        }
        if (shouldAddLogToDatabase(LogLevel.WARN)) {
            if (str3 == null) {
                str3 = getStackTraceString(thArr);
            }
            logMessageToDatabase(WARN, str2, str3, iLogExtrasModelArr);
        }
    }
}
