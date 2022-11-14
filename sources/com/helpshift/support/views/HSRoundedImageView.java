package com.helpshift.support.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.helpshift.C2466R;

public class HSRoundedImageView extends AppCompatImageView {
    public ImageView.ScaleType SCALE_TYPE;
    public Paint backgroundPaint;
    public Paint bitmapPaint;
    public BitmapShader bitmapShader;
    public Paint borderPaint;
    public RectF borderRect;
    public float borderWidth;
    public float cornerRadius;
    public RectF drawableRect;
    public Bitmap imageBitmap;
    public final Matrix shaderMatrix;

    public HSRoundedImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setup() {
        Bitmap bitmap = this.imageBitmap;
        if (bitmap != null) {
            updateGlobalParamsAndBitmapShader(bitmap);
        } else {
            invalidate();
        }
    }

    private void updateGlobalParamsAndBitmapShader(Bitmap bitmap) {
        if (bitmap != null && getWidth() > 0 && getHeight() > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.borderRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.drawableRect.set(this.borderRect);
            RectF rectF = this.borderRect;
            float f = this.borderWidth;
            rectF.inset(f / 2.0f, f / 2.0f);
            RectF rectF2 = this.drawableRect;
            float f2 = this.borderWidth;
            rectF2.inset(f2, f2);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader2 = new BitmapShader(bitmap, tileMode, tileMode);
            this.bitmapShader = bitmapShader2;
            updateShaderMatrix(bitmapShader2, width, height);
            invalidate();
        }
    }

    private void updateShaderMatrix(BitmapShader bitmapShader2, int i, int i2) {
        float f;
        float f2;
        if (getWidth() > 0 && getHeight() > 0) {
            float f3 = 0.0f;
            if (i > i2) {
                f2 = this.drawableRect.height() / ((float) i2);
                f3 = (this.drawableRect.width() - (((float) i) * f2)) * 0.5f;
                f = 0.0f;
            } else {
                f2 = this.drawableRect.width() / ((float) i);
                f = (this.drawableRect.height() - (((float) i2) * f2)) * 0.5f;
            }
            this.shaderMatrix.setScale(f2, f2);
            Matrix matrix = this.shaderMatrix;
            float f4 = this.borderWidth;
            matrix.postTranslate(((float) ((int) (f3 + 0.5f))) + f4, ((float) ((int) (f + 0.5f))) + f4);
            bitmapShader2.setLocalMatrix(this.shaderMatrix);
        }
    }

    public ImageView.ScaleType getScaleType() {
        return this.SCALE_TYPE;
    }

    public void onDraw(Canvas canvas) {
        this.bitmapPaint.setShader(this.bitmapShader);
        float f = this.borderWidth;
        if (f > 0.0f) {
            Paint paint = this.backgroundPaint;
            if (paint != null) {
                RectF rectF = this.drawableRect;
                float f2 = this.cornerRadius;
                canvas.drawRoundRect(rectF, f2 - f, f2 - f, paint);
            }
            RectF rectF2 = this.drawableRect;
            float f3 = this.cornerRadius;
            float f4 = this.borderWidth;
            canvas.drawRoundRect(rectF2, f3 - f4, f3 - f4, this.bitmapPaint);
            RectF rectF3 = this.borderRect;
            float f5 = this.cornerRadius;
            canvas.drawRoundRect(rectF3, f5, f5, this.borderPaint);
            return;
        }
        Paint paint2 = this.backgroundPaint;
        if (paint2 != null) {
            RectF rectF4 = this.drawableRect;
            float f6 = this.cornerRadius;
            canvas.drawRoundRect(rectF4, f6, f6, paint2);
        }
        RectF rectF5 = this.drawableRect;
        float f7 = this.cornerRadius;
        canvas.drawRoundRect(rectF5, f7, f7, this.bitmapPaint);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof BitmapDrawable) {
            this.imageBitmap = ((BitmapDrawable) drawable).getBitmap();
            setup();
        }
    }

    public HSRoundedImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shaderMatrix = new Matrix();
        this.SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
        this.drawableRect = new RectF();
        this.borderRect = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2466R.styleable.HSRoundedImageView, 0, 0);
        int color = obtainStyledAttributes.getColor(C2466R.styleable.HSRoundedImageView_hs__borderColor, -1);
        int color2 = obtainStyledAttributes.getColor(C2466R.styleable.HSRoundedImageView_hs__backgroundColor, -1);
        float dimension = obtainStyledAttributes.getDimension(C2466R.styleable.HSRoundedImageView_hs__borderWidth, 0.0f);
        this.borderWidth = dimension;
        if (dimension < 0.0f) {
            this.borderWidth = 0.0f;
        }
        this.cornerRadius = obtainStyledAttributes.getDimension(C2466R.styleable.HSRoundedImageView_hs__cornerRadius, 0.0f);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.bitmapPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(color);
        this.borderPaint.setStrokeWidth(this.borderWidth);
        if (color2 != -1) {
            Paint paint3 = new Paint();
            this.backgroundPaint = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.backgroundPaint.setColor(color2);
            this.backgroundPaint.setAntiAlias(true);
        }
    }
}
