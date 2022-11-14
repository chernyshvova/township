package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahp extends zzahm {
    public final ContentResolver zza;
    @Nullable
    public Uri zzb;
    @Nullable
    public AssetFileDescriptor zzc;
    @Nullable
    public FileInputStream zzd;
    public long zze;
    public boolean zzf;

    public zzahp(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaho {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzaho(e);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzalh.zza;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzi(read);
        return read;
    }

    public final long zzc(zzahx zzahx) throws zzaho {
        long j;
        try {
            Uri uri = zzahx.zza;
            this.zzb = uri;
            zzg(zzahx);
            AssetFileDescriptor openAssetFileDescriptor = this.zza.openAssetFileDescriptor(uri, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            this.zzc = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.zzd = fileInputStream;
                if (length != -1) {
                    if (zzahx.zzf > length) {
                        throw new zzahu(0);
                    }
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(zzahx.zzf + startOffset) - startOffset;
                if (skip == zzahx.zzf) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.zze = -1;
                            j = -1;
                        } else {
                            j = size - channel.position();
                            this.zze = j;
                            if (j < 0) {
                                throw new zzahu(0);
                            }
                        }
                    } else {
                        long j2 = length - skip;
                        this.zze = j2;
                        if (j2 >= 0) {
                            j = j2;
                        } else {
                            throw new zzahu(0);
                        }
                    }
                    long j3 = zzahx.zzg;
                    if (j3 != -1) {
                        if (j != -1) {
                            j3 = Math.min(j, j3);
                        }
                        this.zze = j3;
                    }
                    this.zzf = true;
                    zzh(zzahx);
                    long j4 = zzahx.zzg;
                    return j4 != -1 ? j4 : this.zze;
                }
                throw new zzahu(0);
            }
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf.length() + 36);
            sb.append("Could not open file descriptor for: ");
            sb.append(valueOf);
            throw new FileNotFoundException(sb.toString());
        } catch (IOException e) {
            throw new zzaho(e);
        }
    }

    @Nullable
    public final Uri zzd() {
        return this.zzb;
    }

    public final void zzf() throws zzaho {
        this.zzb = null;
        try {
            FileInputStream fileInputStream = this.zzd;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzc;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzj();
                }
            } catch (IOException e) {
                throw new zzaho(e);
            } catch (Throwable th) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzj();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new zzaho(e2);
        } catch (Throwable th2) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzj();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzaho(e3);
            } catch (Throwable th3) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzj();
                }
                throw th3;
            }
        }
    }
}
