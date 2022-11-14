package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.AbstractLog;

public class StartSessionLog extends AbstractLog {
    public String getType() {
        return "startSession";
    }
}
