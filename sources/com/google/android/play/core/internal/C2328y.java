package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.y */
public final class C2328y extends C2319j implements C2329z {
    public C2328y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: a */
    public final void mo33306a(Bundle bundle) throws RemoteException {
        Parcel a = mo33294a();
        C2321l.m3012a(a, (Parcelable) bundle);
        mo33295a(3, a);
    }

    /* renamed from: a */
    public final void mo33307a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo33294a();
        C2321l.m3012a(a, (Parcelable) bundle);
        C2321l.m3012a(a, (Parcelable) bundle2);
        mo33295a(2, a);
    }

    /* renamed from: b */
    public final void mo33308b(Bundle bundle) throws RemoteException {
        Parcel a = mo33294a();
        C2321l.m3012a(a, (Parcelable) bundle);
        mo33295a(4, a);
    }
}
