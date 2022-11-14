package com.swrve.sdk.messaging.model;

import com.android.tools.p006r8.GeneratedOutlineSupport;

public class Arg {
    public String key;

    /* renamed from: op */
    public C1707Op f2799op;
    public String value;

    /* renamed from: com.swrve.sdk.messaging.model.Arg$Op */
    public enum C1707Op {
        EQ
    }

    public String getKey() {
        return this.key;
    }

    public C1707Op getOp() {
        return this.f2799op;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Arg{key='");
        GeneratedOutlineSupport.outline33(outline24, this.key, '\'', ", op='");
        outline24.append(this.f2799op);
        outline24.append('\'');
        outline24.append(", value='");
        outline24.append(this.value);
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
