package com.facebook;

import com.facebook.GraphRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphRequest.kt */
public final class GraphRequest$serializeToBatch$1 implements GraphRequest.KeyValueSerializer {
    public final /* synthetic */ ArrayList<String> $keysAndValues;

    public GraphRequest$serializeToBatch$1(ArrayList<String> arrayList) {
        this.$keysAndValues = arrayList;
    }

    public void writeString(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        ArrayList<String> arrayList = this.$keysAndValues;
        String format = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(str2, "UTF-8")}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        arrayList.add(format);
    }
}
