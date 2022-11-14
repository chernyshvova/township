package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgci;
import com.google.android.gms.internal.ads.zzgcj;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgci<MessageType extends zzgcj<MessageType, BuilderType>, BuilderType extends zzgci<MessageType, BuilderType>> implements zzgfj {
    /* renamed from: zzab */
    public abstract BuilderType clone();

    public abstract BuilderType zzac(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzgfj zzad(zzgfk zzgfk) {
        if (zzbe().getClass().isInstance(zzgfk)) {
            return zzac((zzgcj) zzgfk);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
