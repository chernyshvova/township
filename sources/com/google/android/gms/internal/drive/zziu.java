package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzit;
import com.google.android.gms.internal.drive.zziu;

public abstract class zziu<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlr {
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzlr zza(zzlq zzlq) {
        if (zzda().getClass().isInstance(zzlq)) {
            return zza((zzit) zzlq);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzbn */
    public abstract BuilderType clone();
}
