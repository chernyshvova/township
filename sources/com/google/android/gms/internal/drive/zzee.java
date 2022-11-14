package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzi;
import java.util.ArrayList;
import java.util.List;

public final class zzee extends zzet {
    public static final GmsLogger zzbz = new GmsLogger("EventCallback", "");
    public final int zzda = 1;
    public final zzi zzgt;
    public final zzeg zzgu;
    public final List<Integer> zzgv = new ArrayList();

    public zzee(Looper looper, Context context, int i, zzi zzi) {
        this.zzgt = zzi;
        this.zzgu = new zzeg(looper, context);
    }

    public final void zzc(zzfp zzfp) throws RemoteException {
        DriveEvent zzat = zzfp.zzat();
        Preconditions.checkState(this.zzda == zzat.getType());
        Preconditions.checkState(this.zzgv.contains(Integer.valueOf(zzat.getType())));
        zzeg zzeg = this.zzgu;
        zzeg.sendMessage(zzeg.obtainMessage(1, new Pair(this.zzgt, zzat)));
    }

    public final void zzf(int i) {
        this.zzgv.add(1);
    }

    public final boolean zzg(int i) {
        return this.zzgv.contains(1);
    }
}
