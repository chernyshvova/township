package com.helpshift.common.domain;

import com.helpshift.common.domain.PollFunction;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.poller.Delay;
import com.helpshift.common.poller.HttpBackoff;
import java.util.concurrent.TimeUnit;

public class Poller {
    public PollFunction activePollFunction;
    public HttpBackoff aggressiveBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.m3078of(3, TimeUnit.SECONDS)).setMaxInterval(Delay.m3078of(3, TimeUnit.SECONDS)).setRandomness(0.0f).setMultiplier(1.0f).setRetryPolicy(getPollerRetryPollicy()).build();
    public HttpBackoff conservativeBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.m3078of(5, TimeUnit.SECONDS)).setMaxInterval(Delay.m3078of(1, TimeUnit.MINUTES)).setRandomness(0.1f).setMultiplier(2.0f).setRetryPolicy(getPollerRetryPollicy()).build();
    public final Domain domain;
    public HttpBackoff passiveBackoff = new HttpBackoff.Builder().setBaseInterval(Delay.m3078of(30, TimeUnit.SECONDS)).setMaxInterval(Delay.m3078of(5, TimeUnit.MINUTES)).setRandomness(0.1f).setMultiplier(4.0f).setRetryPolicy(getPollerRetryPollicy()).build();
    public final C2500F poll;

    /* renamed from: com.helpshift.common.domain.Poller$2 */
    public static /* synthetic */ class C25022 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$domain$PollingInterval;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                com.helpshift.common.domain.PollingInterval[] r0 = com.helpshift.common.domain.PollingInterval.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$domain$PollingInterval = r0
                r1 = 1
                com.helpshift.common.domain.PollingInterval r2 = com.helpshift.common.domain.PollingInterval.AGGRESSIVE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$common$domain$PollingInterval     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.domain.PollingInterval r2 = com.helpshift.common.domain.PollingInterval.PASSIVE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = $SwitchMap$com$helpshift$common$domain$PollingInterval     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.common.domain.PollingInterval r2 = com.helpshift.common.domain.PollingInterval.CONSERVATIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.domain.Poller.C25022.<clinit>():void");
        }
    }

    public Poller(Domain domain2, C2500F f) {
        this.domain = domain2;
        this.poll = f;
    }

    private HttpBackoff.RetryPolicy getPollerRetryPollicy() {
        return new HttpBackoff.RetryPolicy() {
            public boolean shouldRetry(int i) {
                if (i == NetworkErrorCodes.AUTH_TOKEN_NOT_PROVIDED.intValue() || i == NetworkErrorCodes.INVALID_AUTH_TOKEN.intValue() || NetworkErrorCodes.NOT_RETRIABLE_STATUS_CODES.contains(Integer.valueOf(i))) {
                    return false;
                }
                return true;
            }
        };
    }

    public synchronized void start(PollingInterval pollingInterval, long j, PollFunction.PollFunctionListener pollFunctionListener) {
        stop();
        if (pollingInterval != null) {
            int ordinal = pollingInterval.ordinal();
            if (ordinal == 0) {
                this.activePollFunction = new PollFunction(this.domain, this.aggressiveBackoff, this.poll, PollingInterval.AGGRESSIVE, pollFunctionListener);
            } else if (ordinal == 1) {
                this.activePollFunction = new PollFunction(this.domain, this.conservativeBackoff, this.poll, PollingInterval.CONSERVATIVE, pollFunctionListener);
            } else if (ordinal == 2) {
                this.activePollFunction = new PollFunction(this.domain, this.passiveBackoff, this.poll, PollingInterval.PASSIVE, pollFunctionListener);
            }
            this.activePollFunction.start(j);
        }
    }

    public synchronized void stop() {
        if (this.activePollFunction != null) {
            this.activePollFunction.stop();
            this.activePollFunction = null;
        }
    }
}
