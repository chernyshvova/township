package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginStatusClient.kt */
public final class LoginStatusClient extends PlatformServiceClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_TOAST_DURATION_MS = 5000;
    public final String graphApiVersion;
    public final String loggerRef;
    public final long toastDurationMs;

    /* compiled from: LoginStatusClient.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoginStatusClient newInstance$facebook_common_release(Context context, String str, String str2, String str3, long j, String str4) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(str2, "loggerRef");
            Intrinsics.checkNotNullParameter(str3, "graphApiVersion");
            return new LoginStatusClient(context, str, str2, str3, j, str4);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginStatusClient(Context context, String str, String str2, String str3, long j, String str4) {
        super(context, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20170411, str, str4);
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(str2, "loggerRef");
        Intrinsics.checkNotNullParameter(str3, "graphApiVersion");
        this.loggerRef = str2;
        this.graphApiVersion = str3;
        this.toastDurationMs = j;
    }

    public void populateRequestBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        bundle.putString(NativeProtocol.EXTRA_LOGGER_REF, this.loggerRef);
        bundle.putString(NativeProtocol.EXTRA_GRAPH_API_VERSION, this.graphApiVersion);
        bundle.putLong(NativeProtocol.EXTRA_TOAST_DURATION_MS, this.toastDurationMs);
    }
}
