package com.swrve.sdk.conversations.engine.deserialisers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.MultiValueInput;
import com.swrve.sdk.conversations.engine.model.StarRating;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.lang.reflect.Type;

public class ConversationAtomDeserialiser implements JsonDeserializer<ConversationAtom> {

    /* renamed from: com.swrve.sdk.conversations.engine.deserialisers.ConversationAtomDeserialiser$1 */
    public static /* synthetic */ class C16991 {

        /* renamed from: $SwitchMap$com$swrve$sdk$conversations$engine$model$ConversationAtom$TYPE */
        public static final /* synthetic */ int[] f2788x6c668315;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|8|9|11|12|13|(2:15|16)|17|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|5|6|7|8|9|11|12|13|15|16|17|19|20|21|22|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE[] r0 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2788x6c668315 = r0
                r1 = 1
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_HTML     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r3 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_IMAGE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x001d }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r1 = 4
                int[] r2 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r3 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_SPACER     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r0 = 5
                int[] r2 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x002b }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r3 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_MULTIVALUE     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r1 = 6
                int[] r2 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r3 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_STARRATING     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f2788x6c668315     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.conversations.engine.deserialisers.ConversationAtomDeserialiser.C16991.<clinit>():void");
        }
    }

    private ConversationAtom.TYPE parse(String str) {
        if (str.equalsIgnoreCase("html-fragment")) {
            return ConversationAtom.TYPE.CONTENT_HTML;
        }
        if (str.equalsIgnoreCase("image")) {
            return ConversationAtom.TYPE.CONTENT_IMAGE;
        }
        if (str.equalsIgnoreCase("video")) {
            return ConversationAtom.TYPE.CONTENT_VIDEO;
        }
        if (str.equalsIgnoreCase("spacer")) {
            return ConversationAtom.TYPE.CONTENT_SPACER;
        }
        if (str.equalsIgnoreCase("multi-value-input")) {
            return ConversationAtom.TYPE.INPUT_MULTIVALUE;
        }
        if (str.equalsIgnoreCase(UserInputResult.TYPE_STAR_RATING)) {
            return ConversationAtom.TYPE.INPUT_STARRATING;
        }
        return ConversationAtom.TYPE.UNKNOWN;
    }

    public ConversationAtom deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        ConversationAtom.TYPE parse = parse(asJsonObject.get("type").getAsString());
        int ordinal = parse.ordinal();
        if (ordinal == 0 || ordinal == 1 || ordinal == 2 || ordinal == 3) {
            return (ConversationAtom) TreeTypeAdapter.this.gson.fromJson((JsonElement) asJsonObject, (Type) Content.class);
        } else if (ordinal == 4) {
            return (ConversationAtom) TreeTypeAdapter.this.gson.fromJson((JsonElement) asJsonObject, (Type) MultiValueInput.class);
        } else if (ordinal != 5) {
            return new ConversationAtom(asJsonObject.has("tag") ? asJsonObject.get("tag").getAsString() : null, parse, new ConversationStyle());
        } else {
            return (ConversationAtom) TreeTypeAdapter.this.gson.fromJson((JsonElement) asJsonObject, (Type) StarRating.class);
        }
    }
}
