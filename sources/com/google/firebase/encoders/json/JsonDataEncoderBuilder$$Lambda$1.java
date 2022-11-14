package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final /* synthetic */ class JsonDataEncoderBuilder$$Lambda$1 implements ValueEncoder {
    public static final JsonDataEncoderBuilder$$Lambda$1 instance = new JsonDataEncoderBuilder$$Lambda$1();

    public void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add((String) obj);
    }
}
