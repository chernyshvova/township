package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.android.billingclient.api.zzam;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2894c;
import com.iab.omid.library.vungle.p052c.C2899a;
import com.iab.omid.library.vungle.p052c.C2901b;
import com.iab.omid.library.vungle.p052c.C2902c;
import com.iab.omid.library.vungle.p052c.C2903d;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.walking.C2914a;
import com.iab.omid.library.vungle.walking.p055a.C2920c;
import com.iab.omid.library.vungle.walking.p055a.C2921d;
import com.iab.omid.library.vungle.walking.p055a.C2922e;
import com.iab.omid.library.vungle.walking.p055a.C2923f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class TreeWalker implements C2899a.C2900a {

    /* renamed from: a */
    public static TreeWalker f3539a = new TreeWalker();

    /* renamed from: b */
    public static Handler f3540b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public static Handler f3541c = null;

    /* renamed from: j */
    public static final Runnable f3542j = new Runnable() {
        public void run() {
            String str;
            TreeWalker treeWalker = TreeWalker.f3539a;
            treeWalker.f3545e = 0;
            treeWalker.f3549i = System.nanoTime();
            C2914a aVar = treeWalker.f3547g;
            if (aVar != null) {
                C2891a aVar2 = C2891a.f3501a;
                if (aVar2 != null) {
                    for (C2889a next : aVar2.mo36838c()) {
                        View d = next.mo36836d();
                        if (next.f3497g && !next.f3498h) {
                            String str2 = next.f3499i;
                            if (d != null) {
                                if (!d.hasWindowFocus()) {
                                    str = "noWindowFocus";
                                } else {
                                    HashSet hashSet = new HashSet();
                                    View view = d;
                                    while (true) {
                                        if (view == null) {
                                            aVar.f3554d.addAll(hashSet);
                                            str = null;
                                            break;
                                        }
                                        String e = zzam.m37e(view);
                                        if (e != null) {
                                            str = e;
                                            break;
                                        }
                                        hashSet.add(view);
                                        ViewParent parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                                if (str == null) {
                                    aVar.f3555e.add(str2);
                                    aVar.f3551a.put(d, str2);
                                    Iterator<C2894c> it = next.f3494d.iterator();
                                    if (it.hasNext()) {
                                        if (it.next() != null) {
                                            throw null;
                                        }
                                        throw null;
                                    }
                                } else {
                                    aVar.f3556f.add(str2);
                                    aVar.f3553c.put(str2, d);
                                    aVar.f3557g.put(str2, str);
                                }
                            } else {
                                aVar.f3556f.add(str2);
                                aVar.f3557g.put(str2, "noAdView");
                            }
                        }
                    }
                }
                long nanoTime = System.nanoTime();
                C2902c cVar = treeWalker.f3546f.f3520b;
                if (treeWalker.f3547g.f3556f.size() > 0) {
                    Iterator<String> it2 = treeWalker.f3547g.f3556f.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        JSONObject a = cVar.mo36851a((View) null);
                        View view2 = treeWalker.f3547g.f3553c.get(next2);
                        C2903d dVar = treeWalker.f3546f.f3519a;
                        String str3 = treeWalker.f3547g.f3557g.get(next2);
                        if (str3 != null) {
                            JSONObject a2 = dVar.mo36851a(view2);
                            C2904b.m3502a(a2, next2);
                            try {
                                a2.put("notVisibleReason", str3);
                            } catch (JSONException e2) {
                                zzam.m26a("Error with setting not visible reason", (Exception) e2);
                            }
                            C2904b.m3504a(a, a2);
                        }
                        C2904b.m3500a(a);
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(next2);
                        C2924b bVar = treeWalker.f3548h;
                        bVar.f3571b.mo36870b(new C2922e(bVar, hashSet2, a, nanoTime));
                    }
                }
                if (treeWalker.f3547g.f3555e.size() > 0) {
                    JSONObject a3 = cVar.mo36851a((View) null);
                    cVar.mo36852a((View) null, a3, treeWalker, true);
                    C2904b.m3500a(a3);
                    C2924b bVar2 = treeWalker.f3548h;
                    bVar2.f3571b.mo36870b(new C2923f(bVar2, treeWalker.f3547g.f3555e, a3, nanoTime));
                } else {
                    C2924b bVar3 = treeWalker.f3548h;
                    bVar3.f3571b.mo36870b(new C2921d(bVar3));
                }
                C2914a aVar3 = treeWalker.f3547g;
                aVar3.f3551a.clear();
                aVar3.f3552b.clear();
                aVar3.f3553c.clear();
                aVar3.f3554d.clear();
                aVar3.f3555e.clear();
                aVar3.f3556f.clear();
                aVar3.f3557g.clear();
                aVar3.f3558h = false;
                long nanoTime2 = System.nanoTime() - treeWalker.f3549i;
                if (treeWalker.f3544d.size() > 0) {
                    for (TreeWalkerTimeLogger next3 : treeWalker.f3544d) {
                        next3.onTreeProcessed(treeWalker.f3545e, TimeUnit.NANOSECONDS.toMillis(nanoTime2));
                        if (next3 instanceof TreeWalkerNanoTimeLogger) {
                            ((TreeWalkerNanoTimeLogger) next3).onTreeProcessedNano(treeWalker.f3545e, nanoTime2);
                        }
                    }
                    return;
                }
                return;
            }
            throw null;
        }
    };

    /* renamed from: k */
    public static final Runnable f3543k = new Runnable() {
        public void run() {
            Handler handler = TreeWalker.f3541c;
            if (handler != null) {
                handler.post(TreeWalker.f3542j);
                TreeWalker.f3541c.postDelayed(TreeWalker.f3543k, 200);
            }
        }
    };

    /* renamed from: d */
    public List<TreeWalkerTimeLogger> f3544d = new ArrayList();

    /* renamed from: e */
    public int f3545e;

    /* renamed from: f */
    public C2901b f3546f = new C2901b();

    /* renamed from: g */
    public C2914a f3547g = new C2914a();

    /* renamed from: h */
    public C2924b f3548h = new C2924b(new C2920c());

    /* renamed from: i */
    public long f3549i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    /* renamed from: a */
    public void mo36860a() {
        if (f3541c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f3541c = handler;
            handler.post(f3542j);
            f3541c.postDelayed(f3543k, 200);
        }
    }

    /* renamed from: a */
    public void mo36861a(View view, C2899a aVar, JSONObject jSONObject) {
        String str;
        boolean z;
        C2925c cVar = C2925c.PARENT_VIEW;
        boolean z2 = false;
        if (zzam.m37e(view) == null) {
            C2914a aVar2 = this.f3547g;
            C2925c cVar2 = aVar2.f3554d.contains(view) ? cVar : aVar2.f3558h ? C2925c.OBSTRUCTION_VIEW : C2925c.UNDERLYING_VIEW;
            if (cVar2 != C2925c.UNDERLYING_VIEW) {
                JSONObject a = aVar.mo36851a(view);
                C2904b.m3504a(jSONObject, a);
                C2914a aVar3 = this.f3547g;
                if (aVar3.f3551a.size() == 0) {
                    str = null;
                } else {
                    String str2 = aVar3.f3551a.get(view);
                    if (str2 != null) {
                        aVar3.f3551a.remove(view);
                    }
                    str = str2;
                }
                if (str != null) {
                    try {
                        a.put("adSessionId", str);
                    } catch (JSONException e) {
                        zzam.m26a("Error with setting ad session id", (Exception) e);
                    }
                    this.f3547g.f3558h = true;
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    C2914a aVar4 = this.f3547g;
                    C2914a.C2915a aVar5 = aVar4.f3552b.get(view);
                    if (aVar5 != null) {
                        aVar4.f3552b.remove(view);
                    }
                    if (aVar5 != null) {
                        C2904b.m3501a(a, aVar5);
                    }
                    if (cVar2 == cVar) {
                        z2 = true;
                    }
                    aVar.mo36852a(view, a, this, z2);
                }
                this.f3545e++;
            }
        }
    }
}
