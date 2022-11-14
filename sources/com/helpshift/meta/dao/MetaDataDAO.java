package com.helpshift.meta.dao;

import com.helpshift.meta.dto.BreadCrumbDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public interface MetaDataDAO {
    ArrayList<BreadCrumbDTO> getBreadCrumbs();

    HashMap<String, Serializable> getCustomMetaData();

    void saveCustomMetaData(HashMap<String, Serializable> hashMap);

    void setBreadCrumbs(ArrayList<BreadCrumbDTO> arrayList);
}
