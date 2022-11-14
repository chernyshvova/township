package com.microsoft.appcenter.crashes.model;

public class NativeException extends RuntimeException {
    public NativeException() {
        super("Native exception read from a minidump file");
    }
}
