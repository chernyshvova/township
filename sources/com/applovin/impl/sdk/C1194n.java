package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1265i;
import com.applovin.impl.sdk.utils.C1301k;
import com.applovin.impl.sdk.utils.C1304n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.n */
public class C1194n implements AppLovinCommunicatorSubscriber, C1265i.C1266a {

    /* renamed from: a */
    public final C1188m f2224a;

    /* renamed from: b */
    public Object f2225b;

    /* renamed from: c */
    public WeakReference<View> f2226c = new WeakReference<>((Object) null);

    /* renamed from: d */
    public final Map<String, Bundle> f2227d = new HashMap();

    /* renamed from: e */
    public final Object f2228e = new Object();

    /* renamed from: f */
    public C1265i f2229f;

    /* renamed from: g */
    public C1304n f2230g;

    /* renamed from: h */
    public int f2231h;

    public C1194n(C1188m mVar) {
        this.f2224a = mVar;
        AppLovinCommunicator.getInstance(mVar.mo10932L()).subscribe((AppLovinCommunicatorSubscriber) this, "safedk_ad_info");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.widget.Button} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m2160a(final android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 40
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r0)
            int r1 = r0 / 10
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388629(0x800015, float:1.1754973E-38)
            r2.<init>(r0, r0, r3)
            r2.setMargins(r1, r1, r1, r1)
            android.widget.ImageButton r0 = new android.widget.ImageButton     // Catch:{ all -> 0x0030 }
            r0.<init>(r6)     // Catch:{ all -> 0x0030 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ all -> 0x0030 }
            int r4 = com.applovin.sdk.C1368R.C1369drawable.applovin_ic_white_small     // Catch:{ all -> 0x0030 }
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)     // Catch:{ all -> 0x0030 }
            r0.setImageDrawable(r3)     // Catch:{ all -> 0x0030 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ all -> 0x0030 }
            r0.setScaleType(r3)     // Catch:{ all -> 0x0030 }
            int r3 = r1 * 2
            r0.setPadding(r1, r1, r1, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x004c
        L_0x0030:
            android.widget.Button r0 = new android.widget.Button
            r0.<init>(r6)
            java.lang.String r1 = "ⓘ"
            r0.setText(r1)
            r1 = -1
            r0.setTextColor(r1)
            r1 = 0
            r0.setAllCaps(r1)
            r3 = 1101004800(0x41a00000, float:20.0)
            r4 = 2
            r0.setTextSize(r4, r3)
            r0.setPadding(r1, r1, r1, r1)
        L_0x004c:
            r0.setLayoutParams(r2)
            android.graphics.drawable.Drawable r1 = r5.m2170g()
            r0.setBackground(r1)
            com.applovin.impl.sdk.n$4 r1 = new com.applovin.impl.sdk.n$4
            r1.<init>(r6)
            r0.setOnClickListener(r1)
            boolean r1 = com.applovin.impl.sdk.utils.C1263g.m2508d()
            if (r1 == 0) goto L_0x006d
            r1 = 5
            int r6 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r1)
            float r6 = (float) r6
            r0.setElevation(r6)
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1194n.m2160a(android.app.Activity):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2162a(Context context) {
        final String h = m2171h();
        final WeakReference weakReference = new WeakReference(context);
        new AlertDialog.Builder(context).setTitle("Ad Info").setMessage(h).setNegativeButton("Close", (DialogInterface.OnClickListener) null).setPositiveButton("Report", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (weakReference.get() != null) {
                    C1194n.this.m2163a((Context) weakReference.get(), h);
                }
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2163a(Context context, String str) {
        C1301k kVar = new C1301k();
        kVar.mo11326b("Describe your issue below:\n\n\n").mo11322a("Ad Info:").mo11322a(str).mo11322a("\nDebug Info:\n").mo11323a("Platform", "fireos".equals(this.f2224a.mo10941V().mo11211f()) ? "Fire OS" : "Android").mo11323a("AppLovin SDK Version", AppLovinSdk.VERSION).mo11323a("Plugin Version", this.f2224a.mo10946a(C1085b.f1700dA)).mo11323a("Ad Review Version", Utils.getSafedkVersion()).mo11323a("App Package Name", context.getPackageName()).mo11323a("Device", Build.DEVICE).mo11323a("OS Version", Build.VERSION.RELEASE).mo11323a("AppLovin Random Token", this.f2224a.mo10998o()).mo11317a(m2168e());
        Intent intent = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", "MAX Ad Report").setPackage("com.google.android.gm");
        if (this.f2225b instanceof C1057e) {
            intent.putExtra("android.intent.extra.SUBJECT", "AppLovin Ad Report");
            JSONObject originalFullResponse = ((C1057e) this.f2225b).getOriginalFullResponse();
            Uri cacheTextWithFileName = AppLovinContentProviderUtils.cacheTextWithFileName(originalFullResponse.toString(), "ad_response.json");
            if (cacheTextWithFileName != null) {
                intent.putExtra("android.intent.extra.STREAM", cacheTextWithFileName);
            } else {
                kVar.mo11322a("\nAd Response:\n");
                kVar.mo11322a(originalFullResponse.toString());
            }
        }
        intent.putExtra("android.intent.extra.TEXT", kVar.toString());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage((String) null);
            context.startActivity(intent);
        }
    }

    @Nullable
    /* renamed from: d */
    private String m2167d() {
        Object obj = this.f2225b;
        if (obj instanceof C0801a) {
            return ((C0801a) obj).mo9833f();
        }
        if (C0867c.m939a(obj)) {
            return ((C1057e) this.f2225b).mo10563I();
        }
        return null;
    }

    @Nullable
    /* renamed from: e */
    private Bundle m2168e() {
        Bundle bundle;
        String d = m2167d();
        if (!StringUtils.isValidString(d)) {
            return null;
        }
        synchronized (this.f2228e) {
            bundle = this.f2227d.get(d);
        }
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2169f() {
        if (this.f2224a.mo10966ad().mo11252b() && this.f2226c.get() == null) {
            Activity a = this.f2224a.mo10967ae().mo10434a();
            View findViewById = a.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                C1314v B = this.f2224a.mo10922B();
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Displaying creative debugger button for ad: ");
                outline24.append(this.f2225b);
                B.mo11372b(AppLovinSdk.TAG, outline24.toString());
                final FrameLayout frameLayout = (FrameLayout) findViewById;
                final View a2 = m2160a(a);
                frameLayout.addView(a2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150);
                a2.startAnimation(alphaAnimation);
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (a2.getParent() == null) {
                            frameLayout.addView(a2);
                        }
                    }
                });
                this.f2226c = new WeakReference<>(a2);
            }
        }
    }

    /* renamed from: g */
    private Drawable m2170g() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* renamed from: h */
    private String m2171h() {
        C1301k kVar = new C1301k();
        Object obj = this.f2225b;
        if (obj instanceof C1057e) {
            C1057e eVar = (C1057e) obj;
            kVar.mo11323a("Network", "APPLOVIN").mo11320a(eVar).mo11325b(eVar);
        } else if (obj instanceof C0801a) {
            kVar.mo11319a((C0801a) obj);
        }
        kVar.mo11321a(this.f2224a);
        kVar.mo11317a(m2168e());
        return kVar.toString();
    }

    /* renamed from: a */
    public void mo11016a() {
        String d = m2167d();
        if (StringUtils.isValidString(d)) {
            synchronized (this.f2228e) {
                this.f2227d.remove(d);
            }
        }
        C1265i iVar = this.f2229f;
        if (iVar != null) {
            iVar.mo11280b();
        }
        this.f2225b = null;
        this.f2226c = new WeakReference<>((Object) null);
    }

    /* renamed from: a */
    public void mo11017a(Object obj) {
        if (!C0867c.m942b(obj)) {
            this.f2225b = obj;
            if (((Boolean) this.f2224a.mo10946a(C1085b.f1608bM)).booleanValue() && this.f2224a.mo10999p().isCreativeDebuggerEnabled()) {
                if (this.f2229f == null) {
                    this.f2229f = new C1265i(this.f2224a, this);
                }
                this.f2229f.mo11279a();
            }
        }
    }

    /* renamed from: b */
    public void mo11018b() {
        if (this.f2231h == 0) {
            this.f2230g = C1304n.m2612a(TimeUnit.SECONDS.toMillis(3), this.f2224a, new Runnable() {
                public void run() {
                    int unused = C1194n.this.f2231h = 0;
                }
            });
        }
        int i = this.f2231h;
        if (i % 2 == 0) {
            this.f2231h = i + 1;
        }
    }

    /* renamed from: c */
    public void mo11019c() {
        int i = this.f2231h;
        if (i % 2 == 1) {
            this.f2231h = i + 1;
        }
        if (this.f2231h / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C1194n.this.f2224a.mo10969ag().mo10893a(new Bundle(), "show_creative_debugger");
                    C1194n.this.m2169f();
                }
            });
            this.f2231h = 0;
            this.f2230g.mo11336d();
            this.f2229f.mo11280b();
        }
    }

    public String getCommunicatorId() {
        return C1194n.class.getSimpleName();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            String string = BundleUtils.getString("id", bundle2);
            MaxAdFormat formatFromString = MaxAdFormat.formatFromString(BundleUtils.getString(FirebaseAnalytics.Param.AD_FORMAT, bundle2));
            if (StringUtils.isValidString(string) && formatFromString != null && formatFromString.isFullscreenAd() && bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    bundle.remove(str);
                    BundleUtils.put(StringUtils.toHumanReadableString(str), obj, bundle);
                }
                synchronized (this.f2228e) {
                    this.f2227d.put(string, bundle);
                }
            }
        }
    }
}
