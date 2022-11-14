package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajf extends zzahm {
    public final byte[] zza;
    public final DatagramPacket zzb;
    @Nullable
    public Uri zzc;
    @Nullable
    public DatagramSocket zzd;
    @Nullable
    public MulticastSocket zze;
    @Nullable
    public InetAddress zzf;
    @Nullable
    public InetSocketAddress zzg;
    public boolean zzh;
    public int zzi;

    public zzajf() {
        this(2000);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaje {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzi == 0) {
            try {
                this.zzd.receive(this.zzb);
                int length = this.zzb.getLength();
                this.zzi = length;
                zzi(length);
            } catch (IOException e) {
                throw new zzaje(e);
            }
        }
        int length2 = this.zzb.getLength();
        int i3 = this.zzi;
        int min = Math.min(i3, i2);
        System.arraycopy(this.zza, length2 - i3, bArr, i, min);
        this.zzi -= min;
        return min;
    }

    public final long zzc(zzahx zzahx) throws zzaje {
        Uri uri = zzahx.zza;
        this.zzc = uri;
        String host = uri.getHost();
        int port = this.zzc.getPort();
        zzg(zzahx);
        try {
            this.zzf = InetAddress.getByName(host);
            this.zzg = new InetSocketAddress(this.zzf, port);
            if (this.zzf.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.zzg);
                this.zze = multicastSocket;
                multicastSocket.joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                this.zzd = new DatagramSocket(this.zzg);
            }
            try {
                this.zzd.setSoTimeout(8000);
                this.zzh = true;
                zzh(zzahx);
                return -1;
            } catch (SocketException e) {
                throw new zzaje(e);
            }
        } catch (IOException e2) {
            throw new zzaje(e2);
        }
    }

    @Nullable
    public final Uri zzd() {
        return this.zzc;
    }

    public final void zzf() {
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.zzf);
            } catch (IOException unused) {
            }
            this.zze = null;
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzg = null;
        this.zzi = 0;
        if (this.zzh) {
            this.zzh = false;
            zzj();
        }
    }

    public zzajf(int i) {
        super(true);
        this.zza = new byte[2000];
        this.zzb = new DatagramPacket(this.zza, 0, 2000);
    }
}
