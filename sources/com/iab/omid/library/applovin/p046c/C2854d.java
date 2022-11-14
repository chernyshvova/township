package com.iab.omid.library.applovin.p046c;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.applovin.p046c.C2850a;
import com.iab.omid.library.applovin.p047d.C2856b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.c.d */
public class C2854d implements C2850a {

    /* renamed from: a */
    public final int[] f3426a = new int[2];

    /* renamed from: a */
    private void m3347a(ViewGroup viewGroup, JSONObject jSONObject, C2850a.C2851a aVar, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo36757a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private void m3348b(ViewGroup viewGroup, JSONObject jSONObject, C2850a.C2851a aVar, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo36757a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo36755a(View view) {
        if (view == null) {
            return C2856b.m3356a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f3426a);
        int[] iArr = this.f3426a;
        return C2856b.m3356a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo36756a(View view, JSONObject jSONObject, C2850a.C2851a aVar, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m3347a(viewGroup, jSONObject, aVar, z2);
            } else {
                m3348b(viewGroup, jSONObject, aVar, z2);
            }
        }
    }
}
