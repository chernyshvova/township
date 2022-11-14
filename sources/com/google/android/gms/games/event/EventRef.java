package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class EventRef extends DataBufferRef implements Event {
    public EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        return EventEntity.zzc(this, obj);
    }

    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object freeze() {
        return new EventEntity(this);
    }

    @RecentlyNonNull
    public final String getDescription() {
        return getString("description");
    }

    @RecentlyNonNull
    public final String getEventId() {
        return getString("external_event_id");
    }

    @RecentlyNonNull
    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return parseUri("icon_image_uri");
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    @RecentlyNonNull
    public final String getName() {
        return getString("name");
    }

    @RecentlyNonNull
    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow, (String) null);
    }

    public final long getValue() {
        return getLong("value");
    }

    public final int hashCode() {
        return EventEntity.zza(this);
    }

    public final boolean isVisible() {
        return getBoolean(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
    }

    @RecentlyNonNull
    public final String toString() {
        return EventEntity.zzb(this);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        new EventEntity(this).writeToParcel(parcel, i);
    }

    public final void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final void getFormattedValue(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("formatted_value", charArrayBuffer);
    }

    public final void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}
