package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ErrorAttachmentLogFactory extends AbstractLogFactory {
    public static final ErrorAttachmentLogFactory sInstance = new ErrorAttachmentLogFactory();

    public Log create() {
        return new ErrorAttachmentLog();
    }
}
