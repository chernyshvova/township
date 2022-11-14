package com.google.android.gms.internal.ads;

import com.helpshift.p042db.conversation.tables.ConversationTable;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzbl implements zzbm {
    public static final Logger zzb = Logger.getLogger(zzbl.class.getName());
    public final ThreadLocal<ByteBuffer> zza = new zzbk(this);

    public abstract zzbp zza(String str, byte[] bArr, String str2);

    public final zzbp zzb(zzgis zzgis, zzbq zzbq) throws IOException {
        int zza2;
        long j;
        long zzc = zzgis.zzc();
        this.zza.get().rewind().limit(8);
        do {
            zza2 = zzgis.zza(this.zza.get());
            if (zza2 == 8) {
                this.zza.get().rewind();
                long zza3 = zzbo.zza(this.zza.get());
                byte[] bArr = null;
                if (zza3 >= 8 || zza3 <= 1) {
                    byte[] bArr2 = new byte[4];
                    this.zza.get().get(bArr2);
                    try {
                        String str = new String(bArr2, "ISO-8859-1");
                        if (zza3 == 1) {
                            this.zza.get().limit(16);
                            zzgis.zza(this.zza.get());
                            this.zza.get().position(8);
                            j = zzbo.zzd(this.zza.get()) - 16;
                        } else {
                            j = zza3 == 0 ? zzgis.zzb() - zzgis.zzc() : zza3 - 8;
                        }
                        if (ConversationTable.Columns.LOCAL_UUID.equals(str)) {
                            this.zza.get().limit(this.zza.get().limit() + 16);
                            zzgis.zza(this.zza.get());
                            bArr = new byte[16];
                            for (int position = this.zza.get().position() - 16; position < this.zza.get().position(); position++) {
                                bArr[position - (this.zza.get().position() - 16)] = this.zza.get().get(position);
                            }
                            j -= 16;
                        }
                        long j2 = j;
                        zzbp zza4 = zza(str, bArr, zzbq instanceof zzbp ? ((zzbp) zzbq).zzb() : "");
                        zza4.zza(zzbq);
                        this.zza.get().rewind();
                        zza4.zzc(zzgis, this.zza.get(), j2, this);
                        return zza4;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zza3);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
            }
        } while (zza2 >= 0);
        zzgis.zzd(zzc);
        throw new EOFException();
    }
}
