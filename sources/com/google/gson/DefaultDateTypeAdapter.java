package com.google.gson;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    public final List<DateFormat> dateFormats = new ArrayList();
    public final Class<? extends Date> dateType;

    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        verifyDateType(cls);
        this.dateType = cls;
        this.dateFormats.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(str));
        }
    }

    public static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + RESTClient.COMMA_SEPARATOR + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    public Object read(JsonReader jsonReader) throws IOException {
        Date date;
        Object date2;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            for (DateFormat parse : this.dateFormats) {
                try {
                    date = parse.parse(nextString);
                    break;
                } catch (ParseException unused) {
                }
            }
            try {
                date = ISO8601Utils.parse(nextString, new ParsePosition(0));
            } catch (ParseException e) {
                throw new JsonSyntaxException(nextString, e);
            }
        }
        Class<? extends Date> cls = this.dateType;
        if (cls == Date.class) {
            return date;
        }
        if (cls == Timestamp.class) {
            date2 = new Timestamp(date.getTime());
        } else if (cls == java.sql.Date.class) {
            date2 = new java.sql.Date(date.getTime());
        } else {
            throw new AssertionError();
        }
        return date2;
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("DefaultDateTypeAdapter(");
            outline24.append(((SimpleDateFormat) dateFormat).toPattern());
            outline24.append(')');
            return outline24.toString();
        }
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("DefaultDateTypeAdapter(");
        outline242.append(dateFormat.getClass().getSimpleName());
        outline242.append(')');
        return outline242.toString();
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(this.dateFormats.get(0).format(date));
        }
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        verifyDateType(cls);
        this.dateType = cls;
        this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.majorJavaVersion >= 9) {
            this.dateFormats.add(zzam.getUSDateTimeFormat(i, i2));
        }
    }
}
