package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: GameRequestContent.kt */
public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new GameRequestContent$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final ActionType actionType;
    public final String cta;
    public final String data;
    public final Filters filters;
    public final String message;
    public final String objectId;
    public final List<String> recipients;
    public final List<String> suggestions;
    public final String title;

    /* compiled from: GameRequestContent.kt */
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN,
        INVITE
    }

    /* compiled from: GameRequestContent.kt */
    public static final class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        public ActionType actionType;
        public String cta;
        public String data;
        public Filters filters;
        public String message;
        public String objectId;
        public List<String> recipients;
        public List<String> suggestions;
        public String title;

        public final ActionType getActionType$facebook_common_release() {
            return this.actionType;
        }

        public final String getCta$facebook_common_release() {
            return this.cta;
        }

        public final String getData$facebook_common_release() {
            return this.data;
        }

        public final Filters getFilters$facebook_common_release() {
            return this.filters;
        }

        public final String getMessage$facebook_common_release() {
            return this.message;
        }

        public final String getObjectId$facebook_common_release() {
            return this.objectId;
        }

        public final List<String> getRecipients$facebook_common_release() {
            return this.recipients;
        }

        public final List<String> getSuggestions$facebook_common_release() {
            return this.suggestions;
        }

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
        }

        public final Builder setActionType(ActionType actionType2) {
            this.actionType = actionType2;
            return this;
        }

        public final void setActionType$facebook_common_release(ActionType actionType2) {
            this.actionType = actionType2;
        }

        public final Builder setCta(String str) {
            this.cta = str;
            return this;
        }

        public final void setCta$facebook_common_release(String str) {
            this.cta = str;
        }

        public final Builder setData(String str) {
            this.data = str;
            return this;
        }

        public final void setData$facebook_common_release(String str) {
            this.data = str;
        }

        public final Builder setFilters(Filters filters2) {
            this.filters = filters2;
            return this;
        }

        public final void setFilters$facebook_common_release(Filters filters2) {
            this.filters = filters2;
        }

        public final Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public final void setMessage$facebook_common_release(String str) {
            this.message = str;
        }

        public final Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public final void setObjectId$facebook_common_release(String str) {
            this.objectId = str;
        }

        public final Builder setRecipients(List<String> list) {
            this.recipients = list;
            return this;
        }

        public final void setRecipients$facebook_common_release(List<String> list) {
            this.recipients = list;
        }

        public final Builder setSuggestions(List<String> list) {
            this.suggestions = list;
            return this;
        }

        public final void setSuggestions$facebook_common_release(List<String> list) {
            this.suggestions = list;
        }

        public final Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public final void setTitle$facebook_common_release(String str) {
            this.title = str;
        }

        public final Builder setTo(String str) {
            if (str != null) {
                char[] cArr = {','};
                Intrinsics.checkNotNullParameter(str, "$this$split");
                Intrinsics.checkNotNullParameter(cArr, "delimiters");
                this.recipients = CollectionsKt__CollectionsKt.toList(CharsKt__CharKt.split$StringsKt__StringsKt(str, String.valueOf(cArr[0]), false, 0));
            }
            return this;
        }

        public GameRequestContent build() {
            return new GameRequestContent(this, (DefaultConstructorMarker) null);
        }

        public Builder readFrom(GameRequestContent gameRequestContent) {
            if (gameRequestContent == null) {
                return this;
            }
            return setMessage(gameRequestContent.getMessage()).setCta(gameRequestContent.getCta()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }
    }

    /* compiled from: GameRequestContent.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GameRequestContent.kt */
    public enum Filters {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY
    }

    public GameRequestContent(Builder builder) {
        this.message = builder.getMessage$facebook_common_release();
        this.cta = builder.getCta$facebook_common_release();
        this.recipients = builder.getRecipients$facebook_common_release();
        this.title = builder.getTitle$facebook_common_release();
        this.data = builder.getData$facebook_common_release();
        this.actionType = builder.getActionType$facebook_common_release();
        this.objectId = builder.getObjectId$facebook_common_release();
        this.filters = builder.getFilters$facebook_common_release();
        this.suggestions = builder.getSuggestions$facebook_common_release();
    }

    public /* synthetic */ GameRequestContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getCta() {
        return this.cta;
    }

    public final String getData() {
        return this.data;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTo() {
        List<String> list = this.recipients;
        if (list != null) {
            return TextUtils.join(",", list);
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.message);
        parcel.writeString(this.cta);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
    }

    public GameRequestContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.message = parcel.readString();
        this.cta = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
    }
}
