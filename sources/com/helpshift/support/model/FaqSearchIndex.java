package com.helpshift.support.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FaqSearchIndex implements Serializable {
    public static final long serialVersionUID = 2;
    public final Map<String, List<FuzzySearchToken>> fuzzyIndex;

    public FaqSearchIndex(Map<String, List<FuzzySearchToken>> map) {
        this.fuzzyIndex = map;
    }
}
