package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final /* synthetic */ class ComponentRuntime$$Lambda$1 implements Provider {
    public final ComponentRuntime arg$1;
    public final Component arg$2;

    public ComponentRuntime$$Lambda$1(ComponentRuntime componentRuntime, Component component) {
        this.arg$1 = componentRuntime;
        this.arg$2 = component;
    }

    public Object get() {
        return ComponentRuntime.lambda$new$0(this.arg$1, this.arg$2);
    }
}
