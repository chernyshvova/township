package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(@Nullable String str) throws IOException, EncodingException;

    @NonNull
    ValueEncoderContext add(boolean z) throws IOException, EncodingException;
}
