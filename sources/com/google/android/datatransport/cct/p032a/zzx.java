package com.google.android.datatransport.cct.p032a;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.google.android.datatransport.cct.a.zzx */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class zzx {
    @Nullable
    public static zzx zza(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return new zzl(Long.parseLong(jsonReader.nextString()));
                } else {
                    zzl zzl = new zzl(jsonReader.nextLong());
                    jsonReader.close();
                    return zzl;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }
}
