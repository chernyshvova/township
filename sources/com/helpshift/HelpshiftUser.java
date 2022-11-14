package com.helpshift;

import com.helpshift.util.HSPattern;

public class HelpshiftUser {
    public String authToken;
    public String email;
    public String identifier;
    public String name;

    public static final class Builder {
        public String authToken;
        public String email = null;
        public String identifier = null;
        public String name;

        public Builder(String str, String str2) {
            if (HSPattern.isValidLoginIdentifier(str) && HSPattern.isValidLoginEmail(str2)) {
                this.identifier = str;
                this.email = str2;
            }
        }

        public HelpshiftUser build() {
            return new HelpshiftUser(this);
        }

        public Builder setAuthToken(String str) {
            this.authToken = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public HelpshiftUser(Builder builder) {
        this.identifier = builder.identifier;
        this.email = builder.email;
        this.name = builder.name;
        this.authToken = builder.authToken;
    }
}
