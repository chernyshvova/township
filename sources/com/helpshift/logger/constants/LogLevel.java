package com.helpshift.logger.constants;

public enum LogLevel {
    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    DEBUG(4);
    
    public int value;

    /* access modifiers changed from: public */
    LogLevel(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
