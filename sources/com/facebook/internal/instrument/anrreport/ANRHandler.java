package com.facebook.internal.instrument.anrreport;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ANRHandler.kt */
public final class ANRHandler {
    public static final ANRHandler INSTANCE = new ANRHandler();
    public static final int MAX_ANR_REPORT_NUM = 5;
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static final synchronized void enable() {
        Class<ANRHandler> cls = ANRHandler.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    if (!enabled.getAndSet(true)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                            sendANRReports();
                        }
                        ANRDetector aNRDetector = ANRDetector.INSTANCE;
                        ANRDetector.start();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    @VisibleForTesting
    public static final void sendANRReports() {
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Utility utility = Utility.INSTANCE;
                if (!Utility.isDataProcessingRestricted()) {
                    InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                    File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
                    ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
                    for (File load : listAnrReportFiles) {
                        InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                        arrayList.add(InstrumentData.Builder.load(load));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object next : arrayList) {
                        if (((InstrumentData) next).isValid()) {
                            arrayList2.add(next);
                        }
                    }
                    List sortedWith = CollectionsKt__CollectionsKt.sortedWith(arrayList2, $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M.INSTANCE);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = zzam.until(0, Math.min(sortedWith.size(), 5)).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                    }
                    InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
                    InstrumentUtility.sendReports("anr_reports", jSONArray, new GraphRequest.Callback(sortedWith) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onCompleted(GraphResponse graphResponse) {
                            ANRHandler.m3644sendANRReports$lambda5(this.f$0, graphResponse);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: sendANRReports$lambda-2  reason: not valid java name */
    public static final int m3643sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    /* renamed from: sendANRReports$lambda-5  reason: not valid java name */
    public static final void m3644sendANRReports$lambda5(List list, GraphResponse graphResponse) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
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
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
