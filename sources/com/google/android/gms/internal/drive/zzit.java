package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.drive.zzit;
import com.google.android.gms.internal.drive.zziu;
import java.io.IOException;

public abstract class zzit<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlq {
    public static boolean zznf = false;
    public int zzne = 0;

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzcx()];
            zzjr zzb = zzjr.zzb(bArr);
            zzb(zzb);
            zzb.zzcb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder outline23 = GeneratedOutlineSupport.outline23("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            outline23.append(" threw an IOException (should never happen).");
            throw new RuntimeException(outline23.toString(), e);
        }
    }

    public final zzjc zzbl() {
        try {
            zzjk zzu = zzjc.zzu(zzcx());
            zzb(zzu.zzby());
            return zzu.zzbx();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder outline23 = GeneratedOutlineSupport.outline23("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            outline23.append(" threw an IOException (should never happen).");
            throw new RuntimeException(outline23.toString(), e);
        }
    }

    public int zzbm() {
        throw new UnsupportedOperationException();
    }

    public void zzo(int i) {
        throw new UnsupportedOperationException();
    }
}
