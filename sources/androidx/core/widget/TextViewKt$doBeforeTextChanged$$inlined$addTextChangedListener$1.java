package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function4;

/* compiled from: TextView.kt */
public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1 implements TextWatcher {
    public final /* synthetic */ Function4 $beforeTextChanged;

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1(Function4 function4) {
        this.$beforeTextChanged = function4;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
