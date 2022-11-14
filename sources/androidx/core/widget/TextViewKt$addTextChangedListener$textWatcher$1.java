package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* compiled from: TextView.kt */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    public final /* synthetic */ Function1 $afterTextChanged;
    public final /* synthetic */ Function4 $beforeTextChanged;
    public final /* synthetic */ Function4 $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(Function1 function1, Function4 function4, Function4 function42) {
        this.$afterTextChanged = function1;
        this.$beforeTextChanged = function4;
        this.$onTextChanged = function42;
    }

    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
