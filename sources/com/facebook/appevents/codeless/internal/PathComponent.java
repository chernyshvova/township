package com.facebook.appevents.codeless.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PathComponent.kt */
public final class PathComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PATH_CLASS_NAME_KEY = "class_name";
    public static final String PATH_DESCRIPTION_KEY = "description";
    public static final String PATH_HINT_KEY = "hint";
    public static final String PATH_ID_KEY = "id";
    public static final String PATH_INDEX_KEY = "index";
    public static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    public static final String PATH_TAG_KEY = "tag";
    public static final String PATH_TEXT_KEY = "text";
    public final String className;
    public final String description;
    public final String hint;

    /* renamed from: id */
    public final int f2752id;
    public final int index;
    public final int matchBitmask;
    public final String tag;
    public final String text;

    /* compiled from: PathComponent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PathComponent.kt */
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        public final int value;

        /* access modifiers changed from: public */
        MatchBitmaskType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PathComponent(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "component");
        String string = jSONObject.getString(PATH_CLASS_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = jSONObject.optInt("index", -1);
        this.f2752id = jSONObject.optInt("id");
        String optString = jSONObject.optString("text");
        Intrinsics.checkNotNullExpressionValue(optString, "component.optString(PATH_TEXT_KEY)");
        this.text = optString;
        String optString2 = jSONObject.optString("tag");
        Intrinsics.checkNotNullExpressionValue(optString2, "component.optString(PATH_TAG_KEY)");
        this.tag = optString2;
        String optString3 = jSONObject.optString("description");
        Intrinsics.checkNotNullExpressionValue(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = optString3;
        String optString4 = jSONObject.optString("hint");
        Intrinsics.checkNotNullExpressionValue(optString4, "component.optString(PATH_HINT_KEY)");
        this.hint = optString4;
        this.matchBitmask = jSONObject.optInt(PATH_MATCH_BITMASK_KEY);
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.f2752id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getText() {
        return this.text;
    }
}
