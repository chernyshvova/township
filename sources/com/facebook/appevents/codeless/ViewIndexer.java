package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewIndexer.kt */
public final class ViewIndexer {
    public static final String APP_VERSION_PARAM = "app_version";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PLATFORM_PARAM = "platform";
    public static final String REQUEST_TYPE = "request_type";
    public static final String SUCCESS = "success";
    public static final String TAG;
    public static final String TREE_PARAM = "tree";
    public static ViewIndexer instance;
    public final WeakReference<Activity> activityReference;
    public Timer indexingTimer;
    public String previousDigest = null;
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    /* compiled from: ViewIndexer.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: buildAppIndexingRequest$lambda-0  reason: not valid java name */
        public static final void m3575buildAppIndexingRequest$lambda0(GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(graphResponse, "it");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.access$getTAG$cp(), "App index sent to FB!");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str3, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.Companion companion = GraphRequest.Companion;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(accessToken, format, (JSONObject) null, (GraphRequest.Callback) null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(ViewIndexer.TREE_PARAM, str);
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            parameters.putString("app_version", AppEventUtility.getAppVersion());
            parameters.putString("platform", "android");
            parameters.putString(ViewIndexer.REQUEST_TYPE, str3);
            if (Intrinsics.areEqual(str3, Constants.APP_INDEXING)) {
                CodelessManager codelessManager = CodelessManager.INSTANCE;
                parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback($$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw.INSTANCE);
            return newPostRequest;
        }

        public final void sendToServerUnityInstance(String str) {
            Intrinsics.checkNotNullParameter(str, ViewIndexer.TREE_PARAM);
            ViewIndexer access$getInstance$cp = ViewIndexer.access$getInstance$cp();
            if (access$getInstance$cp != null) {
                ViewIndexer.access$sendToServer(access$getInstance$cp, str);
            }
        }
    }

    /* compiled from: ViewIndexer.kt */
    public static final class ScreenshotTaker implements Callable<String> {
        public final WeakReference<View> rootView;

        public ScreenshotTaker(View view) {
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
    }

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        TAG = canonicalName;
    }

    public ViewIndexer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public static final /* synthetic */ WeakReference access$getActivityReference$p(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.activityReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ ViewIndexer access$getInstance$cp() {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Handler access$getUiThreadHandler$p(ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewIndexer.uiThreadHandler;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$sendToServer(ViewIndexer viewIndexer, String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                viewIndexer.sendToServer(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.buildAppIndexingRequest(str, accessToken, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: schedule$lambda-0  reason: not valid java name */
    public static final void m3573schedule$lambda0(ViewIndexer viewIndexer, TimerTask timerTask) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
                Intrinsics.checkNotNullParameter(timerTask, "$indexingTask");
                Timer timer = viewIndexer.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                viewIndexer.previousDigest = null;
                Timer timer2 = new Timer();
                timer2.scheduleAtFixedRate(timerTask, 0, 1000);
                viewIndexer.indexingTimer = timer2;
            } catch (Exception e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void sendToServer(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(str, this) {
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ ViewIndexer f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ViewIndexer.m3574sendToServer$lambda1(this.f$0, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: sendToServer$lambda-1  reason: not valid java name */
    public static final void m3574sendToServer$lambda1(String str, ViewIndexer viewIndexer) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$tree");
                Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
                Utility utility = Utility.INSTANCE;
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                if (md5hash == null || !Intrinsics.areEqual(md5hash, viewIndexer.previousDigest)) {
                    Companion companion = Companion;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    viewIndexer.processRequest(companion.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING), md5hash);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void sendToServerUnityInstance(String str) {
        Class<ViewIndexer> cls = ViewIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.sendToServerUnityInstance(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void processRequest(GraphRequest graphRequest, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this) && graphRequest != null) {
            try {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (Intrinsics.areEqual(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, jSONObject.optString("success"))) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                        this.previousDigest = str;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        boolean z = jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED);
                        CodelessManager codelessManager = CodelessManager.INSTANCE;
                        CodelessManager.updateAppIndexing$facebook_core_release(z);
                        return;
                    }
                    return;
                }
                Log.e(TAG, Intrinsics.stringPlus("Error sending UI component tree to Facebook: ", executeAndWait.getError()));
            } catch (JSONException e) {
                Log.e(TAG, "Error decoding server response.", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void schedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ViewIndexer$schedule$indexingTask$1 viewIndexer$schedule$indexingTask$1 = new ViewIndexer$schedule$indexingTask$1(this);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable(viewIndexer$schedule$indexingTask$1) {
                    public final /* synthetic */ TimerTask f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ViewIndexer.m3573schedule$lambda0(ViewIndexer.this, this.f$1);
                    }
                });
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "Error scheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void unschedule() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (((Activity) this.activityReference.get()) != null) {
                    Timer timer = this.indexingTimer;
                    if (timer != null) {
                        timer.cancel();
                    }
                    this.indexingTimer = null;
                }
            } catch (Exception e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
