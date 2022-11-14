package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zab;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class FastJsonResponse {

    @ShowFirstParty
    @SafeParcelable.Class(creator = "FieldCreator")
    @VisibleForTesting
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zai CREATOR = new zai();
        @SafeParcelable.Field(getter = "getTypeIn", mo17147id = 2)
        public final int zaa;
        @SafeParcelable.Field(getter = "isTypeInArray", mo17147id = 3)
        public final boolean zab;
        @SafeParcelable.Field(getter = "getTypeOut", mo17147id = 4)
        public final int zac;
        @SafeParcelable.Field(getter = "isTypeOutArray", mo17147id = 5)
        public final boolean zad;
        @RecentlyNonNull
        @SafeParcelable.Field(getter = "getOutputFieldName", mo17147id = 6)
        public final String zae;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", mo17147id = 7)
        public final int zaf;
        @RecentlyNullable
        public final Class<? extends FastJsonResponse> zag;
        @SafeParcelable.VersionField(getter = "getVersionCode", mo17153id = 1)
        public final int zah;
        @SafeParcelable.Field(getter = "getConcreteTypeName", mo17147id = 8)
        @Nullable
        public final String zai;
        public zaj zaj;
        @SafeParcelable.Field(getter = "getWrappedConverter", mo17147id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        @Nullable
        public FieldConverter<I, O> zak;

        @SafeParcelable.Constructor
        public Field(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) int i2, @SafeParcelable.Param(mo17150id = 3) boolean z, @SafeParcelable.Param(mo17150id = 4) int i3, @SafeParcelable.Param(mo17150id = 5) boolean z2, @SafeParcelable.Param(mo17150id = 6) String str, @SafeParcelable.Param(mo17150id = 7) int i4, @SafeParcelable.Param(mo17150id = 8) @Nullable String str2, @SafeParcelable.Param(mo17150id = 9) @Nullable zab zab2) {
            this.zah = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zai = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zai = str2;
            }
            if (zab2 == null) {
                this.zak = null;
            } else {
                this.zak = zab2.zaa();
            }
        }

        @RecentlyNonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64(@RecentlyNonNull String str, int i) {
            return new Field(8, false, 8, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(@RecentlyNonNull String str, int i) {
            return new Field(6, false, 6, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@RecentlyNonNull String str, int i, @RecentlyNonNull Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@RecentlyNonNull String str, int i, @RecentlyNonNull Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<Double, Double> forDouble(@RecentlyNonNull String str, int i) {
            return new Field(4, false, 4, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<Float, Float> forFloat(@RecentlyNonNull String str, int i) {
            return new Field(3, false, 3, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<Integer, Integer> forInteger(@RecentlyNonNull String str, int i) {
            return new Field(0, false, 0, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<Long, Long> forLong(@RecentlyNonNull String str, int i) {
            return new Field(2, false, 2, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<String, String> forString(@RecentlyNonNull String str, int i) {
            return new Field(7, false, 7, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(@RecentlyNonNull String str, int i) {
            return new Field(10, false, 10, false, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@RecentlyNonNull String str, int i) {
            return new Field(7, true, 7, true, str, i, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public static Field withConverter(@RecentlyNonNull String str, int i, @RecentlyNonNull FieldConverter<?, ?> fieldConverter, boolean z) {
            return new Field(fieldConverter.zaa(), z, fieldConverter.zab(), false, str, i, (Class<? extends FastJsonResponse>) null, fieldConverter);
        }

        @Nullable
        private final String zae() {
            String str = this.zai;
            if (str == null) {
                return null;
            }
            return str;
        }

        @Nullable
        private final zab zaf() {
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter == null) {
                return null;
            }
            return zab.zaa(fieldConverter);
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        @RecentlyNonNull
        public String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zah)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf)).add("concreteTypeName", zae());
            Class<? extends FastJsonResponse> cls = this.zag;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zah);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zae(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zaf(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        @RecentlyNonNull
        public final Field<I, O> zaa() {
            return new Field(this.zah, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zai, zaf());
        }

        public final boolean zab() {
            return this.zak != null;
        }

        @RecentlyNonNull
        public final FastJsonResponse zac() throws InstantiationException, IllegalAccessException {
            Preconditions.checkNotNull(this.zag);
            Class<? extends FastJsonResponse> cls = this.zag;
            if (cls != SafeParcelResponse.class) {
                return (FastJsonResponse) cls.newInstance();
            }
            Preconditions.checkNotNull(this.zai);
            Preconditions.checkNotNull(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.zaj, this.zai);
        }

        @RecentlyNonNull
        public final Map<String, Field<?, ?>> zad() {
            Preconditions.checkNotNull(this.zai);
            Preconditions.checkNotNull(this.zaj);
            return (Map) Preconditions.checkNotNull(this.zaj.zaa(this.zai));
        }

        @RecentlyNonNull
        public final I zab(@RecentlyNonNull O o) {
            Preconditions.checkNotNull(this.zak);
            return this.zak.zaa(o);
        }

        public final void zaa(zaj zaj2) {
            this.zaj = zaj2;
        }

        @RecentlyNonNull
        public final O zaa(@Nullable I i) {
            Preconditions.checkNotNull(this.zak);
            return Preconditions.checkNotNull(this.zak.zab(i));
        }

        public Field(int i, boolean z, int i2, boolean z2, String str, int i3, @Nullable Class<? extends FastJsonResponse> cls, @Nullable FieldConverter<I, O> fieldConverter) {
            this.zah = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zai = null;
            } else {
                this.zai = cls.getCanonicalName();
            }
            this.zak = fieldConverter;
        }
    }

    @ShowFirstParty
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface FieldConverter<I, O> {
        int zaa();

        @RecentlyNonNull
        I zaa(@RecentlyNonNull O o);

        int zab();

        @RecentlyNullable
        O zab(@RecentlyNonNull I i);
    }

    @RecentlyNonNull
    public static <O, I> I zaa(@RecentlyNonNull Field<I, O> field, @Nullable Object obj) {
        return field.zak != null ? field.zab(obj) : obj;
    }

    private final <I, O> void zab(Field<I, O> field, @Nullable I i) {
        String str = field.zae;
        O zaa = field.zaa(i);
        switch (field.zac) {
            case 0:
                if (zaa != null) {
                    setIntegerInternal(field, str, ((Integer) zaa).intValue());
                    return;
                } else {
                    zaa(str);
                    return;
                }
            case 1:
                zaa((Field<?, ?>) field, str, (BigInteger) zaa);
                return;
            case 2:
                if (zaa != null) {
                    setLongInternal(field, str, ((Long) zaa).longValue());
                    return;
                } else {
                    zaa(str);
                    return;
                }
            case 4:
                if (zaa != null) {
                    zaa((Field<?, ?>) field, str, ((Double) zaa).doubleValue());
                    return;
                } else {
                    zaa(str);
                    return;
                }
            case 5:
                zaa((Field<?, ?>) field, str, (BigDecimal) zaa);
                return;
            case 6:
                if (zaa != null) {
                    setBooleanInternal(field, str, ((Boolean) zaa).booleanValue());
                    return;
                } else {
                    zaa(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zaa);
                return;
            case 8:
            case 9:
                if (zaa != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zaa);
                    return;
                } else {
                    zaa(str);
                    return;
                }
            default:
                throw new IllegalStateException(GeneratedOutlineSupport.outline9(44, "Unsupported type for conversion: ", field.zac));
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @RecentlyNonNull T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @RecentlyNonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @KeepForSdk
    @RecentlyNullable
    public Object getFieldValue(@RecentlyNonNull Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KeepForSdk
    @RecentlyNullable
    public abstract Object getValueObject(@RecentlyNonNull String str);

    @KeepForSdk
    public boolean isFieldSet(@RecentlyNonNull Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @KeepForSdk
    public abstract boolean isPrimitiveFieldSet(@RecentlyNonNull String str);

    @KeepForSdk
    public void setBooleanInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    public void setDecodedBytesInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    public void setIntegerInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    public void setLongInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    public void setStringInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    public void setStringMapInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    public void setStringsInternal(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @RecentlyNonNull
    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String next : fieldMappings.keySet()) {
            Field field = fieldMappings.get(next);
            if (isFieldSet(field)) {
                Object zaa = zaa(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (zaa != null) {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaa));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaa));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaa);
                            break;
                        default:
                            if (!field.zab) {
                                zaa(sb, field, zaa);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) zaa;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaa(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append(JsonUtils.EMPTY_JSON);
        }
        return sb.toString();
    }

    public final <O> void zac(@RecentlyNonNull Field<ArrayList<Long>, O> field, @Nullable ArrayList<Long> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zac(field, field.zae, arrayList);
        }
    }

    public final <O> void zad(@RecentlyNonNull Field<ArrayList<Float>, O> field, @Nullable ArrayList<Float> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public final <O> void zae(@RecentlyNonNull Field<ArrayList<Double>, O> field, @Nullable ArrayList<Double> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zae(field, field.zae, arrayList);
        }
    }

    public final <O> void zaf(@RecentlyNonNull Field<ArrayList<BigDecimal>, O> field, @Nullable ArrayList<BigDecimal> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zaf(field, field.zae, arrayList);
        }
    }

    public final <O> void zag(@RecentlyNonNull Field<ArrayList<Boolean>, O> field, @Nullable ArrayList<Boolean> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zag(field, field.zae, arrayList);
        }
    }

    public final <O> void zah(@RecentlyNonNull Field<ArrayList<String>, O> field, @Nullable ArrayList<String> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Integer, O> field, int i) {
        if (field.zak != null) {
            zab(field, Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.zae, i);
        }
    }

    public void zac(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public void zad(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public void zae(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public void zaf(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public void zag(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final <O> void zaa(@RecentlyNonNull Field<ArrayList<Integer>, O> field, @Nullable ArrayList<Integer> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zaa((Field<?, ?>) field, field.zae, arrayList);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<BigInteger, O> field, @Nullable BigInteger bigInteger) {
        if (field.zak != null) {
            zab(field, bigInteger);
        } else {
            zaa((Field<?, ?>) field, field.zae, bigInteger);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Long, O> field, long j) {
        if (field.zak != null) {
            zab(field, Long.valueOf(j));
        } else {
            setLongInternal(field, field.zae, j);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Float, O> field, float f) {
        if (field.zak != null) {
            zab(field, Float.valueOf(f));
        } else {
            zaa((Field<?, ?>) field, field.zae, f);
        }
    }

    public final <O> void zab(@RecentlyNonNull Field<ArrayList<BigInteger>, O> field, @Nullable ArrayList<BigInteger> arrayList) {
        if (field.zak != null) {
            zab(field, arrayList);
        } else {
            zab(field, field.zae, arrayList);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Double, O> field, double d) {
        if (field.zak != null) {
            zab(field, Double.valueOf(d));
        } else {
            zaa((Field<?, ?>) field, field.zae, d);
        }
    }

    public void zab(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void zaa(@RecentlyNonNull Field<BigDecimal, O> field, @Nullable BigDecimal bigDecimal) {
        if (field.zak != null) {
            zab(field, bigDecimal);
        } else {
            zaa((Field<?, ?>) field, field.zae, bigDecimal);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Boolean, O> field, boolean z) {
        if (field.zak != null) {
            zab(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.zae, z);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<String, O> field, @Nullable String str) {
        if (field.zak != null) {
            zab(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<byte[], O> field, @Nullable byte[] bArr) {
        if (field.zak != null) {
            zab(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final <O> void zaa(@RecentlyNonNull Field<Map<String, String>, O> field, @Nullable Map<String, String> map) {
        if (field.zak != null) {
            zab(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public void zaa(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public void zaa(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public void zaa(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public void zaa(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public void zaa(@RecentlyNonNull Field<?, ?> field, @RecentlyNonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public static <O> void zaa(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58);
            sb.append("Output field (");
            sb.append(str);
            sb.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb.toString());
        }
    }

    public static void zaa(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i == 11) {
            Class<? extends FastJsonResponse> cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i == 7) {
            sb.append("\"");
            sb.append(com.google.android.gms.common.util.JsonUtils.escapeString((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }
}
