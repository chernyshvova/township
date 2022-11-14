package com.helpshift.conversation.viewmodel;

import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import java.util.List;

public class OptionUIModel {
    public final OptionInput.Option option;
    public final List<HSRange> titleHighlightInfo;

    public OptionUIModel(OptionInput.Option option2, List<HSRange> list) {
        this.option = option2;
        this.titleHighlightInfo = list;
    }
}
