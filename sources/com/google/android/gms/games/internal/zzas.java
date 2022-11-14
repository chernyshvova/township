package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.zzm;
import com.google.android.gms.internal.games_v2.zzak;
import com.google.android.gms.internal.games_v2.zzan;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzas extends GmsClient<zzay> {
    public static final /* synthetic */ int zze = 0;
    public final zzak zzf = new zzo(this);
    public final String zzg;
    public PlayerEntity zzh;
    public GameEntity zzi;
    public final zzaz zzj;
    public boolean zzk = false;
    public final long zzl;
    public final zzm zzm;
    public final zzba zzn;

    public zzas(Context context, Looper looper, ClientSettings clientSettings, zzm zzm2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzba zzba) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzg = clientSettings.getRealClientPackageName();
        this.zzn = (zzba) Preconditions.checkNotNull(zzba);
        this.zzj = zzaz.zzd(this, clientSettings.getGravityForPopups());
        this.zzl = (long) hashCode();
        this.zzm = zzm2;
        boolean z = zzm2.zzh;
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            this.zzj.zzf(clientSettings.getViewForPopups());
        }
    }

    public static void zzZ(RemoteException remoteException) {
        zzat.zzh("GamesGmsClientImpl", "service died", remoteException);
    }

    public static /* bridge */ /* synthetic */ void zzq(zzas zzas, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzay) zzas.getService()).zzf())));
        } catch (RemoteException e) {
            taskCompletionSource.setException(e);
        }
    }

    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        this.zzi = null;
        super.connect(connectionProgressReportCallbacks);
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzay) {
            return (zzay) queryLocalInterface;
        }
        return new zzay(iBinder);
    }

    public final void disconnect() {
        this.zzk = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzay) getService()).zzr(this.zzl);
            } catch (RemoteException unused) {
                zzat.zzg("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Nullable
    public final Bundle getConnectionHint() {
        return null;
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zza = this.zzm.zza();
        zza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzg);
        zza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        zza.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzj.zzc()));
        if (!zza.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            zza.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        zza.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zza;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public final /* bridge */ /* synthetic */ void onConnectedLocked(@NonNull IInterface iInterface) {
        zzay zzay = (zzay) iInterface;
        super.onConnectedLocked(zzay);
        if (this.zzk) {
            this.zzj.zzg();
            this.zzk = false;
        }
        boolean z = this.zzm.zza;
        try {
            zzay.zzP(new zzq(new zzan(this.zzj.zze())), this.zzl);
        } catch (RemoteException e) {
            zzZ(e);
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzk = false;
    }

    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0) {
            if (bundle != null) {
                bundle.setClassLoader(zzas.class.getClassLoader());
                this.zzk = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
                this.zzi = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
            }
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public final void onUserSignOut(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzr zzr = new zzr(signOutCallbacks);
            this.zzf.zzb();
            try {
                ((zzay) getService()).zzV(new zzs(zzr));
            } catch (SecurityException unused) {
                zzr.setFailedResult(GamesClientStatusCodes.zza(4));
            }
        } catch (RemoteException unused2) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final boolean requiresAccount() {
        return true;
    }

    public final boolean requiresSignIn() {
        if (this.zzm.zzo.zzb()) {
            return false;
        }
        String str = this.zzm.zzl;
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(TaskCompletionSource<Boolean> taskCompletionSource, int i) throws RemoteException {
        try {
            ((zzay) getService()).zzA(new zzak(taskCompletionSource), i);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzB(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzB(new zzv(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzC(TaskCompletionSource<AnnotatedData<LeaderboardScore>> taskCompletionSource, String str, int i, int i2) throws RemoteException {
        try {
            ((zzay) getService()).zzw(new zzac(this, taskCompletionSource), (String) null, str, i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzD(TaskCompletionSource<AnnotatedData<EventBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzay) getService()).zzC(new zzy(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzE(TaskCompletionSource<AnnotatedData<EventBuffer>> taskCompletionSource, boolean z, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzay) getService()).zzD(new zzy(taskCompletionSource), z, strArr);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzF(TaskCompletionSource<AnnotatedData<Leaderboard>> taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzE(new zzab(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzG(TaskCompletionSource<AnnotatedData<LeaderboardBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzF(new zzae(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzH(TaskCompletionSource<AnnotatedData<LeaderboardsClient.LeaderboardScores>> taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzay) getService()).zzG(new zzad(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzI(TaskCompletionSource<AnnotatedData<Player>> taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzJ(new zzao(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzJ(TaskCompletionSource<AnnotatedData<LeaderboardsClient.LeaderboardScores>> taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzH(new zzad(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzK(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzI(new zzam(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzL(TaskCompletionSource<AnnotatedData<PlayerBuffer>> taskCompletionSource, String str, int i, boolean z, boolean z2) throws RemoteException {
        String str2;
        if (str.equals("played_with") || str.equals("friends_all")) {
            try {
                ((zzay) getService()).zzK(new zzan(this, taskCompletionSource), str, i, z, z2);
            } catch (SecurityException e) {
                GamesStatusUtils.zzb(taskCompletionSource, e);
            }
        } else {
            if (str.length() != 0) {
                str2 = "Invalid player collection: ".concat(str);
            } else {
                str2 = new String("Invalid player collection: ");
            }
            throw new IllegalArgumentException(str2);
        }
    }

    public final void zzM(TaskCompletionSource<AnnotatedData<SnapshotMetadataBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzL(new zzaj(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzN(TaskCompletionSource<AnnotatedData<LeaderboardsClient.LeaderboardScores>> taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzM(new zzad(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzO(TaskCompletionSource<SnapshotsClient.DataOrConflict<Snapshot>> taskCompletionSource, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzay) getService()).zzN(new zzar(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzP(ListenerHolder<VideosClient.OnCaptureOverlayStateListener> listenerHolder) throws RemoteException {
        ((zzay) getService()).zzO(new zzn(listenerHolder), this.zzl);
    }

    public final void zzQ(TaskCompletionSource<String> taskCompletionSource, String str, boolean z) throws RemoteException {
        ((zzay) getService()).zzQ(new zzaa(taskCompletionSource), str, z);
    }

    public final void zzR(TaskCompletionSource<SnapshotsClient.DataOrConflict<Snapshot>> taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzay) getService()).zzR(new zzar(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzS(@Nullable TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        zzu zzu;
        if (taskCompletionSource == null) {
            zzu = null;
        } else {
            zzu = new zzu(taskCompletionSource);
        }
        try {
            ((zzay) getService()).zzS(zzu, str, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzT(@Nullable TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        zzt zzt;
        if (taskCompletionSource == null) {
            zzt = null;
        } else {
            zzt = new zzt(taskCompletionSource);
        }
        try {
            ((zzay) getService()).zzT(zzt, str, i, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzU(IBinder iBinder, Bundle bundle) {
        if (!isConnected()) {
            return;
        }
        if (!this.zzm.zzo.zzd() || !this.zzn.zzc()) {
            try {
                ((zzay) getService()).zzU(iBinder, bundle);
                this.zzn.zzb();
            } catch (RemoteException e) {
                zzZ(e);
            }
        }
    }

    public final void zzV(TaskCompletionSource<ScoreSubmissionData> taskCompletionSource, String str, long j, @Nullable String str2) throws RemoteException {
        try {
            ((zzay) getService()).zzW(new zzaq(taskCompletionSource), str, j, str2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzW(zzg zzg2) {
        zzg2.zzf(this.zzj);
    }

    public final void zzX(@Nullable TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        zzu zzu;
        if (taskCompletionSource == null) {
            zzu = null;
        } else {
            zzu = new zzu(taskCompletionSource);
        }
        try {
            ((zzay) getService()).zzX(zzu, str, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzY() throws RemoteException {
        ((zzay) getService()).zzY(this.zzl);
    }

    /* JADX INFO: finally extract failed */
    public final Player zzp() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzh == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzay) getService()).zzo());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.zzh = new PlayerEntity(playerBuffer.get(0));
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzh;
    }

    public final void zzs() {
        if (isConnected()) {
            try {
                ((zzay) getService()).zzq();
            } catch (RemoteException e) {
                zzZ(e);
            }
        }
    }

    public final void zzt(TaskCompletionSource<SnapshotMetadata> taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzay) getService()).zzs(new zzw(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzu(TaskCompletionSource<String> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzay) getService()).zzt(new zzx(taskCompletionSource), str);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzv(TaskCompletionSource<VideoCapabilities> taskCompletionSource) throws RemoteException {
        try {
            ((zzay) getService()).zzx(new zzal(taskCompletionSource));
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzw(TaskCompletionSource<CaptureState> taskCompletionSource) throws RemoteException {
        try {
            ((zzay) getService()).zzv(new zzai(taskCompletionSource));
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzx(TaskCompletionSource<AnnotatedData<Player>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzay) getService()).zzJ(new zzao(taskCompletionSource), (String) null, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzy(@Nullable TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        zzt zzt;
        if (taskCompletionSource == null) {
            zzt = null;
        } else {
            zzt = new zzt(taskCompletionSource);
        }
        try {
            ((zzay) getService()).zzy(zzt, str, i, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e) {
            GamesStatusUtils.zzb(taskCompletionSource, e);
        }
    }

    public final void zzz(String str, int i) {
        this.zzf.zzc(str, i);
    }
}
