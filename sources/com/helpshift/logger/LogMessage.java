package com.helpshift.logger;

import com.helpshift.logger.logmodels.ILogExtrasModel;

/* compiled from: Logger */
public class LogMessage {
    public ILogExtrasModel[] extras;
    public String level;
    public String message;
    public String sdkVersion;
    public String stacktrace;
    public long timeStamp;
}
