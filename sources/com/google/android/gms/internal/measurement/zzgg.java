package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzgg<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzjj {
    public int zza = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzia.zza(iterable);
        if (iterable instanceof zziq) {
            List<?> zzb = ((zziq) iterable).zzb();
            zziq zziq = (zziq) list;
            int size = list.size();
            for (Object next : zzb) {
                if (next == null) {
                    String outline10 = GeneratedOutlineSupport.outline10(37, "Element at index ", zziq.size() - size, " is null.");
                    int size2 = zziq.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zziq.remove(size2);
                        } else {
                            throw new NullPointerException(outline10);
                        }
                    }
                } else if (next instanceof zzgp) {
                    zziq.zza((zzgp) next);
                } else {
                    zziq.add((String) next);
                }
            }
        } else if (iterable instanceof zzjv) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    String outline102 = GeneratedOutlineSupport.outline10(37, "Element at index ", list.size() - size3, " is null.");
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(outline102);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        }
    }

    public final zzgp zzbj() {
        try {
            zzgx zzc = zzgp.zzc(zzbp());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder outline23 = GeneratedOutlineSupport.outline23("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            outline23.append(" threw an IOException (should never happen).");
            throw new RuntimeException(outline23.toString(), e);
        }
    }

    public final byte[] zzbk() {
        try {
            byte[] bArr = new byte[zzbp()];
            zzhi zza2 = zzhi.zza(bArr);
            zza(zza2);
            zza2.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder outline23 = GeneratedOutlineSupport.outline23("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            outline23.append(" threw an IOException (should never happen).");
            throw new RuntimeException(outline23.toString(), e);
        }
    }

    public int zzbl() {
        throw new UnsupportedOperationException();
    }

    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }
}
