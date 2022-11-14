package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new zao();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaa;
    public final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zab;
    @SafeParcelable.Field(getter = "getSerializedDictionary", mo17147id = 2)
    @Nullable
    public final ArrayList<zam> zac;
    @SafeParcelable.Field(getter = "getRootClassName", mo17147id = 3)
    public final String zad;

    @SafeParcelable.Constructor
    public zaj(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) ArrayList<zam> arrayList, @SafeParcelable.Param(mo17150id = 3) String str) {
        this.zaa = i;
        this.zac = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zam zam = arrayList.get(i2);
            String str2 = zam.zaa;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.checkNotNull(zam.zab)).size();
            for (int i3 = 0; i3 < size2; i3++) {
                zal zal = zam.zab.get(i3);
                hashMap2.put(zal.zaa, zal.zab);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zab = hashMap;
        this.zad = (String) Preconditions.checkNotNull(str);
        zaa();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zab.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.zab.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zab.keySet()) {
            arrayList.add(new zam(next, this.zab.get(next)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.zad, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zaa() {
        for (String str : this.zab.keySet()) {
            Map map = this.zab.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zaa(this);
            }
        }
    }

    public final void zab() {
        for (String next : this.zab.keySet()) {
            Map map = this.zab.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zaa());
            }
            this.zab.put(next, hashMap);
        }
    }

    public final String zac() {
        return this.zad;
    }

    public final void zaa(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zab.put((String) Preconditions.checkNotNull(cls.getCanonicalName()), map);
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> zaa(String str) {
        return this.zab.get(str);
    }

    public final boolean zaa(Class<? extends FastJsonResponse> cls) {
        return this.zab.containsKey(Preconditions.checkNotNull(cls.getCanonicalName()));
    }

    public zaj(Class<? extends FastJsonResponse> cls) {
        this.zaa = 1;
        this.zac = null;
        this.zab = new HashMap<>();
        this.zad = (String) Preconditions.checkNotNull(cls.getCanonicalName());
    }
}
