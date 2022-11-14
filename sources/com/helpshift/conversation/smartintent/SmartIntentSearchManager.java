package com.helpshift.conversation.smartintent;

import androidx.annotation.NonNull;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.helpshift.conversation.smartintent.dao.SmartIntentDAO;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SISearchResultDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class SmartIntentSearchManager {
    public static final int AI_LEAF_INTENT_MATCH_RESULT_LIMIT = 5;
    public static final int AI_MODEL_MATCH = 1;
    public static final int AI_ROOT_INTENT_MATCH_RESULT_LIMIT = 2;
    public static final int FALLBACK_INTENT_MATCH_RESULT_LIMIT = 5;
    public static final int MIN_CHAR_TO_TRIGGER_SEARCH = 4;
    public static final int SUBSTRING_MATCH = 2;
    public static final String TAG = "Helpshift_siSearchM";
    public Pattern patternGenerateToken = null;
    public SmartIntentDAO smartIntentDAO;

    public SmartIntentSearchManager(SmartIntentDAO smartIntentDAO2) {
        this.smartIntentDAO = smartIntentDAO2;
    }

    private List<String> generateTokensForSearchQuery(SITreeDTO sITreeDTO, String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String valueOf = String.valueOf(str.charAt(i));
            if (sITreeDTO.tokenDelimiter.contains(valueOf)) {
                String sb2 = sb.toString();
                if (StringUtils.isNotEmpty(sb2)) {
                    arrayList.add(sb2.trim().toLowerCase());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(valueOf);
            }
        }
        String sb3 = sb.toString();
        if (StringUtils.isNotEmpty(sb3)) {
            arrayList.add(sb3.trim().toLowerCase());
        }
        return arrayList;
    }

    private List<Double> getLeafIntentsProbability(SISearchModelDTO sISearchModelDTO, List<String> list) {
        List<Double> list2 = sISearchModelDTO.leafIntentBaseProbabilities;
        for (String wordToIntentProbabilities : list) {
            List<Double> wordToIntentProbabilities2 = this.smartIntentDAO.getWordToIntentProbabilities(sISearchModelDTO.localId.longValue(), wordToIntentProbabilities);
            if (ListUtils.isNotEmpty(wordToIntentProbabilities2)) {
                list2 = joinListsByElementsSum(list2, wordToIntentProbabilities2);
            }
        }
        return normalizeProbabilities(list2);
    }

    private List<ValuePair<String, Double>> getSubList(List<ValuePair<String, Double>> list, int i, double d) {
        int min = Math.min(list.size(), i);
        ArrayList arrayList = new ArrayList();
        double d2 = RoundRectDrawableWithShadow.COS_45;
        for (int i2 = 0; i2 < min; i2++) {
            ValuePair valuePair = list.get(i2);
            arrayList.add(valuePair);
            d2 += ((Double) valuePair.second).doubleValue();
            if (d2 >= d) {
                break;
            }
        }
        return arrayList;
    }

    private List<Double> joinListsByElementsSum(List<Double> list, List<Double> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(Double.valueOf(list2.get(i).doubleValue() + list.get(i).doubleValue()));
        }
        return arrayList;
    }

    private SISearchResultDTO matchIntentsViaAIAlgorithm(SITreeDTO sITreeDTO, SISearchModelDTO sISearchModelDTO, List<String> list) {
        HSLogger.m3237d(TAG, "Triggering intent search via AI model");
        List<ValuePair<String, Double>> rankProbabilities = rankProbabilities(getLeafIntentsProbability(sISearchModelDTO, list), sISearchModelDTO.leafIntentServerIds);
        if (ListUtils.isEmpty(rankProbabilities)) {
            return new SISearchResultDTO(false, (Integer) null, (Integer) null, (Integer) null, (List<ValuePair<String, Double>>) null);
        }
        if (((Double) rankProbabilities.get(0).second).doubleValue() >= sISearchModelDTO.confidenceThreshold.doubleValue()) {
            return new SISearchResultDTO(true, 1, 2, sISearchModelDTO.version, getSubList(rankProbabilities, 5, sISearchModelDTO.maxCombinedConfidence.doubleValue()));
        }
        HashMap hashMap = new HashMap();
        for (ValuePair next : rankProbabilities) {
            hashMap.put(next.first, next.second);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SmartIntentDTO next2 : sITreeDTO.rootIntents) {
            Double valueOf = Double.valueOf(RoundRectDrawableWithShadow.COS_45);
            for (SmartIntentDTO smartIntentDTO : next2.children) {
                Double d = (Double) hashMap.get(smartIntentDTO.serverId);
                if (d != null) {
                    valueOf = Double.valueOf(d.doubleValue() + valueOf.doubleValue());
                }
            }
            arrayList.add(next2.serverId);
            arrayList2.add(valueOf);
        }
        return new SISearchResultDTO(true, 1, 1, sISearchModelDTO.version, getSubList(rankProbabilities(normalizeProbabilities(arrayList2), arrayList), 2, sISearchModelDTO.maxCombinedConfidence.doubleValue()));
    }

    private SISearchResultDTO matchIntentsViaSubstringAlgorithm(@NonNull SITreeDTO sITreeDTO, @NonNull List<String> list) {
        HSLogger.m3237d(TAG, "Triggering intent search via substring matching");
        ArrayList arrayList = new ArrayList();
        for (SmartIntentDTO smartIntentDTO : sITreeDTO.rootIntents) {
            Iterator<SmartIntentDTO> it = smartIntentDTO.children.iterator();
            while (true) {
                if (it.hasNext()) {
                    SmartIntentDTO next = it.next();
                    String lowerCase = next.label.toLowerCase();
                    Iterator<String> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (lowerCase.contains(it2.next())) {
                            arrayList.add(new ValuePair(next.serverId, null));
                            if (arrayList.size() == 5) {
                                return new SISearchResultDTO(true, 2, 2, (Integer) null, arrayList);
                            }
                        }
                    }
                }
            }
        }
        return new SISearchResultDTO(true, 2, 2, (Integer) null, arrayList);
    }

    private List<Double> normalizeProbabilities(List<Double> list) {
        Double d = (Double) Collections.max(list);
        ArrayList arrayList = new ArrayList();
        for (Double doubleValue : list) {
            arrayList.add(Double.valueOf(doubleValue.doubleValue() - d.doubleValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Double.valueOf(Math.exp(((Double) it.next()).doubleValue())));
        }
        Double valueOf = Double.valueOf(RoundRectDrawableWithShadow.COS_45);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            valueOf = Double.valueOf(((Double) it2.next()).doubleValue() + valueOf.doubleValue());
        }
        if (valueOf.doubleValue() == RoundRectDrawableWithShadow.COS_45) {
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Double.valueOf(((Double) it3.next()).doubleValue() / valueOf.doubleValue()));
        }
        return arrayList3;
    }

    private List<ValuePair<String, Double>> rankProbabilities(List<Double> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return new ArrayList();
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new ValuePair(list2.get(i), list.get(i)));
        }
        Collections.sort(arrayList, new Comparator<ValuePair<String, Double>>() {
            public int compare(ValuePair<String, Double> valuePair, ValuePair<String, Double> valuePair2) {
                if (((Double) valuePair.second).equals(valuePair2.second)) {
                    return 0;
                }
                return ((Double) valuePair.second).doubleValue() > ((Double) valuePair2.second).doubleValue() ? -1 : 1;
            }
        });
        return arrayList;
    }

    public SISearchResultDTO match(SITreeDTO sITreeDTO, String str) {
        if (StringUtils.isEmpty(str) || sITreeDTO == null) {
            return new SISearchResultDTO(false, (Integer) null, (Integer) null, (Integer) null, (List<ValuePair<String, Double>>) null);
        }
        String trim = str.trim();
        if (trim.length() < 4) {
            return new SISearchResultDTO(false, (Integer) null, (Integer) null, (Integer) null, (List<ValuePair<String, Double>>) null);
        }
        List<String> generateTokensForSearchQuery = generateTokensForSearchQuery(sITreeDTO, trim);
        SISearchModelDTO modelWithoutWordProbabilities = this.smartIntentDAO.getModelWithoutWordProbabilities(sITreeDTO.localId.longValue());
        if (modelWithoutWordProbabilities != null) {
            return matchIntentsViaAIAlgorithm(sITreeDTO, modelWithoutWordProbabilities, generateTokensForSearchQuery);
        }
        return matchIntentsViaSubstringAlgorithm(sITreeDTO, generateTokensForSearchQuery);
    }
}
