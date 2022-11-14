package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.android.play.core.tasks.C2349i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.am */
public final class C2184am extends C2182ak<List<String>> {

    /* renamed from: c */
    public final /* synthetic */ C2187ar f2900c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2184am(C2187ar arVar, C2349i<List<String>> iVar) {
        super(arVar, iVar);
        this.f2900c = arVar;
    }

    /* renamed from: a */
    public final void mo33157a(List<Bundle> list) {
        this.f2899b.f2910e.mo33285a();
        C2187ar.f2906a.mo33278a(4, "onGetSessionStates", new Object[0]);
        C2187ar arVar = this.f2900c;
        ArrayList arrayList = new ArrayList();
        for (Bundle next : list) {
            C2218bz bzVar = arVar.f2909d;
            ArrayList arrayList2 = new ArrayList();
            C2195az azVar = C2197ba.f2947a;
            ArrayList<String> stringArrayList = next.getStringArrayList("pack_names");
            HashMap hashMap = new HashMap();
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = stringArrayList.get(i);
                hashMap.put(str, AssetPackState.m2820a(next, str, bzVar, azVar));
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                hashMap.put(str2, AssetPackState.m2821a(str2, 4, 0, 0, 0, RoundRectDrawableWithShadow.COS_45, 1));
            }
            next.getLong("total_bytes_to_download");
            AssetPackState assetPackState = (AssetPackState) hashMap.values().iterator().next();
            if (assetPackState == null) {
                C2187ar.f2906a.mo33278a(6, "onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            C2203bh bhVar = (C2203bh) assetPackState;
            int i2 = bhVar.f2962b;
            boolean z = true;
            if (!(i2 == 1 || i2 == 7 || i2 == 2 || i2 == 3)) {
                z = false;
            }
            if (z) {
                arrayList.add(bhVar.f2961a);
            }
        }
        this.f2898a.mo33331b(arrayList);
    }
}
