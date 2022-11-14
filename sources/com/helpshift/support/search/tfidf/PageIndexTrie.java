package com.helpshift.support.search.tfidf;

import android.util.Pair;
import android.util.SparseArray;
import com.helpshift.support.HSSearch;
import com.helpshift.support.search.SearchTokenDao;
import com.helpshift.support.search.SearchTokenDto;
import com.helpshift.support.search.storage.SearchTokenDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageIndexTrie {
    public static final int BATCH_SIZE = 1000;
    public static final int MAX_TOKEN_SIZE = 50;
    public static final int maxNGramLength = 10;
    public static final int minNGramLength = 1;
    public PageIndexTrieNode root = new PageIndexTrieNode(0);
    public SearchTokenDao searchTokenDao;
    public List<SearchTokenDto> searchTokenList = new ArrayList();
    public final int totalDocCount;

    public PageIndexTrie(int i) {
        this.totalDocCount = i;
    }

    private SearchTokenDto buildTfIdfIndex(String str, PageIndexTrieNode pageIndexTrieNode) {
        int maxFrequency = pageIndexTrieNode.getMaxFrequency();
        int faqAppearCount = pageIndexTrieNode.getFaqAppearCount();
        HashMap hashMap = new HashMap();
        SparseArray<Pair<Integer, Integer>> wordFrequencyMap = pageIndexTrieNode.getWordFrequencyMap();
        int i = -1;
        for (int i2 = 0; i2 < wordFrequencyMap.size(); i2++) {
            int keyAt = wordFrequencyMap.keyAt(i2);
            Pair valueAt = wordFrequencyMap.valueAt(i2);
            double intValue = (double) ((Integer) valueAt.first).intValue();
            double d = (double) maxFrequency;
            Double.isNaN(intValue);
            Double.isNaN(d);
            double d2 = (double) this.totalDocCount;
            double d3 = (double) faqAppearCount;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double log10 = Math.log10(d2 / d3) * (intValue / d);
            double termWeight = (double) HSSearch.getTermWeight(((Integer) valueAt.second).intValue());
            Double.isNaN(termWeight);
            hashMap.put(Integer.valueOf(keyAt), Double.valueOf(log10 * termWeight));
            i = Math.max(i, ((Integer) valueAt.second).intValue());
        }
        pageIndexTrieNode.resetFrequency();
        return new SearchTokenDto(str, i, hashMap);
    }

    public void createAndStoreTfIdfIndex() {
        this.searchTokenDao = SearchTokenDaoImpl.getInstance();
        char[] cArr = new char[50];
        for (PageIndexTrieNode createAndStoreTfIdfIndex : this.root.getChildren()) {
            createAndStoreTfIdfIndex(createAndStoreTfIdfIndex, cArr, 0);
        }
        if (this.searchTokenList.size() > 0) {
            this.searchTokenDao.save(this.searchTokenList);
        }
    }

    public void insert(String str, int i, int i2) {
        if (str != null && 50 >= str.length()) {
            int length = str.length();
            PageIndexTrieNode pageIndexTrieNode = this.root;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                PageIndexTrieNode child = pageIndexTrieNode.getChild(charAt);
                if (child == null) {
                    child = new PageIndexTrieNode(charAt);
                    pageIndexTrieNode.addChild(child);
                }
                pageIndexTrieNode = child;
                if (i != 50 && i3 > 1 && i3 < 10 && i3 + 1 != length) {
                    pageIndexTrieNode.isWordEnd = true;
                    pageIndexTrieNode.addFrequency(i2, (HSSearch.calcFreq(i3, i) * i3) / length, i);
                }
            }
            pageIndexTrieNode.isWordEnd = true;
            pageIndexTrieNode.addFrequency(i2, HSSearch.calcFreq(length, i), i);
        }
    }

    private void createAndStoreTfIdfIndex(PageIndexTrieNode pageIndexTrieNode, char[] cArr, int i) {
        if (pageIndexTrieNode != null) {
            cArr[i] = pageIndexTrieNode.nodeValue;
            if (pageIndexTrieNode.isWordEnd) {
                this.searchTokenList.add(buildTfIdfIndex(new String(cArr, 0, i + 1), pageIndexTrieNode));
                if (this.searchTokenList.size() > 1000) {
                    this.searchTokenDao.save(this.searchTokenList);
                    this.searchTokenList.clear();
                }
            }
            for (PageIndexTrieNode createAndStoreTfIdfIndex : pageIndexTrieNode.getChildren()) {
                createAndStoreTfIdfIndex(createAndStoreTfIdfIndex, cArr, i + 1);
            }
            pageIndexTrieNode.resetChildren();
        }
    }
}
