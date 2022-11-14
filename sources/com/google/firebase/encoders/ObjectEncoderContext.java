package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull String str, int i) throws IOException, EncodingException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, long j) throws IOException, EncodingException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException;
}
