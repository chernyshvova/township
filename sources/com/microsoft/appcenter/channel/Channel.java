package com.microsoft.appcenter.channel;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.ingestion.models.Log;

public interface Channel {

    public interface GroupListener {
        void onBeforeSending(Log log);

        void onFailure(Log log, Exception exc);

        void onSuccess(Log log);
    }

    public interface Listener {
        void onClear(@NonNull String str);

        void onGloballyEnabled(boolean z);

        void onGroupAdded(@NonNull String str, GroupListener groupListener, long j);

        void onGroupRemoved(@NonNull String str);

        void onPreparedLog(@NonNull Log log, @NonNull String str, int i);

        void onPreparingLog(@NonNull Log log, @NonNull String str);

        boolean shouldFilter(@NonNull Log log);
    }
}
