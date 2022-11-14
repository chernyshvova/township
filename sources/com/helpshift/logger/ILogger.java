package com.helpshift.logger;

import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.model.LogModel;
import java.util.List;

public interface ILogger {
    public static final int DEBUG = 2;
    public static final int ERROR = 8;
    public static final int FATAL = 16;
    public static final int WARN = 4;

    /* renamed from: d */
    void mo35415d(String str, String str2);

    /* renamed from: d */
    void mo35416d(String str, String str2, ILogExtrasModel... iLogExtrasModelArr);

    /* renamed from: d */
    void mo35417d(String str, String str2, Throwable[] thArr);

    /* renamed from: d */
    void mo35418d(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr);

    void deleteAllCachedLogs();

    /* renamed from: e */
    void mo35420e(String str, String str2);

    /* renamed from: e */
    void mo35421e(String str, String str2, ILogExtrasModel... iLogExtrasModelArr);

    /* renamed from: e */
    void mo35422e(String str, String str2, Throwable[] thArr);

    /* renamed from: e */
    void mo35423e(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr);

    void enableLogging(boolean z, boolean z2);

    /* renamed from: f */
    void mo35425f(String str, String str2, Throwable[] thArr);

    /* renamed from: f */
    void mo35426f(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr);

    List<LogModel> getAll();

    void setConsoleLoggingLevel(int i);

    void setLogCachingLevel(int i);

    void setTimestampDelta(long j);

    /* renamed from: w */
    void mo35431w(String str, String str2);

    /* renamed from: w */
    void mo35432w(String str, String str2, ILogExtrasModel... iLogExtrasModelArr);

    /* renamed from: w */
    void mo35433w(String str, String str2, Throwable[] thArr);

    /* renamed from: w */
    void mo35434w(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr);
}
