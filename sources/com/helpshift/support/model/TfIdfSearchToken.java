package com.helpshift.support.model;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class TfIdfSearchToken implements Serializable {
    public static final long serialVersionUID = 1;
    public final int type;
    public final String value;

    public static class Type {
        public static final int IMPORTANT_WORD = 20;
        public static final int METAPHONE = 50;
        public static final int NGRAM = 40;
        public static final int TAG_WORD = 30;
        public static final int WORD = 10;
    }

    public TfIdfSearchToken(String str, int i) {
        this.value = str;
        this.type = i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("value: ");
        outline24.append(this.value);
        outline24.append(", type: ");
        outline24.append(this.type);
        return outline24.toString();
    }
}
