package com.vungle.warren.utility;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTimeoutProvider implements TimeoutProvider {
    public static final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    public long getTimeout() {
        return ThreadUtil.isMainThread() ? OPERATION_TIMEOUT : RecyclerView.FOREVER_NS;
    }
}
