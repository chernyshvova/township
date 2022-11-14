package com.google.android.material.bottomappbar;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment {
    public float cradleVerticalOffset;
    public float fabDiameter;
    public float fabMargin;
    public float horizontalOffset;
    public float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        this.cradleVerticalOffset = f3;
        if (f3 >= 0.0f) {
            this.horizontalOffset = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void getEdgePath(float f, float f2, ShapePath shapePath) {
        float f3 = f;
        float f4 = f2;
        ShapePath shapePath2 = shapePath;
        float f5 = this.fabDiameter;
        if (f5 == 0.0f) {
            shapePath2.lineTo(f3, 0.0f);
            return;
        }
        float f6 = ((this.fabMargin * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.roundedCornerRadius;
        float f8 = (f3 / 2.0f) + this.horizontalOffset;
        float outline0 = GeneratedOutlineSupport.outline0(1.0f, f4, f6, this.cradleVerticalOffset * f4);
        if (outline0 / f6 >= 1.0f) {
            shapePath2.lineTo(f3, 0.0f);
            return;
        }
        float f9 = f6 + f7;
        float f10 = outline0 + f7;
        float sqrt = (float) Math.sqrt((double) ((f9 * f9) - (f10 * f10)));
        float f11 = f8 - sqrt;
        float f12 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f10)));
        float f13 = 90.0f - degrees;
        float f14 = f11 - f7;
        shapePath2.lineTo(f14, 0.0f);
        float f15 = f7 * 2.0f;
        float f16 = degrees;
        shapePath.addArc(f14, 0.0f, f11 + f7, f15, 270.0f, degrees);
        shapePath.addArc(f8 - f6, (-f6) - outline0, f8 + f6, f6 - outline0, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        shapePath.addArc(f12 - f7, 0.0f, f12 + f7, f15, 270.0f - f16, f16);
        shapePath2.lineTo(f3, 0.0f);
    }
}
