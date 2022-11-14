package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetTokenClient.kt */
public final class GetTokenClient extends PlatformServiceClient {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenClient(Context context, LoginClient.Request request) {
        super(context, 65536, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, NativeProtocol.PROTOCOL_VERSION_20121101, request.getApplicationId(), request.getNonce());
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public void populateRequestBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
    }
}
