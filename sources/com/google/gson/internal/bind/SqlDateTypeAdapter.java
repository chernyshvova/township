package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    public final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    public Object read(JsonReader jsonReader) throws IOException {
        Date date;
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                date = null;
            } else {
                try {
                    date = new Date(this.format.parse(jsonReader.nextString()).getTime());
                } catch (ParseException e) {
                    throw new JsonSyntaxException((Throwable) e);
                }
            }
        }
        return date;
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        synchronized (this) {
            if (date == null) {
                str = null;
            } else {
                str = this.format.format(date);
            }
            jsonWriter.value(str);
        }
    }
}
