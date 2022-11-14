package com.helpshift.cif;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.cif.dao.CustomIssueFieldDAO;
import com.helpshift.cif.dto.CustomIssueFieldDTO;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CustomIssueFieldDM {
    public static final String TAG = "Helpshift_CIF_DM";
    public CustomIssueFieldDAO customIssueFieldDAO;
    public Domain domain;
    public Jsonifier jsonifier;

    public CustomIssueFieldDM(Domain domain2, Platform platform) {
        this.domain = domain2;
        this.customIssueFieldDAO = platform.getCustomIssueFieldDAO();
        this.jsonifier = platform.getJsonifier();
    }

    /* access modifiers changed from: private */
    public ArrayList<CustomIssueFieldDTO> convertMapToDTOs(Map<String, String[]> map) {
        String[] strArr;
        if (map == null) {
            return null;
        }
        ArrayList<CustomIssueFieldDTO> arrayList = new ArrayList<>();
        for (String next : map.keySet()) {
            if (!StringUtils.isEmpty(next) && (strArr = map.get(next)) != null && strArr.length >= 2) {
                String str = strArr[0];
                if (!StringUtils.isEmpty(str)) {
                    arrayList.add(new CustomIssueFieldDTO(next, str, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length)));
                }
            }
        }
        return arrayList;
    }

    public Object getCustomIssueFieldData() {
        ArrayList<CustomIssueFieldDTO> customIssueFields = this.customIssueFieldDAO.getCustomIssueFields();
        if (customIssueFields == null || customIssueFields.size() == 0) {
            return null;
        }
        try {
            return this.jsonifier.jsonifyCustomIssueFieldDTOList(customIssueFields);
        } catch (RootAPIException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Exception when jsonify data : ");
            outline24.append(e.getMessage());
            HSLogger.m3241e(TAG, outline24.toString());
            return null;
        }
    }

    public void setCustomIssueFieldData(final Map<String, String[]> map) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                CustomIssueFieldDM.this.customIssueFieldDAO.setCustomIssueFields(CustomIssueFieldDM.this.convertMapToDTOs(map));
            }
        });
    }
}
