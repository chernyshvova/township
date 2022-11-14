package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.internal.security.CertificateUtil;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.cert.CertificateExpiredException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class CryptoUtils {
    @VisibleForTesting
    public static final ICryptoFactory DEFAULT_CRYPTO_FACTORY = new ICryptoFactory() {
        public ICipher getCipher(String str, String str2) throws Exception {
            final Cipher cipher;
            if (str2 != null) {
                cipher = Cipher.getInstance(str, str2);
            } else {
                cipher = Cipher.getInstance(str);
            }
            return new ICipher(this) {
            };
        }
    };
    @SuppressLint({"StaticFieldLeak"})
    public static CryptoUtils sInstance;
    public final int mApiLevel;
    public final Context mContext;
    public final ICryptoFactory mCryptoFactory;
    public final Map<String, CryptoHandlerEntry> mCryptoHandlers = new LinkedHashMap();
    public final KeyStore mKeyStore;

    @VisibleForTesting
    public static class CryptoHandlerEntry {
        public int mAliasIndex;
        public final CryptoHandler mCryptoHandler;

        public CryptoHandlerEntry(int i, CryptoHandler cryptoHandler) {
            this.mAliasIndex = i;
            this.mCryptoHandler = cryptoHandler;
        }
    }

    public static class DecryptedData {
        public final String mDecryptedData;

        @VisibleForTesting
        public DecryptedData(String str, String str2) {
            this.mDecryptedData = str;
        }
    }

    public interface ICipher {
    }

    public interface ICryptoFactory {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[SYNTHETIC, Splitter:B:18:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CryptoUtils(@androidx.annotation.NonNull android.content.Context r5) {
        /*
            r4 = this;
            com.microsoft.appcenter.utils.crypto.CryptoUtils$ICryptoFactory r0 = DEFAULT_CRYPTO_FACTORY
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "AppCenter"
            r4.<init>()
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            r4.mCryptoHandlers = r3
            android.content.Context r5 = r5.getApplicationContext()
            r4.mContext = r5
            r4.mCryptoFactory = r0
            r4.mApiLevel = r1
            r5 = 0
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ Exception -> 0x0026 }
            r0.load(r5)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x0025:
            r5 = r0
        L_0x0026:
            java.lang.String r0 = "Cannot use secure keystore on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r2, r0)
            r0 = r5
        L_0x002c:
            r4.mKeyStore = r0
            if (r0 == 0) goto L_0x004a
            r5 = 23
            if (r1 < r5) goto L_0x004a
            com.microsoft.appcenter.utils.crypto.CryptoAesAndEtmHandler r5 = new com.microsoft.appcenter.utils.crypto.CryptoAesAndEtmHandler     // Catch:{ Exception -> 0x0045 }
            r5.<init>()     // Catch:{ Exception -> 0x0045 }
            r4.registerHandler(r5)     // Catch:{ Exception -> 0x0045 }
            com.microsoft.appcenter.utils.crypto.CryptoAesHandler r5 = new com.microsoft.appcenter.utils.crypto.CryptoAesHandler     // Catch:{ Exception -> 0x0045 }
            r5.<init>()     // Catch:{ Exception -> 0x0045 }
            r4.registerHandler(r5)     // Catch:{ Exception -> 0x0045 }
            goto L_0x004a
        L_0x0045:
            java.lang.String r5 = "Cannot use modern encryption on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r2, r5)
        L_0x004a:
            if (r0 == 0) goto L_0x005a
            com.microsoft.appcenter.utils.crypto.CryptoRsaHandler r5 = new com.microsoft.appcenter.utils.crypto.CryptoRsaHandler     // Catch:{ Exception -> 0x0055 }
            r5.<init>()     // Catch:{ Exception -> 0x0055 }
            r4.registerHandler(r5)     // Catch:{ Exception -> 0x0055 }
            goto L_0x005a
        L_0x0055:
            java.lang.String r5 = "Cannot use old encryption on this device."
            com.microsoft.appcenter.utils.AppCenterLog.error(r2, r5)
        L_0x005a:
            com.microsoft.appcenter.utils.crypto.CryptoNoOpHandler r5 = new com.microsoft.appcenter.utils.crypto.CryptoNoOpHandler
            r5.<init>()
            java.util.Map<java.lang.String, com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry> r0 = r4.mCryptoHandlers
            com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry r1 = new com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry
            r2 = 0
            r1.<init>(r2, r5)
            java.lang.String r5 = "None"
            r0.put(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.crypto.CryptoUtils.<init>(android.content.Context):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        return getDecryptedData(r2, r1.mAliasIndex ^ 1, r0[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        com.microsoft.appcenter.utils.AppCenterLog.error("AppCenter", "Failed to decrypt data.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        return new com.microsoft.appcenter.utils.crypto.CryptoUtils.DecryptedData(r10, (java.lang.String) null);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0037 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.microsoft.appcenter.utils.crypto.CryptoUtils.DecryptedData decrypt(@androidx.annotation.Nullable java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r10.split(r0)
            int r1 = r0.length
            r2 = 2
            r3 = 0
            if (r1 != r2) goto L_0x0017
            java.util.Map<java.lang.String, com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry> r1 = r9.mCryptoHandlers
            r2 = 0
            r2 = r0[r2]
            java.lang.Object r1 = r1.get(r2)
            com.microsoft.appcenter.utils.crypto.CryptoUtils$CryptoHandlerEntry r1 = (com.microsoft.appcenter.utils.crypto.CryptoUtils.CryptoHandlerEntry) r1
            goto L_0x0018
        L_0x0017:
            r1 = r3
        L_0x0018:
            if (r1 != 0) goto L_0x001c
            r2 = r3
            goto L_0x001e
        L_0x001c:
            com.microsoft.appcenter.utils.crypto.CryptoHandler r2 = r1.mCryptoHandler
        L_0x001e:
            java.lang.String r4 = "Failed to decrypt data."
            java.lang.String r5 = "AppCenter"
            if (r2 != 0) goto L_0x002d
            com.microsoft.appcenter.utils.AppCenterLog.error(r5, r4)
            com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData r0 = new com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData
            r0.<init>(r10, r3)
            return r0
        L_0x002d:
            r6 = 1
            int r7 = r1.mAliasIndex     // Catch:{ Exception -> 0x0037 }
            r8 = r0[r6]     // Catch:{ Exception -> 0x0037 }
            com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData r10 = r9.getDecryptedData(r2, r7, r8)     // Catch:{ Exception -> 0x0037 }
            return r10
        L_0x0037:
            int r1 = r1.mAliasIndex     // Catch:{ Exception -> 0x0041 }
            r1 = r1 ^ r6
            r0 = r0[r6]     // Catch:{ Exception -> 0x0041 }
            com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData r10 = r9.getDecryptedData(r2, r1, r0)     // Catch:{ Exception -> 0x0041 }
            return r10
        L_0x0041:
            com.microsoft.appcenter.utils.AppCenterLog.error(r5, r4)
            com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData r0 = new com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData
            r0.<init>(r10, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.crypto.CryptoUtils.decrypt(java.lang.String):com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData");
    }

    @Nullable
    public String encrypt(@Nullable String str) {
        CryptoHandlerEntry next;
        CryptoHandler cryptoHandler;
        KeyStore.Entry entry = null;
        if (str == null) {
            return null;
        }
        try {
            next = this.mCryptoHandlers.values().iterator().next();
            cryptoHandler = next.mCryptoHandler;
            CryptoHandler cryptoHandler2 = next.mCryptoHandler;
            int i = next.mAliasIndex;
            if (this.mKeyStore != null) {
                entry = this.mKeyStore.getEntry(getAlias(cryptoHandler2, i), (KeyStore.ProtectionParameter) null);
            }
            String encodeToString = Base64.encodeToString(cryptoHandler.encrypt(this.mCryptoFactory, this.mApiLevel, entry, str.getBytes("UTF-8")), 0);
            return cryptoHandler.getAlgorithm() + CertificateUtil.DELIMITER + encodeToString;
        } catch (InvalidKeyException e) {
            if (!(e.getCause() instanceof CertificateExpiredException)) {
                if (!"android.security.keystore.KeyExpiredException".equals(e.getClass().getName())) {
                    throw e;
                }
            }
            AppCenterLog.debug("AppCenter", "Alias expired: " + next.mAliasIndex);
            int i2 = next.mAliasIndex ^ 1;
            next.mAliasIndex = i2;
            String alias = getAlias(cryptoHandler, i2);
            if (this.mKeyStore.containsAlias(alias)) {
                AppCenterLog.debug("AppCenter", "Deleting alias: " + alias);
                this.mKeyStore.deleteEntry(alias);
            }
            AppCenterLog.debug("AppCenter", "Creating alias: " + alias);
            cryptoHandler.generateKey(this.mCryptoFactory, alias, this.mContext);
            return encrypt(str);
        } catch (Exception unused) {
            AppCenterLog.error("AppCenter", "Failed to encrypt data.");
            return str;
        }
    }

    @NonNull
    public final String getAlias(@NonNull CryptoHandler cryptoHandler, int i) {
        StringBuilder outline25 = GeneratedOutlineSupport.outline25("appcenter.", i, CodelessMatcher.CURRENT_CLASS_NAME);
        outline25.append(cryptoHandler.getAlgorithm());
        return outline25.toString();
    }

    @NonNull
    public final DecryptedData getDecryptedData(CryptoHandler cryptoHandler, int i, String str) throws Exception {
        KeyStore.Entry entry;
        String str2 = null;
        if (this.mKeyStore == null) {
            entry = null;
        } else {
            entry = this.mKeyStore.getEntry(getAlias(cryptoHandler, i), (KeyStore.ProtectionParameter) null);
        }
        String str3 = new String(cryptoHandler.decrypt(this.mCryptoFactory, this.mApiLevel, entry, Base64.decode(str, 0)), "UTF-8");
        if (cryptoHandler != this.mCryptoHandlers.values().iterator().next().mCryptoHandler) {
            str2 = encrypt(str3);
        }
        return new DecryptedData(str3, str2);
    }

    public final void registerHandler(@NonNull CryptoHandler cryptoHandler) throws Exception {
        int i = 0;
        String alias = getAlias(cryptoHandler, 0);
        String alias2 = getAlias(cryptoHandler, 1);
        Date creationDate = this.mKeyStore.getCreationDate(alias);
        Date creationDate2 = this.mKeyStore.getCreationDate(alias2);
        if (creationDate2 != null && creationDate2.after(creationDate)) {
            alias = alias2;
            i = 1;
        }
        if (this.mCryptoHandlers.isEmpty() && !this.mKeyStore.containsAlias(alias)) {
            AppCenterLog.debug("AppCenter", "Creating alias: " + alias);
            cryptoHandler.generateKey(this.mCryptoFactory, alias, this.mContext);
        }
        AppCenterLog.debug("AppCenter", "Using " + alias);
        this.mCryptoHandlers.put(cryptoHandler.getAlgorithm(), new CryptoHandlerEntry(i, cryptoHandler));
    }
}
