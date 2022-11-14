package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: CrashHandler.kt */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_CRASH_REPORT_NUM = 5;
    public static final String TAG = CrashHandler.class.getCanonicalName();
    public static CrashHandler instance;
    public final Thread.UncaughtExceptionHandler previousHandler;

    /* compiled from: CrashHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void sendExceptionReports() {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isDataProcessingRestricted()) {
                InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
                ArrayList arrayList = new ArrayList(listExceptionReportFiles.length);
                for (File load : listExceptionReportFiles) {
                    InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                    arrayList.add(InstrumentData.Builder.load(load));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (((InstrumentData) next).isValid()) {
                        arrayList2.add(next);
                    }
                }
                List sortedWith = CollectionsKt__CollectionsKt.sortedWith(arrayList2, $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k.INSTANCE);
                JSONArray jSONArray = new JSONArray();
                Iterator it = zzam.until(0, Math.min(sortedWith.size(), 5)).iterator();
                while (it.hasNext()) {
                    jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                }
                InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
                InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback(sortedWith) {
                    public final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onCompleted(GraphResponse graphResponse) {
                        CrashHandler.Companion.m3646sendExceptionReports$lambda5(this.f$0, graphResponse);
                    }
                });
            }
        }

        /* renamed from: sendExceptionReports$lambda-2  reason: not valid java name */
        public static final int m3645sendExceptionReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        }

        /* renamed from: sendExceptionReports$lambda-5  reason: not valid java name */
        public static final void m3646sendExceptionReports$lambda5(List list, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(list, "$validReports");
            Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
            try {
                if (graphResponse.getError() == null) {
                    JSONObject jsonObject = graphResponse.getJsonObject();
                    if (Intrinsics.areEqual(jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), Boolean.TRUE)) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((InstrumentData) it.next()).clear();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public final synchronized void enable() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendExceptionReports();
            }
            if (CrashHandler.instance != null) {
                Log.w(CrashHandler.TAG, "Already enabled!");
                return;
            }
            CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), (DefaultConstructorMarker) null);
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
        }
    }

    public CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(uncaughtExceptionHandler);
    }

    public static final synchronized void enable() {
        synchronized (CrashHandler.class) {
            Companion.enable();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, "t");
        Intrinsics.checkNotNullParameter(th, "e");
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        if (InstrumentUtility.isSDKRelatedException(th)) {
            ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
