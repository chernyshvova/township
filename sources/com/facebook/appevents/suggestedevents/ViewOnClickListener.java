package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.p030ml.ModelManager;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.swrve.sdk.SwrveNotificationConstants;
import com.vungle.warren.log.LogEntry;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: ViewOnClickListener.kt */
public final class ViewOnClickListener implements View.OnClickListener {
    public static final String API_ENDPOINT = "%s/suggested_events";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OTHER_EVENT = "other";
    public static final Set<Integer> viewsAttachedListener = new HashSet();
    public final String activityName;
    public final View.OnClickListener baseListener;
    public final WeakReference<View> hostViewWeakReference;
    public final WeakReference<View> rootViewWeakReference;

    /* compiled from: ViewOnClickListener.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void processPredictedResult(String str, String str2, float[] fArr) {
            SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
            if (SuggestedEventsManager.isProductionEvents$facebook_core_release(str)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
                return;
            }
            SuggestedEventsManager suggestedEventsManager2 = SuggestedEventsManager.INSTANCE;
            if (SuggestedEventsManager.isEligibleEvents$facebook_core_release(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        }

        /* access modifiers changed from: private */
        public final boolean queryHistoryAndProcess(String str, String str2) {
            PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
            String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (Intrinsics.areEqual(queryEvent, "other")) {
                return true;
            }
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new Runnable(queryEvent, str2) {
                public final /* synthetic */ String f$0;
                public final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    ViewOnClickListener.Companion.m3596queryHistoryAndProcess$lambda0(this.f$0, this.f$1);
                }
            });
            return true;
        }

        /* renamed from: queryHistoryAndProcess$lambda-0  reason: not valid java name */
        public static final void m3596queryHistoryAndProcess$lambda0(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "$queriedEvent");
            Intrinsics.checkNotNullParameter(str2, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(str, str2, new float[0]);
        }

        private final void sendPredictedResult(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString(BoltsMeasurementEventListener.MEASUREMENT_EVENT_NAME_KEY, str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                int length = fArr.length;
                int i = 0;
                while (i < length) {
                    float f = fArr[i];
                    i++;
                    sb.append(f);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put(SwrveNotificationConstants.BUTTON_TEXT_KEY, str2);
                bundle.putString(LogEntry.LOG_METADATA, jSONObject.toString());
                GraphRequest.Companion companion = GraphRequest.Companion;
                Locale locale = Locale.US;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String format = String.format(locale, ViewOnClickListener.API_ENDPOINT, Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                GraphRequest newPostRequest = companion.newPostRequest((AccessToken) null, format, (JSONObject) null, (GraphRequest.Callback) null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }

        public final void attachListener$facebook_core_release(View view, View view2, String str) {
            Intrinsics.checkNotNullParameter(view, "hostView");
            Intrinsics.checkNotNullParameter(view2, "rootView");
            Intrinsics.checkNotNullParameter(str, "activityName");
            int hashCode = view.hashCode();
            if (!ViewOnClickListener.access$getViewsAttachedListener$cp().contains(Integer.valueOf(hashCode))) {
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str, (DefaultConstructorMarker) null));
                ViewOnClickListener.access$getViewsAttachedListener$cp().add(Integer.valueOf(hashCode));
            }
        }
    }

    public ViewOnClickListener(View view, View view2, String str) {
        ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            this.activityName = CharsKt__CharKt.replace$default(lowerCase, ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", false, 4);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public /* synthetic */ ViewOnClickListener(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, str);
    }

    public static final /* synthetic */ Set access$getViewsAttachedListener$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewsAttachedListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return null;
        }
    }

    public static final void attachListener$facebook_core_release(View view, View view2, String str) {
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                Companion.attachListener$facebook_core_release(view, view2, str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            }
        }
    }

    private final void predictAndProcess(String str, String str2, JSONObject jSONObject) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Utility utility = Utility.INSTANCE;
                Utility.runOnNonUiThread(new Runnable(jSONObject, str2, this, str) {
                    public final /* synthetic */ JSONObject f$0;
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ ViewOnClickListener f$2;
                    public final /* synthetic */ String f$3;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        ViewOnClickListener.m3595predictAndProcess$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: predictAndProcess$lambda-0  reason: not valid java name */
    public static final void m3595predictAndProcess$lambda0(JSONObject jSONObject, String str, ViewOnClickListener viewOnClickListener, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                Intrinsics.checkNotNullParameter(jSONObject, "$viewData");
                Intrinsics.checkNotNullParameter(str, "$buttonText");
                Intrinsics.checkNotNullParameter(viewOnClickListener, "this$0");
                Intrinsics.checkNotNullParameter(str2, "$pathID");
                try {
                    Utility utility = Utility.INSTANCE;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
                    if (appName != null) {
                        String lowerCase = appName.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                        float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                        FeatureExtractor featureExtractor2 = FeatureExtractor.INSTANCE;
                        String textFeature = FeatureExtractor.getTextFeature(str, viewOnClickListener.activityName, lowerCase);
                        if (denseFeatures != null) {
                            ModelManager modelManager = ModelManager.INSTANCE;
                            String[] predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                            if (predict != null) {
                                String str3 = predict[0];
                                PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                                PredictionHistoryManager.addPrediction(str2, str3);
                                if (!Intrinsics.areEqual(str3, "other")) {
                                    Companion.processPredictedResult(str3, str, denseFeatures);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            }
        }
    }

    private final void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view = (View) this.rootViewWeakReference.get();
                View view2 = (View) this.hostViewWeakReference.get();
                if (view != null && view2 != null) {
                    try {
                        SuggestedEventViewHierarchy suggestedEventViewHierarchy = SuggestedEventViewHierarchy.INSTANCE;
                        String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                        PredictionHistoryManager predictionHistoryManager = PredictionHistoryManager.INSTANCE;
                        String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                        if (pathID != null && !Companion.queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                            JSONObject jSONObject = new JSONObject();
                            SuggestedEventViewHierarchy suggestedEventViewHierarchy2 = SuggestedEventViewHierarchy.INSTANCE;
                            jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                            jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                            predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onClick(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                View.OnClickListener onClickListener = this.baseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
