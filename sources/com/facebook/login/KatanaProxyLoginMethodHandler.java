package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@VisibleForTesting(otherwise = 3)
/* compiled from: KatanaProxyLoginMethodHandler.kt */
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new KatanaProxyLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String nameForLogging = "katana_proxy_auth";

    /* compiled from: KatanaProxyLoginMethodHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, LoginFragment.SAVED_LOGIN_CLIENT);
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int tryAuthorize(com.facebook.login.LoginClient.Request r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.String r1 = "request"
            r2 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            com.facebook.login.LoginBehavior r1 = r24.getLoginBehavior()
            boolean r3 = com.facebook.FacebookSdk.ignoreAppSwitchToLoggedOut
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0023
            com.facebook.internal.CustomTabUtils r3 = com.facebook.internal.CustomTabUtils.INSTANCE
            java.lang.String r3 = com.facebook.internal.CustomTabUtils.getChromePackage()
            if (r3 == 0) goto L_0x0023
            boolean r1 = r1.allowsCustomTabAuth()
            if (r1 == 0) goto L_0x0023
            r15 = 1
            goto L_0x0024
        L_0x0023:
            r15 = 0
        L_0x0024:
            com.facebook.login.LoginClient$Companion r1 = com.facebook.login.LoginClient.Companion
            java.lang.String r1 = r1.getE2E()
            com.facebook.internal.NativeProtocol r3 = com.facebook.internal.NativeProtocol.INSTANCE
            com.facebook.login.LoginClient r3 = r23.getLoginClient()
            androidx.fragment.app.FragmentActivity r6 = r3.getActivity()
            java.lang.String r7 = r24.getApplicationId()
            java.util.Set r8 = r24.getPermissions()
            boolean r10 = r24.isRerequest()
            boolean r11 = r24.hasPublishPermission()
            com.facebook.login.DefaultAudience r3 = r24.getDefaultAudience()
            if (r3 != 0) goto L_0x004c
            com.facebook.login.DefaultAudience r3 = com.facebook.login.DefaultAudience.NONE
        L_0x004c:
            r12 = r3
            java.lang.String r3 = r24.getAuthId()
            java.lang.String r13 = r0.getClientState(r3)
            java.lang.String r14 = r24.getAuthType()
            java.lang.String r16 = r24.getMessengerPageId()
            boolean r17 = r24.getResetMessengerState()
            boolean r18 = r24.isFamilyLogin()
            boolean r19 = r24.shouldSkipAccountDeduplication()
            java.lang.String r20 = r24.getNonce()
            java.lang.String r21 = r24.getCodeChallenge()
            com.facebook.login.CodeChallengeMethod r2 = r24.getCodeChallengeMethod()
            if (r2 != 0) goto L_0x0079
            r2 = 0
            goto L_0x007d
        L_0x0079:
            java.lang.String r2 = r2.name()
        L_0x007d:
            r22 = r2
            r9 = r1
            java.util.List r2 = com.facebook.internal.NativeProtocol.createProxyAuthIntents(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r3 = "e2e"
            r0.addLoggingExtra(r3, r1)
            java.util.Iterator r1 = r2.iterator()
            r2 = 0
        L_0x008e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00a8
            int r2 = r2 + r4
            java.lang.Object r3 = r1.next()
            android.content.Intent r3 = (android.content.Intent) r3
            com.facebook.login.LoginClient$Companion r6 = com.facebook.login.LoginClient.Companion
            int r6 = r6.getLoginRequestCode()
            boolean r3 = r0.tryIntent(r3, r6)
            if (r3 == 0) goto L_0x008e
            return r2
        L_0x00a8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.KatanaProxyLoginMethodHandler.tryAuthorize(com.facebook.login.LoginClient$Request):int");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }
}
