package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.ads.zzgci;
import com.google.android.gms.internal.ads.zzgcj;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgcj<MessageType extends zzgcj<MessageType, BuilderType>, BuilderType extends zzgci<MessageType, BuilderType>> implements zzgfk {
    public int zza = 0;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable<T>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void zzar(java.lang.Iterable<T> r3, java.util.List<? super T> r4) {
        /*
            com.google.android.gms.internal.ads.zzgem.zza(r3)
            boolean r0 = r4 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x0016
            r0 = r4
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r4.size()
            int r2 = r3.size()
            int r2 = r2 + r1
            r0.ensureCapacity(r2)
        L_0x0016:
            int r0 = r4.size()
            java.util.Iterator r3 = r3.iterator()
        L_0x001e:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r3.next()
            if (r1 != 0) goto L_0x0059
            int r3 = r4.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 37
            r1.<init>(r2)
            java.lang.String r2 = "Element at index "
            r1.append(r2)
            int r3 = r3 - r0
            r1.append(r3)
            java.lang.String r3 = " is null."
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            int r1 = r4.size()
        L_0x004b:
            int r1 = r1 + -1
            if (r1 < r0) goto L_0x0053
            r4.remove(r1)
            goto L_0x004b
        L_0x0053:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r3)
            throw r4
        L_0x0059:
            r4.add(r1)
            goto L_0x001e
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcj.zzar(java.lang.Iterable, java.util.List):void");
    }

    public final zzgcz zzan() {
        try {
            int zzaw = zzaw();
            zzgcz zzgcz = zzgcz.zzb;
            byte[] bArr = new byte[zzaw];
            zzgdj zzt = zzgdj.zzt(bArr);
            zzav(zzt);
            zzt.zzC();
            return new zzgcw(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(GeneratedOutlineSupport.outline19(new StringBuilder(name.length() + 72), "Serializing ", name, " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzao() {
        try {
            byte[] bArr = new byte[zzaw()];
            zzgdj zzt = zzgdj.zzt(bArr);
            zzav(zzt);
            zzt.zzC();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(GeneratedOutlineSupport.outline19(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public int zzap() {
        throw null;
    }

    public void zzaq(int i) {
        throw null;
    }
}
