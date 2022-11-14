package com.vungle.warren;

import java.util.concurrent.atomic.AtomicReference;

public class RuntimeValues {
    public final AtomicReference<HeaderBiddingCallback> headerBiddingCallback = new AtomicReference<>();
    public final AtomicReference<InitCallback> initCallback = new AtomicReference<>();
    public final AtomicReference<SessionData> sessionData = new AtomicReference<>();
    public final AtomicReference<VungleSettings> settings = new AtomicReference<>();
}
