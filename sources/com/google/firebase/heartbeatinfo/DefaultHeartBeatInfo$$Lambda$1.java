package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$1 implements ComponentFactory {
    public static final DefaultHeartBeatInfo$$Lambda$1 instance = new DefaultHeartBeatInfo$$Lambda$1();

    public Object create(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) ((RestrictedComponentContainer) componentContainer).get(Context.class));
    }
}
