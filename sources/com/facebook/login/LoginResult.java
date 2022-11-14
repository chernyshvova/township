package com.facebook.login;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginResult.kt */
public final class LoginResult {
    public final AccessToken accessToken;
    public final AuthenticationToken authenticationToken;
    public final Set<String> recentlyDeniedPermissions;
    public final Set<String> recentlyGrantedPermissions;

    public LoginResult(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(accessToken2, "accessToken");
        Intrinsics.checkNotNullParameter(set, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(set2, "recentlyDeniedPermissions");
        this.accessToken = accessToken2;
        this.authenticationToken = authenticationToken2;
        this.recentlyGrantedPermissions = set;
        this.recentlyDeniedPermissions = set2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginResult(AccessToken accessToken2, Set<String> set, Set<String> set2) {
        this(accessToken2, (AuthenticationToken) null, set, set2, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accessToken2, "accessToken");
        Intrinsics.checkNotNullParameter(set, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(set2, "recentlyDeniedPermissions");
    }

    public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2, int i, Object obj) {
        if ((i & 1) != 0) {
            accessToken2 = loginResult.accessToken;
        }
        if ((i & 2) != 0) {
            authenticationToken2 = loginResult.authenticationToken;
        }
        if ((i & 4) != 0) {
            set = loginResult.recentlyGrantedPermissions;
        }
        if ((i & 8) != 0) {
            set2 = loginResult.recentlyDeniedPermissions;
        }
        return loginResult.copy(accessToken2, authenticationToken2, set, set2);
    }

    public final AccessToken component1() {
        return this.accessToken;
    }

    public final AuthenticationToken component2() {
        return this.authenticationToken;
    }

    public final Set<String> component3() {
        return this.recentlyGrantedPermissions;
    }

    public final Set<String> component4() {
        return this.recentlyDeniedPermissions;
    }

    public final LoginResult copy(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(accessToken2, "accessToken");
        Intrinsics.checkNotNullParameter(set, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(set2, "recentlyDeniedPermissions");
        return new LoginResult(accessToken2, authenticationToken2, set, set2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResult)) {
            return false;
        }
        LoginResult loginResult = (LoginResult) obj;
        return Intrinsics.areEqual(this.accessToken, loginResult.accessToken) && Intrinsics.areEqual(this.authenticationToken, loginResult.authenticationToken) && Intrinsics.areEqual(this.recentlyGrantedPermissions, loginResult.recentlyGrantedPermissions) && Intrinsics.areEqual(this.recentlyDeniedPermissions, loginResult.recentlyDeniedPermissions);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    public final Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }

    public final Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public int hashCode() {
        int hashCode = this.accessToken.hashCode() * 31;
        AuthenticationToken authenticationToken2 = this.authenticationToken;
        int hashCode2 = authenticationToken2 == null ? 0 : authenticationToken2.hashCode();
        return this.recentlyDeniedPermissions.hashCode() + ((this.recentlyGrantedPermissions.hashCode() + ((hashCode + hashCode2) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("LoginResult(accessToken=");
        outline24.append(this.accessToken);
        outline24.append(", authenticationToken=");
        outline24.append(this.authenticationToken);
        outline24.append(", recentlyGrantedPermissions=");
        outline24.append(this.recentlyGrantedPermissions);
        outline24.append(", recentlyDeniedPermissions=");
        outline24.append(this.recentlyDeniedPermissions);
        outline24.append(')');
        return outline24.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginResult(AccessToken accessToken2, AuthenticationToken authenticationToken2, Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessToken2, (i & 2) != 0 ? null : authenticationToken2, set, set2);
    }
}
