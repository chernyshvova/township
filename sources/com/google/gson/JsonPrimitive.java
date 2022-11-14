package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    public final Object value;

    public JsonPrimitive(Boolean bool) {
        if (bool != null) {
            this.value = bool;
            return;
        }
        throw null;
    }

    public static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.value;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.value == null) {
            if (jsonPrimitive.value == null) {
                return true;
            }
            return false;
        } else if (!isIntegral(this) || !isIntegral(jsonPrimitive)) {
            if (!(this.value instanceof Number) || !(jsonPrimitive.value instanceof Number)) {
                return this.value.equals(jsonPrimitive.value);
            }
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getAsBoolean() {
        Object obj = this.value;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public double getAsDouble() {
        return this.value instanceof Number ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public float getAsFloat() {
        return this.value instanceof Number ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public int getAsInt() {
        return this.value instanceof Number ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public long getAsLong() {
        return this.value instanceof Number ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public Number getAsNumber() {
        Object obj = this.value;
        return obj instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) obj;
    }

    public String getAsString() {
        Object obj = this.value;
        if (obj instanceof Number) {
            return getAsNumber().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public JsonPrimitive(Number number) {
        if (number != null) {
            this.value = number;
            return;
        }
        throw null;
    }

    public JsonPrimitive(String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw null;
    }
}
