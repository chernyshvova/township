package com.helpshift.conversation.viewmodel;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListPickerVM {
    public static final int MIN_CHAR_FOR_SEARCH = 2;
    public static final Object lock = new Object();
    public Domain domain;
    public final ListPickerVMCallback listPickerVMCallback;
    public final OptionInputMessageDM messageDM;

    public abstract class BaseOptionFilter implements OptionFilter {
        public BaseOptionFilter() {
        }

        private List<OptionInput.Option> filterResult(List<OptionInput.Option> list, String str) {
            ArrayList arrayList = new ArrayList();
            Pattern compile = Pattern.compile(str);
            for (OptionInput.Option next : list) {
                if (compile.matcher(next.title.toLowerCase()).find()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        public final List<OptionInput.Option> filter(List<OptionInput.Option> list, List<String> list2) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String regex : list2) {
                linkedHashSet.addAll(filterResult(list, getRegex(regex)));
            }
            return new ArrayList(linkedHashSet);
        }

        public abstract String getRegex(String str);
    }

    public class CompositeOptionFilter implements OptionFilter {
        public List<OptionFilter> optionFilters;

        public CompositeOptionFilter(List<OptionFilter> list) {
            this.optionFilters = list;
        }

        public List<OptionInput.Option> filter(List<OptionInput.Option> list, List<String> list2) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (OptionFilter filter : this.optionFilters) {
                linkedHashSet.addAll(filter.filter(list, list2));
            }
            return new ArrayList(linkedHashSet);
        }
    }

    public interface OptionFilter {
        List<OptionInput.Option> filter(List<OptionInput.Option> list, List<String> list2);
    }

    public class SentencePrefixOptionFilter extends BaseOptionFilter {
        public SentencePrefixOptionFilter() {
            super();
        }

        public String getRegex(String str) {
            return GeneratedOutlineSupport.outline16("^", str);
        }
    }

    public class WordPrefixOptionFilter extends BaseOptionFilter {
        public WordPrefixOptionFilter() {
            super();
        }

        public String getRegex(String str) {
            return GeneratedOutlineSupport.outline16("\\b", str);
        }
    }

    public class WordSubStringFilter extends BaseOptionFilter {
        public WordSubStringFilter() {
            super();
        }

        public String getRegex(String str) {
            return GeneratedOutlineSupport.outline16("\\B", str);
        }
    }

    public ListPickerVM(Domain domain2, OptionInputMessageDM optionInputMessageDM, ListPickerVMCallback listPickerVMCallback2) {
        this.domain = domain2;
        this.messageDM = optionInputMessageDM;
        this.listPickerVMCallback = listPickerVMCallback2;
    }

    /* access modifiers changed from: private */
    public OptionUIModel convertToOptionUIModel(OptionInput.Option option, List<String> list) {
        return new OptionUIModel(option, !ListUtils.isEmpty(list) ? getHighlightInfo(option.title, list) : null);
    }

    private List<OptionUIModel> convertToOptionUIModels(List<OptionInput.Option> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (OptionInput.Option convertToOptionUIModel : list) {
            arrayList.add(convertToOptionUIModel(convertToOptionUIModel, list2));
        }
        return arrayList;
    }

    private void notifyHideClearButton() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ListPickerVM.this.listPickerVMCallback != null) {
                    ListPickerVM.this.listPickerVMCallback.hidePickerClearButton();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyListPickerOptions(final List<OptionUIModel> list) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ListPickerVM.this.listPickerVMCallback != null) {
                    ListPickerVM.this.listPickerVMCallback.updateListPickerOptions(list);
                }
            }
        });
    }

    private void notifyShowClearButton() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ListPickerVM.this.listPickerVMCallback != null) {
                    ListPickerVM.this.listPickerVMCallback.showPickerClearButton();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyShowEmptyListPickerView() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (ListPickerVM.this.listPickerVMCallback != null) {
                    ListPickerVM.this.listPickerVMCallback.showEmptyListPickerView();
                }
            }
        });
    }

    public List<OptionUIModel> getAllOptions() {
        return convertToOptionUIModels(this.messageDM.input.options, (List<String>) null);
    }

    public List<HSRange> getHighlightInfo(String str, List<String> list) {
        if (StringUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String next : list) {
            if (!StringUtils.isEmpty(next)) {
                String lowerCase2 = next.toLowerCase();
                Matcher matcher = Pattern.compile("\\b" + lowerCase2).matcher(lowerCase);
                while (matcher.find()) {
                    int start = matcher.start();
                    if (!hashSet.contains(Integer.valueOf(start))) {
                        arrayList.add(new HSRange(start, matcher.end() - start));
                        hashSet.add(Integer.valueOf(start));
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return null;
        }
        return arrayList;
    }

    public void handleOptionSelectedForPicker(OptionUIModel optionUIModel, boolean z) {
        this.listPickerVMCallback.handleOptionSelectedForPicker(this.messageDM, z ? null : optionUIModel.option, z);
    }

    public void onListPickerSearchQueryChange(String str) {
        if (StringUtils.isEmpty(str)) {
            notifyListPickerOptions(getAllOptions());
            notifyHideClearButton();
            return;
        }
        notifyShowClearButton();
        String trim = str.trim();
        if (trim.length() < 2) {
            notifyListPickerOptions(getAllOptions());
            return;
        }
        String[] split = trim.split("\\b");
        final ArrayList arrayList = new ArrayList();
        for (String trim2 : split) {
            String lowerCase = trim2.trim().toLowerCase();
            if (lowerCase.length() >= 2) {
                arrayList.add(lowerCase);
            }
        }
        if (arrayList.size() == 0) {
            notifyListPickerOptions(getAllOptions());
            return;
        }
        synchronized (lock) {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    List<OptionInput.Option> filter = new CompositeOptionFilter(new ArrayList(Arrays.asList(new BaseOptionFilter[]{new SentencePrefixOptionFilter(), new WordPrefixOptionFilter(), new WordSubStringFilter()}))).filter(ListPickerVM.this.messageDM.input.options, arrayList);
                    if (filter.size() == 0) {
                        ListPickerVM.this.notifyShowEmptyListPickerView();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (OptionInput.Option access$200 : filter) {
                        arrayList.add(ListPickerVM.this.convertToOptionUIModel(access$200, arrayList));
                    }
                    ListPickerVM.this.notifyListPickerOptions(arrayList);
                }
            });
        }
    }
}
