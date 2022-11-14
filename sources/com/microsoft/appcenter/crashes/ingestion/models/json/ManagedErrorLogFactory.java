package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ManagedErrorLogFactory extends AbstractLogFactory {
    public static final ManagedErrorLogFactory sInstance = new ManagedErrorLogFactory();

    public Log create() {
        return new ManagedErrorLog();
    }
}
