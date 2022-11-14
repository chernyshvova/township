package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgi;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzgi<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzji {
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhb zzhb, zzhl zzhl) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzij {
        try {
            zzhb zza = zzhb.zza(bArr, 0, i2, false);
            zza(zza, zzhl.zza());
            zza.zza(0);
            return this;
        } catch (zzij e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* renamed from: zzt */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzhl zzhl) throws zzij {
        try {
            zzhb zza = zzhb.zza(bArr, 0, i2, false);
            zza(zza, zzhl);
            zza.zza(0);
            return this;
        } catch (zzij e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder outline23 = GeneratedOutlineSupport.outline23(GeneratedOutlineSupport.outline3(str, name.length() + 60), "Reading ", name, " from a ", str);
        outline23.append(" threw an IOException (should never happen).");
        return outline23.toString();
    }

    public final /* synthetic */ zzji zza(zzjj zzjj) {
        if (zzbv().getClass().isInstance(zzjj)) {
            return zza((zzgg) zzjj);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzji zza(byte[] bArr, zzhl zzhl) throws zzij {
        return zza(bArr, 0, bArr.length, zzhl);
    }

    public final /* synthetic */ zzji zza(byte[] bArr) throws zzij {
        return zza(bArr, 0, bArr.length);
    }
}
