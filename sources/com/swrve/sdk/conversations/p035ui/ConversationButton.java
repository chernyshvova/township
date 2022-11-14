package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.conversations.C1694R;
import com.swrve.sdk.conversations.engine.model.ButtonControl;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationButton */
public class ConversationButton extends AppCompatButton implements IConversationControl {
    public int backgroundColor;
    public int backgroundColorPressed;
    public float borderRadius;
    public ButtonControl model;
    public ConversationStyle style;
    public int textColor;
    public int textColorPressed;

    public ConversationButton(Context context, ButtonControl buttonControl) {
        super(context);
        this.model = buttonControl;
        this.style = buttonControl.getStyle();
        setText(buttonControl.getDescription());
        this.borderRadius = SwrveConversationHelper.getRadiusInPixels(context, this.style.getBorderRadius());
        initColors();
        initTextColorStates();
        initBackgroundColorStates();
        setLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_control_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setIncludeFontPadding(false);
        setTypeface(this.style.getTypeface());
        setTextSize(1, (float) this.style.getTextSize());
        initAlignment();
        setHeight(context.getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_control_height));
    }

    private StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[]{16842908}, drawable2);
        stateListDrawable.addState(new int[0], drawable3);
        return stateListDrawable;
    }

    private void initAlignment() {
        if (this.style.getAlignment() == ConversationStyle.ALIGNMENT.LEFT) {
            setGravity(19);
        } else if (this.style.getAlignment() == ConversationStyle.ALIGNMENT.CENTER) {
            setGravity(17);
        } else if (this.style.getAlignment() == ConversationStyle.ALIGNMENT.RIGHT) {
            setGravity(21);
        } else {
            setGravity(17);
        }
    }

    private void initBackgroundColorStates() {
        float f = this.borderRadius;
        float[] fArr = {f, f, f, f, f, f, f, f};
        Drawable colorDrawable = new ColorDrawable();
        if (this.style.isSolidStyle()) {
            Drawable createRoundedDrawable = SwrveConversationHelper.createRoundedDrawable(this.backgroundColor, fArr);
            Drawable createRoundedDrawable2 = SwrveConversationHelper.createRoundedDrawable(this.backgroundColorPressed, fArr);
            colorDrawable = getStateListDrawable(createRoundedDrawable2, createRoundedDrawable2, createRoundedDrawable);
        } else if (this.style.isOutlineStyle()) {
            Drawable createRoundedDrawableWithBorder = SwrveConversationHelper.createRoundedDrawableWithBorder(this.backgroundColor, this.textColor, fArr);
            Drawable createRoundedDrawableWithBorder2 = SwrveConversationHelper.createRoundedDrawableWithBorder(this.backgroundColorPressed, this.textColorPressed, fArr);
            colorDrawable = getStateListDrawable(createRoundedDrawableWithBorder2, createRoundedDrawableWithBorder2, createRoundedDrawableWithBorder);
        }
        SwrveConversationHelper.setBackgroundDrawable(this, colorDrawable);
    }

    private void initColors() {
        int textColorInt = this.style.getTextColorInt();
        this.textColor = textColorInt;
        boolean isLight = isLight(textColorInt);
        int i = ViewCompat.MEASURED_STATE_MASK;
        this.textColorPressed = lerpColor(textColorInt, isLight ? ViewCompat.MEASURED_STATE_MASK : -1, 0.3f);
        int bgColorInt = this.style.getBgColorInt();
        this.backgroundColor = bgColorInt;
        if (!isLight(bgColorInt)) {
            i = -1;
        }
        this.backgroundColorPressed = lerpColor(bgColorInt, i, 0.3f);
    }

    private void initTextColorStates() {
        int[][] iArr = {new int[]{16842919}, new int[]{16842908}, new int[0]};
        int i = this.textColorPressed;
        setTextColor(new ColorStateList(iArr, new int[]{i, i, this.textColor}));
    }

    private boolean isLight(int i) {
        double red = (double) (((float) Color.red(i)) / 255.0f);
        Double.isNaN(red);
        double green = (double) (((float) Color.green(i)) / 255.0f);
        Double.isNaN(green);
        double d = green * 0.7152d;
        double blue = (double) (((float) Color.blue(i)) / 255.0f);
        Double.isNaN(blue);
        return (blue * 0.0722d) + (d + (red * 0.2126d)) > 0.5d;
    }

    private float lerp(float f, float f2, float f3) {
        return GeneratedOutlineSupport.outline0(f2, f, f3, f);
    }

    private int lerpColor(int i, int i2, float f) {
        return i != 0 ? Color.rgb((byte) ((int) lerp((float) Color.red(i), (float) Color.red(i2), f)), (byte) ((int) lerp((float) Color.green(i), (float) Color.green(i2), f)), (byte) ((int) lerp((float) Color.blue(i), (float) Color.blue(i2), f))) : i;
    }

    public float getBorderRadius() {
        return this.borderRadius;
    }

    public ButtonControl getModel() {
        return this.model;
    }
}
