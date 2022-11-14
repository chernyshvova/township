package com.helpshift.common.domain;

import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.util.HSLogger;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackgroundDelayedThreader implements DelayedThreader {
    public static final String TAG = "Helpshift_CoreDelayTh";
    public final ScheduledExecutorService service;

    public BackgroundDelayedThreader(ScheduledExecutorService scheduledExecutorService) {
        this.service = scheduledExecutorService;
    }

    public C2500F thread(final C2500F f, final long j) {
        return new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                f.cause = new Throwable();
                try {
                    BackgroundDelayedThreader.this.service.schedule(new Runnable() {
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
                                    HSLogger.m3244e(BackgroundDelayedThreader.TAG, str, new Throwable[]{e.exception, f.cause}, iLogExtrasModel);
                                }
                            } catch (Exception e2) {
                                HSLogger.m3246f(BackgroundDelayedThreader.TAG, "Caught unhandled exception inside BackgroundThreader", new Throwable[]{e2, f.cause}, new ILogExtrasModel[0]);
                            }
                        }
                    }, j, TimeUnit.MILLISECONDS);
                } catch (RejectedExecutionException e) {
                    HSLogger.m3242e(BackgroundDelayedThreader.TAG, "Rejected execution of task in BackgroundDelayedThreader", e);
                }
            }
        };
    }
}
