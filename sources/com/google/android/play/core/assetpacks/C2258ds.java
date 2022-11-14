package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ds */
public final /* synthetic */ class C2258ds implements FilenameFilter {

    /* renamed from: a */
    public static final FilenameFilter f3178a = new C2258ds();

    public final boolean accept(File file, String str) {
        return C2259dt.f3179a.matcher(str).matches();
    }
}
