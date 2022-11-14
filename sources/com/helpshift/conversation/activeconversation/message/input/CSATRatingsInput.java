package com.helpshift.conversation.activeconversation.message.input;

import androidx.annotation.NonNull;
import com.helpshift.util.CloneUtil;
import com.helpshift.util.HSCloneable;
import java.util.List;

public class CSATRatingsInput extends Input implements HSCloneable {
    public final List<Rating> ratings;
    public final String sendFeedbackLabel;
    public final boolean showNewConversationButton;
    public final String startNewConversationLabel;
    public final Type type;

    public static class Rating implements HSCloneable {
        public final String jsonData;
        public final String title;
        public final int value;

        public Rating(String str, int i, String str2) {
            this.title = str;
            this.value = i;
            this.jsonData = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Rating)) {
                return false;
            }
            Rating rating = (Rating) obj;
            if (!rating.title.equals(this.title) || !rating.jsonData.equals(this.jsonData)) {
                return false;
            }
            return true;
        }

        public Rating deepClone() {
            return new Rating(this);
        }

        public Rating(Rating rating) {
            this.title = rating.title;
            this.value = rating.value;
            this.jsonData = rating.jsonData;
        }
    }

    public enum Type {
        STAR_5("five_star");
        
        public final String ratingInputType;

        /* access modifiers changed from: public */
        Type(String str) {
            this.ratingInputType = str;
        }

        public static Type getType() {
            return STAR_5;
        }

        @NonNull
        public String toString() {
            return this.ratingInputType;
        }
    }

    public CSATRatingsInput(String str, boolean z, String str2, String str3, String str4, boolean z2, String str5, List<Rating> list, Type type2) {
        super(str, z, str2, str3);
        this.ratings = list;
        this.type = type2;
        this.sendFeedbackLabel = str4;
        this.showNewConversationButton = z2;
        this.startNewConversationLabel = str5;
    }

    public CSATRatingsInput deepClone() {
        return new CSATRatingsInput(this);
    }

    public CSATRatingsInput(CSATRatingsInput cSATRatingsInput) {
        super(cSATRatingsInput);
        this.ratings = CloneUtil.deepClone(cSATRatingsInput.ratings);
        this.type = cSATRatingsInput.type;
        this.sendFeedbackLabel = cSATRatingsInput.sendFeedbackLabel;
        this.startNewConversationLabel = cSATRatingsInput.startNewConversationLabel;
        this.showNewConversationButton = cSATRatingsInput.showNewConversationButton;
    }
}
