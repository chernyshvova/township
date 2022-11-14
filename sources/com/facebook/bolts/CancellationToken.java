package com.facebook.bolts;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellationToken.kt */
public final class CancellationToken {
    public final CancellationTokenSource tokenSource;

    public CancellationToken(CancellationTokenSource cancellationTokenSource) {
        Intrinsics.checkNotNullParameter(cancellationTokenSource, "tokenSource");
        this.tokenSource = cancellationTokenSource;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public final CancellationTokenRegistration register(Runnable runnable) {
        return this.tokenSource.register$facebook_bolts_release(runnable);
    }

    public final void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested$facebook_bolts_release();
    }

    public String toString() {
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationToken.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }
}
