package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final /* synthetic */ class ComponentRuntime$$Lambda$4 implements Provider {
    public final Set arg$1;

    public ComponentRuntime$$Lambda$4(Set set) {
        this.arg$1 = set;
    }

    public Object get() {
        return ComponentRuntime.lambda$processSetComponents$1(this.arg$1);
    }
}
