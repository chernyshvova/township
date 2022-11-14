package com.helpshift.common.platform;

import com.helpshift.meta.dao.MetaDataDAO;
import com.helpshift.meta.dto.BreadCrumbDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AndroidMetadataDAO implements MetaDataDAO {
    public static final String BREAD_CRUMB_KEY = "key_bread_crumb_storage";
    public static final String CUSTOM_META_KEY = "key_custom_meta_storage";
    public KVStore kvStore;

    public AndroidMetadataDAO(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    public ArrayList<BreadCrumbDTO> getBreadCrumbs() {
        Object serializable = this.kvStore.getSerializable(BREAD_CRUMB_KEY);
        if (serializable != null) {
            return (ArrayList) serializable;
        }
        return null;
    }

    public HashMap<String, Serializable> getCustomMetaData() {
        Object serializable = this.kvStore.getSerializable(CUSTOM_META_KEY);
        if (serializable != null) {
            return (HashMap) serializable;
        }
        return null;
    }

    public void saveCustomMetaData(HashMap<String, Serializable> hashMap) {
        this.kvStore.setSerializable(CUSTOM_META_KEY, hashMap);
    }

    public void setBreadCrumbs(ArrayList<BreadCrumbDTO> arrayList) {
        this.kvStore.setSerializable(BREAD_CRUMB_KEY, arrayList);
    }
}
