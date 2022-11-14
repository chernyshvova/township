package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: DeviceAuthMethodHandler.kt */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new DeviceAuthMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    public final String nameForLogging = "device_auth";

    /* compiled from: DeviceAuthMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
            ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp;
            if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            access$getBackgroundExecutor$cp = DeviceAuthMethodHandler.backgroundExecutor;
            if (access$getBackgroundExecutor$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundExecutor");
                throw null;
            }
            return access$getBackgroundExecutor$cp;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    public static final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor backgroundExecutor2;
        synchronized (DeviceAuthMethodHandler.class) {
            backgroundExecutor2 = Companion.getBackgroundExecutor();
        }
        return backgroundExecutor2;
    }

    private final void showDialog(LoginClient.Request request) {
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity != null && !activity.isFinishing()) {
            DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
            createDeviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
            createDeviceAuthDialog.startLogin(request);
        }
    }

    public DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public void onCancel() {
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createCancelResult(getLoginClient().getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE));
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), (String) null, exc.getMessage(), (String) null, 8, (Object) null));
    }

    public void onSuccess(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "accessToken");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "applicationId");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "userId");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createTokenResult(getLoginClient().getPendingRequest(), new AccessToken(str4, str5, str6, collection, collection2, collection3, accessTokenSource, date, date2, date3, (String) null, 1024, (DefaultConstructorMarker) null)));
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        showDialog(request);
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
