package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.-$$Lambda$Uwf3BLxD-u3AhwSmJosUeq5paAY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY INSTANCE = new $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY();

    private /* synthetic */ $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY() {
    }

    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.m3622filterExcludeBufferFiles$lambda0(file, str);
    }
}
