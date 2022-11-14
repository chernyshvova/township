package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public interface HeartBeatInfo {

    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        public final int code;

        /* access modifiers changed from: public */
        HeartBeat(int i) {
            this.code = i;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
