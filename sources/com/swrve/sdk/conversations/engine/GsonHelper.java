package com.swrve.sdk.conversations.engine;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swrve.sdk.conversations.engine.deserialisers.ControlActionsDeserialiser;
import com.swrve.sdk.conversations.engine.deserialisers.ConversationAtomDeserialiser;
import com.swrve.sdk.conversations.engine.model.ControlActions;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;

public class GsonHelper {
    public static Gson getConfiguredGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gsonBuilder.registerTypeAdapter(ConversationAtom.class, new ConversationAtomDeserialiser());
        gsonBuilder.registerTypeAdapter(ControlActions.class, new ControlActionsDeserialiser());
        return gsonBuilder.create();
    }
}
