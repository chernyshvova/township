package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.Transition;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginStatusClient;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.log.LogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: LoginManager.kt */
public class LoginManager {
    public static final Companion Companion;
    public static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    public static final String MANAGE_PERMISSION_PREFIX = "manage";
    public static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    public static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    public static final String PUBLISH_PERMISSION_PREFIX = "publish";
    public static final String TAG;
    public static volatile LoginManager instance;
    public String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    public boolean isFamilyLogin;
    public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    public LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
    public String messengerPageId;
    public boolean resetMessengerState;
    public final SharedPreferences sharedPreferences;
    public boolean shouldSkipAccountDeduplication;

    /* compiled from: LoginManager.kt */
    public static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        public final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.activityContext = activity;
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            getActivityContext().startActivityForResult(intent, i);
        }
    }

    /* compiled from: LoginManager.kt */
    public static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        public final ActivityResultRegistryOwner activityResultRegistryOwner;
        public final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(ActivityResultRegistryOwner activityResultRegistryOwner2, CallbackManager callbackManager2) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner2, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner2;
            this.callbackManager = callbackManager2;
        }

        /* renamed from: startActivityForResult$lambda-0  reason: not valid java name */
        public static final void m3665startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, C1562x7971582c loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(androidxActivityResultRegistryOwnerStartActivityDelegate, "this$0");
            Intrinsics.checkNotNullParameter(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, "$launcherHolder");
            CallbackManager callbackManager2 = androidxActivityResultRegistryOwnerStartActivityDelegate.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager2.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher((ActivityResultLauncher<Intent>) null);
        }

        public Activity getActivityContext() {
            ActivityResultRegistryOwner activityResultRegistryOwner2 = this.activityResultRegistryOwner;
            if (activityResultRegistryOwner2 instanceof Activity) {
                return (Activity) activityResultRegistryOwner2;
            }
            return null;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            C1562x7971582c loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new C1562x7971582c();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new C1561x357b4191(), new ActivityResultCallback(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder) {
                public final /* synthetic */ C1562x7971582c f$1;

                {
                    this.f$1 = r2;
                }

                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m3665startActivityForResult$lambda0(LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.this, this.f$1, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }
    }

    /* compiled from: LoginManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return zzam.setOf((T[]) new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        /* access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        @VisibleForTesting(otherwise = 2)
        public final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(accessToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set<T> mutableSet = CollectionsKt__CollectionsKt.toMutableSet(CollectionsKt__CollectionsKt.filterNotNull(accessToken.getPermissions()));
            if (request.isRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set<T> mutableSet2 = CollectionsKt__CollectionsKt.toMutableSet(CollectionsKt__CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(accessToken, authenticationToken, mutableSet, mutableSet2);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Map<String, String> getExtraDataFromIntent(Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.Companion;
                    LoginManager.instance = new LoginManager();
                }
            }
            LoginManager access$getInstance$cp = LoginManager.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException(Transition.MATCH_INSTANCE_STR);
            throw null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isPublishPermission(String str) {
            if (str == null) {
                return false;
            }
            if (CharsKt__CharKt.startsWith$default(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2) || CharsKt__CharKt.startsWith$default(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: LoginManager.kt */
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        public CallbackManager callbackManager;
        public String loggerID;

        public FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager2, String str) {
            Intrinsics.checkNotNullParameter(loginManager, "this$0");
            LoginManager.this = loginManager;
            this.callbackManager = callbackManager2;
            this.loggerID = str;
        }

        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(CallbackManager callbackManager2) {
            this.callbackManager = callbackManager2;
        }

        public final void setLoggerID(String str) {
            this.loggerID = str;
        }

        public Intent createIntent(Context context, Collection<String> collection) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(collection, "permissions");
            LoginClient.Request createLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
            String str = this.loggerID;
            if (str != null) {
                createLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, createLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(createLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, createLoginRequestWithConfig);
            throw facebookException;
        }

        public CallbackManager.ActivityResultParameters parseResult(int i, Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i, intent, (FacebookCallback) null, 4, (Object) null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager2 = this.callbackManager;
            if (callbackManager2 != null) {
                callbackManager2.onActivityResult(requestCode, i, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i, intent);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FacebookLoginActivityResultContract(CallbackManager callbackManager2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(LoginManager.this, (i & 1) != 0 ? null : callbackManager2, (i & 2) != 0 ? null : str);
        }
    }

    /* compiled from: LoginManager.kt */
    public static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        public final Activity activityContext;
        public final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            this.activityContext = fragmentWrapper.getActivity();
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.fragment.startActivityForResult(intent, i);
        }
    }

    /* compiled from: LoginManager.kt */
    public static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        public static LoginLogger logger;

        public final synchronized LoginLogger getLogger(Context context) {
            if (context == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                context = FacebookSdk.getApplicationContext();
            }
            if (context == null) {
                return null;
            }
            if (logger == null) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }

    public LoginManager() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        if (FacebookSdk.hasCustomTabsPrefetching) {
            CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
            if (CustomTabUtils.getChromePackage() != null) {
                CustomTabPrefetchHelper customTabPrefetchHelper = new CustomTabPrefetchHelper();
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", customTabPrefetchHelper);
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
                CustomTabsClient.connectAndInitialize(applicationContext, FacebookSdk.getApplicationContext().getPackageName());
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                callbackManager = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return loginManager.createLogInActivityResultContract(callbackManager, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        List<T> list = null;
        if (!(accessToken == null || (permissions = accessToken.getPermissions()) == null)) {
            list = CollectionsKt__CollectionsKt.filterNotNull(permissions);
        }
        return createLoginRequest(list);
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = (accessToken == null || request == null) ? null : Companion.computeLoginResult(request, accessToken, authenticationToken);
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null && computeLoginResult != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Map<String, String> getExtraDataFromIntent(Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isPublishPermission(String str) {
        return Companion.isPublishPermission(str);
    }

    /* access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null) {
            if (request == null) {
                LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", (String) null, 4, (Object) null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            logger.logCompleteLogin(request.getAuthId(), hashMap, code, map, exc, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
        }
    }

    /* access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null && request != null) {
            logger.logStartLogin(request, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
        }
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                facebookCallback = null;
            }
            return loginManager.onActivityResult(i, intent, facebookCallback);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
    }

    /* renamed from: registerCallback$lambda-0  reason: not valid java name */
    public static final boolean m3662registerCallback$lambda0(LoginManager loginManager, FacebookCallback facebookCallback, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return loginManager.onActivityResult(i, intent, facebookCallback);
    }

    /* access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j) {
        Context context2;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (context == null) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            context2 = FacebookSdk.getApplicationContext();
        } else {
            context2 = context;
        }
        LoginLogger loginLogger = new LoginLogger(context2, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient.Companion companion = LoginStatusClient.Companion;
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        LoginStatusClient newInstance$facebook_common_release = companion.newInstance$facebook_common_release(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j, (String) null);
        newInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener(uuid, loginLogger, loginStatusCallback, applicationId) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ LoginLogger f$1;
            public final /* synthetic */ LoginStatusCallback f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void completed(Bundle bundle) {
                LoginManager.m3663retrieveLoginStatusImpl$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, bundle);
            }
        });
        loginLogger.logLoginStatusStart(uuid);
        if (!newInstance$facebook_common_release.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    /* renamed from: retrieveLoginStatusImpl$lambda-2  reason: not valid java name */
    public static final void m3663retrieveLoginStatusImpl$lambda2(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2, Bundle bundle) {
        String str3 = str;
        LoginLogger loginLogger2 = loginLogger;
        LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(str3, "$loggerRef");
        Intrinsics.checkNotNullParameter(loginLogger2, "$logger");
        Intrinsics.checkNotNullParameter(loginStatusCallback2, "$responseCallback");
        Intrinsics.checkNotNullParameter(str2, "$applicationId");
        if (bundle2 != null) {
            String string = bundle2.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle2.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                Companion.handleLoginStatusError(string, string2, str, loginLogger, loginStatusCallback);
                return;
            }
            String string3 = bundle2.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle2.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle2.getString("graph_domain");
            Utility utility2 = Utility.INSTANCE;
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            String str4 = null;
            boolean z = false;
            if (!(string4 == null || string4.length() == 0)) {
                str4 = LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
            }
            String str5 = str4;
            if (!(string3 == null || string3.length() == 0)) {
                if (!(stringArrayList == null || stringArrayList.isEmpty())) {
                    if (str5 == null || str5.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        AccessToken accessToken = new AccessToken(string3, str2, str5, stringArrayList, (Collection<String>) null, (Collection<String>) null, (AccessTokenSource) null, bundleLongAsDate, (Date) null, bundleLongAsDate2, string5);
                        AccessToken.Companion.setCurrentAccessToken(accessToken);
                        Profile.Companion.fetchProfileForCurrentAccessToken();
                        loginLogger2.logLoginStatusSuccess(str3);
                        loginStatusCallback2.onCompleted(accessToken);
                        return;
                    }
                }
            }
            loginLogger2.logLoginStatusFailure(str3);
            loginStatusCallback.onFailure();
            return;
        }
        loginLogger2.logLoginStatusFailure(str3);
        loginStatusCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        edit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.m3664startLogin$lambda1(LoginManager.this, i, intent);
            }
        });
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, request);
            throw facebookException;
        }
    }

    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final boolean m3664startLogin$lambda1(LoginManager loginManager, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        return onActivityResult$default(loginManager, i, intent, (FacebookCallback) null, 4, (Object) null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (!Companion.isPublishPermission(next)) {
                    throw new FacebookException(GeneratedOutlineSupport.outline17("Cannot pass a read permission (", next, ") to a request for publish authorization"));
                }
            }
        }
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (Companion.isPublishPermission(next)) {
                    throw new FacebookException(GeneratedOutlineSupport.outline17("Cannot pass a publish or manage permission (", next, ") to a request for read authorization"));
                }
            }
        }
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, (CallbackManager) null, (String) null, 3, (Object) null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, (String) null, 2, (Object) null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager, String str) {
        return new FacebookLoginActivityResultContract(this, callbackManager, str);
    }

    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        Set<T> set;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        if (collection == null) {
            set = null;
        } else {
            set = CollectionsKt__CollectionsKt.toSet(collection);
        }
        Set<T> set2 = set;
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set2, defaultAudience2, str, applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    public LoginClient.Request createLoginRequestWithConfig(LoginConfiguration loginConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            str = PKCEUtil.generateCodeChallenge(loginConfiguration.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            str = loginConfiguration.getCodeVerifier();
        }
        String str2 = str;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        Set<T> set = CollectionsKt__CollectionsKt.toSet(loginConfiguration.getPermissions());
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str3 = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set, defaultAudience2, str3, applicationId, uuid, this.loginTargetApp, loginConfiguration.getNonce(), loginConfiguration.getCodeVerifier(), str2, codeChallengeMethod);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    public LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior2 = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience2 = this.defaultAudience;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, hashSet, defaultAudience2, "reauthorize", applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(Fragment fragment, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfiguration);
    }

    public final void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken((AuthenticationToken) null);
        Profile.Companion.setCurrentProfile((Profile) null);
        setExpressLoginStatus(false);
    }

    @VisibleForTesting(otherwise = 3)
    public final boolean onActivityResult(int i, Intent intent) {
        return onActivityResult$default(this, i, intent, (FacebookCallback) null, 4, (Object) null);
    }

    @VisibleForTesting(otherwise = 3)
    public boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        Map<String, String> map;
        LoginClient.Result.Code code;
        LoginClient.Request request;
        AuthenticationToken authenticationToken;
        AccessToken accessToken;
        AuthenticationToken authenticationToken2;
        int i2 = i;
        Intent intent2 = intent;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z2 = false;
        if (intent2 != null) {
            intent2.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i2 != -1) {
                    if (i2 != 0) {
                        accessToken = null;
                        authenticationToken2 = null;
                    } else {
                        accessToken = null;
                        authenticationToken2 = null;
                        z2 = true;
                    }
                } else if (code3 == LoginClient.Result.Code.SUCCESS) {
                    accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.errorMessage);
                    accessToken = null;
                }
                map = result.loggingExtras;
                z = z2;
                authenticationToken = authenticationToken2;
                code = code3;
                if (facebookException == null && accessToken == null && !z) {
                    facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
                FacebookException facebookException2 = facebookException;
                LoginClient.Request request2 = request;
                logCompleteLogin((Context) null, code, map, facebookException2, true, request2);
                finishLogin(accessToken, authenticationToken, request2, facebookException2, z, facebookCallback);
                return true;
            }
        } else if (i2 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = true;
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            FacebookException facebookException22 = facebookException;
            LoginClient.Request request22 = request;
            logCompleteLogin((Context) null, code, map, facebookException22, true, request22);
            finishLogin(accessToken, authenticationToken, request22, facebookException22, z, facebookCallback);
            return true;
        }
        code = code2;
        accessToken = null;
        authenticationToken = null;
        request = null;
        map = null;
        z = false;
        facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        FacebookException facebookException222 = facebookException;
        LoginClient.Request request222 = request;
        logCompleteLogin((Context) null, code, map, facebookException222, true, request222);
        finishLogin(accessToken, authenticationToken, request222, facebookException222, z, facebookCallback);
        return true;
    }

    public final void reauthorizeDataAccess(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback(facebookCallback) {
                public final /* synthetic */ FacebookCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onActivityResult(int i, Intent intent) {
                    return LoginManager.m3662registerCallback$lambda0(LoginManager.this, this.f$1, i, intent);
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void resolveError(Activity activity, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    public final void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    public final LoginManager setAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, "authType");
        this.authType = str;
        return this;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean z) {
        this.isFamilyLogin = z;
        return this;
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
        this.loginBehavior = loginBehavior2;
        return this;
    }

    public final LoginManager setLoginTargetApp(LoginTargetApp loginTargetApp2) {
        Intrinsics.checkNotNullParameter(loginTargetApp2, "targetApp");
        this.loginTargetApp = loginTargetApp2;
        return this;
    }

    public final LoginManager setMessengerPageId(String str) {
        this.messengerPageId = str;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean z) {
        this.resetMessengerState = z;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean z) {
        this.shouldSkipAccountDeduplication = z;
        return this;
    }

    public final void unregisterCallback(CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void logIn(Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithReadPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions((ActivityResultRegistryOwner) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void loginWithConfiguration(Activity activity, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        logIn(activity, loginConfiguration);
    }

    public final void resolveError(Fragment fragment, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    public final void retrieveLoginStatus(Context context, long j, LoginStatusCallback loginStatusCallback) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(loginStatusCallback, "responseCallback");
        retrieveLoginStatusImpl(context, loginStatusCallback, j);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(Fragment fragment, CallbackManager callbackManager, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError((ActivityResultRegistryOwner) activity, callbackManager, graphResponse);
            return;
        }
        throw new FacebookException(Intrinsics.stringPlus("Cannot obtain activity context on the fragment ", fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig);
    }

    public final void resolveError(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(graphResponse));
    }

    public final void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validatePublishPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        validateReadPermissions(collection);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig);
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }
}
