package com.facebook.internal.instrument.errorreport;

import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ErrorReportHandler.kt */
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    public static final int MAX_ERROR_REPORT_NUM = 1000;

    public static final void enable() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static final File[] listErrorReportFiles() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles($$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* renamed from: listErrorReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m3647listErrorReportFiles$lambda3(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new Regex(GeneratedOutlineSupport.outline21(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1, "^%s[0-9]+.json$", "java.lang.String.format(format, *args)")).matches(str);
    }

    public static final void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    public static final void sendErrorReports() {
        Utility utility = Utility.INSTANCE;
        if (!Utility.isDataProcessingRestricted()) {
            File[] listErrorReportFiles = listErrorReportFiles();
            ArrayList arrayList = new ArrayList();
            int length = listErrorReportFiles.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                File file = listErrorReportFiles[i2];
                i2++;
                ErrorReportData errorReportData = new ErrorReportData(file);
                if (errorReportData.isValid()) {
                    arrayList.add(errorReportData);
                }
            }
            $$Lambda$RCFR_ep9Az8oVFbyXtDp80vE8wM r0 = $$Lambda$RCFR_ep9Az8oVFbyXtDp80vE8wM.INSTANCE;
            Intrinsics.checkNotNullParameter(arrayList, "$this$sortWith");
            Intrinsics.checkNotNullParameter(r0, "comparator");
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, r0);
            }
            JSONArray jSONArray = new JSONArray();
            while (i < arrayList.size() && i < 1000) {
                jSONArray.put(arrayList.get(i));
                i++;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback(arrayList) {
                public final /* synthetic */ ArrayList f$0;

                {
                    this.f$0 = r1;
                }

                public final void onCompleted(GraphResponse graphResponse) {
                    ErrorReportHandler.m3649sendErrorReports$lambda2(this.f$0, graphResponse);
                }
            });
        }
    }

    /* renamed from: sendErrorReports$lambda-0  reason: not valid java name */
    public static final int m3648sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
        Intrinsics.checkNotNullExpressionValue(errorReportData2, "o2");
        return errorReportData.compareTo(errorReportData2);
    }

    /* renamed from: sendErrorReports$lambda-2  reason: not valid java name */
    public static final void m3649sendErrorReports$lambda2(ArrayList arrayList, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(arrayList, "$validReports");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        try {
            if (graphResponse.getError() == null) {
                JSONObject jsonObject = graphResponse.getJsonObject();
                if (Intrinsics.areEqual(jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), Boolean.TRUE)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ErrorReportData) it.next()).clear();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
