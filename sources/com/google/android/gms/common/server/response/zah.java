package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zah implements FastParser.zaa<BigInteger> {
    @Nullable
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return fastParser.zaf(bufferedReader);
    }
}
