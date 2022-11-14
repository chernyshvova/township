package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.w */
public interface C2281w {
    /* renamed from: a */
    Task<List<String>> mo33159a(Map<String, Long> map);

    /* renamed from: a */
    void mo33160a();

    /* renamed from: a */
    void mo33161a(int i);

    /* renamed from: a */
    void mo33162a(int i, String str);

    /* renamed from: a */
    void mo33164a(int i, String str, String str2, int i2);

    /* renamed from: a */
    void mo33165a(List<String> list);

    /* renamed from: b */
    Task<ParcelFileDescriptor> mo33166b(int i, String str, String str2, int i2);
}
