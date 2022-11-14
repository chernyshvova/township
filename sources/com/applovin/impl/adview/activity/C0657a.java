package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0769o;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.p009b.C0670a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1146p;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.activity.a */
public class C0657a implements ServiceConnection {

    /* renamed from: a */
    public final C1188m f193a;

    /* renamed from: b */
    public final C1314v f194b;

    /* renamed from: c */
    public final WeakReference<AppLovinFullscreenActivity> f195c;

    /* renamed from: d */
    public final AtomicBoolean f196d = new AtomicBoolean();

    /* renamed from: e */
    public Messenger f197e;

    /* renamed from: com.applovin.impl.adview.activity.a$a */
    public class C0660a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        public C0660a() {
        }

        /* renamed from: a */
        private void m195a(Bundle bundle, FullscreenAdService.C0656b bVar) {
            Message obtain = Message.obtain((Handler) null, bVar.mo9427a());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                C0657a.this.f197e.send(obtain);
            } catch (RemoteException e) {
                C1314v b = C0657a.this.f194b;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to forward callback (");
                outline24.append(bVar.mo9427a());
                outline24.append(")");
                b.mo11373b("AppLovinFullscreenActivity", outline24.toString(), e);
            }
        }

        /* renamed from: a */
        private void m196a(FullscreenAdService.C0656b bVar) {
            m195a((Bundle) null, bVar);
        }

        public void adClicked(AppLovinAd appLovinAd) {
            m196a(FullscreenAdService.C0656b.AD_CLICKED);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            m196a(FullscreenAdService.C0656b.AD_DISPLAYED);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            m196a(FullscreenAdService.C0656b.AD_HIDDEN);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            m196a(FullscreenAdService.C0656b.AD_VIDEO_STARTED);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d);
            bundle.putBoolean("fully_watched", z);
            m195a(bundle, FullscreenAdService.C0656b.AD_VIDEO_ENDED);
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.a$b */
    public static class C0661b extends Handler {

        /* renamed from: a */
        public final WeakReference<C0657a> f204a;

        public C0661b(C0657a aVar) {
            this.f204a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C0657a aVar;
            if (message.what != FullscreenAdService.C0656b.AD.mo9427a() || (aVar = (C0657a) this.f204a.get()) == null) {
                super.handleMessage(message);
                return;
            }
            aVar.m188a(C1053b.m1464a(message.getData().getInt("ad_source")), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
        }
    }

    public C0657a(AppLovinFullscreenActivity appLovinFullscreenActivity, C1188m mVar) {
        this.f193a = mVar;
        this.f194b = mVar.mo10922B();
        this.f195c = new WeakReference<>(appLovinFullscreenActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m186a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.f195c.get();
        if (appLovinFullscreenActivity != null) {
            this.f194b.mo11372b("AppLovinFullscreenActivity", "Dismissing...");
            appLovinFullscreenActivity.dismiss();
            return;
        }
        this.f194b.mo11376e("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m188a(C1053b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C1053b bVar2 = bVar;
            this.f193a.mo10938S().mo10828a((C1109a) new C1146p(jSONObject, C1056d.m1473a(JsonUtils.getString(jSONObject, "zone_id", "")), bVar2, new AppLovinAdLoadListener() {
                public void adReceived(final AppLovinAd appLovinAd) {
                    final AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) C0657a.this.f195c.get();
                    C1314v b = C0657a.this.f194b;
                    if (appLovinFullscreenActivity != null) {
                        b.mo11372b("AppLovinFullscreenActivity", "Presenting ad...");
                        final C0660a aVar = new C0660a();
                        C0670a.m207a((C1057e) appLovinAd, aVar, aVar, aVar, C0657a.this.f193a, appLovinFullscreenActivity, new C0670a.C0682a() {
                            /* renamed from: a */
                            public void mo9256a(C0670a aVar) {
                                appLovinFullscreenActivity.setPresenter(aVar);
                                aVar.mo9462d();
                            }

                            /* renamed from: a */
                            public void mo9257a(String str, Throwable th) {
                                C0769o.m556a((C1057e) appLovinAd, aVar, str, th, appLovinFullscreenActivity);
                            }
                        });
                        return;
                    }
                    b.mo11376e("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                }

                public void failedToReceiveAd(int i) {
                    C0657a.this.m186a();
                }
            }, this.f193a));
        } catch (JSONException e) {
            C1314v vVar = this.f194b;
            vVar.mo11373b("AppLovinFullscreenActivity", "Unable to process ad: " + str, e);
            m186a();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f196d.compareAndSet(false, true)) {
            C1314v vVar = this.f194b;
            vVar.mo11372b("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            this.f197e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.C0656b.AD.mo9427a());
            obtain.replyTo = new Messenger(new C0661b());
            try {
                this.f194b.mo11372b("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                this.f197e.send(obtain);
            } catch (RemoteException e) {
                this.f194b.mo11373b("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e);
                m186a();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f196d.compareAndSet(true, false)) {
            C1314v vVar = this.f194b;
            vVar.mo11372b("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
