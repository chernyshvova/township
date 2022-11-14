package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.helpshift.common.util.HSDateFormatSpec;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final class JsonDataEncoderBuilder {
    public static final ValueEncoder<Boolean> BOOLEAN_ENCODER = JsonDataEncoderBuilder$$Lambda$4.instance;
    public static final ValueEncoder<String> STRING_ENCODER = JsonDataEncoderBuilder$$Lambda$1.instance;
    public static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder((C23571) null);
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    public static final class TimestampEncoder implements ValueEncoder<Date> {
        public static final DateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HSDateFormatSpec.STORAGE_TIME_PATTERN, Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public TimestampEncoder(C23571 r1) {
        }

        public void encode(@Nullable Object obj, @NonNull Object obj2) throws EncodingException, IOException {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, STRING_ENCODER);
        registerEncoder(Boolean.class, BOOLEAN_ENCODER);
        registerEncoder(Date.class, TIMESTAMP_ENCODER);
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        if (!this.objectEncoders.containsKey(cls)) {
            this.objectEncoders.put(cls, objectEncoder);
            return this;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Encoder already registered for ");
        outline24.append(cls.getName());
        throw new IllegalArgumentException(outline24.toString());
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        if (!this.valueEncoders.containsKey(cls)) {
            this.valueEncoders.put(cls, valueEncoder);
            return this;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Encoder already registered for ");
        outline24.append(cls.getName());
        throw new IllegalArgumentException(outline24.toString());
    }
}
