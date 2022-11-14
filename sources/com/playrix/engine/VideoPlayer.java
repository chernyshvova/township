package com.playrix.engine;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.share.internal.VideoUploader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class VideoPlayer {
    public static final long FRAME_TIMEOUT = 4000;
    public static final long PREPARE_TIMEOUT = 5000;
    public static final long SEEK_TIMEOUT = 5000;
    public static final int STATE_FAILED = 5;
    public static final int STATE_FINISHED = 3;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PREPARING = 0;
    public static final int STATE_SEEKING = 1;
    public DataStreamInfo dataStreamInfo = null;
    public Timer frameTimer = null;
    public final long instanceId;
    public boolean isFrameCreated = false;
    public MediaPlayer mediaPlayer = null;
    public boolean needUpdateTexture = false;
    public boolean playingForFrame = false;
    public Thread prepareThread = null;
    public float soundVolume = 1.0f;
    public int state = 3;
    public StreamSource streamSource = null;
    public Surface surface = null;
    public SurfaceTexture surfaceTexture = null;
    public final float[] textureMatrix = new float[16];
    public Timer timeoutTimer = null;
    public int videoDuration = 0;
    public int videoHeight = 0;
    public int videoWidth = 0;

    public static class DataStreamInfo {
        public long dataSize = 0;
        public FileInputStream inputStream = null;
        public long instancePtr = 0;

        public DataStreamInfo(long j, long j2) {
            this.instancePtr = j;
            this.dataSize = j2;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A[SYNTHETIC, Splitter:B:34:0x006f] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.FileInputStream createTempFile() throws java.io.IOException {
            /*
                r14 = this;
                long r0 = r14.instancePtr
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x007a
                java.io.FileInputStream r0 = r14.inputStream
                if (r0 == 0) goto L_0x0012
                r0.reset()
                java.io.FileInputStream r0 = r14.inputStream
                return r0
            L_0x0012:
                r0 = 0
                java.lang.String r1 = "video"
                java.lang.String r4 = "tmp"
                java.io.File r1 = java.io.File.createTempFile(r1, r4)     // Catch:{ all -> 0x0069 }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0065 }
                r4.<init>(r1)     // Catch:{ all -> 0x0065 }
                r0 = 4096(0x1000, float:5.74E-42)
                byte[] r12 = new byte[r0]     // Catch:{ all -> 0x0063 }
            L_0x0024:
                long r5 = r14.dataSize     // Catch:{ all -> 0x0063 }
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x004e
                long r5 = (long) r0     // Catch:{ all -> 0x0063 }
                long r7 = r14.dataSize     // Catch:{ all -> 0x0063 }
                long r7 = r7 - r2
                long r5 = java.lang.Math.min(r5, r7)     // Catch:{ all -> 0x0063 }
                int r13 = (int) r5     // Catch:{ all -> 0x0063 }
                long r5 = r14.instancePtr     // Catch:{ all -> 0x0063 }
                r10 = 0
                r7 = r2
                r9 = r12
                r11 = r13
                int r5 = com.playrix.engine.VideoPlayer.onStreamRead(r5, r7, r9, r10, r11)     // Catch:{ all -> 0x0063 }
                if (r5 != r13) goto L_0x0046
                r5 = 0
                r4.write(r12, r5, r13)     // Catch:{ all -> 0x0063 }
                long r5 = (long) r13     // Catch:{ all -> 0x0063 }
                long r2 = r2 + r5
                goto L_0x0024
            L_0x0046:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0063 }
                java.lang.String r2 = "Error read from stream"
                r0.<init>(r2)     // Catch:{ all -> 0x0063 }
                throw r0     // Catch:{ all -> 0x0063 }
            L_0x004e:
                r4.flush()     // Catch:{ all -> 0x0063 }
                java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x0063 }
                r0.<init>(r1)     // Catch:{ all -> 0x0063 }
                r14.inputStream = r0     // Catch:{ all -> 0x0063 }
                r4.close()     // Catch:{ IOException -> 0x005c }
                goto L_0x005d
            L_0x005c:
            L_0x005d:
                if (r1 == 0) goto L_0x0062
                r1.delete()
            L_0x0062:
                return r0
            L_0x0063:
                r0 = move-exception
                goto L_0x006d
            L_0x0065:
                r2 = move-exception
                r4 = r0
                r0 = r2
                goto L_0x006d
            L_0x0069:
                r1 = move-exception
                r4 = r0
                r0 = r1
                r1 = r4
            L_0x006d:
                if (r4 == 0) goto L_0x0074
                r4.close()     // Catch:{ IOException -> 0x0073 }
                goto L_0x0074
            L_0x0073:
            L_0x0074:
                if (r1 == 0) goto L_0x0079
                r1.delete()
            L_0x0079:
                throw r0
            L_0x007a:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "null file"
                r0.<init>(r1)
                goto L_0x0083
            L_0x0082:
                throw r0
            L_0x0083:
                goto L_0x0082
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.VideoPlayer.DataStreamInfo.createTempFile():java.io.FileInputStream");
        }

        public void close() {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                this.inputStream = null;
            }
            long j = this.instancePtr;
            if (j != 0) {
                VideoPlayer.onStreamClose(j);
                this.instancePtr = 0;
                this.dataSize = 0;
            }
        }
    }

    @TargetApi(23)
    public static class StreamSource extends MediaDataSource {
        public long dataSize;
        public long instancePtr;

        public StreamSource(long j, long j2) {
            this.instancePtr = j;
            this.dataSize = j2;
        }

        public synchronized void close() {
            if (this.instancePtr != 0) {
                VideoPlayer.onStreamClose(this.instancePtr);
                this.instancePtr = 0;
                this.dataSize = 0;
            }
        }

        public synchronized long getSize() {
            return this.dataSize;
        }

        public synchronized int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (!(this.instancePtr == 0 || bArr == null)) {
                if (i + i2 <= bArr.length) {
                    return VideoPlayer.onStreamRead(this.instancePtr, j, bArr, i, i2);
                }
            }
            return -1;
        }
    }

    public VideoPlayer(long j) {
        this.instanceId = j;
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                synchronized (VideoPlayer.this) {
                    if (VideoPlayer.this.state != 0 || VideoPlayer.this.mediaPlayer == null || !VideoPlayer.this.checkTrackInfo()) {
                        VideoPlayer videoPlayer = VideoPlayer.this;
                        videoPlayer.logError("onPrepared bad state " + VideoPlayer.this.state);
                        VideoPlayer.this.destroy();
                    } else {
                        VideoPlayer.this.stopPrepareThread();
                        int unused = VideoPlayer.this.videoWidth = VideoPlayer.this.mediaPlayer.getVideoWidth();
                        int unused2 = VideoPlayer.this.videoHeight = VideoPlayer.this.mediaPlayer.getVideoHeight();
                        int unused3 = VideoPlayer.this.videoDuration = VideoPlayer.this.mediaPlayer.getDuration();
                        boolean unused4 = VideoPlayer.this.playingForFrame = true;
                        VideoPlayer.this.mediaPlayer.setVolume(0.0f, 0.0f);
                        if (!VideoPlayer.this.startImpl()) {
                            VideoPlayer.this.logError("onPrepared can't start play to first frame");
                            VideoPlayer.this.destroy();
                        }
                    }
                }
            }
        });
        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                synchronized (VideoPlayer.this) {
                    if (VideoPlayer.this.state == 2) {
                        VideoPlayer.this.onChangePosition(VideoPlayer.this.videoDuration);
                        VideoPlayer.this.changeState(3);
                        VideoPlayer.this.stopFrameWatchdog();
                        try {
                            VideoPlayer.this.mediaPlayer.stop();
                        } catch (Exception e) {
                            VideoPlayer videoPlayer = VideoPlayer.this;
                            videoPlayer.logError("stop exception: " + e.toString());
                            VideoPlayer.this.destroy();
                        }
                    } else if (VideoPlayer.this.state == 0) {
                        VideoPlayer.this.logError("onCompletion on preparing");
                        VideoPlayer.this.destroy();
                    } else if (VideoPlayer.this.state != 5) {
                        VideoPlayer videoPlayer2 = VideoPlayer.this;
                        videoPlayer2.logError("onCompletion bad state" + VideoPlayer.this.state);
                        VideoPlayer.this.destroy();
                    }
                }
            }
        });
        this.mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                synchronized (VideoPlayer.this) {
                    if (VideoPlayer.this.state == 1) {
                        VideoPlayer.this.onEndOfSeek(VideoPlayer.this.mediaPlayer.getCurrentPosition());
                        VideoPlayer.this.changeState(4);
                        VideoPlayer.this.stopTimeoutWatchdog();
                    }
                }
            }
        });
        this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoPlayer.this.isDestroyed()) {
                    return false;
                }
                VideoPlayer videoPlayer = VideoPlayer.this;
                videoPlayer.logError("play error : " + i + " , " + i2);
                VideoPlayer.this.destroy();
                return false;
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            this.mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build());
        } else {
            this.mediaPlayer.setAudioStreamType(3);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void changeState(final int i) {
        this.state = i;
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                VideoPlayer.onStateChanged(VideoPlayer.this.instanceId, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean checkTrackInfo() {
        /*
            r10 = this;
            monitor-enter(r10)
            android.media.MediaPlayer r0 = r10.mediaPlayer     // Catch:{ all -> 0x0058 }
            android.media.MediaPlayer$TrackInfo[] r0 = r0.getTrackInfo()     // Catch:{ all -> 0x0058 }
            r1 = 0
            if (r0 != 0) goto L_0x000c
            monitor-exit(r10)
            return r1
        L_0x000c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r2.<init>()     // Catch:{ all -> 0x0058 }
            int r3 = r0.length     // Catch:{ all -> 0x0058 }
            r4 = 0
            r5 = 0
        L_0x0014:
            if (r1 >= r3) goto L_0x0049
            r6 = r0[r1]     // Catch:{ all -> 0x0058 }
            int r7 = r6.getTrackType()     // Catch:{ all -> 0x0058 }
            r8 = 1
            if (r7 != r8) goto L_0x0023
            if (r4 != 0) goto L_0x002e
            r4 = 1
            goto L_0x0046
        L_0x0023:
            int r7 = r6.getTrackType()     // Catch:{ all -> 0x0058 }
            r9 = 2
            if (r7 != r9) goto L_0x002e
            if (r5 != 0) goto L_0x002e
            r5 = 1
            goto L_0x0046
        L_0x002e:
            int r7 = r2.length()     // Catch:{ all -> 0x0058 }
            if (r7 != 0) goto L_0x003a
            java.lang.String r7 = "unused tracks:"
            r2.append(r7)     // Catch:{ all -> 0x0058 }
            goto L_0x003f
        L_0x003a:
            java.lang.String r7 = ","
            r2.append(r7)     // Catch:{ all -> 0x0058 }
        L_0x003f:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0058 }
            r2.append(r6)     // Catch:{ all -> 0x0058 }
        L_0x0046:
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0049:
            int r0 = r2.length()     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0058 }
            r10.showAssert(r0)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r10)
            return r4
        L_0x0058:
            r0 = move-exception
            monitor-exit(r10)
            goto L_0x005c
        L_0x005b:
            throw r0
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.VideoPlayer.checkTrackInfo():boolean");
    }

    private synchronized void closeStream() {
        if (this.streamSource != null) {
            this.streamSource.close();
            this.streamSource = null;
        }
        if (this.dataStreamInfo != null) {
            this.dataStreamInfo.close();
            this.dataStreamInfo = null;
        }
    }

    public static boolean isAvailable() {
        return !new File("/system/lib/", "libmhalmdp.so").exists();
    }

    /* access modifiers changed from: private */
    public synchronized boolean isDestroyed() {
        return this.state == 5;
    }

    public static native void logError(long j, String str);

    /* access modifiers changed from: private */
    public synchronized void logError(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                VideoPlayer.logError(VideoPlayer.this.instanceId, str);
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void onChangePosition(final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                VideoPlayer.onPositionChanged(VideoPlayer.this.instanceId, i);
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void onEndOfSeek(final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                VideoPlayer.onEndOfSeek(VideoPlayer.this.instanceId, i);
            }
        });
    }

    public static native void onEndOfSeek(long j, int i);

    private synchronized void onInvalidState(String str, int i) {
        logError(str + " invalid state " + String.valueOf(this.state) + " must be " + String.valueOf(i));
    }

    public static native void onPositionChanged(long j, int i);

    public static native void onStateChanged(long j, int i);

    public static native void onStreamClose(long j);

    public static native int onStreamRead(long j, long j2, byte[] bArr, int i, int i2);

    private synchronized boolean openStream(long j, long j2) {
        try {
            closeStream();
            if (Build.VERSION.SDK_INT >= 23) {
                StreamSource streamSource2 = new StreamSource(j, j2);
                this.streamSource = streamSource2;
                this.mediaPlayer.setDataSource(streamSource2);
            } else {
                this.dataStreamInfo = new DataStreamInfo(j, j2);
            }
        } catch (Exception e) {
            logError("open stream exception: " + e.toString());
            destroy();
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        logError("close file exception: " + r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ab, code lost:
        if (r0 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        logError("close file exception: " + r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ca, code lost:
        throw r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0045, B:21:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean openUrl(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r10.closeStream()     // Catch:{ Exception -> 0x006d }
            android.net.Uri r1 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = "file"
            java.lang.String r3 = r1.getScheme()     // Catch:{ Exception -> 0x006d }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x006d }
            r3 = 1
            if (r2 == 0) goto L_0x0064
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = "/android_asset/"
            boolean r2 = r1.startsWith(r2)     // Catch:{ Exception -> 0x006d }
            if (r2 == 0) goto L_0x0064
            android.content.Context r11 = com.playrix.engine.Engine.getContext()     // Catch:{ Exception -> 0x006d }
            android.content.res.AssetManager r11 = r11.getAssets()     // Catch:{ Exception -> 0x006d }
            r2 = 15
            java.lang.String r1 = r1.substring(r2)     // Catch:{ Exception -> 0x006d }
            android.content.res.AssetFileDescriptor r0 = r11.openFd(r1)     // Catch:{ Exception -> 0x006d }
            android.media.MediaPlayer r4 = r10.mediaPlayer     // Catch:{ Exception -> 0x006d }
            java.io.FileDescriptor r5 = r0.getFileDescriptor()     // Catch:{ Exception -> 0x006d }
            long r6 = r0.getStartOffset()     // Catch:{ Exception -> 0x006d }
            long r8 = r0.getLength()     // Catch:{ Exception -> 0x006d }
            r4.setDataSource(r5, r6, r8)     // Catch:{ Exception -> 0x006d }
            r0.close()     // Catch:{ Exception -> 0x0049 }
            goto L_0x0062
        L_0x0049:
            r11 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r0.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "close file exception: "
            r0.append(r1)     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00cb }
            r0.append(r11)     // Catch:{ all -> 0x00cb }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00cb }
            r10.logError(r11)     // Catch:{ all -> 0x00cb }
        L_0x0062:
            monitor-exit(r10)
            return r3
        L_0x0064:
            android.media.MediaPlayer r1 = r10.mediaPlayer     // Catch:{ Exception -> 0x006d }
            r1.setDataSource(r11)     // Catch:{ Exception -> 0x006d }
            monitor-exit(r10)
            return r3
        L_0x006b:
            r11 = move-exception
            goto L_0x00ab
        L_0x006d:
            r11 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r1.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r2 = "open exception: "
            r1.append(r2)     // Catch:{ all -> 0x006b }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x006b }
            r1.append(r11)     // Catch:{ all -> 0x006b }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x006b }
            r10.logError(r11)     // Catch:{ all -> 0x006b }
            r10.destroy()     // Catch:{ all -> 0x006b }
            r11 = 0
            if (r0 == 0) goto L_0x00a9
            r0.close()     // Catch:{ Exception -> 0x0090 }
            goto L_0x00a9
        L_0x0090:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "close file exception: "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cb }
            r1.append(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00cb }
            r10.logError(r0)     // Catch:{ all -> 0x00cb }
        L_0x00a9:
            monitor-exit(r10)
            return r11
        L_0x00ab:
            if (r0 == 0) goto L_0x00ca
            r0.close()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00ca
        L_0x00b1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "close file exception: "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cb }
            r1.append(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00cb }
            r10.logError(r0)     // Catch:{ all -> 0x00cb }
        L_0x00ca:
            throw r11     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.VideoPlayer.openUrl(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public synchronized boolean pauseImpl() {
        try {
            this.mediaPlayer.pause();
        } catch (Exception e) {
            logError("pause exception: " + e.toString());
            destroy();
            return false;
        }
        return true;
    }

    private synchronized boolean runPrepareThread() {
        startTimeoutWatchdog("Prepare", 5000);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                MediaPlayer access$100;
                DataStreamInfo access$2100;
                try {
                    synchronized (VideoPlayer.this) {
                        access$100 = VideoPlayer.this.mediaPlayer;
                        access$2100 = VideoPlayer.this.dataStreamInfo;
                        DataStreamInfo unused = VideoPlayer.this.dataStreamInfo = null;
                    }
                    if (access$100 != null) {
                        if (access$2100 != null) {
                            access$100.setDataSource(access$2100.createTempFile().getFD());
                            access$2100.close();
                        }
                        access$100.prepare();
                    }
                } catch (IOException e) {
                    VideoPlayer videoPlayer = VideoPlayer.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("prepare stage failed: ");
                    outline24.append(e.toString());
                    videoPlayer.logError(outline24.toString());
                    VideoPlayer.this.destroy();
                } catch (IllegalStateException e2) {
                    VideoPlayer videoPlayer2 = VideoPlayer.this;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("prepare stage failed: ");
                    outline242.append(e2.toString());
                    videoPlayer2.logError(outline242.toString());
                    VideoPlayer.this.destroy();
                }
            }
        }, "VideoPrepare");
        this.prepareThread = thread;
        thread.start();
        return true;
    }

    private synchronized boolean seekImpl(int i) {
        startTimeoutWatchdog("Seek", 5000);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mediaPlayer.seekTo((long) i, 3);
            } else {
                this.mediaPlayer.seekTo(i);
            }
        } catch (Exception e) {
            logError("pause exception: " + e.toString());
            destroy();
            return false;
        }
        return true;
    }

    public static native void showAssert(long j, String str);

    private synchronized void showAssert(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                VideoPlayer.showAssert(VideoPlayer.this.instanceId, str);
            }
        });
    }

    private synchronized void startFrameWatchdog() {
        this.isFrameCreated = false;
        if (this.frameTimer == null) {
            this.frameTimer = new Timer();
        } else {
            this.frameTimer.cancel();
        }
        this.frameTimer.schedule(new TimerTask() {
            public void run() {
                synchronized (VideoPlayer.this) {
                    if (!VideoPlayer.this.isFrameCreated) {
                        VideoPlayer.this.logError("Frame not ready, cancelling");
                        VideoPlayer.this.destroy();
                    } else {
                        boolean unused = VideoPlayer.this.isFrameCreated = false;
                    }
                }
            }
        }, FRAME_TIMEOUT, FRAME_TIMEOUT);
    }

    /* access modifiers changed from: private */
    public synchronized boolean startImpl() {
        try {
            this.mediaPlayer.start();
        } catch (Exception e) {
            logError("start exception: " + e.toString());
            destroy();
            return false;
        }
        return true;
    }

    private synchronized void startTimeoutWatchdog(final String str, long j) {
        if (this.timeoutTimer == null) {
            this.timeoutTimer = new Timer();
        } else {
            this.timeoutTimer.cancel();
        }
        this.timeoutTimer.schedule(new TimerTask() {
            public void run() {
                VideoPlayer videoPlayer = VideoPlayer.this;
                videoPlayer.logError(str + " stage took too much time, cancelling");
                VideoPlayer.this.destroy();
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public synchronized void stopFrameWatchdog() {
        if (this.frameTimer != null) {
            this.frameTimer.cancel();
            this.frameTimer = null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void stopPrepareThread() {
        stopTimeoutWatchdog();
        if (this.prepareThread != null) {
            this.prepareThread.interrupt();
            try {
                this.prepareThread.join();
            } catch (InterruptedException unused) {
                logError("thread interrupted");
            }
            this.prepareThread = null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void stopTimeoutWatchdog() {
        if (this.timeoutTimer != null) {
            this.timeoutTimer.cancel();
            this.timeoutTimer = null;
        }
    }

    public synchronized void destroy() {
        if (this.state == 0) {
            stopPrepareThread();
        }
        if (this.state == 1) {
            stopTimeoutWatchdog();
        }
        if (this.state == 2) {
            stopFrameWatchdog();
        }
        changeState(5);
        this.playingForFrame = false;
        closeStream();
        releaseSurface();
        if (this.mediaPlayer != null) {
            final MediaPlayer mediaPlayer2 = this.mediaPlayer;
            this.mediaPlayer = null;
            new Thread(new Runnable() {
                public void run() {
                    mediaPlayer2.release();
                }
            }, "VideoPlayerDestroy").start();
        }
    }

    public synchronized int getVideoDuration() {
        return this.videoDuration;
    }

    public synchronized int getVideoHeight() {
        return this.videoHeight;
    }

    public synchronized int getVideoWidth() {
        return this.videoWidth;
    }

    public synchronized boolean pause() {
        if (this.mediaPlayer == null) {
            logError("No media player");
            return false;
        } else if (this.state != 2) {
            onInvalidState("pause", 2);
            return false;
        } else if (this.state == 4) {
            return true;
        } else {
            changeState(4);
            stopFrameWatchdog();
            return pauseImpl();
        }
    }

    public synchronized boolean prepare() {
        if (this.mediaPlayer == null) {
            logError("No media player");
            return false;
        } else if (this.state != 3) {
            onInvalidState("prepare", 3);
            return false;
        } else if (this.prepareThread != null) {
            logError("No prepare thread");
            return false;
        } else {
            changeState(0);
            runPrepareThread();
            return true;
        }
    }

    public synchronized void releaseSurface() {
        this.needUpdateTexture = false;
        if (this.surface != null) {
            this.surface.release();
            this.surface = null;
        }
        if (this.surfaceTexture != null) {
            this.surfaceTexture.release();
            this.surfaceTexture = null;
        }
    }

    public synchronized boolean seek(int i) {
        if (this.mediaPlayer == null) {
            logError("No media player");
            return false;
        } else if (this.state != 4) {
            onInvalidState("seek", 4);
            return false;
        } else {
            changeState(1);
            return seekImpl(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSoundVolume(float r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.media.MediaPlayer r0 = r1.mediaPlayer     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r1.soundVolume = r2     // Catch:{ all -> 0x0014 }
            boolean r0 = r1.playingForFrame     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0012
            android.media.MediaPlayer r0 = r1.mediaPlayer     // Catch:{ all -> 0x0014 }
            r0.setVolume(r2, r2)     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.VideoPlayer.setSoundVolume(float):void");
    }

    public synchronized boolean setSurface(int i) {
        if (this.mediaPlayer == null) {
            return false;
        }
        releaseSurface();
        if (i != 0) {
            SurfaceTexture surfaceTexture2 = new SurfaceTexture(i);
            this.surfaceTexture = surfaceTexture2;
            surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    synchronized (VideoPlayer.this) {
                        if (VideoPlayer.this.mediaPlayer != null) {
                            boolean unused = VideoPlayer.this.isFrameCreated = true;
                            boolean unused2 = VideoPlayer.this.needUpdateTexture = true;
                            if (VideoPlayer.this.playingForFrame) {
                                boolean unused3 = VideoPlayer.this.playingForFrame = false;
                                VideoPlayer.this.onChangePosition(0);
                                VideoPlayer.this.changeState(4);
                                VideoPlayer.this.stopTimeoutWatchdog();
                                if (VideoPlayer.this.pauseImpl()) {
                                    VideoPlayer.this.mediaPlayer.setVolume(VideoPlayer.this.soundVolume, VideoPlayer.this.soundVolume);
                                }
                            } else {
                                VideoPlayer.this.onChangePosition(VideoPlayer.this.mediaPlayer.getCurrentPosition());
                            }
                        }
                    }
                }
            });
            this.surface = new Surface(this.surfaceTexture);
        }
        try {
            this.mediaPlayer.setSurface(this.surface);
            return true;
        } catch (Exception e) {
            logError("setSurface exception: " + e.toString());
            destroy();
            return false;
        }
    }

    public synchronized boolean start() {
        if (this.mediaPlayer == null) {
            logError("No media player");
            return false;
        } else if (this.state != 4) {
            onInvalidState(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, 4);
            return false;
        } else {
            changeState(2);
            startFrameWatchdog();
            return startImpl();
        }
    }

    public synchronized float[] updateTexture() {
        if (!this.needUpdateTexture) {
            return null;
        }
        this.needUpdateTexture = false;
        if (this.surfaceTexture == null) {
            return null;
        }
        try {
            this.surfaceTexture.updateTexImage();
            this.surfaceTexture.getTransformMatrix(this.textureMatrix);
            return this.textureMatrix;
        } catch (Exception e) {
            logError("updateTexture exception: " + e.toString());
            return null;
        }
    }
}
