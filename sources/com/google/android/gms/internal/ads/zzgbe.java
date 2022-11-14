package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbm;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbe<T_WRAPPER extends zzgbm<T_ENGINE>, T_ENGINE> {
    public static final zzgbe<zzgbf, Cipher> zza = new zzgbe<>(new zzgbf());
    public static final zzgbe<zzgbj, Mac> zzb = new zzgbe<>(new zzgbj());
    public static final zzgbe<zzgbl, Signature> zzc = new zzgbe<>(new zzgbl());
    public static final zzgbe<zzgbk, MessageDigest> zzd = new zzgbe<>(new zzgbk());
    public static final zzgbe<zzgbg, KeyAgreement> zze = new zzgbe<>(new zzgbg());
    public static final zzgbe<zzgbi, KeyPairGenerator> zzf = new zzgbe<>(new zzgbi());
    public static final zzgbe<zzgbh, KeyFactory> zzg = new zzgbe<>(new zzgbh());
    public static final Logger zzh = Logger.getLogger(zzgbe.class.getName());
    public static final List<Provider> zzi;
    public static final boolean zzj;
    public final T_WRAPPER zzk;

    static {
        if (zzgbw.zza()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzi = arrayList;
            zzj = true;
        } else {
            zzi = new ArrayList();
            zzj = true;
        }
    }

    public zzgbe(T_WRAPPER t_wrapper) {
        this.zzk = t_wrapper;
    }

    public final T_ENGINE zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzi) {
            try {
                return this.zzk.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (zzj) {
            return this.zzk.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
