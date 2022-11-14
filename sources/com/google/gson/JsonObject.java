package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    public void add(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public void addProperty(String str, String str2) {
        this.members.put(str, str2 == null ? JsonNull.INSTANCE : new JsonPrimitive(str2));
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public JsonElement get(String str) {
        LinkedTreeMap.Node<String, JsonElement> findByObject = this.members.findByObject(str);
        return (JsonElement) (findByObject != null ? findByObject.value : null);
    }

    public JsonArray getAsJsonArray(String str) {
        LinkedTreeMap.Node<String, JsonElement> findByObject = this.members.findByObject(str);
        return (JsonArray) (findByObject != null ? findByObject.value : null);
    }

    public JsonObject getAsJsonObject(String str) {
        LinkedTreeMap.Node<String, JsonElement> findByObject = this.members.findByObject(str);
        return (JsonObject) (findByObject != null ? findByObject.value : null);
    }

    public boolean has(String str) {
        return this.members.findByObject(str) != null;
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public void addProperty(String str, Number number) {
        this.members.put(str, number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void addProperty(String str, Boolean bool) {
        this.members.put(str, bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }
}
