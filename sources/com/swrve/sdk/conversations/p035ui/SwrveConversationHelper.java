package com.swrve.sdk.conversations.p035ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import com.swrve.sdk.conversations.C1694R;

/* renamed from: com.swrve.sdk.conversations.ui.SwrveConversationHelper */
public class SwrveConversationHelper {
    public static Drawable createRoundedDrawable(int i, float[] fArr) {
        if (fArr.length != 8) {
            return null;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        return shapeDrawable;
    }

    public static Drawable createRoundedDrawableWithBorder(int i, int i2, float[] fArr) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(6.0f, 6.0f, 6.0f, 6.0f), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i2);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(6.0f);
        Drawable createRoundedDrawable = createRoundedDrawable(i, fArr);
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[1] = shapeDrawable;
        drawableArr[0] = createRoundedDrawable;
        return new LayerDrawable(drawableArr);
    }

    public static float getRadiusInPixels(Context context, int i) {
        float dimensionPixelSize = (float) (context.getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_control_height) / 2);
        return i >= 100 ? dimensionPixelSize : (((float) i) * dimensionPixelSize) / 100.0f;
    }

    @SuppressLint({"NewApi"})
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
