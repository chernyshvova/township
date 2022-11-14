package com.helpshift.common.exception;

public class RootAPIException extends RuntimeException {
    public final Exception exception;
    public final ExceptionType exceptionType;
    public final String message;

    public RootAPIException(Exception exc, ExceptionType exceptionType2, String str) {
        super(str, exc);
        this.exception = exc;
        this.exceptionType = exceptionType2;
        this.message = str;
    }

    public static RootAPIException wrap(Exception exc) {
        return wrap(exc, (ExceptionType) null);
    }

    public int getServerStatusCode() {
        ExceptionType exceptionType2 = this.exceptionType;
        if (exceptionType2 instanceof NetworkException) {
            return ((NetworkException) exceptionType2).serverStatusCode;
        }
        return 0;
    }

    public boolean shouldLog() {
        return this.exception != null;
    }

    public static RootAPIException wrap(Exception exc, ExceptionType exceptionType2) {
        return wrap(exc, exceptionType2, (String) null);
    }

    public static RootAPIException wrap(Exception exc, ExceptionType exceptionType2, String str) {
        if (exc instanceof RootAPIException) {
            RootAPIException rootAPIException = (RootAPIException) exc;
            Exception exc2 = rootAPIException.exception;
            if (exceptionType2 == null) {
                exceptionType2 = rootAPIException.exceptionType;
            }
            if (str == null) {
                str = rootAPIException.message;
            }
            exc = exc2;
        } else if (exceptionType2 == null) {
            exceptionType2 = UnexpectedException.GENERIC;
        }
        return new RootAPIException(exc, exceptionType2, str);
    }
}
