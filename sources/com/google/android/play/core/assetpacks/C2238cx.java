package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.cx */
public final /* synthetic */ class C2238cx implements FilenameFilter {

    /* renamed from: a */
    public final String f3100a;

    public C2238cx(String str) {
        this.f3100a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f3100a).concat("-")) && str.endsWith(".apk");
    }
}
