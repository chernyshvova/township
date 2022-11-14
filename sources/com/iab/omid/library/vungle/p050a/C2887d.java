package com.iab.omid.library.vungle.p050a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2898f;

/* renamed from: com.iab.omid.library.vungle.a.d */
public final class C2887d extends ContentObserver {

    /* renamed from: a */
    public final Context f3488a;

    /* renamed from: b */
    public final AudioManager f3489b;

    /* renamed from: c */
    public final C2884a f3490c;

    /* renamed from: d */
    public final C2886c f3491d;

    /* renamed from: e */
    public float f3492e;

    public C2887d(Handler handler, Context context, C2884a aVar, C2886c cVar) {
        super(handler);
        this.f3488a = context;
        this.f3489b = (AudioManager) context.getSystemService("audio");
        this.f3490c = aVar;
        this.f3491d = cVar;
    }

    /* renamed from: c */
    public final float mo36829c() {
        int streamVolume = this.f3489b.getStreamVolume(3);
        int streamMaxVolume = this.f3489b.getStreamMaxVolume(3);
        if (this.f3490c == null) {
            throw null;
        } else if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        } else {
            float f = ((float) streamVolume) / ((float) streamMaxVolume);
            if (f > 1.0f) {
                return 1.0f;
            }
            return f;
        }
    }

    /* renamed from: d */
    public final void mo36830d() {
        C2886c cVar = this.f3491d;
        float f = this.f3492e;
        C2898f fVar = (C2898f) cVar;
        fVar.f3514b = f;
        if (fVar.f3518f == null) {
            fVar.f3518f = C2891a.f3501a;
        }
        for (C2889a aVar : fVar.f3518f.mo36838c()) {
            aVar.f3496f.mo36854a(f);
        }
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = mo36829c();
        if (c != this.f3492e) {
            this.f3492e = c;
            mo36830d();
        }
    }
}
