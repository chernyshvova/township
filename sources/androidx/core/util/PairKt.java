package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pair.kt */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$component1");
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$component2");
        return pair.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$toAndroidPair");
        return new Pair<>(pair.first, pair.second);
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$toKotlinPair");
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
