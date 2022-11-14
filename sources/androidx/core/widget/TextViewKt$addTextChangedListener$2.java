package androidx.core.widget;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* compiled from: TextView.kt */
public final class TextViewKt$addTextChangedListener$2 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
    public static final TextViewKt$addTextChangedListener$2 INSTANCE = new TextViewKt$addTextChangedListener$2();

    public TextViewKt$addTextChangedListener$2() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((CharSequence) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(CharSequence charSequence, int i, int i2, int i3) {
    }
}
