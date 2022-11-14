package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.assetpacks.C2182ak;
import com.google.android.play.core.assetpacks.C2187ar;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.u */
public abstract class C2325u extends C2320k implements C2326v {
    public C2325u() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* renamed from: a */
    public final boolean mo33277a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onStartDownload(%d)", new Object[]{Integer.valueOf(readInt)});
                break;
            case 3:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onCancelDownload(%d)", new Object[]{Integer.valueOf(readInt2)});
                break;
            case 4:
                int readInt3 = parcel.readInt();
                Bundle bundle3 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onGetSession(%d)", new Object[]{Integer.valueOf(readInt3)});
                break;
            case 5:
                mo33157a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                break;
            case 6:
                Bundle bundle4 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                Bundle bundle5 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onNotifyChunkTransferred(%s, %s, %d, session=%d)", new Object[]{bundle4.getString("module_name"), bundle4.getString("slice_id"), Integer.valueOf(bundle4.getInt("chunk_number")), Integer.valueOf(bundle4.getInt("session_id"))});
                break;
            case 7:
                mo33155a((Bundle) C2321l.m3011a(parcel, Bundle.CREATOR));
                break;
            case 8:
                Bundle bundle6 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                Bundle bundle7 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onNotifyModuleCompleted(%s, sessionId=%d)", new Object[]{bundle6.getString("module_name"), Integer.valueOf(bundle6.getInt("session_id"))});
                break;
            case 10:
                Bundle bundle8 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onNotifySessionFailed(%d)", new Object[]{Integer.valueOf(((Bundle) C2321l.m3011a(parcel, Bundle.CREATOR)).getInt("session_id"))});
                break;
            case 11:
                mo33156a((Bundle) C2321l.m3011a(parcel, Bundle.CREATOR), (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR));
                break;
            case 12:
                mo33158b((Bundle) C2321l.m3011a(parcel, Bundle.CREATOR), (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR));
                break;
            case 13:
                Bundle bundle9 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                Bundle bundle10 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onRequestDownloadInfo()", new Object[0]);
                break;
            case 14:
                Bundle bundle11 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                Bundle bundle12 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onRemoveModule()", new Object[0]);
                break;
            case 15:
                Bundle bundle13 = (Bundle) C2321l.m3011a(parcel, Bundle.CREATOR);
                ((C2182ak) this).f2899b.f2910e.mo33285a();
                C2187ar.f2906a.mo33278a(4, "onCancelDownloads()", new Object[0]);
                break;
            default:
                return false;
        }
        return true;
    }
}
