package com.applovin.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C0758k;
import com.applovin.impl.adview.C0769o;
import com.applovin.impl.adview.activity.C0657a;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.p009b.C0670a;
import com.applovin.impl.adview.activity.p009b.C0692e;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenActivity extends Activity implements C0758k {
    @SuppressLint({"StaticFieldLeak"})
    public static C0769o parentInterstitialWrapper;

    /* renamed from: a */
    public C1188m f42a;

    /* renamed from: b */
    public C0670a f43b;

    /* renamed from: c */
    public final AtomicBoolean f44c = new AtomicBoolean(true);

    /* renamed from: d */
    public C0657a f45d;

    public void dismiss() {
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9466h();
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9470l();
        }
        if (Utils.isAppLovinTestEnvironment(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9450a(configuration);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            if (bundle.getBoolean("com.applovin.dismiss_on_restore", false)) {
                C1314v.m2662h("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
                dismiss();
                return;
            }
            C1314v.m2660f("AppLovinFullscreenActivity", "Activity was destroyed while in background.");
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        findViewById(16908290).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f42a = AppLovinSdk.getInstance(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"), new AppLovinSdkSettings(this), this).coreSdk;
        C0769o oVar = parentInterstitialWrapper;
        if (oVar != null) {
            C0670a.m207a(oVar.mo9675a(), parentInterstitialWrapper.mo9679d(), parentInterstitialWrapper.mo9678c(), parentInterstitialWrapper.mo9677b(), this.f42a, this, new C0670a.C0682a() {
                /* renamed from: a */
                public void mo9256a(C0670a aVar) {
                    C0670a unused = AppLovinFullscreenActivity.this.f43b = aVar;
                    aVar.mo9462d();
                }

                /* renamed from: a */
                public void mo9257a(String str, Throwable th) {
                    C0769o.m556a(AppLovinFullscreenActivity.parentInterstitialWrapper.mo9675a(), AppLovinFullscreenActivity.parentInterstitialWrapper.mo9678c(), str, th, AppLovinFullscreenActivity.this);
                }
            });
            return;
        }
        Intent intent = new Intent(this, FullscreenAdService.class);
        C0657a aVar = new C0657a(this, this.f42a);
        this.f45d = aVar;
        bindService(intent, aVar, 1);
        if (C1263g.m2511g()) {
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    public void onDestroy() {
        parentInterstitialWrapper = null;
        C0657a aVar = this.f45d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        C0670a aVar2 = this.f43b;
        if (aVar2 != null) {
            aVar2.mo9468j();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9447a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9469k();
        }
        super.onLowMemory();
    }

    public void onPause() {
        super.onPause();
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9465g();
        }
    }

    public void onResume() {
        C0670a aVar;
        try {
            super.onResume();
            if (!this.f44c.get() && (aVar = this.f43b) != null) {
                aVar.mo9464f();
            }
        } catch (IllegalArgumentException e) {
            this.f42a.mo10922B().mo11373b("AppLovinFullscreenActivity", "Error was encountered in onResume().", e);
            dismiss();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1188m mVar = this.f42a;
        if (mVar != null) {
            bundle.putBoolean("com.applovin.dismiss_on_restore", ((Boolean) mVar.mo10946a(C1085b.f1771eT)).booleanValue());
        }
    }

    public void onStop() {
        super.onStop();
        C0670a aVar = this.f43b;
        if (aVar != null) {
            aVar.mo9467i();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.f43b != null) {
            if (!this.f44c.getAndSet(false) || (this.f43b instanceof C0692e)) {
                this.f43b.mo9461c(z);
            }
            if (z) {
                getWindow().getDecorView().setSystemUiVisibility(5894);
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void setPresenter(C0670a aVar) {
        this.f43b = aVar;
    }
}
