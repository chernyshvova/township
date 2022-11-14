package com.iab.omid.library.vungle.p051b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.walking.TreeWalker;

/* renamed from: com.iab.omid.library.vungle.b.b */
public class C2892b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    public static C2892b f3504a = new C2892b();

    /* renamed from: b */
    public boolean f3505b;

    /* renamed from: c */
    public boolean f3506c;

    /* renamed from: d */
    public C2893a f3507d;

    /* renamed from: com.iab.omid.library.vungle.b.b$a */
    public interface C2893a {
    }

    /* renamed from: a */
    public final void mo36840a(boolean z) {
        if (this.f3506c != z) {
            this.f3506c = z;
            if (this.f3505b) {
                mo36841e();
                C2893a aVar = this.f3507d;
                if (aVar != null) {
                    boolean z2 = !z;
                    if (((C2898f) aVar) == null) {
                        throw null;
                    } else if (z2) {
                        TreeWalker.f3539a.mo36860a();
                    } else if (TreeWalker.f3539a != null) {
                        Handler handler = TreeWalker.f3541c;
                        if (handler != null) {
                            handler.removeCallbacks(TreeWalker.f3543k);
                            TreeWalker.f3541c = null;
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public final void mo36841e() {
        boolean z = !this.f3506c;
        for (C2889a aVar : C2891a.f3501a.mo36837b()) {
            AdSessionStatePublisher adSessionStatePublisher = aVar.f3496f;
            if (adSessionStatePublisher.f3526a.get() != null) {
                C2896e.f3510a.mo36849a(adSessionStatePublisher.getWebView(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        View d;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z = false;
        boolean z2 = runningAppProcessInfo.importance != 100;
        boolean z3 = true;
        for (C2889a next : C2891a.f3501a.mo36838c()) {
            if ((next.f3497g && !next.f3498h) && (d = next.mo36836d()) != null && d.hasWindowFocus()) {
                z3 = false;
            }
        }
        if (z2 && z3) {
            z = true;
        }
        mo36840a(z);
    }

    public void onActivityResumed(Activity activity) {
        mo36840a(false);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
