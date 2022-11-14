package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaal extends zaap {
    public final ArrayList<Api.Client> zaa;
    public final /* synthetic */ zaaf zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaal(zaaf zaaf, ArrayList<Api.Client> arrayList) {
        super(zaaf, (zaae) null);
        this.zab = zaaf;
        this.zaa = arrayList;
    }

    @WorkerThread
    public final void zaa() {
        this.zab.zaa.zad.zac = this.zab.zai();
        ArrayList<Api.Client> arrayList = this.zaa;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            client.getRemoteService(this.zab.zao, this.zab.zaa.zad.zac);
        }
    }
}
