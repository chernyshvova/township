package com.facebook.appevents.aam;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: MetadataRule.kt */
public final class MetadataRule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_K = "k";
    public static final String FIELD_K_DELIMITER = ",";
    public static final String FIELD_V = "v";
    public static final Set<MetadataRule> rules = new CopyOnWriteArraySet();
    public final List<String> keyRules;
    public final String name;
    public final String valRule;

    /* compiled from: MetadataRule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void constructRules(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MetadataRule.FIELD_K);
                    String optString2 = optJSONObject.optString(MetadataRule.FIELD_V);
                    Intrinsics.checkNotNullExpressionValue(optString, MetadataRule.FIELD_K);
                    if (!(optString.length() == 0)) {
                        Set access$getRules$cp = MetadataRule.access$getRules$cp();
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        List split$default = CharsKt__CharKt.split$default(optString, new String[]{","}, false, 0, 6);
                        Intrinsics.checkNotNullExpressionValue(optString2, MetadataRule.FIELD_V);
                        access$getRules$cp.add(new MetadataRule(next, split$default, optString2, (DefaultConstructorMarker) null));
                    }
                }
            }
        }

        public final Set<String> getEnabledRuleNames() {
            HashSet hashSet = new HashSet();
            for (MetadataRule name : MetadataRule.access$getRules$cp()) {
                hashSet.add(name.getName());
            }
            return hashSet;
        }

        public final Set<MetadataRule> getRules() {
            return new HashSet(MetadataRule.access$getRules$cp());
        }

        public final void updateRules(String str) {
            Intrinsics.checkNotNullParameter(str, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                constructRules(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    public MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }

    public /* synthetic */ MetadataRule(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    public static final /* synthetic */ Set access$getRules$cp() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Set<String> getEnabledRuleNames() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getEnabledRuleNames();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Set<MetadataRule> getRules() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void updateRules(String str) {
        Class<MetadataRule> cls = MetadataRule.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.updateRules(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
