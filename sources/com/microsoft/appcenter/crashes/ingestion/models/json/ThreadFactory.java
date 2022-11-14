package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.Thread;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class ThreadFactory implements ModelFactory<Thread> {
    public static final ThreadFactory sInstance = new ThreadFactory();

    public Model create() {
        return new Thread();
    }

    public List<Thread> createList(int i) {
        return new ArrayList(i);
    }
}
