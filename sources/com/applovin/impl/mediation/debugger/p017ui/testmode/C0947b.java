package com.applovin.impl.mediation.debugger.p017ui.testmode;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.b */
public class C0947b implements AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    public final C1188m f1107a;

    /* renamed from: b */
    public boolean f1108b;

    /* renamed from: c */
    public boolean f1109c;

    /* renamed from: d */
    public String f1110d;

    public C0947b(C1188m mVar) {
        this.f1107a = mVar;
        this.f1110d = (String) mVar.mo10978b(C1087d.f1816C, null);
        mVar.mo10982b(C1087d.f1816C);
        if (StringUtils.isValidString(this.f1110d)) {
            this.f1109c = true;
        }
        this.f1108b = ((Boolean) mVar.mo10978b(C1087d.f1817D, Boolean.FALSE)).booleanValue();
        mVar.mo10982b(C1087d.f1817D);
        AppLovinCommunicator.getInstance(mVar.mo10932L()).subscribe((AppLovinCommunicatorSubscriber) this, "test_mode_settings");
    }

    /* renamed from: a */
    public void mo10218a(@Nullable String str) {
        this.f1110d = str;
    }

    /* renamed from: a */
    public void mo10219a(JSONObject jSONObject) {
        if (!this.f1108b) {
            this.f1108b = JsonUtils.containsCaseInsensitiveString(this.f1107a.mo10941V().mo11217l().f2383b, JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray())) || this.f1107a.mo10941V().mo11212g() || this.f1107a.mo10941V().mo11219n();
        }
    }

    /* renamed from: a */
    public void mo10220a(boolean z) {
        this.f1109c = z;
    }

    /* renamed from: a */
    public boolean mo10221a() {
        return this.f1108b;
    }

    /* renamed from: b */
    public void mo10222b(String str) {
        this.f1107a.mo10953a(C1087d.f1816C, str);
    }

    /* renamed from: b */
    public boolean mo10223b() {
        return this.f1109c;
    }

    @Nullable
    /* renamed from: c */
    public String mo10224c() {
        return this.f1110d;
    }

    /* renamed from: d */
    public void mo10225d() {
        this.f1107a.mo10953a(C1087d.f1817D, Boolean.TRUE);
    }

    public String getCommunicatorId() {
        return C0947b.class.getSimpleName();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("test_mode_settings".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            String string = BundleUtils.getString("force_ad_network", messageData);
            if (StringUtils.isValidString(string)) {
                this.f1109c = true;
                this.f1110d = string;
            }
            String string2 = BundleUtils.getString("test_mode_network_next_session", messageData);
            if (StringUtils.isValidString(string2)) {
                mo10225d();
                mo10222b(string2);
            }
        }
    }
}
