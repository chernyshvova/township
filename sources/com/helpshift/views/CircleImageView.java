package com.helpshift.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;

@SuppressLint({"AppCompatCustomView"})
public class CircleImageView extends ImageView {
    public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static final int COLOR_DRAWABLE_DIMENSION = 2;
    public static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    public Bitmap bitmap;
    public int bitmapHeight;
    public final Paint bitmapPaint;
    public BitmapShader bitmapShader;
    public int bitmapWidth;
    public final RectF borderRect;
    public ColorFilter colorFilter;
    public float drawableRadius;
    public final RectF drawableRect;
    public boolean isReady;
    public boolean isSetupPending;
    public final Matrix shaderMatrix;

    public CircleImageView(Context context) {
        super(context);
        this.drawableRect = new RectF();
        this.borderRect = new RectF();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        init();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap2;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap2 = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                bitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap2);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.isReady = true;
        if (this.isSetupPending) {
            setup();
            this.isSetupPending = false;
        }
    }

    private void setup() {
        if (!this.isReady) {
            this.isSetupPending = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.bitmap == null) {
                invalidate();
                return;
            }
            Bitmap bitmap2 = this.bitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
            this.bitmapPaint.setAntiAlias(true);
            this.bitmapPaint.setShader(this.bitmapShader);
            this.bitmapHeight = this.bitmap.getHeight();
            this.bitmapWidth = this.bitmap.getWidth();
            this.borderRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.drawableRect.set(this.borderRect);
            this.drawableRadius = Math.min(this.drawableRect.height() / 2.0f, this.drawableRect.width() / 2.0f);
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float f;
        float f2;
        this.shaderMatrix.set((Matrix) null);
        float f3 = 0.0f;
        if (this.drawableRect.height() * ((float) this.bitmapWidth) > this.drawableRect.width() * ((float) this.bitmapHeight)) {
            f2 = this.drawableRect.height() / ((float) this.bitmapHeight);
            f3 = (this.drawableRect.width() - (((float) this.bitmapWidth) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.drawableRect.width() / ((float) this.bitmapWidth);
            f = (this.drawableRect.height() - (((float) this.bitmapHeight) * f2)) * 0.5f;
        }
        this.shaderMatrix.setScale(f2, f2);
        Matrix matrix = this.shaderMatrix;
        RectF rectF = this.drawableRect;
        matrix.postTranslate(((float) ((int) (f3 + 0.5f))) + rectF.left, ((float) ((int) (f + 0.5f))) + rectF.top);
        this.bitmapShader.setLocalMatrix(this.shaderMatrix);
    }

    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public void onDraw(Canvas canvas) {
        if (this.bitmap != null) {
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.drawableRadius, this.bitmapPaint);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        if (colorFilter2 != this.colorFilter) {
            this.colorFilter = colorFilter2;
            this.bitmapPaint.setColorFilter(colorFilter2);
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap2) {
        super.setImageBitmap(bitmap2);
        this.bitmap = bitmap2;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.bitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    public void setImageResource(@DrawableRes int i) {
        super.setImageResource(i);
        this.bitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.bitmap = uri != null ? getBitmapFromDrawable(getDrawable()) : null;
        setup();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawableRect = new RectF();
        this.borderRect = new RectF();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        init();
    }
}
