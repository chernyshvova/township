package com.applovin.impl.sdk.p024a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;
import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.applovin.impl.sdk.a.f */
public class C1021f {

    /* renamed from: a */
    public final C1188m f1323a;

    /* renamed from: b */
    public final Context f1324b;

    /* renamed from: c */
    public String f1325c;

    public C1021f(C1188m mVar) {
        this.f1323a = mVar;
        this.f1324b = mVar.mo10932L();
    }

    /* renamed from: a */
    public String mo10472a(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.f1325c, str);
        } catch (Throwable th) {
            this.f1323a.mo10922B().mo11373b("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            return str;
        }
    }

    /* renamed from: a */
    public void mo10473a() {
        if (((Boolean) this.f1323a.mo10946a(C1085b.f1590av)).booleanValue()) {
            C1314v B = this.f1323a.mo10922B();
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Initializing Open Measurement SDK v");
            outline24.append(mo10475c());
            outline24.append("...");
            B.mo11372b("OpenMeasurementService", outline24.toString());
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    Omid.activate(C1021f.this.f1324b);
                    C1314v B = C1021f.this.f1323a.mo10922B();
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Init ");
                    outline24.append(C1021f.this.mo10474b() ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                    outline24.append(" and took ");
                    outline24.append(System.currentTimeMillis() - currentTimeMillis);
                    outline24.append("ms");
                    B.mo11372b("OpenMeasurementService", outline24.toString());
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(C1021f.this.f1324b.getResources().openRawResource(C1368R.raw.omsdk_v_1_0)));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String unused = C1021f.this.f1325c = sb.toString();
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                            }
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
                        }
                    } catch (Throwable th2) {
                        C1021f.this.f1323a.mo10922B().mo11373b("OpenMeasurementService", "Failed to retrieve resource omskd_v_1_0.js", th2);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public boolean mo10474b() {
        return Omid.isActive();
    }

    /* renamed from: c */
    public String mo10475c() {
        return Omid.getVersion();
    }

    /* renamed from: d */
    public Partner mo10476d() {
        return Partner.createPartner((String) this.f1323a.mo10946a(C1085b.f1591aw), AppLovinSdk.VERSION);
    }

    @Nullable
    /* renamed from: e */
    public String mo10477e() {
        return this.f1325c;
    }
}
