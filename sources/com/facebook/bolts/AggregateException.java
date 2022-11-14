package com.facebook.bolts;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateException.kt */
public final class AggregateException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1;
    public final List<Throwable> innerThrowables;

    /* compiled from: AggregateException.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || !(list.isEmpty() ^ true)) ? null : (Throwable) list.get(0));
        List<Throwable> unmodifiableList = Collections.unmodifiableList(list == null ? EmptyList.INSTANCE : list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(innerThrowables ?: emptyList())");
        this.innerThrowables = unmodifiableList;
    }

    public void printStackTrace(PrintStream printStream) {
        Intrinsics.checkNotNullParameter(printStream, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable next : this.innerThrowables) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i++;
            printStream.append(String.valueOf(i));
            printStream.append(": ");
            if (next != null) {
                next.printStackTrace(printStream);
            }
            printStream.append("\n");
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(printWriter, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable next : this.innerThrowables) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i++;
            printWriter.append(String.valueOf(i));
            printWriter.append(": ");
            if (next != null) {
                next.printStackTrace(printWriter);
            }
            printWriter.append("\n");
        }
    }
}
