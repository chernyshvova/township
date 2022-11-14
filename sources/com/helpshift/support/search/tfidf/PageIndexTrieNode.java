package com.helpshift.support.search.tfidf;

import android.util.Pair;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageIndexTrieNode implements Serializable {
    public List<PageIndexTrieNode> children = new ArrayList();
    public boolean isWordEnd;
    public final char nodeValue;
    public SparseArray<Pair<Integer, Integer>> wordFrequency = new SparseArray<>();

    public PageIndexTrieNode(char c) {
        this.nodeValue = c;
    }

    public void addChild(PageIndexTrieNode pageIndexTrieNode) {
        this.children.add(pageIndexTrieNode);
    }

    public void addFrequency(int i, int i2, int i3) {
        Pair pair;
        Pair pair2 = this.wordFrequency.get(i);
        if (pair2 == null) {
            pair = new Pair(Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            pair = new Pair(Integer.valueOf(((Integer) pair2.first).intValue() + i2), Integer.valueOf(((Integer) pair2.second).intValue()));
        }
        this.wordFrequency.put(i, pair);
    }

    public PageIndexTrieNode getChild(char c) {
        List<PageIndexTrieNode> list = this.children;
        if (list == null) {
            return null;
        }
        for (PageIndexTrieNode next : list) {
            if (next.nodeValue == c) {
                return next;
            }
        }
        return null;
    }

    public List<PageIndexTrieNode> getChildren() {
        return this.children;
    }

    public int getFaqAppearCount() {
        return this.wordFrequency.size();
    }

    public int getMaxFrequency() {
        int i = 0;
        for (int i2 = 0; i2 < this.wordFrequency.size(); i2++) {
            i = Math.max(i, ((Integer) this.wordFrequency.valueAt(i2).first).intValue());
        }
        return i;
    }

    public SparseArray<Pair<Integer, Integer>> getWordFrequencyMap() {
        return this.wordFrequency;
    }

    public void resetChildren() {
        this.children = null;
    }

    public void resetFrequency() {
        this.wordFrequency = null;
    }
}
