package androidx.core.util;

import android.util.AtomicFile;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: AtomicFile.kt */
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(AtomicFile atomicFile) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readBytes");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    public static final String readText(AtomicFile atomicFile, Charset charset) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$readText");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$tryWrite");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(startWrite, "stream");
            function1.invoke(startWrite);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(AtomicFile atomicFile, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeBytes");
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(startWrite, "stream");
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(AtomicFile atomicFile, String str, Charset charset) {
        Intrinsics.checkParameterIsNotNull(atomicFile, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}
