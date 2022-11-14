package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsn {
    public static final Logger zza = Logger.getLogger(zzfsn.class.getName());
    public static final ConcurrentMap<String, zzfsm> zzb = new ConcurrentHashMap();
    public static final ConcurrentMap<String, zzfsl> zzc = new ConcurrentHashMap();
    public static final ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();
    public static final ConcurrentMap<String, zzfri<?>> zze = new ConcurrentHashMap();
    public static final ConcurrentMap<Class<?>, zzfsf<?, ?>> zzf = new ConcurrentHashMap();
    public static final ConcurrentMap<String, zzfrq> zzg = new ConcurrentHashMap();

    @Deprecated
    public static zzfri<?> zza(String str) throws GeneralSecurityException {
        if (str != null) {
            zzfri<?> zzfri = (zzfri) zze.get(str.toLowerCase(Locale.US));
            if (zzfri != null) {
                return zzfri;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static synchronized <P> void zzb(zzfrn<P> zzfrn, boolean z) throws GeneralSecurityException {
        synchronized (zzfsn.class) {
            if (zzfrn != null) {
                String zzd2 = zzfrn.zzd();
                zzp(zzd2, zzfrn.getClass(), Collections.emptyMap(), z);
                zzb.putIfAbsent(zzd2, new zzfsi(zzfrn));
                zzd.put(zzd2, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzgfk> void zzc(zzfrv<KeyProtoT> zzfrv, boolean z) throws GeneralSecurityException {
        synchronized (zzfsn.class) {
            String zzb2 = zzfrv.zzb();
            zzp(zzb2, zzfrv.getClass(), zzfrv.zzi().zze(), true);
            if (!zzb.containsKey(zzb2)) {
                zzb.put(zzb2, new zzfsj(zzfrv));
                zzc.put(zzb2, new zzfsl(zzfrv));
                zzq(zzb2, zzfrv.zzi().zze());
            }
            zzd.put(zzb2, Boolean.TRUE);
        }
    }

    public static synchronized <KeyProtoT extends zzgfk, PublicKeyProtoT extends zzgfk> void zzd(zzfsh<KeyProtoT, PublicKeyProtoT> zzfsh, zzfrv<PublicKeyProtoT> zzfrv, boolean z) throws GeneralSecurityException {
        Class<?> zze2;
        synchronized (zzfsn.class) {
            zzp("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzfsh.getClass(), zzfsh.zzi().zze(), true);
            zzp("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzfrv.getClass(), Collections.emptyMap(), false);
            if (zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (zze2 = ((zzfsm) zzb.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze()) != null) {
                if (!zze2.getName().equals(zzfrv.getClass().getName())) {
                    zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey with inconsistent public key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzfsh.getClass().getName(), zze2.getName(), zzfrv.getClass().getName()}));
                }
            }
            if (!zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || ((zzfsm) zzb.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze() == null) {
                zzb.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzfsk(zzfsh, zzfrv));
                zzc.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzfsl(zzfsh));
                zzq("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzfsh.zzi().zze());
            }
            zzd.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", Boolean.TRUE);
            if (!zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                zzb.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", new zzfsj(zzfrv));
            }
            zzd.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", Boolean.FALSE);
        }
    }

    public static synchronized <B, P> void zze(zzfsf<B, P> zzfsf) throws GeneralSecurityException {
        synchronized (zzfsn.class) {
            if (zzfsf != null) {
                Class<P> zzb2 = zzfsf.zzb();
                if (zzf.containsKey(zzb2)) {
                    zzfsf zzfsf2 = (zzfsf) zzf.get(zzb2);
                    if (!zzfsf.getClass().getName().equals(zzfsf2.getClass().getName())) {
                        Logger logger = zza;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzb2);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 62);
                        sb.append("Attempted overwrite of a registered PrimitiveWrapper for type ");
                        sb.append(valueOf);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzb2.getName(), zzfsf2.getClass().getName(), zzfsf.getClass().getName()}));
                    }
                }
                zzf.put(zzb2, zzfsf);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static zzfrn<?> zzf(String str) throws GeneralSecurityException {
        return zzo(str).zzb();
    }

    public static synchronized zzfys zzg(zzfyx zzfyx) throws GeneralSecurityException {
        zzfys zzf2;
        synchronized (zzfsn.class) {
            zzfrn<?> zzf3 = zzf(zzfyx.zza());
            if (((Boolean) zzd.get(zzfyx.zza())).booleanValue()) {
                zzf2 = zzf3.zzf(zzfyx.zzc());
            } else {
                String valueOf = String.valueOf(zzfyx.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzf2;
    }

    public static synchronized zzgfk zzh(zzfyx zzfyx) throws GeneralSecurityException {
        zzgfk zzc2;
        synchronized (zzfsn.class) {
            zzfrn<?> zzf2 = zzf(zzfyx.zza());
            if (((Boolean) zzd.get(zzfyx.zza())).booleanValue()) {
                zzc2 = zzf2.zzc(zzfyx.zzc());
            } else {
                String valueOf = String.valueOf(zzfyx.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzc2;
    }

    public static <P> P zzi(String str, zzgfk zzgfk, Class<P> cls) throws GeneralSecurityException {
        return zzr(str, cls).zzb(zzgfk);
    }

    public static <P> P zzj(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zzs(str, zzgcz.zzt(bArr), cls);
    }

    public static <P> P zzk(zzfys zzfys, Class<P> cls) throws GeneralSecurityException {
        return zzs(zzfys.zza(), zzfys.zzc(), cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzfse, com.google.android.gms.internal.ads.zzfse<B>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <B, P> P zzl(com.google.android.gms.internal.ads.zzfse<B> r4, java.lang.Class<P> r5) throws java.security.GeneralSecurityException {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.google.android.gms.internal.ads.zzfsf<?, ?>> r0 = zzf
            java.lang.Object r5 = r0.get(r5)
            com.google.android.gms.internal.ads.zzfsf r5 = (com.google.android.gms.internal.ads.zzfsf) r5
            if (r5 != 0) goto L_0x002a
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            java.lang.Class r4 = r4.zze()
            java.lang.String r4 = r4.getName()
            java.lang.String r0 = "No wrapper found for "
            int r1 = r4.length()
            if (r1 == 0) goto L_0x0021
            java.lang.String r4 = r0.concat(r4)
            goto L_0x0026
        L_0x0021:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x0026:
            r5.<init>(r4)
            throw r5
        L_0x002a:
            java.lang.Class r0 = r5.zzc()
            java.lang.Class r1 = r4.zze()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            java.lang.Object r4 = r5.zza(r4)
            return r4
        L_0x003d:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Class r5 = r5.zzc()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Class r4 = r4.zze()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r5.length()
            int r2 = r4.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = r1 + 44
            int r1 = r1 + r2
            r3.<init>(r1)
            java.lang.String r1 = "Wrong input primitive class, expected "
            java.lang.String r2 = ", got "
            java.lang.String r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline20(r3, r1, r5, r2, r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsn.zzl(com.google.android.gms.internal.ads.zzfse, java.lang.Class):java.lang.Object");
    }

    public static synchronized Map<String, zzfrq> zzm() {
        Map<String, zzfrq> unmodifiableMap;
        synchronized (zzfsn.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static Class<?> zzn(Class<?> cls) {
        zzfsf zzfsf = (zzfsf) zzf.get(cls);
        if (zzfsf == null) {
            return null;
        }
        return zzfsf.zzc();
    }

    public static synchronized zzfsm zzo(String str) throws GeneralSecurityException {
        zzfsm zzfsm;
        String str2;
        synchronized (zzfsn.class) {
            if (!zzb.containsKey(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "No key manager found for key type ".concat(valueOf);
                } else {
                    str2 = new String("No key manager found for key type ");
                }
                throw new GeneralSecurityException(str2);
            }
            zzfsm = (zzfsm) zzb.get(str);
        }
        return zzfsm;
    }

    public static synchronized <KeyProtoT extends zzgfk, KeyFormatProtoT extends zzgfk> void zzp(String str, Class cls, Map<String, zzfrs<KeyFormatProtoT>> map, boolean z) throws GeneralSecurityException {
        String str2;
        String str3;
        String str4;
        synchronized (zzfsn.class) {
            zzfsm zzfsm = (zzfsm) zzb.get(str);
            if (zzfsm != null && !zzfsm.zzc().equals(cls)) {
                Logger logger = zza;
                Level level = Level.WARNING;
                if (str.length() != 0) {
                    str4 = "Attempted overwrite of a registered key manager for key type ".concat(str);
                } else {
                    str4 = new String("Attempted overwrite of a registered key manager for key type ");
                }
                logger.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", str4);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, zzfsm.zzc().getName(), cls.getName()}));
            } else if (z) {
                if (zzd.containsKey(str) && !((Boolean) zzd.get(str)).booleanValue()) {
                    if (str.length() != 0) {
                        str3 = "New keys are already disallowed for key type ".concat(str);
                    } else {
                        str3 = new String("New keys are already disallowed for key type ");
                    }
                    throw new GeneralSecurityException(str3);
                } else if (zzb.containsKey(str)) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!zzg.containsKey(next.getKey())) {
                            String str5 = (String) next.getKey();
                            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 79 + str.length());
                            sb.append("Attempted to register a new key template ");
                            sb.append(str5);
                            sb.append(" from an existing key manager of type ");
                            sb.append(str);
                            throw new GeneralSecurityException(sb.toString());
                        }
                    }
                } else {
                    for (Map.Entry next2 : map.entrySet()) {
                        if (zzg.containsKey(next2.getKey())) {
                            String valueOf = String.valueOf((String) next2.getKey());
                            if (valueOf.length() != 0) {
                                str2 = "Attempted overwrite of a registered key template ".concat(valueOf);
                            } else {
                                str2 = new String("Attempted overwrite of a registered key template ");
                            }
                            throw new GeneralSecurityException(str2);
                        }
                    }
                }
            }
        }
    }

    public static <KeyFormatProtoT extends zzgfk> void zzq(String str, Map<String, zzfrs<KeyFormatProtoT>> map) {
        for (Map.Entry next : map.entrySet()) {
            zzg.put((String) next.getKey(), zzfrq.zzc(str, ((zzfrs) next.getValue()).zza.zzao(), ((zzfrs) next.getValue()).zzb));
        }
    }

    public static <P> zzfrn<P> zzr(String str, Class<P> cls) throws GeneralSecurityException {
        zzfsm zzo = zzo(str);
        if (zzo.zzd().contains(cls)) {
            return zzo.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzo.zzc());
        Set<Class<?>> zzd2 = zzo.zzd();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzd2) {
            if (!z) {
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(GeneratedOutlineSupport.outline1(name.length(), 77, valueOf.length(), String.valueOf(sb2).length()));
        GeneratedOutlineSupport.outline34(sb3, "Primitive type ", name, " not supported by key manager of type ", valueOf);
        throw new GeneralSecurityException(GeneratedOutlineSupport.outline18(sb3, ", supported primitives: ", sb2));
    }

    public static <P> P zzs(String str, zzgcz zzgcz, Class<P> cls) throws GeneralSecurityException {
        return zzr(str, cls).zza(zzgcz);
    }
}
