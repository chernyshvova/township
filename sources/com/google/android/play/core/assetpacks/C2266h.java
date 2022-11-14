package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.h */
public final /* synthetic */ class C2266h implements OnFailureListener {

    /* renamed from: a */
    public static final OnFailureListener f3195a = new C2266h();

    public final void onFailure(Exception exc) {
        C2267j.f3196a.mo33278a(5, String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
