package com.playrix.engine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;
import com.playrix.engine.LifeCycleActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EngineFacebook {
    public static final int FILTER_ALL = 0;
    public static final int FILTER_APP_NON_USERS = 2;
    public static final int FILTER_APP_USERS = 1;
    public static final int REQUEST_RESULT_CANCELED = 1;
    public static final int REQUEST_RESULT_CONNECTION_ERROR = 3;
    public static final int REQUEST_RESULT_FAILED = 2;
    public static final int REQUEST_RESULT_SUCCESS = 0;
    public static final String TAG = "EngineFacebook ";
    public static AccessTokenTracker accessTokenTracker = null;
    public static CallbackManager callbackManager = null;
    public static long loginRequestId = -1;
    public static final Queue<Runnable> mDeferredTasks = new LinkedList();
    public static final AtomicBoolean mExecutingMode = new AtomicBoolean(false);
    public static final AtomicBoolean mPublishingInstallEvent = new AtomicBoolean(false);
    public static final TrackingSwitcher trackingSwitcher = new TrackingSwitcher();

    public static class AppRequestInfo {
        public final String data;
        public final String message;
        public final String requestId;
        public final String senderId;

        public AppRequestInfo(String str, String str2, String str3, String str4) {
            this.requestId = str;
            this.senderId = str2;
            this.message = str3;
            this.data = str4;
        }
    }

    public static class AppRequestsInfo {
        public final NextPageRequest nextPageRequest;
        public final AppRequestInfo[] requests;

        public AppRequestsInfo(ArrayList<AppRequestInfo> arrayList, NextPageRequest nextPageRequest2) {
            this.requests = (AppRequestInfo[]) arrayList.toArray(new AppRequestInfo[arrayList.size()]);
            this.nextPageRequest = nextPageRequest2;
        }
    }

    public static class FriendsInfo {
        public final UserInfo[] friends;
        public final NextPageRequest nextPageRequest;

        public FriendsInfo(ArrayList<UserInfo> arrayList, NextPageRequest nextPageRequest2) {
            this.friends = (UserInfo[]) arrayList.toArray(new UserInfo[arrayList.size()]);
            this.nextPageRequest = nextPageRequest2;
        }
    }

    public static class LifecycleCallbacks implements LifeCycleActivity.ILifecycleCallbacks {
        public LifecycleCallbacks() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            CallbackManager unused = EngineFacebook.callbackManager = CallbackManager.Factory.create();
            EngineFacebook.registerLoginCallback();
            EngineFacebook.setLoginBehavior(activity);
            AccessTokenTracker unused2 = EngineFacebook.accessTokenTracker = new AccessTokenTracker() {
                public void onCurrentAccessTokenChanged(final AccessToken accessToken, final AccessToken accessToken2) {
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            if (accessToken == null || accessToken2 != null) {
                                AccessToken accessToken = accessToken2;
                                if (accessToken != null && accessToken != accessToken) {
                                    Logger.logDebug("EngineFacebook FB change token");
                                    EngineFacebook.nativeOnTokenChanged(new LoginInfo(accessToken2));
                                    return;
                                }
                                return;
                            }
                            Logger.logDebug("EngineFacebook FB logged out");
                            EngineFacebook.nativeOnTokenChanged((LoginInfo) null);
                        }
                    });
                }
            };
            EngineFacebook.executeDeferredTasks();
            EngineFacebook.mExecutingMode.set(true);
        }

        public void onActivityDestroyed(Activity activity) {
            EngineFacebook.accessTokenTracker.stopTracking();
            EngineFacebook.mExecutingMode.set(false);
        }

        public void onActivityPaused(Activity activity) {
        }

        public boolean onActivityResult(int i, int i2, Intent intent) {
            if (!FacebookSdk.isFacebookRequestCode(i)) {
                return false;
            }
            if (EngineFacebook.callbackManager == null) {
                return true;
            }
            EngineFacebook.callbackManager.onActivityResult(i, i2, intent);
            return true;
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onLowMemory() {
        }

        public void onNewIntent(Intent intent) {
        }
    }

    public static class LoginInfo {
        public final long dataAccessExpirationTime;
        public final String[] declinedPermissions;
        public final String[] expiredPermissions;
        public final String[] grantedPermissions;
        public final Token token;
        public final String userId;

        public LoginInfo(AccessToken accessToken) {
            String[] strArr = null;
            this.token = accessToken != null ? new Token(accessToken) : null;
            this.dataAccessExpirationTime = accessToken != null ? accessToken.getDataAccessExpirationTime().getTime() / 1000 : 0;
            this.userId = accessToken != null ? accessToken.getUserId() : null;
            Set<String> permissions = accessToken != null ? accessToken.getPermissions() : null;
            this.grantedPermissions = permissions != null ? (String[]) permissions.toArray(new String[permissions.size()]) : null;
            Set<String> declinedPermissions2 = accessToken != null ? accessToken.getDeclinedPermissions() : null;
            this.declinedPermissions = declinedPermissions2 != null ? (String[]) declinedPermissions2.toArray(new String[declinedPermissions2.size()]) : null;
            if (accessToken != null && accessToken.isDataAccessExpired()) {
                strArr = this.grantedPermissions;
            }
            this.expiredPermissions = strArr;
        }
    }

    public static class NextPageRequest {
        public final GraphRequest request;

        public NextPageRequest(GraphRequest graphRequest) {
            this.request = graphRequest;
        }
    }

    public static abstract class PagedRequestCallbacks {
        public PagedRequestCallbacks() {
        }

        public abstract void onFailed();

        public abstract void onSuccess(GraphResponse graphResponse, NextPageRequest nextPageRequest);
    }

    public static class Token {
        public final AccessToken token;

        public Token(AccessToken accessToken) {
            this.token = accessToken;
        }

        public String getAsString() {
            AccessToken accessToken = this.token;
            if (accessToken != null) {
                return accessToken.getToken();
            }
            return null;
        }
    }

    public static class TrackingSwitcher {
        public boolean isTrackingEnabled = false;
        public final Map<Activity, TrackingActivityState> trackingActivities = new HashMap();

        public static class TrackingActivityState {
            public boolean createdInTracker;
            public boolean resumed;
            public boolean resumedInTracker;

            public TrackingActivityState() {
                this.resumed = false;
                this.resumedInTracker = false;
                this.createdInTracker = false;
            }
        }

        private void startTracking() {
            try {
                Field declaredField = ActivityLifecycleTracker.class.getDeclaredField("appId");
                declaredField.setAccessible(true);
                declaredField.set((Object) null, FacebookSdk.getApplicationId());
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("EngineFacebook  appId set error: "));
            }
            for (Activity next : this.trackingActivities.keySet()) {
                TrackingActivityState trackingActivityState = this.trackingActivities.get(next);
                if (!trackingActivityState.createdInTracker) {
                    trackingActivityState.createdInTracker = true;
                    trackActivityCreated(next);
                }
                if (trackingActivityState.resumed && !trackingActivityState.resumedInTracker) {
                    trackingActivityState.resumedInTracker = true;
                    trackActivityResumed(next);
                }
            }
        }

        private void stopTracking() {
            for (Activity next : this.trackingActivities.keySet()) {
                TrackingActivityState trackingActivityState = this.trackingActivities.get(next);
                if (trackingActivityState.resumedInTracker) {
                    trackingActivityState.resumedInTracker = false;
                    trackActivityPaused(next);
                }
            }
            AppEventsLogger.onContextStop();
        }

        private void trackActivityCreated(Activity activity) {
            ActivityLifecycleTracker.onActivityCreated(activity);
        }

        private void trackActivityPaused(Activity activity) {
            Class<ActivityLifecycleTracker> cls = ActivityLifecycleTracker.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("onActivityPaused", new Class[]{Activity.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls.getField("INSTANCE").get((Object) null), new Object[]{activity});
            } catch (Exception e) {
                GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("EngineFacebook  invoke onActivityPaused error: "));
            }
        }

        private void trackActivityResumed(Activity activity) {
            ActivityLifecycleTracker.onActivityResumed(activity);
        }

        public void enableTracking(boolean z) {
            if (this.isTrackingEnabled != z) {
                this.isTrackingEnabled = z;
                if (z) {
                    startTracking();
                } else {
                    stopTracking();
                }
            }
        }

        public void onActivityCreated(Activity activity) {
            this.trackingActivities.put(activity, new TrackingActivityState());
            if (this.isTrackingEnabled) {
                TrackingActivityState trackingActivityState = this.trackingActivities.get(activity);
                if (trackingActivityState != null) {
                    trackingActivityState.createdInTracker = true;
                }
                trackActivityCreated(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            this.trackingActivities.remove(activity);
        }

        public void onActivityPaused(Activity activity) {
            TrackingActivityState trackingActivityState = this.trackingActivities.get(activity);
            if (trackingActivityState != null) {
                trackingActivityState.resumed = false;
            }
            if (this.isTrackingEnabled) {
                if (trackingActivityState != null) {
                    trackingActivityState.resumedInTracker = false;
                }
                trackActivityPaused(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            TrackingActivityState trackingActivityState = this.trackingActivities.get(activity);
            if (trackingActivityState != null) {
                trackingActivityState.resumed = true;
            }
            if (this.isTrackingEnabled) {
                if (trackingActivityState != null) {
                    trackingActivityState.resumedInTracker = true;
                }
                trackActivityResumed(activity);
            }
        }

        public void onActivityStopped(Activity activity) {
            if (this.isTrackingEnabled) {
                AppEventsLogger.onContextStop();
            }
        }
    }

    public static class UserInfo {
        public final String userEmail;
        public final String userFirstName;
        public final String userId;
        public final String userName;
        public final String userPictureUrl;

        public UserInfo(String str, String str2, String str3, String str4, String str5) {
            this.userId = str;
            this.userName = str2;
            this.userFirstName = str3;
            this.userPictureUrl = str4;
            this.userEmail = str5;
        }
    }

    public static ShareLinkContent BuildShareLinkContent(String str, String str2, String str3) {
        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
        if (!TextUtils.isEmpty(str)) {
            builder.setContentUrl(Uri.parse(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            ShareHashtag.Builder builder2 = new ShareHashtag.Builder();
            builder2.setHashtag(str2);
            builder.setShareHashtag(builder2.build());
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setQuote(str3);
        }
        return builder.build();
    }

    public static void clearPermissions(final Token token, final long j, final int i) {
        executeTask(new Runnable() {
            public void run() {
                EngineFacebook.executeRequestAsync(new GraphRequest(Token.this.token, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, (Bundle) null, HttpMethod.DELETE, new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse graphResponse) {
                        if (!EngineFacebook.isResponseSucceeded(graphResponse)) {
                            EngineFacebook.logFacebookRequestError(EngineFacebook.getResponseError(graphResponse), "FB:ClearPermissions");
                            EngineFacebook.finishRequest(j, 2);
                            return;
                        }
                        EngineFacebook.finishRequest(j, 0);
                    }
                }), i);
            }
        });
    }

    public static void createActivityLifecycleCallbacks() {
        Engine.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof EngineActivity) {
                    Engine.getActivity().registerActivityLifecycleCallbacks(new LifecycleCallbacks());
                }
                EngineFacebook.trackingSwitcher.onActivityCreated(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                EngineFacebook.trackingSwitcher.onActivityDestroyed(activity);
            }

            public void onActivityPaused(Activity activity) {
                EngineFacebook.trackingSwitcher.onActivityPaused(activity);
            }

            public void onActivityResumed(Activity activity) {
                EngineFacebook.trackingSwitcher.onActivityResumed(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
                EngineFacebook.trackingSwitcher.onActivityStopped(activity);
            }
        });
    }

    public static GraphRequest createPageRequest(AccessToken accessToken, String str, String[] strArr) {
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(accessToken, str, (GraphRequest.Callback) null);
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(strArr));
        Bundle parameters = newGraphPathRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newGraphPathRequest.setParameters(parameters);
        return newGraphPathRequest;
    }

    public static GraphRequest createUserInfoRequest(AccessToken accessToken, String str) {
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(accessToken, "me", (GraphRequest.Callback) null);
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(new String[]{"id", "name", Profile.FIRST_NAME_KEY, "email", str}));
        Bundle parameters = newGraphPathRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newGraphPathRequest.setParameters(parameters);
        return newGraphPathRequest;
    }

    public static void deleteAppRequest(Token token, long j, int i, String str) {
        final Token token2 = token;
        final String str2 = str;
        final long j2 = j;
        final int i2 = i;
        executeTask(new Runnable() {
            public void run() {
                GraphRequest newDeleteObjectRequest = GraphRequest.newDeleteObjectRequest(Token.this.token, str2, (GraphRequest.Callback) null);
                newDeleteObjectRequest.setCallback(new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse graphResponse) {
                        if (!EngineFacebook.isResponseSucceeded(graphResponse)) {
                            EngineFacebook.logFacebookRequestError(EngineFacebook.getResponseError(graphResponse), "FB:deleteAppRequest");
                            EngineFacebook.finishRequest(j2, 2);
                            return;
                        }
                        EngineFacebook.finishRequest(j2, 0);
                    }
                });
                EngineFacebook.executeRequestAsync(newDeleteObjectRequest, i2);
            }
        });
    }

    public static void enableTracking(final boolean z) {
        executeTask(new Runnable() {
            public void run() {
                EngineFacebook.trackingSwitcher.enableTracking(z);
            }
        });
    }

    public static void executeDeferredTasks() {
        synchronized (mDeferredTasks) {
            for (Runnable run : mDeferredTasks) {
                run.run();
            }
            mDeferredTasks.clear();
        }
    }

    public static void executeRequestAsync(GraphRequest graphRequest, int i) {
        try {
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(graphRequest);
            graphRequestBatch.setTimeout(i * 1000);
            graphRequestBatch.executeAsync();
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook Can't execute request: ");
            outline24.append(e.getMessage());
            Logger.logError(outline24.toString());
            graphRequest.getCallback().onCompleted((GraphResponse) null);
        }
    }

    public static void executeTask(Runnable runnable) {
        EngineActivity activity = Engine.getActivity();
        if (activity == null || !mExecutingMode.get()) {
            synchronized (mDeferredTasks) {
                mDeferredTasks.add(runnable);
            }
            return;
        }
        activity.runOnUiThread(runnable);
    }

    public static int extractExceptionErrorCode(FacebookException facebookException) {
        String message;
        if (facebookException == null) {
            return 2;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook Facebook login error exception : ");
        outline24.append(facebookException.getClass().getName());
        outline24.append(", error message : ");
        outline24.append(facebookException.toString());
        String sb = outline24.toString();
        if (!(facebookException instanceof FacebookAuthorizationException) || (message = ((FacebookAuthorizationException) facebookException).getMessage()) == null || (!message.equalsIgnoreCase("net::ERR_ADDRESS_UNREACHABLE") && !message.equalsIgnoreCase("net::ERR_NAME_NOT_RESOLVED"))) {
            Logger.logError(sb);
            return 2;
        }
        Logger.logWarning(sb);
        return 3;
    }

    public static void finishDeferredLinkRequest(final long j, final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineFacebook.nativeOnDeferredAppLinkDataFetched(j, str);
            }
        });
    }

    public static void finishRequest(final long j, final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineFacebook.nativeOnFinishRequest(j, i, (Object) null);
            }
        });
    }

    public static String getAttributeName(String str) {
        try {
            return (String) AppEventsConstants.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject getAttributionIdentifiers() {
        JSONObject jSONObject = new JSONObject();
        try {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(Engine.getContext());
            if (attributionIdentifiers != null) {
                if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                    jSONObject.put(UserSettingsManager.ADVERTISER_ID_KEY, attributionIdentifiers.getAndroidAdvertiserId());
                    jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
                }
                if (attributionIdentifiers.getAttributionId() != null) {
                    jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
                }
            }
        } catch (Exception e) {
            GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("EngineFacebook getAttributionIdentifiers error: "));
        }
        return jSONObject;
    }

    public static String getEventName(String str) {
        try {
            return (String) AppEventsConstants.class.getField(str).get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static FacebookRequestError getResponseError(GraphResponse graphResponse) {
        return graphResponse != null ? graphResponse.getError() : new FacebookRequestError(-1, (String) null, "Error on start execute request");
    }

    public static String getSdkVersion() {
        return FacebookSdk.getSdkVersion();
    }

    public static UserInfo getUserInfo(JSONObject jSONObject) {
        String str;
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("name");
        String optString3 = jSONObject.optString(Profile.FIRST_NAME_KEY);
        String optString4 = jSONObject.optString("email");
        JSONObject optJSONObject = jSONObject.optJSONObject("picture");
        if (optJSONObject != null) {
            if (optJSONObject instanceof String) {
                str = (String) optJSONObject;
            } else {
                try {
                    str = optJSONObject.getJSONObject("data").getString("url");
                } catch (JSONException unused) {
                }
            }
            return new UserInfo(optString, optString2, optString3, str, optString4);
        }
        str = "";
        return new UserInfo(optString, optString2, optString3, str, optString4);
    }

    public static boolean initialize(final String str, final String str2, final String str3) {
        return NativeThread.getInstance().executeInitializeEvent(new Runnable() {
            public void run() {
                FacebookSdk.setApplicationId(str);
                FacebookSdk.setApplicationName(str2);
                FacebookSdk.setClientToken(str3);
                FacebookSdk.sdkInitialize(Engine.getApplication());
                EngineFacebook.createActivityLifecycleCallbacks();
            }
        });
    }

    public static boolean isDataAccessExpired(Token token) {
        AccessToken accessToken;
        if (token == null || (accessToken = token.token) == null) {
            return false;
        }
        return accessToken.isDataAccessExpired();
    }

    public static boolean isMessengerAvailable() {
        return MessageDialog.canShow(ShareLinkContent.class);
    }

    public static boolean isResponseSucceeded(GraphResponse graphResponse) {
        return graphResponse != null && graphResponse.getError() == null;
    }

    public static void logActivation() {
        executeTask(new Runnable() {
            public void run() {
                if (FacebookSdk.isInitialized()) {
                    EngineFacebook.publishInstallAsync(Engine.getApplication(), FacebookSdk.getApplicationId());
                }
            }
        });
    }

    public static void logEvent(final String str, final Bundle bundle) {
        executeTask(new Runnable() {
            public void run() {
                AppEventsLogger newLogger = AppEventsLogger.newLogger(Engine.getApplication());
                Bundle bundle = bundle;
                if (bundle == null || bundle.isEmpty()) {
                    newLogger.logEvent(str);
                } else {
                    newLogger.logEvent(str, bundle);
                }
            }
        });
    }

    public static void logEventWithValue(final String str, final double d, final Bundle bundle) {
        executeTask(new Runnable() {
            public void run() {
                AppEventsLogger newLogger = AppEventsLogger.newLogger(Engine.getApplication());
                Bundle bundle = bundle;
                if (bundle == null || bundle.isEmpty()) {
                    newLogger.logEvent(str, d);
                } else {
                    newLogger.logEvent(str, d, bundle);
                }
            }
        });
    }

    public static void logFacebookRequestError(FacebookRequestError facebookRequestError, String str) {
        StringBuilder outline27 = GeneratedOutlineSupport.outline27(TAG, str, " error: ");
        outline27.append(facebookRequestError.getErrorMessage());
        String sb = outline27.toString();
        if (facebookRequestError.getErrorCode() == -1 && facebookRequestError.getRequestStatusCode() == -1) {
            Logger.logWarning(sb);
        } else {
            Logger.logError(sb);
        }
    }

    public static void logPurchase(final float f, final String str, final Bundle bundle) {
        executeTask(new Runnable() {
            public void run() {
                try {
                    BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
                    Currency instance = Currency.getInstance(str);
                    AppEventsLogger newLogger = AppEventsLogger.newLogger(Engine.getApplication());
                    if (bundle != null) {
                        if (!bundle.isEmpty()) {
                            newLogger.logPurchase(bigDecimal, instance, bundle);
                            return;
                        }
                    }
                    newLogger.logPurchase(bigDecimal, instance);
                } catch (Exception e) {
                    GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("EngineFacebook error logPurchase :"));
                }
            }
        });
    }

    public static void loginForPermissions(long j, final String[] strArr) {
        loginRequestId = j;
        executeTask(new Runnable() {
            public void run() {
                EngineFacebook.onDialogShow();
                LoginManager.getInstance().logInWithReadPermissions((Activity) Engine.getActivity(), (Collection<String>) Arrays.asList(strArr));
            }
        });
    }

    public static void logout() {
        executeTask(new Runnable() {
            public void run() {
                LoginManager.getInstance().logOut();
            }
        });
    }

    public static void messageWithDialog(long j, String str, String str2, String str3) {
        final long j2 = j;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        executeTask(new Runnable() {
            public void run() {
                C30821 r0 = new FacebookCallback<Sharer.Result>() {
                    public void onCancel() {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 1);
                    }

                    public void onError(FacebookException facebookException) {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 1);
                    }

                    public void onSuccess(Sharer.Result result) {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 0);
                    }
                };
                MessageDialog messageDialog = new MessageDialog((Activity) Engine.getActivity());
                messageDialog.registerCallback(EngineFacebook.callbackManager, r0);
                ShareLinkContent access$2300 = EngineFacebook.BuildShareLinkContent(str4, str5, str6);
                if (messageDialog.canShow(access$2300)) {
                    EngineFacebook.onDialogShow();
                    messageDialog.show(access$2300);
                    return;
                }
                EngineFacebook.finishRequest(j2, 1);
            }
        });
    }

    public static native void nativeOnDeferredAppLinkDataFetched(long j, String str);

    public static native void nativeOnDialogHide();

    public static native void nativeOnDialogShow();

    public static native void nativeOnFinishRequest(long j, int i, Object obj);

    public static native void nativeOnTokenChanged(LoginInfo loginInfo);

    public static void onDialogHide() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineFacebook.nativeOnDialogHide();
            }
        });
    }

    public static void onDialogShow() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineFacebook.nativeOnDialogShow();
            }
        });
    }

    public static void postWithDialog(long j, String str, String str2, String str3) {
        final long j2 = j;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        executeTask(new Runnable() {
            public void run() {
                C30781 r0 = new FacebookCallback<Sharer.Result>() {
                    public void onCancel() {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 1);
                    }

                    public void onError(FacebookException facebookException) {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 1);
                    }

                    public void onSuccess(Sharer.Result result) {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 0);
                    }
                };
                ShareDialog shareDialog = new ShareDialog((Activity) Engine.getActivity());
                shareDialog.registerCallback(EngineFacebook.callbackManager, r0);
                ShareLinkContent access$2300 = EngineFacebook.BuildShareLinkContent(str4, str5, str6);
                if (shareDialog.canShow(access$2300, ShareDialog.Mode.FEED)) {
                    EngineFacebook.onDialogShow();
                    shareDialog.show((ShareContent<?, ?>) access$2300, ShareDialog.Mode.FEED);
                    return;
                }
                EngineFacebook.finishRequest(j2, 1);
            }
        });
    }

    public static void processDeferredDeeplink(final long j) {
        executeTask(new Runnable() {
            public void run() {
                try {
                    Logger.logDebug("EngineFacebook Checking for deferred deeplink");
                    AppLinkData.fetchDeferredAppLinkData(Engine.getApplication(), new AppLinkData.CompletionHandler() {
                        public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                            String str;
                            Uri targetUri;
                            if (appLinkData == null || (targetUri = appLinkData.getTargetUri()) == null) {
                                str = null;
                            } else {
                                str = targetUri.toString();
                                Logger.logDebug("EngineFacebook Processing deferred deeplink form FB: " + str);
                            }
                            EngineFacebook.finishDeferredLinkRequest(j, str);
                        }
                    });
                } catch (Exception e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook Fetch deferred error");
                    outline24.append(e.getMessage());
                    Logger.logError(outline24.toString());
                    EngineFacebook.finishDeferredLinkRequest(j, (String) null);
                }
            }
        });
    }

    public static void processLoginResult(final int i, final AccessToken accessToken) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                long access$1300 = EngineFacebook.loginRequestId;
                long unused = EngineFacebook.loginRequestId = -1;
                if (access$1300 >= 0) {
                    EngineFacebook.nativeOnDialogHide();
                    EngineFacebook.nativeOnFinishRequest(access$1300, i, new LoginInfo(accessToken));
                }
            }
        });
    }

    @SuppressLint({"RestrictedApi"})
    public static void publishInstallAsync(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                Class<FacebookSdk> cls = FacebookSdk.class;
                if (!EngineFacebook.mPublishingInstallEvent.get()) {
                    EngineFacebook.mPublishingInstallEvent.set(true);
                    try {
                        Object obj = cls.getField("INSTANCE").get((Object) null);
                        Method declaredMethod = cls.getDeclaredMethod("publishInstallAndWaitForResponse", new Class[]{Context.class, String.class});
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(obj, new Object[]{applicationContext, str});
                    } catch (Exception e) {
                        GeneratedOutlineSupport.outline32(e, GeneratedOutlineSupport.outline24("EngineFacebook  invoke publishInstallAndWaitForResponse error: "));
                    }
                    EngineFacebook.mPublishingInstallEvent.set(false);
                }
            }
        });
        if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
            OnDeviceProcessingManager.sendInstallEventAsync(str, FacebookSdk.ATTRIBUTION_PREFERENCES);
        }
    }

    public static void reauthorizeDataAccess(long j) {
        loginRequestId = j;
        executeTask(new Runnable() {
            public void run() {
                EngineFacebook.onDialogShow();
                LoginManager.getInstance().reauthorizeDataAccess((Activity) Engine.getActivity());
            }
        });
    }

    public static boolean refreshAccessToken(final long j) {
        if (AccessToken.getCurrentAccessToken() == null) {
            return false;
        }
        executeTask(new Runnable() {
            public void run() {
                AccessToken.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() {
                    public void OnTokenRefreshFailed(FacebookException facebookException) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook FB:Token refresh failed: ");
                        outline24.append(facebookException.toString());
                        Logger.logWarning(outline24.toString());
                        EngineFacebook.finishRequest(j, 2);
                    }

                    public void OnTokenRefreshed(final AccessToken accessToken) {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                EngineFacebook.nativeOnFinishRequest(j, 0, new LoginInfo(accessToken));
                            }
                        });
                    }
                });
            }
        });
        return true;
    }

    public static void registerLoginCallback() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            public void onCancel() {
                Logger.logDebug("Facebook login canceled");
                EngineFacebook.processLoginResult(1, (AccessToken) null);
            }

            public void onError(FacebookException facebookException) {
                Logger.logDebug("Facebook login failed");
                EngineFacebook.processLoginResult(EngineFacebook.extractExceptionErrorCode(facebookException), (AccessToken) null);
            }

            public void onSuccess(LoginResult loginResult) {
                Logger.logDebug("Facebook logged in");
                EngineFacebook.processLoginResult(0, loginResult.getAccessToken());
            }
        });
    }

    public static void request(long j, String str, String str2, String str3, String[] strArr, int i) {
        final long j2 = j;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final String[] strArr2 = strArr;
        final int i2 = i;
        executeTask(new Runnable() {
            public void run() {
                new GameRequestDialog((Activity) Engine.getActivity()).registerCallback(EngineFacebook.callbackManager, new FacebookCallback<GameRequestDialog.Result>() {
                    public void onCancel() {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 1);
                    }

                    public void onError(FacebookException facebookException) {
                        EngineFacebook.onDialogHide();
                        EngineFacebook.finishRequest(j2, 2);
                    }

                    public void onSuccess(GameRequestDialog.Result result) {
                        EngineFacebook.onDialogHide();
                        if (result.getRequestId() != null) {
                            EngineFacebook.finishRequest(j2, 0);
                        } else {
                            EngineFacebook.finishRequest(j2, 1);
                        }
                    }
                });
                GameRequestContent.Builder builder = new GameRequestContent.Builder();
                if (!TextUtils.isEmpty(str4)) {
                    builder.setTitle(str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    builder.setMessage(str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    builder.setData(str6);
                }
                String[] strArr = strArr2;
                if (strArr == null || strArr.length == 0) {
                    int i = i2;
                    if (i == 1) {
                        builder.setFilters(GameRequestContent.Filters.APP_USERS);
                    } else if (i == 2) {
                        builder.setFilters(GameRequestContent.Filters.APP_NON_USERS);
                    }
                } else {
                    builder.setRecipients(Arrays.asList(strArr));
                }
                GameRequestContent build = builder.build();
                if (GameRequestDialog.canShow()) {
                    EngineFacebook.onDialogShow();
                    GameRequestDialog.show((Activity) Engine.getActivity(), build);
                    return;
                }
                EngineFacebook.finishRequest(j2, 1);
            }
        });
    }

    public static void requestAppRequests(Token token, final long j, int i, NextPageRequest nextPageRequest) {
        sendPageRequest(token, nextPageRequest, "me/apprequests", new String[]{"id", "from", "message", "data"}, i, new PagedRequestCallbacks() {
            public void onFailed() {
                EngineFacebook.nativeOnFinishRequest(j, 2, (Object) null);
            }

            public void onSuccess(GraphResponse graphResponse, NextPageRequest nextPageRequest) {
                JSONObject jSONObject;
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = graphResponse.getJSONObject().getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("message");
                        String str = "";
                        String optString3 = jSONObject2.has("data") ? jSONObject2.optString("data") : str;
                        if (jSONObject2.has("from") && (jSONObject = jSONObject2.getJSONObject("from")) != null) {
                            str = jSONObject.optString("id");
                        }
                        arrayList.add(new AppRequestInfo(optString, str, optString2, optString3));
                    }
                } catch (Exception unused) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook app response error :");
                    outline24.append(graphResponse.getRawResponse());
                    Logger.logError(outline24.toString());
                }
                EngineFacebook.nativeOnFinishRequest(j, 0, new AppRequestsInfo(arrayList, nextPageRequest));
            }
        });
    }

    public static void requestFriends(Token token, final long j, int i, NextPageRequest nextPageRequest, String str) {
        Token token2 = token;
        NextPageRequest nextPageRequest2 = nextPageRequest;
        sendPageRequest(token2, nextPageRequest2, GraphRequest.MY_FRIENDS, new String[]{"id", "name", Profile.FIRST_NAME_KEY, str}, i, new PagedRequestCallbacks() {
            public void onFailed() {
                EngineFacebook.nativeOnFinishRequest(j, 2, (Object) null);
            }

            public void onSuccess(GraphResponse graphResponse, NextPageRequest nextPageRequest) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = graphResponse.getJSONObject().getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(EngineFacebook.getUserInfo(jSONArray.getJSONObject(i)));
                    }
                } catch (Exception unused) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook friends response error :");
                    outline24.append(graphResponse.getRawResponse());
                    Logger.logError(outline24.toString());
                }
                EngineFacebook.nativeOnFinishRequest(j, 0, new FriendsInfo(arrayList, nextPageRequest));
            }
        });
    }

    public static void requestLikesInfo(Token token, long j, String str, int i) {
        final String str2 = str;
        final Token token2 = token;
        final long j2 = j;
        final int i2 = i;
        executeTask(new Runnable() {
            public void run() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("me/likes/");
                outline24.append(str2);
                EngineFacebook.executeRequestAsync(GraphRequest.newGraphPathRequest(token2.token, outline24.toString(), new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse graphResponse) {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                if (EngineFacebook.isResponseSucceeded(graphResponse)) {
                                    Boolean bool = Boolean.FALSE;
                                    try {
                                        if (graphResponse.getJSONObject().getJSONArray("data").length() > 0) {
                                            bool = Boolean.TRUE;
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    EngineFacebook.nativeOnFinishRequest(j2, 0, bool);
                                    return;
                                }
                                EngineFacebook.logFacebookRequestError(EngineFacebook.getResponseError(graphResponse), "FB:requestLikesInfo");
                                EngineFacebook.nativeOnFinishRequest(j2, 2, (Object) null);
                            }
                        });
                    }
                }), i2);
            }
        });
    }

    public static void requestUser(Token token, long j, int i, String str) {
        final Token token2 = token;
        final String str2 = str;
        final long j2 = j;
        final int i2 = i;
        executeTask(new Runnable() {
            public void run() {
                GraphRequest access$1900 = EngineFacebook.createUserInfoRequest(Token.this.token, str2);
                access$1900.setCallback(new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse graphResponse) {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                UserInfo userInfo = null;
                                if (EngineFacebook.isResponseSucceeded(graphResponse)) {
                                    try {
                                        userInfo = EngineFacebook.getUserInfo(graphResponse.getJSONObject());
                                    } catch (Exception unused) {
                                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EngineFacebook user response error :");
                                        outline24.append(graphResponse.getRawResponse());
                                        Logger.logError(outline24.toString());
                                    }
                                    EngineFacebook.nativeOnFinishRequest(j2, 0, userInfo);
                                    return;
                                }
                                EngineFacebook.logFacebookRequestError(EngineFacebook.getResponseError(graphResponse), "FB:requestUser");
                                EngineFacebook.nativeOnFinishRequest(j2, 2, (Object) null);
                            }
                        });
                    }
                });
                EngineFacebook.executeRequestAsync(access$1900, i2);
            }
        });
    }

    public static void sendPageRequest(Token token, NextPageRequest nextPageRequest, String str, String[] strArr, final int i, final PagedRequestCallbacks pagedRequestCallbacks) {
        final GraphRequest graphRequest;
        if (nextPageRequest != null) {
            graphRequest = nextPageRequest.request;
        } else {
            graphRequest = createPageRequest(token.token, str, strArr);
        }
        executeTask(new Runnable() {
            public void run() {
                GraphRequest.this.setCallback(new GraphRequest.Callback() {
                    public void onCompleted(final GraphResponse graphResponse) {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                if (!EngineFacebook.isResponseSucceeded(graphResponse)) {
                                    EngineFacebook.logFacebookRequestError(EngineFacebook.getResponseError(graphResponse), "FB:sendRequest");
                                    pagedRequestCallbacks.onFailed();
                                    return;
                                }
                                try {
                                    GraphRequest requestForPagedResults = graphResponse.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT);
                                    pagedRequestCallbacks.onSuccess(graphResponse, requestForPagedResults != null ? new NextPageRequest(requestForPagedResults) : null);
                                } catch (FacebookException e) {
                                    e.printStackTrace();
                                    pagedRequestCallbacks.onFailed();
                                }
                            }
                        });
                    }
                });
                EngineFacebook.executeRequestAsync(GraphRequest.this, i);
            }
        });
    }

    public static void setLoginBehavior(Activity activity) {
        if (activity != null) {
            try {
                PackageInfo packageInfo = activity.getPackageManager().getPackageInfo("com.facebook.katana", 0);
                if (packageInfo != null && packageInfo.versionCode < 40477) {
                    LoginManager.getInstance().setLoginBehavior(LoginBehavior.WEB_ONLY);
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            LoginManager.getInstance().setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        }
    }

    public static void setUserId(final String str) {
        executeTask(new Runnable() {
            public void run() {
                AppEventsLogger.setUserID(str);
            }
        });
    }

    public static void silentLogin(final long j) {
        final AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                AccessToken accessToken = AccessToken.this;
                if (accessToken != null) {
                    EngineFacebook.nativeOnFinishRequest(j, 0, new LoginInfo(accessToken));
                } else {
                    EngineFacebook.nativeOnFinishRequest(j, 2, (Object) null);
                }
            }
        });
    }
}
