package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1175k;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.l */
public class C1181l implements C1175k.C1180a, AppLovinWebViewActivity.EventListener {

    /* renamed from: a */
    public static final AtomicBoolean f2137a = new AtomicBoolean();

    /* renamed from: b */
    public static WeakReference<AppLovinWebViewActivity> f2138b;

    /* renamed from: c */
    public final C1188m f2139c;

    /* renamed from: d */
    public final C1314v f2140d;

    /* renamed from: e */
    public AppLovinUserService.OnConsentDialogDismissListener f2141e;

    /* renamed from: f */
    public C1175k f2142f;

    /* renamed from: g */
    public WeakReference<Activity> f2143g = new WeakReference<>((Object) null);

    /* renamed from: h */
    public C1256a f2144h;

    /* renamed from: i */
    public AtomicBoolean f2145i = new AtomicBoolean();

    public C1181l(C1188m mVar) {
        this.f2139c = mVar;
        this.f2140d = mVar.mo10922B();
        if (mVar.mo10933N() != null) {
            this.f2143g = new WeakReference<>(mVar.mo10933N());
        }
        mVar.mo10967ae().mo10435a(new C1256a() {
            public void onActivityStarted(Activity activity) {
                WeakReference unused = C1181l.this.f2143g = new WeakReference(activity);
            }
        });
        this.f2142f = new C1175k(this, mVar);
    }

    /* renamed from: a */
    private void m2038a(boolean z, long j) {
        m2046g();
        if (z) {
            mo10912a(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2040a(C1188m mVar) {
        if (mo10915d()) {
            C1314v.m2663i(AppLovinSdk.TAG, "Consent dialog already showing");
            return false;
        } else if (!C1264h.m2521a(mVar.mo10932L())) {
            C1314v.m2663i(AppLovinSdk.TAG, "No internet available, skip showing of consent dialog");
            return false;
        } else if (!((Boolean) mVar.mo10946a(C1085b.f1592ax)).booleanValue()) {
            this.f2140d.mo11376e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            return false;
        } else if (StringUtils.isValidString((String) mVar.mo10946a(C1085b.f1593ay))) {
            return true;
        } else {
            this.f2140d.mo11376e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            return false;
        }
    }

    /* renamed from: g */
    private void m2046g() {
        this.f2139c.mo10967ae().mo10437b(this.f2144h);
        if (mo10915d()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) f2138b.get();
            f2138b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f2141e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f2141e = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10910a() {
        if (this.f2143g.get() != null) {
            final Activity activity = (Activity) this.f2143g.get();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1181l.this.mo10913a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f2139c.mo10946a(C1085b.f1545aA)).longValue());
        }
    }

    /* renamed from: a */
    public void mo10912a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1181l.this.f2140d.mo11372b("ConsentDialogManager", "Scheduling repeating consent alert");
                C1181l.this.f2142f.mo10905a(j, C1181l.this.f2139c, C1181l.this);
            }
        });
    }

    /* renamed from: a */
    public void mo10913a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                C1181l lVar = C1181l.this;
                if (!lVar.m2040a(lVar.f2139c) || C1181l.f2137a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                        return;
                    }
                    return;
                }
                WeakReference unused = C1181l.this.f2143g = new WeakReference(activity);
                AppLovinUserService.OnConsentDialogDismissListener unused2 = C1181l.this.f2141e = onConsentDialogDismissListener;
                C1256a unused3 = C1181l.this.f2144h = new C1256a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!C1181l.this.mo10915d() || C1181l.f2138b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                WeakReference unused = C1181l.f2138b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) C1181l.this.f2139c.mo10946a(C1085b.f1593ay), C1181l.this);
                            }
                            C1181l.f2137a.set(false);
                        }
                    }
                };
                C1181l.this.f2139c.mo10967ae().mo10435a(C1181l.this.f2144h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, C1181l.this.f2139c.mo11010z());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) C1181l.this.f2139c.mo10946a(C1085b.f1594az));
                activity.startActivity(intent);
            }
        });
    }

    /* renamed from: b */
    public void mo10911b() {
    }

    /* renamed from: c */
    public void mo10914c() {
        if (!this.f2145i.getAndSet(true)) {
            final String str = (String) this.f2139c.mo10946a(C1085b.f1593ay);
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    new WebView(C1181l.this.f2139c.mo10932L()).loadUrl(str);
                }
            });
        }
    }

    /* renamed from: d */
    public boolean mo10915d() {
        WeakReference<AppLovinWebViewActivity> weakReference = f2138b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        C1188m mVar;
        C1085b bVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f2139c.mo10932L());
            m2046g();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f2139c.mo10932L());
            booleanValue = ((Boolean) this.f2139c.mo10946a(C1085b.f1546aB)).booleanValue();
            mVar = this.f2139c;
            bVar = C1085b.f1551aG;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2139c.mo10946a(C1085b.f1547aC)).booleanValue();
            mVar = this.f2139c;
            bVar = C1085b.f1552aH;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2139c.mo10946a(C1085b.f1548aD)).booleanValue();
            mVar = this.f2139c;
            bVar = C1085b.f1553aI;
        } else {
            return;
        }
        m2038a(booleanValue, ((Long) mVar.mo10946a(bVar)).longValue());
    }
}
