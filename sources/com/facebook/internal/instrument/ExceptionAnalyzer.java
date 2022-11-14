package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ExceptionAnalyzer.kt */
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    public static boolean enabled;

    public static final void enable() {
        enabled = true;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    public static final void execute(Throwable th) {
        if (enabled && !isDebug$facebook_core_release() && th != null) {
            HashSet hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            for (StackTraceElement className : stackTrace) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                String className2 = className.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "it.className");
                FeatureManager.Feature feature = FeatureManager.getFeature(className2);
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled() && (!hashSet.isEmpty())) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(new JSONArray(hashSet)).save();
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static final boolean isDebug$facebook_core_release() {
        return false;
    }

    /* renamed from: sendExceptionAnalysisReports$lambda-1  reason: not valid java name */
    public static final void m3635sendExceptionAnalysisReports$lambda1(InstrumentData instrumentData, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(instrumentData, "$instrumentData");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        try {
            if (graphResponse.getError() == null) {
                JSONObject jsonObject = graphResponse.getJsonObject();
                if (Intrinsics.areEqual(jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), Boolean.TRUE)) {
                    instrumentData.clear();
                }
            }
        } catch (JSONException unused) {
        }
    }

    @VisibleForTesting(otherwise = 2)
    public final void sendExceptionAnalysisReports$facebook_core_release() {
        Utility utility = Utility.INSTANCE;
        if (!Utility.isDataProcessingRestricted()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            ArrayList arrayList = new ArrayList();
            int length = listExceptionAnalysisReportFiles.length;
            int i = 0;
            while (i < length) {
                File file = listExceptionAnalysisReportFiles[i];
                i++;
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData load = InstrumentData.Builder.load(file);
                if (load.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", load.toString());
                        GraphRequest.Companion companion = GraphRequest.Companion;
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        arrayList.add(companion.newPostRequest((AccessToken) null, format, jSONObject, new GraphRequest.Callback() {
                            public final void onCompleted(GraphResponse graphResponse) {
                                ExceptionAnalyzer.m3635sendExceptionAnalysisReports$lambda1(InstrumentData.this, graphResponse);
                            }
                        }));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
            }
        }
    }
}
