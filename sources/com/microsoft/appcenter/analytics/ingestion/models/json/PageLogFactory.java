package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class PageLogFactory extends AbstractLogFactory {
    public Log create() {
        return new PageLog();
    }
}
