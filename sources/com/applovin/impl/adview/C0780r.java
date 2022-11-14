package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.applovin.impl.adview.C0752i;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.r */
public final class C0780r extends C0752i {

    /* renamed from: c */
    public static final Paint f500c = new Paint(1);

    /* renamed from: d */
    public static final Paint f501d = new Paint(1);

    /* renamed from: e */
    public final float[] f502e = {30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};

    /* renamed from: f */
    public Path f503f;

    public C0780r(Context context) {
        super(context);
        f500c.setARGB(80, 0, 0, 0);
        f501d.setColor(-1);
        f501d.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    private void m577a() {
        int i = 0;
        while (true) {
            float[] fArr = this.f502e;
            if (i < fArr.length) {
                fArr[i] = fArr[i] * 0.3f * this.f440a;
                i++;
            } else {
                Path path = new Path();
                this.f503f = path;
                float[] fArr2 = this.f502e;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.f503f;
                float[] fArr3 = this.f502e;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.f503f;
                float[] fArr4 = this.f502e;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.f503f;
                float[] fArr5 = this.f502e;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.f503f;
                float[] fArr6 = this.f502e;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.f503f;
                float[] fArr7 = this.f502e;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo9646a(int i) {
        setViewScale(((float) i) / 30.0f);
        m577a();
    }

    public float getCenter() {
        return getSize() / 2.0f;
    }

    public float getStrokeWidth() {
        return this.f440a * 2.0f;
    }

    public C0752i.C0753a getStyle() {
        return C0752i.C0753a.TRANSPARENT_SKIP;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f500c);
        f501d.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.f503f, f501d);
    }
}
