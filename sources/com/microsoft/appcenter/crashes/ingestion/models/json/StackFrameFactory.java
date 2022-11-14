package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class StackFrameFactory implements ModelFactory<StackFrame> {
    public static final StackFrameFactory sInstance = new StackFrameFactory();

    public Model create() {
        return new StackFrame();
    }

    public List<StackFrame> createList(int i) {
        return new ArrayList(i);
    }
}
