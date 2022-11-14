package com.vungle.warren;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.vungle.warren.log.LogEntry;
import com.vungle.warren.model.JsonUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class AdMarkup implements Serializable {
    public final String eventId;
    public final String[] impression;
    public final int version;

    public AdMarkup(String str, String[] strArr, int i) {
        this.eventId = str;
        this.impression = strArr;
        this.version = i;
    }

    @Nullable
    public static AdMarkup fromString(String str) {
        ArrayList arrayList;
        String[] strArr = null;
        if (str == null) {
            return null;
        }
        try {
            JsonObject jsonObject = (JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class);
            if (jsonObject == null) {
                return null;
            }
            if (JsonUtil.hasNonNull(jsonObject, "impression")) {
                JsonArray asJsonArray = jsonObject.getAsJsonArray("impression");
                if (asJsonArray != null) {
                    arrayList = new ArrayList();
                    Iterator<JsonElement> it = asJsonArray.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getAsString());
                    }
                } else {
                    throw null;
                }
            } else {
                arrayList = null;
            }
            String asString = JsonUtil.getAsString(jsonObject, LogEntry.LOG_ITEM_EVENT_ID, (String) null);
            if (arrayList != null) {
                strArr = (String[]) arrayList.toArray(new String[0]);
            }
            return new AdMarkup(asString, strArr, JsonUtil.getAsInt(jsonObject, "version", 0));
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdMarkup.class != obj.getClass()) {
            return false;
        }
        String str = this.eventId;
        String str2 = ((AdMarkup) obj).eventId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getEventId() {
        return this.eventId;
    }

    @Nullable
    public String[] getImpression() {
        return this.impression;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.eventId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdMarkup{eventId='");
        GeneratedOutlineSupport.outline33(outline24, this.eventId, '\'', ", impression=");
        outline24.append(Arrays.toString(this.impression));
        outline24.append(", version=");
        outline24.append(this.version);
        outline24.append('}');
        return outline24.toString();
    }
}
