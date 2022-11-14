package com.microsoft.appcenter.analytics.channel;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.utils.context.SessionContext;
import java.util.Date;
import java.util.UUID;

public class SessionTracker extends AbstractChannelListener {
    public final Channel mChannel;
    public final String mGroupName;
    public Long mLastPausedTime;
    public long mLastQueuedLogTime;
    public Long mLastResumedTime;
    public UUID mSid;

    public SessionTracker(Channel channel, String str) {
        this.mChannel = channel;
        this.mGroupName = str;
    }

    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
        if (!(log instanceof StartSessionLog) && !(log instanceof StartServiceLog)) {
            Date timestamp = log.getTimestamp();
            if (timestamp != null) {
                SessionContext.SessionInfo sessionAt = SessionContext.getInstance().getSessionAt(timestamp.getTime());
                if (sessionAt != null) {
                    log.setSid(sessionAt.mSessionId);
                    return;
                }
                return;
            }
            log.setSid(this.mSid);
            this.mLastQueuedLogTime = SystemClock.elapsedRealtime();
        }
    }
}
