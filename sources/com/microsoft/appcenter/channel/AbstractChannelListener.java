package com.microsoft.appcenter.channel;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;

public class AbstractChannelListener implements Channel.Listener {
    public void onClear(@NonNull String str) {
    }

    public void onGloballyEnabled(boolean z) {
    }

    public void onGroupAdded(@NonNull String str, Channel.GroupListener groupListener, long j) {
    }

    public void onGroupRemoved(@NonNull String str) {
    }

    public void onPreparedLog(@NonNull Log log, @NonNull String str, int i) {
    }

    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
    }

    public boolean shouldFilter(@NonNull Log log) {
        return false;
    }
}
