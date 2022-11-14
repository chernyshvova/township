package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "EventEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class EventEntity extends zzh implements Event {
    @RecentlyNonNull
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getEventId", mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getName", mo17147id = 2)
    public final String zzb;
    @SafeParcelable.Field(getter = "getDescription", mo17147id = 3)
    public final String zzc;
    @SafeParcelable.Field(getter = "getIconImageUri", mo17147id = 4)
    public final Uri zzd;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo17147id = 5)
    public final String zze;
    @SafeParcelable.Field(getter = "getPlayer", mo17147id = 6)
    public final PlayerEntity zzf;
    @SafeParcelable.Field(getter = "getValue", mo17147id = 7)
    public final long zzg;
    @SafeParcelable.Field(getter = "getFormattedValue", mo17147id = 8)
    public final String zzh;
    @SafeParcelable.Field(getter = "isVisible", mo17147id = 9)
    public final boolean zzi;

    public EventEntity(@RecentlyNonNull Event event) {
        this.zza = event.getEventId();
        this.zzb = event.getName();
        this.zzc = event.getDescription();
        this.zzd = event.getIconImageUri();
        this.zze = event.getIconImageUrl();
        this.zzf = (PlayerEntity) event.getPlayer().freeze();
        this.zzg = event.getValue();
        this.zzh = event.getFormattedValue();
        this.zzi = event.isVisible();
    }

    public static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    public static String zzb(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public static boolean zzc(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    public boolean equals(@Nullable Object obj) {
        return zzc(this, obj);
    }

    @RecentlyNonNull
    public Event freeze() {
        return this;
    }

    @RecentlyNonNull
    public String getDescription() {
        return this.zzc;
    }

    public void getDescription(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @RecentlyNonNull
    public String getEventId() {
        return this.zza;
    }

    @RecentlyNonNull
    public String getFormattedValue() {
        return this.zzh;
    }

    public void getFormattedValue(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzh, charArrayBuffer);
    }

    @RecentlyNonNull
    public Uri getIconImageUri() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String getIconImageUrl() {
        return this.zze;
    }

    @RecentlyNonNull
    public String getName() {
        return this.zzb;
    }

    public void getName(@RecentlyNonNull CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @RecentlyNonNull
    public Player getPlayer() {
        return this.zzf;
    }

    public long getValue() {
        return this.zzg;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.zzi;
    }

    @RecentlyNonNull
    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public EventEntity(@SafeParcelable.Param(mo17150id = 1) String str, @SafeParcelable.Param(mo17150id = 2) String str2, @SafeParcelable.Param(mo17150id = 3) String str3, @SafeParcelable.Param(mo17150id = 4) Uri uri, @SafeParcelable.Param(mo17150id = 5) String str4, @SafeParcelable.Param(mo17150id = 6) Player player, @SafeParcelable.Param(mo17150id = 7) long j, @SafeParcelable.Param(mo17150id = 8) String str5, @SafeParcelable.Param(mo17150id = 9) boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = uri;
        this.zze = str4;
        this.zzf = new PlayerEntity(player);
        this.zzg = j;
        this.zzh = str5;
        this.zzi = z;
    }
}
