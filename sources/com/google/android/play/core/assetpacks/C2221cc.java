package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.android.billingclient.api.zzam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.cc */
public final /* synthetic */ class C2221cc implements C2231co {

    /* renamed from: a */
    public final C2232cp f3049a;

    /* renamed from: b */
    public final Bundle f3050b;

    public C2221cc(C2232cp cpVar, Bundle bundle) {
        this.f3049a = cpVar;
        this.f3050b = bundle;
    }

    /* renamed from: a */
    public final Object mo33216a() {
        C2230cn cnVar;
        C2232cp cpVar = this.f3049a;
        Bundle bundle = this.f3050b;
        if (cpVar != null) {
            int i = bundle.getInt("session_id");
            if (i == 0) {
                return Boolean.FALSE;
            }
            Map<Integer, C2229cm> map = cpVar.f3082f;
            Integer valueOf = Integer.valueOf(i);
            boolean z = false;
            if (map.containsKey(valueOf)) {
                C2229cm e = cpVar.mo33218e(i);
                int i2 = bundle.getInt(zzam.m20a("status", e.f3071c.f3064a));
                if (zzam.m29a(e.f3071c.f3066c, i2)) {
                    C2232cp.f3078a.mo33278a(3, "Found stale update for session %s with status %d.", new Object[]{valueOf, Integer.valueOf(e.f3071c.f3066c)});
                    C2228cl clVar = e.f3071c;
                    String str = clVar.f3064a;
                    int i3 = clVar.f3066c;
                    if (i3 == 4) {
                        cpVar.f3080c.mo33293a().mo33162a(i, str);
                    } else if (i3 == 5) {
                        cpVar.f3080c.mo33293a().mo33161a(i);
                    } else if (i3 == 6) {
                        cpVar.f3080c.mo33293a().mo33165a((List<String>) Arrays.asList(new String[]{str}));
                    }
                } else {
                    e.f3071c.f3066c = i2;
                    if (zzam.m32b(i2)) {
                        cpVar.mo33217a(new C2226ch(cpVar, i));
                        cpVar.f3081d.mo33215a(e.f3071c.f3064a);
                    } else {
                        for (C2230cn next : e.f3071c.f3068e) {
                            ArrayList parcelableArrayList = bundle.getParcelableArrayList(zzam.m21a("chunk_intents", e.f3071c.f3064a, next.f3072a));
                            if (parcelableArrayList != null) {
                                for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                    if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                        next.f3075d.get(i4).f3063a = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                String e2 = C2232cp.m2899e(bundle);
                long j = bundle.getLong(zzam.m20a("pack_version", e2));
                int i5 = bundle.getInt(zzam.m20a("status", e2));
                long j2 = bundle.getLong(zzam.m20a("total_bytes_to_download", e2));
                List<String> stringArrayList = bundle.getStringArrayList(zzam.m20a("slice_ids", e2));
                ArrayList arrayList = new ArrayList();
                if (stringArrayList == null) {
                    stringArrayList = Collections.emptyList();
                }
                for (String str2 : stringArrayList) {
                    List<Intent> parcelableArrayList2 = bundle.getParcelableArrayList(zzam.m21a("chunk_intents", e2, str2));
                    ArrayList arrayList2 = new ArrayList();
                    if (parcelableArrayList2 == null) {
                        parcelableArrayList2 = Collections.emptyList();
                    }
                    for (Intent intent : parcelableArrayList2) {
                        if (intent != null) {
                            z = true;
                        }
                        arrayList2.add(new C2227ck(z));
                        z = false;
                    }
                    String string = bundle.getString(zzam.m21a("uncompressed_hash_sha256", e2, str2));
                    long j3 = bundle.getLong(zzam.m21a("uncompressed_size", e2, str2));
                    int i6 = bundle.getInt(zzam.m21a("patch_format", e2, str2), 0);
                    if (i6 != 0) {
                        cnVar = new C2230cn(str2, string, j3, arrayList2, 0, i6);
                        z = false;
                    } else {
                        z = false;
                        cnVar = new C2230cn(str2, string, j3, arrayList2, bundle.getInt(zzam.m21a("compression_format", e2, str2), 0), 0);
                    }
                    arrayList.add(cnVar);
                }
                cpVar.f3082f.put(Integer.valueOf(i), new C2229cm(i, bundle.getInt("app_version_code"), new C2228cl(e2, j, i5, j2, arrayList)));
            }
            return Boolean.TRUE;
        }
        throw null;
    }
}
