package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface Encoder<TValue, TContext> {
    void encode(@Nullable TValue tvalue, @NonNull TContext tcontext) throws EncodingException, IOException;
}
