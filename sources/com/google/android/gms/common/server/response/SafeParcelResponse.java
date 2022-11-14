package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
    @SafeParcelable.VersionField(getter = "getVersionCode", mo17153id = 1)
    public final int zaa;
    @SafeParcelable.Field(getter = "getParcel", mo17147id = 2)
    public final Parcel zab;
    public final int zac;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", mo17147id = 3)
    public final zaj zad;
    @Nullable
    public final String zae;
    public int zaf;
    public int zag;

    public SafeParcelResponse(zaj zaj, String str) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zaj) Preconditions.checkNotNull(zaj);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 0;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(@RecentlyNonNull T t) {
        zaj zaj = new zaj(t.getClass());
        zaa(zaj, t);
        zaj.zab();
        zaj.zaa();
        return new SafeParcelResponse((SafeParcelable) t, zaj, (String) Preconditions.checkNotNull(t.getClass().getCanonicalName()));
    }

    public static void zaa(zaj zaj, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zaj.zaa((Class<? extends FastJsonResponse>) cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            zaj.zaa(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> cls2 = field.zag;
                if (cls2 != null) {
                    try {
                        zaa(zaj, (FastJsonResponse) cls2.newInstance());
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
                    } catch (IllegalAccessException e2) {
                        String valueOf2 = String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
                    }
                }
            }
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<T> arrayList) {
        zaa(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            T t = arrayList.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) t)).zaa());
        }
        SafeParcelWriter.writeParcelList(this.zab, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @RecentlyNonNull T t) {
        zaa(field);
        SafeParcelWriter.writeParcel(this.zab, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).zaa(), true);
    }

    @RecentlyNullable
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zaj zaj = this.zad;
        if (zaj == null) {
            return null;
        }
        return zaj.zaa((String) Preconditions.checkNotNull(this.zae));
    }

    @RecentlyNonNull
    public Object getValueObject(@RecentlyNonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean isPrimitiveFieldSet(@RecentlyNonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public void setBooleanInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, boolean z) {
        zaa(field);
        SafeParcelWriter.writeBoolean(this.zab, field.getSafeParcelableFieldId(), z);
    }

    public void setDecodedBytesInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable byte[] bArr) {
        zaa(field);
        SafeParcelWriter.writeByteArray(this.zab, field.getSafeParcelableFieldId(), bArr, true);
    }

    public void setIntegerInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, int i) {
        zaa(field);
        SafeParcelWriter.writeInt(this.zab, field.getSafeParcelableFieldId(), i);
    }

    public void setLongInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, long j) {
        zaa(field);
        SafeParcelWriter.writeLong(this.zab, field.getSafeParcelableFieldId(), j);
    }

    public void setStringInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable String str2) {
        zaa(field);
        SafeParcelWriter.writeString(this.zab, field.getSafeParcelableFieldId(), str2, true);
    }

    public void setStringMapInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable Map<String, String> map) {
        zaa(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.checkNotNull(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zab, field.getSafeParcelableFieldId(), bundle, true);
    }

    public void setStringsInternal(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<String> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zab, field.getSafeParcelableFieldId(), strArr, true);
    }

    @RecentlyNonNull
    public String toString() {
        Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
        Parcel zaa2 = zaa();
        zaa2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaa(sb, (Map<String, FastJsonResponse.Field<?, ?>>) (Map) Preconditions.checkNotNull(this.zad.zaa((String) Preconditions.checkNotNull(this.zae))), zaa2);
        return sb.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        zaj zaj;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcel(parcel, 2, zaa(), false);
        int i2 = this.zac;
        if (i2 == 0) {
            zaj = null;
        } else if (i2 == 1) {
            zaj = this.zad;
        } else if (i2 == 2) {
            zaj = this.zad;
        } else {
            throw new IllegalStateException(GeneratedOutlineSupport.outline9(34, "Invalid creation type: ", this.zac));
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zaj, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zab(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<BigInteger> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zab, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    public final void zac(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Long> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zab, field.getSafeParcelableFieldId(), jArr, true);
    }

    public final void zad(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Float> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zab, field.getSafeParcelableFieldId(), fArr, true);
    }

    public final void zae(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Double> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zab, field.getSafeParcelableFieldId(), dArr, true);
    }

    public final void zaf(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<BigDecimal> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zab, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    public final void zag(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Boolean> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zab, field.getSafeParcelableFieldId(), zArr, true);
    }

    public SafeParcelResponse(SafeParcelable safeParcelable, zaj zaj, String str) {
        this.zaa = 1;
        Parcel obtain = Parcel.obtain();
        this.zab = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zac = 1;
        this.zad = (zaj) Preconditions.checkNotNull(zaj);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 2;
    }

    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) Parcel parcel, @SafeParcelable.Param(mo17150id = 3) zaj zaj) {
        this.zaa = i;
        this.zab = (Parcel) Preconditions.checkNotNull(parcel);
        this.zac = 2;
        this.zad = zaj;
        if (zaj == null) {
            this.zae = null;
        } else {
            this.zae = zaj.zac();
        }
        this.zaf = 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Parcel zaa() {
        /*
            r2 = this;
            int r0 = r2.zaf
            if (r0 == 0) goto L_0x0008
            r1 = 1
            if (r0 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0008:
            android.os.Parcel r0 = r2.zab
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(r0)
            r2.zag = r0
        L_0x0010:
            android.os.Parcel r0 = r2.zab
            int r1 = r2.zag
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(r0, r1)
            r0 = 2
            r2.zaf = r0
        L_0x001a:
            android.os.Parcel r0 = r2.zab
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zaa():android.os.Parcel");
    }

    private final void zaa(FastJsonResponse.Field<?, ?> field) {
        if (field.zaf != -1) {
            Parcel parcel = this.zab;
            if (parcel != null) {
                int i = this.zaf;
                if (i == 0) {
                    this.zag = SafeParcelWriter.beginObjectHeader(parcel);
                    this.zaf = 1;
                } else if (i == 1) {
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    }
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    public final void zaa(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Integer> arrayList) {
        zaa(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zab, field.getSafeParcelableFieldId(), iArr, true);
    }

    public final void zaa(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable BigInteger bigInteger) {
        zaa(field);
        SafeParcelWriter.writeBigInteger(this.zab, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    public final void zaa(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, float f) {
        zaa(field);
        SafeParcelWriter.writeFloat(this.zab, field.getSafeParcelableFieldId(), f);
    }

    public final void zaa(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, double d) {
        zaa(field);
        SafeParcelWriter.writeDouble(this.zab, field.getSafeParcelableFieldId(), d);
    }

    public final void zaa(@RecentlyNonNull FastJsonResponse.Field<?, ?> field, @RecentlyNonNull String str, @Nullable BigDecimal bigDecimal) {
        zaa(field);
        SafeParcelWriter.writeBigDecimal(this.zab, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    private final void zaa(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry next : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) next.getValue()).getSafeParcelableFieldId(), next);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry.getValue();
                sb.append("\"");
                sb.append((String) entry.getKey());
                sb.append("\":");
                if (field.zab()) {
                    switch (field.zac) {
                        case 0:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str : createBundle.keySet()) {
                                hashMap.put(str, (String) Preconditions.checkNotNull(createBundle.getString(str)));
                            }
                            zaa(sb, (FastJsonResponse.Field<?, ?>) field, FastJsonResponse.zaa(field, (Object) hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(36, "Unknown field out type = ", field.zac));
                    }
                } else if (field.zad) {
                    sb.append("[");
                    switch (field.zac) {
                        case 0:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(sb, (T[]) SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(sb, (T[]) SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            int length = createParcelArray.length;
                            for (int i = 0; i < length; i++) {
                                if (i > 0) {
                                    sb.append(",");
                                }
                                createParcelArray[i].setDataPosition(0);
                                zaa(sb, field.zad(), createParcelArray[i]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.zac) {
                        case 0:
                            sb.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            String createString = SafeParcelReader.createString(parcel, readHeader);
                            sb.append("\"");
                            sb.append(JsonUtils.escapeString(createString));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb.append("\"");
                            sb.append(Base64Utils.encode(createByteArray));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe(createByteArray2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle2.keySet();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str2 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                GeneratedOutlineSupport.outline34(sb, "\"", str2, "\"", CertificateUtil.DELIMITER);
                                sb.append("\"");
                                sb.append(JsonUtils.escapeString(createBundle2.getString(str2)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zaa(sb, field.zad(), createParcel);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException(GeneratedOutlineSupport.outline9(37, "Overread allowed size end=", validateObjectHeader), parcel);
    }

    public static void zaa(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zab) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                zaa(sb, field.zaa, arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        zaa(sb, field.zaa, obj);
    }

    public static void zaa(StringBuilder sb, int i, @Nullable Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(Preconditions.checkNotNull(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) Preconditions.checkNotNull(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(26, "Unknown type = ", i));
        }
    }
}
