package com.helpshift.common.platform;

import android.content.Context;
import com.helpshift.common.domain.network.HSUrlMetadata;
import com.helpshift.common.domain.network.dao.HSNetworkMetadataDAO;
import com.helpshift.p042db.network.HSNetworkMetadataDB;

public class AndroidHSNetworkMetadataDAO implements HSNetworkMetadataDAO {
    public final String TAG = "Helpshift_HSNwDao";
    public final HSNetworkMetadataDB hsNetworkDB;

    public AndroidHSNetworkMetadataDAO(Context context) {
        this.hsNetworkDB = HSNetworkMetadataDB.getInstance(context);
    }

    public boolean deleteAllUrlsMetadata() {
        return this.hsNetworkDB.deleteAllUrlsMetadata();
    }

    public boolean deleteMetadataForUrl(String str) {
        return this.hsNetworkDB.deleteMetadataForUrl(str);
    }

    public HSUrlMetadata getMetadataOfUrl(String str) {
        return this.hsNetworkDB.readMetadataForUrl(str);
    }

    public boolean insertOrUpdateMetadataForUrl(String str, HSUrlMetadata hSUrlMetadata) {
        if (this.hsNetworkDB.readMetadataForUrl(str) != null) {
            return this.hsNetworkDB.updateMetadataForUrl(str, hSUrlMetadata);
        }
        return this.hsNetworkDB.insertMetadataForUrl(str, hSUrlMetadata);
    }

    public boolean updateLastFetchTimestampAndFetchStateOfUrl(String str, long j, boolean z) {
        return this.hsNetworkDB.updateLastFetchTimestampForUrl(str, j, z);
    }
}
