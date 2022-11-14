package com.iab.omid.library.applovin.p045b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.applovin.adsession.C2839a;

/* renamed from: com.iab.omid.library.applovin.b.b */
public class C2842b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    public static C2842b f3396a = new C2842b();

    /* renamed from: b */
    public boolean f3397b;

    /* renamed from: c */
    public boolean f3398c;

    /* renamed from: d */
    public C2843a f3399d;

    /* renamed from: com.iab.omid.library.applovin.b.b$a */
    public interface C2843a {
        /* renamed from: a */
        void mo36727a(boolean z);
    }

    /* renamed from: a */
    public static C2842b m3292a() {
        return f3396a;
    }

    /* renamed from: a */
    private void m3293a(boolean z) {
        if (this.f3398c != z) {
            this.f3398c = z;
            if (this.f3397b) {
                m3294e();
                C2843a aVar = this.f3399d;
                if (aVar != null) {
                    aVar.mo36727a(!z);
                }
            }
        }
    }

    /* renamed from: e */
    private void m3294e() {
        boolean z = !this.f3398c;
        for (C2839a adSessionStatePublisher : C2841a.m3285a().mo36710b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo36774a(z);
        }
    }

    /* renamed from: a */
    public void mo36715a(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: a */
    public void mo36716a(C2843a aVar) {
        this.f3399d = aVar;
    }

    /* renamed from: b */
    public void mo36717b() {
        this.f3397b = true;
        this.f3398c = false;
        m3294e();
    }

    /* renamed from: c */
    public void mo36718c() {
        this.f3397b = false;
        this.f3398c = false;
        this.f3399d = null;
    }

    @RequiresApi(api = 16)
    @VisibleForTesting
    /* renamed from: d */
    public ActivityManager.RunningAppProcessInfo mo36719d() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        m3293a(false);
    }

    public void onActivityStopped(Activity activity) {
        View e;
        boolean z = true;
        boolean z2 = mo36719d().importance != 100;
        boolean z3 = true;
        for (C2839a next : C2841a.m3285a().mo36712c()) {
            if (next.mo36679f() && (e = next.mo36678e()) != null && e.hasWindowFocus()) {
                z3 = false;
            }
        }
        if (!z2 || !z3) {
            z = false;
        }
        m3293a(z);
    }
}
