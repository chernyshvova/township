package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdy;
import com.google.android.gms.internal.ads.zzgec;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgdy<MessageType extends zzgec<MessageType, BuilderType>, BuilderType extends zzgdy<MessageType, BuilderType>> extends zzgci<MessageType, BuilderType> {
    public MessageType zza;
    public boolean zzb = false;
    public final MessageType zzc;

    public zzgdy(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzgec) messagetype.zzb(4, (Object) null, (Object) null);
    }

    public static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzgfs.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    public final /* bridge */ /* synthetic */ zzgci zzac(zzgcj zzgcj) {
        zzai((zzgec) zzgcj);
        return this;
    }

    public void zzae() {
        MessageType messagetype = (zzgec) this.zza.zzb(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzaf */
    public final BuilderType zzab() {
        BuilderType buildertype = (zzgdy) this.zzc.zzb(5, (Object) null, (Object) null);
        buildertype.zzai(zzak());
        return buildertype;
    }

    /* renamed from: zzag */
    public MessageType zzak() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzgfs.zza().zzb(messagetype.getClass()).zzj(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzah() {
        MessageType zzag = zzak();
        if (zzag.zzat()) {
            return zzag;
        }
        throw new zzggn(zzag);
    }

    public final BuilderType zzai(MessageType messagetype) {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaj(byte[] bArr, int i, int i2, zzgdo zzgdo) throws zzgeo {
        if (this.zzb) {
            zzae();
            this.zzb = false;
        }
        try {
            zzgfs.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzgcm(zzgdo));
            return this;
        } catch (zzgeo e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzgeo.zzd();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final /* bridge */ /* synthetic */ zzgfk zzbe() {
        return this.zzc;
    }
}
