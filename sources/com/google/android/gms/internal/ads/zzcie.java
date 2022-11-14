package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcie extends zzcig implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final Map<Integer, String> zzc = new HashMap();
    public final zzciz zzd;
    public final zzcja zze;
    public final boolean zzf;
    public int zzg = 0;
    public int zzh = 0;
    public MediaPlayer zzi;
    public Uri zzj;
    public int zzk;
    public int zzl;
    public int zzm;
    public int zzn;
    public int zzo;
    public zzcix zzp;
    public final boolean zzq;
    public int zzr;
    public zzcif zzs;
    public boolean zzt = false;
    public Integer zzu = null;

    static {
        zzc.put(-1004, "MEDIA_ERROR_IO");
        zzc.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzc.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzc.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzc.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzc.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzc.put(1, "MEDIA_ERROR_UNKNOWN");
        zzc.put(1, "MEDIA_INFO_UNKNOWN");
        zzc.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzc.put(701, "MEDIA_INFO_BUFFERING_START");
        zzc.put(702, "MEDIA_INFO_BUFFERING_END");
        zzc.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzc.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzc.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzc.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzc.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcie(Context context, zzciz zzciz, boolean z, boolean z2, zzciy zzciy, zzcja zzcja) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzd = zzciz;
        this.zze = zzcja;
        this.zzq = z;
        this.zzf = z2;
        zzcja.zza(this);
    }

    private final void zzC() {
        zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzj != null && surfaceTexture != null) {
            zzE(false);
            try {
                zzs.zzs();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzi = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzi.setOnCompletionListener(this);
                this.zzi.setOnErrorListener(this);
                this.zzi.setOnInfoListener(this);
                this.zzi.setOnPreparedListener(this);
                this.zzi.setOnVideoSizeChangedListener(this);
                this.zzm = 0;
                if (this.zzq) {
                    zzcix zzcix = new zzcix(getContext());
                    this.zzp = zzcix;
                    zzcix.zzb(surfaceTexture, getWidth(), getHeight());
                    this.zzp.start();
                    SurfaceTexture zze2 = this.zzp.zze();
                    if (zze2 != null) {
                        surfaceTexture = zze2;
                    } else {
                        this.zzp.zzd();
                        this.zzp = null;
                    }
                }
                this.zzi.setDataSource(getContext(), this.zzj);
                zzs.zzt();
                this.zzi.setSurface(new Surface(surfaceTexture));
                this.zzi.setAudioStreamType(3);
                this.zzi.setScreenOnWhilePlaying(true);
                this.zzi.prepareAsync();
                zzH(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzcgs.zzj(sb.toString(), e);
                onError(this.zzi, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzD() {
        /*
            r8 = this;
            boolean r0 = r8.zzf
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzF()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzi
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzh
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            r0 = 0
            r8.zzG(r0)
            android.media.MediaPlayer r0 = r8.zzi
            r0.start()
            android.media.MediaPlayer r0 = r8.zzi
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzs.zzj()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzF()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzi
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzi
            r0.pause()
            r8.zzq()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcie.zzD():void");
    }

    private final void zzE(boolean z) {
        zze.zza("AdMediaPlayerView release");
        zzcix zzcix = this.zzp;
        if (zzcix != null) {
            zzcix.zzd();
            this.zzp = null;
        }
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzi.release();
            this.zzi = null;
            zzH(0);
            if (z) {
                this.zzh = 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzF() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzi
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzg
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcie.zzF():boolean");
    }

    private final void zzG(float f) {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzcgs.zzi("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzH(int i) {
        if (i == 3) {
            this.zze.zze();
            this.zzb.zzd();
        } else if (this.zzg == 3) {
            this.zze.zzf();
            this.zzb.zze();
        }
        this.zzg = i;
    }

    public static /* synthetic */ void zzs(zzcie zzcie, MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzcie.zzd != null && mediaPlayer != null && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey("bitrate")) {
                                Integer valueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                zzcie.zzu = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                int integer = format2.getInteger("width");
                                int integer2 = format2.getInteger("height");
                                StringBuilder sb = new StringBuilder(23);
                                sb.append(integer);
                                sb.append("x");
                                sb.append(integer2);
                                hashMap.put("resolution", sb.toString());
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                zzcie.zzd.zze("onMetadataEvent", hashMap);
            }
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzm = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView completion");
        zzH(5);
        this.zzh = 5;
        zzr.zza.post(new zzchx(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzc.get(Integer.valueOf(i));
        String str2 = zzc.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str2);
        zzcgs.zzi(sb.toString());
        zzH(-1);
        this.zzh = -1;
        zzr.zza.post(new zzchy(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzc.get(Integer.valueOf(i));
        String str2 = zzc.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str2);
        zze.zza(sb.toString());
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 > r6) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzk
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzl
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzk
            if (r2 <= 0) goto L_0x007e
            int r2 = r5.zzl
            if (r2 <= 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzcix r2 = r5.zzp
            if (r2 != 0) goto L_0x007e
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0043
            if (r1 != r2) goto L_0x0041
            int r0 = r5.zzk
            int r1 = r0 * r7
            int r2 = r5.zzl
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r1 / r2
        L_0x003a:
            r1 = r7
            goto L_0x007e
        L_0x003c:
            if (r1 <= r3) goto L_0x0063
            int r1 = r3 / r0
            goto L_0x0054
        L_0x0041:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x0043:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0056
            int r0 = r5.zzl
            int r0 = r0 * r6
            int r2 = r5.zzk
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0053
            if (r0 <= r7) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            r1 = r0
        L_0x0054:
            r0 = r6
            goto L_0x007e
        L_0x0056:
            if (r1 != r2) goto L_0x0067
            int r1 = r5.zzk
            int r1 = r1 * r7
            int r2 = r5.zzl
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
        L_0x0063:
            r0 = r6
            goto L_0x003a
        L_0x0065:
            r0 = r1
            goto L_0x003a
        L_0x0067:
            int r2 = r5.zzk
            int r4 = r5.zzl
            if (r1 != r3) goto L_0x0073
            if (r4 <= r7) goto L_0x0073
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x0075
        L_0x0073:
            r1 = r2
            r7 = r4
        L_0x0075:
            if (r0 != r3) goto L_0x0065
            if (r1 <= r6) goto L_0x0065
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0054
        L_0x007e:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzcix r6 = r5.zzp
            if (r6 == 0) goto L_0x0088
            r6.zzc(r0, r1)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcie.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView prepared");
        zzH(2);
        this.zze.zzb();
        zzr.zza.post(new zzchw(this, mediaPlayer));
        this.zzk = mediaPlayer.getVideoWidth();
        this.zzl = mediaPlayer.getVideoHeight();
        int i = this.zzr;
        if (i != 0) {
            zzi(i);
        }
        zzD();
        int i2 = this.zzk;
        int i3 = this.zzl;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzcgs.zzh(sb.toString());
        if (this.zzh == 3) {
            zze();
        }
        zzq();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zze.zza("AdMediaPlayerView surface created");
        zzC();
        zzr.zza.post(new zzchz(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null && this.zzr == 0) {
            this.zzr = mediaPlayer.getCurrentPosition();
        }
        zzcix zzcix = this.zzp;
        if (zzcix != null) {
            zzcix.zzd();
        }
        zzr.zza.post(new zzcib(this));
        zzE(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zze.zza("AdMediaPlayerView surface changed");
        int i3 = this.zzh;
        boolean z = false;
        if (this.zzk == i && this.zzl == i2) {
            z = true;
        }
        if (this.zzi != null && i3 == 3 && z) {
            int i4 = this.zzr;
            if (i4 != 0) {
                zzi(i4);
            }
            zze();
        }
        zzcix zzcix = this.zzp;
        if (zzcix != null) {
            zzcix.zzc(i, i2);
        }
        zzr.zza.post(new zzcia(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzs);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zze.zza(sb.toString());
        this.zzk = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzl = videoHeight;
        if (this.zzk != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zze.zza(sb.toString());
        zzr.zza.post(new zzchv(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final String toString() {
        String name = zzcie.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return GeneratedOutlineSupport.outline19(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
    }

    public final String zza() {
        String str = true != this.zzq ? "" : " spherical";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    public final void zzb(zzcif zzcif) {
        this.zzs = zzcif;
    }

    public final void zzc(String str) {
        Uri parse = Uri.parse(str);
        zzayj zza = zzayj.zza(parse);
        if (zza == null || zza.zza != null) {
            if (zza != null) {
                parse = Uri.parse(zza.zza);
            }
            this.zzj = parse;
            this.zzr = 0;
            zzC();
            requestLayout();
            invalidate();
        }
    }

    public final void zzd() {
        zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzi.release();
            this.zzi = null;
            zzH(0);
            this.zzh = 0;
        }
        this.zze.zzc();
    }

    public final void zze() {
        zze.zza("AdMediaPlayerView play");
        if (zzF()) {
            this.zzi.start();
            zzH(3);
            this.zza.zza();
            zzr.zza.post(new zzcic(this));
        }
        this.zzh = 3;
    }

    public final void zzf() {
        zze.zza("AdMediaPlayerView pause");
        if (zzF() && this.zzi.isPlaying()) {
            this.zzi.pause();
            zzH(4);
            zzr.zza.post(new zzcid(this));
        }
        this.zzh = 4;
    }

    public final int zzg() {
        if (zzF()) {
            return this.zzi.getDuration();
        }
        return -1;
    }

    public final int zzh() {
        if (zzF()) {
            return this.zzi.getCurrentPosition();
        }
        return 0;
    }

    public final void zzi(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zze.zza(sb.toString());
        if (zzF()) {
            this.zzi.seekTo(i);
            this.zzr = 0;
            return;
        }
        this.zzr = i;
    }

    public final void zzj(float f, float f2) {
        zzcix zzcix = this.zzp;
        if (zzcix != null) {
            zzcix.zzf(f, f2);
        }
    }

    public final int zzk() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final int zzl() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final long zzm() {
        if (this.zzu != null) {
            return (zzo() * ((long) this.zzm)) / 100;
        }
        return -1;
    }

    public final long zzn() {
        return 0;
    }

    public final long zzo() {
        if (this.zzu != null) {
            return ((long) zzg()) * ((long) this.zzu.intValue());
        }
        return -1;
    }

    public final int zzp() {
        if (Build.VERSION.SDK_INT < 26 || !zzF()) {
            return -1;
        }
        return this.zzi.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final void zzq() {
        zzG(this.zzb.zzc());
    }

    public final /* synthetic */ void zzr(int i) {
        zzcif zzcif = this.zzs;
        if (zzcif != null) {
            zzcif.onWindowVisibilityChanged(i);
        }
    }
}
