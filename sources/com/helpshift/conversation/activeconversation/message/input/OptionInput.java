package com.helpshift.conversation.activeconversation.message.input;

import androidx.annotation.NonNull;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSCloneable;
import java.util.List;

public class OptionInput extends Input implements HSCloneable {
    public final List<Option> options;
    public final Type type;

    public static class Option implements HSCloneable {
        public final String jsonData;
        public final String title;

        public Option(String str, String str2) {
            this.title = str;
            this.jsonData = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Option)) {
                return false;
            }
            Option option = (Option) obj;
            if (!option.title.equals(this.title) || !option.jsonData.equals(this.jsonData)) {
                return false;
            }
            return true;
        }

        public Option deepClone() {
            return new Option(this);
        }

        public Option(Option option) {
            this.title = option.title;
            this.jsonData = option.jsonData;
        }
    }

    public enum Type {
        PILL("pill"),
        PICKER("picker");
        
        public final String optionInputType;

        /* access modifiers changed from: public */
        Type(String str) {
            this.optionInputType = str;
        }

        public static Type getType(String str, int i) {
            if ("pill".equals(str)) {
                return PILL;
            }
            if ("picker".equals(str)) {
                return PICKER;
            }
            if (i <= 5) {
                return PILL;
            }
            return PICKER;
        }

        @NonNull
        public String toString() {
            return this.optionInputType;
        }
    }

    public OptionInput(String str, boolean z, String str2, String str3, List<Option> list, Type type2) {
        super(str, z, str2, str3);
        this.options = list;
        this.type = type2;
    }

    public OptionInput deepClone() {
        return new OptionInput(this);
    }

    public OptionInput(OptionInput optionInput) {
        super(optionInput);
        this.options = CloneUtil.deepClone(optionInput.options);
        this.type = optionInput.type;
    }
}
