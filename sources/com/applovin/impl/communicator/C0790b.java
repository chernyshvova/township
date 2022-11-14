package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1314v;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.b */
public class C0790b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public boolean f531a = true;

    /* renamed from: b */
    public final String f532b;

    /* renamed from: c */
    public final WeakReference<AppLovinCommunicatorSubscriber> f533c;

    /* renamed from: d */
    public final Set<CommunicatorMessageImpl> f534d = new LinkedHashSet();

    /* renamed from: e */
    public final Object f535e = new Object();

    public C0790b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f532b = str;
        this.f533c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    /* renamed from: a */
    public String mo9738a() {
        return this.f532b;
    }

    /* renamed from: a */
    public void mo9739a(boolean z) {
        this.f531a = z;
    }

    /* renamed from: b */
    public AppLovinCommunicatorSubscriber mo9740b() {
        return (AppLovinCommunicatorSubscriber) this.f533c.get();
    }

    /* renamed from: c */
    public boolean mo9741c() {
        return this.f531a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0790b)) {
            return false;
        }
        C0790b bVar = (C0790b) obj;
        if (mo9738a().equals(bVar.mo9738a())) {
            if (this.f533c.get() != null) {
                if (((AppLovinCommunicatorSubscriber) this.f533c.get()).equals(bVar.f533c.get())) {
                    return true;
                }
            } else if (this.f533c.get() == bVar.f533c.get()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f532b.hashCode() * 31) + (this.f533c.get() != null ? ((AppLovinCommunicatorSubscriber) this.f533c.get()).hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        if (mo9740b() == null) {
            C1314v.m2663i("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.f535e) {
            if (!this.f534d.contains(communicatorMessageImpl)) {
                this.f534d.add(communicatorMessageImpl);
                z = true;
            }
        }
        if (z) {
            mo9740b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }
}
