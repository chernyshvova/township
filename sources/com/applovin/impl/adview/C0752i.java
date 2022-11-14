package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.applovin.impl.adview.i */
public abstract class C0752i extends View {

    /* renamed from: a */
    public float f440a = 1.0f;

    /* renamed from: b */
    public final Context f441b;

    /* renamed from: com.applovin.impl.adview.i$a */
    public enum C0753a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2),
        TRANSPARENT_SKIP(3);
        

        /* renamed from: e */
        public final int f447e;

        /* access modifiers changed from: public */
        C0753a(int i) {
            this.f447e = i;
        }

        /* renamed from: a */
        public int mo9650a() {
            return this.f447e;
        }
    }

    public C0752i(Context context) {
        super(context);
        this.f441b = context;
    }

    /* renamed from: a */
    public static C0752i m513a(C0753a aVar, Context context) {
        return aVar.equals(C0753a.INVISIBLE) ? new C0778p(context) : aVar.equals(C0753a.WHITE_ON_TRANSPARENT) ? new C0779q(context) : aVar.equals(C0753a.TRANSPARENT_SKIP) ? new C0780r(context) : new C0786w(context);
    }

    /* renamed from: a */
    public void mo9646a(int i) {
        setViewScale(((float) i) / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f440a * 30.0f;
    }

    public abstract C0753a getStyle();

    public void setViewScale(float f) {
        this.f440a = f;
    }
}
