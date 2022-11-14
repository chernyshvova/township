package com.applovin.impl.sdk;

import androidx.annotation.Nullable;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.sdk.AppLovinSdk;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.x */
public class C1317x {

    /* renamed from: a */
    public final Queue<AppLovinAdImpl> f2580a = new LinkedList();

    /* renamed from: b */
    public final Object f2581b = new Object();

    /* renamed from: a */
    public int mo11380a() {
        int size;
        synchronized (this.f2581b) {
            size = this.f2580a.size();
        }
        return size;
    }

    /* renamed from: a */
    public void mo11381a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f2581b) {
            if (mo11380a() <= 25) {
                this.f2580a.offer(appLovinAdImpl);
            } else {
                C1314v.m2663i(AppLovinSdk.TAG, "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    /* renamed from: b */
    public boolean mo11382b() {
        boolean z;
        synchronized (this.f2581b) {
            z = mo11380a() == 0;
        }
        return z;
    }

    @Nullable
    /* renamed from: c */
    public AppLovinAdImpl mo11383c() {
        AppLovinAdImpl poll;
        synchronized (this.f2581b) {
            poll = !mo11382b() ? this.f2580a.poll() : null;
        }
        return poll;
    }

    @Nullable
    /* renamed from: d */
    public AppLovinAdImpl mo11384d() {
        AppLovinAdImpl peek;
        synchronized (this.f2581b) {
            peek = this.f2580a.peek();
        }
        return peek;
    }
}
