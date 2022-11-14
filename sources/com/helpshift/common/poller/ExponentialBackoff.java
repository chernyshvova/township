package com.helpshift.common.poller;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class ExponentialBackoff {
    public static final long STOP = -100;
    public int attempts;
    public final long baseIntervalMillis;
    public long currentBaseIntervalMillis;
    public final int maxAttempts;
    public final long maxIntervalMillis;
    public final float multiplier;
    public final SecureRandom random = new SecureRandom();
    public final float randomness;

    public static class Builder {
        public static final String ERROR_BASE_INTERVAL_RANGE = "Base interval can't be negative or zero";
        public static final String ERROR_MAX_ATTEMPTS_RANGE = "Max attempts can't be negative or zero";
        public static final String ERROR_MAX_INTERVAL_LESS_THAN_BASE_INTERVAL = "Max interval can't be less than base interval";
        public static final String ERROR_MAX_INTERVAL_RANGE = "Max interval can't be negative or zero";
        public static final String ERROR_MULTIPLIER_RANGE = "Multiplier can't be less than 1";
        public static final String ERROR_RANDOMNESS_RANGE = "Randomness must be between 0 and 1 (both inclusive)";
        public long baseIntervalMillis = TimeUnit.SECONDS.toMillis(10);
        public int maxAttempts = Integer.MAX_VALUE;
        public long maxIntervalMillis = TimeUnit.SECONDS.toMillis(60);
        public float multiplier = 2.0f;
        public float randomness = 0.5f;

        public ExponentialBackoff build() throws IllegalArgumentException {
            validate();
            return new ExponentialBackoff(this);
        }

        public Builder setBaseInterval(Delay delay) {
            this.baseIntervalMillis = delay.timeUnit.toMillis(delay.delay);
            return this;
        }

        public Builder setMaxAttempts(int i) {
            this.maxAttempts = i;
            return this;
        }

        public Builder setMaxInterval(Delay delay) {
            this.maxIntervalMillis = delay.timeUnit.toMillis(delay.delay);
            return this;
        }

        public Builder setMultiplier(float f) {
            this.multiplier = f;
            return this;
        }

        public Builder setRandomness(float f) {
            this.randomness = f;
            return this;
        }

        public void validate() {
            long j = this.baseIntervalMillis;
            if (j > 0) {
                long j2 = this.maxIntervalMillis;
                if (j2 <= 0) {
                    throw new IllegalArgumentException(ERROR_MAX_INTERVAL_RANGE);
                } else if (j2 >= j) {
                    float f = this.randomness;
                    if (f < 0.0f || f > 1.0f) {
                        throw new IllegalArgumentException(ERROR_RANDOMNESS_RANGE);
                    } else if (this.multiplier < 1.0f) {
                        throw new IllegalArgumentException(ERROR_MULTIPLIER_RANGE);
                    } else if (this.maxAttempts <= 0) {
                        throw new IllegalArgumentException(ERROR_MAX_ATTEMPTS_RANGE);
                    }
                } else {
                    throw new IllegalArgumentException(ERROR_MAX_INTERVAL_LESS_THAN_BASE_INTERVAL);
                }
            } else {
                throw new IllegalArgumentException(ERROR_BASE_INTERVAL_RANGE);
            }
        }
    }

    public ExponentialBackoff(Builder builder) {
        this.baseIntervalMillis = builder.baseIntervalMillis;
        this.maxIntervalMillis = builder.maxIntervalMillis;
        this.randomness = builder.randomness;
        this.multiplier = builder.multiplier;
        this.maxAttempts = builder.maxAttempts;
        reset();
    }

    public long nextIntervalMillis() {
        int i = this.attempts;
        if (i >= this.maxAttempts) {
            return -100;
        }
        this.attempts = i + 1;
        long j = this.currentBaseIntervalMillis;
        float f = this.randomness;
        float f2 = (1.0f - f) * ((float) j);
        float f3 = (f + 1.0f) * ((float) j);
        long j2 = this.maxIntervalMillis;
        if (j <= j2) {
            this.currentBaseIntervalMillis = Math.min((long) (((float) j) * this.multiplier), j2);
        }
        return (long) GeneratedOutlineSupport.outline0(f3, f2, this.random.nextFloat(), f2);
    }

    public void reset() {
        this.currentBaseIntervalMillis = this.baseIntervalMillis;
        this.attempts = 0;
    }
}
