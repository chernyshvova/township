package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdma {
    public int zza;
    public zzbhg zzb;
    public zzbma zzc;
    public View zzd;
    public List<?> zze;
    public List<zzbhx> zzf = Collections.emptyList();
    public zzbhx zzg;
    public Bundle zzh;
    public zzcmr zzi;
    public zzcmr zzj;
    @Nullable
    public zzcmr zzk;
    @Nullable
    public IObjectWrapper zzl;
    public View zzm;
    public View zzn;
    public IObjectWrapper zzo;
    public double zzp;
    public zzbmi zzq;
    public zzbmi zzr;
    public String zzs;
    public final SimpleArrayMap<String, zzbls> zzt = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, String> zzu = new SimpleArrayMap<>();
    public float zzv;
    @Nullable
    public String zzw;

    public static zzdma zzaa(zzbvw zzbvw) {
        try {
            return zzaf(zzah(zzbvw.zzn(), zzbvw), zzbvw.zzo(), (View) zzag(zzbvw.zzp()), zzbvw.zze(), zzbvw.zzf(), zzbvw.zzg(), zzbvw.zzs(), zzbvw.zzi(), (View) zzag(zzbvw.zzq()), zzbvw.zzr(), zzbvw.zzl(), zzbvw.zzm(), zzbvw.zzk(), zzbvw.zzh(), zzbvw.zzj(), zzbvw.zzz());
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzdma zzab(zzbvt zzbvt) {
        try {
            zzdlz zzah = zzah(zzbvt.zzs(), (zzbvw) null);
            zzbma zzt2 = zzbvt.zzt();
            String zze2 = zzbvt.zze();
            List<?> zzf2 = zzbvt.zzf();
            String zzg2 = zzbvt.zzg();
            Bundle zzp2 = zzbvt.zzp();
            String zzi2 = zzbvt.zzi();
            IObjectWrapper zzv2 = zzbvt.zzv();
            String zzj2 = zzbvt.zzj();
            zzbmi zzh2 = zzbvt.zzh();
            zzdma zzdma = new zzdma();
            zzdma.zza = 1;
            zzdma.zzb = zzah;
            zzdma.zzc = zzt2;
            zzdma.zzd = (View) zzag(zzbvt.zzr());
            zzdma.zzq("headline", zze2);
            zzdma.zze = zzf2;
            zzdma.zzq("body", zzg2);
            zzdma.zzh = zzp2;
            zzdma.zzq("call_to_action", zzi2);
            zzdma.zzm = (View) zzag(zzbvt.zzu());
            zzdma.zzo = zzv2;
            zzdma.zzq(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, zzj2);
            zzdma.zzr = zzh2;
            return zzdma;
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdma zzac(zzbvs zzbvs) {
        try {
            zzdlz zzah = zzah(zzbvs.zzt(), (zzbvw) null);
            zzbma zzv2 = zzbvs.zzv();
            String zze2 = zzbvs.zze();
            List<?> zzf2 = zzbvs.zzf();
            String zzg2 = zzbvs.zzg();
            Bundle zzr2 = zzbvs.zzr();
            String zzi2 = zzbvs.zzi();
            IObjectWrapper zzx = zzbvs.zzx();
            String zzk2 = zzbvs.zzk();
            String zzl2 = zzbvs.zzl();
            double zzj2 = zzbvs.zzj();
            zzbmi zzh2 = zzbvs.zzh();
            zzdma zzdma = new zzdma();
            zzdma.zza = 2;
            zzdma.zzb = zzah;
            zzdma.zzc = zzv2;
            zzdma.zzd = (View) zzag(zzbvs.zzu());
            zzdma.zzq("headline", zze2);
            zzdma.zze = zzf2;
            zzdma.zzq("body", zzg2);
            zzdma.zzh = zzr2;
            zzdma.zzq("call_to_action", zzi2);
            zzdma.zzm = (View) zzag(zzbvs.zzw());
            zzdma.zzo = zzx;
            zzdma.zzq("store", zzk2);
            zzdma.zzq("price", zzl2);
            zzdma.zzp = zzj2;
            zzdma.zzq = zzh2;
            return zzdma;
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdma zzad(zzbvs zzbvs) {
        try {
            return zzaf(zzah(zzbvs.zzt(), (zzbvw) null), zzbvs.zzv(), (View) zzag(zzbvs.zzu()), zzbvs.zze(), zzbvs.zzf(), zzbvs.zzg(), zzbvs.zzr(), zzbvs.zzi(), (View) zzag(zzbvs.zzw()), zzbvs.zzx(), zzbvs.zzk(), zzbvs.zzl(), zzbvs.zzj(), zzbvs.zzh(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdma zzae(zzbvt zzbvt) {
        try {
            return zzaf(zzah(zzbvt.zzs(), (zzbvw) null), zzbvt.zzt(), (View) zzag(zzbvt.zzr()), zzbvt.zze(), zzbvt.zzf(), zzbvt.zzg(), zzbvt.zzp(), zzbvt.zzi(), (View) zzag(zzbvt.zzu()), zzbvt.zzv(), (String) null, (String) null, -1.0d, zzbvt.zzh(), zzbvt.zzj(), 0.0f);
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    public static zzdma zzaf(zzbhg zzbhg, zzbma zzbma, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbmi zzbmi, String str6, float f) {
        zzdma zzdma = new zzdma();
        zzdma.zza = 6;
        zzdma.zzb = zzbhg;
        zzdma.zzc = zzbma;
        zzdma.zzd = view;
        String str7 = str;
        zzdma.zzq("headline", str);
        zzdma.zze = list;
        String str8 = str2;
        zzdma.zzq("body", str2);
        zzdma.zzh = bundle;
        String str9 = str3;
        zzdma.zzq("call_to_action", str3);
        zzdma.zzm = view2;
        zzdma.zzo = iObjectWrapper;
        String str10 = str4;
        zzdma.zzq("store", str4);
        String str11 = str5;
        zzdma.zzq("price", str5);
        zzdma.zzp = d;
        zzdma.zzq = zzbmi;
        zzdma.zzq(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, str6);
        zzdma.zzs(f);
        return zzdma;
    }

    public static <T> T zzag(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdlz zzah(zzbhg zzbhg, @Nullable zzbvw zzbvw) {
        if (zzbhg == null) {
            return null;
        }
        return new zzdlz(zzbhg, zzbvw);
    }

    public final synchronized List<?> zzA() {
        return this.zze;
    }

    @Nullable
    public final zzbmi zzB() {
        List<?> list = this.zze;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzbmh.zzg((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized List<zzbhx> zzC() {
        return this.zzf;
    }

    @Nullable
    public final synchronized zzbhx zzD() {
        return this.zzg;
    }

    public final synchronized String zzE() {
        return zzu("body");
    }

    public final synchronized Bundle zzF() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized String zzG() {
        return zzu("call_to_action");
    }

    public final synchronized View zzH() {
        return this.zzm;
    }

    public final synchronized View zzI() {
        return this.zzn;
    }

    public final synchronized IObjectWrapper zzJ() {
        return this.zzo;
    }

    public final synchronized String zzK() {
        return zzu("store");
    }

    public final synchronized String zzL() {
        return zzu("price");
    }

    public final synchronized double zzM() {
        return this.zzp;
    }

    public final synchronized zzbmi zzN() {
        return this.zzq;
    }

    public final synchronized String zzO() {
        return zzu(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER);
    }

    public final synchronized zzbmi zzP() {
        return this.zzr;
    }

    public final synchronized String zzQ() {
        return this.zzs;
    }

    public final synchronized zzcmr zzR() {
        return this.zzi;
    }

    public final synchronized zzcmr zzS() {
        return this.zzj;
    }

    @Nullable
    public final synchronized zzcmr zzT() {
        return this.zzk;
    }

    @Nullable
    public final synchronized IObjectWrapper zzU() {
        return this.zzl;
    }

    public final synchronized SimpleArrayMap<String, zzbls> zzV() {
        return this.zzt;
    }

    public final synchronized float zzW() {
        return this.zzv;
    }

    @Nullable
    public final synchronized String zzX() {
        return this.zzw;
    }

    public final synchronized SimpleArrayMap<String, String> zzY() {
        return this.zzu;
    }

    public final synchronized void zzZ() {
        zzcmr zzcmr = this.zzi;
        if (zzcmr != null) {
            zzcmr.destroy();
            this.zzi = null;
        }
        zzcmr zzcmr2 = this.zzj;
        if (zzcmr2 != null) {
            zzcmr2.destroy();
            this.zzj = null;
        }
        zzcmr zzcmr3 = this.zzk;
        if (zzcmr3 != null) {
            zzcmr3.destroy();
            this.zzk = null;
        }
        this.zzl = null;
        this.zzt.clear();
        this.zzu.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzm = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
    }

    public final synchronized void zza(int i) {
        this.zza = i;
    }

    public final synchronized void zzb(zzbhg zzbhg) {
        this.zzb = zzbhg;
    }

    public final synchronized void zzc(zzbma zzbma) {
        this.zzc = zzbma;
    }

    public final synchronized void zzd(List<zzbls> list) {
        this.zze = list;
    }

    public final synchronized void zze(List<zzbhx> list) {
        this.zzf = list;
    }

    public final synchronized void zzf(@Nullable zzbhx zzbhx) {
        this.zzg = zzbhx;
    }

    public final synchronized void zzg(View view) {
        this.zzm = view;
    }

    public final synchronized void zzh(View view) {
        this.zzn = view;
    }

    public final synchronized void zzi(double d) {
        this.zzp = d;
    }

    public final synchronized void zzj(zzbmi zzbmi) {
        this.zzq = zzbmi;
    }

    public final synchronized void zzk(zzbmi zzbmi) {
        this.zzr = zzbmi;
    }

    public final synchronized void zzl(String str) {
        this.zzs = str;
    }

    public final synchronized void zzm(zzcmr zzcmr) {
        this.zzi = zzcmr;
    }

    public final synchronized void zzn(zzcmr zzcmr) {
        this.zzj = zzcmr;
    }

    public final synchronized void zzo(zzcmr zzcmr) {
        this.zzk = zzcmr;
    }

    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        this.zzl = iObjectWrapper;
    }

    public final synchronized void zzq(String str, String str2) {
        if (str2 == null) {
            this.zzu.remove(str);
        } else {
            this.zzu.put(str, str2);
        }
    }

    public final synchronized void zzr(String str, zzbls zzbls) {
        if (zzbls == null) {
            this.zzt.remove(str);
        } else {
            this.zzt.put(str, zzbls);
        }
    }

    public final synchronized void zzs(float f) {
        this.zzv = f;
    }

    public final synchronized void zzt(@Nullable String str) {
        this.zzw = str;
    }

    public final synchronized String zzu(String str) {
        return this.zzu.get(str);
    }

    public final synchronized int zzv() {
        return this.zza;
    }

    public final synchronized zzbhg zzw() {
        return this.zzb;
    }

    public final synchronized zzbma zzx() {
        return this.zzc;
    }

    public final synchronized View zzy() {
        return this.zzd;
    }

    public final synchronized String zzz() {
        return zzu("headline");
    }
}
