package com.swrve.sdk.messaging.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.swrve.sdk.config.SwrveInAppMessageConfig;
import com.swrve.sdk.messaging.SwrveActionType;

public class SwrvePersonalizedTextView extends SwrveBaseInteractableView {
    public static final float TEST_FONT_SIZE = 200.0f;
    public String action;
    public int height;
    public SwrveInAppMessageConfig inAppConfig;
    public String text;
    public Bitmap viewBitmap;
    public int width;

    public SwrvePersonalizedTextView(Context context, SwrveActionType swrveActionType, SwrveInAppMessageConfig swrveInAppMessageConfig, String str, int i, int i2, String str2) {
        super(context, swrveActionType, swrveInAppMessageConfig.getFocusColor(), swrveInAppMessageConfig.getClickColor());
        this.inAppConfig = swrveInAppMessageConfig;
        this.text = str;
        this.width = i;
        this.height = i2;
        this.action = str2;
        this.viewBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.viewBitmap);
        canvas.drawColor(swrveInAppMessageConfig.getPersonalizedTextBackgroundColor());
        Paint paint = new Paint();
        paint.setTypeface(swrveInAppMessageConfig.getPersonalizedTextTypeface());
        paint.setColor(swrveInAppMessageConfig.getPersonalizedTextForegroundColor());
        fitTextSizeToImage(this.text, paint, this.width, this.height);
        Rect rect = new Rect();
        paint.setTextAlign(Paint.Align.LEFT);
        String str3 = this.text;
        paint.getTextBounds(str3, 0, str3.length(), rect);
        canvas.drawText(this.text, (((float) (this.width - rect.width())) / 2.0f) - ((float) rect.left), (((float) (rect.height() + this.height)) / 2.0f) - ((float) rect.bottom), paint);
        setImageBitmap(this.viewBitmap);
    }

    private void fitTextSizeToImage(String str, Paint paint, int i, int i2) {
        if (str != null && !str.isEmpty() && paint != null) {
            paint.setTextSize(200.0f);
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            paint.setTextSize(Math.min((200.0f / ((float) rect.width())) * ((float) i), (200.0f / ((float) rect.height())) * ((float) i2)));
        }
    }

    public String getAction() {
        return this.action;
    }

    public String getText() {
        return this.text;
    }
}
