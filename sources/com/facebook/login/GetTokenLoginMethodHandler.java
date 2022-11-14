package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetTokenLoginMethodHandler.kt */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new GetTokenLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public GetTokenClient getTokenClient;
    public final String nameForLogging = "get_token";

    /* compiled from: GetTokenLoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    /* renamed from: tryAuthorize$lambda-1  reason: not valid java name */
    public static final void m3659tryAuthorize$lambda1(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(getTokenLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        getTokenLoginMethodHandler.getTokenCompleted(request, bundle);
    }

    public void cancel() {
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.cancel();
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
            this.getTokenClient = null;
        }
    }

    public final void complete(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "result");
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.length() == 0) {
            getLoginClient().notifyBackgroundProcessingStart();
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            if (string2 != null) {
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(string2, new GetTokenLoginMethodHandler$complete$1(bundle, this, request));
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        onComplete(request, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            if (stringArrayList == null) {
                stringArrayList = EmptyList.INSTANCE;
            }
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = EmptySet.INSTANCE;
            }
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (permissions.contains("openid")) {
                if (string == null || string.length() == 0) {
                    getLoginClient().tryNextHandler();
                    return;
                }
            }
            if (stringArrayList.containsAll(permissions)) {
                complete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(LoginClient.Request request, Bundle bundle) {
        LoginClient.Result result;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "result");
        try {
            result = LoginClient.Result.Companion.createCompositeTokenResult(request, LoginMethodHandler.Companion.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), LoginMethodHandler.Companion.createAuthenticationTokenFromNativeLogin(bundle, request.getNonce()));
        } catch (FacebookException e) {
            result = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), (String) null, e.getMessage(), (String) null, 8, (Object) null);
        }
        getLoginClient().completeAndValidate(result);
    }

    public int tryAuthorize(LoginClient.Request request) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient2 = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient2;
        if (getTokenClient2 == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(getTokenClient2.start());
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        $$Lambda$0nbY_VDDLzAmaRymMcAzSLWtvA r0 = new PlatformServiceClient.CompletedListener(request) {
            public final /* synthetic */ LoginClient.Request f$1;

            {
                this.f$1 = r2;
            }

            public final void completed(Bundle bundle) {
                GetTokenLoginMethodHandler.m3659tryAuthorize$lambda1(GetTokenLoginMethodHandler.this, this.f$1, bundle);
            }
        };
        GetTokenClient getTokenClient3 = this.getTokenClient;
        if (getTokenClient3 == null) {
            return 1;
        }
        getTokenClient3.setCompletedListener(r0);
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }
}
