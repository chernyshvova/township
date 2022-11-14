package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcpu extends zzerh {
    public final /* synthetic */ zzcra zza;
    public final zzeso zzb;
    public final zzgju<Integer> zzc;
    public final zzgju<zzere> zzd = new zzerg(zzcsa.zza, this.zza.zzg, this.zza.zzm, zzfbt.zza(), this.zzc);
    public final zzgju<String> zze;
    public final zzgju<zzern> zzf;
    public final zzgju<zzert> zzg;
    public final zzgju<zzerx> zzh;
    public final zzgju<zzese> zzi;
    public final zzgju<zzesl> zzj;
    public final zzgju<zzesx> zzk;
    public final zzgju<String> zzl;
    public final zzgju<zzdud> zzm;
    public final zzgju<zzdud> zzn;
    public final zzgju<zzdud> zzo;
    public final zzgju<zzdud> zzp;
    public final zzgju<Map<zzfcr, zzdud>> zzq;
    public final zzgju<Set<zzdhz<zzfcy>>> zzr;
    public final zzgju<Set<zzdhz<zzfcy>>> zzs;
    public final zzgju zzt;
    public final zzgju<zzfcx> zzu;

    public /* synthetic */ zzcpu(zzcra zzcra, zzeso zzeso, zzcpp zzcpp) {
        this.zza = zzcra;
        this.zzb = zzeso;
        this.zzc = new zzesq(zzeso);
        this.zze = new zzesp(zzeso);
        this.zzf = new zzerp(zzcpf.zza, this.zza.zzg, this.zze, zzfbt.zza());
        this.zzg = new zzerv(zzcsa.zza, this.zzc, this.zza.zzg, this.zza.zzX, this.zza.zzm, zzfbt.zza());
        this.zzh = new zzerz(zzcru.zza, zzfbt.zza(), this.zza.zzg);
        this.zzi = new zzesg(zzcrw.zza, zzfbt.zza(), this.zze);
        this.zzj = new zzesn(zzcry.zza, this.zza.zzm, this.zza.zzg);
        this.zzk = new zzesz(zzfbt.zza());
        this.zzl = new zzesr(zzeso);
        this.zzm = zzgjf.zza(zzdtw.zza());
        this.zzn = zzgjf.zza(zzdtu.zza());
        this.zzo = zzgjf.zza(zzdty.zza());
        this.zzp = zzgjf.zza(zzdua.zza());
        zzgjj zzc2 = zzgjk.zzc(4);
        zzc2.zzb(zzfcr.GMS_SIGNALS, this.zzm);
        zzc2.zzb(zzfcr.BUILD_URL, this.zzn);
        zzc2.zzb(zzfcr.HTTP, this.zzo);
        zzc2.zzb(zzfcr.PRE_PROCESS, this.zzp);
        this.zzq = zzc2.zzc();
        this.zzr = zzgjf.zza(new zzdub(this.zzl, this.zza.zzg, zzfbt.zza(), this.zzq));
        zzgjr zza2 = zzgjs.zza(0, 1);
        zza2.zzb(this.zzr);
        zzgjs zzc3 = zza2.zzc();
        this.zzs = zzc3;
        this.zzt = new zzfda(zzc3);
        this.zzu = zzgjf.zza(new zzfcz(zzfbt.zza(), this.zza.zzm, this.zzt));
    }

    private final zzesi zzd() {
        zzbiz zzbiz = new zzbiz();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        List<String> zzd2 = this.zzb.zzd();
        zzgjp.zzb(zzd2);
        return new zzesi(zzbiz, zzfqo, zzd2, (List<String>) null);
    }

    private final zzerk zze() {
        zzcfw zzcfw = new zzcfw();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        String zzb2 = this.zzb.zzb();
        zzgjp.zzb(zzb2);
        return new zzerk(zzcfw, zzfqo, zzb2, this.zzb.zzc(), this.zzb.zzf(), (byte[]) null);
    }

    public final zzeqs<JSONObject> zza() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        zzcfu zzcfu = new zzcfu();
        zzfqo zzfqo2 = zzche.zza;
        zzgjp.zzb(zzfqo2);
        String zza2 = this.zzb.zza();
        zzgjp.zzb(zza2);
        zzepi zzepi = new zzepi(new zzese(zzcfu, zzfqo2, zza2, (byte[]) null), 0, (ScheduledExecutorService) this.zza.zzm.zzb());
        Context zza3 = this.zza.zza.zza();
        zzgjp.zzb(zza3);
        zzepi zzepi2 = new zzepi(new zzesl(new zzbzv(), (ScheduledExecutorService) this.zza.zzm.zzb(), zza3, (byte[]) null), ((Long) zzbex.zzc().zzb(zzbjn.zzct)).longValue(), (ScheduledExecutorService) this.zza.zzm.zzb());
        zzcfw zzcfw = new zzcfw();
        Context zza4 = this.zza.zza.zza();
        zzgjp.zzb(zza4);
        zzfqo zzfqo3 = zzche.zza;
        zzgjp.zzb(zzfqo3);
        zzepi zzepi3 = new zzepi(new zzere(zzcfw, zza4, (ScheduledExecutorService) this.zza.zzm.zzb(), zzfqo3, this.zzb.zzf(), (byte[]) null), 0, (ScheduledExecutorService) this.zza.zzm.zzb());
        zzfqo zzfqo4 = zzche.zza;
        zzgjp.zzb(zzfqo4);
        zzepi zzepi4 = new zzepi(new zzesx(zzfqo4), 0, (ScheduledExecutorService) this.zza.zzm.zzb());
        zzeqp<? extends zzeqo<JSONObject>> zza5 = zzesu.zza();
        Context zza6 = this.zza.zza.zza();
        zzgjp.zzb(zza6);
        String zza7 = this.zzb.zza();
        zzgjp.zzb(zza7);
        zzfqo zzfqo5 = zzche.zza;
        zzgjp.zzb(zzfqo5);
        zzern zzern = new zzern((zzcbm) null, zza6, zza7, zzfqo5);
        zzaym zzaym = new zzaym();
        zzfqo zzfqo6 = zzche.zza;
        zzgjp.zzb(zzfqo6);
        Context zza8 = this.zza.zza.zza();
        zzgjp.zzb(zza8);
        zzcfw zzcfw2 = new zzcfw();
        int zzf2 = this.zzb.zzf();
        Context zza9 = this.zza.zza.zza();
        zzgjp.zzb(zza9);
        zzfqo zzfqo7 = zzche.zza;
        zzgjp.zzb(zzfqo7);
        return new zzeqs<>(zzfqo, zzfmv.zzh(zzepi, zzepi2, zzepi3, zzepi4, zza5, zzern, new zzerx(zzaym, zzfqo6, zza8, (byte[]) null), zzd(), zze(), new zzert(zzcfw2, zzf2, zza9, (zzcgd) this.zza.zzX.zzb(), (ScheduledExecutorService) this.zza.zzm.zzb(), zzfqo7, (byte[]) null), (zzeqp) this.zza.zzav.zzb()));
    }

    public final zzeqs<JSONObject> zzb() {
        zzcfu zzcfu = new zzcfu();
        Object zzb2 = this.zza.zzav.zzb();
        zzerk zze2 = zze();
        zzesi zzd2 = zzd();
        zzgja<zzere> zzc2 = zzgjf.zzc(this.zzd);
        zzgja<zzern> zzc3 = zzgjf.zzc(this.zzf);
        zzgja<zzert> zzc4 = zzgjf.zzc(this.zzg);
        zzgja<zzerx> zzc5 = zzgjf.zzc(this.zzh);
        zzgja<zzese> zzc6 = zzgjf.zzc(this.zzi);
        zzgja<zzesl> zzc7 = zzgjf.zzc(this.zzj);
        zzgja<zzesx> zzc8 = zzgjf.zzc(this.zzk);
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return zzesv.zza(zzcfu, zzb2, zze2, zzd2, zzc2, zzc3, zzc4, zzc5, zzc6, zzc7, zzc8, zzfqo, (ScheduledExecutorService) this.zza.zzm.zzb());
    }

    public final zzfcx zzc() {
        return this.zzu.zzb();
    }
}
