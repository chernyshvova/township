package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
import com.facebook.login.LoginLogger;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    /* renamed from: of */
    public static IllegalStateException m2817of(Task<?> task) {
        String str;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = LoginLogger.EVENT_EXTRAS_FAILURE;
        } else if (task.isSuccessful()) {
            String valueOf = String.valueOf(task.getResult());
            StringBuilder sb = new StringBuilder(valueOf.length() + 7);
            sb.append("result ");
            sb.append(valueOf);
            str = sb.toString();
        } else {
            str = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), exception);
    }
}
