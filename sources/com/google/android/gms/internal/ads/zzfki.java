package com.google.android.gms.internal.ads;

import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfki implements Iterable<String> {
    public final /* synthetic */ CharSequence zza;
    public final /* synthetic */ zzfkk zzb;

    public zzfki(zzfkk zzfkk, CharSequence charSequence) {
        this.zzb = zzfkk;
        this.zza = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<String> it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzfjv.zza(it.next(), RESTClient.COMMA_SEPARATOR));
                while (it.hasNext()) {
                    sb.append(RESTClient.COMMA_SEPARATOR);
                    sb.append(zzfjv.zza(it.next(), RESTClient.COMMA_SEPARATOR));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
