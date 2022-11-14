package com.swrve.sdk.conversations.engine.deserialisers;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.ControlActions;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ControlActionsDeserialiser implements JsonDeserializer<ControlActions> {
    public ControlActions deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String str;
        ControlActions controlActions = null;
        if (jsonElement != null) {
            if (jsonElement instanceof JsonObject) {
                controlActions = new ControlActions();
                for (Map.Entry next : jsonElement.getAsJsonObject().entrySet()) {
                    String str2 = (String) next.getKey();
                    if (str2.equalsIgnoreCase(ControlActions.CALL_ACTION.toString())) {
                        controlActions.includeAction(str2, ((JsonElement) next.getValue()).getAsString());
                    } else if (str2.equalsIgnoreCase(ControlActions.VISIT_URL_ACTION.toString())) {
                        JsonObject asJsonObject = ((JsonElement) next.getValue()).getAsJsonObject();
                        HashMap hashMap = new HashMap();
                        if (asJsonObject.has("url")) {
                            str = asJsonObject.get("url").getAsString().replaceAll("\\s", "");
                            if (!str.startsWith("http")) {
                                str = GeneratedOutlineSupport.outline16("http://", str);
                            }
                        } else {
                            str = "http://www.google.ie";
                        }
                        String replaceAll = asJsonObject.has(ControlActions.VISIT_URL_REFERER_KEY) ? asJsonObject.get(ControlActions.VISIT_URL_REFERER_KEY).getAsString().replaceAll("\\s", "") : "http://swrve.com";
                        hashMap.put("url", str);
                        hashMap.put(ControlActions.VISIT_URL_REFERER_KEY, replaceAll);
                        controlActions.includeAction(str2, hashMap);
                    } else if (str2.equalsIgnoreCase(ControlActions.DEEPLINK_ACTION.toString())) {
                        JsonObject asJsonObject2 = ((JsonElement) next.getValue()).getAsJsonObject();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("url", asJsonObject2.has("url") ? asJsonObject2.get("url").getAsString() : "twitter://");
                        controlActions.includeAction(str2, hashMap2);
                    } else {
                        SwrveLogger.m2754e("Unrecognized Action in json", new Object[0]);
                        SwrveLogger.m2754e("JSON: %s", ((JsonElement) next.getValue()).getAsJsonObject().toString());
                    }
                }
            }
            return controlActions;
        }
        throw null;
    }
}
