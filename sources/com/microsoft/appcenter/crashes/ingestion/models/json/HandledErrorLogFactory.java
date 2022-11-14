package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class HandledErrorLogFactory extends AbstractLogFactory {
    public static final HandledErrorLogFactory sInstance = new HandledErrorLogFactory();

    public Log create() {
        return new HandledErrorLog();
    }
}
