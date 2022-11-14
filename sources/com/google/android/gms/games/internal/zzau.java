package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.games_v2.zzb;
import com.google.android.gms.internal.games_v2.zzc;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class zzau extends zzb implements zzav {
    public zzau() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 6001) {
            parcel.readString();
        } else if (i == 6002) {
            parcel.readString();
        } else if (i == 12011) {
            zzf((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
        } else if (i == 12012) {
            zzr(parcel.readInt(), parcel.readString());
        } else if (i == 13001) {
            DataHolder dataHolder = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
        } else if (i == 13002) {
            parcel.readInt();
        } else if (i == 19001) {
            zzv(parcel.readInt(), (VideoCapabilities) zzc.zza(parcel, VideoCapabilities.CREATOR));
        } else if (i != 19002) {
            switch (i) {
                case 5001:
                    parcel.readInt();
                    parcel.readString();
                    break;
                case 5002:
                    zzc((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5003:
                    zzb(parcel.readInt(), parcel.readString());
                    break;
                case 5004:
                    zzi((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5005:
                    zzh((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), (DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5006:
                    zzm((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5007:
                    zzl((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5008:
                    zzg((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5009:
                    DataHolder dataHolder2 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                    break;
                case 5010:
                    DataHolder dataHolder3 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                    break;
                case 5011:
                    DataHolder dataHolder4 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                    break;
                default:
                    switch (i) {
                        case 5016:
                            zzo();
                            break;
                        case 5017:
                            DataHolder dataHolder5 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5018:
                            DataHolder dataHolder6 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5019:
                            DataHolder dataHolder7 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5020:
                            parcel.readInt();
                            parcel.readString();
                            break;
                        case 5021:
                            DataHolder dataHolder8 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5022:
                            DataHolder dataHolder9 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5023:
                            DataHolder dataHolder10 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5024:
                            DataHolder dataHolder11 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5025:
                            DataHolder dataHolder12 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5026:
                            DataHolder dataHolder13 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5027:
                            DataHolder dataHolder14 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5028:
                            DataHolder dataHolder15 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5029:
                            DataHolder dataHolder16 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5030:
                            DataHolder dataHolder17 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5031:
                            DataHolder dataHolder18 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            break;
                        case 5032:
                            com.google.android.gms.games.multiplayer.realtime.zzb zzb = (com.google.android.gms.games.multiplayer.realtime.zzb) zzc.zza(parcel, com.google.android.gms.games.multiplayer.realtime.zzb.CREATOR);
                            break;
                        case 5033:
                            parcel.readInt();
                            parcel.readInt();
                            parcel.readString();
                            break;
                        case 5034:
                            parcel.readInt();
                            parcel.readString();
                            zzc.zzf(parcel);
                            break;
                        case 5035:
                            DataHolder dataHolder19 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5036:
                            parcel.readInt();
                            break;
                        case 5037:
                            DataHolder dataHolder20 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5038:
                            DataHolder dataHolder21 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5039:
                            DataHolder dataHolder22 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 5040:
                            parcel.readInt();
                            break;
                        case AdError.AD_PRESENTATION_ERROR_CODE:
                            DataHolder dataHolder23 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 11001:
                            parcel.readInt();
                            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                            break;
                        case 12001:
                            zzt((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 14001:
                            DataHolder[] dataHolderArr = (DataHolder[]) parcel.createTypedArray(DataHolder.CREATOR);
                            break;
                        case 15001:
                            zzk((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 17002:
                            parcel.readInt();
                            break;
                        case 19008:
                            parcel.readInt();
                            break;
                        case 19009:
                            parcel.readInt();
                            break;
                        case 19010:
                            parcel.readInt();
                            break;
                        case 20001:
                            DataHolder dataHolder24 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20002:
                            DataHolder dataHolder25 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20003:
                            DataHolder dataHolder26 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20004:
                            DataHolder dataHolder27 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20005:
                            DataHolder dataHolder28 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20006:
                            DataHolder dataHolder29 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20007:
                            DataHolder dataHolder30 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20008:
                            DataHolder dataHolder31 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20009:
                            DataHolder dataHolder32 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            break;
                        case 20012:
                            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                            break;
                        case 20019:
                            zzd(parcel.readInt());
                            break;
                        case 20020:
                            zze(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                            break;
                        case 23001:
                            parcel.readInt();
                            break;
                        case 23002:
                            parcel.readInt();
                            break;
                        case 23003:
                            parcel.readInt();
                            break;
                        case 23004:
                            parcel.readInt();
                            break;
                        case 23005:
                            parcel.readInt();
                            break;
                        case 24002:
                            zzc.zzf(parcel);
                            break;
                        case 25002:
                            parcel.readString();
                            break;
                        case 25003:
                            zzn((Status) zzc.zza(parcel, Status.CREATOR), parcel.readString());
                            break;
                        case 25004:
                            Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                            break;
                        default:
                            switch (i) {
                                case 8001:
                                    zzj((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8002:
                                    parcel.readInt();
                                    Bundle bundle2 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                    break;
                                case 8003:
                                    DataHolder dataHolder33 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    break;
                                case 8004:
                                    DataHolder dataHolder34 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    break;
                                case 8005:
                                    DataHolder dataHolder35 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    break;
                                case 8006:
                                    DataHolder dataHolder36 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    break;
                                case 8007:
                                    parcel.readInt();
                                    parcel.readString();
                                    break;
                                case 8008:
                                    DataHolder dataHolder37 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    break;
                                case 8009:
                                    parcel.readString();
                                    break;
                                case 8010:
                                    parcel.readString();
                                    break;
                                default:
                                    switch (i) {
                                        case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                                            DataHolder dataHolder38 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            break;
                                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                                            parcel.readString();
                                            break;
                                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                                            DataHolder dataHolder39 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            break;
                                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED:
                                            DataHolder dataHolder40 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            break;
                                        case 10005:
                                            parcel.readInt();
                                            Bundle bundle3 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                            break;
                                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE:
                                            DataHolder dataHolder41 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            break;
                                        default:
                                            switch (i) {
                                                case 12004:
                                                    zzs((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR));
                                                    break;
                                                case 12005:
                                                    zzp((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12006:
                                                    DataHolder dataHolder42 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    break;
                                                case 12007:
                                                    DataHolder dataHolder43 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    break;
                                                case 12008:
                                                    DataHolder dataHolder44 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 12014:
                                                            DataHolder dataHolder45 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                            break;
                                                        case 12015:
                                                            parcel.readInt();
                                                            Bundle bundle4 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                                            break;
                                                        case 12016:
                                                            DataHolder dataHolder46 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                            break;
                                                        case 12017:
                                                            zzq((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), parcel.readString(), (Contents) zzc.zza(parcel, Contents.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR));
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            zzu(parcel.readInt(), zzc.zzf(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
