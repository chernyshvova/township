package com.swrve.sdk.config;

import com.swrve.sdk.messaging.SwrveEmbeddedMessageListener;

public class SwrveEmbeddedMessageConfig {
    public SwrveEmbeddedMessageListener embeddedMessageListener;

    public static class Builder {
        public SwrveEmbeddedMessageListener embeddedMessageListener = null;

        public SwrveEmbeddedMessageConfig build() {
            return new SwrveEmbeddedMessageConfig(this);
        }

        public Builder embeddedMessageListener(SwrveEmbeddedMessageListener swrveEmbeddedMessageListener) {
            this.embeddedMessageListener = swrveEmbeddedMessageListener;
            return this;
        }
    }

    public SwrveEmbeddedMessageListener getEmbeddedMessageListener() {
        return this.embeddedMessageListener;
    }

    public SwrveEmbeddedMessageConfig(Builder builder) {
        this.embeddedMessageListener = builder.embeddedMessageListener;
    }
}
