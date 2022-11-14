package org.fmod;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;

public class MediaCodec {
    public int mChannelCount = 0;
    public long mCodecPtr = 0;
    public int mCurrentOutputBufferIndex = -1;
    public Object mDataSourceProxy = null;
    public android.media.MediaCodec mDecoder = null;
    public MediaExtractor mExtractor = null;
    public ByteBuffer[] mInputBuffers = null;
    public boolean mInputFinished = false;
    public long mLength = 0;
    public ByteBuffer[] mOutputBuffers = null;
    public boolean mOutputFinished = false;
    public int mSampleRate = 0;

    public static native long fmodGetSize(long j);

    public static native int fmodReadAt(long j, long j2, byte[] bArr, int i, int i2);

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public long getLength() {
        return this.mLength;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public boolean init(long j) {
        this.mCodecPtr = j;
        int i = 0;
        if (Build.VERSION.SDK_INT < 23) {
            try {
                Class<?> cls = Class.forName("android.media.DataSource");
                Method method = Class.forName("android.media.MediaExtractor").getMethod("setDataSource", new Class[]{cls});
                this.mExtractor = new MediaExtractor();
                Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        if (method.getName().equals("readAt")) {
                            return Integer.valueOf(MediaCodec.fmodReadAt(MediaCodec.this.mCodecPtr, objArr[0].longValue(), objArr[1], 0, objArr[2].intValue()));
                        }
                        if (method.getName().equals("getSize")) {
                            return Long.valueOf(MediaCodec.fmodGetSize(MediaCodec.this.mCodecPtr));
                        }
                        if (method.getName().equals("close")) {
                            return null;
                        }
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaCodec::DataSource::invoke : Unrecognised method found: ");
                        outline24.append(method.getName());
                        Log.w("fmod", outline24.toString());
                        return null;
                    }
                });
                this.mDataSourceProxy = newProxyInstance;
                method.invoke(this.mExtractor, new Object[]{newProxyInstance});
            } catch (ClassNotFoundException e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                outline24.append(e.toString());
                Log.w("fmod", outline24.toString());
                return false;
            } catch (NoSuchMethodException e2) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                outline242.append(e2.toString());
                Log.w("fmod", outline242.toString());
                return false;
            } catch (IllegalAccessException e3) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                outline243.append(e3.toString());
                Log.e("fmod", outline243.toString());
                return false;
            } catch (InvocationTargetException e4) {
                StringBuilder outline244 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                outline244.append(e4.toString());
                Log.e("fmod", outline244.toString());
                return false;
            }
        } else {
            try {
                MediaExtractor mediaExtractor = new MediaExtractor();
                this.mExtractor = mediaExtractor;
                mediaExtractor.setDataSource(new MediaDataSource() {
                    public void close() {
                    }

                    public long getSize() {
                        return MediaCodec.fmodGetSize(MediaCodec.this.mCodecPtr);
                    }

                    public int readAt(long j, byte[] bArr, int i, int i2) {
                        return MediaCodec.fmodReadAt(MediaCodec.this.mCodecPtr, j, bArr, i, i2);
                    }
                });
            } catch (IOException e5) {
                StringBuilder outline245 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                outline245.append(e5.toString());
                Log.w("fmod", outline245.toString());
                return false;
            }
        }
        int trackCount = this.mExtractor.getTrackCount();
        int i2 = 0;
        while (i2 < trackCount) {
            MediaFormat trackFormat = this.mExtractor.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            Log.d("fmod", "MediaCodec::init : Format " + i2 + " / " + trackCount + " -- " + trackFormat);
            if (string.equals("audio/mp4a-latm")) {
                try {
                    this.mDecoder = android.media.MediaCodec.createDecoderByType(string);
                    this.mExtractor.selectTrack(i2);
                    this.mDecoder.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.mDecoder.start();
                    this.mInputBuffers = this.mDecoder.getInputBuffers();
                    this.mOutputBuffers = this.mDecoder.getOutputBuffers();
                    int integer = trackFormat.containsKey("encoder-delay") ? trackFormat.getInteger("encoder-delay") : 0;
                    if (trackFormat.containsKey("encoder-padding")) {
                        i = trackFormat.getInteger("encoder-padding");
                    }
                    long j2 = trackFormat.getLong("durationUs");
                    this.mChannelCount = trackFormat.getInteger("channel-count");
                    int integer2 = trackFormat.getInteger("sample-rate");
                    this.mSampleRate = integer2;
                    this.mLength = (long) ((((int) (((j2 * ((long) integer2)) + 999999) / 1000000)) - integer) - i);
                    return true;
                } catch (IOException e6) {
                    StringBuilder outline246 = GeneratedOutlineSupport.outline24("MediaCodec::init : ");
                    outline246.append(e6.toString());
                    Log.e("fmod", outline246.toString());
                    return false;
                }
            } else {
                i2++;
            }
        }
        return false;
    }

    public int read(byte[] bArr, int i) {
        int dequeueInputBuffer;
        int i2 = (!this.mInputFinished || !this.mOutputFinished || this.mCurrentOutputBufferIndex != -1) ? 0 : -1;
        while (!this.mInputFinished && (dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(0)) >= 0) {
            int readSampleData = this.mExtractor.readSampleData(this.mInputBuffers[dequeueInputBuffer], 0);
            if (readSampleData >= 0) {
                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mExtractor.getSampleTime(), 0);
                this.mExtractor.advance();
            } else {
                this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                this.mInputFinished = true;
            }
        }
        if (!this.mOutputFinished && this.mCurrentOutputBufferIndex == -1) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, 10000);
            if (dequeueOutputBuffer >= 0) {
                this.mCurrentOutputBufferIndex = dequeueOutputBuffer;
                this.mOutputBuffers[dequeueOutputBuffer].limit(bufferInfo.size);
                this.mOutputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
            } else if (dequeueOutputBuffer == -3) {
                this.mOutputBuffers = this.mDecoder.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaCodec::read : MediaCodec::dequeueOutputBuffer returned MediaCodec.INFO_OUTPUT_FORMAT_CHANGED ");
                outline24.append(this.mDecoder.getOutputFormat());
                Log.d("fmod", outline24.toString());
            } else if (dequeueOutputBuffer == -1) {
                Log.d("fmod", "MediaCodec::read : MediaCodec::dequeueOutputBuffer returned MediaCodec.INFO_TRY_AGAIN_LATER.");
            } else {
                Log.w("fmod", "MediaCodec::read : MediaCodec::dequeueOutputBuffer returned " + dequeueOutputBuffer);
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.mOutputFinished = true;
            }
        }
        int i3 = this.mCurrentOutputBufferIndex;
        if (i3 == -1) {
            return i2;
        }
        ByteBuffer byteBuffer = this.mOutputBuffers[i3];
        int min = Math.min(byteBuffer.remaining(), i);
        byteBuffer.get(bArr, 0, min);
        if (!byteBuffer.hasRemaining()) {
            byteBuffer.clear();
            this.mDecoder.releaseOutputBuffer(this.mCurrentOutputBufferIndex, false);
            this.mCurrentOutputBufferIndex = -1;
        }
        return min;
    }

    public void release() {
        android.media.MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mDecoder.release();
            this.mDecoder = null;
        }
        MediaExtractor mediaExtractor = this.mExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mExtractor = null;
        }
    }

    public void seek(int i) {
        int i2 = this.mCurrentOutputBufferIndex;
        if (i2 != -1) {
            this.mOutputBuffers[i2].clear();
            this.mCurrentOutputBufferIndex = -1;
        }
        this.mInputFinished = false;
        this.mOutputFinished = false;
        this.mDecoder.flush();
        long j = (long) i;
        this.mExtractor.seekTo((j * 1000000) / ((long) this.mSampleRate), 0);
        long sampleTime = ((this.mExtractor.getSampleTime() * ((long) this.mSampleRate)) + 999999) / 1000000;
        int i3 = (int) ((j - sampleTime) * ((long) this.mChannelCount) * 2);
        if (i3 < 0) {
            Log.w("fmod", "MediaCodec::seek : Seek to " + i + " resulted in position " + sampleTime);
            return;
        }
        byte[] bArr = new byte[1024];
        while (i3 > 0) {
            i3 -= read(bArr, Math.min(1024, i3));
        }
    }
}
