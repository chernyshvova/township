package com.microsoft.appcenter.channel;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.OneCollectorIngestion;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.SdkExtension;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OneCollectorChannelListener extends AbstractChannelListener {
    public final Channel mChannel;
    public final Map<String, EpochAndSeq> mEpochsAndSeqsByIKey = new HashMap();
    public final Ingestion mIngestion;
    public final UUID mInstallId;
    public final DefaultLogSerializer mLogSerializer;

    public static class EpochAndSeq {
        public final String epoch;
        public long seq;

        public EpochAndSeq(String str) {
            this.epoch = str;
        }
    }

    public OneCollectorChannelListener(@NonNull Channel channel, @NonNull DefaultLogSerializer defaultLogSerializer, @NonNull HttpClient httpClient, @NonNull UUID uuid) {
        OneCollectorIngestion oneCollectorIngestion = new OneCollectorIngestion(httpClient, defaultLogSerializer);
        this.mChannel = channel;
        this.mLogSerializer = defaultLogSerializer;
        this.mInstallId = uuid;
        this.mIngestion = oneCollectorIngestion;
    }

    public static String getOneCollectorGroupName(@NonNull String str) {
        return GeneratedOutlineSupport.outline16(str, "/one");
    }

    public static boolean isOneCollectorCompatible(@NonNull Log log) {
        return !(log instanceof CommonSchemaLog) && !log.getTransmissionTargetTokens().isEmpty();
    }

    public void onClear(@NonNull String str) {
        if (!str.endsWith("/one")) {
            ((DefaultChannel) this.mChannel).clear(getOneCollectorGroupName(str));
        }
    }

    public void onGloballyEnabled(boolean z) {
        if (!z) {
            this.mEpochsAndSeqsByIKey.clear();
        }
    }

    public void onGroupAdded(@NonNull String str, Channel.GroupListener groupListener, long j) {
        if (!str.endsWith("/one")) {
            String oneCollectorGroupName = getOneCollectorGroupName(str);
            ((DefaultChannel) this.mChannel).addGroup(oneCollectorGroupName, 50, j, 2, this.mIngestion, groupListener);
        }
    }

    public void onGroupRemoved(@NonNull String str) {
        if (!str.endsWith("/one")) {
            ((DefaultChannel) this.mChannel).removeGroup(getOneCollectorGroupName(str));
        }
    }

    public void onPreparedLog(@NonNull Log log, @NonNull String str, int i) {
        if (isOneCollectorCompatible(log)) {
            try {
                Collection<CommonSchemaLog> commonSchemaLogs = this.mLogSerializer.mLogFactories.get(log.getType()).toCommonSchemaLogs(log);
                for (CommonSchemaLog next : commonSchemaLogs) {
                    next.flags = Long.valueOf((long) i);
                    EpochAndSeq epochAndSeq = this.mEpochsAndSeqsByIKey.get(next.iKey);
                    if (epochAndSeq == null) {
                        epochAndSeq = new EpochAndSeq(UUID.randomUUID().toString());
                        this.mEpochsAndSeqsByIKey.put(next.iKey, epochAndSeq);
                    }
                    SdkExtension sdkExtension = next.ext.sdk;
                    sdkExtension.epoch = epochAndSeq.epoch;
                    long j = epochAndSeq.seq + 1;
                    epochAndSeq.seq = j;
                    sdkExtension.seq = Long.valueOf(j);
                    sdkExtension.installId = this.mInstallId;
                }
                String oneCollectorGroupName = getOneCollectorGroupName(str);
                for (CommonSchemaLog enqueue : commonSchemaLogs) {
                    ((DefaultChannel) this.mChannel).enqueue(enqueue, oneCollectorGroupName, i);
                }
            } catch (IllegalArgumentException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Cannot send a log to one collector: ");
                outline24.append(e.getMessage());
                AppCenterLog.error("AppCenter", outline24.toString());
            }
        }
    }

    public boolean shouldFilter(@NonNull Log log) {
        return isOneCollectorCompatible(log);
    }
}
