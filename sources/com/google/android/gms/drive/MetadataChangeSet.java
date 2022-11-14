package com.google.android.gms.drive;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzif;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzax = new MetadataChangeSet(MetadataBundle.zzbe());
    public final MetadataBundle zzay;

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.zzay = metadataBundle.zzbf();
    }

    public final Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzay.zza(zzhs.zzjn);
        if (appVisibleCustomProperties == null) {
            return Collections.emptyMap();
        }
        return appVisibleCustomProperties.zzba();
    }

    @Nullable
    public final String getDescription() {
        return (String) this.zzay.zza(zzhs.zzjo);
    }

    @Nullable
    public final String getIndexableText() {
        return (String) this.zzay.zza(zzhs.zzju);
    }

    @Nullable
    public final Date getLastViewedByMeDate() {
        return (Date) this.zzay.zza(zzif.zzle);
    }

    @Nullable
    public final String getMimeType() {
        return (String) this.zzay.zza(zzhs.zzki);
    }

    @KeepForSdk
    @Nullable
    public final Bitmap getThumbnail() {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) this.zzay.zza(zzhs.zzkq);
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    @Nullable
    public final String getTitle() {
        return (String) this.zzay.zza(zzhs.zzkr);
    }

    @Nullable
    public final Boolean isPinned() {
        return (Boolean) this.zzay.zza(zzhs.zzka);
    }

    @Nullable
    public final Boolean isStarred() {
        return (Boolean) this.zzay.zza(zzhs.zzkp);
    }

    @Nullable
    public final Boolean isViewed() {
        return (Boolean) this.zzay.zza(zzhs.zzkh);
    }

    public final MetadataBundle zzq() {
        return this.zzay;
    }

    public static class Builder {
        public final MetadataBundle zzay = MetadataBundle.zzbe();
        public AppVisibleCustomProperties.zza zzaz;

        public static void zza(String str, int i, int i2) {
            Preconditions.checkArgument(i2 <= i, String.format(Locale.US, "%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public static int zzb(@Nullable String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        private final AppVisibleCustomProperties.zza zzr() {
            if (this.zzaz == null) {
                this.zzaz = new AppVisibleCustomProperties.zza();
            }
            return this.zzaz;
        }

        public MetadataChangeSet build() {
            AppVisibleCustomProperties.zza zza = this.zzaz;
            if (zza != null) {
                this.zzay.zzb(zzhs.zzjn, zza.zzbb());
            }
            return new MetadataChangeSet(this.zzay);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            zzr().zza(customPropertyKey, (String) null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            Preconditions.checkNotNull(str, "value");
            zza("The total size of key string and value string of a custom property", 124, zzb(str) + zzb(customPropertyKey.getKey()));
            zzr().zza(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzay.zzb(zzhs.zzjo, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            zza("Indexable text size", 131072, zzb(str));
            this.zzay.zzb(zzhs.zzju, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzay.zzb(zzif.zzle, date);
            return this;
        }

        public Builder setMimeType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzay.zzb(zzhs.zzki, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.zzay.zzb(zzhs.zzka, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.zzay.zzb(zzhs.zzkp, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(@NonNull String str) {
            Preconditions.checkNotNull(str, "Title cannot be null.");
            this.zzay.zzb(zzhs.zzkr, str);
            return this;
        }

        @Deprecated
        public Builder setViewed(boolean z) {
            if (z) {
                this.zzay.zzb(zzhs.zzkh, Boolean.TRUE);
            } else if (this.zzay.zzd(zzhs.zzkh)) {
                this.zzay.zzc(zzhs.zzkh);
            }
            return this;
        }

        public Builder setViewed() {
            this.zzay.zzb(zzhs.zzkh, Boolean.TRUE);
            return this;
        }
    }
}
