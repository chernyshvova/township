package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.v */
public final class C0785v {

    /* renamed from: a */
    public JSONObject f516a;

    public C0785v(JSONObject jSONObject) {
        this.f516a = jSONObject;
    }

    @TargetApi(21)
    /* renamed from: a */
    public Integer mo9711a() {
        int i;
        String string = JsonUtils.getString(this.f516a, "mixed_content_mode", (String) null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(string)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(string)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* renamed from: b */
    public WebSettings.PluginState mo9712b() {
        String string = JsonUtils.getString(this.f516a, "plugin_state", (String) null);
        if (StringUtils.isValidString(string)) {
            if ("on".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* renamed from: c */
    public Boolean mo9713c() {
        return JsonUtils.getBoolean(this.f516a, "allow_file_access", (Boolean) null);
    }

    /* renamed from: d */
    public Boolean mo9714d() {
        return JsonUtils.getBoolean(this.f516a, "load_with_overview_mode", (Boolean) null);
    }

    /* renamed from: e */
    public Boolean mo9715e() {
        return JsonUtils.getBoolean(this.f516a, "use_wide_view_port", (Boolean) null);
    }

    /* renamed from: f */
    public Boolean mo9716f() {
        return JsonUtils.getBoolean(this.f516a, "allow_content_access", (Boolean) null);
    }

    /* renamed from: g */
    public Boolean mo9717g() {
        return JsonUtils.getBoolean(this.f516a, "use_built_in_zoom_controls", (Boolean) null);
    }

    /* renamed from: h */
    public Boolean mo9718h() {
        return JsonUtils.getBoolean(this.f516a, "display_zoom_controls", (Boolean) null);
    }

    /* renamed from: i */
    public Boolean mo9719i() {
        return JsonUtils.getBoolean(this.f516a, "save_form_data", (Boolean) null);
    }

    /* renamed from: j */
    public Boolean mo9720j() {
        return JsonUtils.getBoolean(this.f516a, "geolocation_enabled", (Boolean) null);
    }

    /* renamed from: k */
    public Boolean mo9721k() {
        return JsonUtils.getBoolean(this.f516a, "need_initial_focus", (Boolean) null);
    }

    /* renamed from: l */
    public Boolean mo9722l() {
        return JsonUtils.getBoolean(this.f516a, "allow_file_access_from_file_urls", (Boolean) null);
    }

    /* renamed from: m */
    public Boolean mo9723m() {
        return JsonUtils.getBoolean(this.f516a, "allow_universal_access_from_file_urls", (Boolean) null);
    }

    /* renamed from: n */
    public Boolean mo9724n() {
        return JsonUtils.getBoolean(this.f516a, "offscreen_pre_raster", (Boolean) null);
    }
}
