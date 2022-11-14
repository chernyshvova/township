package com.google.android.gms.games.internal;

import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzad extends zza {
    public final /* synthetic */ zzas zza;
    public final TaskCompletionSource<AnnotatedData<LeaderboardsClient.LeaderboardScores>> zzb;

    public zzad(zzas zzas, TaskCompletionSource<AnnotatedData<LeaderboardsClient.LeaderboardScores>> taskCompletionSource) {
        this.zza = zzas;
        this.zzb = taskCompletionSource;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.common.data.DataHolder r6, com.google.android.gms.common.data.DataHolder r7) {
        /*
            r5 = this;
            int r0 = r7.getStatusCode()
            r1 = 0
            r2 = 3
            if (r0 != r2) goto L_0x000a
            r2 = 1
            goto L_0x000b
        L_0x000a:
            r2 = 0
        L_0x000b:
            r3 = 10003(0x2713, float:1.4017E-41)
            if (r0 != r3) goto L_0x001d
            com.google.android.gms.games.internal.zzas r0 = r5.zza
            com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.LeaderboardsClient$LeaderboardScores>> r1 = r5.zzb
            com.google.android.gms.games.internal.zzas.zzq(r0, r1)
            r6.close()
            r7.close()
            return
        L_0x001d:
            if (r0 == 0) goto L_0x002e
            if (r2 == 0) goto L_0x0022
            goto L_0x002e
        L_0x0022:
            com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.LeaderboardsClient$LeaderboardScores>> r1 = r5.zzb
            com.google.android.gms.games.GamesStatusUtils.zza(r1, r0)
            r6.close()
            r7.close()
            return
        L_0x002e:
            com.google.android.gms.games.leaderboard.LeaderboardBuffer r0 = new com.google.android.gms.games.leaderboard.LeaderboardBuffer
            r0.<init>(r6)
            int r6 = r0.getCount()     // Catch:{ all -> 0x005d }
            if (r6 <= 0) goto L_0x0044
            java.lang.Object r6 = r0.get(r1)     // Catch:{ all -> 0x005d }
            com.google.android.gms.games.leaderboard.Leaderboard r6 = (com.google.android.gms.games.leaderboard.Leaderboard) r6     // Catch:{ all -> 0x005d }
            java.lang.Object r6 = r6.freeze()     // Catch:{ all -> 0x005d }
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            r0.close()
            com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.LeaderboardsClient$LeaderboardScores>> r0 = r5.zzb
            com.google.android.gms.games.AnnotatedData r1 = new com.google.android.gms.games.AnnotatedData
            com.google.android.gms.games.LeaderboardsClient$LeaderboardScores r3 = new com.google.android.gms.games.LeaderboardsClient$LeaderboardScores
            com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer r4 = new com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
            r4.<init>(r7)
            r3.<init>(r6, r4)
            r1.<init>(r3, r2)
            r0.setResult(r1)
            return
        L_0x005d:
            r6 = move-exception
            r0.close()     // Catch:{ all -> 0x0061 }
        L_0x0061:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzad.zzh(com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder):void");
    }
}
