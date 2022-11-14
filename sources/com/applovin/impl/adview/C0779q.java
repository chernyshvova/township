package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.C0752i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.q */
public final class C0779q extends C0752i {

    /* renamed from: c */
    public static final Paint f498c = new Paint(1);

    /* renamed from: d */
    public static final Paint f499d = new Paint(1);

    public C0779q(Context context) {
        super(context);
        f498c.setARGB(80, 0, 0, 0);
        f499d.setColor(-1);
        f499d.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void mo9646a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    public float getCenter() {
        return getSize() / 2.0f;
    }

    public float getCrossOffset() {
        return this.f440a * 8.0f;
    }

    public float getStrokeWidth() {
        return this.f440a * 2.0f;
    }

    public C0752i.C0753a getStyle() {
        return C0752i.C0753a.WHITE_ON_TRANSPARENT;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f498c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f499d.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f499d);
        canvas2.drawLine(f, size, f2, crossOffset, f499d);
    }
}
