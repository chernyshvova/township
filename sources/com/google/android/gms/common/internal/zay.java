package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zay extends RemoteCreator<zam> {
    public static final zay zaa = new zay();

    public zay() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        return zaa.zab(context, i, i2);
    }

    private final View zab(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        try {
            zaw zaw = new zaw(i, i2, (Scope[]) null);
            return (View) ObjectWrapper.unwrap(((zam) getRemoteCreatorInstance(context)).zaa(ObjectWrapper.wrap(context), zaw));
        } catch (Exception e) {
            throw new RemoteCreator.RemoteCreatorException(GeneratedOutlineSupport.outline11(64, "Could not get button with size ", i, " and color ", i2), e);
        }
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zam) {
            return (zam) queryLocalInterface;
        }
        return new zal(iBinder);
    }
}
