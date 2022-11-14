package com.helpshift.common.poller;

import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.poller.ExponentialBackoff;

public class HttpBackoff {
    public final ExponentialBackoff exponentialBackoff;
    public final RetryPolicy retryPolicy;

    public static class Builder {
        public final ExponentialBackoff.Builder exponentialBackoffBuilder = new ExponentialBackoff.Builder();
        public RetryPolicy retryPolicy = RetryPolicy.ALWAYS;

        public HttpBackoff build() throws IllegalArgumentException {
            this.exponentialBackoffBuilder.validate();
            return new HttpBackoff(this);
        }

        public Builder setBaseInterval(Delay delay) {
            this.exponentialBackoffBuilder.setBaseInterval(delay);
            return this;
        }

        public Builder setMaxAttempts(int i) {
            this.exponentialBackoffBuilder.setMaxAttempts(i);
            return this;
        }

        public Builder setMaxInterval(Delay delay) {
            this.exponentialBackoffBuilder.setMaxInterval(delay);
            return this;
        }

        public Builder setMultiplier(float f) {
            this.exponentialBackoffBuilder.setMultiplier(f);
            return this;
        }

        public Builder setRandomness(float f) {
            this.exponentialBackoffBuilder.setRandomness(f);
            return this;
        }

        public Builder setRetryPolicy(RetryPolicy retryPolicy2) {
            this.retryPolicy = retryPolicy2;
            return this;
        }
    }

    public interface RetryPolicy {
        public static final RetryPolicy ALWAYS = new RetryPolicy() {
            public boolean shouldRetry(int i) {
                return true;
            }
        };
        public static final RetryPolicy FAILURE = new RetryPolicy() {
            public boolean shouldRetry(int i) {
                return !NetworkErrorCodes.NOT_RETRIABLE_STATUS_CODES.contains(Integer.valueOf(i));
            }
        };
        public static final RetryPolicy NEVER = new RetryPolicy() {
            public boolean shouldRetry(int i) {
                return false;
            }
        };

        boolean shouldRetry(int i);
    }

    public HttpBackoff(Builder builder) {
        this.exponentialBackoff = new ExponentialBackoff(builder.exponentialBackoffBuilder);
        this.retryPolicy = builder.retryPolicy;
    }

    public long nextIntervalMillis(int i) {
        long nextIntervalMillis = this.exponentialBackoff.nextIntervalMillis();
        if (this.retryPolicy.shouldRetry(i)) {
            return nextIntervalMillis;
        }
        return -100;
    }

    public void reset() {
        this.exponentialBackoff.reset();
    }
}
