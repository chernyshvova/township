package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C2292ag;
import com.google.android.play.core.internal.C2302aq;
import com.google.android.play.core.internal.C2304bz;
import com.google.android.play.core.internal.C2324t;
import com.google.android.play.core.tasks.C2349i;
import com.google.android.play.core.tasks.C2353m;
import com.google.android.play.core.tasks.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.ar */
public final class C2187ar implements C2281w {

    /* renamed from: a */
    public static final C2292ag f2906a = new C2292ag("AssetPackServiceImpl");

    /* renamed from: b */
    public static final Intent f2907b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");

    /* renamed from: c */
    public final String f2908c;

    /* renamed from: d */
    public final C2218bz f2909d;
    @Nullable

    /* renamed from: e */
    public C2302aq<C2324t> f2910e;
    @Nullable

    /* renamed from: f */
    public C2302aq<C2324t> f2911f;

    /* renamed from: g */
    public final AtomicBoolean f2912g = new AtomicBoolean();

    public C2187ar(Context context, C2218bz bzVar) {
        this.f2908c = context.getPackageName();
        this.f2909d = bzVar;
        if (C2304bz.m2991a(context)) {
            Context applicationContext = context.getApplicationContext();
            this.f2910e = new C2302aq(applicationContext != null ? applicationContext : context, f2906a, "AssetPackService", f2907b, C2282x.f3223a);
            Context applicationContext2 = context.getApplicationContext();
            this.f2911f = new C2302aq(applicationContext2 != null ? applicationContext2 : context, f2906a, "AssetPackService-keepAlive", f2907b, C2283y.f3224a);
        }
        f2906a.mo33278a(3, "AssetPackService initiated.", new Object[0]);
    }

    /* renamed from: b */
    public static /* synthetic */ Bundle m2837b(Map map) {
        Bundle e = m2840e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e.putParcelableArrayList("installed_asset_module", arrayList);
        return e;
    }

    /* renamed from: c */
    public static Bundle m2838c(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        bundle.putString("module_name", str);
        bundle.putString("slice_id", str2);
        bundle.putInt("chunk_number", i2);
        return bundle;
    }

    /* renamed from: d */
    public static <T> Task<T> m2839d() {
        f2906a.mo33278a(6, "onError(%d)", new Object[]{-11});
        AssetPackException assetPackException = new AssetPackException(-11);
        C2353m mVar = new C2353m();
        mVar.mo33334a((Exception) assetPackException);
        return mVar;
    }

    /* renamed from: e */
    public static Bundle m2840e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10802);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: a */
    public final Task<List<String>> mo33159a(Map<String, Long> map) {
        if (this.f2910e == null) {
            return m2839d();
        }
        f2906a.mo33278a(4, "syncPacks", new Object[0]);
        C2349i iVar = new C2349i();
        this.f2910e.mo33286a(new C2176ad(this, iVar, map, iVar));
        return iVar.f3302a;
    }

    /* renamed from: a */
    public final void mo33162a(int i, String str) {
        mo33163a(i, str, 10);
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo33166b(int i, String str, String str2, int i2) {
        if (this.f2910e == null) {
            return m2839d();
        }
        f2906a.mo33278a(4, "getChunkFileDescriptor(%s, %s, %d, session=%d)", new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i)});
        C2349i iVar = new C2349i();
        this.f2910e.mo33286a(new C2180ai(this, iVar, i, str, str2, i2, iVar));
        return iVar.f3302a;
    }

    /* renamed from: a */
    public final synchronized void mo33160a() {
        if (this.f2911f == null) {
            f2906a.mo33278a(5, "Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        f2906a.mo33278a(4, "keepAlive", new Object[0]);
        if (!this.f2912g.compareAndSet(false, true)) {
            f2906a.mo33278a(4, "Service is already kept alive.", new Object[0]);
            return;
        }
        C2349i iVar = new C2349i();
        this.f2911f.mo33286a(new C2181aj(this, iVar, iVar));
    }

    /* renamed from: a */
    public final void mo33161a(int i) {
        if (this.f2910e != null) {
            f2906a.mo33278a(4, "notifySessionFailed", new Object[0]);
            C2349i iVar = new C2349i();
            this.f2910e.mo33286a(new C2179ah(this, iVar, i, iVar));
            return;
        }
        throw new C2214bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo33163a(int i, String str, int i2) {
        if (this.f2910e != null) {
            f2906a.mo33278a(4, "notifyModuleCompleted", new Object[0]);
            C2349i iVar = new C2349i();
            this.f2910e.mo33286a(new C2178ag(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C2214bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo33164a(int i, String str, String str2, int i2) {
        if (this.f2910e != null) {
            f2906a.mo33278a(4, "notifyChunkTransferred", new Object[0]);
            C2349i iVar = new C2349i();
            this.f2910e.mo33286a(new C2177af(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C2214bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo33165a(List<String> list) {
        if (this.f2910e != null) {
            f2906a.mo33278a(4, "cancelDownloads(%s)", new Object[]{list});
            C2349i iVar = new C2349i();
            this.f2910e.mo33286a(new C2175ac(this, iVar, list, iVar));
        }
    }
}
