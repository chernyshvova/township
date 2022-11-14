package com.helpshift.util.concurrent;

public class ApiExecutorFactory {

    public static class LazyHolder {
        public static final ApiExecutor HANDLER_EXECUTOR = new HandlerThreadExecutor("HS-cm-api-exec");
    }

    public static ApiExecutor getHandlerExecutor() {
        return LazyHolder.HANDLER_EXECUTOR;
    }
}
