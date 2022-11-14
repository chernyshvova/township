package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class AppExtension implements Model {

    /* renamed from: id */
    public String f3582id;
    public String locale;
    public String name;
    public String userId;
    public String ver;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppExtension.class != obj.getClass()) {
            return false;
        }
        AppExtension appExtension = (AppExtension) obj;
        String str = this.f3582id;
        if (str == null ? appExtension.f3582id != null : !str.equals(appExtension.f3582id)) {
            return false;
        }
        String str2 = this.ver;
        if (str2 == null ? appExtension.ver != null : !str2.equals(appExtension.ver)) {
            return false;
        }
        String str3 = this.name;
        if (str3 == null ? appExtension.name != null : !str3.equals(appExtension.name)) {
            return false;
        }
        String str4 = this.locale;
        if (str4 == null ? appExtension.locale != null : !str4.equals(appExtension.locale)) {
            return false;
        }
        String str5 = this.userId;
        String str6 = appExtension.userId;
        if (str5 != null) {
            return str5.equals(str6);
        }
        if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3582id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ver;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.locale;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.userId;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public void read(JSONObject jSONObject) {
        this.f3582id = jSONObject.optString("id", (String) null);
        this.ver = jSONObject.optString("ver", (String) null);
        this.name = jSONObject.optString("name", (String) null);
        this.locale = jSONObject.optString("locale", (String) null);
        this.userId = jSONObject.optString("userId", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "id", this.f3582id);
        zzam.write(jSONStringer, "ver", this.ver);
        zzam.write(jSONStringer, "name", this.name);
        zzam.write(jSONStringer, "locale", this.locale);
        zzam.write(jSONStringer, "userId", this.userId);
    }
}
