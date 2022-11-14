package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextView.kt */
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42, Function1<? super Editable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$addTextChangedListener");
        Intrinsics.checkParameterIsNotNull(function4, "beforeTextChanged");
        Intrinsics.checkParameterIsNotNull(function42, "onTextChanged");
        Intrinsics.checkParameterIsNotNull(function1, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Function4 function4, Function4 function42, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function4 = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function42 = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(textView, "$this$addTextChangedListener");
        Intrinsics.checkParameterIsNotNull(function4, "beforeTextChanged");
        Intrinsics.checkParameterIsNotNull(function42, "onTextChanged");
        Intrinsics.checkParameterIsNotNull(function1, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, Function1<? super Editable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$doAfterTextChanged");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1 textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1(function1);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$doBeforeTextChanged");
        Intrinsics.checkParameterIsNotNull(function4, "action");
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1 textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1(function4);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$doOnTextChanged");
        Intrinsics.checkParameterIsNotNull(function4, "action");
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1 textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1(function4);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1;
    }
}
