package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a */
public class C1008a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    public final List<C1256a> f1297a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    public WeakReference<Activity> f1298b = new WeakReference<>((Object) null);

    /* renamed from: c */
    public WeakReference<Activity> f1299c = new WeakReference<>((Object) null);

    public C1008a(Context context) {
        C1314v.m2660f(AppLovinSdk.TAG, "Attaching Activity lifecycle manager...");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.f1298b = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.f1299c = this.f1298b;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public Activity mo10434a() {
        return (Activity) this.f1298b.get();
    }

    /* renamed from: a */
    public void mo10435a(C1256a aVar) {
        this.f1297a.add(aVar);
    }

    /* renamed from: b */
    public Activity mo10436b() {
        return (Activity) this.f1299c.get();
    }

    /* renamed from: b */
    public void mo10437b(C1256a aVar) {
        this.f1297a.remove(aVar);
    }

    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(@NonNull Activity activity) {
        this.f1299c = new WeakReference<>((Object) null);
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityPaused(activity);
        }
    }

    public void onActivityResumed(@NonNull Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f1298b = weakReference;
        this.f1299c = weakReference;
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityStarted(activity);
        }
    }

    public void onActivityStopped(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.f1297a).iterator();
        while (it.hasNext()) {
            ((C1256a) it.next()).onActivityStopped(activity);
        }
    }
}
