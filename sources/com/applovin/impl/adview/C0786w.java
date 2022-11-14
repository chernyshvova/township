package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C0752i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.w */
public final class C0786w extends C0752i {

    /* renamed from: c */
    public static final Paint f517c = new Paint(1);

    /* renamed from: d */
    public static final Paint f518d = new Paint(1);

    /* renamed from: e */
    public static final Paint f519e = new Paint(1);

    public C0786w(Context context) {
        super(context);
        f517c.setColor(-1);
        f518d.setColor(ViewCompat.MEASURED_STATE_MASK);
        f519e.setColor(-1);
        f519e.setStyle(Paint.Style.STROKE);
    }

    public float getCenter() {
        return getSize() / 2.0f;
    }

    public float getCrossOffset() {
        return this.f440a * 10.0f;
    }

    public float getInnerCircleOffset() {
        return this.f440a * 2.0f;
    }

    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    public float getStrokeWidth() {
        return this.f440a * 3.0f;
    }

    public C0752i.C0753a getStyle() {
        return C0752i.C0753a.WHITE_ON_BLACK;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f517c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f518d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f519e.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f519e);
        canvas2.drawLine(f, size, f2, crossOffset, f519e);
    }
}
