package com.helpshift.common.domain;

import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.util.HSLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class BackgroundThreader implements Threader {
    public static final String TAG = "Helpshift_CoreBgTh";
    public final ExecutorService service;

    public BackgroundThreader(ExecutorService executorService) {
        this.service = executorService;
    }

    public C2500F thread(final C2500F f) {
        return new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                f.cause = new Throwable();
                try {
                    BackgroundThreader.this.service.submit(new Runnable() {
                        public void run() {
                            try {
                                f.mo33949f();
                            } catch (RootAPIException e) {
                                if (e.shouldLog()) {
                                    ILogExtrasModel iLogExtrasModel = null;
                                    String str = e.message;
                                    if (str == null) {
                                        str = "";
                                    }
                                    ExceptionType exceptionType = e.exceptionType;
                                    if (exceptionType instanceof NetworkException) {
                                        iLogExtrasModel = LogExtrasModelProvider.fromString("route", ((NetworkException) exceptionType).route);
                                    }
                                    HSLogger.m3244e(BackgroundThreader.TAG, str, new Throwable[]{e.exception, f.cause}, iLogExtrasModel);
                                }
                            } catch (Exception e2) {
                                HSLogger.m3246f(BackgroundThreader.TAG, "Caught unhandled exception inside BackgroundThreader", new Throwable[]{e2, f.cause}, new ILogExtrasModel[0]);
                            }
                        }
                    });
                } catch (RejectedExecutionException e) {
                    HSLogger.m3242e(BackgroundThreader.TAG, "Rejected execution of task in BackgroundThreader", e);
                }
            }
        };
    }
}
