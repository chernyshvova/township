package com.microsoft.appcenter.analytics.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;

public class CommonSchemaEventLog extends CommonSchemaLog {
    public String getType() {
        return "commonSchemaEvent";
    }
}
