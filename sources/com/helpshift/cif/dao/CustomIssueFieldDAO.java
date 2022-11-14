package com.helpshift.cif.dao;

import com.helpshift.cif.dto.CustomIssueFieldDTO;
import java.util.ArrayList;

public interface CustomIssueFieldDAO {
    ArrayList<CustomIssueFieldDTO> getCustomIssueFields();

    void setCustomIssueFields(ArrayList<CustomIssueFieldDTO> arrayList);
}
