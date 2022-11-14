package com.helpshift.common.domain;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.poller.HttpBackoff;
import com.helpshift.util.HSLogger;

public class PollFunction extends C2500F {
    public static final String TAG = "Helpshift_PollFunc";
    public HttpBackoff backoff;
    public final Domain domain;
    public final PollFunctionListener listener;
    public final C2500F poll;
    public final PollingInterval pollingInterval;
    public boolean shouldPoll;

    public interface PollFunctionListener {
        void onPollingStoppedViaBackoffStrategy();
    }

    public PollFunction(Domain domain2, HttpBackoff httpBackoff, C2500F f, PollingInterval pollingInterval2, PollFunctionListener pollFunctionListener) {
        this.backoff = httpBackoff;
        this.poll = f;
        this.domain = domain2;
        this.pollingInterval = pollingInterval2;
        this.listener = pollFunctionListener;
    }

    /* renamed from: f */
    public void mo33949f() {
        int i;
        if (this.shouldPoll) {
            try {
                HSLogger.m3237d(TAG, "Running:" + this.pollingInterval.name());
                this.poll.mo33949f();
                i = NetworkErrorCodes.f3330OK.intValue();
            } catch (RootAPIException e) {
                if (e.exceptionType instanceof NetworkException) {
                    i = e.getServerStatusCode();
                } else {
                    throw e;
                }
            }
            long nextIntervalMillis = this.backoff.nextIntervalMillis(i);
            if (nextIntervalMillis == -100) {
                PollFunctionListener pollFunctionListener = this.listener;
                if (pollFunctionListener != null) {
                    pollFunctionListener.onPollingStoppedViaBackoffStrategy();
                    return;
                }
                return;
            }
            schedulePoll(nextIntervalMillis);
        }
    }

    public void schedulePoll(long j) {
        this.domain.runDelayedInParallel(this, j);
    }

    public void start(long j) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Start: ");
        outline24.append(this.pollingInterval.name());
        HSLogger.m3237d(TAG, outline24.toString());
        if (!this.shouldPoll) {
            this.shouldPoll = true;
            schedulePoll(j);
        }
    }

    public void stop() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Stop: ");
        outline24.append(this.pollingInterval.name());
        HSLogger.m3237d(TAG, outline24.toString());
        this.shouldPoll = false;
        this.backoff.reset();
    }
}
