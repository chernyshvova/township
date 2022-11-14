package com.swrve.sdk.conversations.p035ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.swrve.sdk.conversations.C1694R;
import com.swrve.sdk.conversations.engine.model.ChoiceInputItem;
import com.swrve.sdk.conversations.engine.model.ChoiceInputResponse;
import com.swrve.sdk.conversations.engine.model.ConversationInputChangedListener;
import com.swrve.sdk.conversations.engine.model.MultiValueInput;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.swrve.sdk.conversations.ui.MultiValueInputControl */
public class MultiValueInputControl extends LinearLayout implements Serializable, IConversationInput, CompoundButton.OnCheckedChangeListener {
    public ConversationInputChangedListener inputChangedListener;
    public MultiValueInput model;
    public ArrayList<RadioButton> radioButtons;
    public int selectedIndex = -1;
    public TextView titleTextView;

    @SuppressLint({"NewApi"})
    public MultiValueInputControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private Map<String, Object> gatherValue() {
        HashMap hashMap = new HashMap();
        ChoiceInputItem choiceInputItem = this.model.getValues().get(this.selectedIndex);
        ChoiceInputResponse choiceInputResponse = new ChoiceInputResponse();
        choiceInputResponse.setQuestionID(this.model.getTag());
        choiceInputResponse.setFragmentTag(this.model.getTag());
        choiceInputResponse.setAnswerID(choiceInputItem.getAnswerID());
        choiceInputResponse.setAnswerText(choiceInputItem.getAnswerText());
        hashMap.put(this.model.getTag(), choiceInputResponse);
        return hashMap;
    }

    public static MultiValueInputControl inflate(Context context, ViewGroup viewGroup, MultiValueInput multiValueInput) {
        MultiValueInputControl multiValueInputControl = (MultiValueInputControl) LayoutInflater.from(context).inflate(C1694R.layout.swrve__multiinput, viewGroup, false);
        TextView textView = (TextView) multiValueInputControl.findViewById(C1694R.C1696id.swrve__MIV_Header);
        multiValueInputControl.titleTextView = textView;
        textView.setText(multiValueInput.getDescription());
        ConversationStyle style = multiValueInput.getStyle();
        int textColorInt = style.getTextColorInt();
        SwrveConversationHelper.setBackgroundDrawable(multiValueInputControl, style.getBg().getPrimaryDrawable());
        multiValueInputControl.titleTextView.setTextColor(textColorInt);
        multiValueInputControl.titleTextView.setTextSize(1, (float) style.getTextSize());
        multiValueInputControl.titleTextView.setTypeface(style.getTypeface());
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_mvi_padding);
        multiValueInputControl.titleTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        multiValueInputControl.model = multiValueInput;
        multiValueInputControl.radioButtons = new ArrayList<>();
        int i = 0;
        while (i < multiValueInput.getValues().size()) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ChoiceInputItem choiceInputItem = multiValueInput.getValues().get(i);
            radioButton.setText(choiceInputItem.getAnswerText());
            radioButton.setTypeface(choiceInputItem.getStyle().getTypeface());
            radioButton.setTextSize(1, (float) choiceInputItem.getStyle().getTextSize());
            radioButton.setTextColor(choiceInputItem.getStyle().getTextColorInt());
            setTint(radioButton, choiceInputItem.getStyle().getTextColorInt());
            radioButton.setChecked(i == multiValueInputControl.selectedIndex);
            if (!multiValueInputControl.isInEditMode()) {
                radioButton.setTag(C1694R.string.swrve__indexTag, Integer.valueOf(i));
            }
            multiValueInputControl.addView(radioButton);
            radioButton.setOnCheckedChangeListener(multiValueInputControl);
            multiValueInputControl.radioButtons.add(radioButton);
            i++;
        }
        return multiValueInputControl;
    }

    @TargetApi(21)
    public static void setTint(RadioButton radioButton, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            radioButton.setButtonTintList(ColorStateList.valueOf(i));
            return;
        }
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842919}}, new int[]{i, i, i, i});
        Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(radioButton.getContext(), C1694R.C1695drawable.abc_btn_radio_material));
        DrawableCompat.setTintList(wrap, colorStateList);
        radioButton.setButtonDrawable(wrap);
    }

    public ArrayList<RadioButton> getRadioButtons() {
        return this.radioButtons;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int intValue = ((Integer) compoundButton.getTag(C1694R.string.swrve__indexTag)).intValue();
        int i = this.selectedIndex;
        if (i > -1 && i != intValue) {
            RadioButton radioButton = (RadioButton) getChildAt(i + 1);
            if (radioButton.isChecked()) {
                radioButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                radioButton.setChecked(false);
                radioButton.setOnCheckedChangeListener(this);
            }
        }
        if (!z) {
            this.selectedIndex = -1;
        } else {
            this.selectedIndex = intValue;
        }
        ConversationInputChangedListener conversationInputChangedListener = this.inputChangedListener;
        if (conversationInputChangedListener != null) {
            conversationInputChangedListener.onContentChanged(gatherValue(), this.model);
        }
    }

    public void setContentChangedListener(ConversationInputChangedListener conversationInputChangedListener) {
        this.inputChangedListener = conversationInputChangedListener;
    }

    public void setUserInput(UserInputResult userInputResult) {
        ChoiceInputResponse choiceInputResponse = (ChoiceInputResponse) userInputResult.getResult();
        Iterator<RadioButton> it = this.radioButtons.iterator();
        while (it.hasNext()) {
            RadioButton next = it.next();
            if (next.getText().toString().equalsIgnoreCase(choiceInputResponse.getAnswerText())) {
                next.setChecked(true);
            }
        }
    }

    public MultiValueInputControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MultiValueInputControl(Context context) {
        super(context);
    }
}
