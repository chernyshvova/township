package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final /* synthetic */ class EventBus$$Lambda$1 implements Runnable {
    public final Map.Entry arg$1;
    public final Event arg$2;

    public EventBus$$Lambda$1(Map.Entry entry, Event event) {
        this.arg$1 = entry;
        this.arg$2 = event;
    }

    public void run() {
        Map.Entry entry = this.arg$1;
        ((EventHandler) entry.getKey()).handle(this.arg$2);
    }
}
