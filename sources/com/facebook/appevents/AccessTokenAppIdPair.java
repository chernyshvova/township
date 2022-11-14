package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: AccessTokenAppIdPair.kt */
public final class AccessTokenAppIdPair implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;
    public final String accessTokenString;
    public final String applicationId;

    /* compiled from: AccessTokenAppIdPair.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AccessTokenAppIdPair.kt */
    public static final class SerializationProxyV1 implements Serializable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final long serialVersionUID = -2488473066578201069L;
        public final String accessTokenString;
        public final String appId;

        /* compiled from: AccessTokenAppIdPair.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SerializationProxyV1(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "appId");
            this.accessTokenString = str;
            this.appId = str2;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }
    }

    public AccessTokenAppIdPair(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "applicationId");
        this.applicationId = str2;
        Utility utility = Utility.INSTANCE;
        this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AccessTokenAppIdPair)) {
            return false;
        }
        Utility utility = Utility.INSTANCE;
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
        if (!Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString)) {
            return false;
        }
        Utility utility2 = Utility.INSTANCE;
        if (Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
            return true;
        }
        return false;
    }

    public final String getAccessTokenString() {
        return this.accessTokenString;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        String str = this.accessTokenString;
        return (str == null ? 0 : str.hashCode()) ^ this.applicationId.hashCode();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessTokenAppIdPair(com.facebook.AccessToken r2) {
        /*
            r1 = this;
            java.lang.String r0 = "accessToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = r2.getToken()
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AccessTokenAppIdPair.<init>(com.facebook.AccessToken):void");
    }
}
