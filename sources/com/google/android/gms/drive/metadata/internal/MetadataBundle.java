package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SafeParcelable.Class(creator = "MetadataBundleCreator")
@SafeParcelable.Reserved({1})
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();
    public static final GmsLogger zzbz = new GmsLogger("MetadataBundle", "");
    @SafeParcelable.Field(mo17147id = 2)
    public final Bundle zzjh;

    @SafeParcelable.Constructor
    public MetadataBundle(@SafeParcelable.Param(mo17150id = 2) Bundle bundle) {
        int i;
        Bundle bundle2 = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzjh = bundle2;
        bundle2.setClassLoader(MetadataBundle.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzjh.keySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (zzf.zzf(str) == null) {
                arrayList.add(str);
                zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", str);
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.zzjh.remove((String) obj);
        }
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzbe = zzbe();
        zzbe.zzb(metadataField, t);
        return zzbe;
    }

    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != MetadataBundle.class) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzjh.keySet();
        if (!keySet.equals(metadataBundle.zzjh.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!Objects.equal(this.zzjh.get(str), metadataBundle.zzjh.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (String str : this.zzjh.keySet()) {
            i = (i * 31) + this.zzjh.get(str).hashCode();
        }
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzf(metadataField.getName()) == null) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unregistered field: ".concat(valueOf) : new String("Unregistered field: "));
        } else {
            metadataField.zza(t, this.zzjh);
        }
    }

    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    public final Set<MetadataField<?>> zzbg() {
        HashSet hashSet = new HashSet();
        for (String zzf : this.zzjh.keySet()) {
            hashSet.add(zzf.zzf(zzf));
        }
        return hashSet;
    }

    @Nullable
    public final <T> T zzc(MetadataField<T> metadataField) {
        T zza = zza(metadataField);
        this.zzjh.remove(metadataField.getName());
        return zza;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzjh.containsKey(metadataField.getName());
    }

    @Nullable
    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzjh);
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhs.zzkq);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }
}
