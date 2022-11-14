package com.helpshift.support.model;

import java.io.Serializable;

public class FuzzySearchToken implements Serializable {
    public static final long serialVersionUID = 1;
    public final String docId;
    public final String word;

    public FuzzySearchToken(String str, String str2) {
        this.word = str;
        this.docId = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FuzzySearchToken)) {
            return false;
        }
        FuzzySearchToken fuzzySearchToken = (FuzzySearchToken) obj;
        String str = this.word;
        if (str != null ? !str.equals(fuzzySearchToken.word) : fuzzySearchToken.word != null) {
            return false;
        }
        String str2 = this.docId;
        String str3 = fuzzySearchToken.docId;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }
}
