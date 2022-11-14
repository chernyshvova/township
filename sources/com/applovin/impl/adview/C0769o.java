package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.activity.p009b.C0670a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p025ad.C1064g;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.o */
public class C0769o implements AppLovinInterstitialAdDialog {

    /* renamed from: a */
    public final C1188m f474a;

    /* renamed from: b */
    public final WeakReference<Context> f475b;

    /* renamed from: c */
    public volatile AppLovinAdLoadListener f476c;

    /* renamed from: d */
    public volatile AppLovinAdDisplayListener f477d;

    /* renamed from: e */
    public volatile AppLovinAdVideoPlaybackListener f478e;

    /* renamed from: f */
    public volatile AppLovinAdClickListener f479f;

    /* renamed from: g */
    public volatile C1057e f480g;

    /* renamed from: h */
    public volatile C1057e.C1060b f481h;

    /* renamed from: i */
    public ViewGroup f482i;

    /* renamed from: j */
    public AppLovinFullscreenAdViewObserver f483j;

    /* renamed from: k */
    public C0670a f484k;

    public C0769o(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f474a = appLovinSdk.coreSdk;
            this.f475b = new WeakReference<>(context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m549a(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0769o.this.f476c != null) {
                    C0769o.this.f476c.failedToReceiveAd(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m550a(Context context) {
        Intent intent = new Intent(context, AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f474a.mo11010z());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private void m554a(C1057e eVar, final Context context) {
        if (this.f474a.mo10967ae().mo10436b() == null) {
            eVar.mo10621b(true);
            this.f474a.mo10939T().mo10757a(C1103f.f1935m);
        }
        if (((Boolean) this.f474a.mo10946a(C1085b.f1763eL)).booleanValue()) {
            this.f474a.mo10938S().mo10833b().execute(new Runnable() {
                public void run() {
                    System.gc();
                }
            });
        }
        this.f480g = eVar;
        this.f481h = this.f480g.mo10624n();
        final long max = Math.max(0, ((Long) this.f474a.mo10946a(C1085b.f1690cq)).longValue());
        C1314v B = this.f474a.mo10922B();
        B.mo11372b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        m555a(eVar, context, new Runnable() {
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (C0769o.this.f482i == null || C0769o.this.f483j == null) {
                            C0769o.this.f474a.mo10922B().mo11372b("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
                            C07723 r0 = C07723.this;
                            C0769o.this.m550a(context);
                            return;
                        }
                        C1314v B = C0769o.this.f474a.mo10922B();
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Presenting ad in a containerView(");
                        outline24.append(C0769o.this.f482i);
                        outline24.append(")");
                        B.mo11372b("InterstitialAdDialogWrapper", outline24.toString());
                        C0769o.this.f482i.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        C1057e c = C0769o.this.f480g;
                        AppLovinAdClickListener d = C0769o.this.f479f;
                        AppLovinAdDisplayListener e = C0769o.this.f477d;
                        AppLovinAdVideoPlaybackListener f = C0769o.this.f478e;
                        C0769o oVar = C0769o.this;
                        C0670a.m207a(c, d, e, f, oVar.f474a, (Activity) oVar.m563f(), new C0670a.C0682a() {
                            /* renamed from: a */
                            public void mo9256a(C0670a aVar) {
                                C0670a unused = C0769o.this.f484k = aVar;
                                C0769o.this.f483j.setPresenter(aVar);
                                aVar.mo9451a(C0769o.this.f482i);
                            }

                            /* renamed from: a */
                            public void mo9257a(String str, Throwable th) {
                                C0769o.m556a(C0769o.this.f480g, C0769o.this.f477d, str, th, (AppLovinFullscreenActivity) null);
                            }
                        });
                    }
                }, max);
            }
        });
    }

    /* renamed from: a */
    private void m555a(C1057e eVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(eVar.mo10563I()) || !eVar.mo10597ac() || C1264h.m2521a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(eVar.mo10598ad()).setMessage(eVar.mo10599ae()).setPositiveButton(eVar.mo10600af(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* renamed from: a */
    public static void m556a(C1057e eVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, @Nullable Throwable th, @Nullable AppLovinFullscreenActivity appLovinFullscreenActivity) {
        C1314v.m2659c("InterstitialAdDialogWrapper", str, th);
        if (appLovinAdDisplayListener instanceof C1064g) {
            C1267j.m2561a(appLovinAdDisplayListener, str);
        } else {
            C1267j.m2572b(appLovinAdDisplayListener, (AppLovinAd) eVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    /* renamed from: a */
    private void m557a(AppLovinAd appLovinAd) {
        if (this.f477d != null) {
            this.f477d.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m559b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (C0769o.this.f476c != null) {
                    C0769o.this.f476c.adReceived(appLovinAd);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public Context m563f() {
        return (Context) this.f475b.get();
    }

    /* renamed from: a */
    public C1057e mo9675a() {
        return this.f480g;
    }

    /* renamed from: a */
    public void mo9676a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f474a.mo11005u().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: b */
    public AppLovinAdVideoPlaybackListener mo9677b() {
        return this.f478e;
    }

    /* renamed from: c */
    public AppLovinAdDisplayListener mo9678c() {
        return this.f477d;
    }

    /* renamed from: d */
    public AppLovinAdClickListener mo9679d() {
        return this.f479f;
    }

    /* renamed from: e */
    public void mo9680e() {
        this.f482i = null;
        this.f483j = null;
        this.f479f = null;
        this.f476c = null;
        this.f478e = null;
        this.f477d = null;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f479f = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f477d = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f476c = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f478e = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        mo9676a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                C0769o.this.m559b(appLovinAd);
                C0769o.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i) {
                C0769o.this.m549a(i);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        String str;
        Context f = m563f();
        if (f == null) {
            str = "Failed to show interstitial: stale activity reference provided";
        } else {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f474a);
            if (maybeRetrieveNonDummyAd == null) {
                str = "Failed to show ad: " + appLovinAd;
            } else if (((AppLovinAdImpl) maybeRetrieveNonDummyAd).hasShown() && ((Boolean) this.f474a.mo10946a(C1085b.f1678ce)).booleanValue()) {
                throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
            } else if (maybeRetrieveNonDummyAd instanceof C1057e) {
                m554a((C1057e) maybeRetrieveNonDummyAd, f);
                return;
            } else {
                this.f474a.mo10922B().mo11376e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + maybeRetrieveNonDummyAd + "'");
                m557a(maybeRetrieveNonDummyAd);
                return;
            }
        }
        C1314v.m2663i("InterstitialAdDialogWrapper", str);
        m557a(appLovinAd);
    }

    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup == null || lifecycle == null) {
            C1314v.m2663i("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null containerView or lifecycle");
            m557a(appLovinAd);
            return;
        }
        this.f482i = viewGroup;
        AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.f474a);
        this.f483j = appLovinFullscreenAdViewObserver;
        lifecycle.addObserver(appLovinFullscreenAdViewObserver);
        showAndRender(appLovinAd);
    }

    @NonNull
    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
