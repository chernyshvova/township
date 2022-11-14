package com.swrve.sdk.messaging.model;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;

public class Conditions {
    public List<Arg> args;
    public String key;

    /* renamed from: op */
    public C1708Op f2801op = null;
    public String value;

    /* renamed from: com.swrve.sdk.messaging.model.Conditions$Op */
    public enum C1708Op {
        AND,
        EQ
    }

    public List<Arg> getArgs() {
        return this.args;
    }

    public String getKey() {
        return this.key;
    }

    public C1708Op getOp() {
        return this.f2801op;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Conditions{key='");
        GeneratedOutlineSupport.outline33(outline24, this.key, '\'', ", op='");
        outline24.append(this.f2801op);
        outline24.append('\'');
        outline24.append(", value='");
        GeneratedOutlineSupport.outline33(outline24, this.value, '\'', ", args=");
        outline24.append(this.args);
        outline24.append('}');
        return outline24.toString();
    }
}
