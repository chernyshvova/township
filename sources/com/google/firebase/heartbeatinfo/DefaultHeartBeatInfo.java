package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class DefaultHeartBeatInfo implements HeartBeatInfo {
    public HeartBeatInfoStorage storage;

    public DefaultHeartBeatInfo(Context context) {
        HeartBeatInfoStorage heartBeatInfoStorage;
        synchronized (HeartBeatInfoStorage.class) {
            if (HeartBeatInfoStorage.instance == null) {
                HeartBeatInfoStorage.instance = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = HeartBeatInfoStorage.instance;
        }
        this.storage = heartBeatInfoStorage;
    }

    @NonNull
    public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        boolean shouldSendSdkHeartBeat;
        long currentTimeMillis = System.currentTimeMillis();
        boolean shouldSendSdkHeartBeat2 = this.storage.shouldSendSdkHeartBeat(str, currentTimeMillis);
        HeartBeatInfoStorage heartBeatInfoStorage = this.storage;
        synchronized (heartBeatInfoStorage) {
            shouldSendSdkHeartBeat = heartBeatInfoStorage.shouldSendSdkHeartBeat("fire-global", currentTimeMillis);
        }
        if (shouldSendSdkHeartBeat2 && shouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (shouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (shouldSendSdkHeartBeat2) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }
}
