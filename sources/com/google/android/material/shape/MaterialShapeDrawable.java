package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.view.ViewCompat;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable {
    public int alpha;
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public final Matrix[] edgeTransforms = new Matrix[4];
    public float interpolation;
    public final Matrix matrix = new Matrix();
    public final Paint paint = new Paint();
    public Paint.Style paintStyle;
    public final Path path = new Path();
    public final PointF pointF = new PointF();
    public float scale;
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final Region scratchRegion = new Region();
    public int shadowColor;
    public int shadowElevation;
    public boolean shadowEnabled;
    public int shadowRadius;
    public final ShapePath shapePath = new ShapePath();
    @Nullable
    public ShapePathModel shapedViewModel = null;
    public float strokeWidth;
    @Nullable
    public PorterDuffColorFilter tintFilter;
    public ColorStateList tintList;
    public PorterDuff.Mode tintMode;
    public final Region transparentRegion = new Region();
    public boolean useTintColorForShadow;

    public MaterialShapeDrawable(@Nullable ShapePathModel shapePathModel) {
        this.shadowEnabled = false;
        this.useTintColorForShadow = false;
        this.interpolation = 1.0f;
        this.shadowColor = ViewCompat.MEASURED_STATE_MASK;
        this.shadowElevation = 5;
        this.shadowRadius = 10;
        this.alpha = 255;
        this.scale = 1.0f;
        this.strokeWidth = 0.0f;
        this.paintStyle = Paint.Style.FILL_AND_STROKE;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.tintList = null;
        this.shapedViewModel = shapePathModel;
        for (int i = 0; i < 4; i++) {
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
            this.cornerPaths[i] = new ShapePath();
        }
    }

    public final float angleOfEdge(int i, int i2, int i3) {
        getCoordinatesOfCorner(i, i2, i3, this.pointF);
        PointF pointF2 = this.pointF;
        float f = pointF2.x;
        float f2 = pointF2.y;
        getCoordinatesOfCorner((i + 1) % 4, i2, i3, pointF2);
        PointF pointF3 = this.pointF;
        return (float) Math.atan2((double) (pointF3.y - f2), (double) (pointF3.x - f));
    }

    public void draw(Canvas canvas) {
        this.paint.setColorFilter(this.tintFilter);
        int alpha2 = this.paint.getAlpha();
        Paint paint2 = this.paint;
        int i = this.alpha;
        paint2.setAlpha(((i + (i >>> 7)) * alpha2) >>> 8);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStyle(this.paintStyle);
        int i2 = this.shadowElevation;
        if (i2 > 0 && this.shadowEnabled) {
            this.paint.setShadowLayer((float) this.shadowRadius, 0.0f, (float) i2, this.shadowColor);
        }
        if (this.shapedViewModel != null) {
            getPath(canvas.getWidth(), canvas.getHeight(), this.path);
            canvas.drawPath(this.path, this.paint);
        } else {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.paint);
        }
        this.paint.setAlpha(alpha2);
    }

    public final void getCoordinatesOfCorner(int i, int i2, int i3, PointF pointF2) {
        if (i == 1) {
            pointF2.set((float) i2, 0.0f);
        } else if (i == 2) {
            pointF2.set((float) i2, (float) i3);
        } else if (i != 3) {
            pointF2.set(0.0f, 0.0f);
        } else {
            pointF2.set(0.0f, (float) i3);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public final void getPath(int i, int i2, Path path2) {
        EdgeTreatment edgeTreatment;
        CornerTreatment cornerTreatment;
        int i3 = i;
        int i4 = i2;
        Path path3 = path2;
        path2.rewind();
        if (this.shapedViewModel != null) {
            int i5 = 0;
            while (i5 < 4) {
                getCoordinatesOfCorner(i5, i3, i4, this.pointF);
                int i6 = ((i5 - 1) + 4) % 4;
                getCoordinatesOfCorner(i6, i3, i4, this.pointF);
                PointF pointF2 = this.pointF;
                float f = pointF2.x;
                float f2 = pointF2.y;
                int i7 = i5 + 1;
                getCoordinatesOfCorner(i7 % 4, i3, i4, pointF2);
                PointF pointF3 = this.pointF;
                float f3 = pointF3.x;
                float f4 = pointF3.y;
                getCoordinatesOfCorner(i5, i3, i4, pointF3);
                PointF pointF4 = this.pointF;
                float f5 = pointF4.x;
                float f6 = pointF4.y;
                int i8 = i5;
                float atan2 = ((float) Math.atan2((double) (f2 - f6), (double) (f - f5))) - ((float) Math.atan2((double) (f4 - f6), (double) (f3 - f5)));
                if (atan2 < 0.0f) {
                    Double.isNaN((double) atan2);
                }
                int i9 = i8;
                if (i9 == 1) {
                    cornerTreatment = this.shapedViewModel.topRightCorner;
                } else if (i9 == 2) {
                    cornerTreatment = this.shapedViewModel.bottomRightCorner;
                } else if (i9 != 3) {
                    cornerTreatment = this.shapedViewModel.topLeftCorner;
                } else {
                    cornerTreatment = this.shapedViewModel.bottomLeftCorner;
                }
                ShapePath shapePath2 = this.cornerPaths[i9];
                if (cornerTreatment != null) {
                    this.cornerTransforms[i9].reset();
                    Matrix matrix2 = this.cornerTransforms[i9];
                    PointF pointF5 = this.pointF;
                    matrix2.setTranslate(pointF5.x, pointF5.y);
                    this.cornerTransforms[i9].preRotate((float) Math.toDegrees((double) (angleOfEdge(i6, i3, i4) + 1.5707964f)));
                    float[] fArr = this.scratch;
                    ShapePath[] shapePathArr = this.cornerPaths;
                    fArr[0] = shapePathArr[i9].endX;
                    fArr[1] = shapePathArr[i9].endY;
                    this.cornerTransforms[i9].mapPoints(fArr);
                    float angleOfEdge = angleOfEdge(i9, i3, i4);
                    this.edgeTransforms[i9].reset();
                    Matrix matrix3 = this.edgeTransforms[i9];
                    float[] fArr2 = this.scratch;
                    matrix3.setTranslate(fArr2[0], fArr2[1]);
                    this.edgeTransforms[i9].preRotate((float) Math.toDegrees((double) angleOfEdge));
                    i5 = i7;
                } else {
                    throw null;
                }
            }
            int i10 = 0;
            while (i10 < 4) {
                float[] fArr3 = this.scratch;
                ShapePath[] shapePathArr2 = this.cornerPaths;
                fArr3[0] = shapePathArr2[i10].startX;
                fArr3[1] = shapePathArr2[i10].startY;
                this.cornerTransforms[i10].mapPoints(fArr3);
                if (i10 == 0) {
                    float[] fArr4 = this.scratch;
                    path3.moveTo(fArr4[0], fArr4[1]);
                } else {
                    float[] fArr5 = this.scratch;
                    path3.lineTo(fArr5[0], fArr5[1]);
                }
                this.cornerPaths[i10].applyToPath(this.cornerTransforms[i10], path3);
                int i11 = i10 + 1;
                int i12 = i11 % 4;
                float[] fArr6 = this.scratch;
                ShapePath[] shapePathArr3 = this.cornerPaths;
                fArr6[0] = shapePathArr3[i10].endX;
                fArr6[1] = shapePathArr3[i10].endY;
                this.cornerTransforms[i10].mapPoints(fArr6);
                float[] fArr7 = this.scratch2;
                ShapePath[] shapePathArr4 = this.cornerPaths;
                fArr7[0] = shapePathArr4[i12].startX;
                fArr7[1] = shapePathArr4[i12].startY;
                this.cornerTransforms[i12].mapPoints(fArr7);
                float[] fArr8 = this.scratch;
                float f7 = fArr8[0];
                float[] fArr9 = this.scratch2;
                float hypot = (float) Math.hypot((double) (f7 - fArr9[0]), (double) (fArr8[1] - fArr9[1]));
                ShapePath shapePath3 = this.shapePath;
                shapePath3.startX = 0.0f;
                shapePath3.startY = 0.0f;
                shapePath3.endX = 0.0f;
                shapePath3.endY = 0.0f;
                shapePath3.operations.clear();
                if (i10 == 1) {
                    edgeTreatment = this.shapedViewModel.rightEdge;
                } else if (i10 == 2) {
                    edgeTreatment = this.shapedViewModel.bottomEdge;
                } else if (i10 != 3) {
                    edgeTreatment = this.shapedViewModel.topEdge;
                } else {
                    edgeTreatment = this.shapedViewModel.leftEdge;
                }
                edgeTreatment.getEdgePath(hypot, this.interpolation, this.shapePath);
                this.shapePath.applyToPath(this.edgeTransforms[i10], path3);
                i10 = i11;
            }
            path2.close();
        }
        if (this.scale != 1.0f) {
            this.matrix.reset();
            Matrix matrix4 = this.matrix;
            float f8 = this.scale;
            matrix4.setScale(f8, f8, (float) (i3 / 2), (float) (i4 / 2));
            path3.transform(this.matrix);
        }
    }

    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.transparentRegion.set(bounds);
        getPath(bounds.width(), bounds.height(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public void setAlpha(@IntRange(from = 0, mo281to = 255) int i) {
        this.alpha = i;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.tintList = colorStateList;
        updateTintFilter();
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.tintMode = mode;
        updateTintFilter();
        invalidateSelf();
    }

    public final void updateTintFilter() {
        ColorStateList colorStateList = this.tintList;
        if (colorStateList == null || this.tintMode == null) {
            this.tintFilter = null;
            return;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        this.tintFilter = new PorterDuffColorFilter(colorForState, this.tintMode);
        if (this.useTintColorForShadow) {
            this.shadowColor = colorForState;
        }
    }
}
